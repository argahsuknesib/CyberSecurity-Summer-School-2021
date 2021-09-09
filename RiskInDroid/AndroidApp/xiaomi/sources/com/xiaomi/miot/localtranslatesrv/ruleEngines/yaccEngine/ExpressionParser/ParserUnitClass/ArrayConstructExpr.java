package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class ArrayConstructExpr extends BaseExpr {
    private Expr[] member;

    public ArrayConstructExpr() {
    }

    public ArrayConstructExpr(Expr[] exprArr) {
        this.member = exprArr;
    }

    public String getString() {
        if (this.member.length == 0) {
            return "array( )>";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            Expr[] exprArr = this.member;
            if (i < exprArr.length - 1) {
                sb.append(exprArr[i].getString());
                sb.append(",");
                i++;
            } else {
                sb.append(exprArr[exprArr.length - 1].getString());
                String sb2 = sb.toString();
                return "<array(" + sb2 + ")>";
            }
        }
    }

    public Expr[] getMember() {
        return this.member;
    }

    public void setMember(Expr[] exprArr) {
        this.member = exprArr;
    }
}
