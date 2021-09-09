package com.google.protobuf;

import java.lang.reflect.Field;

final class OneofInfo {
    private final Field caseField;
    private final int id;
    private final Field valueField;

    public OneofInfo(int i, Field field, Field field2) {
        this.id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public final int getId() {
        return this.id;
    }

    public final Field getCaseField() {
        return this.caseField;
    }

    public final Field getValueField() {
        return this.valueField;
    }
}
