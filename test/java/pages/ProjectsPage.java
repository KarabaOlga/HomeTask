package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {

	private WebDriver driver;

	public ProjectsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement createProjectButton;

	@FindBy(xpath = "//div/div[2]/h4/a[@class='text-gray-dark']")
	private WebElement projectName;

	public String getProjectName() {
		return projectName.getText().trim();
	}

	public NewProjectPage getNewProjectPage() {
		createProjectButton.click();
		return new NewProjectPage(driver);
	}
}
