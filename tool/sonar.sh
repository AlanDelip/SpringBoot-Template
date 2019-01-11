#!/bin/sh
mvn org.jacoco:jacoco-maven-plugin:prepare-agent install
mvn sonar:sonar