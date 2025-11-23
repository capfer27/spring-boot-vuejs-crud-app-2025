#!/bin/bash
set -e

# Define variables for your project
PROJECT_NAME="spring-boot-vue-crud"

echo "Stopping services..."
docker stop spring-boot-vue-crud-app-1
docker rm -f spring-boot-vue-crud-app-1
docker rmi postgres:18-alpine
docker rmi spring-boot-vue-crud
