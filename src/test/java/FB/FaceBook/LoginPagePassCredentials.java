package FB.FaceBook;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Resources.Base;

public class LoginPagePassCredentials extends Base{

Robot rb;	
	public HashMap<String, String> testdatatologin()
	{
		HashMap<String, String>hm= new HashMap<String, String>();
		hm.put("1", "chinisrinathds@gmail.com&Srivishwanath@123");
		hm.put("2", "something&igave");
		return hm;
	}
			
	

	
	
	@Test
	public void enterusernameAndPassword() throws IOException, InterruptedException, AWTException
	{
		
	inintialize();
	
	
	//Excel code to fetch username and password
	
	String username= getExcelData(1, 0);
	String password=getExcelData(1, 1);
	LoginPage lp = new LoginPage(driver);
	lp.un().sendKeys(username);
	lp.pwd().sendKeys(password);
	lp.LoginButotn().click();
	getscreenshot("Logged in");
	
	
	
	//uncomment for hashmap code
	/*String data =testdatatologin().get("1");
	String[] arr= data.split("&");
	String username = arr[0];
	String password = arr[1];
	LoginPage lp = new LoginPage(driver);
	lp.un().sendKeys(username);
	lp.pwd().sendKeys(password);
	lp.LoginButotn().click();*/
 Thread.sleep(10000);
	rb= new Robot();
	rb.keyPress(KeyEvent.VK_TAB);
	rb.keyPress(KeyEvent.VK_TAB);
	rb.keyPress(KeyEvent.VK_TAB);
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	getscreenshot("Logged in successfully");
	
}
}
