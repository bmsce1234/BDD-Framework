package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CartPage {

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;

	@FindBy(id = "nav-cart")
	private WebElement cart;

	@FindBys({
		@FindBy(xpath = "//div[@data-name='Active Items']/div[not(@style='display:none;')]")
	})
	private List<WebElement> itemsList;

	////div[@data-name='Active Items']/div[not(@style='display:none;')]

	public CartPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
	}

	public boolean isClearCart() {
		if(itemsList.size()>0) {
			for(WebElement item:itemsList) {
				item.findElement(By.xpath("descendant::input[4]")).click();
			}
				return true;
			}else {
			return false;
		}
	}

	public void removeFromCart() {
		WebElement hEle=wait.until(ExpectedConditions.visibilityOfAllElements(itemsList)).get(1);

		hEle.findElement(By.xpath("descendant::input[4]")).click();
	}
}
