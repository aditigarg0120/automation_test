package com.automatedtest.stepDef;

import com.automatedtest.Pages.bookingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BookingPageSteps {

    private bookingPage bookingPage;

    public BookingPageSteps() {
        this.bookingPage = new bookingPage();
    }

    @Given("I navigate to blazedemo Home page")
    public void i_navigate_to_blazedemo_Home_page() {
        this.bookingPage.goToHomePage();
        this.bookingPage.getPageTitle();
    }

    @When("^User enter departure city$")
    public void enterDepartureCity(){
        this.bookingPage.enterDepartureCity();
    }

    @When("^User enter destination city$")
    public void enterDestinationCity(){
        this.bookingPage.enterDestinationCity();
    }

    @When("User click on Find Flights")
    public void user_click_on_find_flights() {
        this.bookingPage.findFlights();
    }

    @When("User select the flight from the list")
    public void clickOnChooseThisFlight(){
        this.bookingPage.chooseFlightFromList();
    }

    @When("User purchase the flight")
    public void purchaseFlight(){
        this.bookingPage.purchaseFlight();
    }

    @When("User purchase flights with no details")
    public void purchaseFlightWithNoDetails(){
        this.bookingPage.purchaseFlightWithNoDetails();
    }

    @Then("User should see the successful booking page with details")
    public void user_should_see_successful_booking_details(){
        Assert.assertTrue(this.bookingPage.validateSuccessfulBookingWithDetails());
    }

    @Then("User should see failure on the webpage")
    public void user_should_see_failure_message(){
        Assert.assertTrue(this.bookingPage.validateSuccessfulBookingWithDetails());
    }
}
