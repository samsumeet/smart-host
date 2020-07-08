#!/bin/sh

mvn clean install

docker build -t smart-host/smart-host-api .

docker run -p 8080:8080 smart-host/smart-host-api
