package _m_j;

import _m_j.cfo;
import _m_j.cfx;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.WXUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.common.utils.QueryIntervalUtils;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.deduct.d.j;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.task.AutoQuerier;
import com.mibi.sdk.task.DefaultAutoQueryCallback;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.xiaomi.smarthome.R;

public final class cge extends BaseMvpPresenter<cfo.O00000o0> implements cfo.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public Activity f13760O000000o;
    /* access modifiers changed from: private */
    public int[] O00000Oo = {0, 1, 2, 2};
    /* access modifiers changed from: private */
    public String O00000o;
    private cfx O00000o0;
    private String O00000oO;
    /* access modifiers changed from: private */
    public AutoQuerier O00000oo;
    private j O0000O0o;
    private O000000o O0000OOo;
    /* access modifiers changed from: private */
    public AutoQuerier.AutoQuerierCallback O0000Oo0 = new DefaultAutoQueryCallback() {
        /* class _m_j.cge.AnonymousClass1 */

        public final void onComplete() {
            cge.this.O000000o();
        }
    };

    public cge() {
        super(cfo.O00000o0.class);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: _m_j.cfz} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: _m_j.cfq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: _m_j.cfz} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: _m_j.cfz} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void onInit(Bundle bundle) {
        cfz cfz;
        super.onInit(bundle);
        if (bundle == null) {
            this.O00000oO = getArguments().getString("processId");
            this.O00000o = getArguments().getString("deductSignAndPayChannel");
        } else {
            this.O00000oO = bundle.getString("processId");
            this.O00000o = bundle.getString("deductSignAndPayChannel");
        }
        Log.d("SignDeductPresenter", "createModel");
        if (e.a.ALIPAY.b().equals(this.O00000o)) {
            cfq cfq = new cfq(getSession(), this.O00000oO);
            cfq.f13723O000000o = this.f13760O000000o;
            addLifeCycleListener(cfq);
            cfz = cfq;
        } else if (e.a.WXPAY.b().equals(this.O00000o)) {
            cfz = new cfz(getSession(), this.O00000oO);
        } else {
            throw new IllegalStateException("mChannelName:" + this.O00000o);
        }
        cfz.O00000o = new O00000Oo(this, (byte) 0);
        this.O00000o0 = cfz;
        int[] queryInterval = QueryIntervalUtils.getQueryInterval((String) getSession().getMemoryStorage().getSerializable("mibi_extra_params"));
        if (queryInterval == null || queryInterval.length <= 0) {
            MibiLog.d("SignDeductPresenter", "interval is null");
        } else {
            this.O00000Oo = queryInterval;
        }
        if (bundle == null) {
            this.O00000o0.O000000o();
        }
    }

    public final void O00000Oo() {
        cfx cfx;
        Log.d("SignDeductPresenter", "checkNeedQuery");
        int i = 0;
        if (getSession().getMemoryStorage().getBoolean(this.O00000oO, "signDeductStart", false) && (cfx = this.O00000o0) != null) {
            if (cfx instanceof cfz) {
                cfz cfz = (cfz) cfx;
                MibiLog.d("WxpaySignDeductModel", "restore wx sign deduct result");
                if (TextUtils.isEmpty(cfz.O00000o0)) {
                    MibiLog.e("WxpaySignDeductModel", "mProcessId is null");
                    return;
                }
                String string = WXUtils.getString(cfz.getContext(), "prepayid");
                String string2 = WXUtils.getString(cfz.getContext(), string);
                WXUtils.removeString(cfz.getContext(), "prepayid");
                WXUtils.removeString(cfz.getContext(), string);
                if (TextUtils.isEmpty(string2)) {
                    MibiLog.d("WxpaySignDeductModel", "has not received result from weiChat");
                    cfz.O00000o.O000000o(9824, "has not received result from weiChat");
                }
                if (!TextUtils.isEmpty(string)) {
                    try {
                        i = Integer.parseInt(string2);
                    } catch (NumberFormatException unused) {
                        MibiLog.d("WxpaySignDeductModel", "errorCode is null");
                    }
                    if (i == 0) {
                        i = 9824;
                    }
                    cfz.O000000o(i);
                    return;
                }
                MibiLog.d("WxpaySignDeductModel", "prepayid is null");
                cfz.O000000o(9848);
            } else if (cfx instanceof cfq) {
                cfq cfq = (cfq) cfx;
                if (cfq.getSession().getMemoryStorage().getBoolean(cfq.O00000o0, "signDeductStart", false) && !cfq.O00000Oo) {
                    cfq.O00000Oo();
                }
            }
        }
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.O00000oO);
        bundle.putString("deductSignAndPayChannel", this.O00000o);
    }

    class O00000Oo implements cfx.O000000o {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(cge cge, byte b) {
            this();
        }

        public final void O000000o(int i, String str) {
            Log.d("SignDeductPresenter", "handleDeductError errorCode : " + i + "  ; errDesc : " + str);
            ((cfo.O00000o0) cge.this.getView()).a(i, str, null);
        }

        public final void O000000o() {
            Log.d("SignDeductPresenter", "requestQueryResult");
            cge.this.O000000o();
        }

        public final void O000000o(cfo.O000000o<Activity> o000000o) {
            ((cfo.O00000o0) cge.this.getView()).a(o000000o);
        }
    }

    public final void O000000o() {
        ((cfo.O00000o0) getView()).a(true);
        if (this.O0000O0o == null) {
            this.O0000O0o = new j(getContext(), getSession());
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", this.O00000oO);
            sortedParameter.add("deductSignAndPayChannel", this.O00000o);
            this.O0000O0o.setParams(sortedParameter);
            this.O0000OOo = new O000000o(getContext());
        }
        chh.O000000o(this.O0000O0o).O000000o(this.O0000OOo);
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        super.handleResult(i, i2, bundle);
        Log.d("SignDeductPresenter", "handleResult requestCode : " + i + " ; resultCode : " + i2);
        this.O00000o0.handleResult(i, i2, bundle);
        if (i == 200 && (i2 == 9822 || i2 == 9823)) {
            ((cfo.O00000o0) getView()).a(i2, "cancel by user", bundle);
        } else if (i2 == 9820) {
            ((cfo.O00000o0) getView()).a(9820, "deduct success", bundle);
        }
    }

    class O000000o extends RxBaseErrorHandleTaskListener<j.a> {
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00ac  */
        public final /* synthetic */ void handleSuccess(Object obj) {
            char c;
            j.a aVar = (j.a) obj;
            String str = aVar.f5140a;
            int hashCode = str.hashCode();
            if (hashCode != -1149187101) {
                if (hashCode == 2150174 && str.equals("FAIL")) {
                    c = 1;
                    if (c == 0) {
                        Bundle bundle = new Bundle();
                        if (TextUtils.equals(cge.this.O00000o, e.a.MIPAY.b())) {
                            bundle.putString("deductName", cge.this.getContext().getResources().getString(R.string.mibi_paytool_mipay));
                        } else if (TextUtils.equals(cge.this.O00000o, e.a.ALIPAY.b())) {
                            bundle.putString("deductName", cge.this.getContext().getResources().getString(R.string.mibi_paytool_alipay));
                        }
                        bundle.putBoolean("isDeduct", true);
                        bundle.putString("marketDeductId", aVar.b);
                        bundle.putString("orderId", aVar.c);
                        ((cfo.O00000o0) cge.this.getView()).a(9820, "sign deduct success ", bundle);
                        return;
                    } else if (c == 1) {
                        if (cge.this.O00000oo == null) {
                            cge cge = cge.this;
                            AutoQuerier unused = cge.O00000oo = new AutoQuerier(cge.O00000Oo, cge.this.O0000Oo0);
                        }
                        if (cge.this.O00000oo.hasNext()) {
                            cge.this.O00000oo.query();
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("isDeduct", true);
                        bundle2.putString("marketDeductId", aVar.b);
                        bundle2.putString("orderId", aVar.c);
                        bundle2.putString("chargeStatus", aVar.d);
                        bundle2.putInt("payStatus", aVar.e);
                        bundle2.putInt("deductSignStatus", aVar.f);
                        ((cfo.O00000o0) cge.this.getView()).a(9823, cge.this.getContext().getResources().getString(R.string.mibi_deduct_query_error), bundle2);
                        return;
                    } else {
                        return;
                    }
                }
            } else if (str.equals("SUCCESS")) {
                c = 0;
                if (c == 0) {
                }
            }
            c = 65535;
            if (c == 0) {
            }
        }

        public O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            ((cfo.O00000o0) cge.this.getView()).a(i, str, null);
        }
    }
}
