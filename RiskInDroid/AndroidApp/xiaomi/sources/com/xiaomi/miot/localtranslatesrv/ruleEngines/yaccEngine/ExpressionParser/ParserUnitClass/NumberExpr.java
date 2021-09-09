package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.ParserUnitClass;

public class NumberExpr extends BaseExpr {
    private Object value;

    public NumberExpr() {
    }

    public NumberExpr(float f) {
        this.value = Float.valueOf(f);
    }

    public String getString() {
        return "<numexpr, " + this.value + ">";
    }

    public Object getValue() {
        float floatValue = ((Float) this.value).floatValue();
        int i = (int) floatValue;
        if (((float) i) == floatValue) {
            return Integer.valueOf(i);
        }
        return Float.valueOf(floatValue);
    }

    public void setValue(float f) {
        this.value = Float.valueOf(f);
    }
}
