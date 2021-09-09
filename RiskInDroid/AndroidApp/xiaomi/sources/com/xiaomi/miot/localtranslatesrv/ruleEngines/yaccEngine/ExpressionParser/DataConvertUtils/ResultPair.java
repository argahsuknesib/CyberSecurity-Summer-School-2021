package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils;

public class ResultPair<Object, Boolean> {
    private Boolean state;
    private Object statement;

    public ResultPair(Object object, Boolean booleanR) {
        this.statement = object;
        this.state = booleanR;
    }

    public Object getStatement() {
        return this.statement;
    }

    public Boolean getState() {
        return this.state;
    }

    public void setStatement(Object object) {
        this.statement = object;
    }

    public void setState(Boolean booleanR) {
        this.state = booleanR;
    }
}
