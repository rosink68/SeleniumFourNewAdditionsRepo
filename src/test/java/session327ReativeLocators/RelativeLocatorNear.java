package session327ReativeLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorNear {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		WebElement searchBoxField = driver.findElement(By.name("q"));
		
		// Finden des Search-Buttons mit Relative Locators near: der Suchbutton ist rechts neben (near) dem Suchfeld  
		// (im HTML-Code ist das <input>-Tag mit der class="gsc-search-button" direkt unter dem Searchbox-Field)
		// near mit einem Parameter bedeutet, dass KEIN Abstand (0 Pixel) zwischen dem Searchbox-Field und dem Search-Button ist
//		driver.findElement(RelativeLocator.with(By.className("gsc-search-button")).near(searchBoxField)).click();

		// near mit einem Parameter bedeutet, dass der Abstand zwischen dem Searchbox-Field und dem Search-Button 100 Pixel ist
		driver.findElement(RelativeLocator.with(By.className("gsc-search-button")).near(searchBoxField, 100)).click();
	}
}
