package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class SearchBaiduTest {
    private WebDriver driver;

    @Before
    public void initBrowser() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
    }

    @Given("I am on the Baidu search page")
    public void i_am_on_the_baidu_search_page() {
        driver.get("https://www.buidu.com");
    }

    @When("I search for {string}")
    public void i_search_for(String keyWords) {
        driver.findElement(By.name("q")).sendKeys(keyWords + Keys.ENTER);
    }

    @Then("the page title should start with {string}")
    public void the_page_title_should_start_with(String keyword) {
        new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                assert input != null;
                return input.getTitle().toLowerCase().startsWith(keyword);
            }
        });
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] buff = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(buff, "image/png", "search_baidu_failed");
        }
        driver.quit();
    }
}
