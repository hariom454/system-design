#!/bin/bash
set -e

./gradlew clean build -x test --no-daemon

if [ -z "$1" ]; then
  echo "Usage: $0 <input_file>"
  exit 1
fi

java -jar build/libs/sprint-planner.jar "$1"
