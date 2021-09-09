package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class LogicalExpr extends BaseExpr {
    private Expr Lhs;
    private Expr Rhs;
    private String oprator;

    public LogicalExpr() {
    }

    public LogicalExpr(Expr expr, String str, Expr expr2) {
        this.Lhs = expr;
        this.oprator = str;
        this.Rhs = expr2;
    }

    public String getString() {
        return "<" + this.Lhs.getString() + ",  " + this.oprator + ", " + this.Rhs.getString() + ">";
    }

    public Expr getLhs() {
        return this.Lhs;
    }

    public String getOprator() {
        return this.oprator;
    }

    public Expr getRhs() {
        return this.Rhs;
    }

    public void setLhs(Expr expr) {
        this.Lhs = expr;
    }

    public void setOprator(String str) {
        this.oprator = str;
    }

    public void setRhs(Expr expr) {
        this.Rhs = expr;
    }
}
