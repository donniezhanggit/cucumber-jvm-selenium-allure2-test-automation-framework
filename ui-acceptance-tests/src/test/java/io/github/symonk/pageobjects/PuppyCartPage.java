package io.github.symonk.pageobjects;

import io.github.symonk.common.waits.FrameworkWaits;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PuppyCartPage extends AbstractBasePage {

    private static final By COMPLETE_ADOPTION_BUTTON = By.xpath("//*[@id='content']/div[2]/form[1]/div/input");

    @Autowired
    public PuppyCartPage(final WebDriver webdriver, final FrameworkWaits waits) {
        super(webdriver, waits);
    }

    public void pressCompleteAdoption() {
        clickElement(COMPLETE_ADOPTION_BUTTON);
    }


}
