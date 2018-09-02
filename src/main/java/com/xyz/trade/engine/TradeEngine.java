package com.xyz.trade.engine;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.process.CSVInstructionFileReader;
import com.xyz.trade.engine.process.InstructionProcessor;
import com.xyz.trade.engine.report.AbstractReportGenerator;
import com.xyz.trade.engine.report.TradeEngineReportGeneratorFactory;

import java.util.Arrays;
import java.util.List;

/**
 * This class encapsulates the workflow to read the instructions,
 * validate them apply the relevant rules and Generates the report
 */
public class TradeEngine {

    public void run() throws TradeEngineException {

        //1. Read the Instuctions from the file.
        CSVInstructionFileReader reader = new CSVInstructionFileReader();
        List<Instruction> instructions = reader.read();

        //2. Process the Instructions and apply the rules
        InstructionProcessor processor = new InstructionProcessor();
        processor.process(instructions);

        //3. Generate the reports.
        AbstractReportGenerator[] reportGenerators = TradeEngineReportGeneratorFactory.getAllReportGenerators();
        Arrays.asList(reportGenerators).stream().forEach(report -> report.generate(instructions));
    }
}
