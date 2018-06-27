package io.github.symonk.common.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class FrameworkWaits {

    private WebDriverWait wait;
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @Autowired
    public FrameworkWaits(WebDriver driver, int explicitWaitTimeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, explicitWaitTimeout);
        this.wait.ignoreAll(Arrays.asList(StaleElementReferenceException.class, NoSuchElementException.class));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void waitUntilAnElementIsTitleIs(final String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitUntilElementIsClickable(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementIsPresent(final By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilJavascriptAndJQueryHaveFinishedLoading() {
        wait.until((webDriver) -> ((Long) jsExecutor.executeScript("return jQuery.active") == 0) &&
        jsExecutor.executeScript("return document.readyState").toString().equals("complete"));
    }

    public void waitForIFrameByIndexAndThenSwitchToItWhenReady(final int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }





}
