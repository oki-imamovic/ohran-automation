
package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GooglePage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    var googleSearch: WebElement? = null

    @FindBy(xpath = "//a[@jsname='UWckNb']")
    var googleResultsLinkList: WebElement? = null

    @FindBy(xpath = "//div[@id='columns']//div[@id='primary']")
    var primaryPageField: WebElement? = null

    val isGoogleSearchVisible: Boolean get() = googleSearch!!.isDisplayed

    fun searchGoogle(value: String) {
        googleSearch!!.sendKeys(value)
        googleSearch!!.sendKeys(Keys.ENTER)
    }

    fun clickOnFirstVideo() {
        googleResultsLinkList!!.click()
    }

    fun clickOnPrimaryPageField() {
        primaryPageField!!.click()
    }
}
