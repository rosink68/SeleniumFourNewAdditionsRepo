package session345PrintPageToPDFUsingPrint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.print.PrintOptions;


public class PrintPageToPDFUsingPrintDemo {

	public static void main(String[] args) throws IOException {
		
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		
		driver.get("https://the-internet.herokuapp.com/");
		
		// die geöffnete Seite in ein PDF speichern
		Pdf pdf = ((PrintsPage)driver).print(new PrintOptions());
		
		// Parameter: 
		// 1. Speicherort (PDF wird direkt unter Projekt kopiert)
		// 2. OutputType (PDF wird konvertiert)
		Files.write(Paths.get("./InternetHerokuHomePage.pdf"), 
				OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
		
		driver.quit();
	}

}
