package itAcademy.tests.MAIL;

import itAcademy.model.User;
import itAcademy.service.TransitionService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {


  private TransitionService service = new TransitionService();
  private User user = new User();

  private final String EXPECTED_HEADING_LOGIN_PAGE = "logo:yandex";
  private final String EXPECTED_HEADING_PASSWORD_PAGE = "Другой аккаунт";
  private final String EXPECTED_ERROR_TEXT_EMPTY_LOGIN = "Логин не указан";
  private final String EXPECTED_ERROR_TEXT_LOGIN = "Такой логин не подойдет";


  @BeforeTest
  public void openBrowser() {
    service.openBrowser();
  }

  @BeforeClass
  public void checkPage() {
    String headingLoginPage = service.getHeadingTextLoginPageService();
    Assert
        .assertEquals(headingLoginPage, EXPECTED_HEADING_LOGIN_PAGE, "You are on the wrong page.");
  }

  @Test(priority = 3)
  public void logInTest() throws InterruptedException {
    service.logIn(user.getCORRECT_LOGIN());
    service.waitOfElement(5);
    String heading = service.getHeadingTextPasswordPageService();
    Assert.assertEquals(heading, EXPECTED_HEADING_PASSWORD_PAGE,
        "The expected PasswordPage page title does not match the current one.");
  }

  @Test(priority = 1)
  public void createEmptyLoginTest() {
    service.logInEmptyLogin("");
    String errorEmptyLogin = service.getErrorTextEmptyLogin();
    Assert.assertEquals(errorEmptyLogin, EXPECTED_ERROR_TEXT_EMPTY_LOGIN, "Empty login entered.");
  }

  @Test(priority = 2)
  public void invalidLoginCreationTest() {
    service.invalidLoginCreation(user.getINVALID_LOGIN());
    Assert.assertEquals(service.getErrorTextLogin(), EXPECTED_ERROR_TEXT_LOGIN, "Invalid login.");
  }

  @AfterTest
  public void closeBrowser() {
    service.closeBrowserService();
  }

}
