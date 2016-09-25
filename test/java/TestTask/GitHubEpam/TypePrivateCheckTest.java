package TestTask.GitHubEpam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import pages.CreateRepositoryPage;
import pages.LoggedMainPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.ProfileRepositoriesPage;
import pages.RepositoriesPage;
import pages.SignInPage;

public class TypePrivateCheckTest {

	private WebDriver driver;
	private String URL = "https://github.com/";
	private String email = "olgaproficomp@mail.ru";
	private String pass1 = "olga393483045570";
	private String name = "Repositories2";
	private String name3 = "KarabaOlga doesn’t have any repositories that match.";
	private String description = "Description";

	@Test
	public void registerUser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		MainPage mainPage = new MainPage(driver);
		SignInPage signInPage = mainPage.getSignInPage();
		LoggedMainPage loggedMainPage = signInPage.getLoggedMainPage(email, pass1);
		CreateRepositoryPage createRepositoryPage = loggedMainPage.getCreateRepositoryPage();
		RepositoriesPage repositoriesPage = createRepositoryPage.getRepositoriesPage(name, description);
		ProfilePage profilePage = repositoriesPage.getProfilePage();
		ProfileRepositoriesPage profileRepositoriesPage = profilePage.getProfileRepositoriesPage();
		assertEquals(name3, profileRepositoriesPage.getPrivateText());
		driver.quit();
	}

}
