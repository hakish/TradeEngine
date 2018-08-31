package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;
import com.xyz.trade.engine.util.TradeUtil;

import java.time.LocalDate;
import java.util.Arrays;

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

        if(!canRuleApply(instruction)) {
            return false;
        }
        try {
            //1. Check if the settlement date is a weekend if so change it to next week day.
            LocalDate date = instruction.getSettlementDate();
            boolean isWeekendSD = isWeekend(date);
            if (isWeekendSD) {
                System.out.println("Settlement Date "+date+" is falling on a weekend Get the next working day.");
                date = getNextWorkingDay(date);
            }
            instruction.setSettlementDate(TradeUtil.getDateStr(date, TEConstants.TEDATEFORMAT));
        } catch (Exception ex) {
        }
        return true;
    }

    public LocalDate getNextWorkingDay(LocalDate date) {
        while (isWeekend(date)) {
            date = date.plusDays(1);
        }
        return date;
    }

    public boolean isWeekend(LocalDate date) {
        return Arrays.stream(getWeekendDays())
                .anyMatch(day -> day.equalsIgnoreCase(date.getDayOfWeek().name()));
    }

    protected abstract String[] getWeekendDays();
    protected abstract boolean canRuleApply(Instruction instruction);

}
