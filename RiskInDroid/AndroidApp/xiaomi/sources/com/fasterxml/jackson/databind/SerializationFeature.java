package com.fasterxml.jackson.databind;

import _m_j.ako;

public enum SerializationFeature implements ako {
    WRAP_ROOT_VALUE(false),
    INDENT_OUTPUT(false),
    FAIL_ON_EMPTY_BEANS(true),
    WRAP_EXCEPTIONS(true),
    CLOSE_CLOSEABLE(false),
    FLUSH_AFTER_WRITE_VALUE(true),
    WRITE_DATES_AS_TIMESTAMPS(true),
    WRITE_DATE_KEYS_AS_TIMESTAMPS(false),
    WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS(false),
    WRITE_ENUMS_USING_TO_STRING(false),
    WRITE_ENUMS_USING_INDEX(false),
    WRITE_NULL_MAP_VALUES(true),
    WRITE_EMPTY_JSON_ARRAYS(true),
    WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED(false),
    ORDER_MAP_ENTRIES_BY_KEYS(false);
    
    private final boolean _defaultState;

    private SerializationFeature(boolean z) {
        this._defaultState = z;
    }

    public final boolean enabledByDefault() {
        return this._defaultState;
    }

    public final int getMask() {
        return 1 << ordinal();
    }
}
