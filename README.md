# WeatherShopper Automation Framework

## How to run
1. Using Maven Command
	Open terminal, go to project root and run:
	mvn compile
	mvn test
	
2. Right click on testng.xml file and run as testng Test

3. Run Tests individually by right clicking on a test and run as Testng Test

### Parallel execution
1. In testng.xml file, add parallel="tests" on suite

2. To run on remote machines:
	Download selenium jar from jars folder
	register hub:   java -jar selenium-server-4.0.0-beta-2.jar hub
	register nodes:  java -jar selenium-server-4.0.0-beta-2.jar node
					java -jar selenium-server-4.0.0-beta-2.jar node --port 5556

## Highlights
- Can run tests with multiple data
- Can run tests parallel
- Can run on different browsers (input from excel)
- Each page class returns the reference to WeatherShopperPage 
- validator function to decide whether to soft assert or to stop execution
- Used Data.xlsx file with Runmode column to run or skip with that particular data
- tests are separated from application logic
- tests are extending base test where beforeMethod and afterMethod testng annotations are used
- Data.xlsx file has input values e.g. product content so that we can change product content in future if required
- used EventFiringWebDriver to catch event before finding any webelement, we could change it to WebDriver and implement ITestListener also
- properties file to read the locators and constants class to store the keys for the properties file
- driver related functions are separated from page related functions
- Used session to communicate with all layers in a framework
- Used ExtentReports to log and create report
- Used multiple interfaces to not to put all functions in one interface and make it messy as suite grows
- Used separate dataprovider class so that we dont write it in each test and also this way we can have different excel    	files for different dataprovider
- Made use of grid to run on different OS
- Shown how to read from tooltip on home page, we can include the temperature as input values from excel file also
- I have used properties file to keep all locators at one place, but I also showed the use of pageFactory init elements in one of the classes








## Folder Structure for more details
It is a maven project, pom.xml contains all dependencies

1. com.WeatherShopper.pages.application: this package contains a class for each page
All these classes extends WeatherShopperBasePage

2. com.WeatherShopper.base.pages: this package contains required function for each page
To segregate application related functions, there are two interfaces created
WeatherShopperApplicationPage interface has all application functions
WeatherShopperPage has functions required for each page class to communicate with driver, session, logging, validations

3. com.WeatherShopper.web: this is a web layer where all driver related functions are written
There are two interfaces WebConnector and WeatherShopperWebConnector which are created for not to put all functions in one interface
WeatherShopperValidationDriver class implements WebConnector interface and it has all validation functions
WeatherShopperDriver class extends WeatherShopperValidationDriver class and it has all driver related functions

4. com.WeatherShopper.session: WeatherShopperTestSession class "HAS A" webconnector and hence driver, reports etc are accessible to all the layers

5. com.WeatherShopper.listener: I have used EventFiringWebDriver instead of WebDriver to capture the event. WeatherShopperEventListener class has beforeFindBy method which gets fired before finding any webelement

6. com.WeatherShopper.constants: Constants class stores all the locator strategies so that we can change at one location if any locator changes. It also has keys, the corresponding values are stored in propeties file. I have used properties file to show how can we access values from properties

7. com.WeatherShopper.util: this package has Xls_Reader class to perform operations on excel file, we create an object of this class in TestBase class
DataUtil class reads the data from "Data.xls" file, it finds the testcase name and then number of rows till we get empty row and no of columns till we get empty column, It also has a function to check Runmodes of tests

8. ExtentManager class is used for report generation based on time, ExtentReport and ExtentTest classed are used to log information in the report

9. TestDataProvider class is created instead of creating dataprovider in each test, this was we can have multiple data provider with different input excel data

10. HomePageTest is created just to go to homepage and also to show how can we run multiple tests parallel, BuyBodyLotionTest is our E2E test which covers all scenarios from homepage to payment confirmation page. Both these tests are extending TestBase class

