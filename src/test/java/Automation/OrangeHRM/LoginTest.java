package Automation.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import java.time.Duration;
import java.util.List;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import PageObjects.LoginPage;
import PageObjects.HomePage;

import resources.base;

public class LoginTest extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
      driver =initializeDriver();
	}
	
	@Test(priority = 6)
	public void loginToTheSystemWithValidCredentials() {
		driver.get(prop.getProperty("url"));
		HomePage homepage =new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		System.out.println("Browser is loading");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage= lp.entervalidCredentials("Admin", "admin123");
        Assert.assertTrue(homepage.getDashboard().contains("Dashboard"));
	}
	@Test(priority = 5)
	public void invalidUsernameWithValidPassword() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.enterInvalidCredentials("dmin", "admin123");
        Assert.assertEquals(lp.errorMessage(), "Invalid credentials");
	}
	@Test(priority = 4)
	public void invalidUsernameWithInValidPassword() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.enterInvalidCredentials("dmin", "admin12345");
        Assert.assertEquals(lp.errorMessage(), "Invalid credentials");
	}
	
	@Test(priority = 3)
	public void validUsernameWithInValidPassword() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.enterInvalidCredentials("Admin", "1admin123");
        Assert.assertEquals(lp.errorMessage(), "Invalid credentials");
	}
	
	@Test(priority = 2)
    public void emptyUsername() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.enterInvalidCredentials("","admin123");
        Assert.assertEquals(lp.requiredAlert(),"Required");
    }
    @Test(priority = 1)
    public void emptyPassword() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.enterInvalidCredentials("Admin","");
        Assert.assertEquals(lp.requiredAlert(),"Required");
    }
    @AfterTest
	public void teardown()
	{
		driver.close();
	}
}


