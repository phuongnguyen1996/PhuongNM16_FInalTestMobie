package core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBase {
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabiloties = new DesiredCapabilities();
        desiredCapabiloties.setCapability("platformName", "Android");
        desiredCapabiloties.setCapability("udid", "R5CR11AXMJB");
        desiredCapabiloties.setCapability("automationName", "UiAutomator2");
        desiredCapabiloties.setCapability("appPackage", "com.banggood.client");
        desiredCapabiloties.setCapability("appActivity", "com.banggood.client.module.home.MainActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabiloties);
        wait = new WebDriverWait(driver, 20);
    }

    public void tearDown() {
        driver.closeApp();
    }

    public void swipe(int startx, int starty, int endx, int endy) {
        new TouchAction(driver).longPress(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();
    }

    public void swipeUpInContainer(By locator, WebElement androidElementContainer, int count) {
        boolean isVisible = checkElementDisplayed(locator);
        if (isVisible) {
            return;
        }
        int startx = 0;
        int starty = 0;
        int endx = 0;
        int endy = 0;
        startx = endx = androidElementContainer.getLocation().getX() + Math.round(androidElementContainer.getSize().getWidth() / 2);
        starty = (int) (androidElementContainer.getLocation().getY() + Math.round(0.8 * androidElementContainer.getSize().getHeight()));
        endy = (int) (androidElementContainer.getLocation().getY() + Math.round(0.2 * androidElementContainer.getSize().getHeight()));
        System.out.println(startx + "_" + starty + "_" + endx + "_" + endy);
        for (int i = 0; i < count; ++i) {
            swipe(startx, starty, endx, endy);
            isVisible = checkElementDisplayed(locator);
            if (isVisible) {
                break;
            }
        }
    }

    public boolean checkElementDisplayed(By locator) {
        boolean isDisplay = false;
        AndroidElement androidElement = null;
        try {
            androidElement = (AndroidElement) driver.findElement(locator);
        } catch (Exception e) {
        }
        if (null != androidElement) {
            try {
                if (null != androidElement.getLocation()) {
                    int x = androidElement.getLocation().getX();
                    int y = androidElement.getLocation().getY();
                    Dimension windowSize = driver.manage().window().getSize();
                    String deviceScreenSize = "";
                    int yMaxScreen = (int) Math.round(windowSize.getHeight());
                    int xMaxScreen = (int) Math.round(windowSize.getWidth());
                    if (driver instanceof AndroidDriver) {
                        deviceScreenSize = StringUtils.substringBetween(driver.toString(), "deviceScreenSize=",
                                ",");
                    }
                    if (null != deviceScreenSize && !deviceScreenSize.equals("")) {
                        yMaxScreen = Integer.parseInt(deviceScreenSize.split("x")[1]);
                        xMaxScreen = Integer.parseInt(deviceScreenSize.split("x")[0]);
                    }
                    if (x >= 0 && x < xMaxScreen && y >= 0 && y < yMaxScreen) {
                        isDisplay = true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return isDisplay;
    }

    public void swipeMobileUp() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        swipe2(startx, starty, startx, endy);
    }

    public void swipe2(int startx, int starty, int endx, int endy) {
        new TouchAction(driver).press(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();
    }
}
