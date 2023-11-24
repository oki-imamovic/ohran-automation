package UserInterface.UserInterfacePages // ktlint-disable package-name

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class FirstPage(val driver: WebDriver) {
    val googleImg: By = By.xpath("//img[@alt='Google']")
}
