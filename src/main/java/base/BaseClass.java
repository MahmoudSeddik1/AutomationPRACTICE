package base;


import automationpractice.pages.HomePage;
import automationpractice.utility.MyListenerClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class BaseClass {
    private Properties prop;
    private WebDriver driver;
    private WebDriver original;
    protected HomePage homepage;


    @BeforeTest
    public void loadConfig(){
        try{
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\Config.properties");
            prop.load(ip);
            System.out.println("driver"+ driver);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();

        }
    }
    @BeforeClass
    public void launchbrowser() {
        String browsername = prop.getProperty("browser");
        switch (browsername) {
            case "Chrome" -> {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\12378\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
                original = new ChromeDriver(Options());
                MyListenerClass listener = new MyListenerClass();
                driver = new EventFiringDecorator(listener).decorate(original);
                homepage = new HomePage(driver);

            }
        }
    }
    @BeforeMethod
    public void goHome(){
        driver.get(prop.getProperty("url"));
    }




    public ChromeOptions Options(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

//        options.setExperimentalOption("credentials_enable_service", false);     // was trying to disable save password prompt but i couldn't
//        options.setExperimentalOption("profile.password_manager_enabled", false);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("useAutomationExtension", false);

        options.setExperimentalOption("prefs", prefs);



//        options.setHeadless(true);
        return options;

    }
}
