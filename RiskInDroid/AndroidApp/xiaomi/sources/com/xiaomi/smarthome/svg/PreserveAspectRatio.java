package com.xiaomi.smarthome.svg;

public final class PreserveAspectRatio {
    public static final PreserveAspectRatio O00000o = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio O00000o0 = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio O00000oO = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio O00000oo = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio O0000O0o = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio O0000OOo = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio O0000Oo = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio O0000Oo0 = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio O0000OoO = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);

    /* renamed from: O000000o  reason: collision with root package name */
    public Alignment f11865O000000o;
    public Scale O00000Oo;

    public enum Alignment {
        None,
        XMinYMin,
        XMidYMin,
        XMaxYMin,
        XMinYMid,
        XMidYMid,
        XMaxYMid,
        XMinYMax,
        XMidYMax,
        XMaxYMax
    }

    public enum Scale {
        Meet,
        Slice
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.f11865O000000o = alignment;
        this.O00000Oo = scale;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        return this.f11865O000000o == preserveAspectRatio.f11865O000000o && this.O00000Oo == preserveAspectRatio.O00000Oo;
    }
}
