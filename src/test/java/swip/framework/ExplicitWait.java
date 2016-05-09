package swip.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public interface ExplicitWait extends SearchScope {

    default Element untilFound(Supplier<By> by) {
        return new FluentWait<>(this)
            .withTimeout(1, SECONDS)
            .pollingEvery(10, MILLISECONDS)
            .ignoring(Exception.class)
            .until((SearchScope e) -> e.findElement(by));
    }

    default void until(Predicate<SearchScope> predicate) {
        new FluentWait<>(this)
            .withTimeout(1, SECONDS)
            .pollingEvery(10, MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .until(
                (SearchScope where) -> predicate.test(where)
            );
    }

    default <T> T until(Function<SearchScope, T> function) {
        return new FluentWait<>(this)
            .withTimeout(1, SECONDS)
            .pollingEvery(10, MILLISECONDS)
            .ignoring(Exception.class)
            .until(
                (SearchScope where) -> function.apply(where)
            );
    }

    default String getText(Supplier<By> by) {
        return untilFound(by).getText();
    }

    default String getUpperText(Supplier<By> by) {
        return untilFound(by).getText().toUpperCase();
    }

    default void click(Supplier<By> by) {
        untilFound(by).click();
    }
}
