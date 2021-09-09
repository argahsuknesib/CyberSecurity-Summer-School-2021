package _m_j;

import _m_j.cfn;
import _m_j.cft;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.common.utils.QueryIntervalUtils;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.deduct.d.c;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.task.AutoQuerier;
import com.mibi.sdk.task.DefaultAutoQueryCallback;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.xiaomi.smarthome.R;

public final class cgd extends BaseMvpPresenter<cfn.O00000o0> implements cfn.O00000Oo {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public int[] f13756O000000o = {0, 1, 2, 2};
    private cft O00000Oo;
    private String O00000o;
    /* access modifiers changed from: private */
    public String O00000o0;
    /* access modifiers changed from: private */
    public AutoQuerier O00000oO;
    private c O00000oo;
    private O00000Oo O0000O0o;
    /* access modifiers changed from: private */
    public AutoQuerier.AutoQuerierCallback O0000OOo = new DefaultAutoQueryCallback() {
        /* class _m_j.cgd.AnonymousClass1 */

        public final void onComplete() {
            cgd.O00000o0(cgd.this);
        }
    };

    public cgd() {
        super(cfn.O00000o0.class);
    }

    public final void onInit(Bundle bundle) {
        cft cft;
        super.onInit(bundle);
        if (bundle == null) {
            this.O00000o = getArguments().getString("processId");
        } else {
            this.O00000o = bundle.getString("processId");
        }
        this.O00000o0 = getArguments().getString("deductChannel");
        if (e.a.MIPAY.b().equals(this.O00000o0)) {
            cft = new cfu(getSession(), this.O00000o);
        } else if (e.a.ALIPAY.b().equals(this.O00000o0)) {
            cft = new cfp(getSession(), this.O00000o);
        } else if (e.a.WXPAY.b().equals(this.O00000o0)) {
            cft = new cfy(getSession(), this.O00000o);
        } else {
            throw new IllegalStateException("mChannelName:" + this.O00000o0);
        }
        cft.O00000Oo = new O000000o(this, (byte) 0);
        this.O00000Oo = cft;
        int[] queryInterval = QueryIntervalUtils.getQueryInterval((String) getSession().getMemoryStorage().getSerializable("mibi_extra_params"));
        if (queryInterval == null || queryInterval.length <= 0) {
            MibiLog.d("DoDeductPresenter", "interval is null");
        } else {
            this.f13756O000000o = queryInterval;
        }
        if (bundle == null) {
            this.O00000Oo.O000000o();
        }
    }

    public final void O000000o() {
        cft cft;
        if (getSession().getMemoryStorage().getBoolean(this.O00000o, "deductStart", false) && (cft = this.O00000Oo) != null) {
            cft.O00000Oo();
        }
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.O00000o);
        bundle.putString("deductChannel", this.O00000o0);
    }

    class O000000o implements cft.O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(cgd cgd, byte b) {
            this();
        }

        public final void O000000o(int i, String str) {
            Log.d("DoDeductPresenter", "handleDeductError errorCode : " + i + "  ; errDesc : " + str);
            ((cfn.O00000o0) cgd.this.getView()).a(i, str, null);
        }

        public final void O000000o() {
            Log.d("DoDeductPresenter", "requestQueryResult");
            ((cfn.O00000o0) cgd.this.getView()).a(true);
            cgd.O00000o0(cgd.this);
        }

        public final void O000000o(cfn.O000000o<Activity> o000000o) {
            ((cfn.O00000o0) cgd.this.getView()).a(o000000o);
        }
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        super.handleResult(i, i2, bundle);
        Log.d("DoDeductPresenter", "handleResult requestCode : " + i + " ; resultCode : " + i2);
        this.O00000Oo.O000000o(i, i2, bundle);
        if (i == 200 && (i2 == 9811 || i2 == 9818)) {
            ((cfn.O00000o0) getView()).a(i2, "cancel by user", bundle);
        } else if (i2 == 9810) {
            ((cfn.O00000o0) getView()).a(9810, "deduct success", bundle);
        }
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<c.a> {
        public final /* synthetic */ void handleSuccess(Object obj) {
            int i = ((c.a) obj).f5133a;
            if (i == 0) {
                ((cfn.O00000o0) cgd.this.getView()).a(9819, cgd.this.getContext().getResources().getString(R.string.mibi_deduct_query_error), null);
            } else if (i == 1) {
                Bundle bundle = new Bundle();
                if (TextUtils.equals(cgd.this.O00000o0, e.a.MIPAY.b())) {
                    bundle.putString("deductName", cgd.this.getContext().getResources().getString(R.string.mibi_paytool_mipay));
                } else if (TextUtils.equals(cgd.this.O00000o0, e.a.ALIPAY.b())) {
                    bundle.putString("deductName", cgd.this.getContext().getResources().getString(R.string.mibi_paytool_alipay));
                } else if (TextUtils.equals(cgd.this.O00000o0, e.a.WXPAY.b())) {
                    bundle.putString("deductName", cgd.this.getContext().getResources().getString(R.string.mibi_paytool_weixin));
                }
                bundle.putBoolean("isDeduct", true);
                ((cfn.O00000o0) cgd.this.getView()).a(9810, "deduct sucess", bundle);
            } else if (i == 2) {
                if (cgd.this.O00000oO == null) {
                    cgd cgd = cgd.this;
                    AutoQuerier unused = cgd.O00000oO = new AutoQuerier(cgd.f13756O000000o, cgd.this.O0000OOo);
                }
                if (cgd.this.O00000oO.hasNext()) {
                    cgd.this.O00000oO.query();
                } else {
                    ((cfn.O00000o0) cgd.this.getView()).a(9818, cgd.this.getContext().getResources().getString(R.string.mibi_deduct_query_error), null);
                }
            }
        }

        public O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            ((cfn.O00000o0) cgd.this.getView()).a(i, str, null);
        }
    }

    static /* synthetic */ void O00000o0(cgd cgd) {
        if (cgd.O00000oo == null) {
            cgd.O00000oo = new c(cgd.getContext(), cgd.getSession());
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", cgd.O00000o);
            sortedParameter.add("deductChannel", cgd.O00000o0);
            cgd.O00000oo.setParams(sortedParameter);
            cgd.O0000O0o = new O00000Oo(cgd.getContext());
        }
        chh.O000000o(cgd.O00000oo).O000000o(cgd.O0000O0o);
    }
}
