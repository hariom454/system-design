#!/bin/bash

cd metro-card
pwd
./gradlew clean build -x test --no-daemon
java -jar build/libs/metro-card.jar input1.txt