package io.github.symonk.pageobjects;

import io.github.symonk.common.waits.FrameworkWaits;
import io.github.symonk.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PuppyOrderPage extends AbstractBasePage {

    private static final By PLACE_ORDER_BUTTON = By.xpath("//*[@id='new_order']/div[6]/input");
    private static final By ORDER_NAME_TEXTBOX = By.id("order_name");
    private static final By ORDER_ADDRESS_TEXTBOX = By.id("order_address");
    private static final By ORDER_EMAIL_TEXTBOX = By.id("order_email");
    private static final By ORDER_PAYMENT_TYPE = By.id("order_pay_type");

    @Autowired
    public PuppyOrderPage(final WebDriver webdriver, final FrameworkWaits waits) {
        super(webdriver, waits);
    }

    public void completeOrderForm(Order order) {

    }


}
