package UserInterface.UserInterfaceTests // ktlint-disable package-name

import UserInterface.TestBase
import UserInterface.UserInterfacePages.GooglePage
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class GoogleSearchTest : TestBase() {

    private var googlePage: GooglePage? = null
    private val url = "https://www.google.com/"

    @BeforeClass
    fun initPageObjects() {
        googlePage = GooglePage(driver)
    }

    @Test
    fun youTubeSongPlayTest() {
        driver.get(url)
        assertTrue(googlePage!!.isGoogleSearchVisible, "Google Search is not visible")
        googlePage!!.searchGoogle("Never Gonna Give You Up")
        googlePage!!.clickOnFirstVideo()
        Thread.sleep(1500)
        googlePage!!.clickOnPrimaryPageField()
        Thread.sleep(300000)
    }
}
