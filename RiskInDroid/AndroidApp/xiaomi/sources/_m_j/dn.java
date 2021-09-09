package _m_j;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import java.io.File;

public abstract class dn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final dn f14801O000000o;

    public abstract dn O000000o(String str, String str2);

    public abstract Uri O000000o();

    public abstract String O00000Oo();

    public abstract long O00000o();

    public abstract String O00000o0();

    public abstract boolean O00000oO();

    public abstract boolean O00000oo();

    public abstract dn[] O0000O0o();

    dn(dn dnVar) {
        this.f14801O000000o = dnVar;
    }

    public static dn O000000o(File file) {
        return new dp(null, file);
    }

    public static dn O000000o(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new dq(context, uri);
        }
        return null;
    }
}
