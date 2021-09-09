package _m_j;

import _m_j.dpf;
import _m_j.dpm;
import _m_j.dpo;
import _m_j.dpp;
import _m_j.dpq;
import _m_j.dpr;
import _m_j.dps;
import _m_j.dpy;
import _m_j.dpz;
import _m_j.dqa;
import _m_j.dqb;
import _m_j.dqd;
import _m_j.dqe;
import _m_j.dqg;
import _m_j.dqi;
import _m_j.dql;
import _m_j.dqm;
import _m_j.dqn;
import _m_j.dqo;
import _m_j.dqp;
import _m_j.dqr;
import _m_j.dqs;
import _m_j.dqv;
import _m_j.dqw;
import _m_j.dqy;
import _m_j.dra;
import _m_j.drb;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.page.Page;
import java.nio.charset.Charset;
import java.util.Stack;

public final class dow {

    /* renamed from: O000000o  reason: collision with root package name */
    public static dpx f14818O000000o = new dpx();
    public static dpv O00000Oo = new dpv();
    public static dpt O00000o0;
    public Stack<dpf> O00000o = new Stack<>();
    public SparseArray<dpf.O000000o> O00000oO = new SparseArray<>();
    public VafContext O00000oo;

    static {
        dpt dpt = new dpt();
        O00000o0 = dpt;
        dpt.O00000Oo = f14818O000000o;
        O00000o0.O00000o0 = O00000Oo;
    }

    public dow() {
        this.O00000oO.put(1, new dpo.O000000o());
        this.O00000oO.put(4, new dpp.O000000o());
        this.O00000oO.put(2, new dps.O000000o());
        this.O00000oO.put(5, new dpm.O000000o());
        this.O00000oO.put(6, new dpq.O000000o());
        this.O00000oO.put(3, new dpr.O000000o());
        this.O00000oO.put(7, new dqy.O000000o());
        this.O00000oO.put(8, new dra.O000000o());
        this.O00000oO.put(9, new dqd.O000000o());
        this.O00000oO.put(10, new dqe.O000000o());
        this.O00000oO.put(14, new dqi.O000000o());
        this.O00000oO.put(15, new dqs.O000000o());
        this.O00000oO.put(16, new Page.O000000o());
        this.O00000oO.put(17, new dqb.O000000o());
        this.O00000oO.put(13, new dqg.O000000o());
        this.O00000oO.put(21, new dpz.O000000o());
        this.O00000oO.put(18, new drb.O000000o());
        this.O00000oO.put(20, new dqa.O000000o());
        if (dou.O000000o()) {
            this.O00000oO.put(19, new dqw.O000000o());
        } else {
            this.O00000oO.put(19, new dqv.O000000o());
        }
        this.O00000oO.put(22, new dqr.O000000o());
        this.O00000oO.put(23, new dpy.O000000o());
        this.O00000oO.put(25, new dql.O000000o());
        this.O00000oO.put(26, new dqm.O000000o());
        this.O00000oO.put(27, new dqn.O000000o());
        this.O00000oO.put(28, new dqo.O000000o());
        this.O00000oO.put(29, new dqp.O000000o());
    }

    public static boolean O000000o(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        bns.O000000o(displayMetrics.density, displayMetrics.widthPixels);
        return true;
    }

    public static int O000000o(byte[] bArr, boolean z) {
        byte[] bArr2 = bArr;
        dpt dpt = O00000o0;
        if (bArr2 != null) {
            dpt.O00000o = null;
            if (bArr2.length > 27) {
                boolean z2 = false;
                String str = new String(bArr2, 0, 5);
                if (TextUtils.equals("ALIVV", str)) {
                    dpu dpu = new dpu();
                    dpu.O00000Oo = bArr2;
                    if (dpu.O00000Oo != null) {
                        dpu.O00000o = dpu.O00000Oo.length;
                    } else {
                        dpu.O00000o = 0;
                    }
                    dpu.O00000o0 = 0;
                    dpu.O000000o(5);
                    short O00000Oo2 = dpu.O00000Oo();
                    short O00000Oo3 = dpu.O00000Oo();
                    dpu.f14843O000000o = dpu.O00000Oo();
                    if (1 == O00000Oo2 && O00000Oo3 == 0) {
                        int O00000o02 = dpu.O00000o0();
                        dpu.O000000o(4);
                        int O00000o03 = dpu.O00000o0();
                        dpu.O000000o(4);
                        int O00000o04 = dpu.O00000o0();
                        dpu.O000000o(4);
                        int O00000o05 = dpu.O00000o0();
                        dpu.O000000o(4);
                        short O00000Oo4 = dpu.O00000Oo();
                        int O00000Oo5 = dpu.O00000Oo();
                        if (O00000Oo5 > 0) {
                            dpt.O00000o = new int[O00000Oo5];
                            for (int i = 0; i < O00000Oo5; i++) {
                                dpt.O00000o[i] = dpu.O00000Oo();
                            }
                        }
                        if (dpu.O00000Oo(O00000o02)) {
                            dpx dpx = dpt.O00000Oo;
                            Log.w("UiCodeLoader_TMTEST", "load view count: ".concat(String.valueOf(dpu.O00000o0())));
                            short O00000Oo6 = dpu.O00000Oo();
                            String str2 = new String(dpu.O00000Oo, dpu.O00000o0, O00000Oo6, Charset.forName("UTF-8"));
                            Log.w("UiCodeLoader_TMTEST", "load view name ".concat(str2));
                            dpx.O00000Oo.put(str2, dpu);
                            dpu.O000000o(O00000Oo6);
                            short O00000Oo7 = dpu.O00000Oo();
                            dpx.f14845O000000o.put(str2, Integer.valueOf(dpu.O00000o0));
                            if (!dpu.O000000o(O00000Oo7)) {
                                Log.e("UiCodeLoader_TMTEST", "seekBy error:".concat(String.valueOf((int) O00000Oo7)));
                            } else {
                                z2 = true;
                            }
                            if (dpu.O00000o0 != O00000o03) {
                                Log.e("BinaryLoader_TMTEST", "string pos error:" + O00000o03 + "  read pos:" + dpu.O00000o0);
                            } else if (dpt.f14842O000000o != null) {
                                z2 = dpt.f14842O000000o.O000000o(dpu, O00000Oo4);
                            } else {
                                Log.e("BinaryLoader_TMTEST", "mStringManager is null");
                            }
                            if (dpu.O00000o0 != O00000o04) {
                                Log.e("BinaryLoader_TMTEST", "expr pos error:" + O00000o04 + "  read pos:" + dpu.O00000o0);
                            } else if (dpt.O00000o0 != null) {
                                z2 = dpt.O00000o0.O000000o(dpu);
                            } else {
                                Log.e("BinaryLoader_TMTEST", "mExprCodeStore is null");
                            }
                            if (dpu.O00000o0 != O00000o05) {
                                Log.e("BinaryLoader_TMTEST", "extra pos error:" + O00000o05 + "  read pos:" + dpu.O00000o0);
                            }
                            if (z2) {
                                return O00000Oo4;
                            }
                        }
                    } else {
                        Log.e("BinaryLoader_TMTEST", "version dismatch");
                    }
                } else {
                    Log.e("BinaryLoader_TMTEST", "loadFromBuffer failed tag is invalidate:".concat(str));
                }
            } else {
                Log.e("BinaryLoader_TMTEST", "file len invalidate:" + bArr2.length);
            }
        } else {
            Log.e("BinaryLoader_TMTEST", "buf is null");
        }
        return -1;
    }

    public final boolean O000000o(int i, dpf.O000000o o000000o) {
        if (this.O00000oO.get(i) == null) {
            this.O00000oO.put(i, o000000o);
            return true;
        }
        Log.e("ViewFac_TMTEST", "register builder failed, already exist id:".concat(String.valueOf(i)));
        return false;
    }
}
