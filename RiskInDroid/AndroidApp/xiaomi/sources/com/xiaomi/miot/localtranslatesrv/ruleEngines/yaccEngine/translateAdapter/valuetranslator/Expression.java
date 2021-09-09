package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserPhase.Parser;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserTree.ParserExecuteContextToTree;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.Expr;
import java.util.HashMap;
import org.json.JSONArray;

public class Expression extends ValueProcessor {
    public void Translate(InputTranslateSource inputTranslateSource, OutputTranslateTarget outputTranslateTarget, TranslateMeta translateMeta) {
        Object obj;
        Object srcValue = inputTranslateSource.getSrcValue();
        HashMap hashMap = new HashMap();
        hashMap.put("srcValue", srcValue);
        if (inputTranslateSource.getTargetKey() != null && translateMeta.getConfig().getTargetKey() == null) {
            hashMap.put("targetKey", inputTranslateSource.getTargetKey());
        }
        HashMap hashMap2 = new HashMap();
        Class<?> cls = new ExpressionFuncs().getClass();
        try {
            hashMap2.put("printf", cls.getDeclaredMethod("printf", Object[].class));
            hashMap2.put("subStr", cls.getDeclaredMethod("subStr", Object[].class));
            hashMap2.put("parseInt", cls.getDeclaredMethod("parseInt", Object[].class));
            hashMap2.put("reverseBytes", cls.getDeclaredMethod("reverseBytes", Object[].class));
            hashMap2.put("max", cls.getDeclaredMethod("max", Object[].class));
            try {
                if (!translateMeta.getConfig().getTargetValueTranslateExpression().equals("[]")) {
                    Expr parsedExpression = getParsedExpression(translateMeta);
                    ParserExecuteContextToTree parserExecuteContextToTree = new ParserExecuteContextToTree();
                    parserExecuteContextToTree.newExecuteContext(hashMap, hashMap2, null);
                    obj = parserExecuteContextToTree.evaluateExpressionWithContext(null, parsedExpression);
                } else {
                    obj = new JSONArray(translateMeta.getConfig().getTargetValueTranslateExpression());
                }
                if (obj == null) {
                    System.out.println("targetValue is null ! ");
                } else {
                    outputTranslateTarget.setTargetValue(obj);
                }
            } catch (Exception unused) {
                System.out.println("Parse the execute tree failed ! ");
            }
        } catch (Exception unused2) {
            System.out.println("get the reflect method object field ! ");
        }
    }

    private Expr getParsedExpression(TranslateMeta translateMeta) {
        Expr expr;
        Object parsedExpression = translateMeta.getMetaData().getParsedExpression();
        if (parsedExpression != null && (parsedExpression instanceof Expr) && (expr = (Expr) parsedExpression) != null) {
            return expr;
        }
        Parser parser = new Parser();
        parser.setCodeString(translateMeta.getConfig().getTargetValueTranslateExpression());
        try {
            Expr expr2 = parser.executeParser().getExprs()[0];
            translateMeta.getMetaData().setParsedExpression(expr2);
            return expr2;
        } catch (Exception unused) {
            System.out.println("The expression parse failed ! ");
            return null;
        }
    }
}
