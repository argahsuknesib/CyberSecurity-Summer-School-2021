package com.fasterxml.jackson.databind;

import _m_j.ako;

public enum MapperFeature implements ako {
    USE_ANNOTATIONS(true),
    AUTO_DETECT_CREATORS(true),
    AUTO_DETECT_FIELDS(true),
    AUTO_DETECT_GETTERS(true),
    AUTO_DETECT_IS_GETTERS(true),
    AUTO_DETECT_SETTERS(true),
    REQUIRE_SETTERS_FOR_GETTERS(false),
    USE_GETTERS_AS_SETTERS(true),
    CAN_OVERRIDE_ACCESS_MODIFIERS(true),
    USE_STATIC_TYPING(false),
    DEFAULT_VIEW_INCLUSION(true),
    SORT_PROPERTIES_ALPHABETICALLY(false);
    
    private final boolean _defaultState;

    private MapperFeature(boolean z) {
        this._defaultState = z;
    }

    public final boolean enabledByDefault() {
        return this._defaultState;
    }

    public final int getMask() {
        return 1 << ordinal();
    }
}
