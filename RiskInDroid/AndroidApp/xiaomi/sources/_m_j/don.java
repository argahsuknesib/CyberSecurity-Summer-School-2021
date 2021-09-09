package _m_j;

import _m_j.dpd;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class don {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dol f14811O000000o;
    private VafContext O00000Oo;
    private List<dom> O00000o = new ArrayList(20);
    private dok O00000o0;

    public don() {
        O000000o(new doo(), 0);
        O000000o(new doo(), 1);
    }

    private void O000000o(dom dom, int i) {
        if (i < 0 || i >= 20) {
            Log.e("ContainerService_TMTEST", "param invalidate containerID:".concat(String.valueOf(i)));
        } else {
            this.O00000o.add(i, dom);
        }
    }

    public final void O000000o(VafContext vafContext) {
        this.O00000Oo = vafContext;
        this.O00000o0 = this.O00000Oo.O0000Oo();
        this.f14811O000000o = this.O00000Oo.O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.don.O000000o(java.lang.String, boolean):android.view.View
     arg types: [java.lang.String, int]
     candidates:
      _m_j.don.O000000o(_m_j.dom, int):void
      _m_j.don.O000000o(java.lang.String, boolean):android.view.View */
    public final View O000000o(String str) {
        return O000000o(str, true);
    }

    public final View O000000o(String str, boolean z) {
        int O000000o2 = this.f14811O000000o.O000000o(str);
        if (O000000o2 < 0) {
            O000000o2 = 0;
        }
        return O000000o(str, O000000o2, z);
    }

    public final View O000000o(String str, int i, boolean z) {
        dpb dpb;
        dpf O000000o2 = this.O00000o0.O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = this.O00000o0.O000000o();
            O000000o2.O00000Oo(str);
        }
        if (O000000o2.O0000Oo0()) {
            dpb = (dpb) O000000o2.g_();
        } else {
            dom dom = this.O00000o.get(i);
            if (dom != null) {
                dpb = dom.O000000o(this.O00000Oo);
            } else {
                Log.e("ContainerService_TMTEST", "getContainer type invalidate:".concat(String.valueOf(i)));
                dpb = null;
            }
        }
        if (dpb != null) {
            dpb.setVirtualView(O000000o2);
            if (z) {
                dpd.O000000o O000O0oo = O000000o2.O000O0oo();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(O000O0oo.f14826O000000o, O000O0oo.O00000Oo);
                marginLayoutParams.leftMargin = O000O0oo.O00000o;
                marginLayoutParams.topMargin = O000O0oo.O0000OOo;
                marginLayoutParams.rightMargin = O000O0oo.O00000oo;
                marginLayoutParams.bottomMargin = O000O0oo.O0000Oo;
                ((View) dpb).setLayoutParams(marginLayoutParams);
            }
            dpb.attachViews();
        }
        return (View) dpb;
    }

    public final void O000000o(dpb dpb) {
        if (dpb != null) {
            dpf virtualView = dpb.getVirtualView();
            if (virtualView != null) {
                dok dok = this.O00000o0;
                if (virtualView != null) {
                    String O0000oOO = virtualView.O0000oOO();
                    if (!TextUtils.isEmpty(O0000oOO)) {
                        virtualView.O00000o();
                        List list = dok.O00000Oo.get(O0000oOO);
                        if (list == null) {
                            list = new LinkedList();
                            dok.O00000Oo.put(O0000oOO, list);
                        }
                        list.add(virtualView);
                    } else {
                        Log.e("ViewManager_TMTEST", "recycle type invalidate:".concat(String.valueOf(O0000oOO)));
                        RuntimeException runtimeException = new RuntimeException("here");
                        runtimeException.fillInStackTrace();
                        Log.w("ViewManager_TMTEST", "Called: ".concat(String.valueOf(dok)), runtimeException);
                    }
                }
                if (dpb instanceof ViewGroup) {
                    ((ViewGroup) dpb).removeAllViews();
                }
            } else {
                Log.e("ContainerService_TMTEST", "recycle viewbase is null");
            }
            int type = dpb.getType();
            if (type >= 0) {
                dom dom = this.O00000o.get(type);
                if (dom != null) {
                    dom.O000000o(dpb);
                    return;
                }
                Log.e("ContainerService_TMTEST", "recycle container type is invalidate:" + dpb.getType());
            }
        }
    }
}
