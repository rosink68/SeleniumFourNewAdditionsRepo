package session337EmulatingSlowInternet;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.ConnectionType;
import org.testng.annotations.*;


public class EmulatingSlowInternetDemo {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void normalSpeed() {
		
		driver.get("https://www.amazon.de/");
	}


	@Test(priority = 2)
	public void slowSpeed() {
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		
		devTools.createSession();
		
		// Parameters
		// offline				boolean			True to emulate internet disconnection.
		// latency				number			Minimum latency from request sent to response headers received (ms).
		// downloadThroughput	number			Maximal aggregated download throughput (bytes/sec). -1 disables download throttling.
		// uploadThroughput		number			Maximal aggregated upload throughput (bytes/sec). -1 disables upload throttling.
		// optional: connectionType		ConnectionType	Connection type if known.
		// optional: packetLoss			number			WebRTC packet loss (percent, 0-100). 0 disables packet loss emulation, 100 drops all the packets.
		// optional: packetQueueLength	integer			WebRTC packet queue length (packet). 0 removes any queue length limitations.
		// optional: packetReordering	boolean			WebRTC packetReordering feature. 
		devTools.send(Network.emulateNetworkConditions(
				false, 	// Simulates being online (not offline)
				150, 	// Simulates a latency of 150 milliseconds.
				2500, 	// Simulates a download throughput of 2500 megabits per second.
				2000, 	// Simulates an upload throughput of 2000 megabits per second.
				Optional.of(ConnectionType.CELLULAR2G), // nachahmen eines sehr langsamen Internets
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty()));
		
		driver.get("https://www.amazon.de/");
	}
}
