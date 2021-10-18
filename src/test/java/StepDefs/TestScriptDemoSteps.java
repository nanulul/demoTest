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

                        }
        @When("I view my wishlist table")
        public void i_view_my_wishlist_table() throws InterruptedException {
        Thread.sleep(3000);
        demoPage.clickWishList(DriverFactory.getWebDriver());

        }

        @Then("I find total four selected items in my wishlist")
        public void i_find_total_four_selected_items_in_my_wishlist() {
        demoPage.clickSearchIcon(DriverFactory.getWebDriver());
        }

        @When("I search for lower price product")
        public void i_search_for_lower_price_product() {

        }

        @When("I am able to add lowest price item to my")
        public void i_am_able_to_add_lowest_price_item_to_my() {

        }

        @Then("I am able to verify the item in my cart")
        public void i_am_able_to_verify_the_item_in_my_cart() {

                demoPage.addToCartSingleShirt(DriverFactory.getWebDriver());

        }





}
