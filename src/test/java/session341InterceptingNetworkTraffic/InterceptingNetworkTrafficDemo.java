package session341InterceptingNetworkTraffic;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;

public class InterceptingNetworkTrafficDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		
		devTools.createSession();

		// parameters
		// maxTotalBufferSize		integer		Buffer size in bytes to use when preserving network payloads (XHRs, etc). 
		// maxResourceBufferSize	integer		Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc). 
		// maxPostDataSize			integer		Longest post body size (in bytes) that would be included in requestWillBeSent notification
		devTools.send(Network.enable(
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), 
				request -> {
					
					System.out.println("Request URL: " + request.getRequest().getUrl());
					System.out.println("Request Method: " + request.getRequest().getMethod());;
				});
		
		driver.get("http://the-internet.herokuapp.com/broken_images");
		
		driver.quit();
	}

}
