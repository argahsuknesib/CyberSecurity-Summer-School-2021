package com.fasterxml.jackson.databind;

import _m_j.ako;

public enum DeserializationFeature implements ako {
    USE_BIG_DECIMAL_FOR_FLOATS(false),
    USE_BIG_INTEGER_FOR_INTS(false),
    USE_JAVA_ARRAY_FOR_JSON_ARRAY(false),
    READ_ENUMS_USING_TO_STRING(false),
    FAIL_ON_UNKNOWN_PROPERTIES(true),
    FAIL_ON_NULL_FOR_PRIMITIVES(false),
    FAIL_ON_NUMBERS_FOR_ENUMS(false),
    WRAP_EXCEPTIONS(true),
    ACCEPT_SINGLE_VALUE_AS_ARRAY(false),
    UNWRAP_ROOT_VALUE(false),
    ACCEPT_EMPTY_STRING_AS_NULL_OBJECT(false),
    READ_UNKNOWN_ENUM_VALUES_AS_NULL(false);
    
    private final boolean _defaultState;

    private DeserializationFeature(boolean z) {
        this._defaultState = z;
    }

    public final boolean enabledByDefault() {
        return this._defaultState;
    }

    public final int getMask() {
        return 1 << ordinal();
    }
}
