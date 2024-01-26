package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ReusableMethods {

    public static void tiklamaMethodu(int xKoordinati,int yKoordinati,int beklemeSuresi) throws InterruptedException {
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xKoordinati,yKoordinati))
                .release()
                .perform();
        Thread.sleep(beklemeSuresi);
    }

    public static void screenScroolMethod(int pressXkoordinati,int pressYkoordinati,int wait,int moveXkoordinati,int moveYkoordinati,int bekleme) throws InterruptedException {
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(pressXkoordinati,pressYkoordinati))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(moveXkoordinati,moveYkoordinati))
                .release()
                .perform();
        Thread.sleep(bekleme);
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();

    }
}