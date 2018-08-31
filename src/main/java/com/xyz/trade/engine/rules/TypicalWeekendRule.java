package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;
import com.xyz.trade.engine.util.TEUtil;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * This rule considers a typical weekend of saturday and sunday.
 * The work week is Monday to Friday.
 * This applies for all trades except those in the middle eastern countries i.e. Abhu Dhabi and Saudi Arabia.
 * These have the currencies denoted by AED and SAR respectively.
 */
public class TypicalWeekendRule extends AbstractWeekendRule {

    private enum TypicalWeekend {
        SATURDAY, SUNDAY;
    }

    @Override
    public boolean isWeekend(LocalDate date) {
        return Arrays.stream(TypicalWeekend.values())
                    .anyMatch(day -> day.name().equalsIgnoreCase(date.getDayOfWeek().name()));
    }
}
