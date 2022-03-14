package page;

import core.AppiumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryScreen extends AppiumBase {
    public CategoryScreen() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Home and Garden']")
    private WebElement homeAndGarden;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.banggood.client:id/primary_cate_list']")
    private WebElement menuLeft;

    public void clickHomeAndGarden() {
        swipeUpInContainer(By.xpath("//android.widget.TextView[@text='Home and Garden']"), menuLeft, 300);
        wait.until(ExpectedConditions.visibilityOf(homeAndGarden)).click();
    }

}