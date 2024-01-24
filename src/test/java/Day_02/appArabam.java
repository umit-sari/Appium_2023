package Day_02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class appArabam {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // eger kullanmis oldugumuz cihazin Android surumu 6 ya da 6  dan buyukse UiAutomator2 yi kullanmamiz gerekiyor
        // eger kullanmis oldugumuz cihazin Android surumu 6 dan kucukse UiAutomator u kullanmamiz gerekiyor.
        // Arabam app'i yüklendiginden tekrar app ekleme kodunu yazmiyoruz.
        capabilities.setCapability("appPackage", "com.dogan.arabam");
        // appPackage bir uygulamanin kimlik bilgisidir. biz bu capability sayesinde hangi uygulama uzerinde calisacagimizi test oncesinde belirtebiliriz
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        // appActivity uzerinde calisacak oldugumuz uygulamanin hangi sayfa penceresinden baslyacagimizi belirtir.
        //yani biz bu capability sayesinde uygulama icersindeki farkli pencerelerden uygulamayi baslatabiliriz. Bunun icin gerekli activity degerlerine sahip olmamiz gerekir.
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void appArabam() throws InterruptedException {
        //  driver.activateApp("com.dogan.arabam");
        // uygulamayi baslatmak icin kullaniyoruz.burayi yukarida appPackage ve appActivity tanimladigimiz icin yoruma aldik.

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='Alırken, satarken kullanırken']").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // arac olarak Volkswagen secilir
        Thread.sleep(2000);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(445, 1853)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(75))).moveTo(PointOption.point(445, 558)).release().perform();

       /* action.press(PointOption.point(414,1870) // parmagizi bir noktaya koymak
                .moveTo(PointOption.point(414,371)) // parmagimizi yukariya dogru kaydirma
                .release() //parmagimizi telefon yüzeyinde cekme islemi
               */
        Thread.sleep(1000);

        action.press(PointOption.point(235, 1495)).release().perform();
        /* action.press(PointOption.point(508,398)) // press kismi ekranda tiklama kaydirma islemi icin tiklama yapacagimiz ilk nokta
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))) // baslangic noktasi ile bitis noktasi arasindaki gecen sure
                // eger wait suresi uzun olursa gidilen yol mesafesi daha AZ olacaktir
                // eger ki wait suresi kisa olursa gidilen yol mesafesi daha FAZLA olacaktir
                .moveTo(PointOption.point(508,1538)) // baslangic noktasindan baslayarak gidilecek bitis noktasinin  koordinatlarini ifade eder
                .release() // parmagimizi tipki gunluk kullanimdaki gibi ekrandan kaldirma serbest birakma eylemidir
                .perform(); // verilen action

         */

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();
        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();
        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Highline']").click();
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        Thread.sleep(750);
        driver.findElementById("com.dogan.arabam:id/imageViewSorting").click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        Thread.sleep(500);
        String aracFiyati = driver.findElementByXPath("//*[@resource-id='com.dogan.arabam:id/tvPrice']").getText();
        System.out.println(aracFiyati);
        //  aracFiyati=aracFiyati.replaceAll(".","").replaceAll(" TL","");
        aracFiyati = aracFiyati.replaceAll("\\D", "");
        // 730.000 TL tutarindaki DİGİT olmayan bosluk ve TL'yi siliyoruz.
        //730000
        Assert.assertTrue(Integer.parseInt(aracFiyati) > 500000);

    }

}
