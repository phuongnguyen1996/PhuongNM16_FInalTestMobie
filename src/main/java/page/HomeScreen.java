package page;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeScreen extends AppiumBase {
    public HomeScreen() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//android.widget.TextView[@text='Hot Categories']//following-sibling::androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup)[1]")
    private WebElement firstCategory;

    public void goToHotCategories(){
        swipeMobileUp();
    }

    public void clickFirstCategory(){
        wait.until(ExpectedConditions.visibilityOf(firstCategory)).click();
    }
}
