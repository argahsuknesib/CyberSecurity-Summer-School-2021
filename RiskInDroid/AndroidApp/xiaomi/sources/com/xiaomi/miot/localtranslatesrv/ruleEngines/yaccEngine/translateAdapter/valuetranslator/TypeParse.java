package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.DataFormatUtils;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.ResultPair;

public class TypeParse extends ValueProcessor {
    public void Translate(InputTranslateSource inputTranslateSource, OutputTranslateTarget outputTranslateTarget, TranslateMeta translateMeta) {
        Object obj;
        Object srcValue = inputTranslateSource.getSrcValue();
        try {
            String targetValueTranslateExpression = translateMeta.getConfig().getTargetValueTranslateExpression();
            char c = 65535;
            switch (targetValueTranslateExpression.hashCode()) {
                case -1325958191:
                    if (targetValueTranslateExpression.equals("double")) {
                        c = 3;
                        break;
                    }
                    break;
                case -891985903:
                    if (targetValueTranslateExpression.equals("string")) {
                        c = 0;
                        break;
                    }
                    break;
                case 104431:
                    if (targetValueTranslateExpression.equals("int")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3029738:
                    if (targetValueTranslateExpression.equals("bool")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3327612:
                    if (targetValueTranslateExpression.equals("long")) {
                        c = 1;
                        break;
                    }
                    break;
                case 97526364:
                    if (targetValueTranslateExpression.equals("float")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(srcValue);
                if (tryString.getState().booleanValue()) {
                    obj = tryString.getStatement();
                } else {
                    throw new Exception("invalid type string");
                }
            } else if (c == 1) {
                ResultPair<Float, Boolean> tryNumber = DataFormatUtils.tryNumber(srcValue);
                if (tryNumber.getState().booleanValue()) {
                    long longValue = new Float(tryNumber.getStatement().floatValue()).longValue();
                    if (((float) longValue) == tryNumber.getStatement().floatValue()) {
                        obj = Long.valueOf(longValue);
                    } else {
                        throw new Exception("The substr index is not a int number ! ");
                    }
                } else {
                    throw new Exception("invalid type string");
                }
            } else if (c == 2) {
                ResultPair<Float, Boolean> tryNumber2 = DataFormatUtils.tryNumber(srcValue);
                if (tryNumber2.getState().booleanValue()) {
                    int intValue = new Float(tryNumber2.getStatement().floatValue()).intValue();
                    if (((float) intValue) == tryNumber2.getStatement().floatValue()) {
                        obj = Integer.valueOf(intValue);
                    } else {
                        throw new Exception("The substr index is not a int number ! ");
                    }
                } else {
                    throw new Exception("invalid type string");
                }
            } else if (c == 3 || c == 4) {
                ResultPair<Float, Boolean> tryNumber3 = DataFormatUtils.tryNumber(srcValue);
                if (tryNumber3.getState().booleanValue()) {
                    obj = tryNumber3.getStatement();
                } else {
                    throw new Exception("invalid type string");
                }
            } else if (c == 5) {
                ResultPair<Boolean, Boolean> tryBool = DataFormatUtils.tryBool(srcValue);
                if (tryBool.getState().booleanValue()) {
                    obj = tryBool.getStatement();
                } else {
                    throw new Exception("invalid type string");
                }
            } else {
                throw new Exception("unknown target value expression :".concat(String.valueOf(srcValue)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj = null;
        }
        outputTranslateTarget.setTargetValue(obj);
    }
}
