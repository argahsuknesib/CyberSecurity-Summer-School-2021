package _m_j;

import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.ProductModel;
import com.xiaomi.smarthome.newui.card.profile.TouchView;
import com.xiaomi.smarthome.newui.card.profile.YeelightControlView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hdy extends hec {
    public hdz O0000o;
    YeelightControlView O0000o0o;
    String O0000oO0 = "off";

    public hdy(hed hed) {
        super(hed);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        this.O0000o0o = (YeelightControlView) O000000o(viewGroup, (int) R.layout.card_item_palette).findViewById(R.id.controlView);
        YeelightControlView yeelightControlView = this.O0000o0o;
        if (yeelightControlView != null) {
            yeelightControlView.setProductModel(new ProductModel.O000000o("yeelink.light.color1"));
            yeelightControlView.O000O0o = new YeelightControlView.O000000o() {
                /* class _m_j.hdy.AnonymousClass1 */

                public final void O000000o(int i) {
                    if (!hdy.this.O0000Oo0) {
                        hdy hdy = hdy.this;
                        Integer valueOf = Integer.valueOf(i);
                        hdy.O000000o((hdb) hdy.O00000o0.get(0), hdy.this.O00000oO(), ((hed) hdy.O0000Ooo).O00000o0, valueOf, null);
                    }
                }

                public final void O00000Oo(int i) {
                    if (!hdy.this.O0000Oo0) {
                        hdy hdy = hdy.this;
                        Integer valueOf = Integer.valueOf(i);
                        Device O00000oO = hdy.this.O00000oO();
                        if (hdy.O0000o != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("id", (int) ((Math.random() * 100000.0d) + 100000.0d));
                                jSONObject.put("method", "set_ct_abx");
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(0, valueOf);
                                jSONArray.put(1, "smooth");
                                jSONArray.put(2, 500);
                                jSONObject.put("params", jSONArray);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            fbm.O000000o(O00000oO.did, O00000oO.token, jSONObject.toString(), null);
                        }
                    }
                }
            };
            int O0000O0o = O0000O0o();
            int O0000Oo0 = O0000Oo0();
            this.O0000oO0 = O000000o(O00000oO(), (hdb) this.O00000o0.get(0)) ? "on" : "off";
            yeelightControlView.O000000o(new hdv(this.O0000oO0, TouchView.ControlMode.SUNSHINE.ordinal(), O0000O0o, O0000Oo0, -65536, !this.O0000oO0.equals("on"), (byte) 0));
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        YeelightControlView yeelightControlView = this.O0000o0o;
        if (yeelightControlView != null) {
            yeelightControlView.O00000Oo();
            yeelightControlView.O000000o();
            yeelightControlView.O00000o0();
            yeelightControlView.O00000o();
            TouchView touchView = yeelightControlView.O00000o;
            if (touchView.O00000Oo != null) {
                touchView.O00000Oo.recycle();
                touchView.O00000Oo = null;
            }
            if (yeelightControlView.O0000Oo != null && !yeelightControlView.O0000Oo.isRecycled()) {
                yeelightControlView.O00000o0.setBackgroundDrawable(null);
                yeelightControlView.O0000Oo.recycle();
                yeelightControlView.O0000Oo = null;
            }
        }
        this.O0000o0o = null;
        this.O0000o = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, int):int
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, double):double
      _m_j.hhc.O000000o(java.lang.Object, int):int */
    private int O0000O0o() {
        Object O000000o2 = hed.O000000o((hed) this.O0000Ooo, O00000oO(), (String) hfa.O000000o((Object[]) this.f18773O000000o));
        if (O000000o2 != null && (O000000o2 instanceof String)) {
            return hhc.O000000o((Object) ((String) O000000o2), 0);
        }
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, int):int
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, double):double
      _m_j.hhc.O000000o(java.lang.Object, int):int */
    private int O0000Oo0() {
        Object O0000O0o;
        hdz hdz = this.O0000o;
        if (hdz == null || (O0000O0o = hdz.O0000O0o()) == null || !(O0000O0o instanceof String)) {
            return 1700;
        }
        return hhc.O000000o((Object) ((String) O0000O0o), 0);
    }

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        YeelightControlView yeelightControlView;
        if (!this.O0000Oo0 && O00000oO() != null && (yeelightControlView = this.O0000o0o) != null && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            int O0000O0o = O0000O0o();
            int O0000Oo0 = O0000Oo0();
            String str = O000000o(O00000oO(), (hdb) this.O00000o0.get(0)) ? "on" : "off";
            boolean z = !str.equals("on");
            if (!this.O0000oO0.equals(str)) {
                yeelightControlView.O000000o(new hdv(str, TouchView.ControlMode.SUNSHINE.ordinal(), O0000O0o, O0000Oo0, -65536, z, (byte) 0));
                this.O0000oO0 = str;
            }
        }
    }
}
