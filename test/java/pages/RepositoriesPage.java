package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepositoriesPage {

	private WebDriver driver;

	public RepositoriesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[1]/div[2]/nav/a[1]")
	private WebElement projectsButton;

	@FindBy(xpath = "//ul[@id='user-links']/li[3]")
	private WebElement selectList;

	@FindBy(xpath = "//a[@data-ga-click='Header, go to profile, text:your profile']")
	private WebElement profileButton;

	@FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
	private WebElement repositoriesName;

	public String getRepositoriesName() {
		return repositoriesName.getText().trim();
	}

	public ProjectsPage getProjectsPage() {
		projectsButton.click();
		return new ProjectsPage(driver);
	}

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
