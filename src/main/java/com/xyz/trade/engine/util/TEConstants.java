package com.xyz.trade.engine.util;

public class TEConstants {

    public static String TEDATEFORMAT = "dd MMM yyyy";

    public static String SAMPLE_CSV_PATH = "./src/main/resources/sample/instructions.csv";

    public static final String COMMA = ",";

    public enum BUYSELL {
        B, S;
    }
    public static String INCOMING = "Incoming";
    public static String OUTGOING = "Outgoing";
    public static final String[] MIDDLEEASTERNCURRENCIES = new String[]{"AED", "SAR"};
}
