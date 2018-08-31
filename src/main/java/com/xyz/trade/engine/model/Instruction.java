package com.xyz.trade.engine.model;

import static com.xyz.trade.engine.util.TEConstants.*;
import com.xyz.trade.engine.util.TEUtil;


import java.time.LocalDate;

/**
 * This model class represents an instruction sent by the client to the Bank for execution.
 */
public class Instruction {

    public Instruction() {

    }

    public Instruction(String[] fields) {


    }

    private String entity;
    private BUYSELL buySell;
    private double agreedFx;
    private String currency;
    private String instructionDate;
    private String settlementDate;
    private int units;
    private double pricePerUnit;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public BUYSELL getBuySell() {
        return buySell;
    }

    public void setBuySell(BUYSELL buySell) {
        this.buySell = buySell;
    }

    public double getAgreedFx() {
        return agreedFx;
    }

    public void setAgreedFx(double agreedFx) {
        this.agreedFx = agreedFx;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getInstructionDate() {
        return TEUtil.getDate(instructionDate, TEDATEFORMAT);
    }

    public void setInstructionDate(String instructionDate) {
        this.instructionDate = instructionDate;
    }

    public LocalDate getSettlementDate() {
        return TEUtil.getDate(settlementDate, TEDATEFORMAT);
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
