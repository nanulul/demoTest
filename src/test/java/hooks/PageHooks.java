package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.util.Properties;

public class PageHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties property;
    @Before(order =0)
    public void getPropery() {
        configReader = new ConfigReader();
        property = configReader.initProperties();
    }
    @Before(order = 1)
    public  void launchBrowser() {
        String browserName = property.getProperty("browser");
        driverFactory = new DriverFactory();
      driver = driverFactory.initDriver("chrome");
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();

    }
    @After(order =1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {

            String screenshotName = scenario.getName().replaceAll(" "," _");
        byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath,"image/png", screenshotName);
        }
    }
}
