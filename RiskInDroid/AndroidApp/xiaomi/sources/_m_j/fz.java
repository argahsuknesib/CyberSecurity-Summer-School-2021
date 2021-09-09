package _m_j;

import _m_j.fy;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;

public final class fz {

    public interface O00000Oo extends fy.O00000o {
        void O00000Oo(String str, fy.O00000o0<Parcel> o00000o0);
    }

    public static class O000000o extends fy.O00000Oo {
        public O000000o(Context context, O00000Oo o00000Oo) {
            super(context, o00000Oo);
        }

        public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
            ((O00000Oo) this.f17400O000000o).O00000Oo(str, new fy.O00000o0(result));
        }
    }
}
