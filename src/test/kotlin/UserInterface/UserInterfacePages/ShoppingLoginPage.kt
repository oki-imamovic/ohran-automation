
package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ShoppingLoginPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(id = "user-name")
    var loginPageUserNameInputField: WebElement? = null

    @FindBy(id = "password")
    var loginPagePasswordInputField: WebElement? = null

    @FindBy(id = "login-button")
    var loginPageLoginButton: WebElement? = null

    @FindBy(className = "error-button")
    var loginErrorButton: WebElement? = null

    @FindBy(xpath = "//div[@class='login_wrapper-inner']")
    var loginFormWrapper: WebElement? = null

    val isLoginPageDisplayed: Boolean get() = loginFormWrapper!!.isDisplayed
    val isLoginErrorDisplayed: Boolean get() = loginErrorButton!!.isDisplayed

    private fun clickOnLoginButton() {
        loginPageLoginButton!!.click()
    }

    private fun inputUserName(userName: String) {
        loginPageUserNameInputField!!.click()
        loginPageUserNameInputField!!.clear()
        loginPageUserNameInputField!!.sendKeys(userName)
    }

    private fun inputUserPassword(password: String) {
        loginPagePasswordInputField!!.click()
        loginPagePasswordInputField!!.clear()
        loginPagePasswordInputField!!.sendKeys(password)
    }

    fun doLogin(userName: String, password: String) {
        inputUserName(userName)
        inputUserPassword(password)
        clickOnLoginButton()
    }
}
