# Basic Network Commands

Below are the commands for the "Basic Network" section:

1. **Create Communication Network**
    ```bash
    docker network create network_comunicacion
    ```

2. **Create Isolated Network**
    ```bash
    docker network create network_aislada
    ```

3. **Run Container 1 in Communication Network in Detached Mode**
    ```bash
    docker run -d --name container1 --network network_comunicacion alpine sleep infinity
    ```

4. **Run Container 2 in Communication Network in Detached Mode**
    ```bash
    docker run -d --name container2 --network network_comunicacion alpine sleep infinity
    ```

5. **List Running Containers**
    ```bash
    docker ps
    ```

6. **Run Container 3 in Isolated Network in Detached Mode**
    ```bash
    docker run -d --name container3 --network network_aislada alpine sleep infinity
    ```

7. **List Running Containers Again**
    ```bash
    docker ps
    ```

8. **Ping Container X from Another Container**
    ```bash
    docker exec -it containerX ping -c 4 containerX
    ```

9. **Remove All Containers**
    ```bash
    docker rm -f container1 container2 container3
    ```

10. **Remove Both Networks**
    ```bash
    docker network rm network_comunicacion network_aislada
    ```
