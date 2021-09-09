package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class ArithmeticOpExpr extends BaseExpr {
    private Expr Lhs;
    private Expr Rhs;
    private String operator;

    public ArithmeticOpExpr() {
    }

    public ArithmeticOpExpr(Expr expr, String str, Expr expr2) {
        this.Lhs = expr;
        this.operator = str;
        this.Rhs = expr2;
    }

    public String getString() {
        return "<" + this.Lhs.getString() + ",  " + this.operator + ", " + this.Rhs.getString() + ">";
    }

    public Expr getLhs() {
        return this.Lhs;
    }

    public String getOperator() {
        return this.operator;
    }

    public Expr getRhs() {
        return this.Rhs;
    }

    public void setLhs(Expr expr) {
        this.Lhs = expr;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setRhs(Expr expr) {
        this.Rhs = expr;
    }
}
