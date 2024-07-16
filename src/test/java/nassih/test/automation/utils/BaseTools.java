package nassih.test.automation.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class BaseTools {
    protected static final Logger log = LoggerFactory.getLogger(BaseTools.class);
    protected static final Duration TIME = Duration.ofSeconds(Utils.getWait("EXPLICIT_WAIT"));
    private WebDriverWait wait;

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void waitForElementToBeVisible(WebElement element) {
        log.atTrace()
                .setMessage("Waiting for element: '" + element.toString() + "' to be Visible")
                .log();
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean elementHasAttributeEqualToValue (WebElement element, String attribute, String value) {
        log.atTrace()
                .setMessage("Checking if the element has an Attribute: {} , Equal the Value: {}")
                .addArgument(attribute)
                .addArgument(value)
                .log();
        waitForElementToBeVisible(element);
        return wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public boolean elementHasAttributeContainsValue(WebElement element, String attribute, String value) {
        log.atTrace()
                .setMessage("Checking if the element has an Attribute: {} , that Contains the Value: {}")
                .addArgument(attribute)
                .addArgument(value)
                .log();
        waitForElementToBeVisible(element);
        return wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void waitAndClick(WebElement element) {
        log.atTrace()
                .setMessage("Clicking on the element {} when he is clickable")
                .addArgument(element)
                .log();
        waitForElementToBeVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean checkIfElementHasAttribute(WebElement element, String attribute) {
        log.atTrace()
                .setMessage("Checking if the element has an Attribute: {}")
                .addArgument(attribute)
                .log();
        waitForElementToBeVisible(element);
        return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public void sendKeys(WebElement element, String keys) {
        log.atTrace()
                .setMessage("Sending keys to the element: {}")
                .addArgument(element)
                .log();
        waitForElementToBeVisible(element);
        element.sendKeys(keys);
    }

    public String getAttribute(WebElement element, String attribute) {
        log.atTrace()
                .setMessage("Get the value of the Attribute: {} from the element: {}")
                .addArgument(attribute)
                .addArgument(element)
                .log();

        String value = element.getAttribute(attribute);
        if(Utils.isEmpty(value)) {
            log.atError()
                    .setMessage("The Attribute: " + attribute + " DO NOT EXIST in the given element")
                    .log();
            Assert.fail();
        }
        return value;
    }

    public void sleep(int seconds) {
        try {
            log.atInfo()
                    .setMessage("Programme will be paused for " + seconds + " seconds.")
                    .log();

            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            log.atError()
                    .setMessage("Error while trying to Pause the programme for " + seconds + " seconds.")
                    .log();
            Assert.fail();
        }
    }
}
