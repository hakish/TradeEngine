package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;

import java.util.List;
import java.util.Map;

import static com.xyz.trade.engine.util.TEConstants.OUTGOING;

/**
 * This class aggregates all Outgoing settlement amount from
 * various instruction for a day.
 * Generates a report and prints it to the console.
 */
public class SettledAmntOutGoingReport extends AbstractReport {

    @Override
    public void generate(List<Instruction> instructions) {

        Map<String, Double> reportMap = generateTradeAmntReportMap(getBuyInstructions(instructions));
        printIOReport(reportMap, OUTGOING);
    }
}
