package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ShoppingItemPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(className = "inventory_details_name")
    var itemName: WebElement? = null

    @FindBy(className = "btn_inventory")
    var addToCartButton: WebElement? = null

    @FindBy(id = "back-to-products")
    var backToProductButton: WebElement? = null

    fun clickOnBackToProductButton() {
        backToProductButton!!.click()
    }

    fun clickOnAddRemoveToCart() {
        addToCartButton!!.click()
    }

    fun buttonTextAddRemove(): Boolean {
        if (addToCartButton!!.text == "Add to cart") {
            return true
        }
        return false
    }

    fun itemNameCheck(item: String): Boolean {
        if (itemName!!.text == item) {
            return true
        }
        return false
    }
}
