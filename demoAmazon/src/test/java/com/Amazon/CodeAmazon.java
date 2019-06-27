package com.Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodeAmazon {
	
	WebDriver driver = new ChromeDriver();
	Actions a = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	public static String getProperty(String key) {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\demoAmazon\\demoAmazon\\configFile\\config.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return prop.getProperty(key);
	}
	
	public void getscreenshot() throws Exception {
		GregorianCalendar calendar = new GregorianCalendar();
		int second = calendar.get(Calendar.SECOND);
		int minute = calendar.get(Calendar.MINUTE);
		int date = calendar.get(Calendar.DATE);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File("C:\\Users\\pc\\eclipse-workspace\\Screenshots\\Screenshot" + date + minute + second + ".png"));
	}
	
	

	public void url()
	{
		driver.manage().window().maximize();
	    driver.get(getProperty("Url"));
	}
	
	public void signIn() throws Exception
	{
		try {
			a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Hello')]"))).build().perform();
			driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']/a/span[text()='Sign in']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		getscreenshot();
	}
	
	public void credentials(String arg1, String arg2)
	{
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(arg1);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.findElement(By.xpath("//*[@id=\'ap_password\']")).sendKeys(arg2);
	}
	public void credentialProp() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(getProperty("username"));
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.findElement(By.xpath("//*[@id=\'ap_password\']")).sendKeys(getProperty("password"));
	    getscreenshot();
	}
	
	public void clkLogin() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\'signInSubmit\']")).click();
		getscreenshot();
	}
	
	public void success() throws Exception
	{
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String url = driver.getCurrentUrl();
		if (url.equals(getProperty("verifyUrl"))) {
			System.out.println(url);
		} else {
			Assert.fail("HomePage is not Loaded");	
		}
		getscreenshot();
	}
	
	public void signOut()
	{
		try {
			Actions signout = a.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hello')]"))));
			signout.build().perform();
			driver.findElement(By.xpath("//a[@id='nav-item-signout']/span[text()='Sign Out']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		driver.close();
	}
	

	public void enterProduct() throws Exception
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(getProperty("searchName"));
		getscreenshot();
		//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
	}
	
	public void clkSearch()
	{
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	
	public void clkProduct()
	{
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='a-fixed-left-grid-col a-col-left'])[1]")));
		element.click();
	}
	
	String ProdTitle;
	public void addCart() {
		ProdTitle=  driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
		System.out.println(ProdTitle);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	}
	
	public void cartTab() throws Exception
	{
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		getscreenshot();
	}
	
	
	public void compareProd() throws Exception
	{
		try {
			WebElement prod = driver.findElement(By.xpath("//div[@class='a-row']/h2"));
			String compareProd = prod.getText();
			if (compareProd.equals("Shopping Cart")) {
				System.out.println(compareProd);
			} else {
				Assert.fail("Product is not Added");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		getscreenshot();
		
}
	
	public void clkAmazonPay()
	{
		driver.findElement(By.xpath("//div/a[text()='Amazon Pay']")).click();
	}
	
	public void clkViewStmt()
	{
		driver.findElement(By.xpath("(//a[@class='a-link-normal']/div[@class='a-section a-spacing-small'])[2]")).click();
	}
	
	public void stmtDetails() throws Exception
	{
		WebElement Stmt = driver.findElement(By.xpath("//h1[@class='a-size-large a-text-left balance-heading']/span"));
		String st = Stmt.getText();
		getscreenshot();
		if (st.equals("Amazon Pay balance statement")) {
			System.out.println(st);
		} else {
			Assert.fail("Statement is not Loaded");	
		}
	}
	String delProduct;
	public void Delete() throws Exception
	{	
		try {
			delProduct = driver.findElement(By.xpath("(//span[@class='a-size-medium sc-product-title a-text-bold'])[1]")).getText().substring(0,5);
			driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
			System.out.println(delProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getscreenshot();
	}
	
	public void removeProduct() throws Exception
	{
		Thread.sleep(5000);
		WebElement rmve = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-action='delete']/span/a)[1]")));
		String remove = rmve.getText().substring(0,5);
		System.out.println(remove);
		if (remove.equals(delProduct)) {
			System.out.println(remove);
		} else {
			Assert.fail("Product is not removed");	
		}		
		getscreenshot();	
	}
	
	
	public void newAddress()
	{
		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Hello')]"))).build().perform();
		driver.findElement(By.xpath("//span[text()='Your Account']")).click();
		driver.findElement(By.xpath("//img[@alt='Your Addresses']")).click();
		driver.findElement(By.xpath("//div[@id='ya-myab-plus-address-icon']")).click(); ////h2[text()='Add address']
		
	}
	
	public void addValue() throws IOException, InterruptedException
	{
		
		ExcelRead.readExcel("Sheet1");
		
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys(ExcelRead.Fullname);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys(ExcelRead.Mobilenumber);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys(ExcelRead.Pincode);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys(ExcelRead.Streetaddress1);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']")).sendKeys(ExcelRead.Streetaddress2);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-landmark']")).sendKeys(ExcelRead.Landmark);
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("(//*[@data-action='a-dropdown-button'])[3]")).click();
		driver.findElement(By.xpath("//a[@id='dropdown1_1']")).click();

		
	}	
	public void clkAddress()
	{
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
	}

	public void clkDel()
	{
		driver.findElement(By.xpath("//a[@id='ya-myab-address-delete-btn-3']")).click();
		driver.findElement(By.xpath("//div[@id='a-popover-content-5']//form[@action='/a/addresses/delete']")).click();
		
	}

	public void assDelete()
	{
		WebElement add = driver.findElement(By.xpath("//h4[text()='Address deleted']"));
		String assDelete = add.getText();
		if(assDelete.equals("Address deleted")){
			System.out.println(assDelete);
		}
		else {
			Assert.fail("Address is not deleted");
		}
			
	}
	
}







