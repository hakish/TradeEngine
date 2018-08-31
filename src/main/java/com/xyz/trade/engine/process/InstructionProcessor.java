package com.xyz.trade.engine.process;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.rules.WeekendRuleFactory;

import java.util.List;

/**
 * This class contains the core logic to process an instruction.
 * Here all the business rules are applied on the instructions.
 */
public class InstructionProcessor implements IProcessor {

    @Override
    public boolean process(List<Instruction> instructions) throws TradeEngineException {
        //1. Apply the Weekend Rule
        instructions.stream()
                .forEach(instr -> WeekendRuleFactory.getWeekendRule(instr).apply(instr));
        return true;
    }
}
