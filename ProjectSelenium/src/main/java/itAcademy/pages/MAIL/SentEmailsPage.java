package itAcademy.pages.MAIL;

import itAcademy.model.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentEmailsPage {

  private WebDriver driver;
  private static Letter letter = new Letter();
  private static final By TOPIC_LETTER_LOCATOR = By
      .xpath("//span[@title=\'" + letter.getTOPIC_CORRECT_RECIPIENT() + "\']");
  private static final By ADDRESS_LETTER_LOCATOR = By.xpath(
      "//div[contains(@class,'ns-view-messages-item-wrap')][1]//span[@class='mail-MessageSnippet-FromText']");

  public SentEmailsPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getAddressLetterLocator() {
    return driver.findElement(ADDRESS_LETTER_LOCATOR).getAttribute("title");
  }

  public String getTopicLetter() {
    return driver.findElement(TOPIC_LETTER_LOCATOR).getText();
  }

}
