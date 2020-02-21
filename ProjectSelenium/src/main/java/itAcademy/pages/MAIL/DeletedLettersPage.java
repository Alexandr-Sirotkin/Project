package itAcademy.pages.MAIL;

import itAcademy.model.Letter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeletedLettersPage {

  private WebDriver driver;
  private static Letter letter = new Letter();
  private static final By HEADING_LOCATOR = By.xpath("//a[contains(@title,'Удалённые')]/span");
  private static final By TOPIC_LETTER_LOCATOR = By
      .xpath("//span[@title=\'" + letter.getTOPIC_TEST_LETTER() + "\']");
  private static final By FLAG_LOCATOR = By.xpath(
      "//div[contains(@class,'ns-view-messages-item-wrap')][1]//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
  private static final By DELETE_BUTTON = By.xpath("//div[@title='Удалить (Delete)']");

  public DeletedLettersPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

  public String getTopicLetter() {
    return driver.findElement(TOPIC_LETTER_LOCATOR).getText();
  }

  public void markLetter() {
    driver.findElement(FLAG_LOCATOR).click();
  }

  public void clickDeleteButton() {
    driver.findElement(DELETE_BUTTON).click();
  }

  public List<WebElement> findTopicLetter() {
    List<WebElement> element = driver.findElements(TOPIC_LETTER_LOCATOR);
    return element;
  }

}
