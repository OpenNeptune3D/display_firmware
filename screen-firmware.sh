#!/bin/bash

echo "Updating screen firmware"
echo " "
echo "DO NOT power off the machine! This may take a while."
#update screen firmware
#Install Dependencies

# Create and activate a Python virtual environment
echo "Creating and activating a virtual environment..."
python3 -m venv Screen-Update
source Screen-Update/bin/activate
pip install pyserial
#Download Screen Image
curl -O https://raw.githubusercontent.com/Choccy-vr/OpenNept4une/main/screen-config/elegoo_neptune_pro_klipper.tft
#Flashing
echo " "
echo "Done downlaoding tft file & dependencies. Onto flashing!"
echo " "
python3 "${HOME}/OpenNept4une/screen-config/Nexus.py" -i elegoo_neptune_pro_klipper.tft -u 115200
