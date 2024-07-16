package nassih.test.automation.configurations;

import nassih.test.automation.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        String driverName = this.getDriverName();
        int implicitWait = Utils.getWait("IMPLICIT_WAIT");
        int explicitWait = Utils.getWait("EXPLICIT_WAIT");

        log.atInfo()
                .setMessage("Loaded Configuration: \n Driver: {},\n Implicit Wait: {},\n Explicit Wait: {}")
                .addArgument(driverName)
                .addArgument(implicitWait)
                .addArgument(explicitWait)
                .log();
    }

    private String getDriverName() {
        String driverName = configFileReader.getProperty("DRIVER");
        if (!SUPPORTED_BROWSERS.contains(driverName) || driverName == null) {
            driverName = "CHROME";
            log.atInfo()
                    .setMessage("The given value of 'DRIVER' is NOT VALID. The Driver is set to default value : 'CHROME'")
                    .log();
        }
        return driverName;
    }


}
