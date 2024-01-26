package test.Day_03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPages;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPages kiwiPages = new KiwiPages();

    @Test
    public void kiwiAppTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        driver.isAppInstalled("com.skypicker.main");

        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPages.questButton.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPages.questButton.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //493,2040
       /* TouchAction action=new TouchAction<>(driver); // 3 defa ayni yere tikladigindan for loop ile aynı islemi 3 defa tekrarlaktik
        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(501,2036))
                    .release()
                    .perform();
            Thread.sleep(1000);

        */
        Thread.sleep(2000);
        //for (int i = 0; i < 3; i++) {
        // contiune tusuna 3 defa basarak ana ekrana ulaşmak için
            ReusableMethods.tiklamaMethodu(980,249, 1000);

        Thread.sleep(1500);

        // Trip type,one way olarak secilir
        //231,728
        ReusableMethods.tiklamaMethodu(216, 727, 1000);
        Thread.sleep(1000);
        kiwiPages.oneWayButton.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.tiklamaMethodu(327, 889, 1000);
        ReusableMethods.tiklamaMethodu(1016, 248, 1000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (!driver.isKeyboardShown()) {
            kiwiPages.departurePointBox.sendKeys("Istanbul");
        } else {
            driver.getKeyboard().pressKey("Istanbul");
        }
        Thread.sleep(1000);
        ReusableMethods.tiklamaMethodu(998, 410, 1000);
        kiwiPages.chooseButton.click();
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        kiwiPages.anyWhereBox.click();
        driver.getKeyboard().pressKey("Munich");
        Thread.sleep(2000);
        ReusableMethods.tiklamaMethodu(993, 411, 1000);
        kiwiPages.chooseButton.click();
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        kiwiPages.departureDateBox.click();
        Thread.sleep(3000);
        // ReusableMethods.screenScroolMethod(536,1234,500,536,357,1000);
        ReusableMethods.tiklamaMethodu(540, 1474, 1000);
        kiwiPages.setDateButton.click();
        // search butonuna tiklanir
        kiwiPages.searchButton.click();
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(274,370,1000);
        ReusableMethods.tiklamaMethodu(1009,710,1000);
        kiwiPages.stopButton.click();
        kiwiPages.nonStopButton.click();
        Thread.sleep(5000);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String cheapPrice=kiwiPages.priceBox.getText();
        driver.sendSMS("11111111","more best price"+cheapPrice);
    }
}


