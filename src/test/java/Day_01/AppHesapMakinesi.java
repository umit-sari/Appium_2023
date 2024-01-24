package Day_01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppHesapMakinesi {

   // AndroidDriver<AndroidElement> driver; Android driver sadece android cihazlar
    // icin olusturulmus bir driverdir.
    // Android cihazlar icin gerekli olan hazir methodlari bu driver ile
    // birlikte kullanarak cihaz ile ilgili islemleri yapabiliriz

    // AppiumDriver<MobileElement> driver2 ;
    // Appium driver ise hem Ios hem de Android isletim sistemine sahip olan
    // cihazlar icin tasarlanmistir. Bu driver ile birlikte
    // iki farkli platform da driver ile islemlerimizi gerceklestirebiliriz.

    // EN TEMEL FARK !!!!!!!!! Android cihazlar kullanim farkliliklari
    // daha zengin oldugu icin AndroidDriver sadece android cihazlara
    // ozel tasarlanmistir. BU da bizlere android cihazlar daha kullanisli
    // bir driver kullanmamiza fayda saglar.


    AndroidDriver<AndroidElement>driver;

    @Test
    public void hesapmakinasiTesti() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        // eger kullanmis oldugumuz cihazin Android surumu 6 ya da 6  dan buyukse UiAutomator2 yi kullanmamiz gerekiyor
        // eger kullanmis oldugumuz cihazin Android surumu 6 dan kucukse UiAutomator u kullanmamiz gerekiyor.
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Umit\\IdeaProjects\\Appium_T120\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        // uygulamanin acildigini dogrular
        Assert.assertTrue(driver.findElementByAccessibilityId("2").isDisplayed());
        // 100 un 5 katininin 500 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementByAccessibilityId("5").click();

        String sonucKutusu=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println(sonucKutusu);
        Assert.assertEquals(Integer.parseInt(sonucKutusu),500);


    }
}
