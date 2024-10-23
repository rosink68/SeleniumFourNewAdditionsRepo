package session344BrowserOptionClasses;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

	public WebDriver initializeBrowser(String browserName) throws MalformedURLException {
		
		@SuppressWarnings("rawtypes")
		AbstractDriverOptions options = null;
		
		if(browserName.equals("chrome")) {
			
			options = new ChromeOptions();
			options.setCapability("browserName", "chrome");
			
		} else if (browserName.equals("firefox")) {
			
			options = new FirefoxOptions();
			options.setCapability("browserName", "firefox");
			
		} else if (browserName.equals("edge")) {
			
			options = new EdgeOptions();
			options.setCapability("browserName", "MicrosoftEdge");
		}
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		driver.manage().window().maximize();
		
		return driver;

	}
}
