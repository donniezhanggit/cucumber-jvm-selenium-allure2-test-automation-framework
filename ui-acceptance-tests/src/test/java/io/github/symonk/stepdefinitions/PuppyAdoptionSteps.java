package io.github.symonk.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.symonk.common.enums.Puppy;
import io.github.symonk.cucumber.TestWorld;
import io.github.symonk.datamanagement.OrderProvider;
import io.github.symonk.pageobjects.PuppyAdoptionHomePage;
import io.github.symonk.pageobjects.PuppyInformationPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PuppyAdoptionSteps {

    private final PuppyAdoptionHomePage puppyAdoptionHomePage;
    private final PuppyInformationPage puppyInformationPage;
    private final OrderProvider orderProvider;
    private final TestWorld testWorld;

    @Autowired
    public PuppyAdoptionSteps(final PuppyAdoptionHomePage puppyAdoptionHomePage, final PuppyInformationPage puppyInformationPage, final TestWorld testWorld,
                              final OrderProvider orderProvider) {
        this.puppyAdoptionHomePage = puppyAdoptionHomePage;
        this.puppyInformationPage = puppyInformationPage;
        this.orderProvider = orderProvider;
        this.testWorld = testWorld;
    }

    @Given("^an order has been prepared$")
    public void an_order_has_been_prepared() {
        testWorld.setCurrentOrder(orderProvider.getRandomOrder());
    }

    @When("^the order is processed")
    public void the_order_is_processed() {
        puppyAdoptionHomePage.open();
        puppyAdoptionHomePage.adoptADog(testWorld.getCurrentOrder().getDogName());
        puppyInformationPage.pressAdoptMe();
    }
}
