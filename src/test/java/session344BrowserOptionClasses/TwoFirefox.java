package session344BrowserOptionClasses;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TwoFirefox extends Base {

	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		driver = initializeBrowser("firefox");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testOnFirefox() {
		
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println(driver.getTitle() + " from firefox");
	}
}
