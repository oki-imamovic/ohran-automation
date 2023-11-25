
package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ShoppingLoginPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//div[@class='login_wrapper-inner']")
    var loginFormWrapper: WebElement? = null

    @FindBy(id = "user-name")
    var loginPageUserNameInputField: WebElement? = null

    @FindBy(id = "password")
    var loginPagePasswordInputField: WebElement? = null

    @FindBy(id = "login-button")
    var loginPageLoginButton: WebElement? = null

    val isLoginPageDisplayed: Boolean get() = loginFormWrapper!!.isDisplayed

    fun inputUserName(userName: String) {
        loginPageUserNameInputField!!.click()
        loginPageUserNameInputField!!.sendKeys(userName)
    }

    fun inputUserPassword(password: String) {
        loginPagePasswordInputField!!.click()
        loginPagePasswordInputField!!.sendKeys(password)
    }

    fun clickOnLoginButton() {
        loginPageLoginButton!!.click()
    }
}
