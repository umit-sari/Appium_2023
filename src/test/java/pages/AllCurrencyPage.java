package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Queue;

public class AllCurrencyPage {

    public AllCurrencyPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }
    @FindBy(xpath = "//*[@text='CURRENCY CONVERTER']")
    public WebElement CurrencyText;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b3")
    public WebElement threeButton;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b5")
    public WebElement fiveButton;

    @FindBy(id="com.smartwho.SmartAllCurrencyConverter:id/b0")
    public WebElement zeroButton;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement resultBox;

}
