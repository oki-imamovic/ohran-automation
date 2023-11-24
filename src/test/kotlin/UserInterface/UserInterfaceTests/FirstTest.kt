package UserInterface.UserInterfaceTests // ktlint-disable package-name

import UserInterface.UserInterfacePages.FirstPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class FirstTest {

    private var driver: WebDriver? = null
    private var firstPage: FirstPage? = null

    @BeforeTest
    fun setupDriverAndPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/kotlin/chromedriver/chromedriver.exe")
        driver = ChromeDriver()
        firstPage = FirstPage(driver!!)
    }

    @AfterTest
    fun killDriver() {
        driver!!.quit()
    }

    @Test
    fun firstTest() {
        val url = "https://www.google.com/"
        driver!!.get(url)
        firstPage!!.isGoogleImgVisible()
        assertEquals(driver!!.currentUrl, url, "Web page URL did not match expected Value")
    }
}
