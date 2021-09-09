package _m_j;

import android.net.Uri;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public final class imt extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    long f1484O000000o;
    long O00000Oo;
    private XMediaplayerJNI O00000o;
    private volatile boolean O00000o0;
    private String O00000oO;
    private volatile LinkedBlockingQueue<ilu> O00000oo;
    private boolean O0000O0o;

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imq.O000000o(float, boolean):float
     arg types: [float, int]
     candidates:
      _m_j.imq.O000000o(_m_j.imo, com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel):void
      _m_j.imq.O000000o(float, boolean):float */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0385, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0387, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0388, code lost:
        r5 = r17;
        r13 = r20;
        r12 = r25;
        r17 = r2;
        r2 = r19;
        r19 = r3;
        r4 = r17;
        r3 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0418, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0419, code lost:
        r27 = r2;
        r26 = r19;
        r31 = r6;
        r29 = r20;
        r30 = r25;
        r5 = false;
        r13 = 0.0f;
        r28 = null;
        r2 = r0;
        r25 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0432, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0433, code lost:
        r27 = r2;
        r26 = r12;
        r5 = r17;
        r2 = r19;
        r13 = r20;
        r12 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04c6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04c7, code lost:
        r27 = r2;
        r2 = r0;
        r31 = r6;
        r30 = "s, connected_time_threshold=";
        r25 = r17;
        r26 = r19;
        r29 = r20;
        r0 = false;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04de, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04df, code lost:
        r27 = r2;
        r12 = "s, connected_time_threshold=";
        r5 = r17;
        r2 = r19;
        r13 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x051d, code lost:
        r2 = java.lang.System.currentTimeMillis() - 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0523, code lost:
        if (r2 != 0) goto L_0x0525;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0525, code lost:
        r29 = r13;
        r13 = ((((float) r4) + 0.0f) / 1024.0f) / ((((float) r2) + 0.0f) / 1000.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x053a, code lost:
        r29 = r13;
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        r5 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0543, code lost:
        r31 = r6;
        r30 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:?, code lost:
        r5.append(_m_j.imq.O000000o(r13, true));
        r14.O00000oO = r5.toString();
        r14.O0000o0O = java.lang.String.valueOf(r4);
        r14.O0000o0o = java.lang.String.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0562, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0563, code lost:
        r31 = r6;
        r30 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0569, code lost:
        r31 = r6;
        r30 = r12;
        r29 = r13;
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x057c, code lost:
        r2 = java.lang.System.currentTimeMillis() - 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:?, code lost:
        r14.O0000Oo = _m_j.imq.O000000o((float) r2, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0587, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0589, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x058a, code lost:
        r3 = r2;
        r5 = true;
        r2 = r0;
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0590, code lost:
        r3 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x05b0, code lost:
        r14.O0000o0O = "0";
        r14.O0000o0o = "0";
        r14.O0000O0o = "system_exception";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x05cd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05ce, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x05ec, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x05f7, code lost:
        r14.O0000OOo = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:?, code lost:
        r28.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0613, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0614, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x061a, code lost:
        r27.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0631, code lost:
        _m_j.imq.O000000o(r14, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0634, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0189, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x018b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x018c, code lost:
        r29 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x018e, code lost:
        r5 = r17;
        r2 = r19;
        r13 = r20;
        r12 = r25;
        r17 = 0.0f;
        r19 = r3;
        r3 = r26;
        r4 = r29;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x035d A[SYNTHETIC, Splitter:B:127:0x035d] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0385 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:56:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0432 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:47:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x04de A[ExcHandler: IOException (e java.io.IOException), Splitter:B:13:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0519 A[Catch:{ all -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0569 A[Catch:{ all -> 0x0562, all -> 0x05cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0578 A[Catch:{ all -> 0x0562, all -> 0x05cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0598 A[Catch:{ all -> 0x05ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x05f7  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x060f A[SYNTHETIC, Splitter:B:268:0x060f] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x061a  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x061f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0659  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0664  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x067c  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x077c A[SYNTHETIC, Splitter:B:324:0x077c] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0787  */
    /* JADX WARNING: Removed duplicated region for block: B:346:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void run() {
        boolean z;
        imo imo;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        String str6;
        String str7;
        float f;
        boolean z2;
        long j;
        Throwable th;
        boolean z3;
        boolean z4;
        boolean z5;
        long j2;
        float f2;
        String str8;
        String str9;
        String str10;
        int i;
        int i2;
        String str11;
        Throwable th2;
        imr imr;
        String str12;
        String str13;
        String str14;
        String str15;
        int i3;
        int i4;
        float f3;
        long j3;
        HttpURLConnection httpURLConnection2;
        String str16;
        String str17;
        String str18;
        String str19;
        int i5;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        int i6;
        int i7;
        String str26;
        float f4;
        boolean z6;
        long j4;
        String str27 = "connected_time=";
        if (!this.O00000o0 && imd.O00000Oo(this.O00000o.O0000Oo0).equals(imd.O00000Oo(this.O00000oO))) {
            CdnConfigModel cdnConfigModel = imq.f1481O000000o;
            if (cdnConfigModel == null) {
                imo = null;
                z = true;
            } else {
                imo imo2 = new imo();
                imo2.O0000Ooo = "play_flv_live";
                imo2.O0000oO = UUID.randomUUID().toString();
                imo = imo2;
                z = false;
            }
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv start run");
            if (TextUtils.isEmpty(this.O00000oO)) {
                str = "download_speed=";
                str2 = "";
            } else {
                str2 = Uri.parse(this.O00000oO).getHost();
                str = "download_speed=";
            }
            String str28 = "cdn_download_too_slow";
            String str29 = "s";
            HttpURLConnection O000000o2 = imf.O000000o(new String[]{this.O00000oO}, null, 3, false, "GET");
            try {
                if (!this.O00000o0) {
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv getConnectionUseDnsCache return httpUrlConnection");
                    if (O000000o2 != null) {
                        if (imo != null) {
                            long currentTimeMillis = System.currentTimeMillis() - 0;
                            try {
                                imo.O0000Oo = imq.O000000o((float) currentTimeMillis, false);
                                String url = O000000o2.getURL().toString();
                                imo.f1479O000000o = url;
                                imo.O0000oO0 = str2;
                                imo.O00000o0 = imq.O000000o(url);
                                imo.O0000Oo0 = O000000o2.getHeaderField("via");
                                j = currentTimeMillis;
                            } catch (IOException e) {
                                e = e;
                                httpURLConnection = O000000o2;
                                str11 = str28;
                                i2 = 0;
                                i = 0;
                                inputStream = null;
                                j4 = currentTimeMillis;
                                str9 = "s, connected_time_threshold=";
                                str10 = str;
                                str8 = str29;
                                f2 = 0.0f;
                                j2 = j4;
                                try {
                                    e.printStackTrace();
                                    str7 = str10;
                                    try {
                                        str6 = str11;
                                        try {
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                                            ilu ilu = new ilu();
                                            ilu.O00000oO = true;
                                            ilu.O00000oo = i2;
                                            O000000o(ilu);
                                            this.O00000o0 = true;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            str3 = str27;
                                            str4 = str9;
                                            str5 = str8;
                                            th = th;
                                            f = f2;
                                            j = j2;
                                            z3 = false;
                                            z2 = false;
                                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            }
                                            imo.O0000OoO = System.currentTimeMillis();
                                            imo.O0000o = "failed";
                                            if (!z3) {
                                            }
                                            z5 = z2;
                                            z4 = z5;
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            imq.O000000o(imo, cdnConfigModel);
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str6 = str11;
                                        str3 = str27;
                                        str4 = str9;
                                        str5 = str8;
                                        th = th;
                                        f = f2;
                                        j = j2;
                                        z3 = false;
                                        z2 = false;
                                        if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                        }
                                        if (TextUtils.isEmpty(imo.O0000OOo)) {
                                        }
                                        imo.O0000OoO = System.currentTimeMillis();
                                        imo.O0000o = "failed";
                                        if (!z3) {
                                        }
                                        z5 = z2;
                                        z4 = z5;
                                        if (inputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        imq.O000000o(imo, cdnConfigModel);
                                        throw th;
                                    }
                                    try {
                                        if (TextUtils.isEmpty(imo.O00000oO)) {
                                        }
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        try {
                                            if (e.getMessage() != null) {
                                            }
                                            imo.O0000O0o = "cdn_io_exception";
                                            imo.O00000oo = imq.O000000o(e);
                                            imo.O0000o = "failed";
                                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            }
                                            imo.O0000OoO = System.currentTimeMillis();
                                            imo.O0000o = "failed";
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo == null) {
                                            }
                                        } catch (Throwable th5) {
                                            th2 = th5;
                                            z3 = true;
                                            z2 = true;
                                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            }
                                            imo.O0000OoO = System.currentTimeMillis();
                                            imo.O0000o = "failed";
                                            if (!z3) {
                                            }
                                            z5 = z2;
                                            z4 = z5;
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            imq.O000000o(imo, cdnConfigModel);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        String str30 = str27;
                                        imr = str9;
                                        String str31 = str8;
                                        th2 = th6;
                                        float f5 = f2;
                                        long j5 = j2;
                                        z3 = true;
                                        z2 = true;
                                        if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                        }
                                        if (TextUtils.isEmpty(imo.O0000OOo)) {
                                        }
                                        imo.O0000OoO = System.currentTimeMillis();
                                        imo.O0000o = "failed";
                                        if (!z3) {
                                        }
                                        z5 = z2;
                                        z4 = z5;
                                        if (inputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        imq.O000000o(imo, cdnConfigModel);
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    str6 = str11;
                                    str7 = str10;
                                    str3 = str27;
                                    str4 = str9;
                                    str5 = str8;
                                    th = th;
                                    f = f2;
                                    j = j2;
                                    z3 = false;
                                    z2 = false;
                                    if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo.O0000OOo)) {
                                    }
                                    imo.O0000OoO = System.currentTimeMillis();
                                    imo.O0000o = "failed";
                                    if (!z3) {
                                    }
                                    z5 = z2;
                                    z4 = z5;
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    imq.O000000o(imo, cdnConfigModel);
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                httpURLConnection = O000000o2;
                                str4 = "s, connected_time_threshold=";
                                str3 = str27;
                                j = currentTimeMillis;
                                str7 = str;
                                str17 = str28;
                                str16 = str29;
                                boolean z7 = false;
                                float f6 = 0.0f;
                                inputStream = null;
                                Throwable th9 = th;
                                z3 = false;
                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                }
                                imo.O0000OoO = System.currentTimeMillis();
                                imo.O0000o = "failed";
                                if (!z3) {
                                }
                                z5 = z2;
                                z4 = z5;
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                imq.O000000o(imo, cdnConfigModel);
                                throw th;
                            }
                        } else {
                            j = 0;
                        }
                        try {
                            int responseCode = O000000o2.getResponseCode();
                            if (imo != null) {
                                try {
                                    j = System.currentTimeMillis() - 0;
                                    imo.O0000Oo = imq.O000000o((float) j, false);
                                    imo.O0000Oo0 = O000000o2.getHeaderField("via");
                                    imo.O0000OOo = String.valueOf(responseCode);
                                } catch (IOException e2) {
                                    e = e2;
                                    httpURLConnection = O000000o2;
                                    str23 = str28;
                                    str24 = str29;
                                    inputStream = null;
                                    j2 = j;
                                    i6 = responseCode;
                                    i7 = 0;
                                    str25 = "s, connected_time_threshold=";
                                    str22 = str;
                                } catch (Throwable th10) {
                                    th = th10;
                                    httpURLConnection = O000000o2;
                                    str4 = "s, connected_time_threshold=";
                                    str3 = str27;
                                    str7 = str;
                                    str17 = str28;
                                    str16 = str29;
                                    boolean z72 = false;
                                    float f62 = 0.0f;
                                    inputStream = null;
                                    Throwable th92 = th;
                                    z3 = false;
                                    if (!z && imo != null) {
                                        if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            imo.O0000Oo0 = null;
                                        }
                                        if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            imo.O0000OOo = "";
                                        }
                                        imo.O0000OoO = System.currentTimeMillis();
                                        if (imo.O0000o == null || !imo.O0000o.contains("success")) {
                                            imo.O0000o = "failed";
                                        }
                                        if (!z3) {
                                            int i8 = cdnConfigModel.O00000oO;
                                            if (i8 == -1) {
                                                z4 = z2;
                                                z = true;
                                            } else {
                                                if (i8 == 0) {
                                                    this.f1484O000000o = (long) cdnConfigModel.O00000Oo;
                                                    this.O00000Oo = (long) cdnConfigModel.O00000o;
                                                    if (j > this.f1484O000000o * 1000) {
                                                        imo.O0000O0o = "cdn_connected_too_slow";
                                                        imo.O00000oo = str3 + imq.O000000o((float) j, false) + str4 + this.f1484O000000o + str5;
                                                    } else if (((float) this.O00000Oo) > f) {
                                                        imo.O0000O0o = str6;
                                                        imo.O00000oo = str7 + imq.O000000o(f, true) + "KB/s, download_speed_threshold=" + this.O00000Oo + "KB/s";
                                                    }
                                                } else {
                                                    z5 = z2;
                                                    String str32 = str7;
                                                    String str33 = str6;
                                                    String str34 = str5;
                                                    String str35 = str4;
                                                    String str36 = str3;
                                                    if (i8 == 1) {
                                                        String str37 = str33;
                                                        String str38 = str32;
                                                        this.f1484O000000o = (long) cdnConfigModel.f12180O000000o;
                                                        this.O00000Oo = (long) cdnConfigModel.O00000o0;
                                                        this.f1484O000000o = 0;
                                                        if (j > this.f1484O000000o * 1000) {
                                                            imo.O0000O0o = "cdn_connected_too_slow";
                                                            imo.O00000oo = str36 + imq.O000000o((float) j, false) + str35 + this.f1484O000000o + str34;
                                                        } else if (((float) this.O00000Oo) > f) {
                                                            imo.O0000O0o = str37;
                                                            imo.O00000oo = str38 + imq.O000000o(f, true) + "KB/s, download_speed_threshold=" + this.O00000Oo + "KB/s";
                                                        }
                                                    }
                                                    z4 = z5;
                                                }
                                                z4 = true;
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (imo != null && z4 && !z && !TextUtils.isEmpty(imo.O0000O0o) && !TextUtils.isEmpty(imo.O00000oo)) {
                                                imq.O000000o(imo, cdnConfigModel);
                                            }
                                            throw th;
                                        }
                                    }
                                    z5 = z2;
                                    z4 = z5;
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    imq.O000000o(imo, cdnConfigModel);
                                    throw th;
                                }
                            }
                            try {
                                String str39 = "s, connected_time_threshold=";
                                try {
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv responseCode:".concat(String.valueOf(responseCode)));
                                    if (responseCode == 200) {
                                        InputStream inputStream2 = O000000o2.getInputStream();
                                        try {
                                            byte[] bArr = new byte[4096];
                                            httpURLConnection = O000000o2;
                                            inputStream = inputStream2;
                                            int i9 = responseCode;
                                            int i10 = 0;
                                            int i11 = 0;
                                            imr imr2 = new imr(inputStream2);
                                            while (!this.O00000o0) {
                                                try {
                                                    i11 = imr2.O000000o(bArr, i11);
                                                    int i12 = i10 + i11;
                                                    byte[] bArr2 = new byte[i11];
                                                    int i13 = i12;
                                                    System.arraycopy(bArr, 0, bArr2, 0, i11);
                                                    ilu ilu2 = new ilu();
                                                    ilu2.O000000o(bArr2);
                                                    O000000o(ilu2);
                                                    imr = imr2;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read buf len:".concat(String.valueOf(i11)));
                                                    i10 = i13;
                                                    imr2 = imr;
                                                } catch (IOException e4) {
                                                    e = e4;
                                                    str10 = str;
                                                    str8 = str29;
                                                    str9 = str39;
                                                    f2 = 0.0f;
                                                    j4 = j;
                                                    i = i10;
                                                    str11 = str28;
                                                    i2 = i9;
                                                    j2 = j4;
                                                    e.printStackTrace();
                                                    str7 = str10;
                                                    str6 = str11;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                                                    ilu ilu3 = new ilu();
                                                    ilu3.O00000oO = true;
                                                    ilu3.O00000oo = i2;
                                                    O000000o(ilu3);
                                                    this.O00000o0 = true;
                                                    if (TextUtils.isEmpty(imo.O00000oO)) {
                                                    }
                                                    if (imo.O0000Oo <= 0.0f) {
                                                    }
                                                    if (e.getMessage() != null) {
                                                    }
                                                    imo.O0000O0o = "cdn_io_exception";
                                                    imo.O00000oo = imq.O000000o(e);
                                                    imo.O0000o = "failed";
                                                    if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo.O0000OOo)) {
                                                    }
                                                    imo.O0000OoO = System.currentTimeMillis();
                                                    imo.O0000o = "failed";
                                                    if (inputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo == null) {
                                                    }
                                                } catch (Throwable th11) {
                                                }
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last");
                                            ilu ilu4 = new ilu();
                                            ilu4.O00000o0 = true;
                                            O000000o(ilu4);
                                            this.O00000o0 = true;
                                            if (imo != null) {
                                                if (i10 > 0) {
                                                    imo.O0000o = "success";
                                                } else {
                                                    imo.O0000o = "failed";
                                                }
                                                long currentTimeMillis2 = System.currentTimeMillis() - 0;
                                                if (currentTimeMillis2 != 0) {
                                                    str26 = str27;
                                                    f4 = ((((float) i10) + 0.0f) / 1024.0f) / ((((float) currentTimeMillis2) + 0.0f) / 1000.0f);
                                                } else {
                                                    str26 = str27;
                                                    f4 = 0.0f;
                                                }
                                                try {
                                                    imo.O0000o0O = String.valueOf(i10);
                                                    imo.O0000o0o = String.valueOf(currentTimeMillis2);
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(imq.O000000o(f4, true));
                                                    imo.O00000oO = sb.toString();
                                                } catch (IOException e5) {
                                                    e = e5;
                                                    str8 = str29;
                                                    str9 = str39;
                                                    str27 = str26;
                                                    long j6 = j;
                                                    i = i10;
                                                    str11 = str28;
                                                    i2 = i9;
                                                    j2 = j6;
                                                    String str40 = str;
                                                    f2 = f4;
                                                    str10 = str40;
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    f = f4;
                                                    str6 = str28;
                                                    str4 = str39;
                                                    str3 = str26;
                                                    z3 = false;
                                                    z2 = false;
                                                    str7 = str;
                                                    str5 = str29;
                                                    if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo.O0000OOo)) {
                                                    }
                                                    imo.O0000OoO = System.currentTimeMillis();
                                                    imo.O0000o = "failed";
                                                    if (!z3) {
                                                    }
                                                    z5 = z2;
                                                    z4 = z5;
                                                    if (inputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    imq.O000000o(imo, cdnConfigModel);
                                                    throw th;
                                                }
                                            } else {
                                                str26 = str27;
                                                f4 = 0.0f;
                                            }
                                            if (!z && imo != null) {
                                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                                    imo.O0000Oo0 = null;
                                                }
                                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                                    imo.O0000OOo = "";
                                                }
                                                imo.O0000OoO = System.currentTimeMillis();
                                                if (imo.O0000o == null || !imo.O0000o.contains("success")) {
                                                    imo.O0000o = "failed";
                                                }
                                                int i14 = cdnConfigModel.O00000oO;
                                                if (i14 == -1) {
                                                    z = true;
                                                } else {
                                                    if (i14 == 0) {
                                                        this.f1484O000000o = (long) cdnConfigModel.O00000Oo;
                                                        this.O00000Oo = (long) cdnConfigModel.O00000o;
                                                        if (j > this.f1484O000000o * 1000) {
                                                            imo.O0000O0o = "cdn_connected_too_slow";
                                                            imo.O00000oo = str26 + imq.O000000o((float) j, false) + str39 + this.f1484O000000o + str29;
                                                        } else if (((float) this.O00000Oo) > f4) {
                                                            imo.O0000O0o = str28;
                                                            imo.O00000oo = str + imq.O000000o(f4, true) + "KB/s, download_speed_threshold=" + this.O00000Oo + "KB/s";
                                                        }
                                                    } else {
                                                        String str41 = str;
                                                        String str42 = str28;
                                                        String str43 = str29;
                                                        String str44 = str39;
                                                        String str45 = str26;
                                                        if (i14 == 1) {
                                                            String str46 = str41;
                                                            this.f1484O000000o = (long) cdnConfigModel.f12180O000000o;
                                                            this.O00000Oo = (long) cdnConfigModel.O00000o0;
                                                            this.f1484O000000o = 0;
                                                            if (j > this.f1484O000000o * 1000) {
                                                                imo.O0000O0o = "cdn_connected_too_slow";
                                                                imo.O00000oo = str45 + imq.O000000o((float) j, false) + str44 + this.f1484O000000o + str43;
                                                            } else if (((float) this.O00000Oo) > f4) {
                                                                imo.O0000O0o = str42;
                                                                imo.O00000oo = str46 + imq.O000000o(f4, true) + "KB/s, download_speed_threshold=" + this.O00000Oo + "KB/s";
                                                            }
                                                        }
                                                    }
                                                    z6 = true;
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException e6) {
                                                            e6.printStackTrace();
                                                        }
                                                    }
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                    if (imo != null && z6 && !z && !TextUtils.isEmpty(imo.O0000O0o) && !TextUtils.isEmpty(imo.O00000oo)) {
                                                        imq.O000000o(imo, cdnConfigModel);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            z6 = false;
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo != null) {
                                            }
                                        } catch (IOException e7) {
                                            e = e7;
                                            httpURLConnection = O000000o2;
                                            inputStream = inputStream2;
                                            int i15 = responseCode;
                                            str22 = str;
                                            str23 = str28;
                                            str24 = str29;
                                            str25 = str39;
                                            j2 = j;
                                            i6 = i15;
                                            i7 = 0;
                                            f2 = 0.0f;
                                            e.printStackTrace();
                                            str7 = str10;
                                            str6 = str11;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                                            ilu ilu32 = new ilu();
                                            ilu32.O00000oO = true;
                                            ilu32.O00000oo = i2;
                                            O000000o(ilu32);
                                            this.O00000o0 = true;
                                            if (TextUtils.isEmpty(imo.O00000oO)) {
                                            }
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            if (e.getMessage() != null) {
                                            }
                                            imo.O0000O0o = "cdn_io_exception";
                                            imo.O00000oo = imq.O000000o(e);
                                            imo.O0000o = "failed";
                                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            }
                                            imo.O0000OoO = System.currentTimeMillis();
                                            imo.O0000o = "failed";
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo == null) {
                                            }
                                        } catch (Throwable th13) {
                                            th = th13;
                                            httpURLConnection = O000000o2;
                                            inputStream = inputStream2;
                                            th = th;
                                            str20 = str27;
                                            str6 = str28;
                                            str5 = str29;
                                            str21 = str39;
                                            z3 = false;
                                            z2 = false;
                                            f = 0.0f;
                                            str7 = str;
                                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            }
                                            imo.O0000OoO = System.currentTimeMillis();
                                            imo.O0000o = "failed";
                                            if (!z3) {
                                            }
                                            z5 = z2;
                                            z4 = z5;
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            imq.O000000o(imo, cdnConfigModel);
                                            throw th;
                                        }
                                    } else {
                                        httpURLConnection = O000000o2;
                                        i5 = responseCode;
                                        str14 = str;
                                        str15 = str28;
                                        str12 = str29;
                                        str13 = str39;
                                        try {
                                            j3 = j;
                                            try {
                                                throw new IOException("httpCode".concat(String.valueOf(i5)));
                                            } catch (IOException e8) {
                                                e = e8;
                                                i3 = i5;
                                                i4 = 0;
                                                f3 = 0.0f;
                                                inputStream = null;
                                                e.printStackTrace();
                                                str7 = str10;
                                                str6 = str11;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                                                ilu ilu322 = new ilu();
                                                ilu322.O00000oO = true;
                                                ilu322.O00000oo = i2;
                                                O000000o(ilu322);
                                                this.O00000o0 = true;
                                                if (TextUtils.isEmpty(imo.O00000oO)) {
                                                }
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                if (e.getMessage() != null) {
                                                }
                                                imo.O0000O0o = "cdn_io_exception";
                                                imo.O00000oo = imq.O000000o(e);
                                                imo.O0000o = "failed";
                                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                                }
                                                imo.O0000OoO = System.currentTimeMillis();
                                                imo.O0000o = "failed";
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo == null) {
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                str17 = str15;
                                                str7 = str14;
                                                str3 = str27;
                                                str4 = str13;
                                                str16 = str12;
                                                j = j3;
                                                boolean z722 = false;
                                                float f622 = 0.0f;
                                                inputStream = null;
                                                Throwable th922 = th;
                                                z3 = false;
                                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                                }
                                                imo.O0000OoO = System.currentTimeMillis();
                                                imo.O0000o = "failed";
                                                if (!z3) {
                                                }
                                                z5 = z2;
                                                z4 = z5;
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                imq.O000000o(imo, cdnConfigModel);
                                                throw th;
                                            }
                                        } catch (IOException e9) {
                                            e = e9;
                                            j3 = j;
                                            i3 = i5;
                                            i4 = 0;
                                            f3 = 0.0f;
                                            inputStream = null;
                                            e.printStackTrace();
                                            str7 = str10;
                                            str6 = str11;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                                            ilu ilu3222 = new ilu();
                                            ilu3222.O00000oO = true;
                                            ilu3222.O00000oo = i2;
                                            O000000o(ilu3222);
                                            this.O00000o0 = true;
                                            if (TextUtils.isEmpty(imo.O00000oO)) {
                                            }
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            if (e.getMessage() != null) {
                                            }
                                            imo.O0000O0o = "cdn_io_exception";
                                            imo.O00000oo = imq.O000000o(e);
                                            imo.O0000o = "failed";
                                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            }
                                            imo.O0000OoO = System.currentTimeMillis();
                                            imo.O0000o = "failed";
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo == null) {
                                            }
                                        } catch (Throwable th15) {
                                            th = th15;
                                            str17 = str15;
                                            str7 = str14;
                                            str3 = str27;
                                            str4 = str13;
                                            str16 = str12;
                                            boolean z7222 = false;
                                            float f6222 = 0.0f;
                                            inputStream = null;
                                            Throwable th9222 = th;
                                            z3 = false;
                                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                                            }
                                            imo.O0000OoO = System.currentTimeMillis();
                                            imo.O0000o = "failed";
                                            if (!z3) {
                                            }
                                            z5 = z2;
                                            z4 = z5;
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            imq.O000000o(imo, cdnConfigModel);
                                            throw th;
                                        }
                                    }
                                } catch (IOException e10) {
                                } catch (Throwable th16) {
                                    httpURLConnection = O000000o2;
                                    th = th16;
                                    str20 = str27;
                                    str6 = str28;
                                    str5 = str29;
                                    str21 = str39;
                                    z3 = false;
                                    z2 = false;
                                    f = 0.0f;
                                    inputStream = null;
                                    str7 = str;
                                    if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo.O0000OOo)) {
                                    }
                                    imo.O0000OoO = System.currentTimeMillis();
                                    imo.O0000o = "failed";
                                    if (!z3) {
                                    }
                                    z5 = z2;
                                    z4 = z5;
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    imq.O000000o(imo, cdnConfigModel);
                                    throw th;
                                }
                            } catch (IOException e11) {
                                e = e11;
                                httpURLConnection = O000000o2;
                                i5 = responseCode;
                                str15 = str28;
                                str12 = str29;
                                j3 = j;
                                str13 = "s, connected_time_threshold=";
                                str14 = str;
                                i3 = i5;
                                i4 = 0;
                                f3 = 0.0f;
                                inputStream = null;
                                e.printStackTrace();
                                str7 = str10;
                                str6 = str11;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                                ilu ilu32222 = new ilu();
                                ilu32222.O00000oO = true;
                                ilu32222.O00000oo = i2;
                                O000000o(ilu32222);
                                this.O00000o0 = true;
                                if (TextUtils.isEmpty(imo.O00000oO)) {
                                }
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                if (e.getMessage() != null) {
                                }
                                imo.O0000O0o = "cdn_io_exception";
                                imo.O00000oo = imq.O000000o(e);
                                imo.O0000o = "failed";
                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                }
                                imo.O0000OoO = System.currentTimeMillis();
                                imo.O0000o = "failed";
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                if (imo == null) {
                                }
                            } catch (Throwable th17) {
                                th = th17;
                                httpURLConnection = O000000o2;
                                str17 = str28;
                                str3 = str27;
                                str4 = "s, connected_time_threshold=";
                                str16 = str29;
                                str7 = str;
                                boolean z72222 = false;
                                float f62222 = 0.0f;
                                inputStream = null;
                                Throwable th92222 = th;
                                z3 = false;
                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                }
                                imo.O0000OoO = System.currentTimeMillis();
                                imo.O0000o = "failed";
                                if (!z3) {
                                }
                                z5 = z2;
                                z4 = z5;
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                imq.O000000o(imo, cdnConfigModel);
                                throw th;
                            }
                        } catch (IOException e12) {
                            e = e12;
                            httpURLConnection = O000000o2;
                            str13 = "s, connected_time_threshold=";
                            str14 = str;
                            str15 = str28;
                            str12 = str29;
                            j3 = j;
                            i3 = 0;
                            i4 = 0;
                            f3 = 0.0f;
                            inputStream = null;
                            e.printStackTrace();
                            str7 = str10;
                            str6 = str11;
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                            ilu ilu322222 = new ilu();
                            ilu322222.O00000oO = true;
                            ilu322222.O00000oo = i2;
                            O000000o(ilu322222);
                            this.O00000o0 = true;
                            if (TextUtils.isEmpty(imo.O00000oO)) {
                            }
                            if (imo.O0000Oo <= 0.0f) {
                            }
                            if (e.getMessage() != null) {
                            }
                            imo.O0000O0o = "cdn_io_exception";
                            imo.O00000oo = imq.O000000o(e);
                            imo.O0000o = "failed";
                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                            }
                            imo.O0000OoO = System.currentTimeMillis();
                            imo.O0000o = "failed";
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (imo == null) {
                            }
                        } catch (Throwable th18) {
                            HttpURLConnection httpURLConnection3 = O000000o2;
                            Throwable th19 = th18;
                            String str47 = str27;
                            String str48 = "s, connected_time_threshold=";
                            String str49 = str;
                            String str50 = str28;
                            String str51 = str29;
                            boolean z8 = false;
                            z2 = false;
                            f = 0.0f;
                            inputStream = null;
                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                            }
                            imo.O0000OoO = System.currentTimeMillis();
                            imo.O0000o = "failed";
                            if (!z3) {
                            }
                            z5 = z2;
                            z4 = z5;
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            imq.O000000o(imo, cdnConfigModel);
                            throw th;
                        }
                    } else {
                        httpURLConnection2 = O000000o2;
                        String str52 = "s, connected_time_threshold=";
                        String str53 = str;
                        String str54 = str28;
                        String str55 = str29;
                        try {
                            throw new IOException("httpUrlConnection is null");
                        } catch (IOException e13) {
                            e = e13;
                            i3 = 0;
                            i4 = 0;
                            f3 = 0.0f;
                            j3 = 0;
                            inputStream = null;
                            e.printStackTrace();
                            str7 = str10;
                            str6 = str11;
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv read BufferItem last exception");
                            ilu ilu3222222 = new ilu();
                            ilu3222222.O00000oO = true;
                            ilu3222222.O00000oo = i2;
                            O000000o(ilu3222222);
                            this.O00000o0 = true;
                            if (TextUtils.isEmpty(imo.O00000oO)) {
                            }
                            if (imo.O0000Oo <= 0.0f) {
                            }
                            if (e.getMessage() != null) {
                            }
                            imo.O0000O0o = "cdn_io_exception";
                            imo.O00000oo = imq.O000000o(e);
                            imo.O0000o = "failed";
                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                            }
                            imo.O0000OoO = System.currentTimeMillis();
                            imo.O0000o = "failed";
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (imo == null) {
                            }
                        } catch (Throwable th20) {
                            th = th20;
                            str17 = str54;
                            str7 = str53;
                            str18 = str27;
                            str19 = str52;
                            str16 = str55;
                            j = 0;
                            boolean z722222 = false;
                            float f622222 = 0.0f;
                            inputStream = null;
                            Throwable th922222 = th;
                            z3 = false;
                            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo.O0000OOo)) {
                            }
                            imo.O0000OoO = System.currentTimeMillis();
                            imo.O0000o = "failed";
                            if (!z3) {
                            }
                            z5 = z2;
                            z4 = z5;
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            imq.O000000o(imo, cdnConfigModel);
                            throw th;
                        }
                    }
                } else {
                    HttpURLConnection httpURLConnection4 = O000000o2;
                    Object obj = "s, connected_time_threshold=";
                    String str56 = str;
                    String str57 = str28;
                    String str58 = str29;
                    throw new IOException("Connection timeout flv has stop");
                }
            } catch (IOException e14) {
            } catch (Throwable th21) {
                th = th21;
                httpURLConnection2 = O000000o2;
                str19 = "s, connected_time_threshold=";
                str18 = str27;
                str7 = str;
                str17 = str28;
                str16 = str29;
                j = 0;
                boolean z7222222 = false;
                float f6222222 = 0.0f;
                inputStream = null;
                Throwable th9222222 = th;
                z3 = false;
                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                }
                if (TextUtils.isEmpty(imo.O0000OOo)) {
                }
                imo.O0000OoO = System.currentTimeMillis();
                imo.O0000o = "failed";
                if (!z3) {
                }
                z5 = z2;
                z4 = z5;
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                imq.O000000o(imo, cdnConfigModel);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private void O000000o(ilu ilu) {
        imc.O000000o("dl_hls", (Object) ("putItem buffItemQueue.size()0:" + this.O00000oo.size()));
        if (this.O00000oo.remainingCapacity() < 5) {
            this.O0000O0o = true;
        } else {
            this.O0000O0o = false;
        }
        try {
            this.O00000oo.put(ilu);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imc.O000000o("dl_hls", (Object) ("putItem buffItemQueue.size()1:" + this.O00000oo.size()));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o() {
        this.O00000o0 = true;
        if (this.O00000oo != null) {
            this.O00000oo.clear();
        }
        interrupt();
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "HlsReadThread hls readData close");
    }
}
