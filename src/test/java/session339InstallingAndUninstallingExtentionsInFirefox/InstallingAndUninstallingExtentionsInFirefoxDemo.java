package session339InstallingAndUninstallingExtentionsInFirefox;

import java.nio.file.*;

import org.openqa.selenium.firefox.FirefoxDriver;

public class InstallingAndUninstallingExtentionsInFirefoxDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// funktioniert nicht, wie im Kurs entwickelt, da noch eine Zwischenabfrage kommt
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		Path path = Paths.get("C:\\Users\\rosink\\Downloads\\selenium_ide-3.17.4.xpi");

		Thread.sleep(5000);

		String extensionIdString = driver.installExtension(path);

		Thread.sleep(5000);

		driver.uninstallExtension(extensionIdString);
	}

}
