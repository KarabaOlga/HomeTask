package TestTask.GitHubEpam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import pages.LoggedMainPage;
import pages.MainPage;
import pages.PersonalSettingPage;
import pages.ProfilePage;
import pages.SettingEmailsPage;
import pages.SignInPage;

public class EmailCheckTest {

	private WebDriver driver;
	private String URL = "https://github.com/";
	private String email = "olgaproficomp@mail.ru";
	private String pass1 = "olga393483045570";

	@Test
	public void registerUser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		MainPage mainPage = new MainPage(driver);
		SignInPage signInPage = mainPage.getSignInPage();
		LoggedMainPage loggedMainPage = signInPage.getLoggedMainPage(email, pass1);
		ProfilePage profilePage = loggedMainPage.getProfilePage();
		PersonalSettingPage personalSettingPage = profilePage.getPersonalSettingPage();
		SettingEmailsPage settingEmailsPage = personalSettingPage.getSettingEmailsPage();
		assertEquals(email, settingEmailsPage.getPrimaryEmail());
		driver.quit();
	}
}

