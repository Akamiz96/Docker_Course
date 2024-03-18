# Volumes Commands

Below are the commands for the "Volumes" section:

1. **Build Docker Image with Tag "web_service_volume"**
    ```bash
    docker build -t web_service_volume .
    ```

2. **Run Docker Container in Detached Mode, Mapping Port 8080 on Host to Port 80 in Container, and Mounting Current Directory to "/usr/share/nginx/html" Inside the Container**
    ```bash
    docker run -d -p 8080:80 -v .:/usr/share/nginx/html web_service_volume
    ```
