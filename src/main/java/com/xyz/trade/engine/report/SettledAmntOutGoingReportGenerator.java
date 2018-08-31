package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SettledAmntOutGoingReportGenerator extends AbstractReportGenerator {

    @Override
    public void generate(List<Instruction> instructions) {

        List<Instruction> buyInstuctions = instructions.stream()
                .filter(instr ->  TEConstants.BUYSELL.B.name().equalsIgnoreCase(instr.getBuySell().name()))
                .collect(Collectors.toList());

        Map<String, Double> reportMap = generateTradeAmntReportMap(buyInstuctions);
        System.out.println(":: ====================================================== :: ");
        System.out.println(":: Amount in USD settled Outgoing everyday :: ");
        System.out.println(":: ====================================================== :: ");
        reportMap.entrySet().stream().forEach(e -> System.out.println("-- Date is "+e.getKey()+" Total Outgoing Amount is "+e.getValue()));
        System.out.println(":: ====================================================== :: \n");
    }
}
