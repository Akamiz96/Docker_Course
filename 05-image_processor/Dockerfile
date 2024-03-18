# Use the base Python image with OpenCV
FROM python:3.9

# Install necessary dependencies
RUN pip install opencv-python-headless

# Set the working directory to /app
WORKDIR /app

# Copy the Python script into the container
COPY process_images.py .

# Execute the Python script when the container starts
CMD ["python", "process_images.py"]
