# Web Automation Testing Project

This is a professional web automation testing project developed using **Java**, **Maven**, **TestNG**, and the **Page Object Model (POM)** design pattern. 
It demonstrates modular automation design, structured test planning, and execution for a sample website hosted locally, or remotely.

---

## 📁 Project Structure Overview

```
src/
├── test/
│   └── java/
│       └── com.shejuti/
│           ├── base/        → Base setup and common WebDriver config
│           │   └── BaseTest.java
│           ├── pages/       → Page Object Model classes for UI mapping
│           │   ├── HomePage.java
│           │   ├── LoginPage.java
│           │   └── ... etc.
│           ├── tests/       → Test classes for functional test scenarios
│           │   ├── LoginTest.java
│           │   ├── HomeTest.java
│           │   └── ... etc.
│           └── utils/       → Reusable utility classes (e.g., waits, configs)
│               ├── ConfigReader.java
│               └── WaitUtils.java
├── test/resources/
│   ├── config-dev.properties
│   └── config-prod.properties
└── testng.xml              → TestNG suite definition
```

---

## 🚀 How to Run the Project

### Prerequisites:
- Java JDK 8+ installed
- Maven installed
- Chrome browser (or modify for other drivers)
- Git (for version control)

### Running Tests from Terminal

1. **Run tests with default (dev) environment**
```bash
mvn clean test
```

2. **Run with specific environment (e.g., production):**
```bash
mvn clean test -Denv=prod
```

> The `env` parameter loads configuration from matching `config-<env>.properties` files.

---

## 🧪 Testing Technologies & Tools Used

| Tool/Framework   | Purpose |
|------------------|---------|
| **Java**         | Programming language |
| **Selenium WebDriver** | UI automation |
| **TestNG**       | Test execution, assertions, test grouping |
| **Maven**        | Build and dependency management |
| **Page Object Model (POM)** | Separation of UI locators from logic |
| **Git**          | Version control |
| **XPath/CSS Selectors** | Web element location strategies |

---

## 📄 Description of Script Types

### ✅ `BaseTest.java`
- Initializes WebDriver
- Launches browser and navigates to base URL
- Configured once and reused across all test classes

### ✅ `pages/*.java`
- Each page class (e.g., `LoginPage.java`) holds web element locators and user actions
- Encapsulates all interaction logic for modular and reusable design

### ✅ `tests/*.java`
- Test cases that call methods from page classes
- Each test class maps to a specific feature/page under test

### ✅ `utils/*.java`
- `ConfigReader.java`: Reads configuration from `.properties` files based on environment
- `WaitUtils.java`: Reusable waits using `WebDriverWait` for element visibility, clickability etc.

---

## 📌 Test Coverage

Functional testing for the following modules is included:
- Login functionality
- Navigation to Home, About, Projects, Testing Demo, Contact pages
- Form submissions and UI validations

---

## 📌 GitHub Repo
github: https://github.com/shejutik/WebAutomation

---

## 📅 Last Updated
July 15, 2025

---

## 📬 Author
Shejuti Khan— Software Test Analyst | Automation Enthusiast  
Melbourne, Australia

---
