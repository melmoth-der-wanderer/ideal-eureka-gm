package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public final String URL = "https://www.vangoghmuseum.nl/nl"; // BaseUrl
    public final String title = "Van Gogh Museum - Hét museum over Vincent van Gogh in Amsterdam";
    public final By collectionLink = By.xpath("//*[@class='cta-list-item']/descendant::*[@href='/nl/collectie']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(URL);
        verifyPage(URL, title);
        acceptCookies();
    }
}