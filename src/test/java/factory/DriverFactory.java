package factory;

import com.sun.media.sound.SF2InstrumentRegion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory
{

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    public WebDriver initDriver(String browser){
        System.out.println("The browser is: " +browser);
        if(browser.equals("chrome")){
            System.out.println("It is Chrome");
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if (browser.equals("firefox"))
        {
            System.out.println("This is Firefox");
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else
        {
            System.out.println("Please pass correct browser value:"+browser);
        }
       getWebDriver().manage().deleteAllCookies();
getWebDriver().manage().window().maximize();
return getWebDriver();
    }
public static WebDriver getWebDriver()
{
    System.out.println("In the getWebDriverMethod");
    return tlDriver.get();

}}
