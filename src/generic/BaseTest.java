package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	
	public String url=Utility.getPropertyValue(CONFIG_PATH,"URL");
	public String ITO=Utility.getPropertyValue(CONFIG_PATH,"ITO");
	public long l=Long.parseLong(ITO);
	
	static{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip,@Optional("chrome")String browser){
		driver=Utility.openBrowser(ip, browser);
		driver.manage().timeouts().implicitlyWait(l,TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(){
		driver.quit();
	}
}










