package itAcademy.pages.CLOUD;

import itAcademy.model.Disk;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YandexDiskPage {

  private WebDriver driver;
  private static Disk disk = new Disk();

  public YandexDiskPage(WebDriver driver) {
    this.driver = driver;
  }

  private static final By HEADING_LOCATOR = By.xpath("//h1[@title='Файлы']");
  private static final By CREATE_BUTTON_LOCATOR = By
      .xpath("//span[@class='create-resource-popup-with-anchor']/button");
  private static final By DELETE_BUTTON_LOCATOR = By
      .xpath("//button[contains(@class,'visible-button_name_delete')]");
  private static final By CREATE_FOLDER_BUTTON_LOCATOR = By
      .xpath("//button[contains(@class,'create-resource-popup-with-anchor')][1]");
  private static final By FOLDER_NAME_LOCATOR = By
      .xpath("//div/span[contains(text(),\'" + disk.getNAME() + "\')]");
  private static final By FILE_NAME_LOCATOR = By.xpath("//span[contains(text(),'test.jpg')]");
  private static final By FILE_LOCATOR = By.xpath("//span[text()='test.jpg']/ancestor::div[3]");
  private static final By CONTAINER_LOCATOR = By.xpath("//span[text()='Новая папка']");
  private static final By DOWNLOAD_BUTTON = By.xpath("//input[@type='file']");
  private static final By BOOT_MESSAGE = By
      .xpath("//h3[@class='uploader-progress__progress-primary']");
  private static final By BOOT_MESSAGE_WINDOW_CLOSE = By.xpath(
      "//button[contains(@class,'button2_theme_clear-inverse uploader-progress__close-button')]");
  private static File file = new File("src/main/java/resources/test.jpg");
  private static final String pathFile = file.getAbsolutePath();

  public By getBOOT_MESSAGE() {
    return BOOT_MESSAGE;
  }

  public YandexDiskPage clickCreateButton() {
    driver.findElement(CREATE_BUTTON_LOCATOR).click();
    return this;
  }

  public NewFolderPage clickCreateFolderButton() {
    driver.findElement(CREATE_FOLDER_BUTTON_LOCATOR).click();
    return new NewFolderPage(driver);
  }

  public void clickFolder() {
    driver.findElement(FOLDER_NAME_LOCATOR).click();
  }

  public void clickDeleteButton() {
    driver.findElement(DELETE_BUTTON_LOCATOR).click();
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

  public String getNameNewFolder() {
    return driver.findElement(FOLDER_NAME_LOCATOR).getText();
  }

  public String getNameFile() {
    return driver.findElement(FILE_NAME_LOCATOR).getText();
  }

  public List<WebElement> findFolder() {
    List<WebElement> element = driver.findElements(FOLDER_NAME_LOCATOR);
    return element;
  }

  public void downloadFile() {
    driver.findElement(DOWNLOAD_BUTTON).sendKeys(pathFile);
  }

  public void dragAndDropFile() {
    WebElement draggable = driver.findElement(FILE_NAME_LOCATOR);
    WebElement target = driver.findElement(CONTAINER_LOCATOR);
    new Actions(driver).dragAndDrop(draggable, target).perform();
  }

  public WebElement findFile() {
    return driver.findElement(FILE_LOCATOR);
  }

  public WebElement findNameFile() {
    return driver.findElement(FILE_NAME_LOCATOR);
  }

  public WebElement findContainer() {
    return driver.findElement(CONTAINER_LOCATOR);
  }

  public void closeBootMessageWindow() {
    driver.findElement(BOOT_MESSAGE_WINDOW_CLOSE).click();
  }

}
