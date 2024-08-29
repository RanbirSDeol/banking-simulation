# Banking Simulation - Overview

## Features

This program includes the following features:
- **Loading Screen:** Displays while the application is initializing.
- **Register:** Allows users to create an account by filling in personal details and setting up login credentials.
- **Sign In:** Enables users to log in using their account number and password.
- **Home Screen:** Shows the main dashboard with bank information.
- **Account Transfer:** Allows users to transfer funds between accounts.
- **Logout:** Returns users to the sign-up screen, allowing them to create additional accounts or log in again.

## Technology Stack

This application is built using Java with Java Swing for the graphical user interface (GUI). Here’s a brief overview of the technologies used:

- **Java:** The core programming language used to develop the application. It provides the structure and functionality for the banking simulation.
- **Java Swing:** A part of Java's Standard Library used to create the graphical user interface. Swing provides a set of lightweight components to build the user interface elements such as windows, buttons, and forms.

# Banking Simulation - Setup and Run Instructions

## Prerequisites

Ensure you have the following installed on your system:
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Git](https://git-scm.com/downloads)

## Step 1: Clone the Repository

First, you need to clone the repository from GitHub. Open your terminal and run:

```bash
git clone https://github.com/RanbirSDeol/banking-simulation.git
```

## Step 2: Navigate to the Project Directory

```bash
cd banking-simulation/src/myPackage
```

## Step 3: Compile the Java Files

```bash
javac *.java
```

## Step 4: Execute the program

```bash
java loadingFrame.java
```

# Usage

To use this application, follow these steps:

1. **Register an Account**

   Click the "Register" button at the bottom of the screen. You will need to fill out the following information:
   - Full name
   - Address
   - Phone number
   - Bank branch
   - Email address
   - Account deposit
   - Password (and re-enter it for confirmation)

   **Note:** You will receive a pre-generated account number. Be sure to write it down, as you will need it to log in. 

   **Important:** **DO NOT use your real information** as this is a simulation tool.

2. **Sign In**

   After registration, you will be returned to the sign-in screen. Enter your credentials—account number and password—and then click "Sign In."

3. **Navigate the Home Screen**

   Once signed in, you will see the home screen with a dashboard displaying your main bank information.

4. **Use the Transfer Feature**

   On the "Transfer" page, you can use the "Account Transfer" feature. Please note that the "E-Transfer" feature is not yet finished and cannot be used for transferring between accounts.

5. **Log Out**

   Use the "Logout" page to return to the sign-up screen. You can create additional accounts as needed. Error handling is in place, so you will not be able to create invalid accounts.

Feel free to explore the app and test its features. If you encounter any issues, the error handling should prevent the creation of invalid accounts.
