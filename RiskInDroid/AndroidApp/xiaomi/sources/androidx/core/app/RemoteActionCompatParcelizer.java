package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2826O000000o = (IconCompat) versionedParcel.O00000o0(remoteActionCompat.f2826O000000o);
        remoteActionCompat.O00000Oo = versionedParcel.O00000Oo(remoteActionCompat.O00000Oo, 2);
        remoteActionCompat.O00000o0 = versionedParcel.O00000Oo(remoteActionCompat.O00000o0, 3);
        remoteActionCompat.O00000o = (PendingIntent) versionedParcel.O00000Oo(remoteActionCompat.O00000o, 4);
        remoteActionCompat.O00000oO = versionedParcel.O00000Oo(remoteActionCompat.O00000oO, 5);
        remoteActionCompat.O00000oo = versionedParcel.O00000Oo(remoteActionCompat.O00000oo, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.O000000o(remoteActionCompat.f2826O000000o);
        versionedParcel.O000000o(remoteActionCompat.O00000Oo, 2);
        versionedParcel.O000000o(remoteActionCompat.O00000o0, 3);
        versionedParcel.O000000o(remoteActionCompat.O00000o, 4);
        versionedParcel.O000000o(remoteActionCompat.O00000oO, 5);
        versionedParcel.O000000o(remoteActionCompat.O00000oo, 6);
    }
}
