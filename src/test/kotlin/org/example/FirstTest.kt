package org.example

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class FirstTest {

    private var driver: WebDriver? = null

    @BeforeTest
    fun createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/kotlin/chromedriver/chromedriver.exe")
        driver = ChromeDriver()
    }

    @AfterTest
    fun killDriver() {
        driver!!.quit()
    }

    @Test
    fun firstTest() {
        val url = "https://www.google.com/"
        driver!!.get(url)
        assertEquals(driver!!.currentUrl, url, "Web page URL did not match expected Value")
    }
}
