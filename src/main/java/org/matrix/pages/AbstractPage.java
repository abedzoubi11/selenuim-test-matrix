package org.matrix.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.matrix.context.ThreadWebDriver;

import java.time.Duration;

public class AbstractPage {

    static final int WAIT=10;

    /**
     * The driver.
     */
    protected WebDriver driver = ThreadWebDriver.getDriver();

    /**
     * The waiter.
     */
    protected FluentWait<WebDriver> waiter = new FluentWait<>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
            .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));


    public void waitForWebElement(WebElement webElement, int timeOutInSeconds) {
        new WebDriverWait(driver, WAIT).until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForWebElement(By byLocator, int timeOutInSeconds) {
        new WebDriverWait(driver, WAIT).until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }
}
