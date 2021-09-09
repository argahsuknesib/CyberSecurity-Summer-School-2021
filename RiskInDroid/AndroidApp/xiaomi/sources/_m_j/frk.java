package _m_j;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.download.DownloadReceiver;
import java.lang.ref.WeakReference;

public final class frk extends frj {
    private DownloadReceiver O00000o = new DownloadReceiver();
    private WeakReference<Context> O00000o0 = null;

    public frk(Context context, ContentResolver contentResolver, String str) {
        super(contentResolver, str);
        this.O00000o0 = new WeakReference<>(context);
    }

    public final void O000000o(boolean z) {
        Intent intent = new Intent();
        if (z) {
            intent.setAction("local_wifi_connected");
        } else {
            intent.setAction("local_wifi_disconnected");
        }
        WeakReference<Context> weakReference = this.O00000o0;
        if (weakReference != null && weakReference.get() != null) {
            this.O00000o0.get().sendBroadcast(intent);
        }
    }
}
