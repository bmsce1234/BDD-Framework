package gluecode;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GmailPage;

public class GmailFeature {

	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	GmailPage page;
	
	
	@Given ("open browser and launch {string} site")
	public void launchSite(String URL) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get(URL);
		
		wait=new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(200));
		wait.withTimeout(Duration.ofSeconds(20));
		
		page=new GmailPage(driver, wait);
	}
	
	@When ("Username should be visible")
	public void isVisible() {
		if(page.isUNDisplayed()) {
			System.out.println("username is displayed");
			Assert.assertTrue(true);
		}else {
			System.out.println("username not displayed");
			Assert.assertTrue(false);
		}
	}
	
	@Then ("send {string} value to UserName")
	public void fill(String val) {
		page.fillUN(val);
	}
	
	@And ("click on next button")
	public void click() {
		page.clickNext();
	}
	
	@And ("quit site")
	public void close() {
		page.close();
	}
}
