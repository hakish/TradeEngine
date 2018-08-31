package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;

import java.util.Arrays;

public class MiddleEastWeekendRule extends AbstractWeekendRule {

    @Override
    protected String[] getWeekendDays() {
        return new String[]{"FRIDAY","SATURDAY"};
    }

    @Override
    public boolean canRuleApply(Instruction instruction) {
        return doValidCurrencyCheck(instruction.getCurrency());
    }

    private boolean doValidCurrencyCheck(String currency) {
        return Arrays.asList(TEConstants.MIDDLEEASTERNCURRENCIES).contains(currency);
    }
}
