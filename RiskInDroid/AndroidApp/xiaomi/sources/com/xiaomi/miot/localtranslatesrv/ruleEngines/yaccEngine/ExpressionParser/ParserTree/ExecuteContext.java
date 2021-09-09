package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserTree;

import java.util.Map;

public class ExecuteContext {
    private boolean attrGetIgnoreEmpty = true;
    private Map<String, Object> definedFunc;
    private Map<String, Object> definedIdent;
    private Map<String, Object> definedIdentFunc;

    public void setDefinedIdent(Map<String, Object> map) {
        this.definedIdent = map;
    }

    public void setDefinedFunc(Map<String, Object> map) {
        this.definedFunc = map;
    }

    public Map<String, Object> getDefinedIdent() {
        return this.definedIdent;
    }

    public Map<String, Object> getDefinedFunc() {
        return this.definedFunc;
    }

    public Map<String, Object> getDefinedIdentFunc() {
        return this.definedIdentFunc;
    }

    public void setDefinedIdentFunc(Map<String, Object> map) {
        this.definedIdentFunc = map;
    }

    public boolean isAttrGetIgnoreEmpty() {
        return this.attrGetIgnoreEmpty;
    }

    public void setAttrGetIgnoreEmpty(boolean z) {
        this.attrGetIgnoreEmpty = z;
    }
}
