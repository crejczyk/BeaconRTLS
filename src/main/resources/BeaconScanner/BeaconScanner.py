#This is a working prototype. DO NOT USE IT IN LIVE PROJECTS

import ScanUtility
import bluetooth._bluetooth as bluez
import paho.mqtt.client as mqtt

#Set bluetooth device. Default 0.
broker_address="18.192.37.5:1883" 
dev_id = 0
try:
	sock = bluez.hci_open_dev(dev_id)
	print ("\n *** Looking for BLE Beacons ***\n")
	print ("\n *** CTRL-C to Cancel ***\n")
except:
	print ("Error accessing bluetooth")

ScanUtility.hci_enable_le_scan(sock)
client = mqtt.Client("P1") #create new instance
client.connect(broker_address) #connect to broker
#Scans for iBeacons
try:
	while True:
		returnedList = ScanUtility.parse_events(sock, 10)
		for item in returnedList:
			print(item)
			client.publish("house_#1/",item)
			print("")
except KeyboardInterrupt:
    pass
