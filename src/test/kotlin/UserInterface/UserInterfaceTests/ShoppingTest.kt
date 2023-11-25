package UserInterface.UserInterfaceTests // ktlint-disable package-name

import UserInterface.TestBase
import UserInterface.UserInterfacePages.* // ktlint-disable no-wildcard-imports
import org.testng.Assert.assertFalse
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class ShoppingTest : TestBase() {

    private var shoppingLoginPage: ShoppingLoginPage? = null
    private var shoppingInventoryPage: ShoppingInventoryPage? = null
    private var shoppingCartPage: ShoppingCartPage? = null
    private var shoppingItemPage: ShoppingItemPage? = null
    private var shoppingCashOutPage: ShoppingCashOutPage? = null
    private val url = "https://www.saucedemo.com/"

    @BeforeClass
    fun initPageObjects() {
        shoppingLoginPage = ShoppingLoginPage(driver)
        shoppingInventoryPage = ShoppingInventoryPage(driver)
        shoppingCartPage = ShoppingCartPage(driver)
        shoppingItemPage = ShoppingItemPage(driver)
        shoppingCashOutPage = ShoppingCashOutPage(driver)
    }

    @Test
    fun shoppingTest() {
        driver.get(url)
        assertTrue(shoppingLoginPage!!.isLoginPageDisplayed)
        shoppingLoginPage!!.doLogin(WRONG_USER_NAME, PASSWORD)
        assertTrue(shoppingLoginPage!!.isLoginErrorDisplayed)
        shoppingLoginPage!!.doLogin(USER_NAME, WRONG_PASSWORD)
        assertTrue(shoppingLoginPage!!.isLoginErrorDisplayed)
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
        shoppingInventoryPage!!.clickOnCart()
        assertFalse(shoppingCartPage!!.areCartItemExisting())
        shoppingCartPage!!.clickOnContinueShoppingButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.clickInventoryItemLink(BACKPACK)
        assertTrue(shoppingItemPage!!.itemNameCheck(BACKPACK))
        shoppingItemPage!!.clickOnAddRemoveToCart()
        assertFalse(shoppingItemPage!!.buttonTextAddRemove())
        shoppingItemPage!!.clickOnBackToProductButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.clickInventoryItemLink(SHIRT)
        assertTrue(shoppingItemPage!!.itemNameCheck(SHIRT))
        shoppingItemPage!!.clickOnAddRemoveToCart()
        assertFalse(shoppingItemPage!!.buttonTextAddRemove())
        shoppingItemPage!!.clickOnBackToProductButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.clickInventoryItemLink(JACKET)
        assertTrue(shoppingItemPage!!.itemNameCheck(JACKET))
        shoppingItemPage!!.clickOnAddRemoveToCart()
        assertFalse(shoppingItemPage!!.buttonTextAddRemove())
        shoppingItemPage!!.clickOnBackToProductButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.clickOnCart()
        assertTrue(shoppingCartPage!!.areCartItemExisting())
        shoppingCartPage!!.removeItemFromCart()
        shoppingCartPage!!.clickOnContinueShoppingButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.clickInventoryItemLink(SHIRT)
        assertTrue(shoppingItemPage!!.itemNameCheck(SHIRT))
        shoppingItemPage!!.clickOnAddRemoveToCart()
        assertTrue(shoppingItemPage!!.buttonTextAddRemove())
        shoppingItemPage!!.clickOnBackToProductButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.clickOnCart()
        assertTrue(shoppingCartPage!!.areCartItemExisting())
        shoppingCartPage!!.clickOnCheckoutButton()
        assertTrue(shoppingCashOutPage!!.isCashOutFormVisible)
        shoppingCashOutPage!!.fillOutForm(FIRST_NAME, LAST_NAME, ZIP_CODE)
        assertTrue(shoppingCashOutPage!!.isSummaryContainerVisible)
        shoppingCashOutPage!!.clickOnFinishButton()
        assertTrue(shoppingCashOutPage!!.isCompleteContainerVisible)
        shoppingCashOutPage!!.clickOnBackHomeButton()
        assertTrue(shoppingInventoryPage!!.isInventoryListContainerDisplayed)
        shoppingInventoryPage!!.doLogOut()
        assertTrue(shoppingLoginPage!!.isLoginPageDisplayed)
    }

    companion object {
        const val WRONG_USER_NAME: String = "wrong_user_name"
        const val WRONG_PASSWORD: String = "wrong_password"
        const val USER_NAME: String = "standard_user"
        const val PASSWORD: String = "secret_sauce"
        const val BACKPACK: String = "Sauce Labs Backpack"
        const val SHIRT: String = "Sauce Labs Onesie"
        const val JACKET: String = "Sauce Labs Fleece Jacket"
        const val SORT_A_TO_Z: String = "Name (A to Z)"
        const val SORT_Z_TO_A: String = "Name (Z to A)"
        const val SORT_PRICE_LOW_TO_HIGH: String = "Price (low to high)"
        const val SORT_PRICE_HIGH_TO_LOW: String = "Price (high to low)"
        const val FIRST_NAME: String = "Jafar"
        const val LAST_NAME: String = "Jefferson"
        const val ZIP_CODE: String = "321123"
    }
}
