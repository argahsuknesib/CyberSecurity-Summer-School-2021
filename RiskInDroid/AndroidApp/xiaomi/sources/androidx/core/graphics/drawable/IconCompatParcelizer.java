package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2830O000000o = versionedParcel.O00000Oo(iconCompat.f2830O000000o, 1);
        iconCompat.O00000o0 = versionedParcel.O00000o0(iconCompat.O00000o0);
        iconCompat.O00000o = versionedParcel.O00000Oo(iconCompat.O00000o, 3);
        iconCompat.O00000oO = versionedParcel.O00000Oo(iconCompat.O00000oO, 4);
        iconCompat.O00000oo = versionedParcel.O00000Oo(iconCompat.O00000oo, 5);
        iconCompat.O0000O0o = (ColorStateList) versionedParcel.O00000Oo(iconCompat.O0000O0o, 6);
        iconCompat.O0000Oo = versionedParcel.O00000o0(iconCompat.O0000Oo);
        iconCompat.O0000Oo0 = PorterDuff.Mode.valueOf(iconCompat.O0000Oo);
        switch (iconCompat.f2830O000000o) {
            case -1:
                if (iconCompat.O00000o != null) {
                    iconCompat.O00000Oo = iconCompat.O00000o;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid icon");
                }
            case 1:
            case 5:
                if (iconCompat.O00000o == null) {
                    iconCompat.O00000Oo = iconCompat.O00000o0;
                    iconCompat.f2830O000000o = 3;
                    iconCompat.O00000oO = 0;
                    iconCompat.O00000oo = iconCompat.O00000o0.length;
                    break;
                } else {
                    iconCompat.O00000Oo = iconCompat.O00000o;
                    break;
                }
            case 2:
            case 4:
            case 6:
                iconCompat.O00000Oo = new String(iconCompat.O00000o0, Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.O00000Oo = iconCompat.O00000o0;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        iconCompat.O0000Oo = iconCompat.O0000Oo0.name();
        switch (iconCompat.f2830O000000o) {
            case -1:
                iconCompat.O00000o = (Parcelable) iconCompat.O00000Oo;
                break;
            case 1:
            case 5:
                iconCompat.O00000o = (Parcelable) iconCompat.O00000Oo;
                break;
            case 2:
                iconCompat.O00000o0 = ((String) iconCompat.O00000Oo).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.O00000o0 = (byte[]) iconCompat.O00000Oo;
                break;
            case 4:
            case 6:
                iconCompat.O00000o0 = iconCompat.O00000Oo.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        if (-1 != iconCompat.f2830O000000o) {
            versionedParcel.O000000o(iconCompat.f2830O000000o, 1);
        }
        if (iconCompat.O00000o0 != null) {
            versionedParcel.O00000Oo(iconCompat.O00000o0);
        }
        if (iconCompat.O00000o != null) {
            versionedParcel.O000000o(iconCompat.O00000o, 3);
        }
        if (iconCompat.O00000oO != 0) {
            versionedParcel.O000000o(iconCompat.O00000oO, 4);
        }
        if (iconCompat.O00000oo != 0) {
            versionedParcel.O000000o(iconCompat.O00000oo, 5);
        }
        if (iconCompat.O0000O0o != null) {
            versionedParcel.O000000o(iconCompat.O0000O0o, 6);
        }
        if (iconCompat.O0000Oo != null) {
            versionedParcel.O00000Oo(iconCompat.O0000Oo);
        }
    }
}
