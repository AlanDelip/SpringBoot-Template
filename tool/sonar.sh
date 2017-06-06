#!/usr/bin/env bash
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install
mvn sonar:sonar