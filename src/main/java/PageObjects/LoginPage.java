package PageObjects;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;
import PageObjects.HomePage;

public class LoginPage extends base{
	
    WebDriver driver;
    
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private static final By txtUsername = By.xpath("//input[@name='username']");
    private static final By txtPassword = By.xpath("//input[@name='password']");
    private static final By btnLogin = By.xpath("//button[@type='submit']");
    private static final By invalidMessage = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]");
    private static final By requiredalert = By.xpath("//form[@class='oxd-form']/div/div/span");
    
    public void typeUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }
    public void typePassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }
    public String errorMessage()
    {
    	 return driver.findElement(invalidMessage).getText();
    }
    public String requiredAlert()
    {   
    	return driver.findElement(requiredalert).getText();
    }
    public HomePage entervalidCredentials(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        this.clickLogin();
        return new HomePage(driver);
    }
    public void enterInvalidCredentials(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        this.clickLogin();
    }
}