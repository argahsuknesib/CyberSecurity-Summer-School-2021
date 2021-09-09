package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserPhase;

import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.LexerPhase.YySysType;

public class ParserVal extends YySysType {
    public double dval;
    public int ival;
    public Object obj;
    public String sval;

    public ParserVal() {
    }

    public ParserVal(int i) {
        this.ival = i;
    }

    public ParserVal(double d) {
        this.dval = d;
    }

    public ParserVal(String str) {
        this.sval = str;
    }

    public ParserVal(Object obj2) {
        this.obj = obj2;
    }
}
