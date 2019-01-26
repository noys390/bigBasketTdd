package qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.testReporting.webEventHandler;

public class basketBase {

	
	public static WebDriver driver;
	public static Properties prop;	


 public void initProp() {
	 
	try{
		prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\seleniumwork\\OrangeFramework\\workspace\\MavenBigBasketTDD\\src\\main\\java\\config.properties");
		prop.load(ip);			
	} catch (Exception e) {}
	
 }
	
 public static void initBrowser(){
	 
	 
	 String browserName = prop.getProperty("browser");
	   if (browserName.equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver", "D:\\seleniumwork\\OrangeFramework\\drivers\\chromedriver.exe");
		   driver = new ChromeDriver();		   
	   }		
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\seleniumwork\\OrangeFramework\\drivers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	   
		else if(browserName.equals("opera")){			
			System.setProperty("webdriver.opera.driver", "D:\\seleniumwork\\OrangeFramework\\drivers\\operadriver.exe");	
			driver = new OperaDriver();
		}
	   
//	   EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver); 
//       webEventHandler handler = new webEventHandler();
//       eventDriver.register(handler);
//	   driver = eventDriver;
	   

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);			
		
	}	

}
