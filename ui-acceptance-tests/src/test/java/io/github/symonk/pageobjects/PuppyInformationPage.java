package io.github.symonk.pageobjects;

import io.github.symonk.common.waits.FrameworkWaits;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PuppyInformationPage extends AbstractBasePage {

    private static final By ADOPT_ME_BUTTON = By.xpath("//*[@id='content']/div[2]/div/form/div/input[1]");

    @Autowired
    public PuppyInformationPage(final WebDriver webdriver, final FrameworkWaits waits) {
        super(webdriver, waits);
    }

    public void pressAdoptMe() {
        clickElement(ADOPT_ME_BUTTON);
    }

}
