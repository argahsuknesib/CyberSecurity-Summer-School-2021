package _m_j;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

public final class fy {

    public interface O00000o {
        O000000o O000000o(String str, int i, Bundle bundle);

        void O000000o(String str, O00000o0<List<Parcel>> o00000o0);
    }

    public static class O00000o0<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        MediaBrowserService.Result f17401O000000o;

        O00000o0(MediaBrowserService.Result result) {
            this.f17401O000000o = result;
        }

        public final void O000000o(Object obj) {
            if (obj instanceof List) {
                this.f17401O000000o.sendResult(O000000o((List<Parcel>) ((List) obj)));
            } else if (obj instanceof Parcel) {
                Parcel parcel = (Parcel) obj;
                parcel.setDataPosition(0);
                this.f17401O000000o.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f17401O000000o.sendResult(null);
            }
        }

        private static List<MediaBrowser.MediaItem> O000000o(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel next : list) {
                next.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(next));
                next.recycle();
            }
            return arrayList;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f17399O000000o;
        final Bundle O00000Oo;

        public O000000o(String str, Bundle bundle) {
            this.f17399O000000o = str;
            this.O00000Oo = bundle;
        }
    }

    public static class O00000Oo extends MediaBrowserService {

        /* renamed from: O000000o  reason: collision with root package name */
        final O00000o f17400O000000o;

        public O00000Oo(Context context, O00000o o00000o) {
            attachBaseContext(context);
            this.f17400O000000o = o00000o;
        }

        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            O000000o O000000o2 = this.f17400O000000o.O000000o(str, i, bundle == null ? null : new Bundle(bundle));
            if (O000000o2 == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(O000000o2.f17399O000000o, O000000o2.O00000Oo);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f17400O000000o.O000000o(str, new O00000o0(result));
        }
    }
}
