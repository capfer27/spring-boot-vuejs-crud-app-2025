#!/bin/bash
set -e

# Define variables for your project
PROJECT_NAME="spring-boot-vue-crud"
IMAGE_TAG="latest"

echo "### Starting Gradle clean and build for '$PROJECT_NAME' ###"

./gradlew clean build

echo "### Starting Docker build and compose for '$PROJECT_NAME' ###"

# Clean up any old running containers and images
echo "Stopping and removing old containers..."
docker-compose -p $PROJECT_NAME down --rmi all

# Build the Docker images defined in docker-compose.yml
echo "Building new images..."
docker-compose -p $PROJECT_NAME build --no-cache

# Run the containers using docker-compose
echo "Starting services..."
docker-compose -p $PROJECT_NAME up -d

echo "### Deployment completed. ###"

# Optionally, show the logs
echo "Showing logs for running services..."
docker-compose -p $PROJECT_NAME logs -f