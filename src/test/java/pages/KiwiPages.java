package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPages {

    public KiwiPages(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
        // webdriver casting yaparak API'leri
        //ceptelefonlari icin kullanmayi saglıyoruz.
    }
    @FindBy(xpath ="//*[@text='Continue as a guest']")
    public WebElement questButton;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement departurePointBox;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//*[@text='Anywhere']")
    public WebElement anyWhereBox;

    @FindBy(xpath = "//*[@text='Anytime']")
    public WebElement departureDateBox;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButton;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stopButton;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonStopButton;

    @FindBy(xpath = "(//*[@class='android.widget.Button'])[3]")
    public WebElement contiuneButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement priceBox;



}
