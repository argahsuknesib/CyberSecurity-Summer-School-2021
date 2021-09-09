package _m_j;

import _m_j.hrc;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.activity.SceneNumberPicker;
import com.xiaomi.smarthome.scene.activity.StartConditionActivityNew;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hox extends hos {
    public CommonSceneOnline O00000o;
    protected int[] O00000oO;
    public String[] O00000oo;
    public int[] O0000O0o;
    public int[] O0000OOo;
    private List<CommonSceneOnline.O00000Oo> O0000Oo0 = new ArrayList();

    public hox(Device device, DefaultSceneItemSet defaultSceneItemSet) {
        super(device);
        if (hod.O0000OoO().O00000Oo(device.model, device.did) != null && hod.O0000OoO().O00000Oo(device.model, device.did).O00000o.size() > 0) {
            this.O00000o = hod.O0000OoO().O00000Oo(device.model, device.did);
            this.O0000Oo0.addAll(this.O00000o.O00000o);
            this.O00000Oo = new String[this.O0000Oo0.size()];
            this.f457O000000o = new int[this.O0000Oo0.size()];
            this.O00000oO = new int[this.O0000Oo0.size()];
            int i = 0;
            for (int i2 = 0; i2 < this.O0000Oo0.size(); i2++) {
                this.f457O000000o[i2] = i2;
                this.O00000oO[i2] = this.O0000Oo0.get(i2).O00000o;
                this.O00000Oo[i2] = this.O00000o.O00000o.get(i2).f10658O000000o;
            }
            if (this.O00000o.O00000oo.size() > 0) {
                this.O00000oo = new String[this.O00000o.O00000oo.size()];
                this.O0000O0o = new int[this.O00000o.O00000oo.size()];
                for (int i3 = 0; i3 < this.O00000o.O00000oo.size(); i3++) {
                    this.O00000oo[i3] = this.O00000o.O00000oo.get(i3).f10660O000000o;
                    this.O0000O0o[i3] = this.O00000o.O00000oo.get(i3).O00000Oo;
                }
                this.O0000OOo = new int[this.O0000Oo0.size()];
                while (true) {
                    int[] iArr = this.O0000OOo;
                    if (i < iArr.length) {
                        iArr[i] = this.O00000o.O00000o.get(i).O00000o0;
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void O000000o(SimpleDraweeView simpleDraweeView) {
        DeviceFactory.O00000Oo(this.O00000o0.model, simpleDraweeView);
    }

    public final SceneApi.O000000o O000000o(int i, Intent intent) {
        hrc O0000O0o2;
        hrc.O000000o O00000oo2;
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.f11121O000000o = LAUNCH_TYPE.DEVICE;
        SceneApi.O00000o0 o00000o0 = new SceneApi.O00000o0();
        o00000o0.f11122O000000o = this.O00000o0.did;
        boolean z = false;
        for (int i2 = 0; i2 < this.f457O000000o.length; i2++) {
            if (i == this.f457O000000o[i2]) {
                o000000o.O0000Ooo = this.O00000oO[i2];
            }
        }
        CommonSceneOnline.O00000Oo o00000Oo = this.O00000o.O00000o.get(i);
        o00000o0.O00000Oo = o00000Oo.f10658O000000o;
        if (intent != null && intent.hasExtra("key_name")) {
            o00000o0.O00000Oo = intent.getStringExtra("key_name");
        }
        o00000o0.O00000o0 = this.O00000o0.name;
        for (int i3 = 0; i3 < this.f457O000000o.length; i3++) {
            if (i == this.f457O000000o[i3]) {
                o000000o.O0000Ooo = this.O00000oO[i3];
            }
        }
        o00000o0.O0000Oo = o00000Oo.O00000oo;
        o00000o0.O00000o = this.O00000o0.model;
        o00000o0.O0000Oo = o00000Oo.O00000oo;
        o00000o0.O0000OoO = o00000Oo.O00000Oo;
        o000000o.O00000o0 = o00000o0;
        if (intent == null || !intent.hasExtra("value")) {
            o00000o0.O0000Ooo = o00000Oo.O0000O0o;
        } else if (intent.getStringExtra("value") != null) {
            try {
                o00000o0.O0000Ooo = new JSONObject(intent.getStringExtra("value"));
                z = true;
            } catch (JSONException unused) {
            }
            if (!z) {
                try {
                    o00000o0.O0000Ooo = new JSONArray(intent.getStringExtra("value"));
                    z = true;
                } catch (JSONException unused2) {
                }
            }
            if (!z) {
                o00000o0.O0000Ooo = intent.getStringExtra("value");
            }
        } else {
            o00000o0.O0000Ooo = intent.getExtras().get("value");
        }
        if (o00000Oo.O0000Oo && o00000Oo.O0000O0o != null && (o00000Oo.O0000O0o instanceof hrc) && (O00000oo2 = (O0000O0o2 = ((hrc) o00000Oo.O0000O0o).O0000O0o()).O00000oo()) != null) {
            O00000oo2.f544O000000o = o00000o0.O0000Ooo;
            o00000o0.O0000Ooo = O0000O0o2.O00000Oo();
        }
        return o000000o;
    }

    public final int O00000o0(int i) {
        for (int i2 = 0; i2 < this.f457O000000o.length; i2++) {
            if (i == this.f457O000000o[i2]) {
                return this.O00000oO[i2];
            }
        }
        return -1;
    }

    public final int O000000o(SceneApi.O000000o o000000o) {
        if (!(this.O00000o0 == null || o000000o == null || o000000o.O00000o0 == null || !this.O00000o0.did.equalsIgnoreCase(o000000o.O00000o0.f11122O000000o) || o000000o.O00000o0 == null || !(o000000o.O00000o0 instanceof SceneApi.O00000o0))) {
            for (int i = 0; i < this.f457O000000o.length; i++) {
                if (o000000o.O00000o0.O0000OoO == -1 || this.O00000o.O00000o.get(i).O00000Oo == -1) {
                    if (this.O00000o.O00000o.get(i).O00000oo.equalsIgnoreCase(o000000o.O00000o0.O0000Oo) && ((this.O00000o.O00000o.get(i).O0000O0o == null && ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo == null) || (this.O00000o.O00000o.get(i).O0000O0o != null && ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo != null && hnw.O000000o(this.O00000o.O00000o.get(i).O0000O0o, ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo)))) {
                        return i;
                    }
                    if (this.O00000o.O00000o.get(i).O00000oo.equalsIgnoreCase(o000000o.O00000o0.O0000Oo)) {
                        return -2;
                    }
                } else if (o000000o.O00000o0.O0000OoO == this.O00000o.O00000o.get(i).O00000Oo) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final int O000000o(String str, Object obj) {
        for (int i = 0; i < this.f457O000000o.length; i++) {
            if (this.O00000o.O00000o.get(i).O00000oo.equalsIgnoreCase(str) && ((this.O00000o.O00000o.get(i).O0000O0o == null && obj == null) || (this.O00000o.O00000o.get(i).O0000O0o != null && obj != null && hnw.O000000o(this.O00000o.O00000o.get(i).O0000O0o, obj)))) {
                return i;
            }
        }
        return -1;
    }

    public final int O000000o(int i, final Activity activity, SceneApi.O000000o o000000o) {
        JSONObject O000000o2;
        CommonSceneOnline.O00000Oo o00000Oo = this.O0000Oo0.get(i);
        if (o00000Oo.O0000Oo0 != null) {
            if (o00000Oo.O0000Oo0 instanceof CommonSceneOnline.O0000OOo) {
                CommonSceneOnline.O0000OOo o0000OOo = (CommonSceneOnline.O0000OOo) o00000Oo.O0000Oo0;
                Intent intent = new Intent(activity, SceneNumberPicker.class);
                intent.putExtra("max_value", o0000OOo.O00000Oo);
                intent.putExtra("min_value", o0000OOo.O00000o0);
                intent.putExtra("interval", o0000OOo.O00000o);
                intent.putExtra("degree", o0000OOo.O00000oO);
                intent.putExtra("json_tag", o0000OOo.O00000oo);
                intent.putExtra("show_tags", o0000OOo.O0000Oo0);
                intent.putExtra("default_value", o0000OOo.O0000OOo);
                intent.putExtra("title", o00000Oo.f10658O000000o);
                if (!TextUtils.isEmpty(o0000OOo.O0000O0o)) {
                    intent.putExtra("formatter", o0000OOo.O0000O0o);
                } else {
                    o0000OOo.O0000O0o = this.O0000Oo0.get(i).f10658O000000o + "%s" + o0000OOo.O00000oO;
                    intent.putExtra("formatter", o0000OOo.O0000O0o);
                }
                if (o000000o != null) {
                    Object obj = ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo;
                    if (!o00000Oo.O0000Oo || obj == null || !(obj instanceof JSONObject)) {
                        intent.putExtra("last_value", String.valueOf(((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo));
                    } else {
                        hrc O000000o3 = hrc.O000000o((JSONObject) obj);
                        hrc.O000000o O00000oo2 = O000000o3.O00000oo();
                        if (O00000oo2 != null) {
                            intent.putExtra("last_value", String.valueOf(O00000oo2.f544O000000o));
                        } else {
                            intent.putExtra("last_value", String.valueOf(O000000o3));
                        }
                    }
                }
                activity.startActivityForResult(intent, 103);
                return 103;
            } else if (o00000Oo.O0000Oo0 instanceof CommonSceneOnline.O0000O0o) {
                ExternalLoadManager.instance.loadExternal("amap2d", new fkv(activity) {
                    /* class _m_j.$$Lambda$hox$TDGpM9Ui7n8vrzC5sZonCOYLIkk */
                    private final /* synthetic */ Activity f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object call(Object obj) {
                        return hox.O000000o(CommonSceneOnline.O00000Oo.this, this.f$1, (ExternalLoadManager.O000000o) obj);
                    }
                });
                return 104;
            }
        }
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(this.O00000o0.model);
        if (O0000Oo != null && O0000Oo.O0000o0O()) {
            fvo.O000000o();
            if (fvo.O00000oO() && (O000000o2 = fvu.O000000o(this.O00000o0.model)) != null) {
                boolean optBoolean = O000000o2.optBoolean(fvt.O00000o0, false);
                boolean optBoolean2 = O000000o2.optBoolean(fvt.O00000oO, false);
                String optString = O000000o2.optString(fvt.O00000o, "");
                LogType logType = LogType.SCENE;
                gsy.O00000o0(logType, "InnerConditionCommon", "native scene debug,  model: " + this.O00000o0.model + "  isCheck: " + optBoolean + "   sceneId: " + optString + "   scenIdIsCheck: " + optBoolean2 + " id: " + o00000Oo.O00000Oo);
                if (optBoolean && optBoolean2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(o00000Oo.O00000Oo);
                    if (optString.equals(sb.toString())) {
                        LogType logType2 = LogType.SCENE;
                        gsy.O00000o0(logType2, "InnerConditionCommon", "native scene debug, will launch rn plugin  condition is " + o00000Oo.O00000Oo);
                        O00000Oo(i, activity, o000000o);
                        return 0;
                    }
                }
            }
            List<String> O00000Oo = hsi.O00000Oo(O0000Oo.O00000o());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(o00000Oo.O00000Oo);
            if (O00000Oo.contains(sb2.toString())) {
                LogType logType3 = LogType.SCENE;
                gsy.O00000o0(logType3, "InnerConditionCommon", "will launch rn plugin  condition is " + o00000Oo.O00000Oo);
                O00000Oo(i, activity, o000000o);
                return 0;
            }
        }
        if (TextUtils.isEmpty(o00000Oo.O0000OOo)) {
            return -2;
        }
        final Intent intent2 = new Intent(o00000Oo.O0000OOo);
        intent2.putExtra("action", o00000Oo.O00000oo);
        intent2.putExtra("value", String.valueOf(o00000Oo.O0000O0o));
        if (o000000o != null) {
            intent2.putExtra("last_value", String.valueOf(((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo));
        }
        intent2.putExtra("actionId", o00000Oo.O00000Oo);
        intent2.putExtra("name", o00000Oo.f10658O000000o);
        intent2.putExtra("plug_id", o00000Oo.O0000OOo);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(o00000Oo.O00000o);
        intent2.putExtra("tr_id", sb3.toString());
        intent2.putExtra("scene_type", 1);
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.hox.AnonymousClass1 */

            public final void run() {
                hox hox = hox.this;
                hox.O000000o(activity, hox.O00000o0, intent2);
            }
        });
        return 0;
    }

    public final void O000000o(Context context, Device device, Intent intent) {
        Context context2 = context;
        Device device2 = device;
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device2.model);
        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(context2, context2.getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0() + context2.getString(R.string.plugin));
        final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        final boolean z = CoreApi.O000000o().O0000Oo(device2.model) == null && CoreApi.O000000o().O0000OoO(device2.model) == null;
        PluginApi instance = PluginApi.getInstance();
        Context appContext = ServiceApplication.getAppContext();
        String str = device2.model;
        DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2);
        final Context context3 = context;
        final Device device3 = device;
        instance.sendMessage(appContext, str, 3, intent, newDeviceStat, null, true, new SendMessageCallback() {
            /* class _m_j.hox.AnonymousClass2 */

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                pluginDownloadTask.O000000o(pluginDownloadTask);
                if (O000000o2 != null) {
                    Context context = context3;
                    if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT < 17 || !((Activity) context3).isDestroyed()) {
                        O000000o2.O000000o(100, 0);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        xQProgressHorizontalDialog.f9117O000000o = false;
                        xQProgressHorizontalDialog.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class _m_j.hox.AnonymousClass2.AnonymousClass1 */

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
                ((StartConditionActivityNew) context3).onActivityResult(-1, intent);
            }

            public final void onMessageFailure(int i, String str) {
                ((StartConditionActivityNew) context3).onActivityResult(0, null);
            }
        });
    }

    private void O00000Oo(int i, final Activity activity, SceneApi.O000000o o000000o) {
        final Intent intent = new Intent(this.O0000Oo0.get(i).O0000OOo);
        intent.putExtra("action", this.O0000Oo0.get(i).O00000oo);
        intent.putExtra("value", String.valueOf(this.O0000Oo0.get(i).O0000O0o));
        if (o000000o != null) {
            intent.putExtra("last_value", String.valueOf(((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo));
        }
        intent.putExtra("actionId", this.O0000Oo0.get(i).O00000Oo);
        intent.putExtra("name", this.O0000Oo0.get(i).f10658O000000o);
        intent.putExtra("plug_id", this.O0000Oo0.get(i).O0000OOo);
        StringBuilder sb = new StringBuilder();
        sb.append(this.O0000Oo0.get(i).O00000o);
        intent.putExtra("tr_id", sb.toString());
        intent.putExtra("scene_type", 1);
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.hox.AnonymousClass3 */

            public final void run() {
                hox hox = hox.this;
                hox.O000000o(activity, hox.O00000o0, intent);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer O000000o(CommonSceneOnline.O00000Oo o00000Oo, Activity activity, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        if (o000000o.f4013O000000o == 3) {
            CommonSceneOnline.O0000O0o o0000O0o = (CommonSceneOnline.O0000O0o) o00000Oo.O0000Oo0;
            Intent intent = new Intent(activity, AmapPoiActivity.class);
            intent.putExtra("extra_data_min_radius", 500);
            intent.putExtra("extra_data_max_radius", 2000);
            intent.putExtra("extra_data_latitude", (double) o0000O0o.O00000o0);
            intent.putExtra("extra_data_longitude", (double) o0000O0o.O00000Oo);
            intent.putExtra("extra_data_radius", o0000O0o.O00000o);
            intent.putExtra("extra_data_sub_title", o0000O0o.O00000oO);
            intent.putExtra("extra_data_act_name", o0000O0o.O0000O0o);
            intent.putExtra("extra_data_radius_degree", o0000O0o.O00000oo);
            activity.startActivityForResult(intent, 104);
        } else if (o000000o.f4013O000000o == 4) {
            gqg.O00000Oo((int) R.string.mapload_fail);
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }
}
