package page;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterMenu extends AppiumBase {
    public FooterMenu() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Category']")
    private WebElement category;

    public void clickCategory() {
        wait.until(ExpectedConditions.visibilityOf(category)).click();
    }
}
