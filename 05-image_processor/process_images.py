import cv2
import os

# Input and output folders
input_folder = '/input_images'
output_folder = '/output_images'

# Iterate over all images in the input folder
for filename in os.listdir(input_folder):
    if filename.endswith('.jpg') or filename.endswith('.png'):
        # Read the image
        image_path = os.path.join(input_folder, filename)
        image = cv2.imread(image_path)

        # Apply edge detection using Canny
        edges = cv2.Canny(image, 100, 200)

        # Save the processed image to the output folder
        output_path = os.path.join(output_folder, filename)
        cv2.imwrite(output_path, edges)

        print(f'Processed image: {filename}')
