package page;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstCategory extends AppiumBase {
    public FirstCategory() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//android.widget.FrameLayout[@resource-id='com.banggood.client:id/item_view'])[1]")
    private WebElement firstProduct;

    public void clickFirstProduct(){
        wait.until(ExpectedConditions.visibilityOf(firstProduct)).click();
    }
}
