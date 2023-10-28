package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Purchase {

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;

	@FindBy(name = "proceedToRetailCheckout")
	private WebElement proceed;

	public Purchase(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickProceed() {
		wait.until(ExpectedConditions.elementToBeClickable(proceed)).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Select a delivery address']"))));

		driver.navigate().back();
	}
}
