package itAcademy.tests.MAIL;

import itAcademy.model.User;
import itAcademy.service.TransitionService;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PasswordPageTest {


  private TransitionService service = new TransitionService();
  private User user = new User();


  private final String EXPECTED_HEADING_USER_MAIL_MAIN_PAGE = "Сироткин";
  private final String EXPECTED_HEADING_PASSWORD_PAGE = "Другой аккаунт";
  private final String EXPECTED_ERROR_EMPTY_PASSWORD = "Пароль не указан";
  private final String EXPECTED_ERROR_TEXT_PASSWORD = "Неверный пароль";


  @BeforeTest
  public void openBrowser() {
    service.openBrowserLogInService();
  }

  @BeforeClass
  public void checkPage() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String headingPasswordPage = service.getHeadingTextPasswordPageService();
    Assert.assertEquals(headingPasswordPage, EXPECTED_HEADING_PASSWORD_PAGE,
        "You are on the wrong page.");
  }

  @Test(priority = 3)
  public void logInTest() throws InterruptedException {
    service.logInWithPassword(user.getCORRECT_PASSWORD());
    TimeUnit.SECONDS.sleep(1);
    String heading = service.getHeadingTextUserMailMainPageService();
    Assert.assertEquals(heading, EXPECTED_HEADING_USER_MAIL_MAIN_PAGE,
        "The expected UserMailMainPage page title does not match the current one.");
  }

  @Test(priority = 1)
  public void createEmptyPasswordTest() throws InterruptedException {
    service.logInEmptyPassword("");
    String errorEmptyPassword = service.getErrorTextPassword();
    Assert
        .assertEquals(errorEmptyPassword, EXPECTED_ERROR_EMPTY_PASSWORD, "Empty password entered.");
  }

  @Test(priority = 2)
  public void invalidPasswordCreationTest() throws InterruptedException {
    service.invalidPasswordCreation(user.getINVALID_PASSWORD());
    Assert.assertEquals(service.getErrorTextPassword(), EXPECTED_ERROR_TEXT_PASSWORD,
        "Invalid password.");
  }

  @AfterTest
  public void closeBrowser() {
    service.closeBrowserService();
  }

}
