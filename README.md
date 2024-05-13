# CS330 Project: TCP Client-Server Connection

## Overview
This project is a Java application that establishes a TCP client-server connection to allow data transfer between two different hosts. The primary function of the application is to convert a decimal number to a number system (hexadecimal or binary) as specified by the client, and then send it to the server for processing. The server then sends the result back to the client.

## Features
- **TCP Connection**: The application uses the Java programming language to establish a TCP connection between the client and the server.
- **Data Conversion**: The client can send a decimal number to the server along with the desired number system (hexadecimal or binary). The server will then convert the decimal number to the specified number system and send the result back to the client.
- **Error Handling**: The application is designed to handle error cases effectively. If an error occurs during the conversion process or data transfer, the application will handle it appropriately and ensure the stability of the connection.

## Getting Started
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the Java files.
4. Run the server program.
5. Run the client program and follow the prompts to input a decimal number and the desired number system.

## Installation
1. Ensure you have Java installed on your machine. You can download it from the official Oracle website.
2. Clone the repository to your local machine using Git:

git clone https://github.com/Abdulrhmansaleh/project-cs330.git

3. Navigate to the project directory:

cd project-cs330


## Usage
1. Compile the Java files:

javac TCP_SERVER.java TCP_CLIENT.java

2. Run the server program in one terminal:

java TCP_SERVER.java

3. Run the client program in another terminal and follow the prompts to input a decimal number and the desired number system:

java TCP_CLIENT.java
