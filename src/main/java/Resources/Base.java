package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public Properties prop;
	
    public static WebDriver driver;
    
	public WebDriver inintialize() throws IOException, InterruptedException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\details.properties");
		prop= new Properties();
		prop.load(fis);
		
		String browsername = prop.getProperty("Browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get(prop.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			return driver;
		}

		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			//driver.get(prop.getProperty("URL"));
			//System.out.println(driver.getTitle());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			return driver;
		}
		
		return driver;
	}
	
	public void getscreenshot(String destination) throws IOException
	{
		TakesScreenshot tks = (TakesScreenshot)driver;
		File src =tks.getScreenshotAs(OutputType.FILE);
		org.openqa.selenium.io.FileHandler.copy(src, new File(System.getProperty("user.dir")+"\\Screenshots\\"+destination+".png"));
		
	}
	
	public String getExcelData(int rowindex, int cellindex) throws IOException
	{
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\Data\\Data.xls");
		HSSFWorkbook hb = new HSSFWorkbook(fis);
		HSSFSheet sh = hb.getSheet("Sheet1");
		HSSFRow hr = sh.getRow(rowindex);
		HSSFCell cell = hr.getCell(cellindex);
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(cell);
		return data;
		}
	
	public void click (WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click",element);
		
	}
	
}
