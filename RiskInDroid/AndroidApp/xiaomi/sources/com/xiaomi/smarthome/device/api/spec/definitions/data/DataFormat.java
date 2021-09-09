package com.xiaomi.smarthome.device.api.spec.definitions.data;

import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vbool;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vfloat;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vint16;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vint32;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vint64;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vint8;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vstring;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vuint16;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vuint32;
import com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vuint8;
import java.util.Locale;

@Deprecated
public enum DataFormat {
    UNKNOWN("unknown"),
    BOOL("bool"),
    UINT8("uint8"),
    UINT16("uint16"),
    UINT32("uint32"),
    INT8("int8"),
    INT16("int16"),
    INT32("int32"),
    INT64("int64"),
    FLOAT("float"),
    STRING("string");
    
    private String string;

    private DataFormat(String str) {
        this.string = str;
    }

    public final String toString() {
        return this.string;
    }

    public final boolean isNumber() {
        switch (AnonymousClass1.$SwitchMap$com$xiaomi$smarthome$device$api$spec$definitions$data$DataFormat[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return true;
            default:
                return false;
        }
    }

    public final boolean isDigits() {
        switch (this) {
            case INT8:
            case UINT8:
            case INT16:
            case UINT16:
            case INT32:
            case UINT32:
            case INT64:
                return true;
            default:
                return false;
        }
    }

    public static DataFormat from(String str) {
        for (DataFormat dataFormat : values()) {
            if (dataFormat.toString().equals(str)) {
                return dataFormat;
            }
        }
        return UNKNOWN;
    }

    public final boolean check(DataValue dataValue) {
        switch (AnonymousClass1.$SwitchMap$com$xiaomi$smarthome$device$api$spec$definitions$data$DataFormat[ordinal()]) {
            case 1:
                return dataValue.getClass() == Vint8.class;
            case 2:
                return dataValue.getClass() == Vuint8.class;
            case 3:
                return dataValue.getClass() == Vint16.class;
            case 4:
                return dataValue.getClass() == Vuint16.class;
            case 5:
                return dataValue.getClass() == Vint32.class;
            case 6:
                return dataValue.getClass() == Vuint32.class;
            case 7:
                return dataValue.getClass() == Vint64.class;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return dataValue.getClass() == Vfloat.class;
            case 9:
                return dataValue.getClass() == Vstring.class;
            case 10:
                return dataValue.getClass() == Vbool.class;
            default:
                return false;
        }
    }

    public final boolean check(DataValue dataValue, DataValue dataValue2, DataValue dataValue3) {
        return dataValue.lessEquals(dataValue2);
    }

    public final boolean validate(DataValue dataValue, DataValue dataValue2, DataValue dataValue3, DataValue dataValue4) {
        return dataValue4 == null ? dataValue.validate(dataValue2, dataValue3) : dataValue.validate(dataValue2, dataValue3, dataValue4);
    }

    public final String getFormatJavaBase() {
        switch (AnonymousClass1.$SwitchMap$com$xiaomi$smarthome$device$api$spec$definitions$data$DataFormat[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return "int";
            case 7:
                return "long";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return "float";
            case 9:
                return "String";
            case 10:
                return "boolean";
            default:
                return "unknown";
        }
    }

    public final Class<?> getJavaClass() throws RuntimeException {
        switch (AnonymousClass1.$SwitchMap$com$xiaomi$smarthome$device$api$spec$definitions$data$DataFormat[ordinal()]) {
            case 1:
                return Vint8.class;
            case 2:
                return Vuint8.class;
            case 3:
                return Vint16.class;
            case 4:
                return Vuint16.class;
            case 5:
                return Vint32.class;
            case 6:
                return Vuint32.class;
            case 7:
                return Vint64.class;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return Vfloat.class;
            case 9:
                return Vstring.class;
            case 10:
                return Vbool.class;
            default:
                return Object.class;
        }
    }

    public final Object createObjectValue(String str) throws IllegalArgumentException {
        switch (AnonymousClass1.$SwitchMap$com$xiaomi$smarthome$device$api$spec$definitions$data$DataFormat[ordinal()]) {
            case 1:
                return Integer.valueOf(str);
            case 2:
                return Integer.valueOf(str);
            case 3:
                return Integer.valueOf(str);
            case 4:
                return Integer.valueOf(str);
            case 5:
                return Integer.valueOf(str);
            case 6:
                return Integer.valueOf(str);
            case 7:
                return Long.valueOf(str);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (str.equals("0")) {
                    str = "0.0f";
                }
                return Float.valueOf(str);
            case 9:
            default:
                return str;
            case 10:
                return BooleanValueOf(str);
        }
    }

    @Deprecated
    public final DataValue createDefaultValue() {
        switch (AnonymousClass1.$SwitchMap$com$xiaomi$smarthome$device$api$spec$definitions$data$DataFormat[ordinal()]) {
            case 1:
                return new Vint8();
            case 2:
                return new Vuint8();
            case 3:
                return new Vint16();
            case 4:
                return new Vuint16();
            case 5:
                return new Vint32();
            case 6:
                return new Vuint32();
            case 7:
                return new Vint64();
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return new Vfloat();
            case 9:
                return new Vstring();
            case 10:
                return new Vbool();
            case 11:
                return new Vstring();
            default:
                return null;
        }
    }

    public final DataValue createValue(Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$xiaomi$smarthome$device$api$spec$definitions$data$DataFormat[ordinal()]) {
            case 1:
                return Vint8.valueOf(obj);
            case 2:
                return Vuint8.valueOf(obj);
            case 3:
                return Vint16.valueOf(obj);
            case 4:
                return Vuint16.valueOf(obj);
            case 5:
                return Vint32.valueOf(obj);
            case 6:
                return Vuint32.valueOf(obj);
            case 7:
                return Vint64.valueOf(obj);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return Vfloat.valueOf(obj);
            case 9:
                return Vstring.valueOf(obj);
            case 10:
                return Vbool.valueOf(obj);
            case 11:
                return Vstring.valueOf(obj);
            default:
                return null;
        }
    }

    private static Boolean BooleanValueOf(String str) {
        if (str == null) {
            return Boolean.FALSE;
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        if (upperCase.equals("1") || upperCase.equals("YES") || upperCase.equals("TRUE")) {
            return Boolean.TRUE;
        }
        if (upperCase.equals("0") || upperCase.equals("NO") || upperCase.equals("FALSE")) {
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
}
