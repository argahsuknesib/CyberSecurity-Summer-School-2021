package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.server.internal.account.AccountApiImpl$1;
import com.xiaomi.smarthome.core.server.internal.api.UnAuthorRetry$1;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class fdj extends fcn {
    public final void O0000Oo0() {
        fdk.O000000o().O00000Oo();
    }

    public final String O00000Oo() {
        return fdk.O000000o().O0000Oo();
    }

    public final boolean O00000o0() {
        fdk O000000o2 = fdk.O000000o();
        return (O000000o2.f16103O000000o == null || (O000000o2.O00000Oo & 1) == 0) ? false : true;
    }

    public final boolean O00000o() {
        fdk O000000o2 = fdk.O000000o();
        return (O000000o2.f16103O000000o == null || (O000000o2.O00000Oo & 2) == 0) ? false : true;
    }

    public final boolean O00000oO() {
        return fdk.O000000o().O0000OoO();
    }

    public final String O00000oo() {
        return fdk.O000000o().O0000Ooo();
    }

    public final void O000000o(String str) {
        fdk.O000000o().O00000o0(str);
    }

    public final void O0000O0o() {
        fdk.O000000o().O00000oo();
    }

    public final boolean O0000OOo() {
        return fdk.O000000o().O0000Oo0();
    }

    public final MiServiceTokenInfo O00000Oo(String str) {
        return fdk.O000000o().O000000o(str);
    }

    public final void O000000o(String str, String str2, String str3, String str4, String str5, long j) {
        fdk.O000000o().O000000o(str, str2, str3, str4, str5, j);
    }

    public final void O000000o(String str, String str2, boolean z, String str3, fdh<Bundle, Error> fdh) {
        try {
            fcy.O000000o().O000000o("com.xiaomi.smarthome").refreshServiceToken(str, str2, z, str3, new AccountApiImpl$1(this, fdh));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void O0000Oo() {
        fdk.O000000o().O0000O0o();
    }

    public final void O0000OoO() {
        fdl O000000o2 = fdl.O000000o();
        if (O000000o2.f16104O000000o) {
            gsy.O00000Oo("UserDegree", "dirty true");
            if (!O000000o2.O00000Oo.getAndSet(true)) {
                gsy.O00000Oo("UserDegree", "mSyncOngoing set true, start req");
                new ArrayList().add(new KeyValuePair("data", new JSONObject().toString()));
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/degree").O000000o(), new fdh<NetResult, NetError>(new fss<JSONObject>() {
                    /* class _m_j.fdl.AnonymousClass1 */

                    public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                        return jSONObject;
                    }
                }, new fsm<JSONObject, fso>() {
                    /* class _m_j.fdl.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        gsy.O00000Oo("UserDegree", "degree:" + jSONObject.toString());
                        if (jSONObject == null) {
                            fdl fdl = fdl.this;
                            fdl.f16104O000000o = false;
                            fdl.O00000Oo.set(false);
                            return;
                        }
                        try {
                            fdl.O000000o(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        fdl fdl2 = fdl.this;
                        fdl2.f16104O000000o = false;
                        fdl2.O00000Oo.set(false);
                    }

                    public final void onFailure(fso fso) {
                        gsy.O00000Oo("UserDegree", "onFailure");
                        fdl fdl = fdl.this;
                        fdl.f16104O000000o = false;
                        fdl.O00000Oo.set(false);
                    }
                }) {
                    /* class _m_j.fdl.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fss f16107O000000o;
                    final /* synthetic */ fsm O00000Oo;

                    {
                        this.f16107O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onFailure(Error error) {
                        NetError netError = (NetError) error;
                        this.O00000Oo.onFailure(new fso(netError.O000000o(), netError.O00000Oo()));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        fsx.O000000o().O000000o((NetResult) obj, this.f16107O000000o, this.O00000Oo);
                    }
                });
            }
        }
    }

    public final String O000000o(Context context) {
        return ftm.O00000o0(context);
    }

    public final void O0000Ooo() {
        hxi.O0000OOo.f953O000000o.O000000o("mihome_userinfo", "type", "cUserId");
    }

    public final String O0000o00() {
        return new HashedDeviceIdUtil(CommonApplication.getAppContext()).getHashedDeviceIdNoThrow();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0311  */
    public final void O000000o(MiServiceTokenInfo miServiceTokenInfo, String str, String str2, fdh<MiServiceTokenInfo, Error> fdh) {
        int i;
        String str3;
        String str4 = str;
        String str5 = str2;
        fdh<MiServiceTokenInfo, Error> fdh2 = fdh;
        fdu O000000o2 = fdu.O000000o(miServiceTokenInfo);
        try {
            i = new JSONObject(str5).optInt("code");
            if (i == 2) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", str4);
                    hashMap.put("response", str5);
                    hashMap.put("uid", fdk.O000000o().O0000Oo());
                    String str6 = O000000o2.f16135O000000o == null ? "" : O000000o2.f16135O000000o.O00000o0;
                    hashMap.put("serviceToken", str6);
                    List<MiServiceTokenInfo> O0000oOO = CoreApi.O000000o().O0000oOO();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(";");
                    sb.append(str5);
                    sb.append(";");
                    sb.append(fdk.O000000o().O0000Oo());
                    sb.append(";");
                    sb.append(str6);
                    sb.append(";");
                    for (MiServiceTokenInfo next : O0000oOO) {
                        sb.append(next.f12086O000000o);
                        sb.append(":");
                        sb.append(next.O00000o0);
                        sb.append(";");
                    }
                    hashMap.put("all", sb.toString());
                    LogType logType = LogType.NETWORK;
                    gsy.O00000o0(logType, "UnAuthorRetry", "app_401_errorcode2 " + hashMap.toString());
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException unused2) {
            i = -1;
        }
        O000000o2.O00000o0.writeLock().lock();
        try {
            if (!O000000o2.f16135O000000o.equals(fdk.O000000o().O000000o(O000000o2.f16135O000000o.f12086O000000o))) {
                fdh2.onSuccess(O000000o2.f16135O000000o);
                LogType logType2 = LogType.NETWORK;
                gsy.O00000o0(logType2, "UnAuthorRetry", "processUnAuthorized.onSuccess " + O000000o2.f16135O000000o);
                return;
            }
            O000000o2.O00000Oo.add(fdh2);
            if (O000000o2.O00000Oo.size() != 1) {
                LogType logType3 = LogType.NETWORK;
                gsy.O00000o0(logType3, "UnAuthorRetry", "rmRefreshingLogin.size " + O000000o2.O00000Oo.size());
                O000000o2.O00000o0.writeLock().unlock();
                return;
            }
            gsy.O00000o0(LogType.NETWORK, "UnAuthorRetry", "processUnAuthorized.refreshToken json:".concat(String.valueOf(str2)));
            O000000o2.O00000o0.writeLock().unlock();
            long O00000Oo = fdk.O000000o().O00000Oo(O000000o2.f16135O000000o.f12086O000000o);
            if (i == 4) {
                Pair<Long, Boolean> O00000Oo2 = ibm.f1156O000000o.O0000OoO.O00000Oo();
                Boolean bool = null;
                if (O00000Oo2 == null || !((Boolean) O00000Oo2.second).booleanValue()) {
                    LogType logType4 = LogType.NETWORK;
                    StringBuilder sb2 = new StringBuilder("refreshTimeDiff fail ");
                    if (O00000Oo2 != null) {
                        bool = O00000Oo2.second;
                    }
                    sb2.append(bool);
                    gsy.O00000o0(logType4, "UnAuthorRetry", sb2.toString());
                    if (fsr.O0000O0o || fsr.O0000Oo0) {
                        gsy.O000000o(6, "MIIO", "refreshTimeDiff onFailure");
                    }
                    fdu.O000000o(3, str4 + ":" + str5, fdk.O000000o().O0000Oo());
                    fdu.O000000o(str4, fdk.O000000o().O0000Oo());
                    O000000o2.O000000o(new Error(-1, "refreshTimeDiff fail with 401"));
                    return;
                }
                O000000o2.f16135O000000o.O00000oO = ((Long) O00000Oo2.first).longValue();
                fdk O000000o3 = fdk.O000000o();
                O000000o2.O00000o0.writeLock().lock();
                try {
                    O000000o3.O000000o(O000000o2.f16135O000000o.f12086O000000o, O000000o2.f16135O000000o.O00000o0, O000000o2.f16135O000000o.O00000Oo, O000000o2.f16135O000000o.O00000o, O000000o2.f16135O000000o.O00000oo, O000000o2.f16135O000000o.O00000oO);
                    O000000o3.O0000O0o();
                    fdt.O000000o().O000000o(false);
                    O000000o2.O000000o((Error) null);
                } finally {
                    O000000o2.O00000o0.writeLock().unlock();
                }
            } else if (O00000Oo == 0 || System.currentTimeMillis() - O00000Oo > 10000) {
                fdk O000000o4 = fdk.O000000o();
                String O0000Oo = O000000o4.O0000Oo();
                boolean O0000OoO = O000000o4.O0000OoO();
                String O0000Ooo = O000000o4.O0000Ooo();
                IClientApi O000000o5 = fcy.O000000o().O000000o("com.xiaomi.smarthome");
                try {
                    if ((gfr.O0000OOo || gfr.O0000Oo || gfr.O0000o0o) && gfr.O0000ooo) {
                        fdu.O000000o(10, str4 + ":" + str5, O0000Oo);
                        fdu.O000000o(str4, O0000Oo);
                        O000000o2.O000000o(new Error(-1, "GlobalSetting.sFail401WithNoRefreshToken true"));
                        return;
                    }
                    if (O0000OoO) {
                        O000000o4.O0000o00();
                    }
                    fdu fdu = O000000o2;
                    fdk fdk = O000000o4;
                    String str7 = O0000Ooo;
                    String str8 = str;
                    str3 = O0000Oo;
                    try {
                        O000000o5.refreshServiceToken(O000000o2.f16135O000000o.f12086O000000o, str3, O0000OoO, O0000Ooo, new UnAuthorRetry$1(fdu, fdk, str7, str8, str2, O0000Oo));
                    } catch (Exception e) {
                        e = e;
                        LogType logType5 = LogType.NETWORK;
                        gsy.O00000o0(logType5, "UnAuthorRetry", "refreshServiceToken Exception " + Log.getStackTraceString(e));
                        if (O0000OoO) {
                        }
                        fdu.O000000o(2, str4 + ":" + str5, str3);
                        O000000o2.O000000o(new Error(-1, Log.getStackTraceString(e)));
                    }
                } catch (Exception e2) {
                    e = e2;
                    str3 = O0000Oo;
                    LogType logType52 = LogType.NETWORK;
                    gsy.O00000o0(logType52, "UnAuthorRetry", "refreshServiceToken Exception " + Log.getStackTraceString(e));
                    if (O0000OoO) {
                        O000000o4.O0000o00();
                    }
                    fdu.O000000o(2, str4 + ":" + str5, str3);
                    O000000o2.O000000o(new Error(-1, Log.getStackTraceString(e)));
                }
            } else {
                fdu.O000000o(4, str4 + ":" + str5, fdk.O000000o().O0000Oo());
                O000000o2.O000000o(new Error(-1, new StringBuilder("refreshToken once 0").toString()));
                gsy.O00000o0(LogType.NETWORK, "UnAuthorRetry", new StringBuilder("refreshToken once 0").toString());
            }
        } finally {
            O000000o2.O00000o0.writeLock().unlock();
        }
    }

    public final void O0000o0() {
        hjx.O00000o0();
    }
}
