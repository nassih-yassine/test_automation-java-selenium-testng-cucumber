package nassih.test.automation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTools {
    protected static final Logger log = LoggerFactory.getLogger(BaseTools.class);

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
