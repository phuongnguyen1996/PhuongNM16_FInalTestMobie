package page;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeAndGarden extends AppiumBase {
    public HomeAndGarden() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Home Decor']")
    private WebElement homeDecor;

    public void clickHomeDecor() {
        wait.until(ExpectedConditions.visibilityOf(homeDecor)).click();
    }

}
