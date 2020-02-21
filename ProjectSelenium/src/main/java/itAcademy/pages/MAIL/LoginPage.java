package itAcademy.pages.MAIL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

  private WebDriver driver;
  private static final By LOG_IN_BUTTON_LOCATOR = By.xpath("//button[@type='submit']");
  private static final By LOGIN_FIELD_LOCATOR = By.xpath("//input[@id='passp-field-login']");
  private static final By ERROR_LOGIN_LOCATOR = By.xpath("//div[@class='passp-form-field__error']");
  private static final By HEADING_LOCATOR = By.xpath("//a[contains(@class,'logo logo_name')]");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement findLoginField() {
    return driver.findElement(LOGIN_FIELD_LOCATOR);
  }

  public void clickLogInButton() {
    driver.findElement(LOG_IN_BUTTON_LOCATOR).click();
  }

  public String getErrorTextLogin() {
    return driver.findElement(ERROR_LOGIN_LOCATOR).getText();
  }

  public String getErrorTextEmptyLogin() {
    return driver.findElement(ERROR_LOGIN_LOCATOR).getText();
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

}
