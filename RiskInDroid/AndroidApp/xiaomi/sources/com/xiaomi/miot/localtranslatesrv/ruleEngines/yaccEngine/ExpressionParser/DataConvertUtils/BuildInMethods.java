package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils;

import java.io.PrintStream;

public class BuildInMethods {
    public Object toBuildInString(Object[] objArr) throws Throwable {
        if (objArr == null || objArr.length == 0) {
            throw new Throwable("Call toString wrong, no arguments! ");
        }
        ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(objArr[0]);
        if (tryString.getState().booleanValue()) {
            return tryString.getStatement();
        }
        PrintStream printStream = System.out;
        printStream.println(objArr[0] + " is not in String format ! ");
        return "";
    }

    public Object toNumber(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            System.out.println("Call toNumber wrong, no arguments! ");
            return null;
        }
        ResultPair<Float, Boolean> tryNumber = DataFormatUtils.tryNumber(objArr[0]);
        if (tryNumber.getState().booleanValue()) {
            return tryNumber.getStatement();
        }
        PrintStream printStream = System.out;
        printStream.println(objArr[0] + " is not in Float/number format ! ");
        return Float.valueOf(Float.NaN);
    }

    public Object isNaN(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            System.out.println("Call isNaN wrong, no arguments ! ");
            return Boolean.FALSE;
        }
        ResultPair<Float, Boolean> tryNumber = DataFormatUtils.tryNumber(objArr[0]);
        if (tryNumber != null) {
            return Boolean.valueOf(Float.isNaN(tryNumber.getStatement().floatValue()));
        }
        return Boolean.TRUE;
    }

    public Object toBool(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            System.out.println("Call toBool wrong, no arguments ! ");
            return Boolean.FALSE;
        }
        ResultPair<Boolean, Boolean> tryBool = DataFormatUtils.tryBool(objArr[0]);
        if (tryBool.getState().booleanValue()) {
            return tryBool.getStatement();
        }
        return Boolean.FALSE;
    }

    public Object inArray(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            System.out.println("Call inArray failed, wrong number of argument");
            return Boolean.FALSE;
        }
        if (!(objArr[0] instanceof Object[])) {
            System.out.println("The first param in array is must be array format !");
            return Boolean.FALSE;
        }
        ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(objArr[1]);
        if (!tryString.getState().booleanValue()) {
            System.out.println("cannot convert to string in inArray");
            return Boolean.FALSE;
        }
        for (Object tryString2 : (Object[]) objArr[0]) {
            ResultPair<String, Boolean> tryString3 = DataFormatUtils.tryString(tryString2);
            if (!tryString3.getState().booleanValue()) {
                return Boolean.FALSE;
            }
            if (tryString.getStatement().equals(tryString3.getStatement())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public Object toInt(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            System.out.println("Call toBool wrong, no arguments ! ");
            return Boolean.FALSE;
        }
        ResultPair<Float, Boolean> tryNumber = DataFormatUtils.tryNumber(objArr[0]);
        if (tryNumber.getState().booleanValue()) {
            return Integer.valueOf(tryNumber.getStatement().intValue());
        }
        return Boolean.FALSE;
    }
}
