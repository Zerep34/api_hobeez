#! /bin/bash

sudo rm -rf target

sudo docker-compose stop

git pull

git checkout $1

sudo mvn clean

sudo mvn install -DskipTests

sudo docker-compose up --build -d