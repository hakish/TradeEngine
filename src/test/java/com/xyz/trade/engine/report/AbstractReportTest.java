package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class AbstractReportTest {

    private SettledAmntIncomingReport sir = new SettledAmntIncomingReport();
    private SettledAmntOutGoingReport sor = new SettledAmntOutGoingReport();
    private EntityRankingsByIncomingAmntReport eir = new EntityRankingsByIncomingAmntReport();
    private EntityRankingsByOutGoingAmountReport eor = new EntityRankingsByOutGoingAmountReport();

    private List<com.xyz.trade.engine.model.Instruction> instructionListBuy = new ArrayList<>();
    private List<com.xyz.trade.engine.model.Instruction> instructionListSell = new ArrayList<>();

    @Before
    public void setup() {
        instructionListBuy.add(new Instruction("foo,B,1,SGP,'01 Jan 2016', '02 Jan 2016',2,10".split(TEConstants.COMMA)));
        instructionListBuy.add(new Instruction("zoo,B,1,INR,'05 Jan 2016', '06 Jan 2016',2,30".split(TEConstants.COMMA)));
        instructionListBuy.add(new Instruction("foo,B,1,SGP,'01 Jan 2016', '02 Jan 2016',2,40".split(TEConstants.COMMA)));

        instructionListSell.add(new Instruction("bar,S,1,AED,'05 Jan 2016', '07 Jan 2016',4,20".split(TEConstants.COMMA)));
        instructionListSell.add(new Instruction("Infy,S,1,INR,'30 Aug 2018', '03 Sep 2018',6,40".split(TEConstants.COMMA)));
    }

    @Test
    public void generateTradeAmntReportMapIncoming() {
        Map<String, Double> sirMap = sir.generateTradeAmntReportMap(instructionListSell);
        Map<String, Double> expSirMap = new TreeMap<>();
        expSirMap.put("07 Jan 2016", 80.0);
        expSirMap.put("03 Sep 2018", 240.0);
        assertMap(sirMap, expSirMap);
    }

    @Test
    public void generateTradeAmntReportMapOutgoing() {
        Map<String, Double> sorMap = sor.generateTradeAmntReportMap(instructionListBuy);
        Map<String, Double> expSorMap = new TreeMap<>();
        expSorMap.put("02 Jan 2016", 100.0);
        expSorMap.put("06 Jan 2016", 60.0);
        assertMap(sorMap, expSorMap);
    }

    @Test
    public void generateRankingsReportMapIncoming() {
        Map<String, Double> eirMap = eir.generateRankingsReportMap(instructionListSell);
        Map<String, Double> expEirMap = new LinkedHashMap<>();
        expEirMap.put("Infy", 240.0);
        expEirMap.put("bar", 80.0);
        assertMap(eirMap, expEirMap);
    }
    @Test
    public void generateRankingsReportMapOutgoing() {
        Map<String, Double> eorMap = eor.generateRankingsReportMap(instructionListBuy);
        Map<String, Double> expEorMap = new TreeMap<>();
        expEorMap.put("zoo", 60.0);
        expEorMap.put("foo", 80.0);
        assertMap(eorMap, expEorMap);
    }

    private void assertMap(Map<String, Double> actMap, Map<String, Double> expMap) {
        for (Map.Entry e : actMap.entrySet()) {
            Assert.assertNotNull(expMap.get(e.getKey()));
            Assert.assertEquals(expMap.get(e.getKey()), e.getValue());
        }
    }
}