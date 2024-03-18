# Communication Example Commands

Below are the commands for the "Communication Example" section:

1. **Build Docker Images for Receiver and Emitter**
    ```bash
    docker build -t receiver_image -f Dockerfile_receiver . && docker build -t emitter_image -f Dockerfile_emitter .
    ```

2. **Run Receiver Docker Container in Detached Mode, Mounting "./shared_folder" Directory to "/shared_folder" Inside the Container, and "./output_images" Directory to "/output_images" Inside the Container**
    ```bash
    docker run -d --name receiver -v "$(pwd)/shared_folder:/shared_folder" -v "$(pwd)/output_images:/output_images" receiver_image
    ```

3. **Run Emitter Docker Container in Detached Mode, Mounting "./shared_folder" Directory to "/shared_folder" Inside the Container**
    ```bash
    docker run -d --name emitter -v "$(pwd)/shared_folder:/shared_folder" emitter_image
    ```

4. **List Running Containers**
    ```bash
    docker ps
    ```

5. **Kill Emitter and Receiver Containers**
    ```bash
    docker kill emitter && docker kill receiver
    ```

