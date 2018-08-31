package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SettledAmntOutGoingReportGenerator extends AbstractReportGenerator {

    @Override
    public void generate(List<Instruction> instructions) {

        List<Instruction> sellInstuctions = instructions.stream()
                .filter(instr ->  TEConstants.BUYSELL.B.name().equalsIgnoreCase(instr.getBuySell().name()))
                .collect(Collectors.toList());

        Map<String, Double> reportMap = generateTradeAmntReportMap(sellInstuctions);
        System.out.println(":: Amount in USD settled Outgoing everyday :: ");
        System.out.println(reportMap);
    }
}
