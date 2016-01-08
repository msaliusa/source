package swip.misc;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swip.framework.Ocr;
import swip.framework.WebDriverRunner;
import swip.framework.WebElementScreenshotTaker;

import javax.inject.Inject;
import java.io.File;

import static org.junit.Assert.assertEquals;

@RunWith(WebDriverRunner.class)
@Ignore("demo of proof of concept for parsing text on HTML canvas")
public class CanvasIT {
    @Inject private WebDriver driver;
    @Inject private WebElementScreenshotTaker screenshotTaker;
    @Inject private Ocr ocr;

    @Before
    public void setUp() throws Exception {
        driver.get("/canvas.html");
    }

    @Test
    public void captureCanvas() throws Exception {
        WebElement canvas = driver.findElement(By.tagName("canvas"));

        File destFile = screenshotTaker.takeScreenshot(driver, canvas);

        assertEquals("Hello WebDriver", ocr.recognise(destFile).trim());
    }
}