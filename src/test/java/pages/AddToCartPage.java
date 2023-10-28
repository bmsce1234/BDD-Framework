package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage {

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	private Select select;

	@FindBy(name = "url")
	private WebElement product;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement search;

	@FindBys({
		@FindBy(xpath = "//div[contains(@class,'s-main-slot s-result-list')]/div[starts-with(@data-asin,'B0')]")
	})
	private List<WebElement> productList;

	@FindBy(xpath = "//button[text()=' Add to Cart ']")
	private WebElement addToCart;

	public AddToCartPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void selectElecectronics() {
		select = new Select(product);

		select.selectByVisibleText("Electronics");
	}

	public void searchHeadPhones() {

		wait.until((ExpectedConditions.visibilityOf(search))).sendKeys("Headphones",Keys.ENTER);
	}

	public void addFirstHeadphoneToCart() {
		System.out.println(productList.size());
		WebElement e=(productList.get(0));

		WebElement e1=e.findElement(By.xpath("/child::div/descendant::div[10]"));

		driver.executeScript("arguments[0].click();", e1);

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> handles=driver.getWindowHandles();
		List<String> lHandles =new ArrayList<>(handles);

		driver.switchTo().window(lHandles.get(1));

		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

		driver.switchTo().window(lHandles.get(0));
	}

	public void fillMacBook(String mac) {
		wait.until(ExpectedConditions.visibilityOf(search)).clear();
		search.sendKeys(mac,Keys.ENTER);
	}

	public void addMacToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(productList.get(1))).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> handles=driver.getWindowHandles();
		List<String> lHandles =new ArrayList<>(handles);

		driver.switchTo().window(lHandles.get(1));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

		driver.switchTo().window(lHandles.get(0));
	}
}
