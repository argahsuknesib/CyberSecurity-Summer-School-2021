package _m_j;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
public final class fv implements fu {

    /* renamed from: O000000o  reason: collision with root package name */
    public AudioAttributes f17247O000000o;
    public int O00000Oo = -1;

    public final int hashCode() {
        return this.f17247O000000o.hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof fv)) {
            return false;
        }
        return this.f17247O000000o.equals(((fv) obj).f17247O000000o);
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f17247O000000o;
    }
}
