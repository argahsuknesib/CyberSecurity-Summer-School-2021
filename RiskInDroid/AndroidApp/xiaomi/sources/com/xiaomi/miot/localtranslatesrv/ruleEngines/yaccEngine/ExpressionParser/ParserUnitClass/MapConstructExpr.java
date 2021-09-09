package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class MapConstructExpr extends BaseExpr {
    private Expr[] member;

    public MapConstructExpr() {
    }

    public MapConstructExpr(Expr[] exprArr) {
        this.member = exprArr;
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();
        if (this.member.length == 0) {
            return null;
        }
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
                return "<map(" + sb2 + ")>";
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
