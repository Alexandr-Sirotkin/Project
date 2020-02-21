package itAcademy.pages.MAIL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetterPage {

  private WebDriver driver;
  private static final By HEADING_LOCATOR = By
      .xpath("//button[@type='submit']//span[@class='_nb-button-text']");
  private static final By RECIPIENT_FIELD_LOCATOR = By
      .xpath("//div[@class='mail-Compose-Field-Input']/div[@name='to']");
  private static final By TOPIC_FIELD_LOCATOR = By
      .xpath("//div[@class='mail-Compose-Field-Input']/input[@type='text']");
  private static final By BODY_FIELD_LOCATOR = By
      .xpath("//div[@class='cke_contents cke_reset']/div");
  private static final By ERROR_ADRESS_FIELD_LOCATOR = By
      .xpath("//div[@data-key='view=compose-field-to-error']");
  private static final By SEND_BUTTON_LOCATOR = By.xpath(
      "//span[@data-key='view=compose-send-link']/button[@title='Отправить письмо (Ctrl + Enter)']");
  private static final By LINK_TO_SENT_LOCATOR = By.xpath("//a[contains(@title,'Отправленные')]");
  private static final By LINK_TO_INBOX_LOCATOR = By.xpath("//a[contains(@title,'Входящие')]");
  private static final By LINK_TO_DRAFTS_LOCATOR = By.xpath("//a[contains(@title,'Черновики')]");
  private static final By WRITE_BUTTON_LOCATOR = By.xpath("//a[@title='Написать (w, c)']");
  private static final By SAVE_AND_GO_BUTTON_LOCATOR = By
      .xpath("//button[contains(@class,' nb-button _nb-small-action-button')]");

  public LetterPage(WebDriver driver) {
    this.driver = driver;
  }

  public By getSaveAndGoButtonLocator() {
    return SAVE_AND_GO_BUTTON_LOCATOR;
  }

  public WebElement findRecipientField() {
    return driver.findElement(RECIPIENT_FIELD_LOCATOR);
  }

  public WebElement findTopicField() {
    return driver.findElement(TOPIC_FIELD_LOCATOR);
  }

  public WebElement findBodyField() {
    return driver.findElement(BODY_FIELD_LOCATOR);
  }

  public void clickSendButton() {
    driver.findElement(SEND_BUTTON_LOCATOR).click();
  }

  public SentEmailsPage clickSendLettersFolder() {
    driver.findElement(LINK_TO_SENT_LOCATOR).click();
    return new SentEmailsPage(driver);
  }

  public IncomingEmailsPage clickInboxLettersFolder() {
    driver.findElement(LINK_TO_INBOX_LOCATOR).click();
    return new IncomingEmailsPage(driver);
  }

  public void clickDraftsFolder() {
    driver.findElement(LINK_TO_DRAFTS_LOCATOR).click();
  }


  public String getErrorAddressText() {
    return driver.findElement(ERROR_ADRESS_FIELD_LOCATOR).getText();
  }

  public LetterPage writeAletter() {
    driver.findElement(WRITE_BUTTON_LOCATOR).click();
    return new LetterPage(driver);
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

}
