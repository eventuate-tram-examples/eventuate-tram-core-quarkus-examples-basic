#! /bin/bash

set -e

export docker="./gradlew ${DATABASE}${MODE}Compose"

${docker}Up

./gradlew :eventuate-tram-examples-jdbc-${BROKER}:cleanTest :eventuate-tram-examples-jdbc-${BROKER}:test

${docker}Down