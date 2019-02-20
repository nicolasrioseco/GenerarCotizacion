package Utilidades;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
* Custom class to configure  and create the webdriver.
*/
public class CreateDriver {

    public static  WebDriver driver;
    
    /**
     * Get the Browser from the POM
     * @return 
     * @return 
     */
     public void initConfig(){    	 
        /****** Load the driver *******/
    	//va a buscar el driver para el navegador chrome
    	Proxy proxy = new Proxy();
    	proxy.setAutodetect(true);
    	//proxy.setHttpProxy("bcbct01:8080");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--start-maximized");
    	options.addArguments("--incognito");
    	DesiredCapabilities dc = DesiredCapabilities.chrome();
    	dc.setCapability(CapabilityType.PROXY, proxy);
    	dc.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
    	System.setProperty("webdriver.chrome.driver", Constantes.webdriver);
    	dc.setCapability(ChromeOptions.CAPABILITY, options);
    	driver = new ChromeDriver(dc);
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
    	driver.get("https://uiwebcore-qa2.cuoreleasing-desa.com");
    }
}