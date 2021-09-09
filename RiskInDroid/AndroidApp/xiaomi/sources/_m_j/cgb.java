package _m_j;

import _m_j.cfl;
import _m_j.cfr;
import _m_j.cfw;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.component.privacy.PrivacyManager;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.deduct.d.d;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.progress.StartProcessModel;
import com.xiaomi.smarthome.R;
import java.util.Iterator;
import java.util.List;

public final class cgb extends BaseMvpPresenter<cfl.O00000Oo> implements cfl.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private StartProcessModel f13748O000000o;
    private cfr O00000Oo;
    /* access modifiers changed from: private */
    public String O00000o;
    private cfw O00000o0;
    private String O00000oO;
    /* access modifiers changed from: private */
    public String O00000oo;
    private String O0000O0o;

    public cgb() {
        super(cfl.O00000Oo.class);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        this.f13748O000000o = new StartProcessModel(getSession());
        this.O00000Oo = new cfr(getSession());
        this.O00000o0 = new cfw(getSession());
        this.O0000O0o = getArguments().getString("deductSignOrder");
        this.O00000oo = getArguments().getString("deductChannel");
        this.O00000oO = e.O000000o(getContext());
        if (bundle != null) {
            return;
        }
        if (TextUtils.isEmpty(this.O0000O0o)) {
            String string = getContext().getString(R.string.mibi_msg_deduct_order_null);
            MibiLog.d("CheckDeductOrderPre", string);
            ((cfl.O00000Oo) getView()).a(9816, string);
        } else if (TextUtils.isEmpty(this.O00000oO)) {
            ((cfl.O00000Oo) getView()).a(9814, getContext().getResources().getString(R.string.mibi_msg_no_available_channels));
        } else {
            MibiLog.d("CheckDeductOrderPre", "start process");
            ((cfl.O00000Oo) getView()).a(true);
            this.f13748O000000o.request(null, new IBaseModel.IResultCallback<String>() {
                /* class _m_j.cgb.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MibiLog.d("CheckDeductOrderPre", "get processId success");
                    String unused = cgb.this.O00000o = (String) obj;
                    PrivacyManager.makePrivacyParam(cgb.this.getSession(), "105", "DEDUCTPAGE");
                    cgb.O00000oO(cgb.this);
                }

                public final void onFailed(int i, String str, Throwable th) {
                    MibiLog.d("CheckDeductOrderPre", "start process failed code : " + i + " ; msg : " + str);
                    ((cfl.O00000Oo) cgb.this.getView()).a(false);
                    if (i == 1993) {
                        ((cfl.O00000Oo) cgb.this.getView()).a();
                    } else {
                        ((cfl.O00000Oo) cgb.this.getView()).a(i, str);
                    }
                }
            });
        }
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        super.handleResult(i, i2, bundle);
        MibiLog.d("CheckDeductOrderPre", "handleResult req: " + i + " ; res : " + i2);
        if (i == 120) {
            String str = null;
            if (bundle != null) {
                str = bundle.getString("message");
            }
            ((cfl.O00000Oo) getView()).a(i2, str);
        }
    }

    static /* synthetic */ void O00000oO(cgb cgb) {
        MibiLog.d("CheckDeductOrderPre", "start check order");
        cfr cfr = cgb.O00000Oo;
        String str = cgb.O00000o;
        String str2 = cgb.O0000O0o;
        AnonymousClass2 r3 = new cfr.O00000Oo() {
            /* class _m_j.cgb.AnonymousClass2 */

            public final void O000000o(int i, String str) {
                ((cfl.O00000Oo) cgb.this.getView()).a(false);
                ((cfl.O00000Oo) cgb.this.getView()).a(i, str);
            }

            public final void O000000o() {
                MibiLog.d("CheckDeductOrderPre", "check order success");
                cgb.O0000OOo(cgb.this);
            }
        };
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(new StringBuilder("CheckDeductOrderModel  processId can't be null").toString());
        } else if (!TextUtils.isEmpty(str2)) {
            cfr.O00000Oo = r3;
            cfr.O000000o o000000o = new cfr.O000000o(cfr, cfr.getContext(), (byte) 0);
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("deductSignOrder", str2);
            sortedParameter.add("processId", str);
            cfr.f13729O000000o.setParams(sortedParameter);
            chh.O000000o(cfr.f13729O000000o).O000000o(o000000o);
        } else {
            throw new IllegalArgumentException(new StringBuilder("CheckDeductOrderModel  order can't be null").toString());
        }
    }

    static /* synthetic */ void O0000OOo(cgb cgb) {
        MibiLog.d("CheckDeductOrderPre", "start get types");
        cgb.O00000o0.O000000o(cgb.O00000o, cgb.O00000oO, new cfw.O00000Oo() {
            /* class _m_j.cgb.AnonymousClass3 */

            public final void O000000o(int i, String str) {
                ((cfl.O00000Oo) cgb.this.getView()).a(false);
                ((cfl.O00000Oo) cgb.this.getView()).a(i, str);
            }

            public final void O000000o(d.a aVar) {
                if (aVar.f5134a == null || aVar.f5134a.size() == 0) {
                    ((cfl.O00000Oo) cgb.this.getView()).a(9813, "no available channels");
                }
                if (cgb.O000000o(cgb.this.O00000oo, aVar.f5134a)) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("deductChannel", cgb.this.O00000oo);
                    bundle.putString("processId", cgb.this.O00000o);
                    ((cfl.O00000Oo) cgb.this.getView()).a(bundle);
                    return;
                }
                ((cfl.O00000Oo) cgb.this.getView()).a(9817, "channel not in server channels");
            }
        });
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
