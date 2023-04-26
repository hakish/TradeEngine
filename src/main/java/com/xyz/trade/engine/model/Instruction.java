package com.xyz.trade.engine.model;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.xyz.trade.engine.util.TEConstants.BUYSELL;
import static com.xyz.trade.engine.util.TEConstants.TEDATEFORMAT;

/**
 * This model class represents an instruction sent by the client to the Bank for execution.
 */
@Getter
public class Instruction {

    public Instruction() {

    }

    public Instruction(String[] fields) {
        this.entity = fields[0];
        this.buySell = BUYSELL.valueOf(fields[1].trim());
        this.agreedFx = Double.parseDouble(fields[2].trim());
        this.currency = fields[3].trim();
        this.instructionDate = fields[4].replace("'", "").trim();
        this.settlementDate = fields[5].replace("'", "").trim();
        this.units = Integer.parseInt(fields[6].trim());
        this.pricePerUnit = Double.parseDouble(fields[7].trim());
        this.tradeAmntInUSD = agreedFx * pricePerUnit * units;
    }

    private String entity;
    private BUYSELL buySell;
    private double agreedFx;
    private String currency;
    private String instructionDate;
    private String settlementDate;
    private int units;
    private double pricePerUnit;
    private double tradeAmntInUSD;


    public LocalDate getInstructionDate() {
        return LocalDate.parse(instructionDate, DateTimeFormatter.ofPattern(TEDATEFORMAT));
    }

    public LocalDate getSettlementDate() {
        return LocalDate.parse(instructionDate, DateTimeFormatter.ofPattern(TEDATEFORMAT));
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public double getTradeAmntInUSD() {
        return tradeAmntInUSD;
    }

}