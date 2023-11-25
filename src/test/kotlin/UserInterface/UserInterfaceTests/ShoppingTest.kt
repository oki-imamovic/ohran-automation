
package UserInterface.UserInterfaceTests // ktlint-disable package-name

import UserInterface.TestBase
import UserInterface.UserInterfacePages.ShoppingInventoryPage
import UserInterface.UserInterfacePages.ShoppingLoginPage
import org.testng.Assert.assertFalse
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class ShoppingTest : TestBase() {

    private var shoppingLoginPage: ShoppingLoginPage? = null
    private var shoppingInventoryPage: ShoppingInventoryPage? = null
    private val url = "https://www.saucedemo.com/"

    @BeforeClass
    fun initPageObjects() {
        shoppingLoginPage = ShoppingLoginPage(driver)
        shoppingInventoryPage = ShoppingInventoryPage(driver)
    }

    @Test
    fun shoppingTest() {
        driver.get(url)
        assertTrue(shoppingLoginPage!!.isLoginPageDisplayed)
        // wrong username check
        shoppingLoginPage!!.doLogin(WRONG_USER_NAME, PASSWORD)
        assertTrue(shoppingLoginPage!!.isLoginErrorDisplayed)
        // wrong password
        shoppingLoginPage!!.doLogin(USER_NAME, WRONG_PASSWORD)
        assertTrue(shoppingLoginPage!!.isLoginErrorDisplayed)
        // right login
        shoppingLoginPage!!.doLogin(USER_NAME, PASSWORD)
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.sortItems(SORT_Z_TO_A)
        assertFalse(shoppingInventoryPage!!.hasListOrderChanged(BACKPACK))
        shoppingInventoryPage!!.sortItems(SORT_PRICE_LOW_TO_HIGH)
        assertFalse(shoppingInventoryPage!!.hasListOrderChanged(BACKPACK))
        shoppingInventoryPage!!.sortItems(SORT_PRICE_HIGH_TO_LOW)
        assertFalse(shoppingInventoryPage!!.hasListOrderChanged(BACKPACK))
        shoppingInventoryPage!!.sortItems(SORT_A_TO_Z)
        assertTrue(shoppingInventoryPage!!.hasListOrderChanged(BACKPACK))
    }

    companion object {
        const val WRONG_USER_NAME: String = "wrong_user_name"
        const val WRONG_PASSWORD: String = "wrong_password"
        const val USER_NAME: String = "standard_user"
        const val PASSWORD: String = "secret_sauce"
        const val BACKPACK: String = "Sauce Labs Backpack"
        const val SORT_A_TO_Z: String = "Name (A to Z)"
        const val SORT_Z_TO_A: String = "Name (Z to A)"
        const val SORT_PRICE_LOW_TO_HIGH: String = "Price (low to high)"
        const val SORT_PRICE_HIGH_TO_LOW: String = "Price (high to low)"
    }
}
