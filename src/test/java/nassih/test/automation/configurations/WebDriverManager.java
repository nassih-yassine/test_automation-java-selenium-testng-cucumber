package nassih.test.automation.configurations;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;


public class WebDriverManager {
    private static final Collection<String> SUPPORTED_BROWSERS = Arrays.asList("CHROME", "EDGE", "FIREFOX");
    private WebDriver driver;
    protected static final Logger log = LoggerFactory.getLogger(WebDriverManager.class);
    protected static final ConfigFileReader configFileReader = new ConfigFileReader();

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setupDriver() {
        log.atInfo()
                .setMessage("Setting Up The Driver.....")
                .log();

        String driverName = configFileReader.getProperty("DRIVER");
        if (!SUPPORTED_BROWSERS.contains(driverName)) {
            driverName = "CHROME";
            log.atInfo()
                    .setMessage("The given value of 'DRIVER' is NOT VALID. The Driver is set to default value : 'CHROME'")
                    .log();
        }

        String strImplicitWAit = configFileReader.getProperty("IMPLICIT_WAIT");
        String strExplicitWait = configFileReader.getProperty("EXPLICIT_WAIT");
        Assert.assertTrue(
                NumberUtils.isCreatable(strImplicitWAit),
                "The given value of 'IMPLICIT_WAIT' should be an INTEGER"
        );
        Assert.assertTrue(
                NumberUtils.isCreatable(strExplicitWait),
                "The given value of 'EXPLICIT_WAIT' should be an INTEGER"
        );

        log.atInfo()
                .setMessage("Loaded Configuration: \n Driver: {},\n Implicit Wait: {},\n Explicit Wait: {}")
                .addArgument(driverName)
                .addArgument(strImplicitWAit)
                .addArgument(strExplicitWait)
                .log();
    }
}
