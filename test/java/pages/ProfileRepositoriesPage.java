package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileRepositoriesPage {

	private WebDriver driver;

	public ProfileRepositoriesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//button[@class='select-menu-button js-menu-target']")
	private WebElement selectList;

	@FindBy(xpath = "//span[@class='select-menu-item-text js-select-button-text'][text()='Private']")
	private WebElement privateButton;

	@FindBy(xpath = "//h4")
	private WebElement privateText;

	public String getPrivateText() {
		return privateText.getText().trim();
	}

	public ProfileRepositoriesPage getProfileRepositoriesPage() {
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// }
		selectList.click();
		privateButton.click();
		return new ProfileRepositoriesPage(driver);
	}

}
