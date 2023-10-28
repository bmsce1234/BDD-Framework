package gluecode;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GmailTitlePage;

public class Feature1 {

	private Shared sh;

	public Feature1(Shared sh) {
		this.sh =sh;
	}

	@Given ("Launch site using {string} URL")
	public void launchSite(String url) {
		WebDriverManager.chromedriver().setup();
		sh.driver =new ChromeDriver();
		sh.driver.get(url);

		sh.page = new GmailTitlePage(sh.driver);
	}

	@Then ("Title should be {string}")
	public void verifyTitle(String title) {
		if(sh.page.getTitle().contains(title)) {
			System.out.println("Title test passes");
		}else {
			System.out.println("Title test failed");
		}
	}

	@When ("close site")
	public void closeSite() throws Exception {
		sh.page.close();
	}

	@Then ("cookies should be loaded")
	public void verifyCookies() {
		if(sh.page.allCookies().size()>0) {
			System.out.println("cookies are loaded");
		}else {
			System.out.println("cookies are not loaded");
		}
	}
}
