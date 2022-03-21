import pages.CollectionPage;
import pages.MainPage;

import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PaintingDetailsPage;

@ExtendWith(SeleniumJupiter.class)
public class CollectionTest {

    @Test
    @DisplayName("Open collection page")
    public void openCollectionTest(@Arguments("--headless") ChromeDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        CollectionPage collectionPage = new CollectionPage(driver);

        mainPage.goTo();
        mainPage.scrollIntoView(mainPage.collectionLink);
        mainPage.click(mainPage.collectionLink);
        mainPage.verifyPage(collectionPage.URL, collectionPage.title);
    }

    @Test
    @DisplayName("Painting search from the search box")
    public void paintingSearchTest(@Arguments("--headless") ChromeDriver driver) {
        CollectionPage collectionPage = new CollectionPage(driver);

        collectionPage.goTo();
        collectionPage.search("Het Gele Huis");
        assert(collectionPage.getSearchResultsCount() > 700);
    }

    @Test
    @DisplayName("Select the painting from the search results")
    public void selectPaintingTest(@Arguments("--headless") ChromeDriver driver) throws InterruptedException {
        CollectionPage collectionPage = new CollectionPage(driver);
        PaintingDetailsPage paintingDetailsPage = new PaintingDetailsPage(driver);

        collectionPage.goTo();
        collectionPage.search("Het Gele Huis");
        collectionPage.selectPainting(1);
        paintingDetailsPage.scrollIntoView(paintingDetailsPage.itemDetailsExpander);
        paintingDetailsPage.click(paintingDetailsPage.itemDetailsExpander);
        paintingDetailsPage.verifyPaintingInfo("F-nummer", "F0464");
        paintingDetailsPage.verifyPaintingInfo("JH-nummer", "JH1589");
        paintingDetailsPage.verifyPaintingInfo("Inventarisnummer", "s0032V1962");
    }
}
