package com.automatedtest.basepage;

import com.automatedtest.infrastructure.driver.Setup;
import com.automatedtest.infrastructure.driver.Wait;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public Wait wait;
    private static final String CONFIGFILEPATH = "src/test/resources/config.properties";
    public static Properties properties;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }

    static {
        File file = new File(CONFIGFILEPATH);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
