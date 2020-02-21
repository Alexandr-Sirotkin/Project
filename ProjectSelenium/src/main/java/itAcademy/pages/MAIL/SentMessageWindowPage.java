package itAcademy.pages.MAIL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentMessageWindowPage {

  private WebDriver driver;
  private static final By HEADING_LOCATOR = By
      .xpath("//div[@class='mail-Done-Title js-title-info']");

  public SentMessageWindowPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }
}
