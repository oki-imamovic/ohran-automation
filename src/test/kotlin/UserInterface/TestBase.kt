package UserInterface // ktlint-disable package-name

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest

abstract class TestBase {

    lateinit var driver: WebDriver
        private set

    @BeforeTest
    fun setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/kotlin/chromedriver/chromedriver.exe")
        driver = ChromeDriver()
        driver.manage()?.window()?.maximize()
    }

    @AfterTest
    fun kill() {
        driver.quit()
    }
}
