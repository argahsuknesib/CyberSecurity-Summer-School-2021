package com.mobikwik.sdk.lib.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonUtils {
    public static Double performArithmeticCalculations(Double d, Double d2, int i) {
        return performArithmeticCalculations(String.valueOf(d), String.valueOf(d2), i);
    }

    public static Double performArithmeticCalculations(Double d, Double d2, int i, RoundingMode roundingMode) {
        return performArithmeticCalculations(String.valueOf(d), String.valueOf(d2), i, roundingMode);
    }

    public static Double performArithmeticCalculations(String str, String str2, int i) {
        BigDecimal bigDecimal = new BigDecimal(str);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        return Double.valueOf((i != 1 ? i != 2 ? i != 3 ? null : bigDecimal.multiply(bigDecimal2) : bigDecimal.subtract(bigDecimal2) : bigDecimal.add(bigDecimal2)).doubleValue());
    }

    public static Double performArithmeticCalculations(String str, String str2, int i, RoundingMode roundingMode) {
        return roundDouble(performArithmeticCalculations(str, str2, i), roundingMode);
    }

    public static Double roundDouble(Double d) {
        return roundDouble(d, RoundingMode.UP);
    }

    public static Double roundDouble(Double d, RoundingMode roundingMode) {
        return (String.valueOf(d).split("\\.").length != 2 || String.valueOf(d).split("\\.")[1].length() <= 2) ? d : Double.valueOf(new BigDecimal(d.doubleValue()).setScale(2, roundingMode).doubleValue());
    }
}
