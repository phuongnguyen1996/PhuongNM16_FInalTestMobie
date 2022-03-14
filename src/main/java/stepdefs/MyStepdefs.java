package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import page.*;

import java.util.Map;

public class MyStepdefs {
    SoftAssert softAssert = new SoftAssert();
    HomeScreen homeScreen = new HomeScreen();
    FooterMenu footerMenu = new FooterMenu();
    CategoryScreen categoryScreen = new CategoryScreen();
    HomeAndGarden homeAndGarden = new HomeAndGarden();
    HomeDecorScreen homeDecorScreen = new HomeDecorScreen();
    FirstCategory firstCategory = new FirstCategory();
    FirstProductDetail firstProductDetail = new FirstProductDetail();
    CartScreen cartScreen = new CartScreen();

    //    TC01
    @When("Click to the Category on footer menu")
    public void clickToTheCategoryOnFooterMenu() {
        System.out.println("Click to the Category on footer menu");
        footerMenu.clickCategory();
    }

    @And("Click to Home and Garden in Left menu")
    public void clickToHomeAndGardenInLeftMenu() {
        System.out.println("Click to “Home and Garden” in Left menu");
        categoryScreen.clickHomeAndGarden();
    }

    @And("click to the Home Decor")
    public void clickToTheHomeDecor() {
        System.out.println("click to the Home Decor");
        homeAndGarden.clickHomeDecor();
    }

    @And("Click to the Filter")
    public void clickToTheFilter() {
        System.out.println("Click to the Filter");
        homeDecorScreen.clickFilter();
    }

    @And("input price from {string} to {string}")
    public void inputPriceFromTo(String arg0, String arg1) {
        System.out.println("input price from " + arg0 + " to " + arg1);
        homeDecorScreen.inputRangeOfPrice(arg0, arg1);
    }

    @And("Click Done")
    public void clickDone() {
        System.out.println("Click Done");
        homeDecorScreen.clickButtonDone();
    }

    @And("Click first product")
    public void clickFirstProduct() {
        System.out.println("Click first product");
        homeDecorScreen.clickFirstProduct();
    }

    @Then("product name should be displayed")
    public void productNameShouldBeDisplayed() {
        System.out.println("product name should be displayed");
        softAssert.assertTrue(homeDecorScreen.verifyProductName());
    }

    @And("product price in range {int} to {int}")
    public void productPriceInRangeTo(int arg0, int arg1) {
        System.out.println("product price in range " + arg0 + " to " + arg1);
        if (homeDecorScreen.verifyProductPrice(arg0, arg1)) {
            softAssert.assertTrue(homeDecorScreen.verifyProductPrice(arg0, arg1));
        } else {
            softAssert.assertFalse(homeDecorScreen.verifyProductPrice(arg0, arg1));
        }
    }

    //    TC02-1
    @When("At the Home screen, scroll to “Hot Categories”")
    public void atTheHomeScreenScrollToHotCategories() {
        System.out.println("At the Home screen, scroll to “Hot Categories”");
        homeScreen.goToHotCategories();
    }

    @And("Click to the first category")
    public void clickToTheFirstCategory() {
        System.out.println("Click to the first category");
        homeScreen.clickFirstCategory();
    }

    @And("Click to the first product")
    public void clickToTheFirstProduct() {
        System.out.println("Click to the first product");
        firstCategory.clickFirstProduct();
    }

    @Then("The product detail page should be displayed")
    public void theProductDetailPageShouldBeDisplayed(DataTable dataTable) {
        System.out.println("The product detail page should be displayed");
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        if (data.get("Product name").equals("Yes")) {
            softAssert.assertTrue(firstProductDetail.verifyProductName());
        } else {
            softAssert.assertFalse(firstProductDetail.verifyProductName());
        }
        if (data.get("product price").equals("Yes")) {
            softAssert.assertTrue(firstProductDetail.verifyProductPrice());
        } else {
            softAssert.assertFalse(firstProductDetail.verifyProductPrice());
        }
        if (data.get("Buy now button").equals("Yes")) {
            softAssert.assertTrue(firstProductDetail.verifyBuyNowBtn());
        } else {
            softAssert.assertFalse(firstProductDetail.verifyBuyNowBtn());
        }
        if (data.get("Add to Cart button").equals("Yes")) {
            softAssert.assertTrue(firstProductDetail.verifyAddToCartBtn());
        } else {
            softAssert.assertFalse(firstProductDetail.verifyAddToCartBtn());
        }
    }

    //    TC02-2
    @Given("Go to screen First Product of first category in Hot Categories")
    public void goToScreenFirstProductOfFirstCategoryInHotCategories() {
        System.out.println("Go to screen First Product of first category in Hot Categories");
        homeScreen.goToHotCategories();
        homeScreen.clickFirstCategory();
        firstCategory.clickFirstProduct();
    }

    @When("Click “Add to Cart”")
    public void clickAddToCart() {
        System.out.println("Click “Add to Cart”");
        firstProductDetail.clickAddToCartBtn();
    }

    @And("Click to “Add to Cart” button")
    public void clickToAddToCartButton() {
        System.out.println("Click to “Add to Cart” button");
        firstProductDetail.clickAddToCartBtn2();
    }

    @And("Click to Cart icon on footer")
    public void clickToCartIconOnFooter() {
        System.out.println("Click to Cart icon on footer");
        firstProductDetail.clickCartIcon();
    }

    @Then("Verify product name, product size, product price and quantity should be displayed")
    public void verifyProductNameProductSizeProductPriceAndQuantityShouldBeDisplayed(DataTable dataTable) {
        System.out.println("Verify product name, product size, product price and quantity should be displayed");
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        if (data.get("Product name").equals("Yes")) {
            softAssert.assertTrue(cartScreen.verifyProductNameInCart());
        } else {
            softAssert.assertFalse(cartScreen.verifyProductNameInCart());
        }
        if (data.get("product price").equals("Yes")) {
            softAssert.assertTrue(cartScreen.verifyProductPriceInCart());
        } else {
            softAssert.assertFalse(cartScreen.verifyProductPriceInCart());
        }
        if (data.get("product size").equals("Yes")) {
            softAssert.assertTrue(cartScreen.verifyProductSizeInCart());
        } else {
            softAssert.assertFalse(cartScreen.verifyProductSizeInCart());
        }
        if (data.get("quantity").equals("Yes")) {
            softAssert.assertTrue(cartScreen.verifyQuantityInCart());
        } else {
            softAssert.assertFalse(cartScreen.verifyQuantityInCart());
        }
    }
}
