package itAcademy.tests.CLOUD;

import itAcademy.model.Disk;
import itAcademy.service.CloudService;
import itAcademy.service.TransitionService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YandexDiskPageTest {

  private CloudService svc = new CloudService();
  private Disk disk = new Disk();


  private final String EXPECTED_NAME_FOLDER = disk.getNAME();
  private final String EXPECTED_FILE_NAME = "test.jpg";
  private final String EXPECTED_HEADING_DISK_PAGE = "Файлы";

  @BeforeTest
  public void openBrowser() throws InterruptedException {
    svc.openBrowserDiskPage();
  }

  @BeforeClass
  public void checkPage() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    String headingDiskPage = svc.getHeadingTextDiskPage();
    Assert.assertEquals(headingDiskPage, EXPECTED_HEADING_DISK_PAGE, "You are on the wrong page.");
  }

  @Test(priority = 1)
  public void createFolderTest() throws InterruptedException {
    svc.createFolder();
    svc.giveFolderName(disk.getNAME());
    TimeUnit.SECONDS.sleep(1);
    String name = svc.getNameNewFolder();
    Assert.assertEquals(name, EXPECTED_NAME_FOLDER,
        "The expected name does not match the current one.");
  }

  @Test(priority = 2)
  public void deleteFolderTest() throws InterruptedException {
    svc.DeleteFolder();
    TimeUnit.SECONDS.sleep(1);
    List<WebElement> element = svc.findFolderService();
    Assert.assertEquals(element.size(), 0, "Folder found in Yandex Disk.");
  }

  @Test(priority = 3)
  public void downloadFileTest() throws InterruptedException {
    svc.downloadFile();
    svc.waitAppearance();
    svc.waitLoding();
    svc.closeBootMessageWindowService();
    TimeUnit.SECONDS.sleep(1);
    String nameFile = svc.getNameFile();
    Assert.assertEquals(nameFile, EXPECTED_FILE_NAME,
        "The expected name does not match the current one.");
  }

  @Test(priority = 4)
  public void dragAndDropFileTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(3);
    svc.dragAndDropFile();
    TimeUnit.SECONDS.sleep(1);
    svc.goToFolder();
    TimeUnit.SECONDS.sleep(1);
    String nameFile = svc.getHeadingTextFile();
    Assert.assertEquals(nameFile, EXPECTED_FILE_NAME, "No file in current folder.");
  }

  @Test(priority = 5)
  public void shareFileLinkTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(2);
    svc.shareFileLink();
    svc.openReceivedLink();
    String fileName = svc.getFileNameService();
    Assert.assertEquals(fileName, EXPECTED_FILE_NAME, "File names are different.");
  }

  @AfterClass
  public void clear() {
    svc.clearFolder();
  }

  @AfterTest
  public void closeBrowser() {
    svc.closeBrowserService();

  }


}
