package androidx.media;

import _m_j.fu;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f2892O000000o = (fu) versionedParcel.O00000o0(audioAttributesCompat.f2892O000000o);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.O000000o(audioAttributesCompat.f2892O000000o);
    }
}
