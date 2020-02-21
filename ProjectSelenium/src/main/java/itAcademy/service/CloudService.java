package itAcademy.service;

import itAcademy.pages.CLOUD.FolderPage;
import itAcademy.pages.CLOUD.NewFolderPage;
import itAcademy.pages.CLOUD.PicturePage;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CloudService {

  private TransitionService service = new TransitionService();
  private WebDriver driver;
  private NewFolderPage newFolderPage;
  private FolderPage folderPage;
  private PicturePage picPage;
  private Actions action;
  private final String EXPECTED_MESSAGE = "Все файлы загружены";

  public void openBrowserDiskPage() throws InterruptedException {
    driver = service.openBrowserCloudPage();
  }


  public NewFolderPage createFolder() {
    service.getDiskPage().clickCreateButton();
    service.getDiskPage().clickCreateFolderButton();
    return newFolderPage = new NewFolderPage(driver);
  }

  public void giveFolderName(String name) throws InterruptedException {
    WebElement nameField = newFolderPage.findFolderNameField();
    nameField.sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
    nameField.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
    TimeUnit.SECONDS.sleep(2);
    nameField.sendKeys(name);
    newFolderPage.save();
  }

  public void DeleteFolder() {
    service.getDiskPage().clickFolder();
    service.getDiskPage().clickDeleteButton();
  }

  public String getHeadingTextDiskPage() {
    return service.getDiskPage().getHeadingText();
  }


  public String getNameNewFolder() {
    return service.getDiskPage().getNameNewFolder();
  }

  public String getNameFile() {
    return service.getDiskPage().getNameFile();
  }

  public List<WebElement> findFolderService() {
    return service.getDiskPage().findFolder();
  }

  public void downloadFile() {
    service.getDiskPage().downloadFile();
  }

  public void dragAndDropFile() {
    WebElement draggable = service.getDiskPage().findFile();
    WebElement target = service.getDiskPage().findContainer();
    new Actions(driver).dragAndDrop(draggable, target).perform();
  }

  public FolderPage goToFolder() {
    WebElement element = service.getDiskPage().findContainer();
    action = new Actions(driver);
    action.doubleClick(element).perform();
    return folderPage = new FolderPage(driver);
  }

  public String getHeadingTextFile() {
    return folderPage.getHeadingTextFile();
  }


  public void shareFileLink() throws InterruptedException {
    WebElement element = service.getDiskPage().findNameFile();
    TimeUnit.SECONDS.sleep(2);
    action.contextClick(element).perform();
    TimeUnit.SECONDS.sleep(2);
    folderPage.clickShareButton();
    TimeUnit.SECONDS.sleep(2);
  }

  public PicturePage openReceivedLink() throws InterruptedException {
    String link = folderPage.getFileLinkLocator();
    driver.get(link);
    return picPage = new PicturePage(driver);
  }

  public String getFileNameService() {
    return picPage.getFileName();
  }

  public void waitAppearance() {
    boolean displayed = false;
    int count = 0;
    do {
      try {
        displayed = driver.findElement(service.getDiskPage().getBOOT_MESSAGE()).isDisplayed();
      } catch (NoSuchElementException e) {
        if (count > 50) {
          displayed = true;
        }
        count++;
      }
    } while (!displayed);
  }

  public void waitLoding() {
    boolean completed = false;
    while (!completed) {
      String message = driver.findElement(service.getDiskPage().getBOOT_MESSAGE()).getText();
      if (message.equals(EXPECTED_MESSAGE)) {
        completed = true;
      }
    }
  }

  public void clearFolder() {
    driver.navigate().back();
    folderPage.clickFile();
    folderPage.clickDeleteButton();
  }

  public void closeBootMessageWindowService() {
    service.getDiskPage().closeBootMessageWindow();
  }

  public void closeBrowserService() {
    driver.quit();
  }

}
