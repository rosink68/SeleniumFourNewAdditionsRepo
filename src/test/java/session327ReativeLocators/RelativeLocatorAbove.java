package session327ReativeLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


public class RelativeLocatorAbove {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		// es gibt zwar 2 Elemente mit "samename", aber es wird das 1. genommen
		WebElement submitButton = driver.findElement(By.name("samename"));
				
		// Finden des Labeltextes 'Buttons with same name attribute values' mit Relative Locator above: über  
		// dem Submit-Button (im HTML-Code ist das <h2>-Tag mit dem Text direkt über dem Submit-Button)
		String labelText = driver.findElement(RelativeLocator.with(By.tagName("h2")).above(submitButton)).getText();
		System.out.println("Text h2: " +labelText);
		
		driver.quit();
	}
}
