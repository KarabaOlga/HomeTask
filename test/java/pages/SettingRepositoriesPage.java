package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SettingRepositoriesPage {

	private WebDriver driver;

	public SettingRepositoriesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
}
