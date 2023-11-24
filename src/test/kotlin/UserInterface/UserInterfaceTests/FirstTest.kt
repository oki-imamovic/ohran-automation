package UserInterface.UserInterfaceTests // ktlint-disable package-name

import UserInterface.BaseTest
import UserInterface.UserInterfacePages.FirstPage
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class FirstTest : BaseTest() {

    private var firstPage: FirstPage? = null

    @BeforeClass
    fun initPageObjects() {
        firstPage = FirstPage(driver)
    }

    @Test
    fun firstTest() {
        val url = "https://www.google.com/"
        driver.get(url)
        assertTrue(firstPage!!.isGoogleImgVisible, "Google Image is missing")
        assertEquals(driver.currentUrl, url, "Web page URL did not match expected Value")
    }
}
