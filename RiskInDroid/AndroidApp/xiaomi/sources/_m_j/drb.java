package _m_j;

import _m_j.dpf;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.vh.VHImp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class drb extends dpe {
    private VHImp O000o00O;

    public final boolean O0000Oo0() {
        return true;
    }

    public drb(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o00O = new VHImp(vafContext.O0000O0o());
        this.f14827O000000o = this.O000o00O;
    }

    public final void O00000Oo(Object obj) {
        super.O00000Oo(obj);
        if (obj instanceof JSONObject) {
            obj = ((JSONObject) obj).optJSONArray(O000OO());
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            don O0000OoO = this.O000OoO0.O0000OoO();
            int childCount = this.O000o00O.getChildCount();
            for (int i = 0; i < childCount; i++) {
                O0000OoO.O000000o((dpb) this.O000o00O.getChildAt(i));
            }
            this.O000o00O.removeAllViews();
            don O0000OoO2 = this.O000OoO0.O0000OoO();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String optString = jSONObject.optString("type");
                    if (!TextUtils.isEmpty(optString)) {
                        View O000000o2 = O0000OoO2.O000000o(optString);
                        if (O000000o2 != null) {
                            dpf virtualView = ((dpb) O000000o2).getVirtualView();
                            virtualView.O000000o(jSONObject);
                            this.O000o00O.addView(O000000o2);
                            virtualView.O00000o0();
                            if (virtualView.O0000oo0()) {
                                this.O000OoO0.O00000Oo().O000000o(1, dpj.O000000o(this.O000OoO0, virtualView));
                            }
                        } else {
                            Log.e("VH_TMTEST", "create view failed");
                        }
                    } else {
                        Log.e("VH_TMTEST", "get type failed");
                    }
                } catch (JSONException e) {
                    Log.e("VH_TMTEST", "get json object failed:".concat(String.valueOf(e)));
                }
            }
            return;
        }
        Log.e("VH_TMTEST", "setData not array:".concat(String.valueOf(obj)));
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i == 1671241242) {
            this.O000o00O.setItemHeight(bns.O00000Oo((double) f));
            return true;
        } else if (i == 1810961057) {
            this.O000o00O.setItemMargin(bns.O00000Oo((double) f));
            return true;
        } else if (i != 2146088563) {
            return false;
        } else {
            this.O000o00O.setItemWidth(bns.O00000Oo((double) f));
            return true;
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        switch (i) {
            case -1439500848:
                this.O000o00O.setOrientation(i2);
                return true;
            case 1671241242:
                this.O000o00O.setItemHeight(bns.O00000Oo((double) i2));
                return true;
            case 1810961057:
                this.O000o00O.setItemMargin(bns.O00000Oo((double) i2));
                return true;
            case 2146088563:
                this.O000o00O.setItemWidth(bns.O00000Oo((double) i2));
                return true;
            default:
                return false;
        }
    }

    public final boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (O000000o2) {
            return O000000o2;
        }
        if (i == 1671241242) {
            this.O000o00O.setItemHeight(bns.O000000o((double) f));
            return true;
        } else if (i == 1810961057) {
            this.O000o00O.setItemMargin(bns.O000000o((double) f));
            return true;
        } else if (i != 2146088563) {
            return false;
        } else {
            this.O000o00O.setItemWidth(bns.O000000o((double) f));
            return true;
        }
    }

    public final boolean O00000Oo(int i, int i2) {
        boolean O00000Oo = super.O00000Oo(i, i2);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i == 1671241242) {
            this.O000o00O.setItemHeight(bns.O000000o((double) i2));
            return true;
        } else if (i == 1810961057) {
            this.O000o00O.setItemMargin(bns.O000000o((double) i2));
            return true;
        } else if (i != 2146088563) {
            return false;
        } else {
            this.O000o00O.setItemWidth(bns.O000000o((double) i2));
            return true;
        }
    }

    public final boolean O000000o(int i, String str) {
        if (i == 1671241242) {
            this.O00000Oo.O000000o(this, 1671241242, str, 1);
            return true;
        } else if (i == 1810961057) {
            this.O00000Oo.O000000o(this, 1810961057, str, 1);
            return true;
        } else if (i != 2146088563) {
            return super.O000000o(i, str);
        } else {
            this.O00000Oo.O000000o(this, 2146088563, str, 1);
            return true;
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new drb(vafContext, dpg);
        }
    }
}
