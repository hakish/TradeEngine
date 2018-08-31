package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.model.Instruction;

public class WeekendRuleFactory {

    public static AbstractWeekendRule getWeekendRule(Instruction instruction) {

        switch (instruction.getCurrency()) {
            case "SAR": return new MiddleEastWeekendRule();
            case "AED": return new MiddleEastWeekendRule();
            default: return new TypicalWeekendRule();
        }

    }
}
