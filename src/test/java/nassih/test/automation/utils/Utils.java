package nassih.test.automation.utils;

import nassih.test.automation.configurations.ConfigFileReader;
import nassih.test.automation.configurations.WebDriverManager;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Utils {
    //  protected static final Logger log = LoggerFactory.getLogger(WebDriverManager.class);
    protected static final ConfigFileReader configFileReader = new ConfigFileReader();

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static int getWait(String wait) {
        String strWait = configFileReader.getProperty(wait);
        Assert.assertTrue(
                NumberUtils.isCreatable(strWait),
                "The given value of '" + wait +"' should be an INTEGER"
        );
        return Integer.parseInt(strWait);
    }
}
