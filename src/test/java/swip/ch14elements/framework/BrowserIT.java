package swip.ch14elements.framework;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(BrowserRunner.class)
public class BrowserIT {

    private Browser browser;

    @Inject private void setWebDriver(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    @Before public void setUp() throws Exception {
        browser.get("/registration-form.html");
    }

    @Test public void textInput() throws Exception {
        browser.setInputText(By.name("email"), "john.doe@email.com");
        assertEquals("john.doe@email.com", browser.getInputText(By.name("email")));
    }

    @Test public void textInputLambda() throws Exception {
        browser.setInputTextLambda(By.name("email"), "john.lambda@email.com");
        assertEquals("john.lambda@email.com", browser.getInputText(By.name("email")));
    }

    @Test public void checkbox() throws Exception {
        browser.setCheckboxValue(By.name("terms"), true);
        assertTrue(browser.isChecked(By.name("terms")));
    }

    @Test public void radio() throws Exception {
        browser.setRadio(By.cssSelector("input[name='contact']"), "email");
        assertEquals("email", browser.getRadio(By.cssSelector("input[name='contact']")));
    }

    @Test public void select() throws Exception {
        browser.getSelect(By.name("interest")).selectByVisibleText("Music");
    }

    @Test public void selectLambda() throws Exception {
        browser.getSelectLambda(By.name("interest")).selectByVisibleText("Music");
    }
}