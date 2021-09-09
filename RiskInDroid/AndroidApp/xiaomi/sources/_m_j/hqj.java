package _m_j;

import _m_j.hof;
import _m_j.hqs;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.scene.ConstantType;

public final class hqj extends hqd implements hqg, hql<hqs.O00000o0, hof.O00000o.O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    int f523O000000o;
    public hpx O0000OOo;
    private double O0000Oo;
    private boolean O0000Oo0;
    private double O0000OoO;
    private String O0000Ooo;
    private String O0000o00;

    public hqj(int i, int i2, int i3, int i4, hpx hpx) {
        super(i, i2, i3, i4);
        this.O0000OOo = hpx;
    }

    public hqj(int i, int i2, int i3, int i4, hpx hpx, String str) {
        super(i, i2, i3, i4);
        this.O0000OOo = hpx;
        if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_SUNSET.key)) {
            this.f523O000000o = 1;
        }
        if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_SUNRISE.key)) {
            this.f523O000000o = 2;
        }
        if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_TEMPERATURE.key)) {
            this.f523O000000o = 3;
        }
        if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_HUMIDITY.key)) {
            this.f523O000000o = 4;
        }
        if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_AQI.key)) {
            this.f523O000000o = 5;
        }
    }

    public final int O000000o(Activity activity) {
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (!TextUtils.isEmpty(O0000Oo02.getAddr()) || !fux.O000000o(activity)) {
            TextUtils.isEmpty(O0000Oo02.getLocationId());
            return -1;
        }
        ExternalLoadManager.instance.loadExternal("amap2d", new fkv(activity) {
            /* class _m_j.$$Lambda$hqj$YVybh8FgclTJG36FiBRdtONl4E */
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final Object call(Object obj) {
                return hqj.this.O000000o(this.f$1, (ExternalLoadManager.O000000o) obj);
            }
        });
        return 1002;
    }

    public final void O000000o(Intent intent) {
        this.O0000Oo0 = true;
        this.O0000Oo = intent.getDoubleExtra("longitude", 0.0d);
        this.O0000OoO = intent.getDoubleExtra("latitude", 0.0d);
        hpv O00000o0 = hjk.O00000o0(this.O0000OoO, this.O0000Oo);
        this.O0000Oo = O00000o0.f511O000000o;
        this.O0000OoO = O00000o0.O00000Oo;
        this.O0000o00 = intent.getStringExtra("home_address");
        this.O0000Ooo = intent.getStringExtra("city_id");
    }

    public final int p_() {
        return this.O00000oO == 4 ? -1 : 3;
    }

    public final boolean O0000Oo0() {
        Home O00000o = ggb.O00000Oo().O00000o(this.O0000OOo.O00000o);
        if ((O00000o == null || TextUtils.isEmpty(O00000o.getAddr())) && !this.O0000Oo0) {
            return false;
        }
        return true;
    }

    public final boolean n_() {
        return this.O0000Oo0;
    }

    public final double O00000Oo() {
        return this.O0000Oo;
    }

    public final double O00000o0() {
        return this.O0000OoO;
    }

    public final String O00000o() {
        return this.O0000Ooo;
    }

    public final String O00000oO() {
        return this.O0000o00;
    }

    public final /* synthetic */ Object o_() {
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo02 != null && !TextUtils.isEmpty(O0000Oo02.getAddr())) {
            hqs.O00000o0 o00000o0 = new hqs.O00000o0();
            o00000o0.f536O000000o = this.O00000Oo;
            o00000o0.O00000Oo = "cloud";
            o00000o0.O00000o0 = this.O0000OOo.O00000Oo();
            o00000o0.O00000o = this.O0000OOo.O00000oO;
            if (!TextUtils.isEmpty(this.O0000OOo.O00000o)) {
                o00000o0.O0000O0o = new hqs.O00000Oo(this.O0000OOo.O00000o);
                o00000o0.O00000oo = 5;
                return o00000o0;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
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
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: private */
    public /* synthetic */ Integer O000000o(Activity activity, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        if (o000000o.f4013O000000o == 3) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(activity, "com.xiaomi.smarthome.scene.newui.amappoi.AmapRecSceneSetHomePage"));
            intent.putExtra("extra_data_min_radius", 200);
            intent.putExtra("extra_data_max_radius", 2000);
            intent.putExtra("home_id", this.O0000OOo.O00000o);
            intent.putExtra("is_pin_mode", true);
            activity.startActivityForResult(intent, 1002);
        } else if (o000000o.f4013O000000o == 4) {
            gqg.O00000Oo((int) R.string.mapload_fail);
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }
}
