#!/bin/bash

echo "Uninstalling display firmware."

#venv
source Display-Update/bin/activate
#stopping display service
echo "Stopping display service"
sudo service display stop
echo " "
echo "Stopped display service"

#restore scripts
echo "Making necessary modifications"
curl -o "${HOME}/display_connector/src/response_actions.py" https://raw.githubusercontent.com/OpenNeptune3D/display_connector/dev/src/response_actions.py
curl -o "${HOME}/display_connector/src/neptune4.py" https://raw.githubusercontent.com/OpenNeptune3D/display_connector/dev/src/neptune4.py
curl -o "${HOME}/display_connector/src/openneptune_display.py" https://raw.githubusercontent.com/OpenNeptune3D/display_connector/dev/src/openneptune_display.py
curl -o "${HOME}/display_connector/src/elegoo_display.py" https://raw.githubusercontent.com/OpenNeptune3D/display_connector/dev/src/elegoo_display.py 
#restore display_connector.cfg
config_file="${HOME}/printer_data/config/display_connector.cfg"
new_line="display_type = openneptune"
if grep -Fxq "$new_line" "$config_file"; then
    sed -i "/$new_line/d" "$config_file"
fi
#restore stock firmware
curl -o "${HOME}/display_firmware/Restore.tft" https://github.com/OpenNeptune3D/display_connector/raw/dev/dev-resources/UI_1.2.14_240705.tft
python3 "${HOME}/display_firmware/Nexus.py" -i "${HOME}/display_firmware/Restore.tft" -u 115200 -p /dev/ttyS1
#Delete display firmware
rm -rf "${HOME}/display_firmware"
#done
echo " "
echo "Uninstall display firmware success"
sudo reboot
