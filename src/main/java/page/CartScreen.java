package page;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartScreen extends AppiumBase {
    public CartScreen() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement proName;

    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement proPrice;

    @FindBy(id = "com.banggood.client:id/qty_edit_view")
    private WebElement quantity;

    @FindBy(id = "com.banggood.client:id/tv_checkout")
    private WebElement proSize;

    public boolean verifyProductNameInCart() {
        wait.until(ExpectedConditions.visibilityOf(proName));
        return proName.isDisplayed();
    }

    public boolean verifyProductPriceInCart() {
        wait.until(ExpectedConditions.visibilityOf(proPrice));
        return proPrice.isDisplayed();
    }

    public boolean verifyProductSizeInCart() {
        wait.until(ExpectedConditions.visibilityOf(proSize));
        return proSize.isDisplayed();
    }

    public boolean verifyQuantityInCart() {
        wait.until(ExpectedConditions.visibilityOf(quantity));
        return quantity.isDisplayed();
    }
}
