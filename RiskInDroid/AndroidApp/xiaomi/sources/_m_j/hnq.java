package _m_j;

import _m_j.hrc;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.activity.SceneNumberPicker;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hnq extends hnm {
    public CommonSceneOnline O00000oO;
    public Device O00000oo;
    public String[] O0000O0o;
    public int[] O0000OOo;
    private int O0000Oo = -1;
    public int[] O0000Oo0;
    private List<CommonSceneOnline.O000000o> O0000OoO = new ArrayList();

    public hnq(Device device, DefaultSceneItemSet defaultSceneItemSet) {
        if (hod.O0000OoO().O00000Oo(device.model, device.did) != null && hod.O0000OoO().O00000Oo(device.model, device.did).O00000oO != null && hod.O0000OoO().O00000Oo(device.model, device.did).O00000oO.size() > 0) {
            this.O00000oO = hod.O0000OoO().O00000Oo(device.model, device.did);
            this.O0000OoO.addAll(this.O00000oO.O00000oO);
            this.O00000Oo = new int[this.O0000OoO.size()];
            this.f19096O000000o = new String[this.O0000OoO.size()];
            this.O00000o0 = new int[this.O0000OoO.size()];
            int i = 0;
            for (int i2 = 0; i2 < this.O00000Oo.length; i2++) {
                this.O00000Oo[i2] = i2;
                this.O00000o0[i2] = this.O0000OoO.get(i2).O0000OOo;
                this.f19096O000000o[i2] = this.O0000OoO.get(i2).f10657O000000o;
            }
            if (this.O00000oO.O0000O0o.size() > 0) {
                this.O0000O0o = new String[this.O00000oO.O0000O0o.size()];
                this.O0000OOo = new int[this.O00000oO.O0000O0o.size()];
                for (int i3 = 0; i3 < this.O00000oO.O0000O0o.size(); i3++) {
                    this.O0000O0o[i3] = this.O00000oO.O0000O0o.get(i3).f10660O000000o;
                    this.O0000OOo[i3] = this.O00000oO.O0000O0o.get(i3).O00000Oo;
                }
                this.O0000Oo0 = new int[this.O0000OoO.size()];
                while (true) {
                    int[] iArr = this.O0000Oo0;
                    if (i >= iArr.length) {
                        break;
                    }
                    iArr[i] = this.O0000OoO.get(i).O00000o0;
                    i++;
                }
            }
        }
        this.O00000oo = device;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        boolean z;
        Device device = (Device) obj;
        SceneApi.Action action = new SceneApi.Action();
        if (device == null) {
            return action;
        }
        CommonSceneOnline.O000000o o000000o = this.O0000OoO.get(i);
        action.f11120O000000o = 0;
        action.O00000Oo = this.O00000oO.O00000o0;
        action.O00000o0 = str;
        action.O00000oO = device.model;
        action.O00000oo = o000000o.O00000Oo;
        for (int i2 = 0; i2 < this.O00000Oo.length; i2++) {
            if (i == this.O00000Oo[i2]) {
                action.O00000o = this.O00000o0[i2];
            }
        }
        SceneApi.O000OO0o o000OO0o = new SceneApi.O000OO0o();
        o000OO0o.O00000o = device.did;
        o000OO0o.O0000OOo = o000000o.O00000Oo;
        o000OO0o.O00000o0 = o000000o.O00000oO;
        if (intent != null && intent.hasExtra("key_name")) {
            action.O00000o0 = intent.getStringExtra("key_name");
        }
        if (intent == null || !intent.hasExtra("value")) {
            o000OO0o.O00000oO = o000000o.O00000oo;
        } else if (intent.getStringExtra("value") != null) {
            boolean z2 = true;
            try {
                o000OO0o.O00000oO = new JSONObject(intent.getStringExtra("value"));
                z = true;
            } catch (JSONException unused) {
                z = false;
            }
            if (!z) {
                try {
                    o000OO0o.O00000oO = new JSONArray(intent.getStringExtra("value"));
                } catch (JSONException unused2) {
                }
                if (!z2) {
                    o000OO0o.O00000oO = intent.getStringExtra("value");
                }
            }
            z2 = z;
            if (!z2) {
            }
        } else {
            o000OO0o.O00000oO = intent.getExtras().get("value");
        }
        if (o000000o.O0000Oo && o000000o.O00000oo != null) {
            if (o000000o.O00000oo instanceof hrc) {
                hrc O0000O0o2 = ((hrc) o000000o.O00000oo).O0000O0o();
                hrc.O000000o O00000oo2 = O0000O0o2.O00000oo();
                if (O00000oo2 != null) {
                    O00000oo2.f544O000000o = o000OO0o.O00000oO;
                    if (O00000oo2.f544O000000o != null) {
                        o000OO0o.O00000oO = O0000O0o2.O00000Oo();
                    }
                }
            } else if (o000000o.O00000oo instanceof hqz) {
                hqz hqz = (hqz) o000000o.O00000oo;
                hqz hqz2 = new hqz(hqz.O00000o);
                hqz2.f541O000000o = hqz.f541O000000o;
                if (hqz.O00000Oo != null && hqz.O00000Oo.size() > 0) {
                    hqz2.O00000Oo.addAll(hqz.O00000Oo);
                }
                hrc hrc = (hqz2.O00000Oo == null || hqz2.O00000Oo.size() == 0) ? null : hqz2.O00000Oo.get(0);
                hrc.O0000OOo = o000OO0o.O00000oO;
                if (hrc.O0000OOo != null) {
                    o000OO0o.O00000oO = hqz2.O00000Oo();
                }
            }
        }
        action.O0000O0o = o000OO0o;
        return action;
    }

    public static String O000000o(Device device) {
        return (device == null || TextUtils.isEmpty(device.name)) ? "" : device.name;
    }

    public final int O000000o(int i) {
        for (int i2 = 0; i2 < this.O00000Oo.length; i2++) {
            if (i == this.O00000Oo[i2]) {
                return this.O00000o0[i2];
            }
        }
        return -1;
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        Device device = (Device) obj;
        if (!device.model.equals(action.O00000oO) || action.O0000O0o == null || !(action.O0000O0o instanceof SceneApi.O000OO0o) || !((SceneApi.O000OO0o) action.O0000O0o).O00000o.equalsIgnoreCase(device.did)) {
            return -1;
        }
        SceneApi.O000OO0o o000OO0o = (SceneApi.O000OO0o) action.O0000O0o;
        for (int i = 0; i < this.O0000OoO.size(); i++) {
            if (((SceneApi.O000OO0o) action.O0000O0o).O0000OOo != -1 && this.O0000OoO.get(i).O00000Oo != -1 && ((SceneApi.O000OO0o) action.O0000O0o).O0000OOo == this.O0000OoO.get(i).O00000Oo) {
                return i;
            }
            if (this.O0000OoO.get(i).O00000oO.equalsIgnoreCase(action.O0000O0o.O00000o0) && ((this.O0000OoO.get(i).O00000oo == null && o000OO0o.O00000oO == null) || (this.O0000OoO.get(i).O00000oo != null && o000OO0o.O00000oO != null && hnw.O000000o(this.O0000OoO.get(i).O00000oo, o000OO0o.O00000oO)))) {
                return i;
            }
        }
        return -1;
    }

    public final int O000000o(String str, Object obj) {
        for (int i = 0; i < this.O0000OoO.size(); i++) {
            if (this.O0000OoO.get(i).O00000oO.equalsIgnoreCase(str) && ((this.O0000OoO.get(i).O00000oo == null && obj == null) || (this.O0000OoO.get(i).O00000oo != null && obj != null && hnw.O000000o(this.O0000OoO.get(i).O00000oo, obj)))) {
                return i;
            }
        }
        return -1;
    }

    public final String O000000o(Object obj) {
        return O000000o(obj instanceof Device ? (Device) obj : null);
    }

    public final int O000000o(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo, Context context, int i, Object obj, Object obj2) {
        JSONObject O000000o2;
        if (this.O0000OoO.get(i).O0000Oo0 == null || !(this.O0000OoO.get(i).O0000Oo0 instanceof CommonSceneOnline.O0000OOo)) {
            PluginPackageInfo O0000Oo2 = CoreApi.O000000o().O0000Oo(this.O00000oo.model);
            if (O0000Oo2 != null && O0000Oo2.O0000o0O()) {
                fvo.O000000o();
                if (fvo.O00000oO() && (O000000o2 = fvu.O000000o(this.O00000oo.model)) != null) {
                    boolean optBoolean = O000000o2.optBoolean(fvt.O00000o0, false);
                    boolean optBoolean2 = O000000o2.optBoolean(fvt.O00000oO, false);
                    String optString = O000000o2.optString(fvt.O00000o, "");
                    LogType logType = LogType.SCENE;
                    gsy.O00000o0(logType, "InnerActionCommon", "native scene debug,  model: " + this.O00000oo.model + "  isCheck: " + optBoolean + "   sceneId: " + optString + "   scenIdIsCheck: " + optBoolean2 + "  id: " + this.O0000OoO.get(i).O00000Oo);
                    if (optBoolean && !optBoolean2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.O0000OoO.get(i).O00000Oo);
                        if (optString.equals(sb.toString())) {
                            O00000Oo(o0000OOo, context, i, obj, obj2);
                            LogType logType2 = LogType.SCENE;
                            gsy.O00000o0(logType2, "InnerActionCommon", "native debug, will launch rn plugin  action is " + this.O0000OoO.get(i).O00000Oo);
                            return 0;
                        }
                    }
                }
                List<String> O00000o0 = hsi.O00000o0(O0000Oo2.O00000o());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.O0000OoO.get(i).O00000Oo);
                if (!O00000o0.contains(sb2.toString())) {
                    return -2;
                }
                O00000Oo(o0000OOo, context, i, obj, obj2);
                LogType logType3 = LogType.SCENE;
                gsy.O00000o0(logType3, "InnerActionCommon", "will launch rn plugin  action is " + this.O0000OoO.get(i).O00000Oo);
                return 0;
            } else if (TextUtils.isEmpty(this.O0000OoO.get(i).O0000O0o) || obj == null) {
                return -2;
            } else {
                final Intent intent = new Intent(this.O0000OoO.get(i).O0000O0o);
                intent.putExtra("action", this.O0000OoO.get(i).O00000oO);
                if (obj2 != null && (obj2 instanceof String)) {
                    intent.putExtra("value", (String) obj2);
                } else if (obj2 != null) {
                    intent.putExtra("value", obj2.toString());
                }
                intent.putExtra("actionId", this.O0000OoO.get(i).O00000Oo);
                intent.putExtra("plug_id", this.O0000OoO.get(i).O0000O0o);
                intent.putExtra("name", this.O0000OoO.get(i).f10657O000000o);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.O0000OoO.get(i).O0000OOo);
                intent.putExtra("tr_id", sb3.toString());
                intent.putExtra("scene_type", 2);
                final Context context2 = context;
                final Object obj3 = obj;
                final SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo2 = o0000OOo;
                ServiceApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.hnq.AnonymousClass1 */

                    public final void run() {
                        hnq.this.O000000o(context2, (Device) obj3, intent, o0000OOo2);
                    }
                });
                return 0;
            }
        } else {
            CommonSceneOnline.O0000OOo o0000OOo3 = (CommonSceneOnline.O0000OOo) this.O0000OoO.get(i).O0000Oo0;
            Intent intent2 = new Intent(context, SceneNumberPicker.class);
            intent2.putExtra("max_value", o0000OOo3.O00000Oo);
            intent2.putExtra("min_value", o0000OOo3.O00000o0);
            intent2.putExtra("interval", o0000OOo3.O00000o);
            intent2.putExtra("degree", o0000OOo3.O00000oO);
            intent2.putExtra("show_tags", o0000OOo3.O0000Oo0);
            intent2.putExtra("default_value", o0000OOo3.O0000OOo);
            intent2.putExtra("json_tag", o0000OOo3.O00000oo);
            intent2.putExtra("title", this.O0000OoO.get(i).f10657O000000o);
            intent2.putExtra("init_value", this.O0000OoO.get(i).O00000oo.toString());
            if (!TextUtils.isEmpty(o0000OOo3.O0000O0o)) {
                intent2.putExtra("formatter", o0000OOo3.O0000O0o);
            } else {
                o0000OOo3.O0000O0o = this.O0000OoO.get(i).f10657O000000o + "%s" + o0000OOo3.O00000oO;
                intent2.putExtra("formatter", o0000OOo3.O0000O0o);
            }
            if (obj2 != null && (obj2 instanceof String)) {
                intent2.putExtra("last_value", (String) obj2);
            } else if (obj2 != null) {
                if (obj2 instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj2;
                    if (jSONObject.has("piid")) {
                        obj2 = hrc.O000000o(jSONObject).O0000OOo;
                    } else if (jSONObject.has("aiid")) {
                        obj2 = hqz.O000000o(jSONObject).O00000Oo.get(0).O0000OOo;
                    }
                }
                intent2.putExtra("last_value", obj2.toString());
            }
            o0000OOo.O000000o(intent2, 103);
            return 103;
        }
    }

    private void O00000Oo(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo, Context context, int i, Object obj, Object obj2) {
        final Intent intent = new Intent(this.O0000OoO.get(i).O0000O0o);
        intent.putExtra("action", this.O0000OoO.get(i).O00000oO);
        if (obj2 != null && (obj2 instanceof String)) {
            intent.putExtra("value", (String) obj2);
        } else if (obj2 != null) {
            intent.putExtra("value", obj2.toString());
        }
        intent.putExtra("actionId", this.O0000OoO.get(i).O00000Oo);
        intent.putExtra("plug_id", this.O0000OoO.get(i).O0000O0o);
        intent.putExtra("name", this.O0000OoO.get(i).f10657O000000o);
        StringBuilder sb = new StringBuilder();
        sb.append(this.O0000OoO.get(i).O0000OOo);
        intent.putExtra("tr_id", sb.toString());
        intent.putExtra("scene_type", 2);
        final Context context2 = context;
        final Object obj3 = obj;
        final SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo2 = o0000OOo;
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.hnq.AnonymousClass2 */

            public final void run() {
                hnq.this.O000000o(context2, (Device) obj3, intent, o0000OOo2);
            }
        });
    }

    public final void O000000o(Context context, Device device, Intent intent, SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo) {
        Context context2 = context;
        Device device2 = device;
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device2.model);
        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(context2, context2.getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0() + context2.getString(R.string.plugin));
        final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        final boolean z = CoreApi.O000000o().O0000Oo(this.O00000oo.model) == null && CoreApi.O000000o().O0000OoO(this.O00000oo.model) == null;
        O000000o o000000o = new O000000o(o0000OOo);
        PluginApi instance = PluginApi.getInstance();
        Context appContext = ServiceApplication.getAppContext();
        String str = device2.model;
        DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2);
        final Context context3 = context;
        final Device device3 = device;
        instance.sendMessage(appContext, str, 3, intent, newDeviceStat, null, true, new SendMessageCallback(o000000o) {
            /* class _m_j.hnq.AnonymousClass3 */

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                pluginDownloadTask.O000000o(pluginDownloadTask);
                if (O000000o2 != null) {
                    Context context = context3;
                    if ((context instanceof Activity) && !((Activity) context).isFinishing() && !((Activity) context3).isDestroyed()) {
                        O000000o2.O000000o(100, 0);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        xQProgressHorizontalDialog.f9117O000000o = false;
                        xQProgressHorizontalDialog.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class _m_j.hnq.AnonymousClass3.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                CoreApi.O000000o().O000000o(device3.model, pluginDownloadTask);
                            }
                        });
                    }
                }
            }

            public final void onDownloadProgress(String str, float f) {
                if (z) {
                    int i = (int) (f * 100.0f);
                    if (i >= 99) {
                        i = 99;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(100, i);
                        return;
                    }
                    return;
                }
                XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                if (xQProgressHorizontalDialog2 != null) {
                    xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onSendFailure(fso fso) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onSendCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onMessageSuccess(Intent intent) {
                if (this.mObj != null && (this.mObj instanceof O000000o)) {
                    ((O000000o) this.mObj).f389O000000o.O000000o(-1, intent);
                }
                this.mObj = null;
            }

            public final void onMessageFailure(int i, String str) {
                if (this.mObj != null && (this.mObj instanceof O000000o)) {
                    ((O000000o) this.mObj).f389O000000o.O000000o(0, (Intent) null);
                }
                this.mObj = null;
            }
        });
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        SmartHomeSceneActionChooseActivity.O0000OOo f389O000000o;

        public O000000o(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo) {
            this.f389O000000o = o0000OOo;
        }
    }
}
