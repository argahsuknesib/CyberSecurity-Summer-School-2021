package _m_j;

import _m_j.blp;
import _m_j.blr;
import _m_j.blv;
import _m_j.bmp;
import _m_j.bmv;
import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Base64;
import com.ishumei.dfp.SMSDK;
import com.ishumei.smantifraud.SmAntiFraud;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class bln {
    /* access modifiers changed from: private */
    public static Map<String, Integer> O00000o0 = new ConcurrentHashMap();

    /* renamed from: O000000o  reason: collision with root package name */
    public bmg f13040O000000o;
    public O000000o O00000Oo;
    /* access modifiers changed from: private */
    public AtomicInteger O00000o;
    private bmv.O000000o O00000oO;
    private O000000o O00000oo;
    /* access modifiers changed from: private */
    public bmv.O000000o O0000O0o;
    private bmv.O000000o O0000OOo;
    /* access modifiers changed from: private */
    public bmg O0000Oo;
    /* access modifiers changed from: private */
    public bmv.O000000o O0000Oo0;

    static class O00000Oo {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bln f13056O000000o = new bln((byte) 0);
    }

    private bln() {
        this.O00000o = new AtomicInteger(0);
        this.f13040O000000o = new bmg() {
            /* class _m_j.bln.AnonymousClass1 */

            public final void run() {
                try {
                    blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                    if (O000000o2 != null && O000000o2.O0000oOo > 0) {
                        bmo.O000000o();
                        if (!bmo.O0000Oo()) {
                            bmz.O00000Oo("SmCollectionManager", "not available, wait to retry.", new Object[0]);
                            if (bln.this.O00000o.incrementAndGet() <= O000000o2.O0000oOo) {
                                bmf.O00000Oo().O000000o(this, 1, 1000, false);
                                return;
                            }
                        }
                    }
                    bln.this.O00000o.set(0);
                    String format = String.format(Locale.CHINA, "%d-%05d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100000)));
                    if (SmAntiFraud.f4498O000000o.O00000o) {
                        bmu O000000o3 = bmu.O000000o(SmAntiFraud.f4498O000000o.O0000O0o, SmAntiFraud.f4498O000000o.O0000o0o, SmAntiFraud.f4498O000000o.O0000o);
                        blp O000000o4 = blp.O000000o.f13066O000000o;
                        try {
                            blr O000000o5 = O000000o4.O000000o();
                            String str = O000000o5 == null ? "" : O000000o5.O0000OOo;
                            bmv.O000000o o000000o = O000000o4.O00000o;
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put("organization", O000000o4.O00000Oo);
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("os", "android");
                                hashMap2.put("sdkver", "2.9.4");
                                hashMap2.put("md5", str);
                                hashMap2.put("enc", 1);
                                hashMap2.put("smid", blo.O000000o().O00000Oo());
                                hashMap2.put("sid", format);
                                hashMap.put("data", hashMap2);
                                new bmv().O000000o(O000000o3).O000000o(bne.O000000o((Map<?, ?>) hashMap).toString().getBytes("utf-8"), null, O000000o4.O00000o0, o000000o);
                            } catch (Exception unused) {
                            }
                        } catch (Exception e) {
                            bmz.O00000Oo("CloudConfiguration", e.getMessage(), new Object[0]);
                        }
                    }
                    final blh blh = new blh();
                    blh.O000oOo0 = format;
                    new O000000o(new O000000o.C0093O000000o() {
                        /* class _m_j.bln.AnonymousClass1.AnonymousClass1 */

                        public final String O000000o() {
                            blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                            char c = 0;
                            boolean z = O000000o2 == null || O000000o2.O0000Oo;
                            boolean z2 = SmAntiFraud.f4498O000000o.O0000Oo0;
                            if (z) {
                                c = 2;
                            }
                            blg.O000000o();
                            blg.O000000o(z2 | c ? 1 : 0, blh);
                            return bln.O00000o0(bln.this.O000000o(blh), true);
                        }
                    }, new O000000o.O00000Oo() {
                        /* class _m_j.bln.AnonymousClass1.AnonymousClass2 */

                        public final String O000000o() {
                            return SmAntiFraud.f4498O000000o.O00000oO;
                        }
                    }, bln.this.O0000O0o, "base info").O000000o();
                    bln.this.O0000Oo.O000000o();
                } catch (Exception unused2) {
                }
            }
        };
        this.O00000oO = new bmv.O000000o<Object>() {
            /* class _m_j.bln.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.bln.O000000o(java.lang.String, boolean):java.lang.String
             arg types: [java.lang.String, int]
             candidates:
              _m_j.bln.O000000o(_m_j.blk, int):java.lang.String
              _m_j.bln.O000000o(_m_j.bln, java.lang.String):java.lang.String
              _m_j.bln.O000000o(java.lang.String, boolean):java.lang.String */
            public final void O000000o(String str) {
                String O000000o2 = bln.this.O000000o(str, false);
                blo.O000000o().O000000o(O000000o2);
                synchronized (bln.class) {
                    if (SmAntiFraud.getServerIdCallback() != null) {
                        if (TextUtils.isEmpty(O000000o2)) {
                            SmAntiFraud.getServerIdCallback().onError(-3);
                        } else {
                            SmAntiFraud.getServerIdCallback().onSuccess(O000000o2);
                        }
                    }
                }
            }

            public final boolean O000000o(String str, int i) {
                boolean O000000o2 = super.O000000o(str, i);
                if (O000000o2) {
                    int i2 = -4;
                    if (i == 0 || i == 1) {
                        i2 = -1;
                    } else if (i == 2 || i == 3) {
                        i2 = -2;
                    }
                    if (SmAntiFraud.getServerIdCallback() != null) {
                        SmAntiFraud.getServerIdCallback().onError(i2);
                    }
                }
                return O000000o2;
            }
        };
        this.O00000oo = new O000000o(new O000000o.C0093O000000o() {
            /* class _m_j.bln.AnonymousClass5 */

            public final String O000000o() {
                boolean z = SmAntiFraud.f4498O000000o.O0000Oo0;
                blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                char c = 0;
                if (O000000o2 == null || O000000o2.O0000Oo) {
                    c = 2;
                }
                return bln.O00000o0(bln.O000000o(bli.O000000o(), z | c ? 1 : 0), true);
            }
        }, new O000000o.O00000Oo() {
            /* class _m_j.bln.AnonymousClass6 */

            public final String O000000o() {
                return SmAntiFraud.f4498O000000o.O00000oO;
            }
        }, this.O00000oO, "core info");
        this.O0000O0o = new bmv.O000000o<Object>() {
            /* class _m_j.bln.AnonymousClass7 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.bln.O000000o(java.lang.String, boolean):java.lang.String
             arg types: [java.lang.String, int]
             candidates:
              _m_j.bln.O000000o(_m_j.blk, int):java.lang.String
              _m_j.bln.O000000o(_m_j.bln, java.lang.String):java.lang.String
              _m_j.bln.O000000o(java.lang.String, boolean):java.lang.String */
            public final void O000000o(String str) {
                String O000000o2 = bln.this.O000000o(str, false);
                blo.O000000o().O000000o(O000000o2);
                synchronized (bln.class) {
                    if (SmAntiFraud.getServerIdCallback() != null) {
                        if (TextUtils.isEmpty(O000000o2)) {
                            SmAntiFraud.getServerIdCallback().onError(-3);
                        } else {
                            SmAntiFraud.getServerIdCallback().onSuccess(O000000o2);
                        }
                    }
                }
            }

            public final boolean O000000o(String str, int i) {
                boolean O000000o2 = super.O000000o(str, i);
                if (O000000o2) {
                    bmf.O00000Oo().O000000o(new Runnable(new String(this.O00000Oo.O00000Oo), this.O00000Oo.O0000Oo) {
                        /* class _m_j.bmc.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ String f13090O000000o;
                        final /* synthetic */ String O00000Oo;

                        {
                            this.f13090O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void run() {
                            blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                            if (O000000o2 == null || !O000000o2.O0000o0O) {
                                bmz.O000000o("UploadChecker", "disabled, return.", new Object[0]);
                            } else if (!TextUtils.isEmpty(this.f13090O000000o) && !TextUtils.isEmpty(this.O00000Oo) && bmc.this.O00000Oo != null) {
                                String str = this.f13090O000000o;
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    jSONObject.put("retry", 1);
                                    str = jSONObject.toString();
                                } catch (Exception unused) {
                                }
                                bmd bmd = bmc.this.O00000Oo;
                                String str2 = this.O00000Oo;
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() <= 100000 && str2.length() <= 1000) {
                                    long O000000o3 = bmd.f13092O000000o.O000000o("upload_checker");
                                    if (O000000o3 != -1 && O000000o3 < 1000) {
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("upload_data", str);
                                        contentValues.put("upload_url", str2);
                                        bmd.f13092O000000o.O000000o("upload_checker", contentValues);
                                    }
                                }
                                bmc.this.O000000o();
                            }
                        }
                    }, 4);
                    int i2 = -4;
                    if (i == 0 || i == 1) {
                        i2 = -1;
                    } else if (i == 2 || i == 3) {
                        i2 = -2;
                    }
                    if (SmAntiFraud.getServerIdCallback() != null) {
                        SmAntiFraud.getServerIdCallback().onError(i2);
                    }
                }
                return O000000o2;
            }
        };
        this.O00000Oo = new O000000o(new O000000o.C0093O000000o() {
            /* class _m_j.bln.AnonymousClass8 */

            public final String O000000o() {
                blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                char c = 0;
                boolean z = O000000o2 == null || O000000o2.O0000Oo;
                boolean z2 = SmAntiFraud.f4498O000000o.O0000Oo0;
                if (z) {
                    c = 2;
                }
                return bln.O00000o0(bln.O000000o(blg.O000000o(), z2 | c ? 1 : 0), true);
            }
        }, new O000000o.O00000Oo() {
            /* class _m_j.bln.AnonymousClass9 */

            public final String O000000o() {
                return SmAntiFraud.f4498O000000o.O00000oO;
            }
        }, this.O0000O0o, "base info");
        this.O0000OOo = new bmv.O000000o<Object>() {
            /* class _m_j.bln.AnonymousClass10 */

            public final void O000000o(String str) {
            }
        };
        this.O0000Oo0 = new bmv.O000000o<Object>() {
            /* class _m_j.bln.AnonymousClass2 */

            public final void O000000o(String str) {
            }
        };
        this.O0000Oo = new bmg() {
            /* class _m_j.bln.AnonymousClass3 */

            public final void run() {
                blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                if (O000000o2 != null) {
                    List<blr.O00000o0> list = O000000o2.O0000oO;
                    final int i = O000000o2.O0000o;
                    int i2 = O000000o2.O0000oO0;
                    if (list != null && list.size() != 0 && i > 0 && i2 >= 0) {
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        ArrayList<bmp.O00000o> arrayList = new ArrayList<>();
                        for (blr.O00000o0 next : list) {
                            if (next.O00000Oo != 0) {
                                bmp O000000o3 = bmp.O0000OOo.f13111O000000o;
                                String str = next.f13074O000000o;
                                bmp.O00000o o00000o = TextUtils.isEmpty(str) ? null : O000000o3.f13105O000000o.get(str);
                                if (o00000o != null) {
                                    int i3 = next.O00000o;
                                    int i4 = next.O00000o0;
                                    if (i3 > 0 && i4 >= 0) {
                                        arrayList.add(o00000o);
                                        o00000o.O000000o(i3, i4);
                                        o00000o.O00000o0();
                                    }
                                }
                            }
                        }
                        bln.O00000o0.put(valueOf, 0);
                        final ArrayList arrayList2 = arrayList;
                        final String str2 = valueOf;
                        final int i5 = i2;
                        AnonymousClass1 r2 = new Runnable() {
                            /* class _m_j.bln.AnonymousClass3.AnonymousClass1 */

                            /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                                jadx.core.utils.exceptions.JadxOverflowException: 
                                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                                */
                            public final void run() {
                                /*
                                    r15 = this;
                                    java.lang.String r0 = "sensor"
                                    r1 = 0
                                    r2 = 1
                                    java.lang.String r3 = "SmCollectionManager"
                                    java.lang.String r4 = "sensor start transport."
                                    java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bmz.O000000o(r3, r4, r5)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    com.ishumei.smantifraud.SmAntiFraud$O000000o r3 = com.ishumei.smantifraud.SmAntiFraud.f4498O000000o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    boolean r3 = r3.O0000Oo0     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    if (r3 == 0) goto L_0x0015
                                    r3 = 1
                                    goto L_0x0016
                                L_0x0015:
                                    r3 = 0
                                L_0x0016:
                                    _m_j.blp r4 = _m_j.blp.O000000o.f13066O000000o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.blr r4 = r4.O000000o()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    boolean r4 = r4.O0000Oo     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    if (r4 == 0) goto L_0x0024
                                    r4 = 2
                                    goto L_0x0025
                                L_0x0024:
                                    r4 = 0
                                L_0x0025:
                                    r3 = r3 | r4
                                    _m_j.bll unused = _m_j.bll.O000000o.f13037O000000o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.List r4 = r4     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r5 = r5     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bli r6 = _m_j.bli.O000000o()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.Map r3 = r6.O000000o(r3)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r6 = "rtype"
                                    r3.put(r6, r0)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    if (r4 == 0) goto L_0x00ba
                                    int r6 = r4.size()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    if (r6 != 0) goto L_0x0044
                                    goto L_0x00ba
                                L_0x0044:
                                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r6.<init>()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                L_0x004d:
                                    boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r8 = "t"
                                    if (r7 == 0) goto L_0x00ac
                                    java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bmp$O00000o r7 = (_m_j.bmp.O00000o) r7     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.HashMap r9 = new java.util.HashMap     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r9.<init>()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.Map r10 = r7.O000000o(r5)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    if (r10 == 0) goto L_0x004d
                                    java.lang.String r11 = "stype"
                                    java.lang.String r7 = r7.O00000oo()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r9.put(r11, r7)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r7.<init>()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.Set r10 = r10.entrySet()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                L_0x007c:
                                    boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    if (r11 == 0) goto L_0x00a3
                                    java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.Object r12 = r11.getKey()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.Object r11 = r11.getValue()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r13.<init>()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r14 = "v"
                                    r13.put(r14, r11)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r13.put(r8, r12)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r7.add(r13)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    goto L_0x007c
                                L_0x00a3:
                                    java.lang.String r8 = "value"
                                    r9.put(r8, r7)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r6.add(r9)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    goto L_0x004d
                                L_0x00ac:
                                    r3.put(r0, r6)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r3.put(r8, r0)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                L_0x00ba:
                                    _m_j.bln r0 = _m_j.bln.O000000o()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    org.json.JSONObject r3 = _m_j.bne.O000000o(r3)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r0 = _m_j.bln.O00000o0(r3, true)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    com.ishumei.smantifraud.SmAntiFraud$O000000o r3 = com.ishumei.smantifraud.SmAntiFraud.f4498O000000o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r3 = r3.O00000oO     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    com.ishumei.smantifraud.SmAntiFraud$O000000o r4 = com.ishumei.smantifraud.SmAntiFraud.f4498O000000o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    byte[] r4 = r4.O0000o0o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    com.ishumei.smantifraud.SmAntiFraud$O000000o r5 = com.ishumei.smantifraud.SmAntiFraud.f4498O000000o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    boolean r5 = r5.O0000o     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bmu r3 = _m_j.bmu.O000000o(r3, r4, r5)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bmv r4 = new _m_j.bmv     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r4.<init>()     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bmv r3 = r4.O000000o(r3)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.lang.String r4 = "utf-8"
                                    byte[] r0 = r0.getBytes(r4)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bln$3 r4 = _m_j.bln.AnonymousClass3.this     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bln r4 = _m_j.bln.this     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    _m_j.bmv$O000000o r4 = r4.O0000Oo0     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    r3.O000000o(r0, r4)     // Catch:{ Exception -> 0x01d5, all -> 0x0164 }
                                    java.util.Map r0 = _m_j.bln.O00000o0
                                    java.lang.String r3 = r5
                                    java.lang.Object r0 = r0.get(r3)
                                    java.lang.Integer r0 = (java.lang.Integer) r0
                                    if (r0 != 0) goto L_0x0103
                                    goto L_0x0107
                                L_0x0103:
                                    int r1 = r0.intValue()
                                L_0x0107:
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                                    int r1 = r0.intValue()
                                    int r3 = r6
                                    int r3 = r3 - r2
                                    if (r1 >= r3) goto L_0x014d
                                    java.util.List r1 = r4
                                    java.util.Iterator r1 = r1.iterator()
                                L_0x011a:
                                    boolean r3 = r1.hasNext()
                                    if (r3 == 0) goto L_0x012c
                                    java.lang.Object r3 = r1.next()
                                    _m_j.bmp$O00000o r3 = (_m_j.bmp.O00000o) r3
                                    java.lang.String r4 = r5
                                    r3.O00000Oo(r4)
                                    goto L_0x011a
                                L_0x012c:
                                    java.util.Map r1 = _m_j.bln.O00000o0
                                    java.lang.String r3 = r5
                                    int r0 = r0.intValue()
                                    int r0 = r0 + r2
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                                    r1.put(r3, r0)
                                    _m_j.bmf r4 = _m_j.bmf.O00000Oo()
                                    r6 = 5
                                    r7 = 0
                                    int r0 = r7
                                    long r8 = (long) r0
                                    r10 = 0
                                    r5 = r15
                                    r4.O000000o(r5, r6, r7, r8, r10)
                                    return
                                L_0x014d:
                                    java.util.List r0 = r4
                                    java.util.Iterator r0 = r0.iterator()
                                L_0x0153:
                                    boolean r1 = r0.hasNext()
                                    if (r1 == 0) goto L_0x0163
                                    java.lang.Object r1 = r0.next()
                                    _m_j.bmp$O00000o r1 = (_m_j.bmp.O00000o) r1
                                    r1.O00000o()
                                    goto L_0x0153
                                L_0x0163:
                                    return
                                L_0x0164:
                                    r0 = move-exception
                                    java.util.Map r3 = _m_j.bln.O00000o0
                                    java.lang.String r4 = r5
                                    java.lang.Object r3 = r3.get(r4)
                                    java.lang.Integer r3 = (java.lang.Integer) r3
                                    if (r3 != 0) goto L_0x0174
                                    goto L_0x0178
                                L_0x0174:
                                    int r1 = r3.intValue()
                                L_0x0178:
                                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                                    int r3 = r1.intValue()
                                    int r4 = r6
                                    int r4 = r4 - r2
                                    if (r3 >= r4) goto L_0x01be
                                    java.util.List r3 = r4
                                    java.util.Iterator r3 = r3.iterator()
                                L_0x018b:
                                    boolean r4 = r3.hasNext()
                                    if (r4 == 0) goto L_0x019d
                                    java.lang.Object r4 = r3.next()
                                    _m_j.bmp$O00000o r4 = (_m_j.bmp.O00000o) r4
                                    java.lang.String r5 = r5
                                    r4.O00000Oo(r5)
                                    goto L_0x018b
                                L_0x019d:
                                    java.util.Map r3 = _m_j.bln.O00000o0
                                    java.lang.String r4 = r5
                                    int r1 = r1.intValue()
                                    int r1 = r1 + r2
                                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                                    r3.put(r4, r1)
                                    _m_j.bmf r5 = _m_j.bmf.O00000Oo()
                                    r7 = 5
                                    r8 = 0
                                    int r1 = r7
                                    long r9 = (long) r1
                                    r11 = 0
                                    r6 = r15
                                    r5.O000000o(r6, r7, r8, r9, r11)
                                    goto L_0x01d4
                                L_0x01be:
                                    java.util.List r1 = r4
                                    java.util.Iterator r1 = r1.iterator()
                                L_0x01c4:
                                    boolean r2 = r1.hasNext()
                                    if (r2 == 0) goto L_0x01d4
                                    java.lang.Object r2 = r1.next()
                                    _m_j.bmp$O00000o r2 = (_m_j.bmp.O00000o) r2
                                    r2.O00000o()
                                    goto L_0x01c4
                                L_0x01d4:
                                    throw r0
                                L_0x01d5:
                                    java.util.Map r0 = _m_j.bln.O00000o0
                                    java.lang.String r3 = r5
                                    java.lang.Object r0 = r0.get(r3)
                                    java.lang.Integer r0 = (java.lang.Integer) r0
                                    if (r0 != 0) goto L_0x01e5
                                    goto L_0x01e9
                                L_0x01e5:
                                    int r1 = r0.intValue()
                                L_0x01e9:
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                                    int r1 = r0.intValue()
                                    int r3 = r6
                                    int r3 = r3 - r2
                                    if (r1 >= r3) goto L_0x020e
                                    java.util.List r1 = r4
                                    java.util.Iterator r1 = r1.iterator()
                                L_0x01fc:
                                    boolean r3 = r1.hasNext()
                                    if (r3 == 0) goto L_0x012c
                                    java.lang.Object r3 = r1.next()
                                    _m_j.bmp$O00000o r3 = (_m_j.bmp.O00000o) r3
                                    java.lang.String r4 = r5
                                    r3.O00000Oo(r4)
                                    goto L_0x01fc
                                L_0x020e:
                                    java.util.List r0 = r4
                                    java.util.Iterator r0 = r0.iterator()
                                L_0x0214:
                                    boolean r1 = r0.hasNext()
                                    if (r1 == 0) goto L_0x0224
                                    java.lang.Object r1 = r0.next()
                                    _m_j.bmp$O00000o r1 = (_m_j.bmp.O00000o) r1
                                    r1.O00000o()
                                    goto L_0x0214
                                L_0x0224:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: _m_j.bln.AnonymousClass3.AnonymousClass1.run():void");
                            }
                        };
                        try {
                            for (bmp.O00000o O00000Oo : arrayList) {
                                O00000Oo.O00000Oo(valueOf);
                            }
                            bmf.O00000Oo().O000000o(r2, 5, false, (long) i2, false);
                        } catch (Exception e) {
                            bmz.O000000o(e);
                        }
                    }
                }
            }
        };
    }

    /* synthetic */ bln(byte b) {
        this();
    }

    public static bln O000000o() {
        return O00000Oo.f13056O000000o;
    }

    public static String O000000o(blk blk, int i) {
        try {
            return bne.O000000o((Map<?, ?>) blk.O000000o(i)).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private String O000000o(Object obj) {
        return obj == null ? "" : obj instanceof JSONObject ? O00000Oo((JSONObject) obj) : obj instanceof JSONArray ? O000000o((JSONArray) obj) : obj instanceof Number ? String.valueOf((long) (((Number) obj).doubleValue() * 10000.0d)) : obj.toString();
    }

    public static String O000000o(String str, String str2, boolean z) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "fp-it.fengkongcloud.com";
        }
        if (str2.startsWith("http")) {
            return str2;
        }
        if (str.startsWith("http")) {
            sb = new StringBuilder();
        } else {
            if (str.equals(str2)) {
                str = "fp-it.fengkongcloud.com";
            }
            sb = z ? new StringBuilder("https://") : new StringBuilder("http://");
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    private String O000000o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            sb.append(O000000o(jSONArray.get(i)));
        }
        return sb.toString();
    }

    public static String O00000Oo() {
        return "";
    }

    private static String O00000Oo(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str.trim());
            if (z) {
                O000000o(jSONObject);
            }
            return jSONObject.getString(bnd.O00000o0("9b9a89969c9ab69b"));
        } catch (Exception unused) {
            return "";
        }
    }

    private String O00000Oo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            sb.append(O000000o(jSONObject.get(str)));
        }
        return sb.toString();
    }

    public final String O000000o(blh blh) {
        try {
            JSONObject O000000o2 = bne.O000000o(blh);
            O000000o2.put("a21", bne.O00000oo(O00000Oo(O000000o2)));
            return O000000o2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O000000o(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(bnd.O00000o0("9b9a8b9e9693"));
            String optString = jSONObject.optString(bnd.O00000o0("8c"));
            if (!TextUtils.isEmpty(optString)) {
                return O00000Oo(bmx.O000000o(bnd.O00000o0("859e8ece929490cf"), bne.O0000O0o(optString)), z);
            }
            if (z) {
                O000000o(jSONObject);
            }
            return jSONObject.optString(bnd.O00000o0("9b9a89969c9ab69b"));
        } catch (Exception unused) {
            return "";
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13054O000000o = null;
        String O00000Oo = null;
        O00000Oo O00000o = null;
        C0093O000000o O00000o0 = null;
        boolean O00000oO = false;
        int O00000oo = 0;
        String O0000O0o = null;
        bmv.O000000o<?> O0000OOo = null;

        /* renamed from: _m_j.bln$O000000o$O000000o  reason: collision with other inner class name */
        public interface C0093O000000o {
            String O000000o();
        }

        public interface O00000Oo {
            String O000000o();
        }

        O000000o(C0093O000000o o000000o, O00000Oo o00000Oo, bmv.O000000o<?> o000000o2, String str) {
            this.O00000o0 = o000000o;
            this.O00000o = o00000Oo;
            this.O00000oO = true;
            this.O00000oo = 1;
            this.O0000OOo = o000000o2;
            this.O0000O0o = str;
        }

        public final void O000000o() {
            O000000o(this.O00000oO);
        }

        public final void O000000o(boolean z) {
            if (SmAntiFraud.f4498O000000o.O00000o0) {
                new bmg(z, this.O00000oo) {
                    /* class _m_j.bln.O000000o.AnonymousClass1 */

                    public final void run() {
                        try {
                            if (O000000o.this.O00000o0 != null) {
                                O000000o.this.f13054O000000o = O000000o.this.O00000o0.O000000o();
                            }
                            if (O000000o.this.O00000o != null) {
                                O000000o.this.O00000Oo = O000000o.this.O00000o.O000000o();
                            }
                            new bmv().O000000o(bmu.O000000o(O000000o.this.O00000Oo, SmAntiFraud.f4498O000000o.O0000o0o, SmAntiFraud.f4498O000000o.O0000o)).O000000o(O000000o.this.f13054O000000o.getBytes("utf-8"), O000000o.this.O0000OOo);
                        } catch (Exception unused) {
                        }
                    }
                }.O000000o();
            }
        }
    }

    private static void O000000o(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("c", 0);
        blv.O000000o.f13080O000000o.O000000o(jSONObject.optInt("t", 0), optInt);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[SYNTHETIC, Splitter:B:25:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ Exception -> 0x0104 }] */
    public static String O00000o0(String str, boolean z) {
        String str2;
        String str3;
        String str4;
        boolean z2 = false;
        try {
            char[] cArr = new char[16];
            Random random = new Random();
            for (int i = 0; i < 16; i++) {
                cArr[i] = (char) (random.nextInt(26) + 97);
            }
            str4 = new String(cArr);
            try {
                str3 = Base64.encodeToString(bnb.O000000o(SmAntiFraud.f4498O000000o.O0000o0, str4.getBytes()), 2);
            } catch (Throwable unused) {
                str3 = "";
                str2 = null;
                HashMap hashMap = new HashMap();
                String valueOf = String.valueOf(System.currentTimeMillis());
                hashMap.put(bnd.O00000o0("8b91"), Base64.encodeToString(bnb.O000000o(SmAntiFraud.f4498O000000o.O0000o0, bne.O00000oo(valueOf + str + str4 + SmAntiFraud.f4498O000000o.f4499O000000o + bnd.O00000o0("8c92a08b91")).getBytes()), 2));
                if (bnd.O000000o(str2)) {
                }
                hashMap.put(bnd.O00000o0("8c9a8c8c969091b69b"), valueOf);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(bnd.O00000o0("908d989e9196859e8b969091"), SmAntiFraud.f4498O000000o.f4499O000000o);
                hashMap2.put(bnd.O00000o0("9b9e8b9e"), hashMap);
                hashMap2.put(bnd.O00000o0("9c979e91919a93"), SmAntiFraud.f4498O000000o.O00000Oo);
                hashMap2.put(bnd.O00000o0("9a919c8d868f8b"), 1);
                return bne.O000000o((Map<?, ?>) hashMap2).toString();
            }
            try {
                str2 = SMSDK.O000000o(str4, str);
                z2 = true;
            } catch (Throwable unused2) {
                str2 = null;
                HashMap hashMap3 = new HashMap();
                String valueOf2 = String.valueOf(System.currentTimeMillis());
                hashMap3.put(bnd.O00000o0("8b91"), Base64.encodeToString(bnb.O000000o(SmAntiFraud.f4498O000000o.O0000o0, bne.O00000oo(valueOf2 + str + str4 + SmAntiFraud.f4498O000000o.f4499O000000o + bnd.O00000o0("8c92a08b91")).getBytes()), 2));
                if (bnd.O000000o(str2)) {
                }
                hashMap3.put(bnd.O00000o0("8c9a8c8c969091b69b"), valueOf2);
                HashMap hashMap22 = new HashMap();
                hashMap22.put(bnd.O00000o0("908d989e9196859e8b969091"), SmAntiFraud.f4498O000000o.f4499O000000o);
                hashMap22.put(bnd.O00000o0("9b9e8b9e"), hashMap3);
                hashMap22.put(bnd.O00000o0("9c979e91919a93"), SmAntiFraud.f4498O000000o.O00000Oo);
                hashMap22.put(bnd.O00000o0("9a919c8d868f8b"), 1);
                return bne.O000000o((Map<?, ?>) hashMap22).toString();
            }
        } catch (Throwable unused3) {
            str4 = "";
            str3 = str4;
            str2 = null;
            HashMap hashMap32 = new HashMap();
            String valueOf22 = String.valueOf(System.currentTimeMillis());
            hashMap32.put(bnd.O00000o0("8b91"), Base64.encodeToString(bnb.O000000o(SmAntiFraud.f4498O000000o.O0000o0, bne.O00000oo(valueOf22 + str + str4 + SmAntiFraud.f4498O000000o.f4499O000000o + bnd.O00000o0("8c92a08b91")).getBytes()), 2));
            if (bnd.O000000o(str2)) {
            }
            hashMap32.put(bnd.O00000o0("8c9a8c8c969091b69b"), valueOf22);
            HashMap hashMap222 = new HashMap();
            hashMap222.put(bnd.O00000o0("908d989e9196859e8b969091"), SmAntiFraud.f4498O000000o.f4499O000000o);
            hashMap222.put(bnd.O00000o0("9b9e8b9e"), hashMap32);
            hashMap222.put(bnd.O00000o0("9c979e91919a93"), SmAntiFraud.f4498O000000o.O00000Oo);
            hashMap222.put(bnd.O00000o0("9a919c8d868f8b"), 1);
            return bne.O000000o((Map<?, ?>) hashMap222).toString();
        }
        try {
            HashMap hashMap322 = new HashMap();
            String valueOf222 = String.valueOf(System.currentTimeMillis());
            hashMap322.put(bnd.O00000o0("8b91"), Base64.encodeToString(bnb.O000000o(SmAntiFraud.f4498O000000o.O0000o0, bne.O00000oo(valueOf222 + str + str4 + SmAntiFraud.f4498O000000o.f4499O000000o + bnd.O00000o0("8c92a08b91")).getBytes()), 2));
            if (bnd.O000000o(str2)) {
                hashMap322.put(bnd.O00000o0("999691989a8d8f8d96918b"), str);
            } else {
                hashMap322.put(bnd.O00000o0("999691989a8d8f8d96918b"), str2);
                if (z2) {
                    hashMap322.put(bnd.O00000o0("998fba919c909b9a"), 11);
                    hashMap322.put(bnd.O00000o0("8f8d96"), str3);
                }
            }
            hashMap322.put(bnd.O00000o0("8c9a8c8c969091b69b"), valueOf222);
            HashMap hashMap2222 = new HashMap();
            hashMap2222.put(bnd.O00000o0("908d989e9196859e8b969091"), SmAntiFraud.f4498O000000o.f4499O000000o);
            hashMap2222.put(bnd.O00000o0("9b9e8b9e"), hashMap322);
            hashMap2222.put(bnd.O00000o0("9c979e91919a93"), SmAntiFraud.f4498O000000o.O00000Oo);
            hashMap2222.put(bnd.O00000o0("9a919c8d868f8b"), 1);
            return bne.O000000o((Map<?, ?>) hashMap2222).toString();
        } catch (Exception unused4) {
            return "";
        }
    }
}
