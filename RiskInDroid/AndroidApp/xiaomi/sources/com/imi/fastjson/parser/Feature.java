package com.imi.fastjson.parser;

public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty;
    
    private final int mask = (1 << ordinal());

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, Feature feature) {
        return (i & feature.getMask()) != 0;
    }

    public static int config(int i, Feature feature, boolean z) {
        if (z) {
            return i | feature.getMask();
        }
        return i & (feature.getMask() ^ -1);
    }
}
