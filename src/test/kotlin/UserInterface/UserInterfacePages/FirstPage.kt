package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class FirstPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//img[@alt='Google']")
    var googleImg: WebElement? = null

    val isGoogleImgVisible: Boolean get() = googleImg!!.isDisplayed
}
