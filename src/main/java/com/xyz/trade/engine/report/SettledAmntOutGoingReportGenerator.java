package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.xyz.trade.engine.util.TEConstants.INCOMING;
import static com.xyz.trade.engine.util.TEConstants.OUTGOING;

public class SettledAmntOutGoingReportGenerator extends AbstractReportGenerator {

    @Override
    public void generate(List<Instruction> instructions) {

        Map<String, Double> reportMap = generateTradeAmntReportMap(getBuyInstructions(instructions));
        printIOReport(reportMap, OUTGOING);
    }
}
