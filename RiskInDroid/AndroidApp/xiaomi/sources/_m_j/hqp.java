package _m_j;

import _m_j.hof;
import _m_j.hqs;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.ConstantType;

public final class hqp extends hqe implements hqg, hql<hqs.O0000Oo0, hof.O0000O0o.O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f527O000000o;
    public long O0000OOo;
    public float O0000Oo;
    public String O0000Oo0;
    public boolean O0000OoO;
    public String O0000Ooo;
    private double O0000o0;
    private double O0000o00;
    private String O0000o0O;

    public hqp(int i, int i2, int i3, int i4, String str) {
        super(i, i2, i3, i4);
        this.f527O000000o = str;
    }

    public final int p_() {
        return this.O00000oO == 4 ? -1 : 3;
    }

    public final int O000000o(Activity activity) {
        if (!fux.O000000o(activity)) {
            return -1;
        }
        ExternalLoadManager.instance.loadExternal("amap2d", new fkv(activity) {
            /* class _m_j.$$Lambda$hqp$sR6r9h3eH52qYJMhemWsFNxB3M */
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final Object call(Object obj) {
                return hqp.this.O000000o(this.f$1, (ExternalLoadManager.O000000o) obj);
            }
        });
        return 1002;
    }

    public final void O000000o(Intent intent) {
        this.O0000OoO = true;
        this.O0000o00 = intent.getDoubleExtra("longitude", 0.0d);
        this.O0000o0 = intent.getDoubleExtra("latitude", 0.0d);
        float floatExtra = intent.getFloatExtra("radius", -1.0f);
        if (floatExtra > 200.0f && floatExtra < 2000.0f) {
            this.O0000Oo = floatExtra;
        }
        hpv O00000o0 = hjk.O00000o0(this.O0000o0, this.O0000o00);
        this.O0000o00 = O00000o0.f511O000000o;
        this.O0000o0 = O00000o0.O00000Oo;
        this.O0000Ooo = intent.getStringExtra("home_address");
        this.O0000o0O = intent.getStringExtra("city_id");
    }

    public final boolean n_() {
        return this.O0000OoO;
    }

    public final double O00000Oo() {
        return this.O0000o00;
    }

    public final double O00000o0() {
        return this.O0000o0;
    }

    public final String O00000o() {
        return this.O0000o0O;
    }

    public final String O00000oO() {
        return this.O0000Ooo;
    }

    public final /* synthetic */ Object o_() {
        String str;
        hqs.O0000Oo0 o0000Oo0 = new hqs.O0000Oo0();
        o0000Oo0.O00000Oo = "location";
        o0000Oo0.f538O000000o = this.O00000Oo;
        if (TextUtils.equals(ConstantType.TriggerConditionType.LOCATION_ENTER.key, this.f527O000000o)) {
            str = ServiceApplication.getAppContext().getString(R.string.enter);
        } else {
            str = TextUtils.equals(ConstantType.TriggerConditionType.LOCATION_LEAVE.key, this.f527O000000o) ? ServiceApplication.getAppContext().getString(R.string.leave) : "";
        }
        o0000Oo0.O00000o0 = str;
        o0000Oo0.O00000oo = this.f527O000000o;
        o0000Oo0.O00000oO = 5;
        o0000Oo0.O0000O0o = new hqs.O0000OOo(this.O0000OOo, this.O0000Oo0, this.O0000Oo);
        return o0000Oo0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer O000000o(Activity activity, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        if (o000000o.f4013O000000o == 3) {
            Intent intent = new Intent();
            intent.setClassName(activity, "com.xiaomi.smarthome.scene.newui.amappoi.AmapRecSceneSetHomePage");
            intent.putExtra("extra_data_min_radius", 200);
            intent.putExtra("extra_data_max_radius", 2000);
            intent.putExtra("home_id", this.O0000Oo0);
            activity.startActivityForResult(intent, 1002);
        } else if (o000000o.f4013O000000o == 4) {
            gqg.O00000Oo((int) R.string.mapload_fail);
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }
}
