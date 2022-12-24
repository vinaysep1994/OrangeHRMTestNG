package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver =driver;
    }

    By txtDashboard = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']");
    By pim = By.xpath("//a[contains(@href,'/pim/viewPimModule')]");

    public String getDashboard(){
        return driver.findElement(txtDashboard).getText();
    }
    
    public void ClickPIM() {
    driver.findElement(pim).click();
   }
    public HomePage getPIMMenu() {
    	this.ClickPIM();
        return new HomePage(driver);
    }
     

}
	