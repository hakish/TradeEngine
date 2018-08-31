package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EntityRankingsForIncomingReportGenerator extends AbstractReportGenerator {

    @Override
    public void generate(List<Instruction> instructions) {

        List<Instruction> sellInstuctions = instructions.stream()
                .filter(instr ->  TEConstants.BUYSELL.S.name().equalsIgnoreCase(instr.getBuySell().name()))
                .collect(Collectors.toList());

        Map<String, Double> reportMap = generateRankingsReportMap(sellInstuctions);
        System.out.println(":: ====================================================== :: ");
        System.out.println(":: Ranking of entities based on Incoming Amount :: ");
        System.out.println(":: ====================================================== :: ");
        AtomicInteger rank = new AtomicInteger(0);
        reportMap.entrySet().stream()
                .forEach(e -> System.out.println("-- Entity " +e.getKey()
                        +" Rank is " +rank.incrementAndGet()
                        +" Amount is "+e.getValue()));
        System.out.println(":: ====================================================== :: \n");
    }
}
