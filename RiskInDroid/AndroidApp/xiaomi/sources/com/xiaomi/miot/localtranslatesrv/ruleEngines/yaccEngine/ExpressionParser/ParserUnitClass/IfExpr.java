package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class IfExpr extends BaseExpr {
    private Expr Cond;
    private Expr Else;
    private Expr Then;

    public IfExpr() {
    }

    public IfExpr(Expr expr, Expr expr2, Expr expr3) {
        this.Cond = expr;
        this.Then = expr2;
        this.Else = expr3;
    }

    public String getString() {
        if (this.Else == null) {
            return "< if (" + this.Cond.getString() + ")then{" + this.Then.getString() + "}>";
        }
        return "< if (" + this.Cond.getString() + ")then{" + this.Then.getString() + "}else{" + this.Else.getString() + "}>";
    }

    public Expr getCond() {
        return this.Cond;
    }

    public Expr getThen() {
        return this.Then;
    }

    public Expr getElse() {
        return this.Else;
    }

    public void setCond(Expr expr) {
        this.Cond = expr;
    }

    public void setThen(Expr expr) {
        this.Then = expr;
    }

    public void setElse(Expr expr) {
        this.Else = expr;
    }
}
