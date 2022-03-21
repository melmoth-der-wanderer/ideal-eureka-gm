package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaintingDetailsPage extends BasePage {

    public final By itemDetailsExpander = By.cssSelector("[aria-label='Open Objectgegevens']");

    public PaintingDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPaintingInfo(String key, String expectedValue) {
        String factualValue = getText(By.xpath("//*[contains (@class, 'item-label') and text()='" + key + "']/following-sibling::*[contains (@class, 'item-value')]"));
        assert(factualValue.equals(expectedValue));
    }

}