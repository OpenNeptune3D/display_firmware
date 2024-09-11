#!/bin/bash

echo "Updating display firmware"
echo " "
echo "DO NOT power off the machine! This may take a while."
#update screen firmware

#stopping display service
echo "Stopping display service"
sudo service display stop
echo " "
echo "Stopped display service"

#Make sure display_connector is on dev
DISPLAY_CONNECTOR_DIR="${HOME}/display_connector"
current_branch=$(git --git-dir="$DISPLAY_CONNECTOR_DIR/.git" --work-tree="$DISPLAY_CONNECTOR_DIR" rev-parse --abbrev-ref HEAD)
if [ "$current_branch" = "main" ]; then
    echo "You are on the main branch. Switching to dev."
    branch_name="dev"
    repo_dir="DISPLAY_CONNECTOR_DIR"
    if [ -d "$repo_dir" ]; then
        git -C "$repo_dir" reset --hard >/dev/null 2>&1
        git -C "$repo_dir" clean -fd >/dev/null 2>&1
        git -C "$repo_dir" checkout "$branch_name" >/dev/null 2>&1 && echo -e "${G}Switched $repo_dir to $branch_name.${NC}"
    fi
    
fi

# Create and activate a Python virtual environment
#venv
echo " "
echo "Creating and activating a virtual environment..."
python3 -m venv Display-Update
source Display-Update/bin/activate
pip install pyserial
echo " "
echo "Activated virtual environment successfully"
#Download Screen Image
echo " "
echo "Downloading Screen Firmware"
curl -o "${HOME}/display_firmware/tft/OpenNeptuneUi.tft" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/tft/OpenNeptuneUi.tft
#Flashing
echo " "
echo "Starting to flash!"
echo " "
python3 "${HOME}/display_firmware/Nexus.py" -i "${HOME}/display_firmware/tft/OpenNeptuneUi.tft" -u 115200 -p /dev/ttyS1
echo " "
#Modify scripts
echo "Making necessary modifications"
curl -o "${HOME}/display_connector/src/response_actions.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/response_actions.py
curl -o "${HOME}/display_connector/src/neptune4.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/neptune4.py
curl -o "${HOME}/display_connector/src/openneptune_display.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/openneptune_display.py
curl -o "${HOME}/display_connector/src/elegoo_display.py" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/elegoo_display.py
#modify display_connector.cfg
config_file="${HOME}/printer_data/config/display_connector.cfg"
new_line="display_type = openneptune"
if ! grep -Fxq "$new_line" "$config_file"; then
    sed -i "/\[general\]/a $new_line" "$config_file"
fi
#done
echo " "
echo " Updated display firmware successfully. Restarting"
sudo reboot
