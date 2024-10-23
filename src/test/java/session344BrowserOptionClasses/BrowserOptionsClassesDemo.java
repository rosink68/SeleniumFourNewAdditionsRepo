package session344BrowserOptionClasses;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserOptionsClassesDemo {

	public static void main(String[] args) throws MalformedURLException {
		
		// deprecated
		// DesiredCapabilities dc = new DesiredCapabilities();
		// dc.setCapability("browserName", "chrome");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserName", "chrome");
		chromeOptions.setCapability("platformName", "Windows 11");
		
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		System.out.println("Title of application: " + driver.getTitle());
		
		driver.quit();
	}

}
