package io.github.symonk.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.symonk.common.enums.Puppy;
import io.github.symonk.pageobjects.PuppyAdoptionHomePage;
import io.github.symonk.pageobjects.PuppyInformationPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PuppyAdoptionSteps {

    private final PuppyAdoptionHomePage puppyAdoptionHomePage;
    private final PuppyInformationPage puppyInformationPage;

    @Autowired
    public PuppyAdoptionSteps(final PuppyAdoptionHomePage puppyAdoptionHomePage, final PuppyInformationPage puppyInformationPage) {
        this.puppyAdoptionHomePage = puppyAdoptionHomePage;
        this.puppyInformationPage = puppyInformationPage;
    }

    @Given("^the puppy adoption page has been loaded$")
    public void the_puppy_adoption_page_has_been_loaded() {
        puppyAdoptionHomePage.open();
    }

    @When("^someone chooses to adopt (.+)$")
    public void someoneChoosesToAdoptBrook(Puppy type) {
        puppyAdoptionHomePage.adoptADog(type);
        puppyInformationPage.pressAdoptMe();

    }
}
