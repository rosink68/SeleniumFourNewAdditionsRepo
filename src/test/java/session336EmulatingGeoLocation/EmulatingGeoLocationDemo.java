package session336EmulatingGeoLocation;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v127.emulation.Emulation;


public class EmulatingGeoLocationDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Emulation.setGeolocationOverride(
                Optional.of(52.5043),
                Optional.of(13.4501),
                Optional.of(1)));
		
		driver.get("https://my-location.org/");
	}

}
