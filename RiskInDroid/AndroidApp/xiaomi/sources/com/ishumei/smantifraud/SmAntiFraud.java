package com.ishumei.smantifraud;

import _m_j.blg;
import _m_j.bln;
import _m_j.blo;
import _m_j.blp;
import _m_j.blu;
import _m_j.blv;
import _m_j.blw;
import _m_j.bmb;
import _m_j.bmc;
import _m_j.bmf;
import _m_j.bmw;
import _m_j.bmy;
import _m_j.bmz;
import _m_j.bnd;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.Keep;
import com.ishumei.dfp.SMSDK;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class SmAntiFraud {

    /* renamed from: O000000o  reason: collision with root package name */
    public static O000000o f4498O000000o = null;
    private static boolean O00000Oo = false;
    /* access modifiers changed from: private */
    public static IServerSmidCallback O00000o = null;
    private static int O00000o0 = 1;

    @Keep
    public interface IServerSmidCallback {
        void onError(int i);

        void onSuccess(String str);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f4499O000000o;
        public String O00000Oo;
        public boolean O00000o;
        public boolean O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        boolean O0000Oo;
        public boolean O0000Oo0;
        IServerSmidCallback O0000OoO;
        public Set<String> O0000Ooo;
        public boolean O0000o;
        public String O0000o0;
        public String O0000o00;
        public String O0000o0O;
        public byte[] O0000o0o;
        String O0000oO0;

        public final String O000000o() {
            StringBuilder sb = new StringBuilder();
            String str = "1";
            sb.append(this.O00000o0 ? str : "0");
            sb.append(this.O00000o ? str : "0");
            sb.append(this.O0000Oo0 ? str : "0");
            sb.append(this.O0000Oo ? str : "0");
            sb.append(SmAntiFraud.O00000o != null ? str : "0");
            Set<String> set = this.O0000Ooo;
            sb.append((set == null || set.size() <= 0) ? "0" : str);
            if (!this.O0000o) {
                str = "0";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    private SmAntiFraud() {
    }

    @Keep
    public static int checkDeviceIdType(String str) {
        try {
            int O000000o2 = SMSDK.O000000o(str);
            if (O000000o2 == 1 || O000000o2 == 2) {
                return 3;
            }
            if (O000000o2 == 0) {
                return 2;
            }
            return O000000o2 == -1 ? 1 : -1;
        } catch (IOException unused) {
        }
    }

    @Keep
    public static String getBaseSyn() {
        return getBaseSyn(false);
    }

    @Keep
    public static String getBaseSyn(boolean z) {
        bln.O000000o();
        return bln.O000000o(blg.O000000o(), 0);
    }

    @Keep
    public static String getContact(int i) {
        if (i != 0 && 1 != i) {
            return "";
        }
        try {
            if (O00000o0 == 0) {
                bln.O000000o();
            }
            return getContactSyn();
        } catch (Exception e) {
            blu.O000000o(e);
            return "";
        }
    }

    @Keep
    public static String getContactSyn() {
        return getContactSyn(false);
    }

    @Keep
    public static String getContactSyn(boolean z) {
        bln.O000000o();
        return bln.O00000Oo();
    }

    @Keep
    public static String getDeviceId() {
        return blo.O000000o().O00000Oo();
    }

    @Keep
    public static String getSDKVersion() {
        return "2.9.4";
    }

    @Keep
    public static IServerSmidCallback getServerIdCallback() {
        return O00000o;
    }

    @Keep
    public static synchronized void registerServerIdCallback(IServerSmidCallback iServerSmidCallback) {
        synchronized (SmAntiFraud.class) {
            O00000o = iServerSmidCallback;
        }
    }

    @Keep
    public static void create(Context context, O000000o o000000o) {
        if (o000000o == null || o000000o.f4499O000000o == null) {
            throw new IllegalArgumentException("SmOption and organization could not be null.");
        }
        try {
            bmy O000000o2 = bmy.O000000o.f13125O000000o;
            if (O000000o2.f13124O000000o == 0) {
                O000000o2.f13124O000000o = System.currentTimeMillis();
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                blw.f13081O000000o = applicationContext;
                blu.O000000o(o000000o.O00000o0);
                if (bnd.O000000o(O000000o(o000000o))) {
                    blu.O000000o(new Exception(bnd.O00000o0("9c8d9a9e8b9adf8d9a8b8a8d91df8c92969bdf9a928f8b86")));
                    bmy.O000000o.f13125O000000o.O000000o();
                    return;
                }
                bmy.O000000o.f13125O000000o.O000000o();
            }
        } catch (Exception e) {
            blu.O000000o(e);
            bmz.O000000o(e);
        } finally {
            bmy.O000000o.f13125O000000o.O000000o();
        }
    }

    private static String O000000o(O000000o o000000o) {
        String[] strArr;
        if (!O00000Oo) {
            synchronized (SmAntiFraud.class) {
                if (!O00000Oo) {
                    O00000Oo = true;
                    if (o000000o != null) {
                        f4498O000000o = o000000o;
                        if (!bnd.O000000o(o000000o.f4499O000000o)) {
                            String str = f4498O000000o.O0000oO0;
                            char c = 65535;
                            int hashCode = str.hashCode();
                            if (hashCode != 3144) {
                                if (hashCode != 118718) {
                                    if (hashCode == 3144079) {
                                        if (str.equals("fjny")) {
                                            c = 2;
                                        }
                                    }
                                } else if (str.equals("xjp")) {
                                    c = 1;
                                }
                            } else if (str.equals("bj")) {
                                c = 0;
                            }
                            if (c == 0) {
                                strArr = bmb.f13087O000000o;
                            } else if (c != 1) {
                                strArr = c != 2 ? new String[]{f4498O000000o.O00000oO, f4498O000000o.O0000OOo, f4498O000000o.O0000oO0} : bmb.O00000o0;
                            } else {
                                strArr = bmb.O00000Oo;
                            }
                            if (strArr == null || strArr.length < 3) {
                                strArr = bmb.f13087O000000o;
                            }
                            O000000o o000000o2 = f4498O000000o;
                            bln.O000000o();
                            o000000o2.O00000oO = bln.O000000o(strArr[0], f4498O000000o.O00000oO, f4498O000000o.O0000Oo);
                            O000000o o000000o3 = f4498O000000o;
                            bln.O000000o();
                            o000000o3.O0000O0o = bln.O000000o(strArr[0], f4498O000000o.O0000O0o, f4498O000000o.O0000Oo);
                            O000000o o000000o4 = f4498O000000o;
                            bln.O000000o();
                            o000000o4.O00000oo = bln.O000000o(strArr[0], f4498O000000o.O00000oo, f4498O000000o.O0000Oo);
                            O000000o o000000o5 = f4498O000000o;
                            bln.O000000o();
                            o000000o5.O0000OOo = bln.O000000o(strArr[1], f4498O000000o.O0000OOo, f4498O000000o.O0000Oo);
                            blo O000000o2 = blo.O000000o();
                            String str2 = strArr[2];
                            try {
                                O000000o2.O00000oO = blo.O00000o0 + str2;
                                O000000o2.O000000o(new blo.O00000Oo());
                                O000000o2.O000000o(new blo.O00000o());
                                O000000o2.O000000o(new blo.O000000o());
                                O000000o2.O000000o(new blo.O00000o0());
                                Collections.sort(O000000o2.O00000o, new Comparator<blo.O0000O0o>() {
                                    /* class _m_j.blo.AnonymousClass1 */

                                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                                        return ((O0000O0o) obj2).O00000Oo - ((O0000O0o) obj).O00000Oo;
                                    }
                                });
                            } catch (Exception e) {
                                bmz.O00000o("SmidManager", "SmidManager constructor failed: %s", e);
                            }
                            bmf O00000Oo2 = bmf.O00000Oo();
                            O00000Oo2.O00000o0 = new Handler(Looper.getMainLooper());
                            O00000Oo2.O00000o = new HandlerThread("request thread");
                            O00000Oo2.O00000oO = new HandlerThread("callback thread");
                            O00000Oo2.O00000oo = new HandlerThread("uploadChecker thread");
                            O00000Oo2.O0000O0o = new HandlerThread("sensor thread");
                            O00000Oo2.O00000o.start();
                            O00000Oo2.O00000oO.start();
                            O00000Oo2.O00000oo.start();
                            O00000Oo2.O0000O0o.start();
                            O00000Oo2.O0000OOo = new Handler(O00000Oo2.O00000o.getLooper());
                            O00000Oo2.O0000Oo0 = new Handler(O00000Oo2.O00000oO.getLooper());
                            O00000Oo2.O0000Oo = new Handler(O00000Oo2.O00000oo.getLooper());
                            O00000Oo2.O0000OoO = new Handler(O00000Oo2.O0000O0o.getLooper());
                            O00000Oo2.f13094O000000o.put(Long.valueOf(O00000Oo2.O00000o0.getLooper().getThread().getId()), 3);
                            O00000Oo2.f13094O000000o.put(Long.valueOf(O00000Oo2.O0000OOo.getLooper().getThread().getId()), 1);
                            O00000Oo2.f13094O000000o.put(Long.valueOf(O00000Oo2.O0000Oo0.getLooper().getThread().getId()), 2);
                            O00000Oo2.f13094O000000o.put(Long.valueOf(O00000Oo2.O0000Oo.getLooper().getThread().getId()), 4);
                            O00000Oo2.f13094O000000o.put(Long.valueOf(O00000Oo2.O0000OoO.getLooper().getThread().getId()), 5);
                            O00000Oo2.O00000Oo.put(3, O00000Oo2.O00000o0);
                            O00000Oo2.O00000Oo.put(1, O00000Oo2.O0000OOo);
                            O00000Oo2.O00000Oo.put(2, O00000Oo2.O0000Oo0);
                            O00000Oo2.O00000Oo.put(4, O00000Oo2.O0000Oo);
                            O00000Oo2.O00000Oo.put(5, O00000Oo2.O0000Oo);
                            blu.O00000Oo(f4498O000000o.f4499O000000o);
                            blu.O000000o(f4498O000000o.O0000OOo);
                            blp O000000o3 = blp.O000000o.f13066O000000o;
                            String str3 = f4498O000000o.f4499O000000o;
                            String str4 = f4498O000000o.O0000O0o;
                            O000000o3.O00000Oo = str3;
                            O000000o3.O00000o0 = str4;
                            if (f4498O000000o.O0000OoO != null) {
                                O00000o = f4498O000000o.O0000OoO;
                            }
                            bmc.O000000o.f13091O000000o.O000000o();
                            O00000o0 = 0;
                        } else {
                            throw new Exception("organization empty");
                        }
                    } else {
                        throw new Exception("option null");
                    }
                }
            }
        }
        if (O00000o0 == 0) {
            bmw bmw = new bmw();
            bmw.O000000o();
            String O00000Oo3 = blo.O000000o().O00000Oo();
            if (O00000Oo3 == null || O00000Oo3.isEmpty()) {
                blo.O000000o();
                O00000Oo3 = blo.O00000o();
                if (!bnd.O000000o(O00000Oo3)) {
                    blo.O000000o().O000000o(O00000Oo3);
                } else {
                    throw new Exception();
                }
            }
            bmw.O000000o();
            int O000000o4 = SMSDK.O000000o(O00000Oo3);
            boolean O000000o5 = blv.O000000o.f13080O000000o.O000000o();
            if (O000000o4 == 1 && O00000o != null) {
                synchronized (SmAntiFraud.class) {
                    O00000o.onSuccess(O00000Oo3);
                }
            }
            if (O000000o5) {
                bln.O000000o().f13040O000000o.O000000o();
            }
            bmz.O000000o("SmAntiFraud", "unsafeCreate finish.", new Object[0]);
            return blo.O000000o().O00000Oo();
        }
        throw new IOException();
    }

    @Keep
    public static String getBase(int i) {
        if (i != 0 && 1 != i) {
            return "";
        }
        try {
            if (O00000o0 == 0) {
                bln O000000o2 = bln.O000000o();
                if (i == 0) {
                    O000000o2.O00000Oo.O000000o(false);
                } else {
                    O000000o2.O00000Oo.O000000o();
                }
            }
            return getBaseSyn();
        } catch (Exception unused) {
            return "";
        }
    }
}
