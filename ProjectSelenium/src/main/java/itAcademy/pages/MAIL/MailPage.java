package itAcademy.pages.MAIL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage {

  private WebDriver driver;
  private static final By HEADING_LOCATOR = By.xpath("//a[@data-title='Входящие']/span");
  private static final By WRITE_BUTTON_LOCATOR = By.xpath("//a[@title='Написать (w, c)']");

  public MailPage(WebDriver driver) {
    this.driver = driver;
  }

  public void writeAletter() {
    driver.findElement(WRITE_BUTTON_LOCATOR).click();
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

}
