package gluecode;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCartPage;
import pages.CartPage;
import pages.HomePage;
import pages.SignInPage;

public class Scenario1 {

	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	HomePage homePage;
	SignInPage signPage;
	CartPage cartPage;
	AddToCartPage addtoCart;

	@Given ("I am on the Login page URL {string}")
	public void launchSite(String url) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();

		wait=new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(150));

		homePage =new HomePage(driver, wait);
		signPage = new SignInPage(driver, wait);
		cartPage =new CartPage(driver, wait);
		addtoCart = new AddToCartPage(driver, wait);
	}

	@Then ("I click on sign in button and wait for sign in page")
	public void signIn() {
		homePage.clickSignUp();
	}

	@Then ("I should see Sign In Page")
	public void showSignInPage() {
		if(homePage.isSignInDisplay()) {
			System.out.println("sign in page displayed");
		}else {
			System.out.println("sign in page displayed");
		}
	}

	@When ("I enter username as {string}")
	public void userName(String user) {
		signPage.fillEmail(user);
	}

	@And ("I Click on Continue button")
	public void continueBtn() {
		signPage.clickContinue();
	}

	@And ("I enter password as {string}")
	public void password(String pass) {
		signPage.fillPassword(pass);
	}

	@And ("click on login button")
	public void login() {
		signPage.clickSignIn();
	}

	@Then ("I am logged in")
	public void loggedIn() {
		if(signPage.isLoggedIn()) {
			System.out.println("logged in successfully");
		}else {
			System.out.println("logging not happened");
		}
	}

	@And ("I clear cart items if any")
	public void clearCart() {
		cartPage.clickCart();
		if(cartPage.isClearCart()) {
			System.out.println("clear cart");
		}else {
			System.out.println("no item in cart");
		}
	}

	@Then ("I choose Electronincs>Headphones and headphones list out")
	public void chooseHeadphones() {
		addtoCart.selectElecectronics();
		addtoCart.searchHeadPhones();
	}

	@Then ("I add first availabe headphone to cart")
	public void addFirstHeadPhone() {
		addtoCart.addFirstHeadphoneToCart();
	}
}
