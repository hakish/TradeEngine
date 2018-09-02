package com.xyz.trade.engine.report;

/**
 * This is factory class abstracting the creation of all report generators.
 */
public class TradeEngineReportFactory {

    public static AbstractReport[] getAllReportGenerators() {

        return new AbstractReport[]{new SettledAmntIncomingReport(),
        new SettledAmntOutGoingReport(), new EntityRankingsByIncomingAmntReport()
        , new EntityRankingsByOutGoingAmountReport()};
    }
}
