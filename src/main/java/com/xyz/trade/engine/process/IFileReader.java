package com.xyz.trade.engine.process;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;

import java.util.List;

public interface IFileReader {

    boolean read(String path) throws TradeEngineException;
    List<Instruction> read() throws TradeEngineException;
}
