package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CollectionPage extends BasePage {

    public final String URL = "https://www.vangoghmuseum.nl/nl/collectie";
    public final String title = "Collectie - Van Gogh Museum";
    public final By searchBox = By.cssSelector(".list-filters-form-left .search-field-input");
    public final By searchButton = By.cssSelector(".search-field-search-button");
    public final By searchResults = By.cssSelector(".results");

    public CollectionPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(URL);
        verifyPage(URL, title);
        acceptCookies();
    }

    public Integer getSearchResultsCount() {
        return Integer.parseInt(getText(searchResults));
    }

    public void search(String query) {
        Integer initialSearchResultsCount = getSearchResultsCount();
        fill(searchBox, query);
        click(searchButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='" + initialSearchResultsCount + "']")));
    }

    public void selectPainting(Integer number) {
        click(By.xpath("(//*[@class='collection-art-object-item'])[" + number + "]"));
    }
}
