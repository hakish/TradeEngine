package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;

import java.util.Arrays;

/**
 * This rule considers a typical weekend of saturday and sunday.
 * The work week is Monday to Friday.
 * This applies for all trades except those in the middle eastern countries i.e. Abhu Dhabi and Saudi Arabia.
 * These have the currencies denoted by AED and SAR respectively.
 */
public class TypicalWeekendRule extends AbstractWeekendRule {

    @Override
    protected String[] getWeekendDays() {
        return new String[]{"SATURDAY", "SUNDAY"};
    }

    @Override
    public boolean canRuleApply(Instruction instruction) {
        return doValidCurrencyCheck(instruction.getCurrency());
    }

    private boolean doValidCurrencyCheck(String currency) {
        return !Arrays.asList(TEConstants.MIDDLEEASTERNCURRENCIES).contains(currency);
    }
}
