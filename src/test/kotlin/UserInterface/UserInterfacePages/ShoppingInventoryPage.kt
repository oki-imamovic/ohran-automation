
package UserInterface.UserInterfacePages // ktlint-disable package-name

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

    val isInventoryListContainerDisplayed: Boolean get() = inventoryListContainer!!.isDisplayed
}