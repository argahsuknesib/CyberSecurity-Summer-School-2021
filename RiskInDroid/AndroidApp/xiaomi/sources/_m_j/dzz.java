package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class dzz {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static volatile O000000o f15111O000000o;
        /* access modifiers changed from: private */
        public Context O00000Oo;
        private Boolean O00000o;
        private String O00000o0;
        private C0101O000000o O00000oO = new C0101O000000o();
        private final ArrayList<ht> O00000oo = new ArrayList<>();

        /* renamed from: _m_j.dzz$O000000o$O000000o  reason: collision with other inner class name */
        public class C0101O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            ScheduledThreadPoolExecutor f15112O000000o = new ScheduledThreadPoolExecutor(1);
            public final ArrayList<ht> O00000Oo = new ArrayList<>();
            final Runnable O00000o = new eae(this);
            ScheduledFuture<?> O00000o0;

            public C0101O000000o() {
            }
        }

        public static O000000o O000000o() {
            if (f15111O000000o == null) {
                synchronized (O000000o.class) {
                    if (f15111O000000o == null) {
                        f15111O000000o = new O000000o();
                    }
                }
            }
            return f15111O000000o;
        }

        private static boolean O00000Oo(Context context) {
            if (!eao.O000000o(context).O00000o0()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                return packageInfo != null && packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        public final void O000000o(Context context) {
            if (context == null) {
                duv.O000000o("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.O00000Oo = context;
            this.O00000o = Boolean.valueOf(O00000Oo(context));
            O000000o("com.xiaomi.xmpushsdk.tinydataPending.init");
        }

        public final void O000000o(String str) {
            duv.O00000o0("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.O00000oo) {
                arrayList.addAll(this.O00000oo);
                this.O00000oo.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                O000000o((ht) it.next());
            }
        }

        public final boolean O00000Oo() {
            return this.O00000Oo != null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f4, code lost:
            return true;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0054  */
        public final synchronized boolean O000000o(ht htVar) {
            boolean z;
            if (htVar == null) {
                return false;
            }
            if (bs.a(htVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(htVar.f52a) && TextUtils.isEmpty(this.O00000o0);
            boolean z3 = !O00000Oo();
            if (this.O00000Oo != null) {
                if (!(b.O000000o(this.O00000Oo).O00000Oo.f6054O000000o == null && !O00000Oo(this.O00000Oo))) {
                    z = false;
                    if (!z3 && !z2) {
                        if (z) {
                            duv.O00000o0("MiTinyDataClient Send item immediately." + htVar.f);
                            if (TextUtils.isEmpty(htVar.f)) {
                                htVar.f = aw.a();
                            }
                            if (TextUtils.isEmpty(htVar.f52a)) {
                                htVar.f52a = this.O00000o0;
                            }
                            if (TextUtils.isEmpty(htVar.e)) {
                                htVar.e = this.O00000Oo.getPackageName();
                            }
                            if (htVar.b <= 0) {
                                htVar.O00000Oo(System.currentTimeMillis());
                            }
                            if (bs.a(htVar, false)) {
                                return false;
                            }
                            if (this.O00000o.booleanValue()) {
                                duv.O00000o0("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + htVar.f);
                                eao O000000o2 = eao.O000000o(this.O00000Oo);
                                Intent O00000Oo2 = O000000o2.O00000Oo();
                                byte[] O000000o3 = eru.O000000o(htVar);
                                if (O000000o3 == null) {
                                    duv.O000000o("send TinyData failed, because tinyDataBytes is null.");
                                } else {
                                    O00000Oo2.setAction("com.xiaomi.mipush.SEND_TINYDATA");
                                    O00000Oo2.putExtra("mipush_payload", O000000o3);
                                    O000000o2.O00000Oo(O00000Oo2);
                                }
                            } else {
                                C0101O000000o o000000o = this.O00000oO;
                                o000000o.f15112O000000o.execute(new ead(o000000o, htVar));
                            }
                        }
                    }
                    if (z2) {
                        duv.O00000o0("MiTinyDataClient Pending " + htVar.c + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel");
                    } else if (z3) {
                        duv.O00000o0("MiTinyDataClient Pending " + htVar.c + " reason is com.xiaomi.xmpushsdk.tinydataPending.init");
                    } else if (z) {
                        duv.O00000o0("MiTinyDataClient Pending " + htVar.c + " reason is com.xiaomi.xmpushsdk.tinydataPending.appId");
                    }
                    synchronized (this.O00000oo) {
                        if (!this.O00000oo.contains(htVar)) {
                            this.O00000oo.add(htVar);
                            if (this.O00000oo.size() > 100) {
                                this.O00000oo.remove(0);
                            }
                        }
                    }
                    return true;
                }
            }
            z = true;
            if (z) {
            }
        }
    }

    public static boolean O000000o(String str, String str2, String str3) {
        ht htVar = new ht();
        htVar.d = str;
        htVar.c = str2;
        htVar.O000000o(1);
        htVar.f56b = str3;
        return O000000o.O000000o().O000000o(htVar);
    }

    public static boolean O000000o(Context context, ht htVar) {
        duv.O00000o0("MiTinyDataClient.upload " + htVar.f);
        if (!O000000o.O000000o().O00000Oo()) {
            O000000o.O000000o().O000000o(context);
        }
        return O000000o.O000000o().O000000o(htVar);
    }
}
