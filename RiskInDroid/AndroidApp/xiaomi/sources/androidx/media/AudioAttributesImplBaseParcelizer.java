package androidx.media;

import _m_j.fw;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer {
    public static fw read(VersionedParcel versionedParcel) {
        fw fwVar = new fw();
        fwVar.f17295O000000o = versionedParcel.O00000Oo(fwVar.f17295O000000o, 1);
        fwVar.O00000Oo = versionedParcel.O00000Oo(fwVar.O00000Oo, 2);
        fwVar.O00000o0 = versionedParcel.O00000Oo(fwVar.O00000o0, 3);
        fwVar.O00000o = versionedParcel.O00000Oo(fwVar.O00000o, 4);
        return fwVar;
    }

    public static void write(fw fwVar, VersionedParcel versionedParcel) {
        versionedParcel.O000000o(fwVar.f17295O000000o, 1);
        versionedParcel.O000000o(fwVar.O00000Oo, 2);
        versionedParcel.O000000o(fwVar.O00000o0, 3);
        versionedParcel.O000000o(fwVar.O00000o, 4);
    }
}
