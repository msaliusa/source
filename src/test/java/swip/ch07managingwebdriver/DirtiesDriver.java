package swip.ch07managingwebdriver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the test makes the driver "dirty". E.g. leaves windows open.
 * The driver should be quit and subsequent tests use a new driver.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DirtiesDriver {
}
