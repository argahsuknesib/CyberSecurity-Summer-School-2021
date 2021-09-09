package com.fasterxml.jackson.core;

public enum JsonToken {
    NOT_AVAILABLE(null),
    START_OBJECT("{"),
    END_OBJECT("}"),
    START_ARRAY("["),
    END_ARRAY("]"),
    FIELD_NAME(null),
    VALUE_EMBEDDED_OBJECT(null),
    VALUE_STRING(null),
    VALUE_NUMBER_INT(null),
    VALUE_NUMBER_FLOAT(null),
    VALUE_TRUE("true"),
    VALUE_FALSE("false"),
    VALUE_NULL("null");
    
    final String _serialized;
    final byte[] _serializedBytes;
    final char[] _serializedChars;

    private JsonToken(String str) {
        if (str == null) {
            this._serialized = null;
            this._serializedChars = null;
            this._serializedBytes = null;
            return;
        }
        this._serialized = str;
        this._serializedChars = str.toCharArray();
        int length = this._serializedChars.length;
        this._serializedBytes = new byte[length];
        for (int i = 0; i < length; i++) {
            this._serializedBytes[i] = (byte) this._serializedChars[i];
        }
    }

    public final String asString() {
        return this._serialized;
    }

    public final char[] asCharArray() {
        return this._serializedChars;
    }

    public final byte[] asByteArray() {
        return this._serializedBytes;
    }

    public final boolean isNumeric() {
        return this == VALUE_NUMBER_INT || this == VALUE_NUMBER_FLOAT;
    }

    public final boolean isScalarValue() {
        return ordinal() >= VALUE_EMBEDDED_OBJECT.ordinal();
    }
}
