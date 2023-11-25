
package UserInterface.UserInterfaceTests // ktlint-disable package-name

import UserInterface.TestBase
import UserInterface.UserInterfacePages.ShoppingInventoryPage
import UserInterface.UserInterfacePages.ShoppingLoginPage
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
        shoppingLoginPage!!.inputUserName(USER_NAME)
        shoppingLoginPage!!.inputUserPassword(PASSWORD)
        shoppingLoginPage!!.clickOnLoginButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
    }

    companion object {
        const val USER_NAME: String = "standard_user"
        const val PASSWORD: String = "secret_sauce"
    }
}
