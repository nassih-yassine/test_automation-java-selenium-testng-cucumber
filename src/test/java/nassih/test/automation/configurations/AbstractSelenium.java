package nassih.test.automation.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class AbstractSelenium {

    protected static final Logger log = LoggerFactory.getLogger(AbstractSelenium.class);

    @BeforeClass
    public static void startRunner() {
        log.atInfo().setMessage("Starting the Runner......").log();
    }

    @AfterClass
    public static void endRunner() {
        log.atInfo().setMessage("Ending the Runner......").log();
    }
}
