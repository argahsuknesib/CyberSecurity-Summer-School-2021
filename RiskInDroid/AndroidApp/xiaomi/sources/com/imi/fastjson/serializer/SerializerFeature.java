package com.imi.fastjson.serializer;

public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar;
    
    private final int mask = (1 << ordinal());

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, SerializerFeature serializerFeature) {
        return (i & serializerFeature.getMask()) != 0;
    }

    public static int config(int i, SerializerFeature serializerFeature, boolean z) {
        if (z) {
            return i | serializerFeature.getMask();
        }
        return i & (serializerFeature.getMask() ^ -1);
    }
}
