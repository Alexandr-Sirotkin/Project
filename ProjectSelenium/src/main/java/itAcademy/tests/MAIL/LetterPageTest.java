package itAcademy.tests.MAIL;

import itAcademy.model.Letter;
import itAcademy.model.User;
import itAcademy.service.LetterService;
import itAcademy.service.TransitionService;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LetterPageTest {

  private LetterService svc = new LetterService();
  private User user = new User();
  private Letter letter = new Letter();


  private final String EXPECTED_HEADING_LETTER_PAGE = "Отправить";
  private final String EXPECTED_HEADING_SENT_MESSAGE_WINDOW_PAGE = "Письмо отправлено.";
  private final String EXPECTED_ADDRESS_SENT_LETTER = user.getEMAIL_ADDRESS();
  private final String EXPECTED_USER_INCOMING_LETTER = user.getUSER_NAME();
  private final String EXPECTED_TOPIC_SENT_LETTER = letter.getTOPIC_CORRECT_RECIPIENT();
  private final String EXPECTED_TOPIC_INCOMING_LETTER = letter.getTOPIC_CORRECT_RECIPIENT();
  private final String EXPECTED_ERROR_ADDRESS_TEXT =
      "Некорректные адреса: " + letter.getINVALID_RECIPIENT();


  @BeforeTest
  public void openBrowser() throws InterruptedException {
    svc.openBrowserLetterPage();
  }

  @BeforeClass
  public void checkPage() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String headingLetterPage = svc.getHeadingTextLetterPage();
    Assert.assertEquals(headingLetterPage, EXPECTED_HEADING_LETTER_PAGE,
        "You are on the wrong page.");
  }

  @Test(priority = 1)
  public void sendLetterTest() throws InterruptedException {
    svc.sendLetterService(user.getEMAIL_ADDRESS(), letter.getTOPIC_CORRECT_RECIPIENT(),
        letter.getBODY_CORRECT_RECIPIENT());
    TimeUnit.SECONDS.sleep(1);
    String heading = svc.getHeadingTextSentMessageWindowPage();
    Assert.assertEquals(heading, EXPECTED_HEADING_SENT_MESSAGE_WINDOW_PAGE,
        "The expected page title does not match the current one.");
  }

  @Test(priority = 2)
  public void checkSentTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    svc.clickSendLettersFolderService();
    String topic = svc.getTopicSentLetterService();
    Assert.assertEquals(topic, EXPECTED_TOPIC_SENT_LETTER, "Email not found in sent folder.");
  }

  @Test(priority = 3)
  public void checkInboxTest() throws InterruptedException {

    TimeUnit.SECONDS.sleep(1);
    svc.clickInboxLettersFolderService();
    svc.refresh(svc.getTopicLetterLocatorForLetterPageTest());
    String topic = svc.getTopicIncomingLetterService();
    Assert.assertEquals(topic, EXPECTED_TOPIC_INCOMING_LETTER, "Email not found in inbox folder.");
  }

  @Test(priority = 4)
  public void sendLetterWithInvalidAddressTest() throws InterruptedException {
    svc.writeAletterService();
    svc.sendLetterWithInvalidAddressService(letter.getINVALID_RECIPIENT(),
        letter.getTOPIC_INVALID_RECIPIENT(), letter.getBODY_INVALID_RECIPIENT());
    TimeUnit.SECONDS.sleep(2);
    String error = svc.getErrorAddressTextService();
    Assert.assertEquals(error, EXPECTED_ERROR_ADDRESS_TEXT,
        "The expected error does not match the current one.");
  }

  @Test(priority = 5)
  public void sendLetterWithoutTopicAndBodyTest() throws InterruptedException {
    svc.writeAletterService();
    TimeUnit.SECONDS.sleep(2);
    svc.findWindow();
    TimeUnit.SECONDS.sleep(1);
    svc.sendLetterService(user.getEMAIL_ADDRESS());
    TimeUnit.SECONDS.sleep(1);
    String heading = svc.getHeadingTextSentMessageWindowPage();
    Assert.assertEquals(heading, EXPECTED_HEADING_SENT_MESSAGE_WINDOW_PAGE,
        "The expected page title does not match the current one.");
  }

  @Test(priority = 6)
  public void checkSentByAddressTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    svc.clickSendLettersFolderService();
    String address = svc.getAddressLetterLocatorService();
    Assert.assertEquals(address, EXPECTED_ADDRESS_SENT_LETTER, "Email not found in sent folder.");
  }

  @Test(priority = 7)
  public void checkInboxByAddressTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    svc.clickInboxLettersFolderService();
    TimeUnit.SECONDS.sleep(1);
    svc.refresh(svc.getUserLetterLocator());
    String user = svc.getUserLetterService();
    Assert.assertEquals(user, EXPECTED_USER_INCOMING_LETTER, "Email not found in inbox folder.");
  }

  @AfterClass
  public void clear() {
    svc.clearService();
  }

  @AfterTest
  public void closeBrowser() {
    svc.closeBrowserService();
  }

}
