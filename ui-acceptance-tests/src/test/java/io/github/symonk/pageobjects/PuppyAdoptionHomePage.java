package io.github.symonk.pageobjects;

import io.github.symonk.common.enums.Puppy;
import io.github.symonk.common.waits.FrameworkWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

public class PuppyAdoptionHomePage extends AbstractBasePage {

    private String pageUrl;

    @FindBy(xpath = "//form[@action=\"/puppies/4\"]//input")
    private WebElement viewDetailsOnBrook;
    @FindBy(xpath = "//form[@action=\"/puppies/3\"]//input")
    private WebElement viewDetailsOnHannah;

    @Autowired
    public PuppyAdoptionHomePage(WebDriver webdriver, FrameworkWaits explicitWait, String pageUrl) {
        super(webdriver, explicitWait);
        this.pageUrl = pageUrl;
    }

    public PuppyAdoptionHomePage open() {
        webdriver.get(pageUrl);
        return this;
    }

    public void adoptADog(Puppy name) {
        switch(name) {
            case BROOK:
                viewDetailsOnBrook.click();
                break;
            case HANNA:
                break;
            case MAGGIE_MAE:
                break;
            case RUBY_SUE:
                break;
        }
    }
}
