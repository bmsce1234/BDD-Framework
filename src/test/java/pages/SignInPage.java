package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SignInPage {

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;

	@FindBy(name = "email")
	private WebElement emailText;

	@FindBy(id = "continue")
	private WebElement ok;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(id = "signInSubmit")
	private WebElement signIn;

	public SignInPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void fillEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailText)).sendKeys(email);
	}

	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(ok)).click();
	}

	public void fillPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
	}

	public void clickSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
	}

	public boolean isLoggedIn() {
		try {
			if(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("twotabsearchtextbox")))).isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
}
