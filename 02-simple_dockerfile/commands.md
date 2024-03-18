# Simple Dockerfile Commands

Below are the commands for the "Simple Dockerfile" section:

1. **Build Docker Image with Tag "calculadora_primos"**
    ```bash
    docker build -t calculadora_primos .
    ```

2. **Run Docker Container with "calculadora_primos" Image**
    ```bash
    docker run calculadora_primos
    ```

3. **Run Docker Container Interactively with "calculadora_primos" Image**
    ```bash
    docker run -it calculadora_primos
    ```

4. **List All Containers (Including Exited Ones)**
    ```bash
    docker ps --all
    ```

5. **Run Docker Container Named "calculadora" in Detached Mode with "calculadora_primos" Image**
    ```bash
    docker run --name calculadora -it -d calculadora_primos
    ```

6. **List Running Containers**
    ```bash
    docker ps
    ```

7. **Execute Bash Shell in Running "calculadora" Container**
    ```bash
    docker exec -it calculadora bash
    ```

8. **List Files in Container Directory**
    ```bash
    ls
    ```

9. **Display Contents of "primos.cpp" File**
    ```bash
    cat primos.cpp
    ```
