package session334UsingBiDiAPIs;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLevelAuthenticationDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Browser level Authentication
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("the-internet.herokuapp.com");
		
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("admin", "admin"));
		
		//Browser identification
		driver.get("https://the-internet.herokuapp.com/basic_auth");
	}

}
