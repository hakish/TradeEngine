package com.xyz.trade.engine.exception;

public class TradeEngineException extends Exception {

    public TradeEngineException() {
    }

    public TradeEngineException(String s) {
        super(s);
    }

    public TradeEngineException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TradeEngineException(Throwable throwable) {
        super(throwable);
    }

    public TradeEngineException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
