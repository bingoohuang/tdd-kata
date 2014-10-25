package com.github.bingoohuang.tddbj;

public class BaseConverter {
    static char[] SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String convert(int decimal, int base) {
        if (base < 2 || base > SYMBOLS.length) {
            throw new RuntimeException(base + " is not supported");
        }

        StringBuilder converted = new StringBuilder();

        int remain = decimal;
        while (remain >= base) {
            int mode = remain % base;
            converted.insert(0, SYMBOLS[mode]);
            remain = remain / base;
        }

        converted.insert(0, SYMBOLS[remain]);

        return converted.toString();
    }
}
