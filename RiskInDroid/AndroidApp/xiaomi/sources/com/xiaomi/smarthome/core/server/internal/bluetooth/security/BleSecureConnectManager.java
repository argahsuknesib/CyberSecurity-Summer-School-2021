package com.xiaomi.smarthome.core.server.internal.bluetooth.security;

import _m_j.fap;
import _m_j.feb;
import _m_j.fec;
import _m_j.feo;
import _m_j.feq;
import _m_j.fer;
import _m_j.fes;
import _m_j.ffr;
import _m_j.fgn;
import _m_j.fgo;
import _m_j.fgq;
import _m_j.fgx;
import _m_j.fgy;
import _m_j.fgz;
import _m_j.fhb;
import _m_j.fhf;
import _m_j.fhi;
import _m_j.fhk;
import _m_j.fit;
import _m_j.fiv;
import _m_j.fll;
import _m_j.fte;
import _m_j.gle;
import _m_j.glw;
import _m_j.gnk;
import _m_j.got;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class BleSecureConnectManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public static ConcurrentMap<String, O00000Oo> f6877O000000o = new ConcurrentHashMap();
    private static final BleConnectOptions O00000Oo;
    private static final SecureConnectOptions O00000o0;

    static {
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 3;
        o000000o.O00000o0 = 25000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 20000;
        O00000Oo = o000000o.O000000o();
        SecureConnectOptions.O000000o o000000o2 = new SecureConnectOptions.O000000o();
        o000000o2.f6884O000000o = O00000Oo;
        O00000o0 = o000000o2.O000000o();
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f6882O000000o;
        fgn O00000Oo;
        ISecureConnectHandler O00000o0;

        O00000Oo(String str, fgn fgn, ISecureConnectHandler iSecureConnectHandler) {
            this.f6882O000000o = str;
            this.O00000Oo = fgn;
            this.O00000o0 = iSecureConnectHandler;
        }
    }

    public static ISecureConnectHandler O000000o(String str, SecureConnectOptions secureConnectOptions, gle gle) {
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("SecureConnect for %s error: previous ongoing!!", fte.O000000o(str)));
            gle.O00000o(-13, null);
            return null;
        }
        int O00000o02 = feb.O00000o0(str);
        if (O00000o02 <= 0) {
            fte.O00000Oo(String.format("SecureConnect for %s error: productId invalid!!", fte.O000000o(str)));
            gle.O00000o(-12, null);
            return null;
        }
        byte[] O0000o0o = ffr.O0000o0o(str);
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        BleConnectOptions bleConnectOptions = secureConnectOptions.f6883O000000o;
        fgn fgy = got.O00000o(O0000o0o) ? new fgy(str, O00000o02, bleConnectOptions) : new fgx(str, O00000o02, O0000o0o, bleConnectOptions);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, fgy);
        f6877O000000o.put(str, new O00000Oo(str, fgy, secureConnectHandler));
        fgy.O000000o(o000000o);
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O00000Oo(String str, SecureConnectOptions secureConnectOptions, gle gle) {
        fgn fgn = null;
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("securityChipConnect for %s error: previous ongoing!!", fte.O000000o(str)));
            gle.O00000o(-13, null);
            return null;
        }
        final int O00000o02 = feb.O00000o0(str);
        if (O00000o02 <= 0) {
            fte.O00000Oo(String.format("securityChipConnect for %s error: productId invalid!!", fte.O000000o(str)));
            gle.O00000o(-12, null);
            return null;
        }
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        final BleConnectOptions bleConnectOptions = secureConnectOptions.f6883O000000o;
        byte[] O0000oO0 = ffr.O0000oO0(str);
        String O00000oo = ffr.O00000oo(str);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, null);
        O00000Oo o00000Oo = new O00000Oo(str, null, secureConnectHandler);
        f6877O000000o.put(str, o00000Oo);
        if (!got.O00000o(O0000oO0)) {
            String O0000oO = ffr.O0000oO(str);
            int O0000oOO = ffr.O0000oOO(str);
            if (O0000oOO == 0) {
                fgn = new fhf(str, O00000o02, O0000oO0, bleConnectOptions);
            } else if (TextUtils.isEmpty(O0000oO)) {
                o000000o.O00000o(-38, null);
            } else {
                fgn = new fhf(str, O00000o02, got.O000000o(fll.O00000Oo(O0000oO, got.O00000o0(O0000oO0), O0000oOO)), bleConnectOptions);
            }
        } else if (TextUtils.isEmpty(O00000oo)) {
            fgn = new fhi(str, O00000o02, bleConnectOptions);
        } else {
            final String str2 = str;
            final SecureConnectHandler secureConnectHandler2 = secureConnectHandler;
            final O00000Oo o00000Oo2 = o00000Oo;
            final O000000o o000000o2 = o000000o;
            fgo.O000000o(O00000oo, new feo<JSONObject, fes>() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.security.BleSecureConnectManager.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    String optString = jSONObject != null ? jSONObject.optString("key") : "";
                    if (!TextUtils.isEmpty(optString)) {
                        ffr.O0000Oo(str2, optString);
                        int optInt = jSONObject.optInt("encrypt_type", 0);
                        if (optInt == 0) {
                            fhf fhf = new fhf(str2, O00000o02, got.O000000o(optString), bleConnectOptions);
                            secureConnectHandler2.setLauncher(fhf);
                            o00000Oo2.O00000Oo = fhf;
                            fhf.O000000o(o000000o2);
                            return;
                        }
                        String O0000oO = ffr.O0000oO(str2);
                        if (TextUtils.isEmpty(O0000oO)) {
                            gle gle = o000000o2;
                            if (gle != null) {
                                gle.O00000o(-38, null);
                                return;
                            }
                            return;
                        }
                        fhf fhf2 = new fhf(str2, O00000o02, got.O000000o(fll.O00000Oo(O0000oO, optString, optInt)), bleConnectOptions);
                        secureConnectHandler2.setLauncher(fhf2);
                        o00000Oo2.O00000Oo = fhf2;
                        fhf2.O000000o(o000000o2);
                        return;
                    }
                    fhi fhi = new fhi(str2, O00000o02, bleConnectOptions);
                    secureConnectHandler2.setLauncher(fhi);
                    o00000Oo2.O00000Oo = fhi;
                    fhi.O000000o(o000000o2);
                }

                public final void O000000o(fes fes) {
                    fte.O00000Oo(String.format("securityChipConnect for %s error: getOwnLtmk failed(%s), try to register", fte.O000000o(str2), fes.O00000Oo));
                    fhi fhi = new fhi(str2, O00000o02, bleConnectOptions);
                    secureConnectHandler2.setLauncher(fhi);
                    o00000Oo2.O00000Oo = fhi;
                    fhi.O000000o(o000000o2);
                }
            });
        }
        if (fgn != null) {
            secureConnectHandler.setLauncher(fgn);
            o00000Oo.O00000Oo = fgn;
            fgn.O000000o(o000000o);
        }
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O000000o(String str, String str2, String str3, int i, SecureConnectOptions secureConnectOptions, gle gle) {
        gle gle2;
        O00000Oo remove = f6877O000000o.remove(str);
        if (!(remove == null || remove.O00000Oo == null || (gle2 = remove.O00000Oo.O00000oO) == null)) {
            remove.O00000Oo.O00000oO = null;
            Bundle bundle = new Bundle();
            bundle.putString("result", "new request");
            glw.O000000o().disconnect(str);
            gle2.O00000o(-2, bundle);
            fte.O00000Oo(String.format("securityChipConnect for %s previous cancel for new request!!", fte.O000000o(str)));
        }
        int O00000o02 = feb.O00000o0(str);
        if (O00000o02 <= 0) {
            fte.O00000Oo(String.format("securityChipConnect for %s error: productId invalid!!", fte.O000000o(str)));
            gle.O00000o(-12, null);
            return null;
        }
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        fhf fhf = new fhf(str, O00000o02, got.O000000o(fll.O00000Oo(str2, str3, i)), secureConnectOptions.f6883O000000o);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, fhf);
        f6877O000000o.put(str, new O00000Oo(str, fhf, secureConnectHandler));
        fhf.O000000o(o000000o);
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O00000o0(String str, SecureConnectOptions secureConnectOptions, gle gle) {
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("securityChipSharedDeviceConnect for %s error: previous ongoing!!", fte.O000000o(str)));
            gle.O00000o(-13, null);
            return null;
        }
        int O00000o02 = feb.O00000o0(str);
        if (O00000o02 <= 0) {
            fte.O00000Oo(String.format("securityChipSharedDeviceConnect for %s error: productId invalid!!", fte.O000000o(str)));
            gle.O00000o(-12, null);
            return null;
        }
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        fhk fhk = new fhk(str, O00000o02, secureConnectOptions.f6883O000000o);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, fhk);
        f6877O000000o.put(str, new O00000Oo(str, fhk, secureConnectHandler));
        fhk.O000000o(o000000o);
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O00000o(String str, SecureConnectOptions secureConnectOptions, gle gle) {
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("bleMeshBind for %s error: previous ongoing!!", fte.O000000o(str)));
            gle.O00000o(-13, null);
            return null;
        }
        int O00000o02 = feb.O00000o0(str);
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        fhb fhb = new fhb(str, O00000o02, secureConnectOptions.f6883O000000o);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, fhb);
        f6877O000000o.put(str, new O00000Oo(str, fhb, secureConnectHandler));
        fhb.O000000o(o000000o);
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O000000o(String str, String str2, String str3, SecureConnectOptions secureConnectOptions, gle gle) {
        SecureConnectOptions secureConnectOptions2;
        gle gle2 = gle;
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("bleMeshConnect for %s error: previous ongoing!!", fte.O000000o(str)));
            gle2.O00000o(-13, null);
            return null;
        }
        final int O00000o02 = feb.O00000o0(str);
        final O000000o o000000o = new O000000o(str, gle2);
        if (secureConnectOptions == null) {
            secureConnectOptions2 = O00000o0;
        } else {
            secureConnectOptions2 = secureConnectOptions;
        }
        final BleConnectOptions bleConnectOptions = secureConnectOptions2.f6883O000000o;
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, null);
        final O00000Oo o00000Oo = new O00000Oo(str, null, secureConnectHandler);
        String O0000o0O = ffr.O0000o0O(str);
        String O0000o = ffr.O0000o(str);
        f6877O000000o.put(str, o00000Oo);
        if (!TextUtils.equals(O0000o0O, str3) || TextUtils.isEmpty(O0000o)) {
            final String str4 = str;
            final String str5 = str3;
            final SecureConnectHandler secureConnectHandler2 = secureConnectHandler;
            final AnonymousClass2 r1 = new feo<String, fes>() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.security.BleSecureConnectManager.AnonymousClass2 */

                public final /* synthetic */ void O000000o(Object obj) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        ffr.O0000Oo0(str4, str5);
                        ffr.O0000Oo(str4, str);
                        fgz fgz = new fgz(str4, O00000o02, got.O000000o(str), bleConnectOptions);
                        secureConnectHandler2.setLauncher(fgz);
                        o00000Oo.O00000Oo = fgz;
                        fgz.O000000o(o000000o);
                        return;
                    }
                    fte.O00000Oo(String.format("bleMeshConnect for %s error: gatt ltmk is null", fte.O000000o(str4)));
                    gle gle = o000000o;
                    if (gle != null) {
                        gle.O00000o(-15, null);
                    }
                }

                public final void O000000o(fes fes) {
                    fte.O00000Oo(String.format("bleMeshConnect for %s error: getGattLtmk failed(%s)", fte.O000000o(str4), fes.O00000Oo));
                    gle gle = o000000o;
                    if (gle != null) {
                        gle.O00000o(-15, null);
                    }
                }
            };
            AnonymousClass3 r12 = new feo<String, fes>() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.security.BleSecureConnectManager.AnonymousClass3 */

                public final /* synthetic */ void O000000o(Object obj) {
                    String str;
                    try {
                        str = new JSONObject((String) obj).optString("gatt_ltmk");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        str = "";
                    }
                    feo feo = r1;
                    if (feo != null) {
                        feo.O000000o(str);
                    }
                }

                public final void O000000o(fes fes) {
                    feo feo = r1;
                    if (feo != null) {
                        feo.O000000o(fes);
                    }
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
            gnk.O00000o0(String.format("authBleMesh: [%s]", jSONObject));
            BleNetRequest.O000000o o000000o2 = new BleNetRequest.O000000o();
            o000000o2.f6799O000000o = "POST";
            o000000o2.O00000Oo = "/v2/blemesh/query_dev";
            o000000o2.O00000o0 = arrayList;
            fec.O00000o0().O000000o(o000000o2.O000000o(), new fer(new feq<String>() {
                /* class _m_j.fgo.AnonymousClass20 */

                public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                    gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                    return jSONObject.toString();
                }
            }, r12) {
                /* class _m_j.fgo.AnonymousClass21 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ feq f16285O000000o;
                final /* synthetic */ feo O00000Oo;

                {
                    this.f16285O000000o = r1;
                    this.O00000Oo = r2;
                }

                public final void O000000o(String str) {
                    fet.O000000o().O000000o(str, this.f16285O000000o, this.O00000Oo);
                }

                public final void O000000o(int i, String str) {
                    feo feo = this.O00000Oo;
                    if (feo != null) {
                        feo.O000000o(new fes(i, str));
                    }
                }
            });
        } else {
            fgz fgz = new fgz(str, O00000o02, got.O000000o(O0000o), bleConnectOptions);
            secureConnectHandler.setLauncher(fgz);
            o00000Oo.O00000Oo = fgz;
            fgz.O000000o(o000000o);
        }
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O00000oO(String str, SecureConnectOptions secureConnectOptions, gle gle) {
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("bleStandardAuthBind for %s error: previous ongoing!!", fte.O000000o(str)));
            gle.O00000o(-13, null);
            return null;
        }
        int O00000o02 = feb.O00000o0(str);
        if (O00000o02 <= 0) {
            fte.O00000Oo(String.format("bleStandardAuthBind for %s error: productId invalid!!", fte.O000000o(str)));
            gle.O00000o(-12, null);
            return null;
        }
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        fiv fiv = new fiv(str, O00000o02, secureConnectOptions.f6883O000000o);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, fiv);
        f6877O000000o.put(str, new O00000Oo(str, fiv, secureConnectHandler));
        fiv.O000000o(o000000o);
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O00000oo(String str, SecureConnectOptions secureConnectOptions, gle gle) {
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("bleStandardAuthConnect for %s error: previous ongoing!!", fte.O000000o(str)));
            gle.O00000o(-13, null);
            return null;
        }
        int O00000o02 = feb.O00000o0(str);
        if (O00000o02 <= 0) {
            fte.O00000Oo(String.format("bleStandardAuthConnect for %s error: productId invalid!!", fte.O000000o(str)));
            gle.O00000o(-12, null);
            return null;
        }
        byte[] O0000o0o = ffr.O0000o0o(str);
        if (got.O00000o(O0000o0o)) {
            fte.O00000Oo(String.format("bleStandardAuthConnect for %s error: token is empty!!", fte.O000000o(str)));
            gle.O00000o(-54, null);
            return null;
        }
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        fit fit = new fit(str, O00000o02, O0000o0o, secureConnectOptions.f6883O000000o);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, fit);
        f6877O000000o.put(str, new O00000Oo(str, fit, secureConnectHandler));
        fit.O000000o(o000000o);
        return secureConnectHandler;
    }

    public static ISecureConnectHandler O000000o(String str, BleComboWifiConfig bleComboWifiConfig, SecureConnectOptions secureConnectOptions, gle gle) {
        if (f6877O000000o.containsKey(str)) {
            fte.O00000Oo(String.format("bleComboStandardAuth for %s error: previous ongoing!!", fte.O000000o(str)));
            gle.O00000o(-13, null);
            return null;
        }
        O000000o o000000o = new O000000o(str, gle);
        if (secureConnectOptions == null) {
            secureConnectOptions = O00000o0;
        }
        fgq fgq = new fgq(str, feb.O00000o0(str), bleComboWifiConfig, secureConnectOptions.f6883O000000o);
        SecureConnectHandler secureConnectHandler = new SecureConnectHandler(str, fgq);
        f6877O000000o.put(str, new O00000Oo(str, fgq, secureConnectHandler));
        fgq.O000000o(o000000o);
        return secureConnectHandler;
    }

    public static void O000000o(String str) {
        f6877O000000o.remove(str);
    }

    static class SecureConnectHandler extends ISecureConnectHandler.Stub {
        fgn launcher;
        String mac;

        SecureConnectHandler(String str, fgn fgn) {
            this.mac = str;
            this.launcher = fgn;
        }

        public void setLauncher(fgn fgn) {
            this.launcher = fgn;
        }

        public void cancel() throws RemoteException {
            fgn fgn = this.launcher;
            if (fgn != null) {
                fgn.O000000o();
            }
        }
    }

    static class O000000o implements gle {

        /* renamed from: O000000o  reason: collision with root package name */
        String f6881O000000o;
        gle O00000Oo;

        O000000o(String str, gle gle) {
            this.f6881O000000o = str;
            this.O00000Oo = gle;
        }

        public final void O000000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("ConnectResponse onConnectResponse: code = %d", Integer.valueOf(i)));
            gle gle = this.O00000Oo;
            if (gle != null) {
                gle.O000000o(i, bundle);
            }
        }

        public final void O00000Oo(int i, Bundle bundle) {
            fte.O00000Oo(String.format("ConnectResponse onAuthResponse: code = %d", Integer.valueOf(i)));
            gle gle = this.O00000Oo;
            if (gle != null) {
                gle.O00000Oo(i, bundle);
            }
        }

        public final void O00000o0(int i, Bundle bundle) {
            fte.O00000Oo(String.format("ConnectResponse onBindResponse: code = %d", Integer.valueOf(i)));
            gle gle = this.O00000Oo;
            if (gle != null) {
                gle.O00000o0(i, bundle);
            }
        }

        public final void O00000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("ConnectResponse onLastResponse: code = %d", Integer.valueOf(i)));
            BleSecureConnectManager.f6877O000000o.remove(this.f6881O000000o);
            if (i == 0) {
                MMKV.O000000o(fap.O000000o.f16027O000000o.O000000o(this.f6881O000000o).f16028O000000o).O000000o("KEY.CONNECT.STATUS", 3);
            } else {
                fap.O000000o.f16027O000000o.O000000o(this.f6881O000000o).O000000o();
            }
            gle gle = this.O00000Oo;
            if (gle != null) {
                gle.O00000o(i, bundle);
            }
        }
    }
}
