package variosConcepts;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginTest2 {
	
	
	WebDriver driver;
	@Before
	public void init () {
		
		System.setProperty("webdriver.chrome.driver", "Webdriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginTest () {
		
		//Storing in WebElement class
		WebElement USER_NAME_ELEMNT= driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_ELEMNT= driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTOON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		//storing in class
		
		By USER_NAME_FIELD =By.xpath("//*[@id=\"username\"]");
	    By PASSWORD_FIELD= By.xpath("//*[@id=\"password\"]");
	    By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	    By DASHBOARD_HEADER_FIELD=By.xpath("//h2[contains(text(), ' Dashboard ')]");
	     
		//driver.findElement(USER_NAME_FIELD).sendKeys("TEST 1 2");

		
//		USER_NAME_ELEMNT.sendKeys("demo@techfios.com");
//		PASSWORD_ELEMNT.sendKeys("abc123");
//		SIGNIN_BUTOON_ELEMENT.click();
		
		 
		
	    USER_NAME_ELEMNT.clear();
	    driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
	    driver.findElement(PASSWORD_FIELD).sendKeys("abc1234");
	    driver.findElement(SIGNIN_BUTTON_FIELD).click();
	    
		 boolean pageTitleDisplayStatus ;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), ' Dashboard ')]"));
			pageTitleDisplayStatus = true;
		}
		
		catch(Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
			
		}
	    
	  //Explicit wait
		//WebDriverWait wait = new WebDriverWait(driver,15);
		
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));
		
		//WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), ' Dashboard ')]"));
	    
	//	Assert.assertTrue("Dashboard page not found ", DASHBOARD_HEADER_ELEMENT.isDisplayed());
        Assert.assertTrue("Dashboard page not found", pageTitleDisplayStatus);
	}

}
