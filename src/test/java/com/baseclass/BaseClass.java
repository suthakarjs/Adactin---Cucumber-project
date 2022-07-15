package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Suthakar JS
 * @description Class which consists some of reusable methods which helps to avoid the same code repetition 
 * @date 08-July-2022
 *
 */
public class BaseClass {

public static WebDriver driver;
	
/**
 * @description Method which is used to read datas from property files
 * @param key
 * @return String
 * @throws IOException
 * @date 08-July-2022
 */
public static String getPropertyFiles(String key) throws IOException {

	FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");

	Properties properties = new Properties();

	properties.load(stream);

	Object keyValue = properties.get(key);
	String value = (String) keyValue;
	return value;
}	


// b) browser launch 

/**
 * @description Method which is used to initiate the browser 
 * @param browser
 * @date 08-July-2022
 */
public static void browserChoice(String browser) {

	switch (browser) {
	case "chrome" : 
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	break;

	case "firefox" : 
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	break;

	case "edge" :  
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();	
	break;
	
	case "ie" : 
	WebDriverManager.iedriver().setup();
	driver = new InternetExplorerDriver();
	break;
	
	default :
		break;
	}
}


//	*) To load a URL
	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
		
// 1) To Launch Browsers by Web-Driver Managers
	
	// 2) for Chrome browser
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	// 3) for Firefox browser
	public void launchFireFox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	// 4) for IE browser
		public void launchIE() {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	
	// 5) for firefox browser
		public static void launchEdge() {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
// 6) To Maximize the window
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
// 7) To get Current URL from browser
		
		public String getWindowUrl() {
			String url = driver.getCurrentUrl();
			return url;
		}
		
// 8) To getText from browser		
		
		public String getText(WebElement element) {
			String text = element.getText();
			return text;
		}
		
// 9) To find locator by id()
		
		public static WebElement getLocatorById(String idAttributeValue) {
			WebElement locatorById = driver.findElement(By.id(idAttributeValue));
			return locatorById;
		}
		
// 10) To find locator by name()
		
		public static WebElement getLocatorByName(String nameAttributeValue) {
			WebElement locatorByName = driver.findElement(By.name(nameAttributeValue));
			return locatorByName;
		}		
		
// 11) To find locator by className()
		
		public static WebElement getLocatorByclassName(String classAttributeValue) {
			WebElement locatorByClass = driver.findElement(By.className(classAttributeValue));
			return locatorByClass;
		}	
		
// 12) To find locator by xpath()
		
		public static WebElement getLocatorByXpath(String xpath) {
			WebElement locatorByXpath = driver.findElement(By.xpath(xpath));
			return locatorByXpath;
		}		

// 13) To find locator by TagName()	
		
		public List<WebElement> getLocatorByTagname(String tagName) {
			List<WebElement> locatorByTagname = driver.findElements(By.tagName(tagName));
			return locatorByTagname;
		}
		
// 14) To insert a values in a textbox		
		
		public static void sendKeys(WebElement element,String keysToSend) {
			element.sendKeys(keysToSend);
		}
		
// 15) To click a button (or) a link
		
		public static void toClick(WebElement element) {
			element.click();
		}
		
// 15a) To clear a textbox
		
		public void toclear(WebElement element) {
			element.clear();
		}
		
// 16) To launch a website
		
		public void launchWebsite(String url) {
			driver.get(url);
		}
		
// 17) To close Windows
		
		// 13a) To close Current Window only
		public static void closeCurrentWindow() {
			driver.close();
		}
		
		// 13b) To close All windows 
		public static void closeAllWindows() {
			driver.quit();
		}
		
// 18) To get inserted values through attribute values
		
		// 14a) It's for 99% cases  
		public static String getByAttributeValue(WebElement element) {
			String attributeValue = element.getAttribute("value");
			return attributeValue;
		}
		
		// 14b) for that remaining 1% case
		public String getByAttributeValue(WebElement element,String attributeName) {
			String attributeValue = element.getAttribute(attributeName);
			return attributeValue;
		}
		
// 19) 	Launch Website by to()
		
		// 15a) Launch Url by passing String 
		public void toMethodByString(String url) {
			driver.navigate().to(url);	
		}
		
		// 15b) Launch Url by passing object
		public void toMethodByObject(String url) throws MalformedURLException {
			URL launch  = new URL(url);
			driver.navigate().to(launch);	
		}

// 20) Navigate - back  		
		
		public void navigateBack() {
			driver.navigate().back();
		}
		
// 21) Navigate - forward  		
		
		public void navigateForward() {
			driver.navigate().forward();;
		}		
		
// 22) Navigate - refresh the page  		
		
		public void navigateReload() {
			driver.navigate().refresh();;
		}		
		
// 		ACTIONS 			
// 	MOUSE ACTIONS : 	
		
// 23) 	To perform a Right Click 
		
		public void rightClick(WebElement element) {
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
		}
		
// 24) To perform a double click		
		public void doubleClick(WebElement element) {
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
		}
		
	// 25) To perform a click
		public void clickByAction(WebElement element) {
			Actions action = new Actions(driver);
			action.click(element).perform();
		}
		
// 26) Move a mouse cursor into a target 		
		
		public static void moveToTarget(WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
		
// 27) To perform a drag & drop operation		
		
		public void dragAndDrop(WebElement source,WebElement dest) {
			Actions action = new Actions(driver);
			action.dragAndDrop(source,dest).perform();
		}
		
		
// 		KEYBOARD ACTIONS :
// 28) Want to press and release a particular key		
		
//		public void keyEnter() {
//			action.keyDown(Keys.keys).perform();
//			action.keyUp(Keys.keys).perform();
//		}
		
// 29) 	Click & Insert a value by Action class 	
		
	// 24a) Insert a value by Action
		
		public void insertByAction(WebElement element,String value) {
			Actions action = new Actions(driver);
			action.sendKeys(element,value).perform();
		}
		
// 		ALERT INTERFACE	:
		
// 30) to click OK & CANCEL in Alert pop-up
		
	// 31) Click OK	
		public static void clickOkInAlert() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
	//	32) Click CANCEL	
		public void clickCancelInAlert() {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}	
// 33) to get text from alert menu
		
		public String textFromAlert() {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			return text;
		}
		
// 34) to insert a keys in alert's textboxes
		
		public void insertKeysInAlert(String keysToSend) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(keysToSend);
		}
		
// 		JAVA SCRIPT : (JS)	
		
// 35)	to insert a keys by JS		
		
		public void insertKeysByJs(String keysToSend,WebElement element ) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('value',"+keysToSend+")", element);
		}
		
// 36) get a enterted keys by JS		
		
		public Object getKeysByJs(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Object script = executor.executeScript("arguments[0].getAttribute('value')", element);
			return script;
		}
		
// 37) click a element by JS
		
		public void clickByJs(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element);
		}
		
// 38) scroll up & scroll down by JS		
		
	//	39) Scroll Up
		public void scrollUpbyJs(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(false)", element);
		}
		
	// 40) Scroll Down	
		public void scrollDownbyJs(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true)", element);
		}
		
		
//		DROP-DOWN :	(Using Select Class)
		
	// 41) 	to select a option in a dropdown by index 
		
		public void selectOptionByIndex(WebElement element,int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		
	// 42) 	to select a option in a dropdown by value
		
		public void selectOptionByValue(WebElement element,String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}	
		
	// 43) 	to select a option in a dropdown by text 
		
		public void selectOptionByText(WebElement element,String text) {
			Select select = new Select(element);
			select.selectByVisibleText(text);;
		}	
		
	// 44) to get all options from a drop-down	
		
		public List<String> getAllOptions(WebElement element) {
			Select select = new Select(element);
			List<WebElement> allOptions = select.getOptions();
			
			List<String> list = new ArrayList<String>();
			
			for (WebElement webElement : allOptions) {
				String text = webElement.getText();
				list.add(text);	
			}
			return list;
		}
		
	// 45) to get first selected option	
		
		public String getFirstSelectedOption(WebElement element) {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			String text = firstSelectedOption.getText();
			return text;
		}
		
	// 46) to get all selected options	
		
		public List<String> getAllSelectedOptions(WebElement element) {
			Select select = new Select(element);
			 List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			
			 List <String> list = new ArrayList<String>();
			 
			 for (int i = 0; i < list.size(); i++) {
				
				 WebElement webElement = allSelectedOptions.get(i);
				 String text = webElement.getText();
				 list.add(text);
			} 
			return list;
		}
		
	// 47) to chech is a dropdown multiple or not!	
		
		public boolean typeOfDropDown(WebElement element) {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			return multiple;
		}
		
	// 48) to de-select a option by index 	
		
		public void deSelectOptionByIndex(WebElement element,int index) {
			Select select = new Select(element);
			select.deselectByIndex(index);
		}
		
	// 49) to de-select a option by value
		
		public void deSelectOptionByValue(WebElement element,String value) {
			Select select = new Select(element);
			select.deselectByValue(value);
		}
		
	// 50) to de-select a option by text	
		
		public void deSelectOptionByText(WebElement element,String text) {
			Select select = new Select(element);
			select.deselectByVisibleText(text);
		}
		
	// 51) to de-select all the options
		
		public void deSelectAllOptions(WebElement element) {
			Select select = new Select(element);
			select.deselectAll();
		}
		
//		: WEB-TABLE :  
		
	// 52) to get Table Row 	
		
	public List<String> getwebTableRows(String element) {
		WebElement webElement = driver.findElement(By.id(element));
		List<WebElement> listOfElements = webElement.findElements(By.tagName("tr"));
			
		List <String> list = new ArrayList<String>();
			
		for (WebElement webElements : listOfElements) {
			String text = webElements.getText();
			list.add(text);
		}
	return list;
}
		
	// 53) to get all Table Datas	
		
	public List<String> getwebTableDatas(String element) {
	
		WebElement webElement = driver.findElement(By.id(element));
		List<WebElement> listOfElements = webElement.findElements(By.tagName("td"));
			
		List <String> list = new ArrayList<String>();
			
		for (WebElement webElements : listOfElements) {
			String text = webElements.getText();
			list.add(text);
		}
	return list;
}
		
	// 54) to get Table headings	
		
	public List<String> getwebTableHeading(String element) {
		
		WebElement webElement = driver.findElement(By.id(element));
		List<WebElement> listOfElements = webElement.findElements(By.tagName("th"));
			
		List <String> list = new ArrayList<String>();
			
		for (WebElement webElements : listOfElements) {
			String text = webElements.getText();
			list.add(text);
		}
	return list;
}
		
// 		: SCREENSHOT :
		
	// 55) 	take Screenshot
	
		public void takeScreenshot(String fileName) throws IOException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy h-m-s");
			Date date = new Date();
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File("D:\\GreensTech\\Assertion Task Screenshots\\"+fileName+"-"+dateFormat.format(date)+".jpg");
			FileUtils.copyFile(file, dest);
		}
		
//		: FRAMES :
		
	// 56) Switch into frame by Frame id	
		
		public void jumpToFrameById(String url,String id) {
			driver.get(url);
			driver.switchTo().frame(id);
		}
		
	// 57) Switch into frame by Frame name	
		
		public void jumpToFrameByName(String url,String name) {
			driver.get(url);
			driver.switchTo().frame(name);
		}
		
	// 58) Switch into frame by frame Webelement
		
		public void jumpToFrameByElement(String url,WebElement element) {
			driver.get(url);
			driver.switchTo().frame(element);
		}
		
	// 59) Get back to web content
		
		public void jumpOutFromFrame(String url,String id) {
			driver.get(url);
			driver.switchTo().frame(id);
			driver.switchTo().defaultContent();
		}
		
	// 60) Switch into frame by index	
		
		public void jumpToFrameByIndex(String url,int index) {
			driver.get(url);
			driver.switchTo().frame(index);
		}
		
//		: WINDOWS - HANDLING :
		
	// 61) Switch Windows by it's URL
		
		public void switchWindowByUrl(String url) {
			driver.switchTo().window(url);
		}
	
	// 62) Switch window by it's title 
		
		public void switchWindowByTitle(String title) {
			driver.switchTo().window(title);
		}

	// 63) Switch window by Window-Id from parent window to one child window
		
		public void switchWindowById() {
			String parentId = driver.getWindowHandle();
			Set<String> childId = driver.getWindowHandles();
			
			for (String string : childId) {
				if(!(string.equals(parentId))) {
					driver.switchTo().window(string);
				}
			}
		}
		
		
//		: WAIT - CONCEPT :
		
	// 64) Implicit Wait
		
public static void implicitWait(int time) {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
}
		
		
	//  EXPLICIT WAITS 	
		
	// 	WebDriver Wait

	static WebDriverWait driverWait;
	
	public void setWebDriverWaitDuration(int seconds) {
		driverWait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
	}
		
	// 65) Switch to Alert if present
		
public void alertIsPresent() {	
	driverWait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert();
}
		
	// 66) Element Selection State to be	
		
public void elementSelectionStateToBe(WebElement element,Boolean boolean1) {
	driverWait.until(ExpectedConditions.elementSelectionStateToBe(element, boolean1));			
}
		
	// 67) Element to be Clickable	
		
public static WebElement elementToBeClickable(WebElement element) {
	WebElement until = driverWait.until(ExpectedConditions.elementToBeClickable(element));
	return until;
}	
	
	// 68) Element To Be Selected	
		
public void elementToBeSelected(WebElement element) {
	driverWait.until(ExpectedConditions.elementToBeSelected(element));
}		
		
	// 69) Frame To Be Available and Switch To It	
		
public WebDriver frameToBeAvailableAndSwitchToIt(String locator,String frameLocator,int frame,WebElement element) {
	
	String loc = null;
	String loc1 = null;
	int frame1 = 0;
	WebDriver ret = null;
	
	if (loc != locator && loc1 == frameLocator) {
	WebDriver until = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	else if (loc == locator && loc1 != frameLocator) {
	WebDriver until = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	else if (frame1 != frame) {
	WebDriver until = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));	
	}
	else {
	WebDriver until = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));	
	}
return ret;

}

	// 70) Invisibility of the element located

public void invisibilityOfElementLocated(WebElement element) {
	
	Boolean until = driverWait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
}


	// 71) Inviaibility of Element with text

public void invisibilityOfElementWithText(WebElement element, String text) {
	Boolean until = driverWait.until(ExpectedConditions.invisibilityOfElementWithText((By) element, text));
}


	// 72) Presence of All Elements Located By

public void presenceOfAllElementsLocatedBy(WebElement element) {
	List<WebElement> until = driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) element));
}


	// 73) Presence of Elements Located

public void presenceOfElementsLocated(WebElement element) {
	WebElement until = driverWait.until(ExpectedConditions.presenceOfElementLocated((By) element));
}


	// 74) Text to be Present in Element

public void textToBePresentInElement(WebElement element, String text) {
	Boolean until = driverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
}


	//75) Text to be Present in Element Located

public void textToBePresentInElementLocated(WebElement element,String text) {
	Boolean until = driverWait.until(ExpectedConditions.textToBePresentInElementLocated((By) element, text));
}


	// 76) Text to be Present in Element Value

public void textToBePresentInElementValue(WebElement element,String text) {
	Boolean until = driverWait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
}

	// 76a) 

public void textToBePresentInElementValue(String text, WebElement element) {
	Boolean until = driverWait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
}


	// 77) Title is

public void titleIs(String title) {
	Boolean until = driverWait.until(ExpectedConditions.titleIs(title));
}

	
	// 78) Title Contains

public void titleContains(String title) {
	Boolean until = driverWait.until(ExpectedConditions.titleContains(title));
}


	// 79) Visibility Of

public void visibilityOf(WebElement element) {
	WebElement until = driverWait.until(ExpectedConditions.visibilityOf(element));
}


	// 80) Visibility of All Elements

public void visibilityOfAllElements(List<WebElement> elements) {
	List<WebElement> until = driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
}

	// 80a)
public void visibilityOfAllElements(WebElement elements) {
	List<WebElement> until = driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
}
	

// 81)	visibility of all elements located by

public void visibilityOfAllElementsLocatedBy(WebElement element) {
	List<WebElement> until = driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) element));
}


	// 82) visibility of element located

public void visibilityOfElementLoacated(WebElement element) {
	WebElement until = driverWait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
}



				//  EXCEL SHEET Accessing methods

	// 83) To getData from a Excel Sheet by Base-Class method
		
public String getData(String sheetName,int rowNo,int cellNo) throws IOException {
	
	String result = null;
	File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\FirstMavenProject\\ExcelSheets\\AdactinTaskSheet.xlsx");
		
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	CellType cellType = cell.getCellType();
	
	switch (cellType) {
	case STRING :
		result = cell.getStringCellValue();
	break;
		
	case NUMERIC :
		
		if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
			result = dateFormat.format(dateCellValue);
		}
		
		else {
			double numericCellValue = cell.getNumericCellValue();
			BigDecimal decimal = BigDecimal.valueOf(numericCellValue);
			result = decimal.toString();
		}
		
	break;
	
default:
	break;
	}
return result;	
}


	// 84)	To updateData in Excel Sheet by Base-Class method

public void updateData(String sheetName,int rowNo,int cellNo,String oldData,String newData) throws IOException {
	
	File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\FirstMavenProject\\ExcelSheets\\AdactinTaskSheet.xlsx");
	
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	String stringCellValue = cell.getStringCellValue();
	
	if (stringCellValue.equals(oldData)) {
		cell.setCellValue(newData);
	}
	
	FileOutputStream outputstream = new FileOutputStream(file);
	workbook.write(outputstream);	
}


	// 85) To insert a data at Excel sheet by create a new cell only not a row

public void insertData(String sheetName,int rowNo,int cellNo,String data) throws IOException {
	
	File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\FirstMavenProject\\ExcelSheets\\AdactinTaskSheet.xlsx");
	
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.createCell(cellNo);
	cell.setCellValue(data);
	FileOutputStream outputStream = new FileOutputStream(file);
	workbook.write(outputStream);	
}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
