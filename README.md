# Challenge 1

## Justification for Design Decisions


* **RestAssured** is a widely used Java library for testing REST APIs, known for its intuitive and expressive syntax, which simplifies the process of crafting HTTP requests and validating responses.


* **TestNG** is a versatile testing framework that provides advanced features such as parallel test execution, detailed reporting, and support for grouping and prioritizing tests. Its powerful annotations enable fine-grained control over the test lifecycle, making it ideal for building scalable and maintainable testing pipelines, especially in complex environments.

## Continuous Integration (CI) 

To effectively integrate automated testing into a CI pipeline, follow this structured approach:

### 1. Select a CI Tool
Choose a CI tool that fits your project's requirements and ecosystem. Popular choices include:

* **Jenkins**: Highly customizable with extensive plugin support.
* **GitHub Actions**: Tight integration with GitHub repositories.
* **GitLab CI/CD**: Seamless integration with GitLab-hosted projects.
* **CircleCI**: Focused on speed and scalability.

### 2. Define a Pipeline Configuration File
Use the CI tool's configuration file format to automate the build and test process:

* **Jenkins**: Jenkinsfile
* **GitHub Actions**: .github/workflows/ci.yml
* **GitLab CI/CD**: .gitlab-ci.yml

### 3. Organize the Pipeline into Stages
Define clear stages to separate concerns and improve readability:

* **Build Stage**:
Compiles the Java code using Maven or Gradle. Example command: 
```
mvn clean compile 
```
or 
```
./gradlew build
```

* **Test Stage**:
Executes the TestNG tests and generates test reports.
Example command: 
```
mvn test 
```
or 
```
./gradlew test
```

### 4. Environment Variables
Securely manage sensitive information like API tokens or keys:

Example: Store the AUTH_TOKEN variable in the CI tool’s secret management system (e.g., GitLab's CI/CD variables, GitHub Secrets).


Reference the variable in code using 
```
System.getenv("AUTH_TOKEN")
```

### 5. Use Appropriate Docker Images
Ensure the environment includes the necessary dependencies:

Example: Use the maven:3.8.7-jdk-11 Docker image for Java projects, which provides Maven and JDK 11 pre-installed.

### 6. Save and Share Artifacts
* **Build Stage**: Save compiled files (e.g., the target/ directory for Maven) for use in subsequent stages.

* **Test Stage**: Store TestNG reports (e.g., surefire-reports/*.xml) to provide detailed feedback and debugging information.

### 7. Trigger Pipeline Automatically
Define pipeline triggers for key events:

* Commits to the main branch.
* Merge requests or pull requests to ensure code quality in new changes.


# Challenge 3

## Other Tests to Perform

#### 1. Functional Tests:
* **Start/Stop Charging Session:**
Verify the functionality to start a session after scanning a QR code.
Ensure a session can be successfully stopped.
* **QR Code Redirection:**
Test that scanning different QR codes redirects to the correct chargers in the application.
* **Session State Updates:**
Verify that the application updates the session state in real-time (e.g., "Charging", "Completed").
#### 2. Usability Tests:
* Ensure the UI is intuitive, and buttons/links are easily accessible.
* Test responsiveness of the web application on different screen sizes and devices.
#### 3. Measure page load times to ensure they meet performance standards.
* Test application performance under high traffic or simultaneous driver usage.
#### 4. Security Tests:
* Validate secure storage and transmission of credentials and sensitive data.
* Ensure that the one-time passcode expires after a specific duration.
#### 5. Localization Tests:
* If the application supports multiple languages, ensure the correct text is displayed for different locales.
#### 6. Error Handling Tests:
* Test login with invalid credentials (e.g., wrong OTP).
* Verify appropriate error messages are displayed for network or API failures.

## Justification for Design Decisions

* **Selenium WebDriver**:
Flexible and widely used for UI automation. Cross-browser support ensures compatibility testing across major browsers.  Large community and plugin support (e.g., integration with TestNG).


* **TestNG**:
Allows grouping of tests (e.g., Login Tests, Session Tests). 
Provides detailed reporting and parallel test execution.

## Additional Areas to Test

#### 1. Comprehensive Accessibility Testing:
Ensure the application is usable by individuals with disabilities (e.g., screen reader support, keyboard navigation).

#### 2. End-to-End Workflow Testing:
Simulate an end-to-end driver workflow:
Scan QR code → Log in → Start a session → Stop a session → View transaction details.
#### 3. Cross-Browser and Cross-Device Testing:
* Test compatibility on browsers like Chrome, Firefox, Safari, and Edge.
* Validate functionality on both iOS and Android devices.
#### 4. Real-Time Notifications:
Verify that drivers receive real-time updates for charger statuses or session errors.
#### 5. API Integration Testing:
Test the integration of the web application with the ChargeLab backend APIs (e.g., session creation, status updates).
#### 6. Load Testing:
Simulate concurrent driver logins and actions to test scalability.