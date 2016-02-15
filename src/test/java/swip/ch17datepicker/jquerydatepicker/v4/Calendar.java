package swip.ch17datepicker.jquerydatepicker.v4;

import swip.ch15pageflow.framework.Browser;

import java.util.function.Function;


public class Calendar {

    private final Browser browser;        //<1>
    private final Function<Browser, Void> trigger;   //<2>

    /**
     * Constructor of the Calendar.
     *
     * @param browser
     * @param trigger
     */
    public Calendar(Browser browser, Function<Browser, Void> trigger) { //<6>
        this.browser = browser;
        this.trigger = trigger;
    }

    /**
     * Display the calendar
     */
    public void show() {  //<7>
        trigger.apply(browser);      //<9>
    }
}