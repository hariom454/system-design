#!/bin/bash
set -e

cd parking-lot
./gradlew clean build -x test --no-daemon

if [ -z "$1" ]; then
  echo "Usage: $0 <input_file>"
  exit 1
fi

java -jar build/libs/parking-lot.jar "$1"
