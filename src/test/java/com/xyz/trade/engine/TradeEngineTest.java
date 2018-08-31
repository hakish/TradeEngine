package com.xyz.trade.engine;

import com.xyz.trade.engine.exception.TradeEngineException;
import org.junit.Test;

public class TradeEngineTest {

    private TradeEngine engine = new TradeEngine();

    @Test
    public void testEngine() {
        try {
            engine.run();
        } catch (TradeEngineException e) {
            e.printStackTrace();
        }
    }


}