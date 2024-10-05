#!/bin/bash

# Function to display progress bar
show_progress() {
    local duration=$1
    local interval=0.1
    local total_steps=$(echo "$duration / $interval" | bc)
    local step=0

    while [ $step -le $total_steps ]; do
        local progress=$(echo "scale=2; $step / $total_steps * 100" | bc)
        printf "\rProgress: [%-50s] %3.2f%%" $(printf "%0.s#" $(seq 1 $(echo "$progress / 2" | bc))) $progress
        sleep $interval
        step=$((step + 1))
    done
    echo ""
}

# Clear the terminal screen
clear

echo "Updating display firmware"
echo " "
echo "DO NOT power off the machine! This may take a while."
show_progress 5

# Stopping display service
echo "Stopping display service"
sudo service display stop
echo " "
echo "Stopped display service"
show_progress 3

# Make sure display_connector is on dev
DISPLAY_CONNECTOR_DIR="${HOME}/display_connector"
current_branch=$(git --git-dir="$DISPLAY_CONNECTOR_DIR/.git" --work-tree="$DISPLAY_CONNECTOR_DIR" rev-parse --abbrev-ref HEAD)
if [ "$current_branch" = "main" ]; then
    echo "You are on the main branch. Switching to dev."
    branch_name="dev"
    repo_dir="$DISPLAY_CONNECTOR_DIR"
    if [ -d "$repo_dir" ]; then
        git -C "$repo_dir" reset --hard >/dev/null 2>&1
        git -C "$repo_dir" clean -fd >/dev/null 2>&1
        git -C "$repo_dir" checkout "$branch_name" >/dev/null 2>&1 && echo -e "Switched $repo_dir to $branch_name."
    fi
fi
show_progress 5

# Create and activate a Python virtual environment
echo " "
echo "Creating and activating a virtual environment..."
python3 -m venv Display-Update
source Display-Update/bin/activate
pip install pyserial
echo " "
echo "Activated virtual environment successfully"
show_progress 5

# Download Screen Image
echo " "
echo "Downloading Screen Firmware"
curl -o "${HOME}/display_firmware/tft/OpenNeptuneUi.tft" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/tft/OpenNeptuneUi.tft
show_progress 5

# Flashing
echo " "
echo "Starting to flash!"
echo " "
python3 "${HOME}/display_firmware/Nexus.py" -i "${HOME}/display_firmware/tft/OpenNeptuneUi.tft" -u 115200 -p /dev/ttyS1
echo " "
show_progress 10

# Modify scripts
echo "Making necessary modifications"
curl -o "${HOME}/display_connector/src/response_actions.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/response_actions.py
curl -o "${HOME}/display_connector/src/neptune4.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/neptune4.py
curl -o "${HOME}/display_connector/src/openneptune_display.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/openneptune_display.py
curl -o "${HOME}/display_connector/src/elegoo_display.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/elegoo_display.py
show_progress 5

# Modify display_connector.cfg
config_file="${HOME}/printer_data/config/display_connector.cfg"
new_line="display_type = openneptune"
if ! grep -Fxq "$new_line" "$config_file"; then
    sed -i "/\[general\]/a $new_line" "$config_file"
fi
show_progress 3

# Done
echo " "
echo "Updated display firmware successfully. Restarting"
sudo reboot

# Display ending status code
if [ $? -eq 0 ]; then
    echo "Success: Display firmware updated and system rebooted."
else
    echo "Error: Something went wrong."
fi
