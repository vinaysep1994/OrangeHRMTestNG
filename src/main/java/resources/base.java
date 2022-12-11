package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		
	prop= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Java-Selenium\\OrangeHRM\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	
	String browserName=prop.getProperty("browser");
	System.out.println("browser");
	

	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	else if (browserName.equals("firefox"))
	{
		 driver= new FirefoxDriver();
	}
	else if (browserName.equals("IE"))
	{
//		IE code
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
	}

}