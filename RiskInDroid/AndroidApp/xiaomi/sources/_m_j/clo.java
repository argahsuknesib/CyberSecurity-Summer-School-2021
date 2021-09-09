package _m_j;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.mijia.model.sdcard.TimeItem;
import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.camera.P2pResponse;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class clo {

    /* renamed from: O000000o  reason: collision with root package name */
    protected cid f14085O000000o;
    protected boolean O00000Oo;
    public volatile boolean O00000o = false;
    protected WeakReference<O00000Oo> O00000o0;
    public ArrayList<O000000o> O00000oO = new ArrayList<>();
    public O000000o O00000oo;
    public ArrayList<O000000o> O0000O0o = new ArrayList<>();
    private Handler O0000OOo = new Handler(Looper.getMainLooper());

    public interface O00000Oo {
        void onDownloadFailed(O000000o o000000o, String str, int i, String str2);

        void onDownloadSuccess(O000000o o000000o, String str);

        void onDownloading(O000000o o000000o, String str, int i);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public TimeItem f14088O000000o;
        public int O00000Oo;
        public int O00000o = 1;
        public int O00000o0;
        public boolean O00000oO = true;

        public O000000o(TimeItem timeItem, boolean z) {
            this.f14088O000000o = timeItem;
            this.O00000oO = true;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof O000000o)) {
                O000000o o000000o = (O000000o) obj;
                if (this.O00000oO != o000000o.O00000oO || !this.f14088O000000o.equals(o000000o.f14088O000000o)) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    public clo(cid cid) {
        this.f14085O000000o = cid;
    }

    public O000000o O000000o(TimeItem timeItem) {
        if (this.O00000Oo && this.O00000oo.f14088O000000o.equals(timeItem)) {
            return this.O00000oo;
        }
        try {
            if (!this.O00000oO.isEmpty()) {
                Iterator<O000000o> it = this.O00000oO.iterator();
                while (it.hasNext()) {
                    O000000o next = it.next();
                    if (next.f14088O000000o.equals(timeItem)) {
                        return next;
                    }
                }
            }
            if (!this.O0000O0o.isEmpty()) {
                Iterator<O000000o> it2 = this.O0000O0o.iterator();
                while (it2.hasNext()) {
                    O000000o next2 = it2.next();
                    if (next2.f14088O000000o.equals(timeItem)) {
                        return next2;
                    }
                }
            }
        } catch (IndexOutOfBoundsException unused) {
        }
        return null;
    }

    public void O000000o(List<TimeItem> list) {
        if (!this.O00000oO.isEmpty()) {
            try {
                for (TimeItem next : list) {
                    Iterator<O000000o> it = this.O00000oO.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        O000000o next2 = it.next();
                        if (next2.f14088O000000o.f5243O000000o == next.f5243O000000o) {
                            this.O00000oO.remove(next2);
                            break;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o(O00000Oo o00000Oo) {
        if (o00000Oo == null) {
            this.O00000o0 = null;
        } else {
            this.O00000o0 = new WeakReference<>(o00000Oo);
        }
    }

    public synchronized void O00000Oo(TimeItem timeItem) {
        this.O00000oO.add(new O000000o(timeItem, true));
    }

    public synchronized void O00000o0(TimeItem timeItem) {
        O00000Oo(timeItem);
    }

    public final synchronized void O000000o() {
        this.O00000o = false;
        O00000Oo();
    }

    public synchronized void O00000Oo() {
        if (this.O00000oO.size() != 0) {
            this.O0000OOo.post(new Runnable() {
                /* class _m_j.clo.AnonymousClass1 */

                public final void run() {
                    if (clo.this.O00000oO.size() != 0 && !clo.this.O00000Oo && !clo.this.O00000o) {
                        clo.this.O00000Oo(clo.this.O00000oO.remove(0));
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String
     arg types: [long, int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, int, java.lang.String):java.lang.String
      _m_j.me.O000000o(java.lang.String, java.lang.String, int):java.lang.String
      _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String */
    public String O000000o(O000000o o000000o) {
        return me.O000000o(o000000o.f14088O000000o.f5243O000000o, true, this.f14085O000000o.getDid());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    public void O00000Oo(final O000000o o000000o) {
        final String O000000o2 = O000000o(o000000o);
        if (new File(O000000o2).exists()) {
            o000000o.O00000o = 4;
            WeakReference<O00000Oo> weakReference = this.O00000o0;
            if (!(weakReference == null || weakReference.get() == null)) {
                this.O00000o0.get().onDownloadSuccess(o000000o, O000000o2);
            }
            O00000Oo();
            return;
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(O000000o2 + ".tmp", false);
            this.O00000oo = o000000o;
            this.O0000O0o.remove(o000000o);
            this.O00000Oo = true;
            o000000o.O00000o = 2;
            WeakReference<O00000Oo> weakReference2 = this.O00000o0;
            if (!(weakReference2 == null || weakReference2.get() == null)) {
                this.O00000o0.get().onDownloading(o000000o, O000000o2, 0);
            }
            this.f14085O000000o.O0000ooo().sendMsg(1, 1, Packet.intToByteArray((int) (o000000o.f14088O000000o.f5243O000000o / 1000), chp.O000000o()), new P2pResponse() {
                /* class _m_j.clo.AnonymousClass2 */

                public final void onResponse(int i, byte[] bArr) {
                    gsy.O000000o(3, "DownloadSdCardManager", "downloadFile:".concat(String.valueOf(i)));
                    if (o000000o.O00000Oo <= 0) {
                        o000000o.O00000Oo = i;
                    }
                    if (!(clo.this.O00000o0 == null || clo.this.O00000o0.get() == null)) {
                        int i2 = o000000o.O00000Oo > 0 ? ((o000000o.O00000Oo - i) * 100) / o000000o.O00000Oo : 0;
                        O000000o o000000o = o000000o;
                        o000000o.O00000o = 2;
                        o000000o.O00000o0 = i2;
                        clo.this.O00000o0.get().onDownloading(o000000o, O000000o2, i2);
                    }
                    try {
                        fileOutputStream.write(bArr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (i <= 0) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        File file = new File(O000000o2 + ".tmp");
                        File file2 = new File(O000000o2 + ".g711");
                        if (!mk.O000000o(O000000o2, file, file2) || !file2.exists()) {
                            file.renameTo(new File(O000000o2));
                        } else {
                            file.delete();
                            file2.renameTo(new File(O000000o2));
                        }
                        clo clo = clo.this;
                        clo.O00000Oo = false;
                        clo.O00000oo = null;
                        o000000o.O00000o = 4;
                        clo.f14085O000000o.O0000O0o().O000000o(O000000o2);
                        XmPluginHostApi.instance().context().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(O000000o2))));
                        if (!(clo.this.O00000o0 == null || clo.this.O00000o0.get() == null || clo.this.O00000oO.size() != 0)) {
                            clo.this.O00000o0.get().onDownloadSuccess(o000000o, O000000o2);
                        }
                        clo.this.O00000Oo();
                    }
                }

                public final void onError(int i) {
                    gsy.O000000o(3, "DownloadSdCardManager", "downloadFile failled:".concat(String.valueOf(i)));
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new File(O000000o2 + ".tmp").delete();
                    clo clo = clo.this;
                    clo.O00000Oo = false;
                    clo.O00000oo = null;
                    o000000o.O00000o = 3;
                    clo.O0000O0o.add(o000000o);
                    if (!(clo.this.O00000o0 == null || clo.this.O00000o0.get() == null)) {
                        clo.this.O00000o0.get().onDownloadFailed(o000000o, O000000o2, i, "");
                    }
                    clo.this.O00000Oo();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.O00000Oo = false;
            this.O00000oo = null;
            o000000o.O00000o = 3;
            this.O0000O0o.add(o000000o);
            WeakReference<O00000Oo> weakReference3 = this.O00000o0;
            if (!(weakReference3 == null || weakReference3.get() == null || this.O00000oO.size() != 0)) {
                this.O00000o0.get().onDownloadFailed(o000000o, O000000o2, -1, "");
            }
            O00000Oo();
        }
    }
}
