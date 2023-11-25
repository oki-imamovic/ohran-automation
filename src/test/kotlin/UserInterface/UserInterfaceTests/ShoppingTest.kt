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
        val loginPage = shoppingLoginPage!!
        val inventoryPage = shoppingInventoryPage!!
        val cartPage = shoppingCartPage!!
        val itemPage = shoppingItemPage!!
        val cashOutPage = shoppingCashOutPage!!

        assertTrue(loginPage.isLoginPageDisplayed)
        loginPage.doLogin(WRONG_USER_NAME, PASSWORD)
        assertTrue(loginPage.isLoginErrorDisplayed)
        loginPage.doLogin(USER_NAME, WRONG_PASSWORD)
        assertTrue(loginPage.isLoginErrorDisplayed)
        loginPage.doLogin(USER_NAME, PASSWORD)
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.sortItems(SORT_Z_TO_A)
        assertFalse(inventoryPage.hasListOrderChanged(BACKPACK))
        inventoryPage.sortItems(SORT_PRICE_LOW_TO_HIGH)
        assertFalse(inventoryPage.hasListOrderChanged(BACKPACK))
        inventoryPage.sortItems(SORT_PRICE_HIGH_TO_LOW)
        assertFalse(inventoryPage.hasListOrderChanged(BACKPACK))
        inventoryPage.sortItems(SORT_A_TO_Z)
        assertTrue(inventoryPage.hasListOrderChanged(BACKPACK))
        inventoryPage.clickOnCart()
        assertFalse(cartPage.areCartItemExisting())
        cartPage.clickOnContinueShoppingButton()
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.clickInventoryItemLink(BACKPACK)
        assertTrue(itemPage.itemNameCheck(BACKPACK))
        itemPage.clickOnAddRemoveToCart()
        assertFalse(itemPage.buttonTextAddRemove())
        itemPage.clickOnBackToProductButton()
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.clickInventoryItemLink(SHIRT)
        assertTrue(itemPage.itemNameCheck(SHIRT))
        itemPage.clickOnAddRemoveToCart()
        assertFalse(itemPage.buttonTextAddRemove())
        itemPage.clickOnBackToProductButton()
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.clickInventoryItemLink(JACKET)
        assertTrue(itemPage.itemNameCheck(JACKET))
        itemPage.clickOnAddRemoveToCart()
        assertFalse(itemPage.buttonTextAddRemove())
        itemPage.clickOnBackToProductButton()
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.clickOnCart()
        assertTrue(cartPage.areCartItemExisting())
        cartPage.removeItemFromCart()
        cartPage.clickOnContinueShoppingButton()
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.clickInventoryItemLink(SHIRT)
        assertTrue(itemPage.itemNameCheck(SHIRT))
        itemPage.clickOnAddRemoveToCart()
        assertTrue(itemPage.buttonTextAddRemove())
        itemPage.clickOnBackToProductButton()
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.clickOnCart()
        assertTrue(cartPage.areCartItemExisting())
        cartPage.clickOnCheckoutButton()
        assertTrue(cashOutPage.isCashOutFormVisible)
        cashOutPage.fillOutForm(FIRST_NAME, LAST_NAME, ZIP_CODE)
        assertTrue(cashOutPage.isSummaryContainerVisible)
        cashOutPage.clickOnFinishButton()
        assertTrue(cashOutPage.isCompleteContainerVisible)
        cashOutPage.clickOnBackHomeButton()
        assertTrue(inventoryPage.isInventoryListContainerDisplayed)
        inventoryPage.doLogOut()
        assertTrue(loginPage.isLoginPageDisplayed)
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
