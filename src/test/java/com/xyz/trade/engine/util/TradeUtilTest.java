package com.xyz.trade.engine.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class TradeUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDate() {
        LocalDate date = TradeUtil.getDate("02 Jan 2016", "dd MMM yyyy");
        Assert.assertNotNull(date);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getDate1() {
        LocalDate date = TradeUtil.getDate("", "dd MMM yyyy");
    }
    @Test(expected = IllegalArgumentException.class)
    public void getDate2() {
        LocalDate date = TradeUtil.getDate(null, "dd MMM yyyy");
    }
    @Test(expected = IllegalArgumentException.class)
    public void getDate3() {
        LocalDate date = TradeUtil.getDate("02 Jan 2016", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDate4() {
        LocalDate date = TradeUtil.getDate("02 Jan 2016", null);
    }

    @Test
    public void getDateString() {
        LocalDate date = LocalDate.of(2016, Month.JANUARY, 2);
        String dateStr = TradeUtil.getDateStr(date, "dd MMM yyyy");
        Assert.assertNotNull(dateStr);
        Assert.assertEquals("02 Jan 2016", dateStr);
    }

}