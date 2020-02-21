package itAcademy.pages.CLOUD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewFolderPage {

  private WebDriver driver;
  private static final By HEADING_LOCATOR = By.xpath("//div[@class='dialog__title']");
  private static final By SAVE_BUTTON_LOCATOR = By
      .xpath("//button[contains(@class,'confirmation-dialog__button_submit')]");
  private static final By NAME_FIELD = By
      .xpath("//form[@class='rename-dialog__rename-form']//input");

  public NewFolderPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement findFolderNameField() {
    return driver.findElement(NAME_FIELD);
  }

  public String getHeadingText() {
    return driver.findElement(HEADING_LOCATOR).getText();
  }

  public void save() {
    driver.findElement(SAVE_BUTTON_LOCATOR).click();
  }

}
