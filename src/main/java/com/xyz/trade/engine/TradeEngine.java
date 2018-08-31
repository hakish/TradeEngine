package com.xyz.trade.engine;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.process.InstructionProcessor;
import com.xyz.trade.engine.process.InstructionReader;
import com.xyz.trade.engine.report.AbstractReportGenerator;
import com.xyz.trade.engine.report.SettledAmntIncomingReportGenerator;
import com.xyz.trade.engine.report.SettledAmntOutGoingReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class TradeEngine {

    public void run() throws TradeEngineException {

        //1. Read the Instuctions from the file.
        InstructionReader reader = new InstructionReader();
        List<Instruction> instructions = reader.read();

        //2. Process the Instructions and apply the rules
        InstructionProcessor processor = new InstructionProcessor();
        processor.process(instructions);

        //3. Generate the reports.
        SettledAmntIncomingReportGenerator smir = new SettledAmntIncomingReportGenerator();
        smir.generate(instructions);

        SettledAmntOutGoingReportGenerator smor = new SettledAmntOutGoingReportGenerator();
        smor.generate(instructions);
    }
}
