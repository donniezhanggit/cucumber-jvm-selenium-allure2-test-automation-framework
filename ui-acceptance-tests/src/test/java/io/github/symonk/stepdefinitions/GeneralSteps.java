package io.github.symonk.stepdefinitions;

import cucumber.api.java.en.Given;
import io.github.symonk.helpers.localisation.ResourceHelper;
import io.github.symonk.pageobjects.PuppyAdoptionHomePage;
import io.github.symonk.spring.AutomationProperties;
import io.github.symonk.webdriver.Driver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class GeneralSteps {

  private WebDriver driver;
  private AutomationProperties properties;
  private ResourceHelper resourceHelper;
  private PuppyAdoptionHomePage puppyAdoptionHomePage;

  @Autowired
  public GeneralSteps(WebDriver driver, AutomationProperties properties, ResourceHelper resourceHelper, PuppyAdoptionHomePage puppyAdoptionHomePage) {
    this.driver = driver;
    this.properties = properties;
    this.resourceHelper = resourceHelper;
    this.puppyAdoptionHomePage = puppyAdoptionHomePage;
  }

  @Given("^a browser has loaded the puppy adoption site$")
  public void something_or_other() {
    puppyAdoptionHomePage.open();
  }
}
