package com.xyz.trade.engine.process;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TEUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstructionReader implements IFileReader {

    @Override
    public List<Instruction> read() throws TradeEngineException {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(new File("sample/instructions.csv")));
            List<String> lineList = bfr.lines().filter(TEUtil::isNullEmpty).collect(Collectors.toList());
            if (null != lineList && lineList.size() > 0) {
                List<Instruction> instructions = new ArrayList<>();
                if (validateHeader(lineList.get(0))) {
                    lineList.remove(0);
                    instructions = lineList.stream()
                            .map(instr -> new Instruction(instr.split(",")))
                            .collect(Collectors.toList());
                }
                return instructions;
            } else {
                throw new TradeEngineException("There are no instructions to process.");
            }
        } catch (IOException e) {
            throw new TradeEngineException(e);
        }
    }

    private boolean validateHeader(String s) {
        System.out.print("All headers are valid.");
        return true;
    }


    @Override
    public boolean read(String path) throws TradeEngineException {
        throw new TradeEngineException(new UnsupportedOperationException());
    }
}
