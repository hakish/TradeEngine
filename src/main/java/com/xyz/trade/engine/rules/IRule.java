package com.xyz.trade.engine.rules;

import com.xyz.trade.engine.model.Instruction;

public interface IRule {

    boolean apply(Instruction instruction);
}
