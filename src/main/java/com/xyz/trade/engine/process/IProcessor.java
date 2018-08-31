package com.xyz.trade.engine.process;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;

import java.util.List;

/**
 * Interface for the processor
 */
public interface IProcessor {

    /**
     * Apply business rules and other processing logic on an a list of instructions
     * @param instruction
     * @return
     * @throws TradeEngineException
     */
    boolean process(List<Instruction> instruction) throws TradeEngineException;
}
