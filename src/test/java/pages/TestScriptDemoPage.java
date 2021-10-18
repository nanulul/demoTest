package pages;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.SeleniumHelper;

import java.util.List;

public class TestScriptDemoPage {
    private WebDriver driver;

    //locators
    private By homeTab = By.id("menu-item-309");
    private By saleTab = By.id("menu-item-306");
    private By shopTab = By.id("menu-item-310");
    private By AboutUs = By.id("menu-item-307");
    private By Contact = By.id("menu-item-308");
    private By sortOrder = By.name("orderby");
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=23]")
    WebElement topPantsUpperWishList;
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=24]")
    WebElement womensDressWishList;
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=22]")
    WebElement bikiniWishList;
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=20]")
    WebElement singleShirtWishList;
    @FindBy(xpath = "//table/tbody[@class='wishlist-items-wrapper']")
    WebElement wishListtable;

    @FindBy(xpath = "//*[@id='site-content']/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[3]/a[1]/img")
    WebElement singleShirt;

    @FindBy(xpath = "//*[@id='site-content']//form/table//a[@href='https://testscriptdemo.com/?product=single-shirt']")
    WebElement singleShirtImg;

    @FindBy(xpath = "//*[@id='site-content']//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    WebElement cartTable;
@FindBy(xpath = "//*[@id=\"product-20\"]/div[2]/form/button[3]")
    WebElement addToCartButton;
    @FindBy (xpath = "//*[@id=\"blog\"]/div[3]/div[1]/div/div/div[2]/div[1]/form/button")
   WebElement searchIcon;

    private By wishList = By.className("header-wishlist");
   @FindBy(xpath = "//*[@id='blog']//a[@data-tooltip='Wishlist']")
    WebElement wishListIcon;

    @FindBy(className = "header-search-select")
    WebElement searchCategoryList;
    @FindBy(xpath = "//a[@class='cart-contents']")
    WebElement cartIcon;


    public Select listSearch;

    @FindBy(className = "yith-wcwl-row-20")

    List<WebElement> wishListTable;
    //  private By searchCategoryList = By.name("product_cat");

SeleniumHelper selenium;
    public TestScriptDemoPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        selenium = new SeleniumHelper();
        this.driver = driver;
    }
public boolean addToCartSingleShirt(WebDriver driver) {
        selenium.mouseHover(singleShirt, driver);
        selenium.click(singleShirt);
        selenium.click(addToCartButton);
    System.out.println("clicked on Add To cart Button");
        selenium.click(cartIcon);
    System.out.println("Clicked on Cart Button");
        selenium.clickUsingJavaScript(cartIcon,driver);
    System.out.println("Clicked on Cart Button");
    System.out.println(singleShirt.isDisplayed());
       selenium.validateText(driver,singleShirtWishList,"Single Shirt");

        return false;
}
    public void clickSaleTab() {
        driver.findElement(saleTab).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickSearchIcon(WebDriver driver) {
        selenium.refresh(driver);
        selenium.click(searchIcon);
            }
    public void clickWishListIcons(WebDriver driver){
    selenium.click(wishListIcon);
        selenium.validateText(driver,singleShirtWishList,"\n" +
                "\t\t\t\t\t\t\tSingle Shirt\t\t\t\t\t\t");
        selenium.validateText(driver,womensDressWishList,"\n" +
                "\t\t\t\t\t\t\tWomen's dress\t\t\t\t\t\t");
        selenium.validateText(driver,bikiniWishList,"\n" +
                "\t\t\t\t\t\t\tBikini\t\t\t\t\t\t");
        selenium.validateText(driver,topPantsUpperWishList,"\n" +
                "\t\t\t\t\t\t\tTop pants upper\t\t\t\t\t\t");

    }
    public void clickWishList(WebDriver driver) throws InterruptedException {
        selenium.click(womensDressWishList);
        Thread.sleep(6000);
        selenium.click(singleShirtWishList);
        Thread.sleep(6000);
        selenium.click(topPantsUpperWishList);
        Thread.sleep(6000);
        selenium.click(bikiniWishList);
        Thread.sleep(6000);

    }


    public boolean clickSearchCategoryList() {

        searchCategoryList.isSelected();
        return false;
    }

    public void selectCategory(String value) throws InterruptedException {
        boolean visibility =  searchCategoryList.isDisplayed();
        System.out.println(visibility);
        listSearch = new Select(searchCategoryList);
        System.out.println("List found");
        searchCategoryList.click();
        listSearch.selectByValue(value);

    }
}

