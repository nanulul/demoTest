package util;

import org.junit.rules.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
    Actions action;

    public void mouseHover(WebElement element, WebDriver driver) {
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clear(WebElement element) {
        element.clear();
    }
    public boolean waitforElementVisible(WebElement element, WebDriver driver )
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
    }catch (Exception t){
            throw t;
        }}

    public void sendtext(String text, WebElement element) {
        element.sendKeys(text);
    }
    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    public void selectByVisibleText(WebElement selectSize, String text) {
        Select s = new Select(selectSize);
        s.selectByVisibleText(text);

    }

    public String getText(WebElement element, WebDriver driver){
        String text= null;
    try {

        text = element.getText();
        System.out.println("Expected text" + text);
    }
    catch (NoAlertPresentException e) {
        System.out.println("No text present");
    }return text;
    }



    public void clickUsingJavaScript(WebElement element, WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public boolean validateText(WebDriver driver, WebElement element, String expectedText) {
        String actualText = element.getText();
        if(actualText.equals(expectedText))
        { return true;
    }return  false;
    }
}


