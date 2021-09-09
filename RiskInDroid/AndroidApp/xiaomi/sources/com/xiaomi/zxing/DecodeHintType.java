package com.xiaomi.zxing;

import _m_j.idh;
import java.util.List;

public enum DecodeHintType {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(idh.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    
    private final Class<?> valueType;

    private DecodeHintType(Class<?> cls) {
        this.valueType = cls;
    }

    public final Class<?> getValueType() {
        return this.valueType;
    }
}
