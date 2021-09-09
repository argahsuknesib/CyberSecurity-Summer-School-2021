package _m_j;

import _m_j.eaa;
import _m_j.gsj;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.push.PushType;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class gdz extends fab {
    private static gdz O0000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17571O000000o;
    String O00000Oo;
    String O00000o;
    String O00000o0;
    String O00000oO;
    public HashMap<String, gdy> O00000oo = new HashMap<>();
    public Context O0000O0o = ServiceApplication.getAppContext();
    public Object O0000OOo = new Object();
    public Handler O0000Oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gdz.AnonymousClass1 */

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        public final void handleMessage(Message message) {
            int i = message.what;
            boolean z = true;
            if (i == 1) {
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) message.obj;
                gdz gdz = gdz.this;
                String str = miPushCommandMessage.command;
                List<String> list = miPushCommandMessage.commandArguments;
                Pair pair = null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                String str3 = (list == null || list.size() <= 1) ? null : list.get(1);
                if ("register".equals(str)) {
                    if (miPushCommandMessage.resultCode == 0) {
                        gdz.f17571O000000o = str2;
                        gsy.O00000o0(LogType.PUSH, "PushManager", "receive push id - " + gdz.f17571O000000o);
                        gdz.O00000o();
                        gsy.O00000Oo(LogType.GENERAL, "SmartHome-Push", "registerLoggedPushId: ");
                        String str4 = "";
                        String O000000o2 = gpv.O000000o("sh_pref_key_logged_reged_pushid_deviceid", str4);
                        if (!TextUtils.isEmpty(O000000o2)) {
                            String[] split = O000000o2.split("@\\$##\\$@");
                            if (split.length >= 2) {
                                pair = new Pair(split[0], split[1]);
                            }
                        }
                        boolean O0000O0o = ftn.O0000O0o(gdz.O0000O0o);
                        grr.O000000o();
                        String O000000o3 = grr.O000000o(gdz.O0000O0o, O0000O0o);
                        if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && !TextUtils.isEmpty((CharSequence) pair.second) && ((String) pair.first).equalsIgnoreCase(gdz.f17571O000000o) && ((String) pair.second).equalsIgnoreCase(O000000o3)) {
                            z = false;
                        }
                        gsy.O00000o0(LogType.GENERAL, "SmartHome-Push", "registerLoggedPushId shouldRegister=" + z + ",mPushId=" + gdz.f17571O000000o);
                        if (z && !TextUtils.isEmpty(gdz.f17571O000000o)) {
                            String O0000o0o = dzs.O0000o0o(ServiceApplication.getAppContext());
                            ged O000000o4 = ged.O000000o();
                            String str5 = gdz.f17571O000000o;
                            AnonymousClass6 r6 = new fsm<JSONObject, fso>(O000000o3) {
                                /* class _m_j.gdz.AnonymousClass6 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ String f17578O000000o;

                                {
                                    this.f17578O000000o = r2;
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    if (jSONObject.optBoolean("result", false)) {
                                        gdz gdz = gdz.this;
                                        String str = this.f17578O000000o;
                                        gpv.O00000Oo("sh_pref_key_logged_reged_pushid_deviceid", gdz.f17571O000000o + "@$##$@" + str);
                                    }
                                    gsy.O00000Oo("SmartHome-Push", "register logged pushid onResponse: ".concat(String.valueOf(jSONObject)));
                                }

                                public final void onFailure(fso fso) {
                                    String str;
                                    try {
                                        gsy.O00000Oo("SmartHome-Push", "register logged pushid onSuccess: failure");
                                        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                                        StringBuilder sb = new StringBuilder("fail regis tering push to miot:");
                                        if (fso == null) {
                                            str = null;
                                        } else {
                                            str = fso.O000000o() + "-" + fso.O00000Oo();
                                        }
                                        sb.append(str);
                                        sb.append(",mPushId=");
                                        sb.append(gdz.this.f17571O000000o);
                                        sb.append(",islogin=");
                                        sb.append(CoreApi.O000000o().O0000Ooo());
                                        sb.append(",server=");
                                        sb.append(O0000ooO == null ? "" : O0000ooO.f7546O000000o);
                                        sb.append(",userid=");
                                        sb.append(CoreApi.O000000o().O0000o());
                                        String sb2 = sb.toString();
                                        gsy.O00000o0(LogType.GENERAL, "SmartHome-Push", sb2);
                                        if (!ftn.O00000oO(gdz.this.O0000O0o)) {
                                            dgn.O00000Oo("push logged ", sb2);
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        gsy.O00000o0(LogType.GENERAL, "SmartHome-Push", "registerLoggedPushId exception:" + e.getMessage());
                                    }
                                }
                            };
                            gsy.O00000Oo("push logged", "registerLoggedPushId: ");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("deviceid", O000000o3);
                                jSONObject.put("pushid", str5);
                                jSONObject.put("region", O0000o0o);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                str4 = hsk.O000000o(ServiceApplication.getAppContext()) + "/app/v2/mipush/unlogged_reg?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                            gsg.O00000Oo(new gsj.O000000o().O000000o("GET").O00000Oo(str4).O000000o(), new gsl(r6) {
                                /* class _m_j.ged.AnonymousClass1 */

                                /* renamed from: O000000o */
                                final /* synthetic */ fsm f17595O000000o;

                                public final void onSuccess(Object obj, Response response) {
                                }

                                {
                                    this.f17595O000000o = r2;
                                }

                                public final void processResponse(Response response) {
                                    try {
                                        this.f17595O000000o.onSuccess(new JSONObject(response.body().string()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        gsy.O00000Oo("push logged", "processResponse: " + response.toString() + " ; " + Log.getStackTraceString(e));
                                    }
                                }

                                public final void processFailure(Call call, IOException iOException) {
                                    gsy.O00000Oo("push logged", "processFailure: ");
                                    this.f17595O000000o.onFailure(new fso(-1, null));
                                }

                                public final void onFailure(gsf gsf, Exception exc, Response response) {
                                    this.f17595O000000o.onFailure(new fso(-1, null));
                                }
                            });
                        }
                    }
                } else if ("set-alias".equals(str)) {
                    if (miPushCommandMessage.resultCode == 0) {
                        gdz.O00000o0 = str2;
                    }
                } else if ("unset-alias".equals(str)) {
                    if (miPushCommandMessage.resultCode == 0) {
                        gdz.O00000o0 = str2;
                    }
                } else if ("subscribe-topic".equals(str)) {
                    if (miPushCommandMessage.resultCode == 0) {
                        gdz.O00000Oo = str2;
                    }
                } else if ("unsubscibe-topic".equals(str)) {
                    if (miPushCommandMessage.resultCode == 0) {
                        gdz.O00000Oo = str2;
                    }
                } else if ("accept-time".equals(str) && miPushCommandMessage.resultCode == 0) {
                    gdz.O00000o = str2;
                    gdz.O00000oO = str3;
                }
            } else if (i == 2) {
                MiPushMessage miPushMessage = (MiPushMessage) message.obj;
                gdz gdz2 = gdz.this;
                if (gdz2.O000000o(miPushMessage)) {
                    if (miPushMessage != null && (gfr.O0000Oo || gfr.O0000OOo)) {
                        gsy.O000000o(LogType.PUSH, "PushReceiver", "PushManager-->  MessageId: " + miPushMessage.messageId + "  Content: " + miPushMessage.content);
                    }
                    String str6 = miPushMessage.content;
                    gsy.O00000Oo("PushManager", str6);
                    JSONObject jSONObject2 = new JSONObject(str6);
                    String optString = jSONObject2.optString("msgid");
                    String optString2 = jSONObject2.optString("type");
                    String optString3 = jSONObject2.optString("body");
                    String optString4 = jSONObject2.optString("up_info");
                    gdy gdy = gdz2.O00000oo.get(optString2);
                    if (PushType.DEVICE.getValue().equals(optString2) || PushType.DEVICE_BATCH.getValue().equals(optString2)) {
                        hxi.O00000o.O000000o(optString2, optString, System.currentTimeMillis());
                    }
                    if (gdy != null) {
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.GENERAL, "PushManager", "process - ".concat(String.valueOf(optString3)));
                        }
                        try {
                            if (miPushMessage.isNotified) {
                                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0(optString, optString2, optString3, gdy, optString4) {
                                    /* class _m_j.gdz.AnonymousClass7 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ String f17579O000000o;
                                    final /* synthetic */ String O00000Oo;
                                    final /* synthetic */ gdy O00000o;
                                    final /* synthetic */ String O00000o0;
                                    final /* synthetic */ String O00000oO;

                                    {
                                        this.f17579O000000o = r2;
                                        this.O00000Oo = r3;
                                        this.O00000o0 = r4;
                                        this.O00000o = r5;
                                        this.O00000oO = r6;
                                    }

                                    public final void onCoreReady() {
                                        try {
                                            new JSONObject().put("msgid", this.f17579O000000o);
                                            hxi.f950O000000o.O000000o(this.O00000Oo, this.f17579O000000o, this.O00000o0);
                                            this.O00000o.onReceiveNotifiedMessage(this.f17579O000000o, this.O00000o0);
                                            if (!TextUtils.isEmpty(this.O00000oO)) {
                                                hxi.O00000o.O0000Ooo(this.O00000oO);
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                });
                            } else {
                                gdy.onReceiveMessage(optString, optString3);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        }
    };
    public boolean O0000Oo0 = false;
    public AtomicBoolean O0000OoO = new AtomicBoolean(true);
    private long O0000Ooo = -1;
    private HashMap<String, Long> O0000o00 = new HashMap<>();

    public static gdz O000000o() {
        if (O0000o0 == null) {
            O0000o0 = new gdz();
        }
        return O0000o0;
    }

    private gdz() {
    }

    public final void O00000Oo() {
        super.O00000Oo();
        this.O0000Oo.postDelayed(new Runnable() {
            /* class _m_j.gdz.AnonymousClass2 */

            public final void run() {
                gdz.this.O00000o0();
            }
        }, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
    }

    public final void O00000o0() {
        boolean z;
        LogType logType = LogType.GENERAL;
        gsy.O00000Oo(logType, "SmartHome-Push", "registerPushService: shouldInitPush(): " + O00000oO());
        if (O00000oO()) {
            synchronized (this.O0000OOo) {
                z = this.O0000Oo0;
                if (!this.O0000Oo0) {
                    this.O0000Oo0 = true;
                }
            }
            if (!z) {
                dzr.O000000o(this.O0000O0o, new dut() {
                    /* class _m_j.gdz.AnonymousClass3 */

                    public final void O000000o(String str, Throwable th) {
                        Log.d("SmartHome-Push", str, th);
                    }

                    public final void O000000o(String str) {
                        gsy.O000000o(3, "SmartHome-Push", str);
                    }
                });
                O000000o(PushType.ADS, new gef());
                O000000o(PushType.DEVICE, gek.O000000o());
                O000000o(PushType.DEVICE_BATCH, frc.O000000o());
                O000000o(PushType.SCENE, new geb());
                O000000o(PushType.COMMON, new geg());
                O000000o(PushType.THIRDPARTYAPI, ezp.O000000o());
                O000000o(PushType.USER_BANNER_PROP, ezp.O00000Oo());
                O000000o(PushType.SCENE_STATUS, ezp.O00000o0());
                O000000o(PushType.DEVICE_NEW, new gej());
                O000000o(PushType.AIOT_BIND, new gei());
                O000000o(PushType.INNER_JUMP, new geh());
                if (!CoreApi.O000000o().O0000oo0()) {
                    O000000o(PushType.SHOP, new htb());
                }
                O000000o(PushType.HOME_MEMBER, new gel());
                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                    /* class _m_j.gdz.AnonymousClass4 */

                    public final void onCoreReady() {
                        new Thread(new Runnable() {
                            /* class _m_j.gdz.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                PushChannelRegion pushChannelRegion;
                                if (ftn.O00000o(CoreApi.O000000o().O0000ooO())) {
                                    pushChannelRegion = PushChannelRegion.Europe;
                                } else if (CoreApi.O000000o().O0000oo0()) {
                                    pushChannelRegion = PushChannelRegion.Global;
                                } else {
                                    pushChannelRegion = PushChannelRegion.China;
                                }
                                LogType logType = LogType.GENERAL;
                                gsy.O00000Oo(logType, "PushManager", "start register to push - " + pushChannelRegion.name());
                                eaa.O000000o o000000o = new eaa.O000000o();
                                try {
                                    if (!grr.O00000oO() && Class.forName("com.huawei.hms.support.api.push.PushReceiver") != null) {
                                        o000000o.O00000Oo = true;
                                        gsy.O00000o0(LogType.PUSH, "SmartHome-Push", "load hms");
                                    }
                                } catch (Exception unused) {
                                    gsy.O00000o0(LogType.PUSH, "SmartHome-Push", "not contain hms");
                                }
                                o000000o.O00000o = true;
                                if (pushChannelRegion != PushChannelRegion.China && gfr.O0000oO0) {
                                    eyd O000000o2 = eyo.O000000o();
                                    if (O000000o2 != null) {
                                        O000000o2.setAutoInitEnabled(true);
                                    }
                                    o000000o.f15115O000000o = pushChannelRegion;
                                    o000000o.O00000o0 = true;
                                }
                                dzs.O000000o(gdz.this.O0000O0o, "2882303761517233197", "5541723310197", new eaa(o000000o, (byte) 0));
                            }
                        }).start();
                    }
                });
            }
        }
    }

    private boolean O00000oO() {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.O0000O0o.getSystemService("activity")).getRunningAppProcesses();
            String packageName = this.O0000O0o.getPackageName();
            int myPid = Process.myPid();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid && packageName.equals(next.processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(MiPushMessage miPushMessage) {
        try {
            String optString = new JSONObject(miPushMessage.content).optString("msgid");
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            if (this.O0000o00.get(optString) != null) {
                this.O0000o00.remove(optString);
                return false;
            }
            if (this.O0000o00.size() >= 5) {
                String str = "";
                Long l = Long.MAX_VALUE;
                for (Map.Entry next : this.O0000o00.entrySet()) {
                    Long l2 = (Long) next.getValue();
                    if (l2.longValue() < l.longValue()) {
                        str = (String) next.getKey();
                        l = l2;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    this.O0000o00.remove(str);
                }
            }
            this.O0000o00.put(optString, Long.valueOf(System.currentTimeMillis()));
            return true;
        } catch (JSONException unused) {
        }
    }

    public final void O000000o(PushType pushType, gdy gdy) {
        if (gdy != null) {
            this.O00000oo.put(pushType.getValue(), gdy);
        }
    }

    public final void O00000o() {
        String O000000o2 = gpv.O000000o("sh_pref_key_reged_pushid_encrypted_user_id", "");
        final String O0000o = CoreApi.O000000o().O0000o();
        String O000000o3 = gpv.O000000o("sh_pref_key_reged_pushid_deviceid", "");
        boolean z = true;
        Pair pair = null;
        if (!TextUtils.isEmpty(O000000o3)) {
            String[] split = O000000o3.split("@\\$##\\$@");
            if (split.length >= 2) {
                pair = new Pair(split[0], split[1]);
            }
        }
        boolean O0000O0o2 = ftn.O0000O0o(this.O0000O0o);
        grr.O000000o();
        final String O000000o4 = grr.O000000o(this.O0000O0o, O0000O0o2);
        if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && !TextUtils.isEmpty((CharSequence) pair.second) && ((String) pair.first).equalsIgnoreCase(this.f17571O000000o) && ((String) pair.second).equalsIgnoreCase(O000000o4) && !TextUtils.isEmpty(O000000o2) && TextUtils.equals(O000000o2, O0000o)) {
            z = false;
        }
        LogType logType = LogType.GENERAL;
        gsy.O00000o0(logType, "SmartHome-Push", "registerPushId: shouldRegister: " + z + ",mPushId=" + this.f17571O000000o + ",isLogin=" + CoreApi.O000000o().O0000Ooo());
        if (z && !TextUtils.isEmpty(this.f17571O000000o) && CoreApi.O000000o().O0000Ooo()) {
            String O0000o0o = dzs.O0000o0o(ServiceApplication.getAppContext());
            ged.O000000o();
            ged.O000000o(this.O0000O0o, this.f17571O000000o, O000000o4, O0000o0o, new fsm<Void, fso>() {
                /* class _m_j.gdz.AnonymousClass5 */

                public final void onFailure(fso fso) {
                    String str;
                    try {
                        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                        StringBuilder sb = new StringBuilder("fail registering push to miot:");
                        if (fso == null) {
                            str = null;
                        } else {
                            str = fso.O000000o() + "-" + fso.O00000Oo();
                        }
                        sb.append(str);
                        sb.append(",mPushId=");
                        sb.append(gdz.this.f17571O000000o);
                        sb.append(",islogin=");
                        sb.append(CoreApi.O000000o().O0000Ooo());
                        sb.append(",server=");
                        sb.append(O0000ooO == null ? "" : O0000ooO.f7546O000000o);
                        sb.append(",userid=");
                        sb.append(CoreApi.O000000o().O0000o());
                        String sb2 = sb.toString();
                        gsy.O00000o0(LogType.GENERAL, "SmartHome-Push", sb2);
                        if (!ftn.O00000oO(gdz.this.O0000O0o)) {
                            dgn.O00000Oo("push", sb2);
                        }
                        if (gdz.this.O0000OoO.compareAndSet(true, false)) {
                            gsy.O00000Oo(LogType.GENERAL, "SmartHome-Push", "onFailure: try registerPushId again: " + fso.O00000Oo());
                            gdz.this.O00000o();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            gsy.O00000o0(LogType.GENERAL, "SmartHome-Push", "registerPushId exception:" + e.getMessage());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    gdz gdz = gdz.this;
                    String str = O000000o4;
                    gpv.O00000Oo("sh_pref_key_reged_pushid_deviceid", gdz.f17571O000000o + "@$##$@" + str);
                    String str2 = O0000o;
                    if (!TextUtils.isEmpty(str2)) {
                        gpv.O00000Oo("sh_pref_key_reged_pushid_encrypted_user_id", str2);
                    }
                }
            });
        }
    }
}
