package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedMainPage {

	private WebDriver driver;

	public LoggedMainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(xpath = "//a[@class='btn btn-secondary shelf-cta']")
	private WebElement startProjectButton;

	public CreateRepositoryPage getCreateRepositoryPage() {
		startProjectButton.click();
		return new CreateRepositoryPage(driver);
	}

	@FindBy(xpath = "//ul[@id='user-links']/li[3]")
	private WebElement selectList;

	@FindBy(xpath = "//a[@data-ga-click='Header, go to profile, text:your profile']")
	private WebElement profileButton;

	public ProfilePage getProfilePage() {
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// }
		selectList.click();
		profileButton.click();
		return new ProfilePage(driver);
	}
}