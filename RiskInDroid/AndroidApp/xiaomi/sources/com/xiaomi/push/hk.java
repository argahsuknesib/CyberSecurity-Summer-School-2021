package com.xiaomi.push;

import _m_j.duv;
import _m_j.emf;
import _m_j.erp;
import _m_j.err;
import _m_j.ers;
import _m_j.erv;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.at;
import java.io.File;

public class hk implements XMPushService.n {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f6388O000000o = false;
    private Context O00000Oo;
    private int O00000o;
    private boolean O00000o0;

    public hk(Context context) {
        this.O00000Oo = context;
    }

    public static void O000000o() {
        f6388O000000o = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    public void a() {
        Context context = this.O00000Oo;
        this.O00000o0 = at.a(context).a(hu.ak.a(), true);
        this.O00000o = at.a(context).a(hu.al.a(), 7200);
        this.O00000o = Math.max(60, this.O00000o);
        if (this.O00000o0) {
            boolean z = false;
            if (Math.abs((System.currentTimeMillis() / 1000) - this.O00000Oo.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1)) > ((long) this.O00000o)) {
                duv.O000000o("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
                err O000000o2 = err.O000000o(this.O00000Oo);
                ers ers = O000000o2.O00000Oo.get("UPLOADER_PUSH_CHANNEL");
                if (ers == null && (ers = O000000o2.O00000Oo.get("UPLOADER_HTTP")) == null) {
                    ers = null;
                }
                if (emf.O000000o(this.O00000Oo) && ers != null) {
                    String packageName = this.O00000Oo.getPackageName();
                    if (!TextUtils.isEmpty("com.xiaomi.xmsf".equals(packageName) ? "1000271" : this.O00000Oo.getSharedPreferences("pref_registered_pkg_names", 0).getString(packageName, null)) && new File(this.O00000Oo.getFilesDir(), "tiny_data.data").exists() && !f6388O000000o && (!at.a(this.O00000Oo).a(hu.aV.a(), false) || erv.O0000OoO(this.O00000Oo) || erv.O0000Ooo(this.O00000Oo))) {
                        z = true;
                    }
                }
                if (!z) {
                    duv.O000000o("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                    return;
                }
                f6388O000000o = true;
                erp.O000000o(this.O00000Oo, ers);
            }
        }
    }
}
