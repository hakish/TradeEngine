package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;

import java.util.List;
import java.util.Map;

import static com.xyz.trade.engine.util.TEConstants.OUTGOING;

/**
 * This class Ranks all of the entities based on their outgoing settlement amount.
 * Generates a report and prints it to the console.
 */
public class EntityRankingsByOutGoingAmountReport extends AbstractReportGenerator {

    @Override
    public void generate(List<Instruction> instructions) {
        Map<String, Double> reportMap = generateRankingsReportMap(getBuyInstructions(instructions));
        printRankingsReport(reportMap, OUTGOING);
    }
}
