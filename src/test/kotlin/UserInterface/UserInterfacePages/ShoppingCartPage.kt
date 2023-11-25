package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ShoppingCartPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(id = "continue-shopping")
    var continueShoppingButton: WebElement? = null

    @FindBy(id = "checkout")
    var checkoutButton: WebElement? = null

    @FindBy(className = "cart_item")
    var cartItem: MutableList<WebElement>? = null

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    var removeButtonList: MutableList<WebElement>? = null

    fun clickOnContinueShoppingButton() {
        continueShoppingButton!!.click()
    }

    fun clickOnCheckoutButton() {
        checkoutButton!!.click()
    }

    fun removeItemFromCart() {
        removeButtonList!![0].click()
    }

    fun areCartItemExisting(): Boolean {
        return cartItem?.any { it.isDisplayed } ?: false
    }
}
