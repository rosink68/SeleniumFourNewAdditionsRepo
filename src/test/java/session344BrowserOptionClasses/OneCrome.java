package session344BrowserOptionClasses;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class OneCrome extends Base {

	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		driver = initializeBrowser("chrome");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testOnChrome() {
		
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println(driver.getTitle() + " from chrome");
	}
}
