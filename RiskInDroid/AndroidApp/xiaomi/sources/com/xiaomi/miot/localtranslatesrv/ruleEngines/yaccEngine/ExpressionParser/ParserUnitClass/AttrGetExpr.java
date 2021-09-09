package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class AttrGetExpr extends BaseExpr {
    private Expr key;
    private Expr object;

    public AttrGetExpr() {
    }

    public AttrGetExpr(Expr expr, Expr expr2) {
        this.object = expr;
        this.key = expr2;
    }

    public String getString() {
        return "<" + this.object.getString() + "[" + this.key.getString() + "]>";
    }

    public Expr getObject() {
        return this.object;
    }

    public Expr getKey() {
        return this.key;
    }

    public void setObject(Expr expr) {
        this.object = expr;
    }

    public void setKey(Expr expr) {
        this.key = expr;
    }
}
