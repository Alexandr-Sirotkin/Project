package itAcademy.tests.MAIL;


import itAcademy.pages.MAIL.MailPage;
import itAcademy.service.TransitionService;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserMailMainPageTest {


  private TransitionService service = new TransitionService();

  private final String EXPECTED_HEADING_USER_MAIL_MAIN_PAGE = "Сироткин";
  private final String EXPECTED_HEADING_MAIL_PAGE = "Входящие";
  private final String EXPECTED_HEADING_DISK_PAGE = "Файлы";


  @BeforeTest
  public void openBrowser() {
    service.openBrowserLogInWithPasswordService();
  }

  @BeforeClass
  public void checkPage() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String headingUmmPage = service.getHeadingTextUserMailMainPageService();
    Assert.assertEquals(headingUmmPage, EXPECTED_HEADING_USER_MAIL_MAIN_PAGE,
        "You are on the wrong page.");
  }

  @Test(enabled = false, priority = 1, groups = "mail")
  public void goToMailTest() throws InterruptedException {
    service.goToMail();
    TimeUnit.SECONDS.sleep(1);
    String heading = service.getHeadingTextMailPage();
    Assert.assertEquals(heading, EXPECTED_HEADING_MAIL_PAGE,
        "The expected page title does not match the current one.");
  }

  @Test(priority = 1, groups = "cloud")
  public void goToCloudTest() throws InterruptedException {
    service.goToCloud();
    TimeUnit.SECONDS.sleep(1);
    String heading = service.getHeadingTextDiskPage();
    Assert.assertEquals(heading, EXPECTED_HEADING_DISK_PAGE,
        "The expected page title does not match the current one.");
  }

  @AfterTest
  public void closeBrowser() {
    service.closeBrowserService();
  }

}
