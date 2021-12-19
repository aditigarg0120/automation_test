package com.automatedtest.Pages;

import com.automatedtest.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class bookingPage extends BasePage {

    @FindBy(name = "fromPort")
    private WebElement departureCity;

    @FindBy(name = "toPort")
    private WebElement destinationCity;

    @FindBy(xpath = "/html/body/div[3]/form/div/input")
    private WebElement clickOnFindFlights;

    @FindBy(xpath = "/html/body/div[2]/h3")
    private WebElement flightFromTo;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]/input")
    private WebElement chooseFlight;

    @FindBy(xpath = "/html/body/div[2]/h2")
    private WebElement flightReserved;

    @FindBy(name = "inputName")
    private WebElement name;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "zipCode")
    private WebElement zipCode;

    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumber;

    @FindBy(id = "creditCardMonth")
    private WebElement creditCardMonth;

    @FindBy(id = "creditCardYear")
    private WebElement creditCardYear;

    @FindBy(name = "nameOnCard")
    private WebElement nameOnCard;

    @FindBy(xpath = "/html/body/div[2]/form/div[11]/div/input")
    private WebElement purchaseFlight;

    @FindBy(xpath = "/html/body/div[2]/div/h1")
    private WebElement purchaseSuccess;

    @FindBy(xpath = "/html/body/div[2]/div/table/tbody/tr[1]/td[2]")
    private WebElement bookingId;

    @FindBy(xpath = "/html/body/div[2]/div/table/tbody/tr[2]/td[2]")
    private WebElement bookingStatus;

    public bookingPage() {
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage(){
        driver.get(properties.getProperty("url"));
    }

    public String getPageTitle(){
        driver.manage().window().maximize();
        return driver.getTitle();
    }

    public void enterDepartureCity() {
        Select selectDepartureCity = new Select(departureCity);
        selectDepartureCity.selectByValue("Boston");
    }

    public void enterDestinationCity() {
        Select selectDestinationCity = new Select(destinationCity);
        selectDestinationCity.selectByValue("London");
    }

    public void findFlights() {
        clickOnFindFlights.click();
    }

    public void chooseFlightFromList() {
        wait.forElementToBeDisplayed(5,this.flightFromTo);
        chooseFlight.click();
    }

    public void purchaseFlight() {
        wait.forElementToBeDisplayed(5,this.flightReserved);
        name.sendKeys(properties.getProperty("name"));
        address.sendKeys(properties.getProperty("address"));
        city.sendKeys(properties.getProperty("city"));
        state.sendKeys(properties.getProperty("state"));
        zipCode.sendKeys(properties.getProperty("zipcode"));
        creditCardNumber.sendKeys(properties.getProperty("creditCardNum"));
        creditCardMonth.sendKeys(properties.getProperty("creditCardMonth"));
        creditCardYear.sendKeys(properties.getProperty("creditCardYear"));
        nameOnCard.sendKeys(properties.getProperty("name"));
        purchaseFlight.click();
    }
    public void purchaseFlightWithNoDetails() {
        purchaseFlight.click();
    }

    public boolean validateSuccessfulBookingWithDetails() {
        wait.forElementToBeDisplayed(10, this.purchaseSuccess);
        boolean bookingIdDisplayed = bookingId.isDisplayed();
        boolean bookingStatusDisplayed = bookingStatus.isDisplayed();
        Assert.assertTrue(bookingIdDisplayed);
        Assert.assertTrue(bookingStatusDisplayed);
        return purchaseSuccess.isDisplayed();
    }
}
