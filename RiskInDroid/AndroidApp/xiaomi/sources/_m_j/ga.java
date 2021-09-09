package _m_j;

import _m_j.fz;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.List;

public final class ga {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Field f17455O000000o;

    public interface O00000o0 extends fz.O00000Oo {
        void O000000o(String str, O00000Oo o00000Oo, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f17455O000000o = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.w("MBSCompatApi26", e);
        }
    }

    public static Object O000000o(Context context, O00000o0 o00000o0) {
        return new O000000o(context, o00000o0);
    }

    public static void O000000o(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }

    public static Bundle O000000o(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public MediaBrowserService.Result f17456O000000o;

        O00000Oo(MediaBrowserService.Result result) {
            this.f17456O000000o = result;
        }
    }

    static class O000000o extends fz.O000000o {
        O000000o(Context context, O00000o0 o00000o0) {
            super(context, o00000o0);
        }

        public final void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((O00000o0) this.f17400O000000o).O000000o(str, new O00000Oo(result), bundle);
        }
    }
}
