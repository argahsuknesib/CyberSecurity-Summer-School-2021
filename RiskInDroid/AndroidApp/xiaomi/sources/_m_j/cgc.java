package _m_j;

import _m_j.cfl;
import _m_j.cfm;
import _m_j.cfs;
import _m_j.cfw;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.deduct.d.d;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.progress.StartProcessModel;
import com.xiaomi.smarthome.R;
import java.util.Iterator;
import java.util.List;

public final class cgc extends BaseMvpPresenter<cfm.O000000o> implements cfl.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private StartProcessModel f13752O000000o;
    private cfs O00000Oo;
    /* access modifiers changed from: private */
    public String O00000o;
    private cfw O00000o0;
    private String O00000oO;
    /* access modifiers changed from: private */
    public String O00000oo;
    private String O0000O0o;

    public cgc() {
        super(cfm.O000000o.class);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        this.f13752O000000o = new StartProcessModel(getSession());
        this.O00000Oo = new cfs(getSession());
        this.O00000o0 = new cfw(getSession());
        this.O0000O0o = getArguments().getString("deductSignAndPayOrder");
        this.O00000oo = getArguments().getString("deductSignAndPayChannel");
        this.O00000oO = e.O000000o(getContext());
        if (bundle != null) {
            return;
        }
        if (TextUtils.isEmpty(this.O0000O0o)) {
            String string = getContext().getString(R.string.mibi_msg_deduct_order_null);
            MibiLog.d("CheckSignDeductOrderPre", string);
            ((cfm.O000000o) getView()).a(9816, string, null);
        } else if (TextUtils.isEmpty(this.O00000oO)) {
            ((cfm.O000000o) getView()).a(9814, getContext().getResources().getString(R.string.mibi_msg_no_available_channels), null);
        } else {
            MibiLog.d("CheckSignDeductOrderPre", "start process");
            ((cfm.O000000o) getView()).a(true);
            this.f13752O000000o.request(null, new IBaseModel.IResultCallback<String>() {
                /* class _m_j.cgc.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MibiLog.d("CheckSignDeductOrderPre", "get processId success");
                    String unused = cgc.this.O00000o = (String) obj;
                    cgc.O00000o(cgc.this);
                }

                public final void onFailed(int i, String str, Throwable th) {
                    ((cfm.O000000o) cgc.this.getView()).a(false);
                    if (i == 1993) {
                        ((cfm.O000000o) cgc.this.getView()).a();
                    } else {
                        ((cfm.O000000o) cgc.this.getView()).a(i, str, null);
                    }
                }
            });
        }
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        super.handleResult(i, i2, bundle);
        MibiLog.d("CheckSignDeductOrderPre", "handleResult req : " + i + " ; res : " + i2);
        if (i == 120) {
            String str = null;
            if (bundle != null) {
                str = bundle.getString("message");
            }
            ((cfm.O000000o) getView()).a(i2, str, bundle);
        }
    }

    static /* synthetic */ void O00000o(cgc cgc) {
        MibiLog.d("CheckSignDeductOrderPre", "start check order");
        cfs cfs = cgc.O00000Oo;
        String str = cgc.O00000o;
        String str2 = cgc.O0000O0o;
        AnonymousClass2 r3 = new cfs.O00000Oo() {
            /* class _m_j.cgc.AnonymousClass2 */

            public final void O000000o(int i, String str, Throwable th) {
                MibiLog.d("CheckSignDeductOrderPre", "check order failed", th);
                ((cfm.O000000o) cgc.this.getView()).a(false);
                ((cfm.O000000o) cgc.this.getView()).a(i, str, null);
            }

            public final void O000000o() {
                MibiLog.d("CheckSignDeductOrderPre", "check order success");
                cgc.this.O00000o0.O000000o(cgc.this.O00000o, cgc.this.O00000oO, new cfw.O00000Oo() {
                    /* class _m_j.cgc.AnonymousClass3 */

                    public final void O000000o(int i, String str) {
                        ((cfm.O000000o) cgc.this.getView()).a(false);
                        ((cfm.O000000o) cgc.this.getView()).a(i, str, null);
                    }

                    public final void O000000o(d.a aVar) {
                        if (aVar.f5134a == null || aVar.f5134a.size() == 0) {
                            ((cfm.O000000o) cgc.this.getView()).a(9813, "no available channels", null);
                        }
                        if (cgc.O000000o(cgc.this.O00000oo, aVar.f5134a)) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("deductSignAndPayChannel", cgc.this.O00000oo);
                            bundle.putString("processId", cgc.this.O00000o);
                            ((cfm.O000000o) cgc.this.getView()).a(bundle);
                            return;
                        }
                        ((cfm.O000000o) cgc.this.getView()).a(9817, "channel not in server channels", null);
                    }
                });
            }
        };
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(new StringBuilder("CheckDeductOrderModel  processId can't be null").toString());
        } else if (!TextUtils.isEmpty(str2)) {
            cfs.O00000Oo = r3;
            cfs.O000000o o000000o = new cfs.O000000o(cfs, cfs.getContext(), (byte) 0);
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("deductSignAndPayOrder", str2);
            sortedParameter.add("processId", str);
            cfs.f13731O000000o.setParams(sortedParameter);
            chh.O000000o(cfs.f13731O000000o).O000000o(o000000o);
        } else {
            throw new IllegalArgumentException(new StringBuilder("CheckDeductOrderModel  order can't be null").toString());
        }
    }

    static /* synthetic */ boolean O000000o(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(((RechargeType) it.next()).mRechargeMethods.get(0).mChannel)) {
                return true;
            }
        }
        return false;
    }
}
