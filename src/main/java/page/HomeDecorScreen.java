package page;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeDecorScreen extends AppiumBase {
    public HomeDecorScreen() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.banggood.client:id/slide_filter_entry")
    private WebElement filter;

    @FindBy(id = "com.banggood.client:id/edit_price_min")
    private WebElement priceMin;

    @FindBy(id = "com.banggood.client:id/edit_price_max")
    private WebElement priceMax;

    @FindBy(id = "com.banggood.client:id/btn_done")
    private WebElement btnDone;

    @FindBy(xpath = "(//android.widget.FrameLayout[@resource-id='com.banggood.client:id/item_view'])[1]")
    private WebElement firstProduct;

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement proName;

    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement proPrice;

    public void clickFilter() {
        wait.until(ExpectedConditions.visibilityOf(filter)).click();
    }

    public void inputRangeOfPrice(String min, String max) {
        wait.until(ExpectedConditions.visibilityOf(priceMin)).sendKeys(min);
        wait.until(ExpectedConditions.visibilityOf(priceMax)).sendKeys(max);
    }

    public void clickButtonDone() {
        wait.until(ExpectedConditions.visibilityOf(btnDone)).click();
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.visibilityOf(firstProduct)).click();
    }

    public boolean verifyProductName() {
        wait.until(ExpectedConditions.visibilityOf(proName));
        return proName.isDisplayed();
    }

    public boolean verifyProductPrice(int min, int max) {
        wait.until(ExpectedConditions.visibilityOf(proPrice));
        int price = Integer.parseInt(proPrice.getText().substring(2));
        System.out.println(price);
        if (price > min && price < max)
            return true;
        else
            return false;
    }
}
