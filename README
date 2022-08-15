# Floward task
***
This is an automation script for test scenarios in floward website using page object model and selenium tool.


## Technologies
***
A list of technologies used within the project:
* [Java]: Version 18.0.1.1
* [Maven]: Version 3.8.6
* [Selenium]: Version 4.3.0
* [TestNG]: Version 7.6.1
* [webdrivermanager]: Version 5.2.2
* [Extent report]: Version 2.41.2
* [Chrome]: Version 103.0.5060.134

Follow the instructions in this README to install software requirements and run the project.

# Setup Instructions
* Download maven from https://maven.apache.org/download.cgi.
* Set MAVEN_HOME to your enviroment variables.
* Download JAVA from https://www.java.com/download/ie_manual.jsp.
* Set JAVA_HOME to your enviroment variables.
* Add MAVEN_HOME & JAVA_HOME to path in enviroment variables.
* You will also need [Git](https://git-scm.com/) to copy this project code.
If you are new to Git, [try learning the basics](https://try.github.io/).


## Project Setup and execution

1. Clone this repository.
2. Run all the previous installation to install the dependencies. 
3. Open command promote then Run `cd {project path}' to enter the project.
4. When enter project run "mvn test".
5. Result will be at this path "{Project path}\reports".

* The `tests/*` contain the testcase code for project parts.

* Adding 2 testcases for pass and fail scenarios.
* `tests/FlowardTest.java`.
* tests/TestBase.java.


## Defining Page Objects

*Example: pages/homePage.java*

A **page object** is an object representing a Web page or component.
They have *locators* for finding elements,
as well as *interaction methods* that interact with the page under test.
Page objects make low-level Selenium WebDriver calls
so that tests can make short, readable calls instead of complex ones.


There are 2 pages under page classes and 1 base page for common interaction like click or get text 
each with a few interactions:

1. The base page
    * make action on element by passing locators for web
2. The home page page
    * Get the locators of floward home page and interactions
3. The cart page page
    * Get the locators of floward cart page and interactions

## Extent report
*Extent report in TestBase is responsible for naming and appending on the current report.

	   @BeforeClass
	public void startReport() {
		String FileName = "Report"+".html";
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String FullPath = directory + FileName;
        reports = new ExtentReports(FullPath, true);
	}

* Handling test result and screenshot in TestBase
 
 * Screenshot function 
 
    public static String captureScreen(WebDriver driver) throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File("src/../screenshots/" + System.currentTimeMillis()
	+ ".png");
	String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
	return errflpath;
	}

  *Calling of screenshot
	 @AfterMethod
     public void setTestResult(ITestResult result) throws IOException {
                
                 if (result.getStatus() == ITestResult.FAILURE) {
                             test.log(LogStatus.FAIL, result.getName());
                             test.log(LogStatus.FAIL,result.getThrowable() +test.addScreenCapture(Capture.captureScreen(driver)));
                 } else if (result.getStatus() == ITestResult.SUCCESS) {
                             test.log(LogStatus.PASS, result.getName());
                            
                 } else if (result.getStatus() == ITestResult.SKIP) {
                             test.log(LogStatus.SKIP,"Test Case : " + result.getName() + " has been skipped");
                 }
                 
                 reports.flush();
                 driver.quit();
     }

## Run with jenkins

* Open jenkins
* Create a new pipline job
* In pipline section :

      1.Change definition to be "Pipline script from SCM".
      2.Choose SCM to be "Git".
      3.Put Repository URL "https://github.com/AlaaIsmaeil/SeleniumFramework.git"
      4.Add in Script Path "jenkinsFile"

## Jenkins file pipeline

* Jenkins file will be as the following:

pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AlaaIsmaeil/SeleniumFramework.git'

            }
            }
        stage('Build') {
            steps {
             
   
                // To run Maven on a Windows agent, use
                 bat "mvn test"
            }
           }
         
      stage('result') {
                
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                
           steps {
                   
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'

                }
            }
        
    }
}