package com.xyz.trade.engine.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility class.
 */
public class TEUtil {

    /**
     * This method gets a string date in 'DD MMM YYYY' and
     * returns a LocalDate instance
     * @param date
     * @return
     */
    public static LocalDate getDate(String date, String pattern) {
        if (isNullEmpty(pattern)) {
            throw new IllegalArgumentException("Please send a valid pattern.");
        }
        if (isNullEmpty(date)) {
            throw new IllegalArgumentException("Please send a valid date.");
        }
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * This method gets a string date in 'DD MMM YYYY' and
     * returns a LocalDate instance
     * @param date
     * @return
     */
    public static String getDateStr(LocalDate date, String pattern) {
        if (isNullEmpty(pattern)) {
            throw new IllegalArgumentException("Please send a valid pattern.");
        }
        if (null == date) {
            throw new IllegalArgumentException("Please send a valid date.");
        }
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Checks if the input is null or empty.
     * @param input
     * @return
     */
    public static boolean isNullEmpty(String input) {
        return (null == input || input.trim().isEmpty());
    }
}
