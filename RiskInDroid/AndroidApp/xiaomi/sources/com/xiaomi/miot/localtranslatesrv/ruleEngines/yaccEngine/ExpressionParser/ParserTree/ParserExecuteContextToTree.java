package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserTree;

import com.google.android.exoplayer2.C;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.BuildInMethods;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.DataFormatUtils;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.ResultPair;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.ArithmeticOpExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.ArrayConstructExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.AttrGetExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.Expr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.FuncCallExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.IdentExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.IfExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.LogicalExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.MapConstructExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.MapItemExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.NumberExpr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.StringExpr;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ParserExecuteContextToTree {
    private static HashMap<String, Object> buildInMethod = new HashMap<>();
    private static HashMap<String, Object> definedIdentFuncs = new HashMap<>();
    private BuildInMethods buildInMethods;
    private ExecuteContext executeContext;

    public ParserExecuteContextToTree() {
        this.buildInMethods = null;
        this.executeContext = new ExecuteContext();
        this.buildInMethods = new BuildInMethods();
        if (buildInMethod != null) {
            init_buildInMethodList();
        } else {
            System.out.println("The object BuildInMethod construct failed ! ");
        }
    }

    private void init_buildInMethodList() {
        Class<?> cls = this.buildInMethods.getClass();
        try {
            buildInMethod.put("toNumber", cls.getDeclaredMethod("toNumber", Object[].class));
            buildInMethod.put("toString", cls.getDeclaredMethod("toBuildInString", Object[].class));
            buildInMethod.put("toBool", cls.getDeclaredMethod("toBool", Object[].class));
            buildInMethod.put("isNaN", cls.getDeclaredMethod("isNaN", Object[].class));
            buildInMethod.put("inArray", cls.getDeclaredMethod("inArray", Object[].class));
            buildInMethod.put("toInt", cls.getDeclaredMethod("toInt", Object[].class));
        } catch (Exception unused) {
            System.out.println("The buildIn method list init failed ! ");
        }
    }

    public ExecuteContext newExecuteContext(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, HashMap<String, Object> hashMap3) {
        if (buildInMethod == null) {
            System.out.println("The buildIn method list is empty ! ");
            return new ExecuteContext();
        }
        if (!(hashMap3 == null || hashMap3.size() == 0)) {
            for (Map.Entry next : hashMap3.entrySet()) {
                buildInMethod.put((String) next.getKey(), next.getValue());
            }
        }
        if (!(hashMap2 == null || hashMap2.size() == 0)) {
            for (Map.Entry next2 : hashMap2.entrySet()) {
                definedIdentFuncs.put((String) next2.getKey(), next2.getValue());
            }
        }
        this.executeContext.setDefinedIdent(hashMap);
        this.executeContext.setDefinedFunc(buildInMethod);
        this.executeContext.setDefinedIdentFunc(definedIdentFuncs);
        return this.executeContext;
    }

    public Object evaluateExpression(Expr expr) throws Exception {
        return evaluateExpressionWithContext(null, expr);
    }

    public Object evaluateExpressionWithContext(Object obj, Expr expr) throws Exception {
        if (expr == null) {
            System.out.println("The arg expr is empty ! ");
            return null;
        } else if (this.executeContext.getDefinedFunc() == null && this.executeContext.getDefinedIdent() == null && this.executeContext.getDefinedIdentFunc() == null) {
            System.out.println("The executeContext is empty ! ");
            return null;
        } else {
            String type = getType(expr);
            char c = 65535;
            switch (type.hashCode()) {
                case -2108665646:
                    if (type.equals("IfExpr")) {
                        c = 7;
                        break;
                    }
                    break;
                case -2092743298:
                    if (type.equals("LogicalExpr")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1273289504:
                    if (type.equals("ArithmeticOpExpr")) {
                        c = 6;
                        break;
                    }
                    break;
                case -584802125:
                    if (type.equals("ArrayConstructExpr")) {
                        c = 11;
                        break;
                    }
                    break;
                case 35069336:
                    if (type.equals("FalseExpr")) {
                        c = 3;
                        break;
                    }
                    break;
                case 419953094:
                    if (type.equals("StringExpr")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1331210010:
                    if (type.equals("AttrGetExpr")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1600854270:
                    if (type.equals("NumberExpr")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1856512119:
                    if (type.equals("FuncCallExpr")) {
                        c = 9;
                        break;
                    }
                    break;
                case 1908445379:
                    if (type.equals("TrueExpr")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2089252837:
                    if (type.equals("IdentExpr")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2106864272:
                    if (type.equals("MapConstructExpr")) {
                        c = 10;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return ((StringExpr) expr).getValue();
                case 1:
                    return ((NumberExpr) expr).getValue();
                case 2:
                    return Boolean.TRUE;
                case 3:
                    return Boolean.FALSE;
                case 4:
                    return evalIdentityExpr(obj, (IdentExpr) expr);
                case 5:
                    return evalLogicalExpr(obj, (LogicalExpr) expr);
                case 6:
                    return evalArithemticExpr(obj, (ArithmeticOpExpr) expr);
                case 7:
                    return evalIfExpr(obj, (IfExpr) expr);
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return evalAttrGetExpr(obj, (AttrGetExpr) expr);
                case 9:
                    return evalFuncCallExpr(obj, (FuncCallExpr) expr);
                case 10:
                    return evalMapConstructExpr(obj, (MapConstructExpr) expr);
                case 11:
                    return evalArrayConstructExpr(obj, (ArrayConstructExpr) expr);
                default:
                    throw new Exception("Unknown input expression ");
            }
        }
    }

    private Object evalArrayConstructExpr(Object obj, ArrayConstructExpr arrayConstructExpr) throws Exception {
        if (arrayConstructExpr == null) {
            System.out.println("The arg expr is empty ! ");
            return null;
        }
        Object[] objArr = new Object[arrayConstructExpr.getMember().length];
        for (int i = 0; i < arrayConstructExpr.getMember().length; i++) {
            Object evaluateExpressionWithContext = evaluateExpressionWithContext(obj, arrayConstructExpr.getMember()[i]);
            if (evaluateExpressionWithContext == null) {
                return null;
            }
            objArr[i] = evaluateExpressionWithContext;
        }
        return objArr;
    }

    private Object evalMapConstructExpr(Object obj, MapConstructExpr mapConstructExpr) throws Exception {
        Object evaluateExpressionWithContext;
        if (mapConstructExpr == null) {
            System.out.println("The arg expr is empty !");
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < mapConstructExpr.getMember().length; i++) {
            if (!(mapConstructExpr.getMember()[i] instanceof MapItemExpr)) {
                System.out.println("map expr with no map item expr, please check ! ");
                return null;
            }
            MapItemExpr mapItemExpr = (MapItemExpr) mapConstructExpr.getMember()[i];
            Object evaluateExpressionWithContext2 = evaluateExpressionWithContext(obj, mapItemExpr.getKey());
            if (evaluateExpressionWithContext2 == null || (evaluateExpressionWithContext = evaluateExpressionWithContext(obj, mapItemExpr.getVaule())) == null) {
                return null;
            }
            hashMap.put(evaluateExpressionWithContext2, evaluateExpressionWithContext);
        }
        return hashMap;
    }

    private Object evalFuncCallExpr(Object obj, FuncCallExpr funcCallExpr) throws Exception {
        Method method;
        if (funcCallExpr == null) {
            System.out.println("the arg expr is empty ! ");
            return null;
        } else if (this.executeContext.getDefinedFunc() == null) {
            System.out.println("function that you call is not founded ! ");
            return null;
        } else {
            if (this.executeContext.getDefinedFunc().containsKey(funcCallExpr.getFunc().getValue())) {
                method = (Method) this.executeContext.getDefinedFunc().get(funcCallExpr.getFunc().getValue());
            } else {
                method = this.executeContext.getDefinedIdentFunc().containsKey(funcCallExpr.getFunc().getValue()) ? (Method) this.executeContext.getDefinedIdentFunc().get(funcCallExpr.getFunc().getValue()) : null;
            }
            if (method == null) {
                PrintStream printStream = System.out;
                printStream.println("function:\t" + funcCallExpr.getFunc().getValue() + "\tcannot founded both in buildInMethod and IdentMethod! ");
                return null;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            if (method != null) {
                Object[] objArr = new Object[funcCallExpr.getArgs().length];
                for (int i = 0; i < funcCallExpr.getArgs().length; i++) {
                    Object evaluateExpressionWithContext = evaluateExpressionWithContext(obj, funcCallExpr.getArgs()[i]);
                    if (evaluateExpressionWithContext == null) {
                        System.out.println("The inputs args in funcCall was wrong ! ");
                        return null;
                    }
                    objArr[i] = evaluateExpressionWithContext;
                }
                try {
                    return method.invoke(declaringClass.newInstance(), objArr);
                } catch (Exception unused) {
                    System.out.println("Reflect the buildIn method was wrong ! ");
                }
            }
            System.out.println("Function not found and not called ! ");
            return null;
        }
    }

    private Object evalAttrGetExpr(Object obj, AttrGetExpr attrGetExpr) throws Exception {
        Object evaluateExpressionWithContext;
        Object obj2;
        if (attrGetExpr == null) {
            System.out.println("The arg expr is empty ! ");
        }
        Object evaluateExpressionWithContext2 = evaluateExpressionWithContext(obj, attrGetExpr.getObject());
        if (evaluateExpressionWithContext2 == null || (evaluateExpressionWithContext = evaluateExpressionWithContext(obj, attrGetExpr.getKey())) == null) {
            return null;
        }
        if (evaluateExpressionWithContext2.getClass().isArray() || (evaluateExpressionWithContext2 instanceof Map)) {
            if (evaluateExpressionWithContext2.getClass().isArray()) {
                ResultPair<Float, Boolean> tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                if (!tryNumber.getState().booleanValue()) {
                    return null;
                }
                int floatValue = (int) tryNumber.getStatement().floatValue();
                if (((float) floatValue) != tryNumber.getStatement().floatValue()) {
                    System.out.println("The Index number can not convert to int. Operation wrong ! ");
                    return null;
                } else if (floatValue >= 0 && floatValue < Array.getLength(evaluateExpressionWithContext2)) {
                    return Array.get(evaluateExpressionWithContext2, floatValue);
                } else {
                    if (this.executeContext.isAttrGetIgnoreEmpty()) {
                        return "";
                    }
                    System.out.println("The index out of range of array ! ");
                    return null;
                }
            } else if (evaluateExpressionWithContext2 instanceof Map) {
                Map map = (Map) evaluateExpressionWithContext2;
                Set keySet = map.keySet();
                Collection values = map.values();
                Iterator it = keySet.iterator();
                String type = it.hasNext() ? getType(it.next()) : null;
                Iterator it2 = values.iterator();
                String type2 = it2.hasNext() ? getType(it2.next()) : null;
                if (!type.equals("String") || !type.equals("Float")) {
                    if (type.equals("String") && type2.equals("String")) {
                        ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(evaluateExpressionWithContext);
                        if (!tryString.getState().booleanValue()) {
                            return null;
                        }
                        obj2 = tryString.getStatement();
                    } else if (!type.equals("Float") || !type2.equals("Float")) {
                        obj2 = null;
                    } else {
                        ResultPair<Float, Boolean> tryNumber2 = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                        if (!tryNumber2.getState().booleanValue()) {
                            return null;
                        }
                        obj2 = tryNumber2.getStatement();
                    }
                    Object obj3 = map.get(obj2);
                    if (obj3 != null) {
                        return obj3;
                    }
                    if (this.executeContext.isAttrGetIgnoreEmpty()) {
                        return "";
                    }
                    System.out.println("no in index (key) response to value in Map ");
                    return null;
                }
                System.out.println("map key must be String or Float(Integer/ Number)");
                return null;
            } else if (this.executeContext.isAttrGetIgnoreEmpty()) {
                return "";
            } else {
                System.out.println("object input is not array or map !");
                return null;
            }
        } else if (this.executeContext.isAttrGetIgnoreEmpty()) {
            return "";
        } else {
            System.out.println("Object is not map or array ! ");
            return null;
        }
    }

    private Object evalIfExpr(Object obj, IfExpr ifExpr) throws Exception {
        if (ifExpr == null) {
            System.out.println("The arg expr is empty ! ");
            return null;
        }
        Object evaluateExpressionWithContext = evaluateExpressionWithContext(obj, ifExpr.getCond());
        if (evaluateExpressionWithContext == null) {
            return null;
        }
        ResultPair<Boolean, Boolean> tryBool = DataFormatUtils.tryBool(evaluateExpressionWithContext);
        if (!tryBool.getState().booleanValue()) {
            System.out.println("Condition can not convert to boolean ! ");
            return null;
        } else if (tryBool.getStatement().booleanValue()) {
            return evaluateExpressionWithContext(obj, ifExpr.getThen());
        } else {
            if (ifExpr.getElse() != null) {
                return evaluateExpressionWithContext(obj, ifExpr.getElse());
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011e  */
    private Object evalArithemticExpr(Object obj, ArithmeticOpExpr arithmeticOpExpr) throws Exception {
        char c;
        ResultPair<Float, Boolean> tryNumber;
        char c2;
        Object obj2 = obj;
        if (arithmeticOpExpr == null) {
            System.out.println("The arg expr is empty ! ");
            return null;
        }
        Object evaluateExpressionWithContext = evaluateExpressionWithContext(obj2, arithmeticOpExpr.getLhs());
        if (evaluateExpressionWithContext == null) {
            return Boolean.FALSE;
        }
        Object evaluateExpressionWithContext2 = evaluateExpressionWithContext(obj2, arithmeticOpExpr.getRhs());
        if (evaluateExpressionWithContext2 == null) {
            return Boolean.FALSE;
        }
        String operator = arithmeticOpExpr.getOperator();
        int hashCode = operator.hashCode();
        if (hashCode != 37) {
            if (hashCode != 45) {
                if (hashCode != 47) {
                    if (hashCode != 42) {
                        if (hashCode == 43 && operator.equals("+")) {
                            c = 0;
                            if (c != 0) {
                                boolean z = evaluateExpressionWithContext2 instanceof String;
                                if ((evaluateExpressionWithContext instanceof String) || z) {
                                    ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(evaluateExpressionWithContext);
                                    if (!tryString.getState().booleanValue()) {
                                        System.out.println("left String convert failed when calculating ! ");
                                        return Boolean.FALSE;
                                    }
                                    ResultPair<String, Boolean> tryString2 = DataFormatUtils.tryString(evaluateExpressionWithContext2);
                                    if (!tryString2.getState().booleanValue()) {
                                        System.out.println("right String convert failed when calculating ! ");
                                        return Boolean.FALSE;
                                    }
                                    return tryString.getStatement() + tryString2.getStatement();
                                }
                            } else if (!(c == 1 || c == 2 || c == 3 || c == 4)) {
                                PrintStream printStream = System.out;
                                printStream.println("Invaild operator case " + arithmeticOpExpr.getOperator());
                                return null;
                            }
                            tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                            if (tryNumber.getState().booleanValue()) {
                                System.out.println("left number convert failed when calculating ! ");
                                return Boolean.FALSE;
                            }
                            ResultPair<Float, Boolean> tryNumber2 = DataFormatUtils.tryNumber(evaluateExpressionWithContext2);
                            if (!tryNumber2.getState().booleanValue()) {
                                System.out.println("right number convert failed when calculating ! ");
                                return Boolean.FALSE;
                            }
                            String operator2 = arithmeticOpExpr.getOperator();
                            int hashCode2 = operator2.hashCode();
                            if (hashCode2 != 37) {
                                if (hashCode2 != 45) {
                                    if (hashCode2 != 47) {
                                        if (hashCode2 != 42) {
                                            if (hashCode2 == 43 && operator2.equals("+")) {
                                                c2 = 0;
                                                if (c2 != 0) {
                                                    return Float.valueOf(tryNumber.getStatement().floatValue() + tryNumber2.getStatement().floatValue());
                                                }
                                                if (c2 == 1) {
                                                    return Float.valueOf(tryNumber.getStatement().floatValue() - tryNumber2.getStatement().floatValue());
                                                }
                                                if (c2 == 2) {
                                                    return Float.valueOf(tryNumber.getStatement().floatValue() * tryNumber2.getStatement().floatValue());
                                                }
                                                if (c2 != 3) {
                                                    if (c2 != 4) {
                                                        System.out.println("You should not reach this branch ! ");
                                                        return Float.valueOf(tryNumber.getStatement().floatValue() + tryNumber2.getStatement().floatValue());
                                                    }
                                                    int floatValue = (int) tryNumber.getStatement().floatValue();
                                                    int floatValue2 = (int) tryNumber2.getStatement().floatValue();
                                                    if (((float) floatValue) != tryNumber.getStatement().floatValue() || ((float) floatValue2) != tryNumber2.getStatement().floatValue()) {
                                                        System.out.println("The leftNumber or rightNumber can not convert to int. Operation wrong ! ");
                                                        return Boolean.FALSE;
                                                    } else if (tryNumber2.getStatement().floatValue() != 0.0f && floatValue2 != 0) {
                                                        return Float.valueOf((float) (floatValue % floatValue2));
                                                    } else {
                                                        System.out.println(" can not % (mod) with zero. Operation wrong ! ");
                                                        return Boolean.FALSE;
                                                    }
                                                } else if (tryNumber2.getStatement().floatValue() != 0.0f) {
                                                    return Float.valueOf(tryNumber.getStatement().floatValue() / tryNumber2.getStatement().floatValue());
                                                } else {
                                                    System.out.println("Left / right : left is divided by zero");
                                                    return null;
                                                }
                                            }
                                        } else if (operator2.equals("*")) {
                                            c2 = 2;
                                            if (c2 != 0) {
                                            }
                                        }
                                    } else if (operator2.equals("/")) {
                                        c2 = 3;
                                        if (c2 != 0) {
                                        }
                                    }
                                } else if (operator2.equals("-")) {
                                    c2 = 1;
                                    if (c2 != 0) {
                                    }
                                }
                            } else if (operator2.equals("%")) {
                                c2 = 4;
                                if (c2 != 0) {
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        }
                    } else if (operator.equals("*")) {
                        c = 2;
                        if (c != 0) {
                        }
                        tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                        if (tryNumber.getState().booleanValue()) {
                        }
                    }
                } else if (operator.equals("/")) {
                    c = 3;
                    if (c != 0) {
                    }
                    tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                    if (tryNumber.getState().booleanValue()) {
                    }
                }
            } else if (operator.equals("-")) {
                c = 1;
                if (c != 0) {
                }
                tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                if (tryNumber.getState().booleanValue()) {
                }
            }
        } else if (operator.equals("%")) {
            c = 4;
            if (c != 0) {
            }
            tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
            if (tryNumber.getState().booleanValue()) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
        tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
        if (tryNumber.getState().booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01d6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01a3  */
    private Object evalLogicalExpr(Object obj, LogicalExpr logicalExpr) throws Exception {
        char c;
        ResultPair<Float, Boolean> tryNumber;
        char c2;
        Object obj2 = obj;
        Object evaluateExpressionWithContext = evaluateExpressionWithContext(obj2, logicalExpr.getLhs());
        if (evaluateExpressionWithContext == null) {
            return Boolean.FALSE;
        }
        if (logicalExpr.getOprator().equals("&&") || logicalExpr.getOprator().equals("||")) {
            ResultPair<Boolean, Boolean> tryBool = DataFormatUtils.tryBool(evaluateExpressionWithContext);
            if (!tryBool.getState().booleanValue()) {
                System.out.println("left expr value was not found ! ");
                return Boolean.FALSE;
            } else if (logicalExpr.getOprator().equals("&&") && !tryBool.getStatement().booleanValue()) {
                return Boolean.FALSE;
            } else {
                if (logicalExpr.getOprator().equals("||") && tryBool.getStatement().booleanValue()) {
                    return Boolean.TRUE;
                }
                Object evaluateExpressionWithContext2 = evaluateExpressionWithContext(obj2, logicalExpr.getRhs());
                if (evaluateExpressionWithContext2 == null) {
                    return Boolean.FALSE;
                }
                ResultPair<Boolean, Boolean> tryBool2 = DataFormatUtils.tryBool(evaluateExpressionWithContext2);
                if (!tryBool2.getState().booleanValue()) {
                    return Boolean.FALSE;
                }
                if (logicalExpr.getOprator().equals("||")) {
                    return Boolean.valueOf(tryBool.getStatement().booleanValue() || tryBool2.getStatement().booleanValue());
                }
                return Boolean.valueOf(tryBool.getStatement().booleanValue() && tryBool2.getStatement().booleanValue());
            }
        } else {
            Object evaluateExpressionWithContext3 = evaluateExpressionWithContext(obj2, logicalExpr.getRhs());
            if (evaluateExpressionWithContext3 == null) {
                return Boolean.FALSE;
            }
            String oprator = logicalExpr.getOprator();
            int hashCode = oprator.hashCode();
            if (hashCode != 60) {
                if (hashCode != 62) {
                    if (hashCode != 1084) {
                        if (hashCode != 1921) {
                            if (hashCode != 1952) {
                                if (hashCode == 1983 && oprator.equals(">=")) {
                                    c = 4;
                                    if (c != 0 || c == 1) {
                                        boolean z = !logicalExpr.getOprator().equals("!=");
                                        boolean z2 = evaluateExpressionWithContext3 instanceof Number;
                                        if (!(evaluateExpressionWithContext instanceof Number) || z2) {
                                            tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                                            if (!tryNumber.getState().booleanValue()) {
                                                return Boolean.FALSE;
                                            }
                                            ResultPair<Float, Boolean> tryNumber2 = DataFormatUtils.tryNumber(evaluateExpressionWithContext3);
                                            if (!tryNumber2.getState().booleanValue()) {
                                                return Boolean.FALSE;
                                            }
                                            if (z) {
                                                return Boolean.valueOf(tryNumber.getStatement().floatValue() == tryNumber2.getStatement().floatValue());
                                            }
                                            return Boolean.valueOf(tryNumber.getStatement().floatValue() != tryNumber2.getStatement().floatValue());
                                        }
                                        boolean z3 = evaluateExpressionWithContext3 instanceof Boolean;
                                        if ((evaluateExpressionWithContext instanceof Boolean) || z3) {
                                            ResultPair<Boolean, Boolean> tryBool3 = DataFormatUtils.tryBool(evaluateExpressionWithContext);
                                            if (!tryBool3.getState().booleanValue()) {
                                                return Boolean.FALSE;
                                            }
                                            ResultPair<Boolean, Boolean> tryBool4 = DataFormatUtils.tryBool(evaluateExpressionWithContext3);
                                            if (!tryBool4.getState().booleanValue()) {
                                                return Boolean.FALSE;
                                            }
                                            if (z) {
                                                return Boolean.valueOf(tryBool4.getStatement() == tryBool3.getStatement());
                                            }
                                            return Boolean.valueOf(tryBool4.getStatement() != tryBool3.getStatement());
                                        }
                                        boolean z4 = evaluateExpressionWithContext3 instanceof String;
                                        if (!(evaluateExpressionWithContext instanceof String) || !z4) {
                                            System.out.println("logical expression with left or right side type was unknown ! ");
                                            return Boolean.FALSE;
                                        }
                                        ResultPair<String, Boolean> tryString = DataFormatUtils.tryString(evaluateExpressionWithContext);
                                        if (!tryString.getState().booleanValue()) {
                                            return Boolean.FALSE;
                                        }
                                        ResultPair<String, Boolean> tryString2 = DataFormatUtils.tryString(evaluateExpressionWithContext3);
                                        if (!tryString2.getState().booleanValue()) {
                                            return Boolean.FALSE;
                                        }
                                        if (z) {
                                            return Boolean.valueOf(tryString.getStatement().equals(tryString2.getStatement()));
                                        }
                                        return Boolean.valueOf(!tryString2.getStatement().equals(tryString.getStatement()));
                                    } else if (c == 2 || c == 3 || c == 4 || c == 5) {
                                        ResultPair<Float, Boolean> tryNumber3 = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                                        if (!tryNumber3.getState().booleanValue()) {
                                            System.out.println("left number convert failed when comparing ! ");
                                            return Boolean.FALSE;
                                        }
                                        ResultPair<Float, Boolean> tryNumber4 = DataFormatUtils.tryNumber(evaluateExpressionWithContext3);
                                        if (!tryNumber4.getState().booleanValue()) {
                                            System.out.println("right number convert failed when comparing ! ");
                                            return Boolean.FALSE;
                                        }
                                        String oprator2 = logicalExpr.getOprator();
                                        int hashCode2 = oprator2.hashCode();
                                        if (hashCode2 != 60) {
                                            if (hashCode2 != 62) {
                                                if (hashCode2 != 1921) {
                                                    if (hashCode2 == 1983 && oprator2.equals(">=")) {
                                                        c2 = 2;
                                                        if (c2 == 0) {
                                                            return Boolean.valueOf(tryNumber3.getStatement().floatValue() > tryNumber4.getStatement().floatValue());
                                                        } else if (c2 == 1) {
                                                            return Boolean.valueOf(tryNumber3.getStatement().floatValue() < tryNumber4.getStatement().floatValue());
                                                        } else if (c2 == 2) {
                                                            return Boolean.valueOf(tryNumber3.getStatement().floatValue() >= tryNumber4.getStatement().floatValue());
                                                        } else if (c2 != 3) {
                                                            System.out.println("You should not reach this branch ! ");
                                                            return null;
                                                        } else {
                                                            return Boolean.valueOf(tryNumber3.getStatement().floatValue() <= tryNumber4.getStatement().floatValue());
                                                        }
                                                    }
                                                } else if (oprator2.equals("<=")) {
                                                    c2 = 3;
                                                    if (c2 == 0) {
                                                    }
                                                }
                                            } else if (oprator2.equals(">")) {
                                                c2 = 0;
                                                if (c2 == 0) {
                                                }
                                            }
                                        } else if (oprator2.equals("<")) {
                                            c2 = 1;
                                            if (c2 == 0) {
                                            }
                                        }
                                        c2 = 65535;
                                        if (c2 == 0) {
                                        }
                                    } else {
                                        System.out.println("Invaild operator case " + logicalExpr.getOprator());
                                        return null;
                                    }
                                }
                            } else if (oprator.equals("==")) {
                                c = 0;
                                if (c != 0) {
                                }
                                boolean z5 = !logicalExpr.getOprator().equals("!=");
                                boolean z22 = evaluateExpressionWithContext3 instanceof Number;
                                if (!(evaluateExpressionWithContext instanceof Number)) {
                                }
                                tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                                if (!tryNumber.getState().booleanValue()) {
                                }
                            }
                        } else if (oprator.equals("<=")) {
                            c = 5;
                            if (c != 0) {
                            }
                            boolean z52 = !logicalExpr.getOprator().equals("!=");
                            boolean z222 = evaluateExpressionWithContext3 instanceof Number;
                            if (!(evaluateExpressionWithContext instanceof Number)) {
                            }
                            tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                            if (!tryNumber.getState().booleanValue()) {
                            }
                        }
                    } else if (oprator.equals("!=")) {
                        c = 1;
                        if (c != 0) {
                        }
                        boolean z522 = !logicalExpr.getOprator().equals("!=");
                        boolean z2222 = evaluateExpressionWithContext3 instanceof Number;
                        if (!(evaluateExpressionWithContext instanceof Number)) {
                        }
                        tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                        if (!tryNumber.getState().booleanValue()) {
                        }
                    }
                } else if (oprator.equals(">")) {
                    c = 2;
                    if (c != 0) {
                    }
                    boolean z5222 = !logicalExpr.getOprator().equals("!=");
                    boolean z22222 = evaluateExpressionWithContext3 instanceof Number;
                    if (!(evaluateExpressionWithContext instanceof Number)) {
                    }
                    tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                    if (!tryNumber.getState().booleanValue()) {
                    }
                }
            } else if (oprator.equals("<")) {
                c = 3;
                if (c != 0) {
                }
                boolean z52222 = !logicalExpr.getOprator().equals("!=");
                boolean z222222 = evaluateExpressionWithContext3 instanceof Number;
                if (!(evaluateExpressionWithContext instanceof Number)) {
                }
                tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
                if (!tryNumber.getState().booleanValue()) {
                }
            }
            c = 65535;
            if (c != 0) {
            }
            boolean z522222 = !logicalExpr.getOprator().equals("!=");
            boolean z2222222 = evaluateExpressionWithContext3 instanceof Number;
            if (!(evaluateExpressionWithContext instanceof Number)) {
            }
            tryNumber = DataFormatUtils.tryNumber(evaluateExpressionWithContext);
            if (!tryNumber.getState().booleanValue()) {
            }
        }
    }

    private Object evalIdentityExpr(Object obj, IdentExpr identExpr) {
        if (this.executeContext.getDefinedIdent() == null) {
            System.out.println("The value in executeContext.idents is empty ! ");
            return null;
        }
        Object obj2 = this.executeContext.getDefinedIdent().get(identExpr.getValue());
        if (obj2 != null) {
            return obj2;
        }
        if (this.executeContext.getDefinedIdentFunc() != null) {
            Method method = (Method) this.executeContext.getDefinedIdentFunc().get(identExpr.getValue());
            try {
                return method.invoke(method.getDeclaringClass().newInstance(), new Object[0]);
            } catch (Exception unused) {
                System.out.println("The definedIdentFunc call failed !");
            }
        }
        return null;
    }

    private static String getType(Object obj) {
        String name = obj.getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }
}
