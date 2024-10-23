package session327ReativeLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorToRightOf {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		WebElement searchBoxField = driver.findElement(By.name("q"));
		
		// Finden des Search-Buttons mit Relative Locators toRightOf: rechts neben dem Suchfeld ist 
		// der Search-Button (im HTML-Code ist das <input>-Tag direkt unter dem Searchbox-Field)
		driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(searchBoxField)).click();
	}
}
