package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.GmailTitlePage;

public class Shared {

	public RemoteWebDriver driver;
	public FluentWait<RemoteWebDriver> wait;
	public GmailTitlePage page;
	public Scenario sc;


	@Before
	public void initAll(Scenario sc) {
		this.sc=sc;

		sc.log(sc.getName() +" started execution");
		page = new GmailTitlePage(driver);
	}

	@After
	public void completeExe(Scenario sc) {
		this.sc=sc;

		sc.log(sc.getName() +" complete exec");
	}
}
