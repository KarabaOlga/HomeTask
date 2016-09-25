package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalSettingPage {

	private WebDriver driver;

	public PersonalSettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "///img[@class='avatar float-left']")
	private WebElement avatar;

	@FindBy(xpath = "//input[@id='upload-profile-picture']")
	private WebElement uploadPictureButton;

	@FindBy(xpath = "//input[@id='user_profile_name']")
	private WebElement name;

	@FindBy(xpath = "//textarea[@id='user_profile_bio']")
	private WebElement bio;

	@FindBy(xpath = "//input[@id='user_profile_location']']")
	private WebElement location;

	@FindBy(xpath = "//button[text()='Update profile']")
	private WebElement updateProfileButton;

	public PersonalSettingPage getPersonalSettingPage(String name1, String biography, String location1) {
		name.clear();
		name.sendKeys(name1);
		bio.sendKeys(biography);
		location.sendKeys(location1);
		updateProfileButton.click();
		return new PersonalSettingPage(driver);
	}

	@FindBy(xpath = "//a[@data-selected-links=' /settings/emails']")
	private WebElement emailsButton;

	public SettingEmailsPage getSettingEmailsPage() {
		emailsButton.click();
		return new SettingEmailsPage(driver);
	}

	@FindBy(xpath = "//a[@data-selected-links=' /settings/repositories']")
	private WebElement repositoriesButton;

	public SettingRepositoriesPage getSettingRepositoriesPage() {
		repositoriesButton.click();
		return new SettingRepositoriesPage(driver);
	}

}
	
	
	
	
	
	
	
	
