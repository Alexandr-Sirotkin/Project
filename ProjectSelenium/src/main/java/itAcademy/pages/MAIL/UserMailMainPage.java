package itAcademy.pages.MAIL;

import itAcademy.pages.CLOUD.YandexDiskPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMailMainPage {

  private WebDriver driver;
  private static final By HEADING_LOCATOR = By.xpath("//div[@class='personal-info__last']");
  private static final By USER_BUTTON_LOCATOR = By.xpath("//a[contains(@class, 'user-account')]");
  private static final By MAIL_BUTTON_LOCATOR = By.xpath("//a[@href='https://mail.yandex.ru']");
  private static final By SERVICES_BUTTON = By.xpath("//a[@href='/profile/services']");
  private static final By DISK_BUTTON = By.xpath(
      "//div[@class='dashboard__section-title dashboard__section-title_active']/a[@href='https://disk.yandex.ru']");

  public UserMailMainPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

  public void clickUserButton() {
    driver.findElement(USER_BUTTON_LOCATOR).click();
  }

  public MailPage clickMailButton() {
    driver.findElement(MAIL_BUTTON_LOCATOR).click();
    return new MailPage(driver);
  }

  public void clickServicesButton() {
    driver.findElement(SERVICES_BUTTON).click();
  }

  public YandexDiskPage clickDiskButton() {
    driver.findElement(DISK_BUTTON).click();
    return new YandexDiskPage(driver);
  }

  public UserMailMainPage retrieve() {
    return this;
  }

}
