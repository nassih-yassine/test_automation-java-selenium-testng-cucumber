package nassih.test.automation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class BaseTools {
    protected static final Logger log = LoggerFactory.getLogger(BaseTools.class);

    public boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
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

            throw new RuntimeException(e.getMessage());
        }
    }
}
