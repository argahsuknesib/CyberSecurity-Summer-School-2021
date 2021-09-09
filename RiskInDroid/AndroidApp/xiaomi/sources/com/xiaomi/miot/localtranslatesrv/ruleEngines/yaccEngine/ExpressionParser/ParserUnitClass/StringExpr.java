package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class StringExpr extends BaseExpr {
    private String value;

    public StringExpr() {
    }

    public StringExpr(String str) {
        this.value = str;
    }

    public String getString() {
        return "<strexpr, " + this.value + ">";
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
