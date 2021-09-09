package _m_j;

import _m_j.dpf;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.grid.GridImp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dqb extends dpe {
    private GridImp O000o00O;

    public final boolean O0000Oo0() {
        return true;
    }

    public dqb(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o00O = new GridImp(vafContext.O0000O0o());
        this.O000o00O.setVirtualView(this);
        this.f14827O000000o = this.O000o00O;
    }

    public final void O00000o() {
        super.O00000o();
        O00000Oo();
    }

    private void O00000Oo() {
        don O0000OoO = this.O000OoO0.O0000OoO();
        int childCount = this.O000o00O.getChildCount();
        for (int i = 0; i < childCount; i++) {
            O0000OoO.O000000o((dpb) this.O000o00O.getChildAt(i));
        }
        this.O000o00O.removeAllViews();
    }

    public final void O00000Oo(Object obj) {
        super.O00000Oo(obj);
        if (obj instanceof JSONObject) {
            obj = ((JSONObject) obj).optJSONArray(O000OO());
        }
        O00000Oo();
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            don O0000OoO = this.O000OoO0.O0000OoO();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("type");
                    if (!TextUtils.isEmpty(optString)) {
                        View O000000o2 = O0000OoO.O000000o(optString);
                        if (O000000o2 != null) {
                            dpf virtualView = ((dpb) O000000o2).getVirtualView();
                            virtualView.O000000o(jSONObject);
                            this.O000o00O.addView(O000000o2);
                            if (virtualView.O0000oo0()) {
                                this.O000OoO0.O00000Oo().O000000o(1, dpj.O000000o(this.O000OoO0, virtualView));
                            }
                            virtualView.O00000o0();
                        } else {
                            Log.e("Grid_TMTEST", "create view failed");
                        }
                    } else {
                        Log.e("Grid_TMTEST", "get type failed");
                    }
                } catch (JSONException e) {
                    Log.e("Grid_TMTEST", "get json object failed:".concat(String.valueOf(e)));
                }
            }
            return;
        }
        Log.e("Grid_TMTEST", "setData not array");
    }

    public final void O00000oO() {
        super.O00000oO();
        this.O000o00O.setAutoDimDirection(this.O000O0o0);
        this.O000o00O.setAutoDimX(this.O000O0o);
        this.O000o00O.setAutoDimY(this.O000O0oO);
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i == 196203191) {
            this.O000o00O.setItemVerticalMargin(bns.O00000Oo((double) f));
            return true;
        } else if (i == 1671241242) {
            this.O000o00O.setItemHeight(bns.O00000Oo((double) f));
            return true;
        } else if (i != 2129234981) {
            return false;
        } else {
            this.O000o00O.setItemHorizontalMargin(bns.O00000Oo((double) f));
            return true;
        }
    }

    public final boolean O00000o0(int i, int i2) {
        switch (i) {
            case -669528209:
                this.O000o00O.setColumnCount(i2);
                break;
            case 196203191:
                this.O000o00O.setItemVerticalMargin(bns.O00000Oo((double) i2));
                break;
            case 1671241242:
                this.O000o00O.setItemHeight(bns.O00000Oo((double) i2));
                break;
            case 2129234981:
                this.O000o00O.setItemHorizontalMargin(bns.O00000Oo((double) i2));
                break;
            default:
                return super.O00000o0(i, i2);
        }
        return true;
    }

    public final boolean O000000o(int i, String str) {
        if (i == 196203191) {
            this.O00000Oo.O000000o(this, 196203191, str, 1);
            return true;
        } else if (i != 2129234981) {
            return super.O000000o(i, str);
        } else {
            this.O00000Oo.O000000o(this, 2129234981, str, 1);
            return true;
        }
    }

    public final boolean O000000o(int i, float f) {
        if (i == 196203191) {
            this.O000o00O.setItemVerticalMargin(bns.O000000o((double) f));
        } else if (i == 1671241242) {
            this.O000o00O.setItemHeight(bns.O000000o((double) f));
        } else if (i != 2129234981) {
            return super.O000000o(i, f);
        } else {
            this.O000o00O.setItemHorizontalMargin(bns.O000000o((double) f));
        }
        return true;
    }

    public final boolean O00000Oo(int i, int i2) {
        if (i == 196203191) {
            this.O000o00O.setItemVerticalMargin(bns.O000000o((double) i2));
        } else if (i == 1671241242) {
            this.O000o00O.setItemHeight(bns.O000000o((double) i2));
        } else if (i != 2129234981) {
            return super.O00000Oo(i, i2);
        } else {
            this.O000o00O.setItemHorizontalMargin(bns.O000000o((double) i2));
        }
        return true;
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqb(vafContext, dpg);
        }
    }
}
