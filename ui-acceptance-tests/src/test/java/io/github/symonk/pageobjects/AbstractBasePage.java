package io.github.symonk.pageobjects;

import io.github.symonk.common.waits.FrameworkWaits;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Slf4j
public class AbstractBasePage {

  @Autowired protected ApplicationContext applicationContext;
  protected WebDriver webdriver;
  protected FrameworkWaits expectedConditions;

  @Autowired
  public AbstractBasePage(WebDriver webdriver, FrameworkWaits waits) {
    this.webdriver = webdriver;
    this.expectedConditions = waits;
    PageFactory.initElements(webdriver, this);
  }

  public void navigateToPageAndWait(String url) {
    webdriver.get(url);
  }

  public void setElementTextValue(WebElement elementToSetTextOn, String text) {
    expectedConditions.waitUntilElementIsClickable(elementToSetTextOn);
    elementToSetTextOn.clear();
    elementToSetTextOn.sendKeys(text);
  }
}
