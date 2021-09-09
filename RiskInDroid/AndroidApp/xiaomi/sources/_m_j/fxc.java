package _m_j;

import android.net.Uri;

public class fxc {
    private static volatile fxc O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f17362O000000o = false;
    public Uri O00000Oo;

    private fxc() {
    }

    public static fxc O000000o() {
        if (O00000o0 == null) {
            synchronized (fxc.class) {
                if (O00000o0 == null) {
                    O00000o0 = new fxc();
                }
            }
        }
        return O00000o0;
    }

    public static boolean O000000o(Uri uri) {
        if (uri != null) {
            gbu.O000000o("mijia.wearables.app", "mijia.wearables.app", "uri: " + uri.toString());
        }
        return uri != null && "mihomeplugin".equals(uri.getScheme()) && "open".equals(uri.getHost()) && "ACTIVATE_NFC_FOR_LOCK".equals(uri.getQueryParameter("action"));
    }
}
