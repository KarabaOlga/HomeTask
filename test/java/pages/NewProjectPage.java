package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProjectPage {

	private WebDriver driver;

	public NewProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='project_name']")
	private WebElement name;

	@FindBy(xpath = "//textarea[@id='project_body']")
	private WebElement description;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement saveProjectButton;

	public CreatedProjectPage getCreatedProjectPage(String name1, String description1) {
		name.clear();
		name.sendKeys(name1);
		description.sendKeys(description1);
		saveProjectButton.click();
		return new CreatedProjectPage(driver);
	}

}
