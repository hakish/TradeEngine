package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class MiddleEastWeekendRuleTest {

    private MiddleEastWeekendRule rule = new MiddleEastWeekendRule();
    private String sampleTrade1 = "foo,B,0.50,SGP,'01 Jan 2016', '02 Jan 2016',200,100.25";
    private Instruction sampleInstruction;

    @Before
    public void setUp(){
        sampleInstruction = new Instruction(sampleTrade1.split(TEConstants.COMMA));
    }

    @Test
    public void getWeekendDays() {
        Assert.assertTrue(Arrays.asList(rule.getWeekendDays()).contains("FRIDAY"));
        Assert.assertTrue(Arrays.asList(rule.getWeekendDays()).contains("SATURDAY"));
    }

    @Test
    public void canRuleApply() {
        boolean actual = rule.canRuleApply(sampleInstruction);
        Assert.assertFalse(actual);
    }

    @Test
    public void isWeekend() {
        LocalDate date = LocalDate.of(2018, Month.AUGUST, 31);
       Assert.assertTrue(rule.isWeekend(date));
    }

    @Test
    public void getNextWorkingDay() {
        LocalDate date = LocalDate.of(2018, Month.AUGUST, 31);
        LocalDate expdate = LocalDate.of(2018, Month.SEPTEMBER, 2);
        Assert.assertEquals(expdate, rule.getNextWorkingDay(date));
    }
}