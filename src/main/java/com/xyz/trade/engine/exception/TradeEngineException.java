package com.xyz.trade.engine.exception;

/**
 * Custom Exception class for Trade Engine.
 */
public class TradeEngineException extends Exception {

    public TradeEngineException(String s) {
        super(s);
    }

    public TradeEngineException(Throwable throwable) {
        super(throwable);
    }

}
