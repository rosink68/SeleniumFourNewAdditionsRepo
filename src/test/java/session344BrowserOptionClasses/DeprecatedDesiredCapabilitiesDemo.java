package session344BrowserOptionClasses;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeprecatedDesiredCapabilitiesDemo {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserName", "chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		System.out.println("Title of application: " + driver.getTitle());
		
		driver.quit();
	}

}
