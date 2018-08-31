package com.xyz.trade.engine.report;

import com.xyz.trade.engine.model.Instruction;

import java.util.List;

/**
 * Interface for report generation process.
 */
public interface IReportGenerator {

    void generate(List<Instruction> instructions);
}
