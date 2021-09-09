package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.core.ruleBasedTranslator;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserPhase.Parser;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserTree.ParserExecuteContextToTree;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.Expr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valueadaptor.ValueAdaptor;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator.ExpressionFuncs;
import java.util.HashMap;

public class yaccEngine implements ruleBasedTranslator {
    private ValueAdaptor valueAdaptor = new ValueAdaptor();

    public OutputTranslateTarget Translate(InputTranslateSource inputTranslateSource, TranslateMeta translateMeta) throws Exception {
        OutputTranslateTarget outputTranslateTarget = new OutputTranslateTarget();
        if (inputTranslateSource != null) {
            if ((inputTranslateSource.getTargetKey() == null || inputTranslateSource.getTargetKey().equals("")) && translateMeta.getConfig().getTargetKey() == null) {
                if (translateMeta.getConfig().getSrcValueTranslateExpression() != null) {
                    String targetKeyBySrcValueExpression = getTargetKeyBySrcValueExpression(inputTranslateSource.getSrcValue(), translateMeta.getConfig().getSrcValueTranslateExpression());
                    if (targetKeyBySrcValueExpression != null) {
                        inputTranslateSource.setTargetKey(targetKeyBySrcValueExpression);
                    } else {
                        throw new Exception("expressionSrc targetKey should not be empty");
                    }
                } else {
                    throw new Exception("targetKey should not be empty");
                }
            }
            if (translateMeta.getConfig().getTargetKey() == null || inputTranslateSource.getTargetKey() == null || translateMeta.getConfig().getTargetKey().equals(inputTranslateSource.getTargetKey())) {
                if (translateMeta.getConfig().getSrcType() == 1 && translateMeta.getConfig().getTargetType() == 0) {
                    profileToSpecTranslate(inputTranslateSource, outputTranslateTarget, translateMeta);
                } else if (translateMeta.getConfig().getSrcType() == 0 && translateMeta.getConfig().getTargetType() == 1) {
                    specToProfileTranslate(inputTranslateSource, outputTranslateTarget, translateMeta);
                }
                if (translateMeta.getConfig().getTargetKey() == null && inputTranslateSource.getTargetKey() != null && outputTranslateTarget.getTargetKey() == null) {
                    outputTranslateTarget.setTargetKey(inputTranslateSource.getTargetKey());
                }
                if (!(translateMeta.getConfig().getSetMethodExpression() == null || inputTranslateSource.getSrcValue() == null)) {
                    outputTranslateTarget.setAdditionalMethod(getSetMethodBySetMethodExpression(inputTranslateSource.getSrcValue(), translateMeta.getConfig().getSetMethodExpression()));
                }
                return outputTranslateTarget;
            }
            throw new Exception("targetKey is not correct ");
        }
        throw new Exception("invalid inputSource !");
    }

    private String getTargetKeyBySrcValueExpression(Object obj, String str) throws Exception {
        if (obj != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Parser parser = new Parser();
            ParserExecuteContextToTree parserExecuteContextToTree = new ParserExecuteContextToTree();
            hashMap2.put("srcValue", obj);
            try {
                hashMap.put("subStr", new ExpressionFuncs().getClass().getDeclaredMethod("subStr", Object[].class));
                try {
                    parser.setCodeString(str);
                    Expr expr = parser.executeParser().getExprs()[0];
                    parserExecuteContextToTree.newExecuteContext(hashMap2, hashMap, null);
                    Object evaluateExpressionWithContext = parserExecuteContextToTree.evaluateExpressionWithContext(null, expr);
                    if (evaluateExpressionWithContext != null) {
                        return String.valueOf(evaluateExpressionWithContext);
                    }
                    throw new Exception("targetKey is null ! ");
                } catch (Exception unused) {
                    System.out.println("Parse the srcvalue expression --> execute tree failed ! ");
                    return null;
                }
            } catch (Exception unused2) {
                System.out.println("get the reflect method object field ! ");
                return null;
            }
        } else {
            throw new Exception("srcValue is null, forbidden ！");
        }
    }

    private void profileToSpecTranslate(InputTranslateSource inputTranslateSource, OutputTranslateTarget outputTranslateTarget, TranslateMeta translateMeta) throws Exception {
        this.valueAdaptor.Translate(inputTranslateSource, outputTranslateTarget, translateMeta);
    }

    private void specToProfileTranslate(InputTranslateSource inputTranslateSource, OutputTranslateTarget outputTranslateTarget, TranslateMeta translateMeta) throws Exception {
        if (!(translateMeta == null || translateMeta.getMetaData() == null || translateMeta.getMetaData().getAdditionalGetMethod() == null)) {
            outputTranslateTarget.setMetaData(translateMeta.getMetaData());
        }
        this.valueAdaptor.Translate(inputTranslateSource, outputTranslateTarget, translateMeta);
    }

    private String getSetMethodBySetMethodExpression(Object obj, String str) throws Exception {
        if (obj != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Parser parser = new Parser();
            ParserExecuteContextToTree parserExecuteContextToTree = new ParserExecuteContextToTree();
            hashMap2.put("srcValue", obj);
            try {
                parser.setCodeString(str);
                Expr expr = parser.executeParser().getExprs()[0];
                parserExecuteContextToTree.newExecuteContext(hashMap2, hashMap, null);
                Object evaluateExpressionWithContext = parserExecuteContextToTree.evaluateExpressionWithContext(null, expr);
                if (evaluateExpressionWithContext != null) {
                    return String.valueOf(evaluateExpressionWithContext);
                }
                throw new Exception("targetKey is null ! ");
            } catch (Exception unused) {
                throw new Exception("Parse the srcvalue expression --> execute tree failed ! ");
            }
        } else {
            throw new Exception("srcValue is null, forbidden ！");
        }
    }
}
