package com.xyz.trade.engine;

import com.xyz.trade.engine.exception.TradeEngineException;

/**
 * This class is a client that starts the trade engine process.
 */
public class TradeEngineClient {

    public static void main(String[] args) throws TradeEngineException {
        TradeEngine te = new TradeEngine();
        te.run();
    }
}
