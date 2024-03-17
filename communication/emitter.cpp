#include <iostream>
#include <fstream>
#include <random>
#include <chrono>
#include <thread>
#include <iomanip>

const int IMAGE_WIDTH = 1000;
const int IMAGE_HEIGHT = 1000;

// Function to generate a file containing random pixel values for a grayscale image
void generateNumbersFile(const std::string& filename) {
    // Log start of file generation process
    std::cout << "Starting file generation: " << filename << "\n";

    std::ofstream file(filename);
    if (!file.is_open()) {
        std::cerr << "Error: Unable to open file for writing\n";
        return;
    }

    // Use std::random_device to obtain a seed for the random number engine
    std::random_device rd;
    // Use std::mt19937 as the random number engine
    std::mt19937 gen(rd());
    // Define the range of the random numbers (0 to 255 for grayscale pixel values)
    std::uniform_int_distribution<int> dis(0, 255);

    for (int y = 0; y < IMAGE_HEIGHT; ++y) {
        for (int x = 0; x < IMAGE_WIDTH; ++x) {
            // Generate a random number for each pixel and write it to the file
            file << std::setw(3) << dis(gen) << " ";
        }
        file << "\n";
    }

    file.close();

    // Log end of file generation process
    std::cout << "File generation completed: " << filename << "\n";
}

int main() {
    while (true) {
        // Generate filename with timestamp
        auto now = std::chrono::system_clock::now();
        auto timestamp = std::chrono::duration_cast<std::chrono::milliseconds>(now.time_since_epoch()).count();
        std::string filename = "/shared_folder/numbers_" + std::to_string(timestamp) + ".txt";

        // Generate random numbers file
        generateNumbersFile(filename);

        // Wait for half a minute
        std::this_thread::sleep_for(std::chrono::seconds(30));
    }

    return 0;
}
