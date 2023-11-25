
package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ShoppingInventoryPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(className = "inventory_list")
    var inventoryListContainer: WebElement? = null

    @FindBy(className = "product_sort_container")
    var sortDropMenu: WebElement? = null

    @FindBy(className = "inventory_item_name")
    var inventoryItemsList: MutableList<WebElement>? = null

    @FindBy(xpath = "//select[@class='product_sort_container']//option")
    var sortOptions: MutableList<WebElement>? = null

    val isInventoryListContainerDisplayed: Boolean get() = inventoryListContainer!!.isDisplayed

    fun hasListOrderChanged(itemName: String): Boolean {
        if (inventoryItemsList!![0].text == itemName) {
            return true
        }
        return false
    }

    fun sortItems(sortOption: String) {
        var attempts = 0
        while (attempts < MAX_ATTEMPTS) {
            try {
                sortDropMenu!!.click()
                for (option in sortOptions!!) {
                    if (option.text == sortOption) {
                        option.click()
                        return
                    }
                }
            } catch (e: StaleElementReferenceException) {
                attempts++
            }
        }
        println("Element not found after $MAX_ATTEMPTS attempts.")
    }

    companion object {
        const val MAX_ATTEMPTS = 3
    }
}
