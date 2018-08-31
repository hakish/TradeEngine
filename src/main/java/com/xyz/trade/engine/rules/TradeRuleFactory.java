package com.xyz.trade.engine.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the business rules
 * that can be applied to an instruction.
 */
public class TradeRuleFactory {

    public static List<IRule> getRules() {
        List<IRule> rules = new ArrayList<>();
        rules.add(new MiddleEastWeekendRule());
        rules.add(new TypicalWeekendRule());
        return rules;
    }
}

