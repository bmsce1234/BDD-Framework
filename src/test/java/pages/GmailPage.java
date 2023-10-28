package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class GmailPage {
	
	@FindBy(name = "identifier")
	private WebElement userName;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement next;

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	
	public GmailPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUNDisplayed() {
		if(userName.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void fillUN(String value) {
		wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(value);
	}
	
	public void clickNext() {
		wait.until(ExpectedConditions.elementToBeClickable(next)).click();
	}
	
	public void close() {
		driver.close();
	}
}
