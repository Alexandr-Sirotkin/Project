package itAcademy.pages.MAIL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {

  private WebDriver driver;
  private static final By LOG_IN_BUTTON_LOCATOR = By.xpath("//button[@type='submit']");
  private static final By PASSWORD_FIELD_LOCATOR = By.xpath("//input[@id='passp-field-passwd']");
  private static final By ERROR_PASSWORD_LOCATOR = By
      .xpath("//div[@class='passp-form-field__error']");
  private static final By HEADING_LOCATOR = By.xpath("//div[@class='passp-auth-header']/a[2]");

  public PasswordPage(WebDriver driver) {
    this.driver = driver;
  }

  public By getHeadingLocator() {
    return HEADING_LOCATOR;
  }

  public PasswordPage typeUserPassword(String userPassword) {
    WebElement passwordField = driver.findElement(PASSWORD_FIELD_LOCATOR);
    passwordField.clear();
    passwordField.sendKeys(userPassword);
    return this;
  }

  public void clickLogInButton() {
    driver.findElement(LOG_IN_BUTTON_LOCATOR).click();
  }

  public String getErrorTextPassword() {
    return driver.findElement(ERROR_PASSWORD_LOCATOR).getText();
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

}
