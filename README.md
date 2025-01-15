# Bragi Mobile E2E Test Automation Framework

## Introduction

This framework is aimed to automate the Mobile E2E tests of the Bragi mobile application.

It uses Selenide/Appium and Allure Reports, written in Java.

## Reasoning

### Why Selenide - Appium?
1. Easier to setup, configure and work with.
2. Very concise and easy to read.
3. Mostly resolves the inherit problems with Appium out of the box like auto waiting, easy configuration, etc.
4. Allows us to use the native Appium / Selenium driver instance when the out of the box features of Selenide is not enough, so we can even perform more low level operations when necessary.

### Features

The high-level features of this framework are:

1. Designed according to the POM (Page Object Model) architecture.
2. Easy to maintain and add new tests thanks to its modular design.
3. Stable, fast and can be easily containerized when necessary.
4. Able to run tests in parallel.
5. Has the functionality to switch between device types and test suites via command line.

### Dependencies

1. **Selenide:**
   Used as a wrapper framework for Selenium and Appium to solve its common problems.

2. **TestNG - AssertJ**
   Used as a testing framework and for assertions.

3. **Allure Reports:**
   Used for generating test execution reports.

4. **SLF4J**
    Used for logging operations, mainly related with macOS devices.

5. **Maven**
    Used for dependency management and test execution.

6. **Java JDK 17**
    The backbone of the whole thing.

## Installation and Execution

To install the framework on your local machine, follow the steps below.

1. Install JDK 17 by following the steps described at:
   > https://docs.oracle.com/en/java/javase/17/install/overview-jdk-installation.html

2. Install NodeJS [NodeJS Downloads Page](https://nodejs.org/en/download/).
3. Install Android Studio and Android SDKs [Android Studio Download Page](https://developer.android.com/studio).
4. Add ANDROID_HOME as an environment variable. Path should be the location of the installed SDK (e.g: C:\Program Files\Android).
5. Add the following values to the path:<br>
`%ANDROID_HOME%\platform-tools` `%ANDROID_HOME%\emulator` `%ANDROID_HOME%\tools` `%ANDROID_HOME%\build-tools` `%ANDROID_HOME%\cmdline-tools\latest\bin`.

6. Clone the repository to a desired location on your machine by executing the following code:

   `git clone git@github.com:denizhamamcioglu/bragi-assignment.git`

7. Place the .apk test file under `src/test/resources/` folder.
8. Install Maven to your local machine by following the steps that are described at:
   > https://maven.apache.org/install.html

9. Navigate to the root folder of the project and open up a terminal / command line window.

10. Type the following command to install the dependencies:

   `mvn clean install`

11. Launch an emulator or connect your Android device to your PC. If you want to use real devices for testing, make sure that the debugging is enabled on the test device.
12. Open up a command prompt and execute `adb devices`. This will return you the list of devices that are connected and ready to be used.1
13. Modify the `setUdid` value inside the src/main/java/core/base/DriverManager class to reflect the test device that you want to use.
14. After installing all the dependencies, you can execute the tests by typing one of the commands below:

   `mvn test`

This will execute the tests with default options.

Or you can customize these options by similar to the command below:

`mvn test -DtestSuite='<test_suite_choice>.xml'`

15. To generate a HTML test report using Allure Reports, you can use 2 options. Both of them depend on Allure being installed on your local host. <br>
To install Allure, follow the [Official Allure Installation Guide](https://allurereport.org/docs/install/)
   * `allure:serve`: This command will automatically generate a report and open up your default browser to display it.
   * `allure:report`: This command will generate all the necessary report files but will not display the report automatically.


#### Available Run Parameters
**-DtestSuite**: Used selecting the desired test suite.

