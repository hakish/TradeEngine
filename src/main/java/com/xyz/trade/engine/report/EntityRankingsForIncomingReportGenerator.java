package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;

import java.util.List;
import java.util.Map;

import static com.xyz.trade.engine.util.TEConstants.INCOMING;

public class EntityRankingsForIncomingReportGenerator extends AbstractReportGenerator {

    @Override
    public void generate(List<Instruction> instructions) {

        Map<String, Double> reportMap = generateRankingsReportMap(getSellInstructions(instructions));
        printRankingsReport(reportMap, INCOMING);
    }
}
