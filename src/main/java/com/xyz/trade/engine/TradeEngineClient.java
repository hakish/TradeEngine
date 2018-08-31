package com.xyz.trade.engine;

import com.xyz.trade.engine.exception.TradeEngineException;

public class TradeEngineClient {

    public static void main(String[] args) throws TradeEngineException {
        TradeEngine te = new TradeEngine();
        te.run();
    }
}
