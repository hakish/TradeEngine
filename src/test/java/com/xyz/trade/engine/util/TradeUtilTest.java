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
    public void getDateString() {
        LocalDate date = LocalDate.of(2016, Month.JANUARY, 2);
        String dateStr = TradeUtil.getDateStr(date, "dd MMM yyyy");
        Assert.assertNotNull(dateStr);
        Assert.assertEquals("02 Jan 2016", dateStr);
    }

}