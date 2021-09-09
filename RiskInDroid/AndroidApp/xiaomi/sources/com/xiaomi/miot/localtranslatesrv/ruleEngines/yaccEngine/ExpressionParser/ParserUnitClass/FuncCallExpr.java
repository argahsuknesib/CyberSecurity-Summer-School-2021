package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class FuncCallExpr extends BaseExpr {
    private Expr[] args;
    private IdentExpr func;

    public FuncCallExpr() {
    }

    public FuncCallExpr(IdentExpr identExpr, Expr[] exprArr) {
        this.func = identExpr;
        this.args = exprArr;
    }

    public String getString() {
        if (this.args.length != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                Expr[] exprArr = this.args;
                if (i < exprArr.length - 1) {
                    sb.append(exprArr[i].getString());
                    sb.append(",");
                    i++;
                } else {
                    sb.append(exprArr[exprArr.length - 1].getString());
                    String sb2 = sb.toString();
                    return "<" + this.func + "(" + sb2 + ")>";
                }
            }
        } else {
            return "<" + this.func + "( )>";
        }
    }

    public IdentExpr getFunc() {
        return this.func;
    }

    public void setFunc(IdentExpr identExpr) {
        this.func = identExpr;
    }

    public void setArgs(Expr[] exprArr) {
        this.args = exprArr;
    }

    public Expr[] getArgs() {
        return this.args;
    }
}
