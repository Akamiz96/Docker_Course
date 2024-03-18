# Use a C++ base image
FROM gcc:latest

# Copy the source code into the container
COPY primos.cpp /usr/src/app/

# Set the working directory
WORKDIR /usr/src/app/

# Compile the program
RUN g++ -o primos primos.cpp

# Define the default command to execute the program
CMD ["./primos"]


