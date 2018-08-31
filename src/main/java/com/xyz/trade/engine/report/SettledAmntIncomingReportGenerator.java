package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;

import java.util.List;
import java.util.Map;

import static com.xyz.trade.engine.util.TEConstants.INCOMING;
/**
 * This class aggregates all Incoming settlement amount from
 * various instruction for a day.
 * Generates a report and prints it to the console.
 */
public class SettledAmntIncomingReportGenerator extends AbstractReportGenerator {

    public SettledAmntIncomingReportGenerator() {
    }

    @Override
    public void generate(List<Instruction> instructions) {
        Map<String, Double> reportMap = generateTradeAmntReportMap(getSellInstructions(instructions));
        printIOReport(reportMap, INCOMING);
    }
}
