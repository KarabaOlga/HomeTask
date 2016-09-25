package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	private WebDriver driver;

	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name='login']")
	private WebElement mail;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement pass;

	@FindBy(xpath = "//input[@name='commit']")
	private WebElement button;

	public LoggedMainPage getLoggedMainPage(String email, String pass1) {
		mail.clear();
		mail.sendKeys(email);
		pass.sendKeys(pass1);
		button.click();

		return new LoggedMainPage(driver);
	}

	public LoggedMainPage getLoggedMainPage2(String username1, String pass1) {
		username.clear();
		username.sendKeys(username1);
		pass.sendKeys(pass1);
		button.click();

		return new LoggedMainPage(driver);
	}
}
