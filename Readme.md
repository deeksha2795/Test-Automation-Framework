# Test Automation Framework using Selenium Web Driver #
This Automation Testing Framework is designed for efficient, scalable, and maintainable web application testing.
It is built using Java 11 and leverages Selenium WebDriver with TestNG to ensure robust test coverage and flexible execution.

## Tech Stack ##
1. **Language:** Java 11
2. **Automation Tool:** Selenium WebDriver
3. **Test Framework:** TestNG
4. **Build Tool:** Maven
5. **Plugin:** Maven Surefire Plugin
6. **Design Pattern:** Page Object Model (POM)
7. **Reporting:** Extent Reports
8. **Data Sources:** CSV & JSON files
9. **External Features :** TestNG Listeners and Retry Analyzers for robust execution

## Framework Highlights ##
**Page Object Model (POM)** : Promotes modular, readable, and maintainable code.
Separates test logic from UI interactions.

⚡ **Parallel Execution** : Powered by Maven Surefire Plugin and TestNG for running multiple tests simultaneously, reducing total execution time.
🧠 **Listeners & RetryAnalyzer :**

- Implements TestNG Listeners for event-based actions such as:
- Capturing screenshots on failure
- Logging test start/end events
- Integrating Extent report logging dynamically
- Includes a RetryAnalyzer to automatically re-run failed tests, reducing flakiness due to intermittent or environmental issues.

🧪 **Data-Driven Testing** : Reads test input dynamically from CSV and JSON files for parameterized test runs.

📊 **Reporting** : Generates interactive and visually rich Extent Reports with:

- Test status (Pass/Fail/Skip)
- Execution time
- Environment details
- Screenshot embedding

🪵 **Logging & Debugging** : Implements structured logging for detailed execution trace.
Screenshots are automatically captured on test failures for quick debugging.

🔗 **CI/CD Integration** : Compatible with Jenkins and other CI/CD tools for continuous test execution.

🧾 **Test Data Management:** Test data is stored in /testData/ as CSV and JSON files.
loginData.csv 
loginData.json
Data is dynamically read during runtime for data-driven test execution.

 ## Project Setup ##
🔧 **Prerequisites** :
Make sure you have the following installed:
- Java 11 or later
- Maven 3.8+
- Git
- A web browser (e.g., Chrome) and matching WebDriver

  ## Folder Structure ##
  <code> automation-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── com/constants/          # Framework constants
│       │   ├── com/ui/dataproviders/   # Data providers for TestNG
│       │   ├── com/ui/listeners/       # TestNG listeners & retry analyzers
│       │   ├── com/ui/pages/           # Page Object Model classes
│       │   ├── com/ui/pojos/           # POJO classes for test data objects
│       │   ├── com/ui/tests/           # Test classes
│       │   └── com/utility/            # Utility/helper classes
│       └── resources/                  # Test resources (config, test data)
│           ├── config/                 # Configuration files (e.g., config.properties)
├── logs/                               # Log files generated during test runs
├── screenshots/                        # Captured screenshots on failure
├── target/                             # Maven build output
├── testData/                           # Data files (CSV, JSON)
├── test-output/                        # TestNG default output folder
├── pom.xml                             # Maven project configuration
├── testNG.xml                          # TestNG suite definition
├── report.html                         # Generated report (Extent or HTML)
├── Readme.md                           # Project documentation
└── ... </code>

## Key Benefits ##

- Modular & maintainable architecture (POM)
- Data-driven and parallel execution support
- Detailed Extent reports with embedded screenshots
- Centralized configuration and easy CI/CD integration
- Simplified debugging with logs and failure capture

