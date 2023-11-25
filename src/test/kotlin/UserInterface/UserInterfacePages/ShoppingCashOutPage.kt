package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ShoppingCashOutPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(id = "first-name")
    var firstNameInput: WebElement? = null

    @FindBy(id = "last-name")
    var lastNameInput: WebElement? = null

    @FindBy(id = "postal-code")
    var zipCodeInput: WebElement? = null

    @FindBy(id = "continue")
    var continueButton: WebElement? = null

    @FindBy(id = "finish")
    var finishButton: WebElement? = null

    @FindBy(id = "checkout_complete_container")
    var completeContainer: WebElement? = null

    @FindBy(id = "back-to-products")
    var backToHomeButton: WebElement? = null

    @FindBy(className = "checkout_info")
    var cashOutForm: WebElement? = null

    @FindBy(className = "summary_info")
    var summaryContainer: WebElement? = null

    val isCashOutFormVisible: Boolean get() = cashOutForm!!.isDisplayed
    val isSummaryContainerVisible: Boolean get() = summaryContainer!!.isDisplayed
    val isCompleteContainerVisible: Boolean get() = completeContainer!!.isDisplayed

    fun clickOnFinishButton() {
        finishButton!!.click()
    }

    fun clickOnBackHomeButton() {
        backToHomeButton!!.click()
    }

    private fun clickOnContinueButton() {
        continueButton!!.click()
    }

    private fun inputFirstName(firstName: String) {
        firstNameInput!!.click()
        firstNameInput!!.clear()
        firstNameInput!!.sendKeys(firstName)
    }

    private fun inputLastName(lastName: String) {
        lastNameInput!!.click()
        lastNameInput!!.clear()
        lastNameInput!!.sendKeys(lastName)
    }

    private fun inputZipCode(zipCode: String) {
        zipCodeInput!!.click()
        zipCodeInput!!.clear()
        zipCodeInput!!.sendKeys(zipCode)
    }

    fun fillOutForm(firstName: String, lastName: String, zipCode: String) {
        inputFirstName(firstName)
        inputLastName(lastName)
        inputZipCode(zipCode)
        clickOnContinueButton()
    }
}
