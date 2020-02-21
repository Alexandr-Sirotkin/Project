package itAcademy.service;

import itAcademy.model.Letter;
import itAcademy.pages.MAIL.DeletedLettersPage;
import itAcademy.pages.MAIL.DraftsPage;
import itAcademy.pages.MAIL.IncomingEmailsPage;
import itAcademy.pages.MAIL.LetterPage;
import itAcademy.pages.MAIL.SentEmailsPage;
import itAcademy.pages.MAIL.SentMessageWindowPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetterService {

  private TransitionService service = new TransitionService();
  private WebDriver driver;
  private SentMessageWindowPage smwPage;
  private SentEmailsPage sentPage;
  private IncomingEmailsPage inboxPage;
  private DraftsPage draft;
  private DeletedLettersPage deletedLetters;
  private static Letter letter = new Letter();

  private static final By LINK_TO_SENT_LOCATOR = By.xpath("//a[contains(@title,'Отправленные')]");
  private static final By LINK_TO_INBOX_LOCATOR = By.xpath("//a[contains(@title,'Входящие')]");
  private static final By LINK_TO_DRAFTS_LOCATOR = By.xpath("//a[contains(@title,'Черновики')]");
  private static final By LINK_TO_DELETED_LOCATOR = By.xpath("//a[contains(@title,'Удалённые')]");
  private static final By DELETE_BUTTON = By.xpath("//div[@title='Удалить (Delete)']");
  private static final By FLAG_LOCATOR = By.xpath(
      "//div[contains(@class,'ns-view-messages-item-wrap')]//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
  private static final By TOPIC_LETTER_LOCATOR_FOR_LETTER_PAGE_TEST = By
      .xpath("//span[@title=\'" + letter.getTOPIC_CORRECT_RECIPIENT() + "\']");
  private static final By USER_LETTER_LOCATOR = By.xpath(
      "//div[contains(@class,'ns-view-messages-item-wrap')][1]//span[@title='aleksandarsirotk1n@yandex.by']");
  private static final By TOPIC_LETTER_LOCATOR = By
      .xpath("//span[@title=\'" + letter.getTOPIC_TEST_LETTER() + "\']");


  public By getUserLetterLocator() {
    return USER_LETTER_LOCATOR;
  }

  public By getTopicLetterLocator() {
    return TOPIC_LETTER_LOCATOR;
  }

  public By getTopicLetterLocatorForLetterPageTest() {
    return TOPIC_LETTER_LOCATOR_FOR_LETTER_PAGE_TEST;
  }

  public void openBrowserLetterPage() throws InterruptedException {
    driver = service.openBrowserLetterPage();
  }

  public LetterPage writeRecipientService(String recipient) {
    WebElement recipientField = service.getLetterPage().findRecipientField();
    recipientField.clear();
    recipientField.sendKeys(recipient);
    return service.getLetterPage();
  }

  public LetterPage writeTopicService(String topic) {
    WebElement topicField = service.getLetterPage().findTopicField();
    topicField.clear();
    topicField.sendKeys(topic);
    return service.getLetterPage();
  }

  public LetterPage writeBodyService(String body) {
    WebElement bodyField = service.getLetterPage().findBodyField();
    bodyField.clear();
    bodyField.sendKeys(body);
    return service.getLetterPage();
  }

  public SentMessageWindowPage sendLetterService(String recipient, String topic, String body) {
    writeRecipientService(recipient);
    writeTopicService(topic);
    writeBodyService(body);
    service.getLetterPage().clickSendButton();
    return smwPage = new SentMessageWindowPage(driver);
  }

  public SentMessageWindowPage sendLetterService(String recipient) {
    writeRecipientService(recipient);
    service.getLetterPage().clickSendButton();
    return smwPage = new SentMessageWindowPage(driver);
  }

  public void findWindow() {
    boolean displayed = driver.findElement(service.getLetterPage().getSaveAndGoButtonLocator())
        .isDisplayed();
    if (displayed) {
      driver.findElement(service.getLetterPage().getSaveAndGoButtonLocator()).click();
    }
  }

  public void refresh(By locator) {
    boolean displayed = false;
    int count = 0;
    do {
      try {
        displayed = driver.findElement(locator).isDisplayed();
      } catch (NoSuchElementException e) {
        driver.navigate().refresh();
        if (count > 50) {
          displayed = true;
        }
        count++;
      }
    } while (!displayed);
  }

  public SentEmailsPage clickSendLettersFolderService() {
    return sentPage = service.getLetterPage().clickSendLettersFolder();
  }

  public IncomingEmailsPage clickInboxLettersFolderService() {
    return inboxPage = service.getLetterPage().clickInboxLettersFolder();
  }

  public DraftsPage clickDraftsFolderService() {
    service.getLetterPage().clickDraftsFolder();
    findWindow();
    return draft = new DraftsPage(driver);
  }

  public DeletedLettersPage clickDeletedLettersFolderService() {
    return deletedLetters = draft.clickDeletedLettersFolder();
  }

  public LetterPage writeAletterService() {
    return service.getLetterPage().writeAletter();
  }

  public LetterPage sendLetterWithInvalidAddressService(String recipient, String topic,
      String body) {
    writeRecipientService(recipient);
    writeTopicService(topic);
    writeBodyService(body);
    service.getLetterPage().clickSendButton();
    return service.getLetterPage();
  }


  public String getHeadingTextSentMessageWindowPage() {
    return smwPage.getHeadingText();
  }

  public String getHeadingTextDrafts() {
    return draft.getHeadingText();
  }

  public String getTopicLetterDraft() {
    refresh(TOPIC_LETTER_LOCATOR);
    return draft.getTopicLetter();
  }

  public String getHeadingTextDeletedLetters() {
    return deletedLetters.getHeadingText();
  }

  public String getTopicDeletedLetter() {

    return deletedLetters.getTopicLetter();
  }

  public DraftsPage deleteDraftLetter() {
    draft.markLetter();
    draft.clickDeleteButton();
    return draft;
  }

  public void deleteDeletedLetter() {
    deletedLetters.markLetter();
    deletedLetters.clickDeleteButton();
  }

  public List<WebElement> findTopicDeletedLetterService() {
    return deletedLetters.findTopicLetter();
  }

  public List<WebElement> findTopicDraftLetterService() {
    return draft.findTopicLetter();
  }

  public String getTopicSentLetterService() {
    return sentPage.getTopicLetter();
  }

  public String getAddressLetterLocatorService() {
    return sentPage.getAddressLetterLocator();
  }

  public String getTopicIncomingLetterService() {
    return inboxPage.getTopicLetter();
  }

  public String getUserLetterService() {
    return inboxPage.getUserLetter();
  }

  public String getErrorAddressTextService() {
    return service.getLetterPage().getErrorAddressText();
  }

  public String getHeadingTextLetterPage() {
    return service.getLetterPage().getHeadingText();
  }

  public void clearService() {
    driver.findElement(LINK_TO_INBOX_LOCATOR).click();
    List<WebElement> elementInbox = driver.findElements(FLAG_LOCATOR);
    for (int i = 1; i < (elementInbox.size() + 1); i++) {
      By elementLocator = By.xpath(
          "//div[contains(@class,'ns-view-messages-item-wrap')]" + "[" + i + "]"
              + "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
      driver.findElement(elementLocator).click();
    }
    driver.findElement(DELETE_BUTTON).click();

    driver.findElement(LINK_TO_SENT_LOCATOR).click();
    List<WebElement> elementSent = driver.findElements(FLAG_LOCATOR);
    for (int i = 1; i < (elementSent.size() + 1); i++) {
      By elementLocator = By.xpath(
          "//div[contains(@class,'ns-view-messages-item-wrap')]" + "[" + i + "]"
              + "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
      driver.findElement(elementLocator).click();
    }
    driver.findElement(DELETE_BUTTON).click();

    driver.findElement(LINK_TO_DRAFTS_LOCATOR).click();
    List<WebElement> elementDrafts = driver.findElements(FLAG_LOCATOR);
    for (int i = 1; i < (elementDrafts.size() + 1); i++) {
      By elementLocator = By.xpath(
          "//div[contains(@class,'ns-view-messages-item-wrap')]" + "[" + i + "]"
              + "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
      driver.findElement(elementLocator).click();
    }
    driver.findElement(DELETE_BUTTON).click();

    driver.findElement(LINK_TO_DELETED_LOCATOR).click();
    List<WebElement> elementDeleted = driver.findElements(FLAG_LOCATOR);
    for (int i = 1; i < (elementDeleted.size() + 1); i++) {
      By elementLocator = By.xpath(
          "//div[contains(@class,'ns-view-messages-item-wrap')]" + "[" + i + "]"
              + "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
      driver.findElement(elementLocator).click();
    }
    driver.findElement(DELETE_BUTTON).click();

  }

  public void closeBrowserService() {
    driver.quit();
  }

}
