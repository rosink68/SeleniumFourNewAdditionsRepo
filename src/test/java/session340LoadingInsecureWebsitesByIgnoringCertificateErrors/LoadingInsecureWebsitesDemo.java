package session340LoadingInsecureWebsitesByIgnoringCertificateErrors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.security.Security;

public class LoadingInsecureWebsitesDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		
		devTools.createSession();
		
		// die Sicherheit enablen, da sonst die Seite nicht geöffnet wird
		// statt dessen wird "Dies ist keine sichere Verbindung" angezeigt
		devTools.send(Security.enable());
		
		// Aktivieren/deaktivieren Sie, ob alle Zertifikatsfehler ignoriert werden sollen.
		devTools.send(Security.setIgnoreCertificateErrors(true)); // true - ignorieren der Zertifikat-Errors
		
		// für die msg spring hier der Zscaler an!!!!!!!!!!!
		driver.get("https://expired.badssl.com/");
	}

}
