package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator;

import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.DataFormatUtils;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.ResultPair;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.lockutils.LockUtils;
import java.io.PrintStream;

public class ExpressionFuncs {
    public Object printf(Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            System.out.println("call printf with wrong number of arguments");
            return "";
        }
        if (!DataFormatUtils.tryString(objArr[0]).getState().booleanValue()) {
            System.out.println(objArr[0] + " cannot convert to string in printf");
            return "";
        }
        for (Object obj : objArr) {
            System.out.print(((String) obj) + " ");
        }
        return null;
    }

    public Object subStr(Object[] objArr) {
        if (objArr == null || objArr.length != 3) {
            System.out.println("call SubStr with wrong number of arguments");
            return "";
        }
        ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(objArr[0]);
        if (!tryString.getState().booleanValue()) {
            PrintStream printStream = System.out;
            printStream.println(objArr[0] + "cannot convert to string in subStr");
            return "";
        }
        String statement = tryString.getStatement();
        ResultPair<Float, Boolean> tryNumber = DataFormatUtils.tryNumber(objArr[1]);
        if (!tryNumber.getState().booleanValue()) {
            PrintStream printStream2 = System.out;
            printStream2.println(objArr[1] + "cannot convert to string in subStr");
            return "";
        }
        float floatValue = tryNumber.getStatement().floatValue();
        ResultPair<Float, Boolean> tryNumber2 = DataFormatUtils.tryNumber(objArr[2]);
        if (!tryNumber2.getState().booleanValue()) {
            PrintStream printStream3 = System.out;
            printStream3.println(objArr[2] + "cannot convert to string in subStr");
            return "";
        }
        float floatValue2 = tryNumber2.getStatement().floatValue();
        if (floatValue < 0.0f || floatValue > ((float) statement.length()) || floatValue > floatValue2 || floatValue2 > ((float) statement.length())) {
            PrintStream printStream4 = System.out;
            printStream4.println("invalid arguments in subStr, str=" + statement + "\"start=" + floatValue + ", end=" + floatValue2 + ". ");
            return "";
        }
        int i = (int) floatValue;
        int i2 = (int) floatValue2;
        if (((float) i) == floatValue && ((float) i2) == floatValue2) {
            return statement.substring(i, i2);
        }
        System.out.println("The substr index is not a int number ! ");
        return "";
    }

    public Object parseInt(Object[] objArr) {
        if (objArr == null || objArr.length != 3) {
            System.out.println("call SubStr with wrong number of arguments");
            return 0;
        }
        ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(objArr[0]);
        if (!tryString.getState().booleanValue()) {
            PrintStream printStream = System.out;
            printStream.println(objArr[0] + "cannot convert to string in parseInt");
            return 0;
        }
        String statement = tryString.getStatement();
        ResultPair<String, Boolean> tryString2 = DataFormatUtils.tryString(objArr[1]);
        if (!tryString2.getState().booleanValue()) {
            PrintStream printStream2 = System.out;
            printStream2.println(objArr[1] + "cannot convert to int in parseInt");
            return 0;
        }
        int parseInt = Integer.parseInt(tryString2.getStatement(), 10);
        ResultPair<String, Boolean> tryString3 = DataFormatUtils.tryString(objArr[2]);
        if (!tryString3.getState().booleanValue()) {
            PrintStream printStream3 = System.out;
            printStream3.println(objArr[2] + "cannot convert to int in parseInt");
            return 0;
        }
        int parseInt2 = Integer.parseInt(tryString3.getStatement(), 10);
        long parseLong = Long.parseLong(statement, parseInt);
        if (parseInt2 == 8) {
            return Byte.valueOf(Byte.parseByte(String.valueOf(parseLong)));
        }
        if (parseInt2 == 16) {
            return Short.valueOf(Short.parseShort(String.valueOf(parseLong)));
        }
        if (parseInt2 == 32) {
            return Integer.valueOf(Integer.parseInt(String.valueOf(parseLong)));
        }
        if (parseInt2 == 64) {
            return Long.valueOf(parseLong);
        }
        System.out.println("invalid bit size in parseInt");
        return 0;
    }

    public Object reverseBytes(Object[] objArr) {
        if (objArr.length <= 0) {
            System.out.println("call reverseBytes with wrong number of arguments");
            return "";
        }
        ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(objArr[2]);
        if (!tryString.getState().booleanValue()) {
            PrintStream printStream = System.out;
            printStream.println(objArr[0] + " cannot convert to string in reverseBytes");
            return 0;
        }
        String statement = tryString.getStatement();
        if ((statement.length() & 1) == 0) {
            return LockUtils.RevertBytes(statement);
        }
        PrintStream printStream2 = System.out;
        printStream2.println(statement + " invalid length in reverseBytes");
        return 0;
    }

    public Object max(Object[] objArr) {
        if (objArr.length <= 0) {
            System.out.println("call max with wrong number of arguments");
            return "";
        }
        ResultPair<Float, Boolean> tryNumber = DataFormatUtils.tryNumber(objArr[0]);
        if (!tryNumber.getState().booleanValue()) {
            PrintStream printStream = System.out;
            printStream.println(objArr[0] + " cannot convert to float64 in max index 0");
            return 0;
        }
        float floatValue = tryNumber.getStatement().floatValue();
        for (int i = 1; i < objArr.length; i++) {
            ResultPair<Float, Boolean> tryNumber2 = DataFormatUtils.tryNumber(objArr[i]);
            if (!tryNumber2.getState().booleanValue()) {
                PrintStream printStream2 = System.out;
                printStream2.println(objArr[i] + " cannot convert to float64 in max index " + i);
                return 0;
            }
            if (floatValue < tryNumber2.getStatement().floatValue()) {
                floatValue = tryNumber2.getStatement().floatValue();
            }
        }
        return Float.valueOf(floatValue);
    }
}
