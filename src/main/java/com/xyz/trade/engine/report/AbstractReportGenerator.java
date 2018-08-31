package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;
import com.xyz.trade.engine.util.TradeUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * This class holds the common logic for report generation.
 */
public abstract class AbstractReportGenerator implements IReportGenerator {

    /**
     * For a given list of instructions this method generates the
     * report map with settlement date as key.
     * @param instuctions
     * @return
     */
    protected Map<String, Double> generateTradeAmntReportMap(List<Instruction> instuctions) {
        Map<String, Double> reportMap = new TreeMap<>();
        for (Instruction instr  : instuctions) {
            Double tradeAmnt = reportMap.get(TradeUtil.getDateStr(instr.getSettlementDate(), TEConstants.TEDATEFORMAT));
            if (null == tradeAmnt) {
                tradeAmnt = instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits();
            } else {
                tradeAmnt = tradeAmnt + (instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits());
            }
            reportMap.put(TradeUtil.getDateStr(instr.getSettlementDate(), TEConstants.TEDATEFORMAT), tradeAmnt);
        }
        return reportMap;
    }

    /**
     * For a given list of instructions this method generates the
     * report map for entity rankings.
     * @param instructions
     * @return
     */
    protected Map<String, Double> generateRankingsReportMap(List<Instruction> instructions) {

        Map<String, Double> reportMap = new TreeMap();
        for (Instruction instr  : instructions) {
            Double tradeAmnt = reportMap.get(instr.getEntity());
            if (null == tradeAmnt) {
                tradeAmnt = instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits();
            } else {
                tradeAmnt = tradeAmnt + (instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits());
            }
            reportMap.put(instr.getEntity(), tradeAmnt);
        }
        Map<String, Double> sortedMap = new LinkedHashMap();
        reportMap.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e1 -> sortedMap.put(e1.getKey(), e1.getValue()));
        return sortedMap;
    }

    /**
     * Filters out all the BUY instructions from a given LIST
     * @param instructions
     * @return
     */
    protected List<Instruction> getBuyInstructions(List<Instruction> instructions) {
        return instructions.stream()
                .filter(instr ->  TEConstants.BUYSELL.B.name().equalsIgnoreCase(instr.getBuySell().name()))
                .collect(Collectors.toList());
    }

    /**
     * Filters out all the SELL instructions from a given LIST
     * @param instructions
     * @return
     */
    protected List<Instruction> getSellInstructions(List<Instruction> instructions) {
        return instructions.stream()
                .filter(instr ->  TEConstants.BUYSELL.S.name().equalsIgnoreCase(instr.getBuySell().name()))
                .collect(Collectors.toList());
    }

    /**
     * Prints the output to the console for daily settlement amount report
     * @param reportMap
     * @param io
     */
    protected void printIOReport(Map<String, Double> reportMap, String io) {
        System.out.println("\n:: ====================================================== :: ");
        System.out.println(":: Amount in USD settled " + io + " everyday :: ");
        System.out.println(":: ====================================================== :: ");
        reportMap.entrySet().stream().forEach(e -> System.out.println("-- Date is "+e.getKey()+" Incoming Amount is "+e.getValue()));
        System.out.println(":: ====================================================== :: \n");
    }

    /**
     * Prints the output to the console for entity rankings report
     * @param reportMap
     * @param io
     */
    protected void printRankingsReport(Map<String, Double> reportMap, String io) {
        System.out.println("\n:: ====================================================== :: ");
        System.out.println(":: Ranking of entities based on "+io+" :: ");
        System.out.println(":: ====================================================== :: ");
        AtomicInteger rank = new AtomicInteger(0);
        reportMap.entrySet().stream()
                .forEach(e -> System.out.println("-- Entity " +e.getKey()
                        +" Rank is " +rank.incrementAndGet()
                        +" Amount is "+e.getValue()));
        System.out.println(":: ====================================================== :: \n");
    }
}
