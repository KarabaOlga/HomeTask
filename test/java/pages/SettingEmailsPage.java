package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingEmailsPage {

	private WebDriver driver;

	public SettingEmailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@class='form-control short']")
	private WebElement emailAdress;

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement addEmailButton;

	@FindBy(xpath = "//ul[@id='settings-emails']/li/span[1]")
	private WebElement primaryEmail;

	public SettingEmailsPage getSettingEmailsPage(String email) {
		emailAdress.sendKeys(email);
		addEmailButton.click();
		return new SettingEmailsPage(driver);
	}

	public String getPrimaryEmail() {
		return primaryEmail.getText().trim();
	}

}