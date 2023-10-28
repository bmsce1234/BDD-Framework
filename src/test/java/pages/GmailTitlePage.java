package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailTitlePage {

	private RemoteWebDriver driver;

	public GmailTitlePage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void close()throws Exception {
		Thread.sleep(5000);
		driver.close();
	}

	public List<Cookie> allCookies(){
		Set<Cookie> cookies=driver.manage().getCookies();
		return new ArrayList<>(cookies);
	}
}
