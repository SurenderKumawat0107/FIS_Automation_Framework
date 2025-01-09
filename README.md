# FIS Automation Framework

## Overview
This project contains an **Automation Framework** that is designed to perform both UI and API automation. The framework is built using **Page Object Model (POM)** and integrates with **TestNG** for running tests and generating reports.

## Features
1. **UI Automation**: 
   - Automated test scenario for adding an item to the cart on **eBay**.
   - Steps include searching for a book, clicking on a book, adding it to the cart, and verifying the cart update.
2. **API Automation**: 
   - Automated test to send a GET request to `https://api.coindesk.com/v1/bpi/currentprice.json`.
   - Verifies the presence of 3 BPIs (USD, GBP, EUR) and checks the description for GBP.

## Tools and Technologies
- **Selenium WebDriver**: For UI automation.
- **TestNG**: For running and reporting test results.
- **Rest-Assured**: For API testing.
- **Maven**: For build automation.

## How to Run the Tests
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/SurenderKumawat0107/FIS_Automation_Framework.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd FIS_Automation_Framework
   ```

3. **Build and Run Tests with Maven**:
   To run the tests, execute the following Maven command:
   ```bash
   mvn clean test
   ```

4. **View the Reports**:
   The test reports will be available under the `target` folder after the tests are executed.


