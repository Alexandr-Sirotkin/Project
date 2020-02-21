package itAcademy.pages.CLOUD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FolderPage {

  private WebDriver driver;
  private static final By HEADING_FILE_LOCATOR = By.xpath("//span[text()='test.jpg']");
  private static final By SHARE_BUTTON_LOCATOR = By.xpath(
      "//span[contains(text(),'Поделиться')]/ancestor::div[contains(@class,'control menu__item')]");
  private static final By LINK_LOCATOR = By
      .xpath("//input[@class='publish-resource-tumbler__input']");
  private static final By FILE_LOCATOR = By.xpath("//div/span[contains(text(),'test.jpg')]");
  private static final By DELETE_BUTTON_LOCATOR = By
      .xpath("//button[contains(@class,'visible-button_name_delete')]");

  public FolderPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeadingTextFile() {
    return driver.findElement(HEADING_FILE_LOCATOR).getText();
  }

  public void clickShareButton() {
    driver.findElement(SHARE_BUTTON_LOCATOR).click();
  }

  public String getFileLinkLocator() {
    return driver.findElement(LINK_LOCATOR).getAttribute("value");
  }

  public void clickFile() {
    driver.findElement(FILE_LOCATOR).click();
  }

  public void clickDeleteButton() {
    driver.findElement(DELETE_BUTTON_LOCATOR).click();
  }

}
