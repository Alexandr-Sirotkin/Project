package itAcademy.tests.MAIL;


import itAcademy.service.TransitionService;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MailPageTest {

  private TransitionService service = new TransitionService();

  private final String EXPECTED_HEADING_LETTER_PAGE = "Отправить";
  private final String EXPECTED_HEADING_MAIL_PAGE = "Входящие";

  @BeforeTest
  public void openBrowser() throws InterruptedException {
    service.openBrowserMailPage();
  }

  @BeforeClass
  public void checkPage() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String headingMailPage = service.getHeadingTextMailPage();
    Assert.assertEquals(headingMailPage, EXPECTED_HEADING_MAIL_PAGE, "You are on the wrong page.");
  }

  @Test(priority = 1)
  public void writeAletterTest() throws InterruptedException {
    service.writeAletter();
    TimeUnit.SECONDS.sleep(1);
    String heading = service.getHeadingTextLetterPage();
    Assert.assertEquals(heading, EXPECTED_HEADING_LETTER_PAGE,
        "The expected LetterPage page title does not match the current one.");
  }

  @AfterTest
  public void closeBrowser() {
    service.closeBrowserService();
  }

}
