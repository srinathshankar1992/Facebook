package Resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {

	public static com.aventstack.extentreports.ExtentReports extent;
	
	
	public static com.aventstack.extentreports.ExtentReports getextentReportHere()
	{
		
		ExtentSparkReporter ext = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\extentreport.html");
        ext.config().setDocumentTitle("FaceBookAutomation");
        ext.config().setReportName("srinath shankar");
        
        
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(ext);
        extent.setSystemInfo("Tester", "Srinath shankar");
        return extent;
        
	}
	
}
