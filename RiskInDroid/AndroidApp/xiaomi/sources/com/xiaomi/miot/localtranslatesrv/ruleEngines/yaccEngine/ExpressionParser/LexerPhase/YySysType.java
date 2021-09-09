package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.LexerPhase;

import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.Expr;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass.Token;

public class YySysType {
    private Expr expr;
    private Expr[] exprs;
    private Token token = new Token();

    public Expr getExpr() {
        return this.expr;
    }

    public Expr[] getExprs() {
        return this.exprs;
    }

    public void setExpr(Expr expr2) {
        this.expr = expr2;
    }

    public void setExprs(Expr[] exprArr) {
        this.exprs = exprArr;
    }

    public Token getToken() {
        return this.token;
    }

    public void setToken(Token token2) {
        this.token = token2;
    }
}
