package com.xyz.trade.engine.process;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;

import java.util.List;

public interface IProcessor {

    boolean process(List<Instruction> instruction) throws TradeEngineException;
}
