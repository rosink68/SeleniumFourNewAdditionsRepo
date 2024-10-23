package session346EmulatingMobileDevice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.emulation.Emulation;

public class EmulatingMobileDeviceDemo {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();

		// Einstellen IPhone 12 Pro Ansicht
		
		/**
		 * Das ist die besser Methode zum Emulieren des IPhone Pro 12!!!!!!!!!
		 * 
		// Parameters siehe https://chromedevtools.github.io/devtools-protocol/tot/Emulation/#method-setDeviceMetricsOverride
		devTools.send(Emulation.setDeviceMetricsOverride(
				390, // width
				844, // height
				100, // scale factor <== Zooming level
				true, // mobile device
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty()));
		*/
		
		// Alternative, wenn für devTools.send(Emulation.setDeviceMetricsOverride Fehler angezeigt wird
		Map<String, Object> dm = new HashMap<String, Object>();
		dm.put("width", 390);
		dm.put("height", 844);
		dm.put("deviceScaleFactor", 100);
		dm.put("mobile", true);
//		dm.put("scale", Optional.empty());
//		dm.put("screenWidth", Optional.empty());
//		dm.put("screenHeight", Optional.empty());
//		dm.put("positionX", Optional.empty());
//		dm.put("positionY", Optional.empty());
//		dm.put("dontSetVisibleSize", Optional.empty());
//		dm.put("screenOrientation", Optional.empty());
//		dm.put("viewport", Optional.empty());
//		dm.put("displayFeature", Optional.empty());
//		dm.put("devicePosture", Optional.empty());
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", dm);

		driver.get("https://www.selenium.dev/");
	}

}
