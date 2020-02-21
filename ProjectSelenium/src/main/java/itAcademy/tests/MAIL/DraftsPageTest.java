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

public class DraftsPageTest {


  private LetterService svc = new LetterService();
  private User user = new User();
  private Letter letter = new Letter();

  private final String EXPECTED_HEADING = "Черновики";
  private final String EXPECTED_DRAFT_LETTER_TOPIC = letter.getTOPIC_TEST_LETTER();

  @BeforeTest
  public void openBrowser() throws InterruptedException {
    svc.openBrowserLetterPage();
    svc.writeRecipientService(user.getEMAIL_ADDRESS());
    svc.writeTopicService(letter.getTOPIC_TEST_LETTER());
    svc.writeBodyService(letter.getBODY_TEST_LETTER());
    TimeUnit.SECONDS.sleep(1);
    svc.clickDraftsFolderService();
    svc.refresh(svc.getTopicLetterLocator());
  }

  @BeforeClass
  public void checkPage() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String heading = svc.getHeadingTextDrafts();
    Assert.assertEquals(heading, EXPECTED_HEADING, "You are on the wrong page.");
  }

  @Test(priority = 1)
  public void writeLetterAndSaveInDraftTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    TimeUnit.SECONDS.sleep(1);
    String topic = svc.getTopicLetterDraft();
    Assert.assertEquals(topic, EXPECTED_DRAFT_LETTER_TOPIC, "Email not found in draft folder.");
  }

  @Test(priority = 2)
  public void DraftTest() throws Exception {
    TimeUnit.SECONDS.sleep(1);
    svc.deleteDraftLetter();
    TimeUnit.SECONDS.sleep(1);
    List<WebElement> element = svc.findTopicDraftLetterService();
    Assert.assertEquals(element.size(), 0, "Email found in drafts folder.");
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
