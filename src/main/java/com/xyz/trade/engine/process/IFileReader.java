package com.xyz.trade.engine.process;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;

import java.util.List;

/**
 * Interface for the file reading process.
 */
public interface IFileReader {

    List<Instruction> read() throws TradeEngineException;
}
