package _m_j;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cih {

    /* renamed from: O000000o  reason: collision with root package name */
    static SimpleDateFormat f13895O000000o;
    static SimpleDateFormat O00000Oo;
    private static Runnable O00000o = $$Lambda$cih$BgMcSWPR9bDj6lYNBq44fqbCC7E.INSTANCE;
    private static AtomicBoolean O00000o0 = new AtomicBoolean(false);
    private static final Object O00000oO = new Object();

    /* access modifiers changed from: private */
    public static /* synthetic */ void O0000Oo() {
        Iterator<Map.Entry<String, String>> it = XmStreamClient.sDelayedDisconnectDevices.entrySet().iterator();
        while (it.hasNext()) {
            XmStreamClient.disconnectDevice(XmPluginHostApi.instance().getDeviceByDid((String) it.next().getValue()));
            it.remove();
        }
    }

    public static void O000000o(Activity activity, final cid cid, final List<TimeItem> list, final XQProgressDialog xQProgressDialog, final Callback<Void> callback) {
        if (list == null || list.size() == 0) {
            fag.O000000o(activity, activity.getString(R.string.bottom_action_tip));
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
        builder.O000000o((int) R.string.delete_title);
        if (list.size() == 1) {
            if (f13895O000000o == null || O00000Oo == null) {
                f13895O000000o = new SimpleDateFormat(activity.getResources().getString(R.string.simple_date_format_mm_dd_hh_mm));
                O00000Oo = new SimpleDateFormat(activity.getResources().getString(R.string.simple_date_format_hh_mm));
            }
            builder.O00000Oo("(" + mi.O00000oO(list.get(0).f5243O000000o) + " " + O00000Oo.format(new Date(list.get(0).f5243O000000o)) + "-" + O00000Oo.format(new Date(list.get(0).O00000o0)) + ")");
        }
        builder.O000000o((int) R.string.local_file_delete, new DialogInterface.OnClickListener() {
            /* class _m_j.cih.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                XQProgressDialog xQProgressDialog = xQProgressDialog;
                if (xQProgressDialog != null) {
                    xQProgressDialog.show();
                }
                cid cid = cid;
                if (cid == null || !cid.O00000o()) {
                    clr O0000OOo = cid.O0000OOo();
                    if (O0000OOo != null) {
                        List list = list;
                        AnonymousClass2 r0 = new Callback<JSONObject>() {
                            /* class _m_j.cih.AnonymousClass1.AnonymousClass2 */

                            public final void onFailure(int i, String str) {
                                if (callback != null) {
                                    callback.onFailure(i, str);
                                }
                            }

                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                if (callback != null) {
                                    callback.onSuccess(null);
                                }
                            }
                        };
                        if (list == null || list.size() == 0) {
                            r0.onFailure(-1, "");
                        } else {
                            new Thread(new Runnable(list, new ArrayList(), r0) {
                                /* class _m_j.clr.AnonymousClass6 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ List f14101O000000o;
                                final /* synthetic */ List O00000Oo;
                                final /* synthetic */ Callback O00000o0;

                                {
                                    this.f14101O000000o = r2;
                                    this.O00000Oo = r3;
                                    this.O00000o0 = r4;
                                }

                                public final void run() {
                                    int i;
                                    int i2;
                                    int size = this.f14101O000000o.size();
                                    if (size < 50) {
                                        i = size;
                                        i2 = 0;
                                    } else {
                                        i2 = 0;
                                        i = 50;
                                    }
                                    while (i2 < size) {
                                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                                        final List subList = this.f14101O000000o.subList(i2, i);
                                        JSONArray jSONArray = new JSONArray();
                                        for (int i3 = 0; i3 < subList.size(); i3++) {
                                            jSONArray.put((int) (((TimeItem) subList.get(i3)).f5243O000000o / 1000));
                                        }
                                        clr.this.O00000o.callMethod(((TimeItem) subList.get(0)).O00000oO != 0 ? "deleteSaveVideo" : "deleteVideo", jSONArray, new Callback<JSONObject>() {
                                            /* class _m_j.clr.AnonymousClass6.AnonymousClass1 */

                                            public final void onFailure(int i, String str) {
                                                AnonymousClass6.this.O00000Oo.add(Boolean.FALSE);
                                                countDownLatch.countDown();
                                                civ.O00000o("SdCard", "delete video fail ".concat(String.valueOf(str)));
                                            }

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                clr.this.O000000o(subList);
                                                clr.this.O0000Oo0.O0000o00().O000000o(subList);
                                                AnonymousClass6.this.O00000Oo.add(Boolean.TRUE);
                                                countDownLatch.countDown();
                                            }
                                        }, Parser.DEFAULT_PARSER);
                                        try {
                                            countDownLatch.await();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        int i4 = i + 50;
                                        if (i4 >= size) {
                                            i4 = size;
                                        }
                                        if (this.O00000Oo.isEmpty() || ((Boolean) this.O00000Oo.remove(0)).booleanValue()) {
                                            int i5 = i;
                                            i = i4;
                                            i2 = i5;
                                        } else {
                                            Callback callback = this.O00000o0;
                                            if (callback != null) {
                                                callback.onFailure(-1, "");
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    Callback callback2 = this.O00000o0;
                                    if (callback2 != null) {
                                        callback2.onSuccess(new JSONObject());
                                    }
                                }
                            }).start();
                        }
                    }
                } else {
                    cls O0000Oo0 = cid.O0000Oo0();
                    if (O0000Oo0 != null) {
                        O0000Oo0.O000000o(list, new Callback<JSONObject>() {
                            /* class _m_j.cih.AnonymousClass1.AnonymousClass1 */

                            public final void onFailure(int i, String str) {
                                if (callback != null) {
                                    callback.onFailure(i, str);
                                }
                            }

                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                if (callback != null) {
                                    callback.onSuccess(null);
                                }
                            }
                        });
                    }
                }
            }
        });
        builder.O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000oo();
    }

    public static void O00000Oo(Activity activity, final cid cid, final List<TimeItem> list, final XQProgressDialog xQProgressDialog, final Callback<Void> callback) {
        if (list == null || list.size() == 0) {
            fag.O000000o(activity, activity.getString(R.string.bottom_action_tip));
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).O00000oO != 0) {
                list.remove(size);
            }
        }
        if (list.size() == 0) {
            fag.O000000o(activity, activity.getString(R.string.bottom_save_title));
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getString(R.string.save_title));
        if (list.size() == 1) {
            if (f13895O000000o == null || O00000Oo == null) {
                f13895O000000o = new SimpleDateFormat(activity.getResources().getString(R.string.simple_date_format_mm_dd_hh_mm));
                O00000Oo = new SimpleDateFormat(activity.getResources().getString(R.string.simple_date_format_hh_mm));
            }
            sb.append("\r\n\r\n");
            sb.append("(" + mi.O00000oO(list.get(0).f5243O000000o) + "-" + O00000Oo.format(new Date(list.get(0).O00000o0)) + ")");
        }
        builder.O00000Oo(sb.toString());
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class _m_j.cih.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                XQProgressDialog xQProgressDialog = xQProgressDialog;
                if (xQProgressDialog != null) {
                    xQProgressDialog.show();
                }
                cid cid = cid;
                if (cid == null || !cid.O00000o()) {
                    clr O0000OOo = cid.O0000OOo();
                    if (O0000OOo != null) {
                        List list = list;
                        AnonymousClass2 r0 = new Callback<JSONObject>() {
                            /* class _m_j.cih.AnonymousClass2.AnonymousClass2 */

                            public final void onFailure(int i, String str) {
                                if (callback != null) {
                                    callback.onFailure(i, str);
                                }
                            }

                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                if (callback != null) {
                                    callback.onSuccess(null);
                                }
                            }
                        };
                        if (list == null || list.size() == 0) {
                            r0.onFailure(-1, "");
                        } else {
                            new Thread(new Runnable(list, r0, new ArrayList()) {
                                /* class _m_j.clr.AnonymousClass8 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ List f14104O000000o;
                                final /* synthetic */ Callback O00000Oo;
                                final /* synthetic */ List O00000o0;

                                {
                                    this.f14104O000000o = r2;
                                    this.O00000Oo = r3;
                                    this.O00000o0 = r4;
                                }

                                public final void run() {
                                    int i;
                                    int i2;
                                    int size = this.f14104O000000o.size();
                                    if (size < 50) {
                                        i = size;
                                        i2 = 0;
                                    } else {
                                        i2 = 0;
                                        i = 50;
                                    }
                                    while (i2 < size) {
                                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                                        final List subList = this.f14104O000000o.subList(i2, i);
                                        JSONArray jSONArray = new JSONArray();
                                        for (int i3 = 0; i3 < subList.size(); i3++) {
                                            if (((TimeItem) subList.get(i3)).O00000oO == 0) {
                                                jSONArray.put((int) (((TimeItem) subList.get(i3)).f5243O000000o / 1000));
                                            }
                                        }
                                        if (jSONArray.length() == 0) {
                                            Callback callback = this.O00000Oo;
                                            if (callback != null) {
                                                callback.onFailure(-1, "");
                                                return;
                                            }
                                            return;
                                        }
                                        clr.this.O00000o.callMethod("saveVideo", jSONArray, new Callback<JSONObject>() {
                                            /* class _m_j.clr.AnonymousClass8.AnonymousClass1 */

                                            public final void onFailure(int i, String str) {
                                                AnonymousClass8.this.O00000o0.add(Boolean.FALSE);
                                                countDownLatch.countDown();
                                                civ.O00000o("SdCard", "save video fail ".concat(String.valueOf(str)));
                                            }

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                clr.this.O00000Oo(subList);
                                                AnonymousClass8.this.O00000o0.add(Boolean.TRUE);
                                                countDownLatch.countDown();
                                            }
                                        }, Parser.DEFAULT_PARSER);
                                        try {
                                            countDownLatch.await();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        int i4 = i + 50;
                                        if (i4 >= size) {
                                            i4 = size;
                                        }
                                        if (this.O00000o0.isEmpty() || ((Boolean) this.O00000o0.remove(0)).booleanValue()) {
                                            int i5 = i;
                                            i = i4;
                                            i2 = i5;
                                        } else {
                                            Callback callback2 = this.O00000Oo;
                                            if (callback2 != null) {
                                                callback2.onFailure(-1, "");
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    Callback callback3 = this.O00000Oo;
                                    if (callback3 != null) {
                                        callback3.onSuccess(new JSONObject());
                                    }
                                }
                            }).start();
                        }
                    }
                } else {
                    cls O0000Oo0 = cid.O0000Oo0();
                    if (O0000Oo0 != null) {
                        O0000Oo0.O00000Oo(list, new Callback<JSONObject>() {
                            /* class _m_j.cih.AnonymousClass2.AnonymousClass1 */

                            public final void onFailure(int i, String str) {
                                if (callback != null) {
                                    callback.onFailure(i, str);
                                }
                            }

                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                if (callback != null) {
                                    callback.onSuccess(null);
                                }
                            }
                        });
                    }
                }
            }
        });
        builder.O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000oo();
    }

    public static void O000000o(cid cid) {
        new Thread(new Runnable() {
            /* class _m_j.$$Lambda$cih$fYSU35eXF89M98Zgl79p6_5v00 */

            public final void run() {
                cih.O00000Oo(cid.this);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(cid cid) {
        File[] listFiles;
        String O00000o02 = me.O00000o0(cid.getDid());
        if (!TextUtils.isEmpty(O00000o02)) {
            File file = new File(O00000o02);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }
    }

    public static boolean O000000o() {
        ServerBean O0000ooO;
        if (CoreApi.O000000o().O0000O0o() && (O0000ooO = CoreApi.O000000o().O0000ooO()) != null && !TextUtils.isEmpty(O0000ooO.O00000Oo) && O0000ooO.O00000Oo.toLowerCase().equals("cn")) {
            return true;
        }
        return false;
    }

    public static String O000000o(String str) {
        String str2 = null;
        ServerBean O0000ooO = CoreApi.O000000o().O0000O0o() ? CoreApi.O000000o().O0000ooO() : null;
        if (O0000ooO == null || TextUtils.isEmpty(O0000ooO.O00000Oo)) {
            return null;
        }
        String str3 = O0000ooO.O00000Oo;
        if (str3.equalsIgnoreCase("in")) {
            str2 = "i2";
        } else if (!str3.equalsIgnoreCase("cn")) {
            str2 = str3.toLowerCase();
        }
        if (TextUtils.isEmpty(str2)) {
            return "https://".concat(String.valueOf(str));
        }
        return "https://" + str2 + "." + str;
    }

    public static void O00000Oo() {
        for (DeviceStat next : XmPluginHostApi.instance().getDeviceList()) {
            if (next != null && !TextUtils.isEmpty(next.model) && next.model.contains("camera") && O00000o0(next) && next.isOnline) {
                XmStreamClient.sCameraDevices.put(next.model + "_" + next.did, next.did);
            }
        }
        O0000Oo0();
        O000000o(true);
    }

    public static void O00000o0() {
        XmPluginHostApi.instance().getAppConfig("camera_audio_config", "en", "1", new Callback<String>() {
            /* class _m_j.cih.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                gsy.O00000Oo("CameraMissUtil", str);
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("audio_config");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("model");
                                int optInt = optJSONObject.optInt("sample_rate", 3);
                                int optInt2 = optJSONObject.optInt("data_bits", 1);
                                int optInt3 = optJSONObject.optInt("channel", 0);
                                int optInt4 = optJSONObject.optInt("codec", 1027);
                                if (!TextUtils.isEmpty(optString)) {
                                    gkv.f17949O000000o.getSharedPreferences("AUDIO_CONFIG_P", 0).edit().putString("AUDIO_CONFIG".concat(String.valueOf(optString)), optInt + "#" + optInt2 + "#" + optInt3 + "#" + optInt4);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    gsy.O00000Oo("CameraMissUtils", "forceGetMissTutkVersionConfig:" + e.getLocalizedMessage());
                }
            }

            public final void onFailure(int i, String str) {
                gsy.O00000Oo("CameraMissUtils", "forceGetMissTutkVersionConfig:".concat(String.valueOf(str)));
            }
        });
    }

    public static void O00000o() {
        for (DeviceStat next : XmPluginHostApi.instance().getDeviceList()) {
            if (next != null && !TextUtils.isEmpty(next.model) && next.model.contains("camera") && O00000o(next) && next.isOnline) {
                XmStreamClient.sCameraDevices.put(next.model + "_" + next.did, next.did);
            }
        }
        O0000Oo0();
        O000000o(false);
    }

    private static void O000000o(boolean z) {
        goq.O000000o(new Runnable(z) {
            /* class _m_j.$$Lambda$cih$tU52tRdCf_mipXCXojSkKieLKRQ */
            private final /* synthetic */ boolean f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                cih.O00000Oo(this.f$0);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(final boolean z) {
        if (!O00000o0.get()) {
            O00000o0.set(true);
            int i = fbz.O000000o().O00000Oo;
            StringBuilder sb = new StringBuilder("startPreconnection isRn=");
            sb.append(!z);
            sb.append(" maxConnectionLimit=");
            sb.append(i);
            wd.O00000o("rn_camera", sb.toString());
            for (Map.Entry next : XmStreamClient.sCameraDevices.entrySet()) {
                if (XmStreamClient.sDelayedDisconnectDevices.size() >= i) {
                    break;
                }
                final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid((String) next.getValue());
                if (deviceByDid != null) {
                    cid.O000000o(deviceByDid, deviceByDid.did);
                    XmStreamClient instance = XmStreamClient.getInstance(deviceByDid, deviceByDid.did);
                    if (!instance.isConnected()) {
                        instance.setAutoAudio(false);
                        instance.setAutoVideo(false);
                        instance.setOnPreConnectCallBack(new XmStreamClient.OnPreConnectCallBack() {
                            /* class _m_j.cih.AnonymousClass4 */

                            public final void onConnected(long j) {
                                if (j > 0) {
                                    hxi.O00000o.f952O000000o.O000000o("Camera_PreConnectSuccess_Time", "time", Long.valueOf(j));
                                }
                                StringBuilder sb = new StringBuilder("Preconnection onConnected uniqKey=");
                                sb.append(deviceByDid.model + "_" + deviceByDid.did);
                                sb.append(" isRn=");
                                sb.append(!z);
                                wd.O00000o("rn_camera", sb.toString());
                            }

                            public final void onVideoReceived(long j) {
                                if (j > 0) {
                                    hxk hxk = hxi.O00000o;
                                    hxk.f952O000000o.O000000o("Camera_PreConnectShowVideo_Time", "time", Long.valueOf(j));
                                }
                            }

                            public final void onError(int i, String str) {
                                hxi.O00000o.O0000o0O(i);
                                StringBuilder sb = new StringBuilder("Preconnection onError code=");
                                sb.append(i);
                                sb.append(" info=");
                                sb.append(str);
                                sb.append(" isRn=");
                                sb.append(!z);
                                wd.O00000o("rn_camera", sb.toString());
                            }

                            public final void onReConnected() {
                                StringBuilder sb = new StringBuilder("Preconnection onReConnected isRn=");
                                sb.append(!z);
                                wd.O00000o("rn_camera", sb.toString());
                            }
                        });
                        instance.startConnect(2, new IXmConnectionClient.XmActionCallback() {
                            /* class _m_j.cih.AnonymousClass5 */

                            public final void onSuccess(String str, Object obj) {
                            }

                            public final void onFailed(int i, String str) {
                                hxi.O00000o.O0000o0O(i);
                            }
                        });
                        String str = (String) next.getKey();
                        String str2 = (String) next.getValue();
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            XmStreamClient.sDelayedDisconnectDevices.put(str, str2);
                        }
                        StringBuilder sb2 = new StringBuilder("preConnect: ");
                        sb2.append((String) next.getKey());
                        sb2.append(" isRn=");
                        sb2.append(!z);
                        cki.O00000o0("rn_camera", sb2.toString());
                        hxi.O00000o.f952O000000o.O000000o("Camera_PreConnect_Num", new Object[0]);
                    } else {
                        return;
                    }
                }
            }
            O00000oO();
            O00000o0.set(false);
        }
    }

    public static void O00000oO() {
        CommonApplication.getGlobalHandler().removeCallbacks(O00000o);
        CommonApplication.getGlobalHandler().postAtTime(O00000o, SystemClock.uptimeMillis() + 180000);
    }

    public static void O000000o(DeviceStat deviceStat) {
        if (deviceStat != null) {
            XmStreamClient.sDelayedDisconnectDevices.put(deviceStat.model + "_" + deviceStat.did, deviceStat.did);
        }
    }

    public static void O00000Oo(DeviceStat deviceStat) {
        if (deviceStat != null) {
            XmStreamClient.sDelayedDisconnectDevices.remove(deviceStat.model + "_" + deviceStat.did, deviceStat.did);
        }
    }

    public static boolean O00000o0(DeviceStat deviceStat) {
        return deviceStat != null && O00000oO(deviceStat) && fbz.O000000o().O000000o(deviceStat.model, deviceStat.did, false);
    }

    public static boolean O00000o(DeviceStat deviceStat) {
        return deviceStat != null && O00000oO(deviceStat) && fbz.O000000o().O000000o(deviceStat.model, deviceStat.did, true);
    }

    private static boolean O00000oO(DeviceStat deviceStat) {
        if (deviceStat == null || TextUtils.isEmpty(deviceStat.model) || !deviceStat.model.contains("camera")) {
            return false;
        }
        cid O000000o2 = cid.O000000o(deviceStat, deviceStat.model);
        if (O000000o2.O00000o() || O000000o2.O00000o) {
            return true;
        }
        return false;
    }

    public static void O00000oo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> key : XmStreamClient.sCameraDevices.entrySet()) {
            sb.append((String) key.getKey());
            sb.append("#");
        }
        gpv.O00000Oo("key_camera_device_lru", sb.toString());
    }

    private static void O0000Oo0() {
        String O000000o2 = gpv.O000000o("key_camera_device_lru", "");
        if (!TextUtils.isEmpty(O000000o2)) {
            String[] split = O000000o2.split("#");
            ArrayList arrayList = new ArrayList();
            for (String add : split) {
                arrayList.add(add);
            }
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                XmStreamClient.sCameraDevices.get((String) it.next());
            }
            gpv.O00000Oo(CommonApplication.getAppContext(), "key_camera_device_lru");
        }
    }

    public static void O0000O0o() {
        wd.O00000o("rn_camera", "remove all preConnections");
        CommonApplication.getGlobalHandler().removeCallbacks(O00000o);
        CommonApplication.getGlobalHandler().post(O00000o);
    }

    public static boolean O0000OOo() {
        boolean z;
        List<DeviceStat> deviceList = XmPluginHostApi.instance().getDeviceList();
        if (deviceList == null) {
            return false;
        }
        for (DeviceStat next : deviceList) {
            if (!O00000o(next) || !next.isOnline) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return fbz.O000000o().O000000o(str, null, true);
    }
}
