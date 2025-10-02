

## Containerization
Micronaut is containerized using Docker to ensure a consistent and reproducible environment for development and deployment. The Docker setup includes all necessary dependencies and configurations to run Micronaut applications seamlessly.

### Dockerfile
The `Dockerfile` defines the environment for the Micronaut application. It starts from a base image, installs necessary dependencies, copies the application code, and sets the entry point for the container.
Run below command to build the Docker image for the Micronaut application:
```Dockerfile
./gradlew dockerBuild
```
Run the Docker container using the following command:
```bash
docker run -d -p 8080:8080 parking-lot
```

Validate the Docker image by running:
```bash
docker ps
```
To stop the running container, use below command:
```bash
docker stop <container_id>
```
Follow the above steps to update the image, and to remove old container use below command.
```bash
docker rm <container_id>
```