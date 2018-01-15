from picamera.array import PiRGBArray
from picamera import PiCamera

from networktables import NetworkTables as nt

import time
import cv2
import numpy as np
import math

# camera setup

camera = PiCamera(resolution="320x240", framerate = 60) # use 60 fps to avoid issues with rolling shutter
#camera.exposure_compensation = -25 # not sure if necessary
#camera.exposure_mode = 'off' # avoid automatic exposure compensation
#camera.shutter_speed = 5555 # low shutter speed to lower lighting besides the retroreflective tape
rawCapture = PiRGBArray(camera)
nt.initialize(server='roborio-424-frc.local')

time.sleep(5) # camera warmup, position setup

startTime = time.time(); # for timing purposes

# main execution

color = 0;

vi = nt.getTable('vision')

for image in camera.capture_continuous(rawCapture, format="bgr", use_video_port=True):
    
    # now grab frame and store it
    frame = image.array
    rawCapture.truncate(0) # important

        
    # convert images to HSV color spectrum
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    # hsv thresholds
    lower = np.array([18,100,89])
    upper = np.array([39,255,255])

    thresh = cv2.inRange(hsv, lower, upper)
    # find contours
    im2, contours, hierarchy = cv2.findContours(thresh, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    centerx = 0
    centery = 0
    contour = -1

    # filter contours
    for i in range(0, len(contours)):
         if cv2.contourArea(contours[i]) > 500:
             x,y,w,h = cv2.boundingRect(contours[i])
             centerx = x + w/2 # info about the target
             centery = y + h/2 # info about the target
             contour = i
             vi.putNumber('centerx', centerx);
             print(centerx)

    # save debug images
    cv2.imwrite("cube_orig.jpg", frame)

    cv2.drawContours(frame, contours, -1, (0, 0, 255), 2) # draw all contours in red
    cv2.imwrite('cube_found.jpg', frame) 


print("--- %s seconds capturing ---" % (time.time() - startTime))
processingStart = time.time();

# end main execution

print("--- %s seconds processing ---" % (time.time() - processingStart))
print("--- %s seconds total ---" % (time.time() - startTime))

camera.close(); # important
"""
while True:
    led.fill((255, 0, 0))
    led.update()
    time.sleep(DELAY)
    led.fill((0, 255, 0))
    led.update()
    time.sleep(DELAY)
    led.fill((0, 0, 255))
    led.update()
    time.sleep(DELAY)
"""