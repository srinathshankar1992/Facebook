package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By username=By.id("email");
	By password = By.id("pass");
	By loginButton =By.xpath("//button[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public WebElement un()
	{
	return driver.findElement(username);
	}
	
	public WebElement pwd()
	{
	return driver.findElement(password);
	}
	
	public WebElement LoginButotn()
	{
	return driver.findElement(loginButton);
	}
	
	
}
