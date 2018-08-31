package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;
import com.xyz.trade.engine.util.TEUtil;

import java.time.LocalDate;

/**
 * This class follows the below business rule:-
 * A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where
 * the work week starts Sunday and ends Thursday. No other holidays to be taken into account.
 * A trade can only be settled on a working day.
 * If an instructed settlement date falls on a weekend, then the settlement date should be changed to
 * the next working day.A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where
 * the work week starts Sunday and ends Thursday. No other holidays to be taken into account.
 * A trade can only be settled on a working day.
 * If an instructed settlement date falls on a weekend, then the settlement date should be changed to
 * the next working day.
 */
public abstract class AbstractWeekendRule implements IRule {

    @Override
    public boolean apply(Instruction instruction) {
        try {
            //1. Check if the settlement date is a weekend if so change it to next week day.
            LocalDate date = instruction.getSettlementDate();
            boolean isWeekendSD = isWeekend(date);
            if (isWeekendSD) {
                date = getNextWorkingDay(date);
            }
            instruction.setSettlementDate(TEUtil.getDateStr(date, TEConstants.TEDATEFORMAT));
        } catch (Exception ex) {
            //TODO ADD LOGGERS
        }
        return true;
    }

    private LocalDate getNextWorkingDay(LocalDate date) {
        while (isWeekend(date)) {
            date = date.plusDays(1);
        }
        return date;
    }

    protected abstract boolean isWeekend(LocalDate date);

}
