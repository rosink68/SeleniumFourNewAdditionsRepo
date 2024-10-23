package session327ReativeLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorToLeftOfAndBelow {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		WebElement labelText = driver.findElement(By.xpath("//h2[normalize-space()='Buttons with same name attribute values']"));
				
		// Finden des Submit-Buttons mit Relative Locators toLeftOf und below: links neben dem Login-Button 
		// und unter dem Labeltext 'Buttons with same name attribute values' ist der Submit-Button (im  
		// HTML-Code ist das <button>-Tag direkt über dem Login-Button und unter der h2 mit dem Text)
		String textOnButton = driver.findElement(RelativeLocator.with(By.tagName("button")).toLeftOf(loginButton).below(labelText)).getText();
		System.out.println("Text on Button: " + textOnButton);
		
		driver.quit();
	}
}
