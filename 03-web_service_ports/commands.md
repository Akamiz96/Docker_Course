# Expose Ports Commands

Below are the commands for the "Expose Ports" section:

1. **Build Docker Image with Tag "simple_web_service"**
    ```bash
    docker build -t simple_web_service .
    ```

2. **Run Docker Container in Detached Mode, Mapping Port 8080 on Host to Port 80 in Container**
    ```bash
    docker run -d -p 8080:80 simple_web_service
    ```

3. **Access Web Service via http://localhost:8080**
    ```
    localhost:8080
    ```

4. **Run Another Docker Container with Port Mapping to 8080**
    ```bash
    docker run -d -p 8080:80 simple_web_service
    ```

5. **List Running Containers**
    ```bash
    docker ps
    ```

6. **Run Docker Container with Port Mapping to 8090**
    ```bash
    docker run -d -p 8090:80 simple_web_service
    ```

7. **Run Docker Container with Port Mapping to 9090**
    ```bash
    docker run -d -p 9090:80 simple_web_service
    ```

8. **Run Docker Container with Port Mapping to 9080**
    ```bash
    docker run -d -p 9080:80 simple_web_service
    ```

9. **List Running Containers**
    ```bash
    docker ps
    ```

10. **Access Web Services via http://localhost:8080, http://localhost:8090, http://localhost:9090, http://localhost:9080**
    ```
    localhost:8080
    localhost:8090
    localhost:9090
    localhost:9080
    ```

11. **Execute Bash Shell in Running Container Named "exciting_lamport"**
    ```bash
    docker exec -it exciting_lamport bash
    ```

12. **Display Contents of "index.html" File**
    ```bash
    cat /usr/share/nginx/html/index.html
    ```
