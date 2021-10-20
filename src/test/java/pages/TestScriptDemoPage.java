package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.SeleniumHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestScriptDemoPage {
    private WebDriver driver;


    @FindBy(xpath = "//select[@name='orderby']")
    WebElement sortOrder;
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=23]")
    WebElement topPantsUpperWishList;
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=24]")
    WebElement womenDressWishList;
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=22]")
    WebElement bikiniWishList;
    @FindBy(xpath = "//*[@id='site-content']//a[@data-product-id=20]")
    WebElement singleShirtWishList;
    @FindBy(xpath = "//table[@data-id='7572']")
    WebElement wishListTable;
    @FindBy(xpath = "//table//tbody/tr")
    List<WebElement> wishListTableContent;
    @FindBy(xpath = "//*[@id='yith-wcwl-row-20']")
    WebElement singleShirtInWishList;
    @FindBy(xpath = "//*[@id='yith-wcwl-row-22']")
    WebElement bikiniInWishlist;
    @FindBy(xpath = "//*[@id='yith-wcwl-row-23']")
    WebElement topPantsInWishList;
    @FindBy(xpath = "//*[@id='yith-wcwl-row-24']")
    WebElement womenDressInInWishList;
    @FindBy(xpath = "//option[@value='price'']")
    WebElement sortByLowPrice;
    @FindBy(xpath = "//a[@data-product_sku='woo-beanie']")
    WebElement lowerProductAddCart;
    @FindBy(xpath = "//tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']")
    WebElement lowerPriceProductInCart;


    @FindBy(xpath = "//*[@id='site-content']/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[3]/a[1]/img")
    WebElement singleShirt;

    @FindBy(xpath = "//*[@id='site-content']//form/table//a[@href='https://testscriptdemo.com/?product=single-shirt']")
    WebElement singleShirtImg;

    @FindBy(xpath = "//*[@id='site-content']//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    WebElement cartTable;

    @FindBy(xpath = "//*[@id='product-20']/div[2]/form/button[3]")
    WebElement addToCartButton;
    @FindBy (xpath = "//button[@class='header-search-button']")
    WebElement searchIcon;


   @FindBy(xpath = "//*[@id='blog']//a[@data-tooltip='Wishlist']")
    WebElement wishListIcon;

    @FindBy(className = "header-search-select")
    WebElement searchCategoryList;
    @FindBy(xpath = "//a[@class='cart-contents']")
    WebElement cartIcon;





SeleniumHelper selenium;
    public TestScriptDemoPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        selenium = new SeleniumHelper();
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickSearchIcon(WebDriver driver) {
        selenium.refresh(driver);
        selenium.click(searchIcon);
            }

    public boolean verifyWishListTable(WebDriver driver){
        /*if(wishListTable.isDisplayed())
        {
            return true;

        }return  false;*/

        int rows = wishListTableContent.size();
        System.out.println("The Wishlist table displayed with "+rows+"rows");

        if(rows==4)
        {
            return true;

        }return  false;

    }


    public void verifyWishListProducts(WebDriver driver){
    selenium.click(wishListIcon);
      //  selenium.validateText(driver,singleShirtInWishList, "test");
        String Actualtext1 = "×\n" +
                "Single Shirt £30.00 £20.00 In Stock\n" +
                "Add to cart";
        String Actualtext2 = "×\n" +
                "Women's dress £20.00 In Stock\n" +
                "Add to cart";
        String Actualtext3 = "×\n" +
                "Bikini £25.00 £19.00 In Stock\n" +
                "Add to cart";
        String Actualtext4 = "×\n" +
                "Top pants upper £22.00 – £89.00 In Stock\n" +
                "Add to cart";
        Assert.assertEquals(selenium.getText(singleShirtInWishList, driver),Actualtext1);
       Assert.assertEquals(selenium.getText(womenDressInInWishList,driver),Actualtext2);
        Assert.assertEquals(selenium.getText(bikiniInWishlist,driver),Actualtext3);
        Assert.assertEquals(selenium.getText(topPantsInWishList,driver),Actualtext4);

    }
    public void clickWishList(WebDriver driver) throws InterruptedException {
        selenium.click(womenDressWishList);
        Thread.sleep(6000);
        selenium.click(singleShirtWishList);
        Thread.sleep(6000);
        selenium.click(topPantsUpperWishList);
        Thread.sleep(6000);
        selenium.click(bikiniWishList);
        Thread.sleep(6000);

    }



   /* public void selectCategory(String value) throws InterruptedException {
        boolean visibility =  searchCategoryList.isDisplayed();
        System.out.println(visibility);
        listSearch = new Select(searchCategoryList);
        System.out.println("List found");
        searchCategoryList.click();
        listSearch.selectByValue(value);
        }
*/

    public void searchLowerPriceProduct(WebDriver driver, String value){
        Select searchFilter = new Select(sortOrder);
        searchFilter.selectByValue("price");

    }
    public void addToCartLowPriceProduct(WebDriver driver) {
        //  selenium.mouseHover(singleShirt, driver);
        System.out.println("lower price product displayed:"+lowerProductAddCart.isDisplayed());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selenium.click(lowerProductAddCart);
        // selenium.click(addToCartButton);
        System.out.println("clicked on Add To cart Button");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    public void clickCartIcon(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selenium.click(cartIcon);
        selenium.clickUsingJavaScript(cartIcon,driver);
        System.out.println("Clicked on Cart Button");
        selenium.validateText(driver,lowerProductAddCart,"Modern");

    }

    public String verifyCart(WebDriver driver){

        String productName=  selenium.getText(lowerPriceProductInCart, driver);
        return productName;
    }


}

