package Automation.OrangeHRM;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PimPage;
import resources.base;

public class PimTest extends base {
	public WebDriver driver;

@BeforeTest
public void initialize() throws IOException
{
  driver =initializeDriver();
  driver.get(prop.getProperty("url"));
  HomePage homepage =new HomePage(driver);
  LoginPage lp = new LoginPage(driver);
  homepage= lp.entervalidCredentials("Admin", "admin123");
  homepage.getPIMMenu();

}
@Test(enabled=false)
public void SearchEmployeeByName() {
	PimPage pimpage = new PimPage(driver);
	pimpage.SearchByName().sendKeys("ram");
	pimpage.ClickSearBtn().click();
	Assert.assertEquals(pimpage.ValidateNoRecordFound(), "No Records Found");
}
@Test(enabled=false)
public void SearchEmployeeByNameAndId() {
	PimPage pimpage = new PimPage(driver);
	pimpage.SearchByName().sendKeys("ram");
	pimpage.SearchByEmpId().sendKeys("Oran001");
	pimpage.ClickSearBtn().click();
	Assert.assertEquals(pimpage.ValidateNoRecordFound(), "No Records Found");
}
@Test(priority=3)
public void SrchEmployeeByNameIdStatus() {
	PimPage pimpage = new PimPage(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	pimpage.SearchByName().sendKeys("ram");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	pimpage.SearchByEmpId().sendKeys("Oran001");
	//pimpage.SearchByempStatus().click();

	Actions act =new Actions(driver);
	WebElement status = pimpage.SearchByempStatus();
    //act.moveToElement(status).click().build().perform();
    act.clickAndHold(status).build().perform();


	//pimpage.ClickSearBtn().click();
	//Assert.assertEquals(pimpage.ValidateNoRecordFound(), "No Records Found");
}


}
