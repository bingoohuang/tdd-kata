package com.github.bingoohuang.tddbj;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicNumberToRoman {
    static Map<Integer, String> mapping =
            new LinkedHashMap<Integer, String>() {{
                put(1000, "M");
                put(900, "DM");
                put(500, "D");
                put(400, "CD");
                put(100, "C");
                put(90, "XC");
                put(50, "L");
                put(40, "XL");
                put(10, "X");
                put(9, "IX");
                put(5, "V");
                put(4, "IV");
                put(1, "I");
            }};

    public static String convert(int arabicNumber) {
        int remain = arabicNumber;
        StringBuilder romanNumber = new StringBuilder();

        for (Map.Entry<Integer, String> entry : mapping.entrySet()) {
            int boundary = entry.getKey();
            String symbol = entry.getValue();
            remain = subConvert(remain, romanNumber, boundary, symbol);
        }

        return romanNumber.toString();
    }

    private static int subConvert(int remain, StringBuilder romanNumber,
                                  int boundary, String symbol) {
        while (remain >= boundary) {
            romanNumber.append(symbol);
            remain -= boundary;
        }

        return remain;
    }
}
