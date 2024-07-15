package nassih.test.automation.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFileReader {
    protected static final Logger log = LoggerFactory.getLogger(ConfigFileReader.class);
    private final Properties properties;

    public ConfigFileReader() {
        try (InputStream input = new FileInputStream(getPathToResourceDir() + "/application.properties")) {
            properties = new Properties();
            Assert.assertNotNull(
                    input,
                    "Application Properties file is NOT Found in Resources Directory"
            );

            log.atInfo()
                    .setMessage("Loading Application Properties File")
                    .log();

            properties.load(input);
        } catch (IOException e) {
            log.atError()
                    .setMessage("Error while Loading Application Properties File.")
                    .log();
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getProperty(String name) {
        String prop = properties.getProperty(name);
        Assert.assertNotNull(
                prop,
                "There is No such Property, " + name + " in Application Properties File"
        );
        log.atInfo()
                .setMessage("Got '" + name + "' from Properties File.")
                .log();
    return prop;
    }

     private String getPathToResourceDir() {
        Path resourceDirectory = Paths.get("src","test","resources");
        return resourceDirectory.toFile().getAbsolutePath();
    }
}
