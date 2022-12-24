package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PimPage {
	
    WebDriver driver;

    public PimPage(WebDriver driver){
        this.driver =driver;
    }
    
    By SearchByempName = By.xpath("//label[contains(text(),'Employee Name')]/parent::div/following-sibling::div");
    By SearchByempId =By.xpath("//label[contains(text(),'Supervisor Name')]/parent::div/following-sibling::div");
    By searchByemploymentStatus = By.xpath("//label[contains(text(),'Employment Status')]/parent::div/following-sibling::div");
    By clicksearbtn = By.xpath("//button[@type='submit']");
    By norecordfoundmsg =By.xpath("//span[contains(text(),'Records Found')]");

public WebElement SearchByName() {
	return driver.findElement(SearchByempName);
}
public WebElement SearchByEmpId() {
	return driver.findElement(SearchByempId);
}

public WebElement SearchByempStatus() {
	return driver.findElement(searchByemploymentStatus);
}
public WebElement ClickSearBtn() {
	return driver.findElement(clicksearbtn);
}
public String ValidateNoRecordFound() {
	return driver.findElement(norecordfoundmsg).getText();
}

}

