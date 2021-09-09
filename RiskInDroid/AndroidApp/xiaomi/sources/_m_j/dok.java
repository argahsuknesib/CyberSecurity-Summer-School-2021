package _m_j;

import _m_j.dpd;
import _m_j.dpf;
import _m_j.dpg;
import android.util.Log;
import android.util.SparseArray;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.List;

public final class dok {

    /* renamed from: O000000o  reason: collision with root package name */
    public dow f14808O000000o = new dow();
    public o0O0OOO0<String, List<dpf>> O00000Oo = new o0O0OOO0<>();
    private SparseArray<dpf> O00000o = new SparseArray<>();
    public VafContext O00000o0;

    public final dpf O000000o() {
        dqe dqe = new dqe(this.O00000o0, new dpg());
        dqe.O000000o(new dpd.O000000o());
        return dqe;
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01d2 A[LOOP:0: B:15:0x008c->B:69:0x01d2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d8 A[EDGE_INSN: B:84:0x01d8->B:70:0x01d8 ?: BREAK  , SYNTHETIC] */
    public final dpf O000000o(String str) {
        dpd dpd;
        dpu dpu;
        dpf dpf;
        dpd.O000000o o000000o;
        List list = this.O00000Oo.get(str);
        if (list != null && list.size() != 0) {
            return (dpf) list.remove(0);
        }
        dow dow = this.f14808O000000o;
        SparseArray<dpf> sparseArray = this.O00000o;
        if (dow.O00000o0 != null) {
            dpx dpx = dow.f14818O000000o;
            if (!dpx.O00000Oo.containsKey(str) || !dpx.f14845O000000o.containsKey(str)) {
                Log.e("UiCodeLoader_TMTEST", "getCode type invalide type:" + str + dpx.O00000Oo.containsKey(str) + " " + dpx.f14845O000000o.containsKey(str));
                dpu = null;
            } else {
                dpu = dpx.O00000Oo.get(str);
                dpu.O00000Oo(dpx.f14845O000000o.get(str).intValue());
            }
            if (dpu != null) {
                dow.O00000o.clear();
                byte O000000o2 = dpu.O000000o();
                dpg dpg = new dpg();
                dpd = null;
                char c = 0;
                while (true) {
                    if (O000000o2 != 0) {
                        if (O000000o2 == 1) {
                            if (dow.O00000o.size() > 0) {
                                dpf pop = dow.O00000o.pop();
                                if (pop instanceof dpd) {
                                    ((dpd) pop).O000000o((dpf) dpd);
                                } else {
                                    Log.e("ViewFac_TMTEST", "com can not contain subcomponent");
                                    c = 2;
                                }
                                dpd = pop;
                            } else {
                                c = 1;
                            }
                            if (c != 0) {
                                break;
                            }
                            O000000o2 = dpu.O000000o();
                        } else {
                            Log.e("ViewFac_TMTEST", "invalidate tag type:".concat(String.valueOf((int) O000000o2)));
                        }
                    } else {
                        short O00000Oo2 = dpu.O00000Oo();
                        VafContext vafContext = dow.O00000oo;
                        dpf.O000000o o000000o2 = dow.O00000oO.get(O00000Oo2);
                        if (o000000o2 != null) {
                            dpf = o000000o2.O000000o(vafContext, dpg);
                        } else {
                            dpf = null;
                        }
                        if (dpf != null) {
                            if (dpd != null) {
                                o000000o = dpd.O000000o();
                                dow.O00000o.push(dpd);
                            } else {
                                o000000o = new dpd.O000000o();
                            }
                            dpf.O000000o(o000000o);
                            for (byte O000000o3 = dpu.O000000o(); O000000o3 > 0; O000000o3 = (byte) (O000000o3 - 1)) {
                                dpf.O0000O0o(dpu.O00000o0(), dpu.O00000o0());
                            }
                            for (byte O000000o4 = dpu.O000000o(); O000000o4 > 0; O000000o4 = (byte) (O000000o4 - 1)) {
                                dpf.O00000oo(dpu.O00000o0(), dpu.O00000o0());
                            }
                            for (byte O000000o5 = dpu.O000000o(); O000000o5 > 0; O000000o5 = (byte) (O000000o5 - 1)) {
                                dpf.O00000o(dpu.O00000o0(), Float.intBitsToFloat(dpu.O00000o0()));
                            }
                            for (byte O000000o6 = dpu.O000000o(); O000000o6 > 0; O000000o6 = (byte) (O000000o6 - 1)) {
                                dpf.O00000o0(dpu.O00000o0(), Float.intBitsToFloat(dpu.O00000o0()));
                            }
                            for (byte O000000o7 = dpu.O000000o(); O000000o7 > 0; O000000o7 = (byte) (O000000o7 - 1)) {
                                dpf.O00000oO(dpu.O00000o0(), dpu.O00000o0());
                            }
                            for (byte O000000o8 = dpu.O000000o(); O000000o8 > 0; O000000o8 = (byte) (O000000o8 - 1)) {
                                dpf.O000000o(dpu.O00000o0(), dow.O00000Oo.f14844O000000o.get(Integer.valueOf(dpu.O00000o0())));
                            }
                            for (byte O000000o9 = dpu.O000000o(); O000000o9 > 0; O000000o9 = (byte) (O000000o9 - 1)) {
                                dpf.O00000Oo(dpu.O000000o(), dpu.O00000o0(), dpu.O00000o0());
                            }
                            int O0000o = dpf.O0000o();
                            if (O0000o > 0 && sparseArray != null) {
                                sparseArray.put(O0000o, dpf);
                            }
                            List<dpg.O000000o> O000000o10 = dpg.O000000o(dpf);
                            if (O000000o10 == null || O000000o10.isEmpty()) {
                                dpf.O00000oO();
                            }
                            dpd = dpf;
                            if (c != 0) {
                            }
                        } else {
                            Log.e("ViewFac_TMTEST", "can not find view id:".concat(String.valueOf((int) O00000Oo2)));
                        }
                    }
                    c = 2;
                    if (c != 0) {
                    }
                }
                if (1 == c) {
                    dpu.O00000Oo(9);
                    dpd.O00000o(dpu.O00000Oo());
                    if (dpd == null) {
                        if (dpd.O0000oOo()) {
                            dmv O0000OOo = this.O00000o0.O0000OOo();
                            if (dpd != null) {
                                O0000OOo.f14796O000000o.add(dpd);
                            }
                        }
                        dpd.O00000Oo(str);
                    } else {
                        Log.e("ViewManager_TMTEST", "new view failed type:".concat(String.valueOf(str)));
                    }
                    return dpd;
                }
            } else {
                Log.e("ViewFac_TMTEST", "can not find component type:".concat(String.valueOf(str)));
            }
        } else {
            Log.e("ViewFac_TMTEST", "loader is null");
        }
        dpd = null;
        if (dpd == null) {
        }
        return dpd;
    }
}
