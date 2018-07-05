package io.github.symonk.pageobjects;

import io.github.symonk.common.annotations.PageObjectTitle;
import io.github.symonk.common.annotations.PageObjectUrl;
import io.github.symonk.common.enums.Puppy;
import io.github.symonk.common.waits.FrameworkWaits;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@PageObjectUrl("http://puppies.herokuapp.com")
@PageObjectTitle("Sally's Puppy Adoption Agency")
public class PuppyAdoptionHomePage extends AbstractBasePage {

    private static final By BROOK_VIEW_DETAILS = By.xpath("//form[@action=\"/puppies/4\"]//input");
    private static final By HANNAH_VIEW_DETAILS = By.xpath("//form[@action=\"/puppies/3\"]//input");
    private static final By ORDER_SUCCESSFUL_LABEL = By.id("notice");

    @Autowired
    public PuppyAdoptionHomePage(WebDriver webdriver, FrameworkWaits explicitWait) {
        super(webdriver, explicitWait);
    }

    public PuppyAdoptionHomePage open() {
        webdriver.get(PuppyAdoptionHomePage.class.getAnnotation(PageObjectUrl.class).value());
        return this;
    }

    public void adoptADog(Puppy type) {
        switch (type) {
            case BROOK:
                clickElement(BROOK_VIEW_DETAILS);
                break;
            case HANNA:
                clickElement(HANNAH_VIEW_DETAILS);
                break;
            case MAGGIE_MAE:
                break;
            case RUBY_SUE:
                break;
            default:
                throw new InvalidArgumentException("unsupported puppy type!");
        }
    }
}
