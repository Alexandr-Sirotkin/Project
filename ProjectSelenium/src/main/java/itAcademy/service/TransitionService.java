package itAcademy.service;

import itAcademy.model.User;
import itAcademy.pages.CLOUD.YandexDiskPage;
import itAcademy.pages.MAIL.LetterPage;
import itAcademy.pages.MAIL.LoginPage;
import itAcademy.pages.MAIL.MailPage;
import itAcademy.pages.MAIL.PasswordPage;
import itAcademy.pages.MAIL.UserMailMainPage;
import itAcademy.tests.MAIL.LoginPageTest;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransitionService {

  private WebDriver driver;
  private LoginPage loginPage;
  private PasswordPage passwordPage;
  private UserMailMainPage ummPage;
  private MailPage mailPage;
  private LetterPage letterPage;
  private YandexDiskPage diskPage;
  private User user = new User();

  private Logger logger = Logger.getLogger(LoginPageTest.class);

  public Logger getLogger() {
    return logger;
  }

  public void openBrowser() {
    System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://passport.yandex.ru/auth/welcome");
    loginPage = new LoginPage(driver);
  }

  public void openBrowserLogInService() {
    openBrowser();
    passwordPage = logIn(user.getCORRECT_LOGIN());
  }

  public void openBrowserLogInWithPasswordService() {
    openBrowserLogInService();
    ummPage = logInWithPassword(user.getCORRECT_PASSWORD());
  }

  public void openBrowserMailPage() throws InterruptedException {
    openBrowserLogInWithPasswordService();
    TimeUnit.SECONDS.sleep(1);
    mailPage = goToMail();
  }

  public WebDriver openBrowserCloudPage() throws InterruptedException {
    openBrowserLogInWithPasswordService();
    TimeUnit.SECONDS.sleep(1);
    diskPage = goToCloud();
    return driver;
  }

  public LetterPage getLetterPage() {
    return letterPage;
  }

  public YandexDiskPage getDiskPage() {
    return diskPage;
  }

  public WebDriver openBrowserLetterPage() throws InterruptedException {
    openBrowserMailPage();
    letterPage = writeAletter();
    return driver;
  }

  public void closeBrowserService() {
    driver.quit();
  }

  public PasswordPage logIn(String userLogin) {
    this.typeUserLogin(userLogin);
    loginPage.clickLogInButton();
    return passwordPage = new PasswordPage(driver);
  }

  public LoginPage logInEmptyLogin(String userLogin) {
    this.typeUserLogin(userLogin);
    loginPage.clickLogInButton();
    return new LoginPage(driver);
  }

  public LoginPage invalidLoginCreation(String userLogin) {
    this.typeUserLogin(userLogin);
    loginPage.clickLogInButton();
    return new LoginPage(driver);
  }

  public void typeUserLogin(String userLogin) {
    WebElement loginField = loginPage.findLoginField();
    loginField.sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
    loginField.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
    loginField.sendKeys(userLogin);
  }


  public UserMailMainPage logInWithPassword(String userPassword) {
    passwordPage.typeUserPassword(userPassword);
    passwordPage.clickLogInButton();
    return ummPage = new UserMailMainPage(driver);
  }

  public PasswordPage logInEmptyPassword(String userPassword) {
    passwordPage.typeUserPassword(userPassword);
    passwordPage.clickLogInButton();
    return new PasswordPage(driver);
  }

  public PasswordPage invalidPasswordCreation(String userPassword) {
    passwordPage.typeUserPassword(userPassword);
    passwordPage.clickLogInButton();
    return new PasswordPage(driver);
  }

  public MailPage goToMail() {
    ummPage.clickUserButton();
    return mailPage = ummPage.clickMailButton();
  }

  public YandexDiskPage goToCloud() {
    ummPage.clickServicesButton();
    return diskPage = ummPage.clickDiskButton();
  }

  public LetterPage writeAletter() {
    mailPage.writeAletter();
    return letterPage = new LetterPage(driver);
  }


  public void waitOfElement(int timeout) {
    new WebDriverWait(driver, timeout)
        .until(ExpectedConditions.visibilityOfElementLocated(passwordPage.getHeadingLocator()));
  }

  public void waitOfElement(By by, int timeout) {
    new WebDriverWait(driver, timeout)
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public String getErrorTextLogin() {
    return loginPage.getErrorTextLogin();
  }

  public String getErrorTextEmptyLogin() {
    return loginPage.getErrorTextEmptyLogin();
  }

  public String getErrorTextPassword() {
    return passwordPage.getErrorTextPassword();
  }

  public String getHeadingTextUserMailMainPageService() {
    return ummPage.getHeadingText();
  }

  public String getHeadingTextLoginPageService() {
    return loginPage.getHeadingText();
  }

  public String getHeadingTextPasswordPageService() {
    return passwordPage.getHeadingText();
  }

  public String getHeadingTextMailPage() {
    return mailPage.getHeadingText();
  }

  public String getHeadingTextLetterPage() {
    return letterPage.getHeadingText();
  }

  public String getHeadingTextDiskPage() {
    return diskPage.getHeadingText();
  }


}
