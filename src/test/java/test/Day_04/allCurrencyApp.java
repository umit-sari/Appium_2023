package test.Day_04;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class allCurrencyApp {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyPage allCurrencyPage=new AllCurrencyPage();

    @Test
   public void allCurrencyTest() throws InterruptedException, IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter");

        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(allCurrencyPage.CurrencyText.isDisplayed());

// cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.tiklamaMethodu(349,461,500);
        ReusableMethods.scrollWithUiScrollable("QAR");

// cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.tiklamaMethodu(353,631,500);
        ReusableMethods.scrollWithUiScrollable("TRY");
        allCurrencyPage.threeButton.click();
        allCurrencyPage.fiveButton.click();
        for (int i = 0; i < 3; i++) {
            allCurrencyPage.zeroButton.click();
        }

// cevrilen tutar screenShot olarak kaydedilir
        File paraSonucu =driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(paraSonucu,new File("QarToTry.jpg"));

// Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
      String exchangeResult=allCurrencyPage.resultBox.getText();
// kullaniciya sms olarak bildirilir
        driver.sendSMS("555555555","exchange result"+exchangeResult);
    }
}
