package androidx.media;

import _m_j.fv;
import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer {
    public static fv read(VersionedParcel versionedParcel) {
        fv fvVar = new fv();
        fvVar.f17247O000000o = (AudioAttributes) versionedParcel.O00000Oo(fvVar.f17247O000000o, 1);
        fvVar.O00000Oo = versionedParcel.O00000Oo(fvVar.O00000Oo, 2);
        return fvVar;
    }

    public static void write(fv fvVar, VersionedParcel versionedParcel) {
        versionedParcel.O000000o(fvVar.f17247O000000o, 1);
        versionedParcel.O000000o(fvVar.O00000Oo, 2);
    }
}
