package itAcademy.tests.MAIL;

import itAcademy.model.Letter;
import itAcademy.model.User;
import itAcademy.service.LetterService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeletedLettersPageTest {

  private LetterService svc = new LetterService();
  private User user = new User();
  private Letter letter = new Letter();

  private final String EXPECTED_HEADING = "Удалённые";
  private String EXPECTED_TOPIC_DELETE_LETTER = letter.getTOPIC_TEST_LETTER();

  @BeforeTest
  public void openBrowser() throws InterruptedException {
    svc.openBrowserLetterPage();
    svc.writeRecipientService(user.getEMAIL_ADDRESS());
    svc.writeTopicService(letter.getTOPIC_TEST_LETTER());
    svc.writeBodyService(letter.getTOPIC_TEST_LETTER());
    TimeUnit.SECONDS.sleep(1);
    svc.clickDraftsFolderService();
    svc.refresh(svc.getTopicLetterLocator());
    TimeUnit.SECONDS.sleep(1);
    svc.deleteDraftLetter();
    TimeUnit.SECONDS.sleep(1);
    svc.clickDeletedLettersFolderService();
  }

  @BeforeClass
  public void checkPage() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String heading = svc.getHeadingTextDeletedLetters();
    Assert.assertEquals(heading, EXPECTED_HEADING, "You are on the wrong page.");
  }

  @Test(priority = 1)
  public void checkLetterTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String topic = svc.getTopicDeletedLetter();
    Assert.assertEquals(topic, EXPECTED_TOPIC_DELETE_LETTER, "Email not found in deleted folder.");
  }

  @Test(priority = 2)
  public void DeleteTest() throws Exception {
    TimeUnit.SECONDS.sleep(1);
    svc.deleteDeletedLetter();
    TimeUnit.SECONDS.sleep(1);
    List<WebElement> element = svc.findTopicDeletedLetterService();
    Assert.assertEquals(element.size(), 0, "Email found in deleted folder.");
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
