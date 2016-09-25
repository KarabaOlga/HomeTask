package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedProjectPage {

	private WebDriver driver;

	public CreatedProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[1]/div[2]/nav/a[1]")
	private WebElement projectsButton;

	public ProjectsPage getProjectsPage() {
		projectsButton.click();
		return new ProjectsPage(driver);
	}

}
