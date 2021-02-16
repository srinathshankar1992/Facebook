package FB.FaceBook;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Resources.Base;

public class Windowhandlers extends Base {

	
	@Test
	public void windowhandler() throws IOException, InterruptedException
	{
	
		inintialize();
		driver.get("https://jqueryui.com/");
		
		
		//frames
		
		WebElement droppable = driver.findElement(By.xpath("//a[contains(text(),'Droppable')]"));
		droppable.click();
		
		WebElement wec= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(wec);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		driver.switchTo().defaultContent();
		
		List<WebElement> iterations=driver.findElements(By.xpath("(//aside[@class='widget'])[1]/ul/li/a"));
		//Actions act = new Actions(driver);
		for(WebElement we:iterations)
		{
			String abc =we.getText();
			System.out.println(abc);
			we.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
			
		}
		
		
		
		
		
		
		
		
		String currentWindow=driver.getWindowHandle();
		
		Set<String>windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext())
		{
			String getid=it.next();
			driver.switchTo().window(getid);
			System.out.println(driver.getTitle());
		}
		
		driver.switchTo().window(currentWindow);
		
	}
}
