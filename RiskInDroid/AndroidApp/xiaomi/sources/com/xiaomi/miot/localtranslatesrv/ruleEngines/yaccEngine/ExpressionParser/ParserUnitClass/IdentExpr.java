package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class IdentExpr extends BaseExpr {
    private String value;

    public IdentExpr() {
    }

    public IdentExpr(String str) {
        this.value = str;
    }

    public String getString() {
        return "<identexpr, " + this.value + ">";
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
