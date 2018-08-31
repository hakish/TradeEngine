package com.xyz.trade.engine.process;

import com.xyz.trade.engine.exception.TradeEngineException;
import com.xyz.trade.engine.model.Instruction;
import com.xyz.trade.engine.util.TradeUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.xyz.trade.engine.util.TEConstants.COMMA;
import static com.xyz.trade.engine.util.TEConstants.SAMPLE_CSV_PATH;

/**
 * This class reads the instructions file in CSV format from
 * a path does some basic checks and returns a list
 * of Instruction objects for further processing.
 */
public class CSVInstructionFileReader implements IFileReader {

    @Override
    public List<Instruction> read() throws TradeEngineException {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(new File(SAMPLE_CSV_PATH)));
            List<String> lineList = bfr.lines().filter(TradeUtil::isNotNullEmpty).collect(Collectors.toList());
            if (null != lineList && lineList.size() > 0) {
                List<Instruction> instructions = new ArrayList<>();
                if (validateHeader(lineList.get(0))) {
                    lineList.remove(0);
                    instructions = lineList.stream()
                            .map(instr -> new Instruction(instr.split(COMMA)))
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

    /**
     * Validate the header columns
     * @param s
     * @return
     */
    private boolean validateHeader(String s) {
        //returning true for now.
        return true;
    }
}
