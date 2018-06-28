package io.github.symonk.pageobjects;

import io.github.symonk.common.annotations.PageObjectTitle;
import io.github.symonk.common.annotations.PageObjectUrl;
import io.github.symonk.common.enums.Puppy;
import io.github.symonk.common.waits.FrameworkWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObjectUrl("http://puppies.herokuapp.com")
@PageObjectTitle("Sally's Puppy Adoption Agency")
public class PuppyAdoptionHomePage extends AbstractBasePage {

    private static final By BROOK_VIEW_DETAILS = By.xpath("//form[@action=\"/puppies/4\"]//input");
    private static final By HANNAH_VIEW_DETAILS = By.xpath("//form[@action=\"/puppies/3\"]//input");

    @Autowired
    public PuppyAdoptionHomePage(WebDriver webdriver, FrameworkWaits explicitWait) {
        super(webdriver, explicitWait);
    }

    public PuppyAdoptionHomePage open() {
        webdriver.get(PuppyAdoptionHomePage.class.getAnnotation(PageObjectUrl.class).value());
        return this;
    }

    public void adoptADog(Puppy name) {
        switch(name) {
            case BROOK:
                clickElement(BROOK_VIEW_DETAILS);
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
