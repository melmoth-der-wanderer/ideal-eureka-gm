package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void acceptCookies() {
        click(By.xpath("//*[contains (@class, 'cookie-banner-button') and contains (text(),'Akkoord')]"));
    }

    public void click(By by) {
        waitForVisible(by).click();
    }

    public void scrollIntoView(By by) throws InterruptedException {
        waitForVisible(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
        Thread.sleep(1000);
    }

    public void fill(By by, String text) {
        waitForVisible(by).sendKeys(text);
    }

    public String getText(By by) {
        return waitForVisible(by).getText();
    }

    public WebElement waitForVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void verifyPage(String url, String title) {
        wait.until(ExpectedConditions.urlToBe(url));
        assert(driver.getTitle().equals(title));
    }
}
