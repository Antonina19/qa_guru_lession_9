package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //System.setProperty("selenoid.url", "http://localhost:4444/wd/hub"); // для запуска тестов через докер
        //System.setProperty("selenoid.url", "http://test:test-password@localhost:4445/wd/hub"); // для запуска тестов через докер с настройками ggr

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true); // для запуска тестов через докер
        capabilities.setCapability("enableVideo", true); // для запуска тестов через докер

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        //Configuration.remote = System.getProperty("selenoid.url"); // для запуска тестов через докер
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenhot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
