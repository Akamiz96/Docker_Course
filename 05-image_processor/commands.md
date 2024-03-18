# Image Processor Commands

Below are the commands for the "Image Processor" section:

1. **Build Docker Image with Tag "image_processor"**
    ```bash
    docker build -t image_processor .
    ```

2. **Run Docker Container, Mounting "./input_images" Directory to "/input_images" Inside the Container, and "./output_images" Directory to "/output_images" Inside the Container**
    ```bash
    docker run -v "$(pwd)/input_images:/input_images" -v "$(pwd)/output_images:/output_images" image_processor
    ```
