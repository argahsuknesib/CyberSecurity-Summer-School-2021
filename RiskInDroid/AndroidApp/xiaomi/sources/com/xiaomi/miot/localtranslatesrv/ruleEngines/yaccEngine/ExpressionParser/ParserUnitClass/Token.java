package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class Token implements Expr {
    private String Str;
    private int type;

    public String getString() {
        return "<";
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setStr(String str) {
        this.Str = str;
    }

    public int getType() {
        return this.type;
    }

    public String getStr() {
        return this.Str;
    }
}
