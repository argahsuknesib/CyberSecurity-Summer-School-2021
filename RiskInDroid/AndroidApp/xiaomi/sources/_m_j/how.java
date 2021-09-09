package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import org.json.JSONException;
import org.json.JSONObject;

public final class how extends hos implements hoz {
    public final int O000000o() {
        return R.string.scene_enter_or_leave_fence;
    }

    public final int O00000o0(int i) {
        return 101;
    }

    public how() {
        super(null);
        this.O00000Oo = new String[2];
        this.f457O000000o = new int[2];
        this.O00000Oo[0] = ServiceApplication.getAppContext().getString(R.string.enter);
        this.f457O000000o[0] = 0;
        this.O00000Oo[1] = ServiceApplication.getAppContext().getString(R.string.leave);
        this.f457O000000o[1] = 1;
    }

    public final SceneApi.O000000o O000000o(int i, Intent intent) {
        String str;
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.O0000Ooo = 101;
        SceneApi.O0000O0o o0000O0o = new SceneApi.O0000O0o();
        o0000O0o.O0000o00 = "user";
        ServiceApplication.getAppContext().getString(R.string.scene_enter_fence_formatter);
        if (i == 0) {
            o000000o.f11121O000000o = LAUNCH_TYPE.ENTER_FENCE;
            str = ServiceApplication.getAppContext().getString(R.string.scene_enter_fence_formatter);
            o0000O0o.O0000o0O = "enter_fence";
        } else {
            o000000o.f11121O000000o = LAUNCH_TYPE.LEAVE_FENCE;
            str = ServiceApplication.getAppContext().getString(R.string.scene_exit_fence_formatter);
            o0000O0o.O0000o0O = "leave_fence";
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra("poi_name");
            if (!TextUtils.isEmpty(stringExtra)) {
                o0000O0o.O0000Ooo = stringExtra;
            }
            long longExtra = intent.getLongExtra("extra_data_poid", -1);
            if (longExtra > 0) {
                o0000O0o.O0000o0 = longExtra;
            }
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "";
            }
            objArr[0] = stringExtra;
            o0000O0o.O00000Oo = String.format(str, objArr);
            String stringExtra2 = intent.getStringExtra("value");
            if (!TextUtils.isEmpty(stringExtra2)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra2);
                    LogType logType = LogType.GENERAL;
                    gsy.O00000Oo(logType, "select GCJ", "lat:" + jSONObject.optDouble("latitude") + "  ,lon: " + jSONObject.optDouble("longitude"));
                    o0000O0o.O0000o = jSONObject.optDouble("longitude");
                    o0000O0o.O0000o0o = jSONObject.optDouble("latitude");
                    o0000O0o.O0000oO0 = (float) jSONObject.optDouble("radius");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        o000000o.O0000Oo = o0000O0o;
        return o000000o;
    }

    public final int O000000o(int i, Activity activity, SceneApi.O000000o o000000o) {
        ExternalLoadManager.instance.loadExternal("amap2d", new fkv(activity, o000000o, i) {
            /* class _m_j.$$Lambda$how$qbRP8UfdQtURpPHaRiqYBGGWC8 */
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ SceneApi.O000000o f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object call(Object obj) {
                return how.O000000o(this.f$0, this.f$1, this.f$2, (ExternalLoadManager.O000000o) obj);
            }
        });
        return 107;
    }

    public final int O000000o(SceneApi.O000000o o000000o) {
        if (o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) {
            return 0;
        }
        return o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE ? 1 : -1;
    }

    public final void O000000o(SimpleDraweeView simpleDraweeView) {
        simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_fence));
    }

    public final String O00000o() {
        return ServiceApplication.getAppContext().getString(R.string.scene_enter_or_leave_fence);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent} */
    /* access modifiers changed from: private */
    public static /* synthetic */ Integer O000000o(Activity activity, SceneApi.O000000o o000000o, int i, ExternalLoadManager.O000000o o000000o2) throws RuntimeException {
        if (o000000o2.f4013O000000o == 3) {
            Intent intent = new Intent(activity, AmapGeofencingActivity.class);
            if (o000000o == null || o000000o.O0000Oo == null) {
                intent.putExtra("extra_data_radius", 100.0f);
            } else {
                intent.putExtra("extra_data_latitude", o000000o.O0000Oo.O0000o0o);
                intent.putExtra("extra_data_longitude", o000000o.O0000Oo.O0000o);
                intent.putExtra("extra_data_radius", o000000o.O0000Oo.O0000oO0);
                intent.putExtra("extra_data_poid", o000000o.O0000Oo.O0000o0);
                intent.putExtra("poi_name", o000000o.O0000Oo.O0000Ooo);
            }
            intent.putExtra("extra_data_min_radius", 200);
            intent.putExtra("extra_data_max_radius", 1000);
            if (o000000o != null && o000000o.O0000Oo != null) {
                String str = o000000o.O0000Oo.O0000o0O;
                if (TextUtils.equals("enter_fence", str)) {
                    intent.putExtra("extra_data_sub_title", activity.getString(R.string.scene_enter_fence));
                } else if (TextUtils.equals("leave_fence", str)) {
                    intent.putExtra("extra_data_sub_title", activity.getString(R.string.scene_exit_fence));
                }
            } else if (i == 0) {
                intent.putExtra("extra_data_sub_title", activity.getString(R.string.scene_enter_fence));
            } else if (i == 1) {
                intent.putExtra("extra_data_sub_title", activity.getString(R.string.scene_exit_fence));
            }
            activity.startActivityForResult(intent, 107);
        } else if (o000000o2.f4013O000000o == 4) {
            gqg.O00000Oo((int) R.string.mapload_fail);
        }
        return Integer.valueOf(o000000o2.f4013O000000o);
    }
}
