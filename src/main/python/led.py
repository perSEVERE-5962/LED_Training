#!/usr/bin/env python3
import RPi.GPIO as GPIO
import sys
from networktables import NetworkTables

ip = sys.argv[1]
NetworkTables.initialize(server=ip)
led = NetworkTables.getTable("LED")

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)
GPIO.setup(12,GPIO.OUT)

while True:
    isOn = bool(led.getBoolean("isOn", False))
    if isOn == True:
        print ("LED on")
        GPIO.output(12,GPIO.HIGH)
    else:
        print ("LED off")
        GPIO.output(12,GPIO.LOW)

GPIO.cleanup()  
