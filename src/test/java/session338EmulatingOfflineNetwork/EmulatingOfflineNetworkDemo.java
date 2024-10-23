package session338EmulatingOfflineNetwork;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.ConnectionType;
import org.openqa.selenium.edge.EdgeDriver;

public class EmulatingOfflineNetworkDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		DevTools devTools = ((EdgeDriver)driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.emulateNetworkConditions(
				true, 	// Simulates being offline (not online)
				150, 	// Simulates a latency of 150 milliseconds.
				2500, 	// Simulates a download throughput of 2500 megabits per second.
				2000, 	// Simulates an upload throughput of 2000 megabits per second.
				Optional.of(ConnectionType.WIFI), // nachahmen WIFI
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty()));

		try {
			driver.get("https://www.google.de/");
			
		} catch (Exception e) {

			driver.findElement(By.id("diagnose-button")).click();
		}
	}

}
