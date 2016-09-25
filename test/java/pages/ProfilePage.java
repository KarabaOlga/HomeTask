package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	private WebDriver driver;

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@class='btn btn-block mb-3']")
	private WebElement editButton;

	@FindBy(xpath = "//span[@class='vcard-username d-block']")
	private WebElement username;

	@FindBy(xpath = "//a[@href='/KarabaOlga?tab=repositories']")
	private WebElement repositoriesButton;

	public PersonalSettingPage getPersonalSettingPage() {
		editButton.click();
		return new PersonalSettingPage(driver);
	}

	public ProfileRepositoriesPage getProfileRepositoriesPage() {
		repositoriesButton.click();
		return new ProfileRepositoriesPage(driver);
	}

	public String getUserName() {
		return username.getText().trim();
	}

}
