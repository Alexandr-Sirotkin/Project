package itAcademy.pages.CLOUD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PicturePage {

  private WebDriver driver;
  private static final By FILE_NAME_LOCATOR = By.xpath("//div[@class='file-name']");

  public PicturePage(WebDriver driver) {
    this.driver = driver;
  }

  public String getFileName() {
    return driver.findElement(FILE_NAME_LOCATOR).getText();
  }
}
