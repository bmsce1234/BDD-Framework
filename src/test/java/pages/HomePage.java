package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage {

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	private Actions action;

	@FindBy(xpath = "//span[text()='Account & Lists']")
	private WebElement sign;

	@FindBy(xpath = "//span[text()='Sign Out']/parent::a")
	private WebElement signOut;

	public HomePage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action =new Actions(driver);
	}

	public void clickSignUp() {
		wait.until(ExpectedConditions.elementToBeClickable(sign)).click();
	}

	public boolean isSignInDisplay() {
		try {
			if(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("email")))).isDisplayed()){
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}

	public void signOut() {
		action.moveToElement(sign).perform();
		wait.until(ExpectedConditions.elementToBeClickable(signOut)).click();
	}

	public boolean isSignOutHappen() {
		if(this.isSignInDisplay()) {
			return true;
		}else {
			return false;
		}
	}
}