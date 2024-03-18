import os
import numpy as np
from PIL import Image
import time
import logging

# Configure logging
logging.basicConfig(filename='receiver.log', level=logging.INFO,
                    format='%(asctime)s - %(levelname)s - %(message)s')

def generate_image(numbers_file, output_folder):
    # Log start of image generation process
    logging.info(f'Starting image generation process for file: {numbers_file}')

    # Read numbers from the file
    with open(numbers_file, 'r') as file:
        lines = file.readlines()

    # Create a numpy matrix from the numbers
    numbers_matrix = np.loadtxt(lines)
    # Convert the matrix to a grayscale image
    image = Image.fromarray(numbers_matrix.astype('uint8'), 'L')

    # Generate image file name
    image_filename = os.path.splitext(os.path.basename(numbers_file))[0] + '.png'
    # Define path to save the image
    image_path = os.path.join(output_folder, image_filename)
    # Save the image in the output folder
    image.save(image_path)

    # Log image generation and saving
    logging.info(f'Image generated and saved as: {image_path}')

    # Remove the numbers file after generating the image
    os.remove(numbers_file)
    # Log deletion of numbers file
    logging.info(f'Numbers file deleted: {numbers_file}')

def main():
    input_folder = '/shared_folder'
    output_folder = '/output_images'

    while True:
        # Look for files in the input folder
        for filename in os.listdir(input_folder):
            if filename.startswith('numbers_') and filename.endswith('.txt'):
                numbers_file = os.path.join(input_folder, filename)
                generate_image(numbers_file, output_folder)

        # Wait for half a minute
        time.sleep(30)

if __name__ == "__main__":
    main()
