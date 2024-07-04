package nassih.test.automation.utils;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Context {

    /*
    * Context Class is used to change data between different steps
    */
    private static final Map<String, Object> context = new HashMap<>();
    public static void setContext(String key, Object value) {
        context.put(key, value);
    }
    public static Object getContext(String key) {
        Assert.assertTrue(
                context.containsKey(key),
                "Context DO NOT Contain the key: " + key
        );
        return context.get(key);
    }

}
