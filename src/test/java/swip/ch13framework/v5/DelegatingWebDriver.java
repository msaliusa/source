package swip.ch13framework.v5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class DelegatingWebDriver implements WebDriver {
    private final WebDriver delegate; // <1>

    public DelegatingWebDriver(WebDriver delegate) {
        this.delegate = delegate;
    }

    @Override public List<WebElement> findElements(By by) {
        return delegate.findElements(by);
    }

    @Override public WebElement findElement(By by) {
        return delegate.findElement(by);
    }

    @Override public void get(String url) {
        delegate.get(url); // <2>
    }

    @Override public String getCurrentUrl() {
        return delegate.getCurrentUrl();
    }

    @Override public String getTitle() {
        return delegate.getTitle();
    }

    @Override public String getPageSource() {
        return delegate.getPageSource();
    }

    @Override public void close() {
        delegate.close();
    }

    @Override public void quit() {
        delegate.quit();
    }

    @Override public Set<String> getWindowHandles() {
        return delegate.getWindowHandles();
    }

    @Override public String getWindowHandle() {
        return delegate.getWindowHandle();
    }

    @Override public TargetLocator switchTo() {
        return delegate.switchTo();
    }

    @Override public Navigation navigate() {
        return delegate.navigate();
    }

    @Override public Options manage() {
        return delegate.manage();
    }
}
