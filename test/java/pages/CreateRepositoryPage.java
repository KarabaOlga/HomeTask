package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateRepositoryPage {

	private WebDriver driver;

	public CreateRepositoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='repository_name']")
	private WebElement repositoryName;

	@FindBy(xpath = "//input[@id='repository_description']")
	private WebElement repositoryDescription;

	@FindBy(xpath = "//button[@class='btn btn-primary first-in-line']")
	private WebElement button;

	public RepositoriesPage getRepositoriesPage(String name, String description) {
		repositoryName.sendKeys(name);
		repositoryDescription.sendKeys(description);
		button.click();
		return new RepositoriesPage(driver);
	}

}
