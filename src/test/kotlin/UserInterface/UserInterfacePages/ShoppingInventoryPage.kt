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

    @FindBy(id = "react-burger-menu-btn")
    var burgerMenuDrop: WebElement? = null

    @FindBy(id = "logout_sidebar_link")
    var logOutLink: WebElement? = null

    @FindBy(className = "inventory_list")
    var inventoryListContainer: WebElement? = null

    @FindBy(className = "product_sort_container")
    var sortDropMenu: WebElement? = null

    @FindBy(className = "shopping_cart_link")
    var cartIcon: WebElement? = null

    @FindBy(className = "inventory_item_name")
    var inventoryItemsList: MutableList<WebElement>? = null

    @FindBy(xpath = "//select[@class='product_sort_container']//option")
    var sortOptions: MutableList<WebElement>? = null

    val isInventoryListContainerDisplayed: Boolean get() = inventoryListContainer!!.isDisplayed

    fun clickOnCart() {
        cartIcon!!.click()
    }

    private fun clickOnBurgerMenu() {
        burgerMenuDrop!!.click()
    }

    private fun clickOnLogOutLink() {
        logOutLink!!.click()
    }

    fun doLogOut() {
        clickOnBurgerMenu()
        // Have to leave this Thread.sleep(1.5 seconds) because the link is not clickable until those 1.5 seconds pass...
        Thread.sleep(1500)
        clickOnLogOutLink()
    }

    fun hasListOrderChanged(itemName: String): Boolean {
        if (inventoryItemsList!![0].text == itemName) {
            return true
        }
        return false
    }

    fun clickInventoryItemLink(itemName: String) {
        var attempts = 0
        while (attempts < MAX_ATTEMPTS) {
            try {
                for (item in inventoryItemsList!!) {
                    if (item.text == itemName) {
                        item.click()
                        return
                    }
                }
            } catch (e: StaleElementReferenceException) {
                attempts++
            }
        }
        println("Element not found after $MAX_ATTEMPTS attempts.")
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
        const val MAX_ATTEMPTS: Int = 3
    }
}
