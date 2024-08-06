#!/bin/bash

echo "Updating display firmware"
echo " "
echo "DO NOT power off the machine! This may take a while."
#update screen firmware
# Create and activate a Python virtual environment
#stopping display service
echo "Stopping display service"
sudo service display stop
echo " "
echo "Stopped display service"
#venv
echo " "
echo "Creating and activating a virtual environment..."
python3 -m venv Display-Update
source Display-Update/bin/activate
pip install pyserial
echo " "
echo "Activated virtual enviroment successfully"
#Download Screen Image
echo " "
echo "Downlaoding Screen Firmware"
curl -o "${HOME}/display_firmware/tft" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/tft/OpenNeptuneUi.tft
#Flashing
echo " "
echo "Starting to flash!"
echo " "
python3 "${HOME}/display_firmware/Nexus.py" -i "${HOME}/display_firmware/tft/OpenNeptuneUi.tft" -u 115200 -p /dev/ttyS1
echo " "
#Modify scripts
echo "Making necessary modifications"
curl -o "${HOME}/display_connector/src" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/response_actions.py
curl -o "${HOME}/display_connector/src" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/neptune4.py
curl -o "${HOME}/display_connector/src" https://raw.githubusercontent.com/OpenNeptune3D/display_firmware/main/Modified_Scripts/openneptune_display.py
echo " "
echo " Updated display firmware succesfully. Restarting"
sudo reboot
