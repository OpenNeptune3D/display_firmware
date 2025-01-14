#!/bin/bash

# Exit on error
set -e

# Function to print errors
function error_exit {
    echo "[ERROR] $1" >&2
    exit 1
}

# Prompt the user for firmware type
echo "Select firmware to flash:"
echo "1) OpenNept4une display firmware (Alpha)"
echo "2) Elegoo Official display firmware"
read -p "Enter your choice (1 or 2): " firmware_choice

if [[ "$firmware_choice" != "1" && "$firmware_choice" != "2" ]]; then
    error_exit "Invalid choice. Please select 1 or 2."
fi

# Stop display service
echo "Stopping display service..."
sudo service display stop || error_exit "Failed to stop display service."
echo "Display service stopped."

# Ensure virtual environment is active
VENV_PATH="${HOME}/display_firmware/venv"
if [[ ! -d "$VENV_PATH" ]]; then
    echo "Setting up Python virtual environment..."
    python3 -m venv "$VENV_PATH"
    source "$VENV_PATH/bin/activate"
    pip install --upgrade pip pyserial || error_exit "Failed to install Python dependencies."
    echo "Virtual environment activated."
else
    echo "Using existing Python virtual environment."
    source "$VENV_PATH/bin/activate"
fi

if [[ "$firmware_choice" == "2" ]]; then
    # Remove the specific entry from display_connector.cfg if present
    config_file="${HOME}/printer_data/config/display_connector.cfg"
    if grep -q "display_type = openneptune" "$config_file"; then
        sed -i "/display_type = openneptune/d" "$config_file"
        echo "Removed 'display_type = openneptune' from display_connector.cfg."
    fi

    # Flash the Elegoo firmware
    tft_file="${HOME}/display_connector/dev-resources/UI_1.2.14_240705.tft"

    if [[ ! -f "$tft_file" ]]; then
        error_exit "Firmware file not found: $tft_file"
    fi

    echo "Flashing Elegoo Official display firmware..."
    python3 "${HOME}/display_firmware/Nexus.py" -i "$tft_file" -u 115200 -p /dev/ttyS1 || error_exit "Firmware flashing failed."

    sync
    clear
    echo ""
    printf "The system needs to be rebooted to complete the process. Reboot now? (y/n): "
    read -r reboot_choice

    if [[ "$reboot_choice" =~ ^[Yy]$ ]]; then
        echo "Rebooting system..."
        sudo reboot
    else
        echo "Reboot canceled. Exiting."
    fi

    exit 0
fi

# Continue with OpenNept4une firmware if choice is 1

# Prompt the user for confirmation
read -p "Are you sure you want to update the display firmware? Display_firmware is still very early in development! Some things may not function as intended. (Y/N): " confirm
confirm=$(echo "$confirm" | tr '[:lower:]' '[:upper:]')
if [ "$confirm" != "Y" ]; then
    echo "Update canceled by user."
    exit 0
fi

# Prompt user to select a theme
echo "Fetching available themes..."
THEMES_PATH="Themes"
LOCAL_PATH="${HOME}/display_firmware"

# Verify Themes folder exists
if [[ ! -d "$LOCAL_PATH/Themes" ]]; then
    error_exit "Themes folder not found after sparse checkout."
fi

# Parse themes directory to list options
themes_list=$(find "$LOCAL_PATH/$THEMES_PATH" -mindepth 1 -maxdepth 1 -type d -exec basename {} \;)
if [[ -z "$themes_list" ]]; then
    error_exit "No themes found in the repository."
fi

# Display available themes for selection
echo "Available Themes:"
theme_array=()
index=1
for theme in $themes_list; do
    theme_array+=("$theme")
    echo "$index) $theme"
    index=$((index + 1))
done

# Prompt user for selection
read -p "Enter the number of the theme you want to use: " selection
if ! [[ "$selection" =~ ^[0-9]+$ ]] || ((selection < 1 || selection > ${#theme_array[@]})); then
    error_exit "Invalid selection. Please choose a valid number."
fi
selected_theme="${theme_array[$selection-1]}"
echo "Selected theme: $selected_theme"

# Dynamically handle directory structure
theme_dir="$LOCAL_PATH/$THEMES_PATH/$selected_theme"
if [[ ! -d "$theme_dir" ]]; then
    error_exit "Theme directory not found for $selected_theme."
fi

json_file="$theme_dir/Config.json"
tft_file="$theme_dir/tft/OpenNeptuneUi.tft"

# Debug directory structure if Config.json not found
#if [[ ! -f "$json_file" ]]; then
#    echo "[ERROR] Config.json not found in expected path."
#    echo "Debugging directory structure:"
#    ls -R "$LOCAL_PATH/$THEMES_PATH"
#    exit 1
#fi
#echo "Config.json successfully fetched."

# Process scripts in Config.json
#echo "Processing scripts from $json_file..."
#jq -c '.scripts[]' "$json_file" | while read -r script; do
#    source_file=$(echo "$script" | jq -r '.source')
#    destination_file=$(echo "$script" | jq -r '.destination')

#    full_source_path="$theme_dir/$source_file"
#    full_destination_path="${HOME}/$destination_file"

#    if [[ -f "$full_source_path" ]]; then
#        cp -f "$full_source_path" "$full_destination_path"
#        echo "Copied $full_source_path to $full_destination_path"
#    else
#        echo "[WARNING] Source file not found: $full_source_path"
#    fi
#done

# Update display_connector.cfg
config_file="${HOME}/printer_data/config/display_connector.cfg"
new_line="display_type = openneptune"
if grep -q "\[general\]" "$config_file"; then
    if ! grep -Fxq "$new_line" "$config_file"; then
        sed -i "/\[general\]/a $new_line" "$config_file"
        echo "Updated display_connector.cfg."
    fi
else
    echo "[general]" >> "$config_file"
    echo "$new_line" >> "$config_file"
    echo "Added new section to display_connector.cfg."
fi

# Flash the firmware
if [[ ! -f "$tft_file" ]]; then
    error_exit "TFT file not found: $tft_file"
fi

echo "Flashing the firmware..."
python3 "${HOME}/display_firmware/Nexus.py" -i "$tft_file" -u 115200 -p /dev/ttyS1 || error_exit "Firmware flashing failed."

sync
clear
echo ""

printf "The system needs to be rebooted to continue. Reboot now? (y/n): "
read -r reboot_choice

if [[ "$reboot_choice" =~ ^[Yy]$ ]]; then
    echo "Rebooting system..."
    sudo reboot
else
    echo "Reboot canceled. Exiting."
fi
