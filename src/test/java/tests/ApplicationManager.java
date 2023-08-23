package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager {

    final String BASE_URL = PropertiesLoader.loadProperties("url");

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\SeleniumChromeDriver116\\chromedriver.exe");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    public void stop() {
        closeWebDriver();
    }
}
