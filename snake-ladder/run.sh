#!/bin/bash
set -e

cd snake-ladder
./gradlew clean build -x test --no-daemon

if [ -z "$1" ]; then
  echo "Usage: $0 <input_file>"
  exit 1
fi

java -jar build/libs/snake-ladder.jar "$1"
