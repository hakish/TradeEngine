package com.xyz.trade.engine.rules;

import java.time.LocalDate;
import java.util.Arrays;

public class MiddleEastWeekendRule extends AbstractWeekendRule {

    private enum MEWeekend {
        FRIDAY, SATURDAY;
    }

    @Override
    public boolean isWeekend(LocalDate date) {
        return Arrays.stream(MiddleEastWeekendRule.MEWeekend.values())
                .anyMatch(day -> day.name().equalsIgnoreCase(date.getDayOfWeek().name()));
    }
}
