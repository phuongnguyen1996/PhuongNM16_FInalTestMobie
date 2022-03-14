package page;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstProductDetail extends AppiumBase {
    public FirstProductDetail() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement proName;

    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement proPrice;

    @FindBy(id = "com.banggood.client:id/btn_slide_buy")
    private WebElement buyNowBtn;

    @FindBy(id = "com.banggood.client:id/btn_slide_cart")
    private WebElement addToCartBtn;

    @FindBy(id = "com.banggood.client:id/btn_cart")
    private WebElement addToCartBtn2;

    @FindBy(id = "com.banggood.client:id/cv_slide_cart")
    private WebElement cartIcon;

    @FindBy(id = "com.banggood.client:id/qty_edit_view")
    private WebElement quantity;

    @FindBy(id = "com.banggood.client:id/tv_checkout")
    private WebElement proSize;

    public boolean verifyProductName() {
        wait.until(ExpectedConditions.visibilityOf(proName));
        return proName.isDisplayed();
    }

    public boolean verifyProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(proPrice));
        return proPrice.isDisplayed();
    }

    public boolean verifyBuyNowBtn() {
        wait.until(ExpectedConditions.visibilityOf(buyNowBtn));
        return buyNowBtn.isDisplayed();
    }

    public boolean verifyAddToCartBtn() {
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        return addToCartBtn.isDisplayed();
    }

    public void clickAddToCartBtn() {
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn)).click();
    }

    public void clickAddToCartBtn2() {
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn2)).click();
    }

    public void clickCartIcon() {
        wait.until(ExpectedConditions.visibilityOf(cartIcon)).click();
    }
}