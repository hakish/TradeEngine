package com.xyz.trade.engine.report;

/**
 * This is factory class abstracting the creation of all report generators.
 */
public class TradeEngineReportGeneratorFactory {

    public static AbstractReportGenerator[] getAllReportGenerators() {

        return new AbstractReportGenerator[]{new SettledAmntIncomingReportGenerator(),
        new SettledAmntOutGoingReportGenerator(), new EntityRankingsByIncomingAmntReport()
        , new EntityRankingsByOutGoingAmountReport()};
    }
}
