package swip.ch05pageobjects.loadablepagefactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import swip.ch07managingwebdriver.SeleniumWebDriverRunner;

import javax.inject.Inject;

@RunWith(SeleniumWebDriverRunner.class)
public class SearchFormIT {
    @Inject
    private WebDriver driver;

    @Test
    public void searchPage() throws Exception {
        SearchForm page = LoadingPageFactory.get(driver, SearchForm.class);
        page.searchFor("funny cats");
    }
}