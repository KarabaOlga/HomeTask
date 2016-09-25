package TestTask.GitHubEpam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.CreateRepositoryPage;
import pages.CreatedProjectPage;
import pages.LoggedMainPage;
import pages.MainPage;
import pages.NewProjectPage;
import pages.ProjectsPage;
import pages.RepositoriesPage;
import pages.SignInPage;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class CreatedProjectCheckTest {

	private WebDriver driver;
	private String URL = "https://github.com/";
	private String email = "olgaproficomp@mail.ru";
	private String pass1 = "olga393483045570";
	private String name = "Repositories";
	private String description = "Description";
	private String name1 = "Project";
	private String description1 = "description";

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
		ProjectsPage projectsPage = repositoriesPage.getProjectsPage();
		NewProjectPage newProjectPage = projectsPage.getNewProjectPage();
		CreatedProjectPage createdProjectPage = newProjectPage.getCreatedProjectPage(name1, description1);
		ProjectsPage projectsPage2 = createdProjectPage.getProjectsPage();
		System.out.println(projectsPage2.getProjectName().trim());
		assertEquals(name1, projectsPage2.getProjectName().trim());
		driver.close();
	}
}
