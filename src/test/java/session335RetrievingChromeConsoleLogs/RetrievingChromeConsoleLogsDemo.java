package session335RetrievingChromeConsoleLogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.log.Log;


public class RetrievingChromeConsoleLogsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		
		// create session
		devTools.createSession();
		
		// execute commands
		devTools.send(Log.enable()); 
		devTools.addListener(Log.entryAdded(), 
				logEntry -> {
					System.out.println("Log: " + logEntry.getText());
					System.out.println("Level: " + logEntry.getLevel());
				});

		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.quit();
		
	}

}
