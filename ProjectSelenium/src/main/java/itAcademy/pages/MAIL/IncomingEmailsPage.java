package itAcademy.pages.MAIL;

import itAcademy.model.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IncomingEmailsPage {

  private WebDriver driver;
  private static Letter letter = new Letter();
  private static final By TOPIC_LETTER_LOCATOR = By
      .xpath("//span[@title=\'" + letter.getTOPIC_CORRECT_RECIPIENT() + "\']");
  private static final By USER_LETTER_LOCATOR = By.xpath(
      "//div[contains(@class,'ns-view-messages-item-wrap')][1]//span[@title='aleksandarsirotk1n@yandex.by']");

  public IncomingEmailsPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getTopicLetter() {
    return driver.findElement(TOPIC_LETTER_LOCATOR).getText();
  }

  public String getUserLetter() {
    return driver.findElement(USER_LETTER_LOCATOR).getText();
  }
}
