 Selenium Automation Project

## Project Overview
This project is a Selenium-based automation framework designed to test web applications. It consists of several components, including page classes, utility classes, and test class to ensure a modular and maintainable structure.

## Project Structure

#### Project Name : UI_Tests

#### Project files path: Src->Test->Java

- **AutomationPage**: Represents the AutomationPage of the web application, encapsulating all the elements and actions specific to this page.
- **HomePage**: Represents the homepage of the web application, encapsulating all the elements and actions specific to this page.
- **TestBase**: A base class for all test classes, providing setup and teardown methods for initializing and quitting the WebDriver instance and handling test data.
- **TestRunner**: Manages the execution of test cases, typically using TestNg framework.
- **WebDriverManage**: Handles the configuration and management of WebDriver instances, including browser setup.
- **ExcelHandler**: Utility class for reading from Excel files, used for data-driven testing.

## Prerequisites
- Java Development Kit (JDK) installed
- Maven installed
- IDE (IntelliJ)
- WebDriver binaries (Edge Driver), 

## Setup Instructions

1. **Clone the Repository**
    ```sh
    git clone https://github.com/OsamaAbdallah1/UI_Tests.git
    cd UI_Tests
    ```

2. **Install Dependencies**
    ```sh
    mvn clean install
    ```

3. **Configure WebDriver**
    - Download the WebDriver binary for your browser (EdgeDriver).
    - Place the WebDriver binary in your system variable.



## Running Tests

1. **Using Maven**
    ```sh
    mvn test
    ```

2. **Using IDE**
    - Open the project in your IDE.
    - Navigate to the `TestRunner` class.
    - Right-click and select "Run" or use the test framework's runner.




