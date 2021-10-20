package StepDefs;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TestScriptDemoPage;

public class TestScriptDemoSteps {
private TestScriptDemoPage demoPage = new TestScriptDemoPage(DriverFactory.getWebDriver());
        @Given("I add four different products to my wish list")
        public void i_add_four_different_products_to_my_wish_list() throws InterruptedException {
                Thread.sleep(5000);
                 DriverFactory.getWebDriver().get("https://testscriptdemo.com");

                String title= demoPage.getPageTitle();
                System.out.println("The Webpage title is" +title);
//                Boolean result =  demoPage.clickSearchCategoryList();
//                Assert.assertTrue(demoPage.clickSearchCategoryList());
//                System.out.println("search category is displayed");
//                Thread.sleep(3000);
//               demoPage.selectCategory("Clothing");
//                Thread.sleep(3000);
                       demoPage.clickSearchIcon(DriverFactory.getWebDriver());
//                System.out.println("Search Icon is clicked");
                demoPage.clickWishList(DriverFactory.getWebDriver());

                        }
        @When("I view my wishlist table")
        public void i_view_my_wishlist_table() throws InterruptedException {
        Thread.sleep(3000);
        demoPage.verifyWishListProducts(DriverFactory.getWebDriver());
                System.out.println("The Wishlist table is displayed ");
        }

        @Then("I find total four selected items in my wishlist")
        public void i_find_total_four_selected_items_in_my_wishlist() {
              Assert.assertEquals(demoPage.verifyWishListTable(DriverFactory.getWebDriver()),true);

               System.out.println("Four products were added in the WishList");
        }

        @When("I search for lower price product")
        public void i_search_for_lower_price_product() {
                demoPage.clickSearchIcon(DriverFactory.getWebDriver());
                System.out.println("Clicked on Search icon");
                demoPage.searchLowerPriceProduct(DriverFactory.getWebDriver(),"price");
                System.out.println("Search Price Low-High is selected");
                demoPage.addToCartLowPriceProduct(DriverFactory.getWebDriver());
                System.out.println("Lower price product added to the cart");
        }

        @When("I am able to add lowest price item to my cart")
        public void i_am_able_to_add_lowest_price_item_to_my_cart() {

                demoPage.clickCartIcon(DriverFactory.getWebDriver());
                System.out.println("Lower price product is added in the cart");
        }

        @Then("I am able to verify the item in my cart")
        public void i_am_able_to_verify_the_item_in_my_cart() {
                String cartProduct1 = "×\n" +
                        "Modern £20.00\n" +
                        "Modern quantity\n" +
                        "£20.00";
        Assert.assertEquals(cartProduct1, demoPage.verifyCart(DriverFactory.getWebDriver()));
                System.out.println("Lower price product is displayed in the cart");

        }





}
