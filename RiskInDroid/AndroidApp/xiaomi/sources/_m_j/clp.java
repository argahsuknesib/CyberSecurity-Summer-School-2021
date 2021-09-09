package _m_j;

import _m_j.clo;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mijia.model.sdcard.TimeItem;
import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IRDTListener;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class clp extends clo {
    public static final String O0000OOo = "clp";
    public clo.O000000o O0000Oo;
    public ArrayList<clo.O000000o> O0000Oo0 = new ArrayList<>();
    private ArrayList<clo.O000000o> O0000OoO = new ArrayList<>();
    private Handler O0000Ooo = new Handler(Looper.getMainLooper());

    public clp(cid cid) {
        super(cid);
    }

    public final clo.O000000o O000000o(TimeItem timeItem) {
        if (this.O00000Oo && this.O0000Oo.f14088O000000o.equals(timeItem)) {
            return this.O0000Oo;
        }
        try {
            if (!this.O0000Oo0.isEmpty()) {
                Iterator<clo.O000000o> it = this.O0000Oo0.iterator();
                while (it.hasNext()) {
                    clo.O000000o next = it.next();
                    if (next.f14088O000000o.equals(timeItem)) {
                        return next;
                    }
                }
            }
            if (!this.O0000OoO.isEmpty()) {
                Iterator<clo.O000000o> it2 = this.O0000OoO.iterator();
                while (it2.hasNext()) {
                    clo.O000000o next2 = it2.next();
                    if (next2.f14088O000000o.equals(timeItem)) {
                        return next2;
                    }
                }
            }
        } catch (IndexOutOfBoundsException unused) {
        }
        return null;
    }

    public final void O000000o(List<TimeItem> list) {
        if (!this.O0000Oo0.isEmpty()) {
            try {
                for (TimeItem next : list) {
                    Iterator<clo.O000000o> it = this.O0000Oo0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        clo.O000000o next2 = it.next();
                        if (next2.f14088O000000o.f5243O000000o == next.f5243O000000o) {
                            this.O0000Oo0.remove(next2);
                            break;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(clo.O00000Oo o00000Oo) {
        if (o00000Oo == null) {
            this.O00000o0 = null;
        } else {
            this.O00000o0 = new WeakReference(o00000Oo);
        }
    }

    public final synchronized void O00000Oo(TimeItem timeItem) {
        this.O0000Oo0.add(new clo.O000000o(timeItem, true));
    }

    public final synchronized void O00000o0(TimeItem timeItem) {
        O00000Oo(timeItem);
    }

    public final synchronized void O00000Oo() {
        if (this.O0000Oo0.size() != 0) {
            this.O0000Ooo.post(new Runnable() {
                /* class _m_j.clp.AnonymousClass1 */

                public final void run() {
                    if (clp.this.O0000Oo0.size() != 0 && !clp.this.O00000Oo && !clp.this.O00000o) {
                        clp.this.O00000Oo(clp.this.O0000Oo0.remove(0));
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
    public final String O000000o(clo.O000000o o000000o) {
        return me.O000000o(o000000o.f14088O000000o.f5243O000000o, true, this.f14085O000000o.getDid());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    public final void O00000Oo(final clo.O000000o o000000o) {
        String str = O0000OOo;
        gsy.O00000Oo(str, "downloadFile startTime:" + o000000o.f14088O000000o.f5243O000000o);
        final String O000000o2 = O000000o(o000000o);
        if (new File(O000000o2).exists()) {
            o000000o.O00000o = 4;
            if (!(this.O00000o0 == null || this.O00000o0.get() == null || this.O0000Oo0.size() != 0)) {
                ((clo.O00000Oo) this.O00000o0.get()).onDownloadSuccess(o000000o, O000000o2);
                fag.O000000o(XmPluginHostApi.instance().context(), XmPluginHostApi.instance().context().getString(R.string.save_success));
            }
            O00000Oo();
            return;
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(O000000o2 + ".tmp", false);
            this.O0000Oo = o000000o;
            this.O0000OoO.remove(o000000o);
            this.O00000Oo = true;
            o000000o.O00000o = 2;
            if (!(this.O00000o0 == null || this.O00000o0.get() == null)) {
                ((clo.O00000Oo) this.O00000o0.get()).onDownloading(o000000o, O000000o2, 0);
            }
            byte[] intToByteArray = Packet.intToByteArray((int) (o000000o.f14088O000000o.f5243O000000o / 1000), chp.O000000o());
            this.f14085O000000o.O00oOooO().setRDTListener(new IRDTListener() {
                /* class _m_j.clp.AnonymousClass2 */

                public final void onRDTDataReceived(byte[] bArr) {
                    boolean z;
                    int length = bArr.length;
                    if (o000000o.O00000Oo <= 0) {
                        o000000o.O00000Oo = length;
                    }
                    if (!(clp.this.O00000o0 == null || clp.this.O00000o0.get() == null)) {
                        int i = o000000o.O00000Oo > 0 ? ((o000000o.O00000Oo - length) * 100) / o000000o.O00000Oo : 0;
                        clo.O000000o o000000o = o000000o;
                        o000000o.O00000o = 2;
                        o000000o.O00000o0 = i;
                        ((clo.O00000Oo) clp.this.O00000o0.get()).onDownloading(o000000o, O000000o2, i);
                    }
                    try {
                        fileOutputStream.write(bArr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (length > 0) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        File file = new File(O000000o2 + ".tmp");
                        File file2 = new File(O000000o2 + ".g711");
                        if (clp.this.f14085O000000o == null || TextUtils.isEmpty(clp.this.f14085O000000o.getModel()) || !DeviceConstant.is16K(clp.this.f14085O000000o.getModel())) {
                            z = mk.O000000o(O000000o2, file, file2);
                        } else {
                            z = mk.O000000o(O000000o2, file, file2, 16000, 1, 16000);
                        }
                        if (!z || !file2.exists()) {
                            file.renameTo(new File(O000000o2));
                        } else {
                            file.delete();
                            file2.renameTo(new File(O000000o2));
                        }
                        clp clp = clp.this;
                        clp.O00000Oo = false;
                        clp.O0000Oo = null;
                        o000000o.O00000o = 4;
                        clp.f14085O000000o.O0000O0o().O000000o(O000000o2);
                        XmPluginHostApi.instance().context().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(O000000o2))));
                        String str = clp.O0000OOo;
                        gsy.O00000Oo(str, "mDownloadItemArrayList.size()=" + clp.this.O0000Oo0.size());
                        if (clp.this.O00000o0 == null || clp.this.O00000o0.get() == null || clp.this.O0000Oo0.size() != 0) {
                            String str2 = clp.O0000OOo;
                            gsy.O00000Oo(str2, "mOnDownloadListenerRef = " + clp.this.O00000o0);
                        } else {
                            gsy.O00000Oo(clp.O0000OOo, "mOnDownloadListenerRef != null");
                            ((clo.O00000Oo) clp.this.O00000o0.get()).onDownloadSuccess(o000000o, O000000o2);
                            if (!clp.this.O00000o) {
                                fag.O000000o(XmPluginHostApi.instance().context(), XmPluginHostApi.instance().context().getString(R.string.save_success));
                            }
                        }
                        clp.this.O00000Oo();
                    }
                }
            });
            this.f14085O000000o.O00oOooO().streamSendMessage(1, 1, intToByteArray, null, new IMISSListener() {
                /* class _m_j.clp.AnonymousClass3 */

                public final void onFailed(int i, String str) {
                }

                public final void onProgress(int i) {
                }

                public final void onSuccess(String str, Object obj) {
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.O00000Oo = false;
            this.O0000Oo = null;
            o000000o.O00000o = 3;
            this.O0000OoO.add(o000000o);
            if (!(this.O00000o0 == null || this.O00000o0.get() == null)) {
                ((clo.O00000Oo) this.O00000o0.get()).onDownloadFailed(o000000o, O000000o2, -1, "");
            }
            O00000Oo();
        }
    }
}
