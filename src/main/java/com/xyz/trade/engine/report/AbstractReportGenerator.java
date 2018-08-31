package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;
import com.xyz.trade.engine.util.TEUtil;

import java.util.*;

public abstract class AbstractReportGenerator implements IReportGenerator {

    /**
     * For a given list of instructions this method generates the
     * report map with settlement date as key.
     * @param instuctions
     * @return
     */
    protected Map<String, Double> generateTradeAmntReportMap(List<Instruction> instuctions) {
        Map<String, Double> reportMap = new HashMap<>();
        for (Instruction instr  : instuctions) {
            Double tradeAmnt = reportMap.get(instr.getSettlementDate());
            if (null == tradeAmnt) {
                tradeAmnt = instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits();
            } else {
                tradeAmnt = tradeAmnt + (instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits());
            }
            reportMap.put(TEUtil.getDateStr(instr.getSettlementDate(), TEConstants.TEDATEFORMAT), tradeAmnt);
        }
        return reportMap;
    }

    /**
     * For a given list of instructions this method generates the
     * report map for entity rankings.
     * @param instuctions
     * @return
     */
    protected Map<String, Double> generateRankingsReportMap(List<Instruction> instuctions) {

        Comparator<Map.Entry> rankingsComparator = ()
        Map<String, Double> reportMap = new TreeMap<>();
        for (Instruction instr  : instuctions) {
            Double tradeAmnt = reportMap.get(instr.getEntity());
            if (null == tradeAmnt) {
                tradeAmnt = instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits();
            } else {
                tradeAmnt = tradeAmnt + (instr.getAgreedFx() * instr.getPricePerUnit() * instr.getUnits());
            }
            reportMap.put(TEUtil.getDateStr(instr.getSettlementDate(), TEConstants.TEDATEFORMAT), tradeAmnt);
        }
        return reportMap;
    }

    protected
}
