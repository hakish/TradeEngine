package com.xyz.trade.engine;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.process.InstructionProcessor;
import com.xyz.trade.engine.process.CSVInstructionFileReader;
import com.xyz.trade.engine.report.EntityRankingsForIncomingReportGenerator;
import com.xyz.trade.engine.report.EntityRankingsForOutGoingReportGenerator;
import com.xyz.trade.engine.report.SettledAmntIncomingReportGenerator;
import com.xyz.trade.engine.report.SettledAmntOutGoingReportGenerator;

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
        //3.1 Report - Amount in USD settled incoming everyday
        SettledAmntIncomingReportGenerator smir = new SettledAmntIncomingReportGenerator();
        smir.generate(instructions);

        //3.2 Report - Amount in USD settled outgoing everyday
        SettledAmntOutGoingReportGenerator smor = new SettledAmntOutGoingReportGenerator();
        smor.generate(instructions);

        //3.3 Report - Entity Rankings based on Incoming Amount
        EntityRankingsForIncomingReportGenerator ier = new EntityRankingsForIncomingReportGenerator();
        ier.generate(instructions);

        //3.4 Report - Entity Rankings based on Outgoing Amount
        EntityRankingsForOutGoingReportGenerator oer = new EntityRankingsForOutGoingReportGenerator();
        oer.generate(instructions);
    }
}
