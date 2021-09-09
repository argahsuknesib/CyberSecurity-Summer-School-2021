package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class MapItemExpr extends BaseExpr {
    private Expr key;
    private Expr vaule;

    public MapItemExpr() {
    }

    public MapItemExpr(Expr expr, Expr expr2) {
        this.key = expr;
        this.vaule = expr2;
    }

    public String getString() {
        return this.key.getString() + "=>" + this.vaule.getString();
    }

    public Expr getKey() {
        return this.key;
    }

    public Expr getVaule() {
        return this.vaule;
    }

    public void setKey(Expr expr) {
        this.key = expr;
    }

    public void setVaule(Expr expr) {
        this.vaule = expr;
    }
}
