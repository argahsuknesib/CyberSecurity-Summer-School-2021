package _m_j;

import _m_j.cfn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.deduct.d.g;
import com.mibi.sdk.deduct.d.k;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.xiaomi.smarthome.R;

public final class cfu extends cft {
    public cfu(Session session, String str) {
        super(session, str);
    }

    public final void O000000o() {
        if (TextUtils.isEmpty((String) getSession().getMemoryStorage().get(this.f13733O000000o, "responseData"))) {
            g gVar = new g(getContext(), getSession());
            O000000o o000000o = new O000000o(this, getContext(), (byte) 0);
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", this.f13733O000000o);
            gVar.setParams(sortedParameter);
            chh.O000000o(gVar).O000000o(o000000o);
            return;
        }
        O00000o0();
    }

    private void O00000o0() {
        k kVar = new k(getContext(), getSession());
        O00000Oo o00000Oo = new O00000Oo(this, getContext(), (byte) 0);
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", this.f13733O000000o);
        sortedParameter.add("responseData", (String) getSession().getMemoryStorage().get(this.f13733O000000o, "responseData"));
        kVar.setParams(sortedParameter);
        chh.O000000o(kVar).O000000o(o00000Oo);
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<k.a> {
        /* synthetic */ O00000Oo(cfu cfu, Context context, byte b) {
            this(context);
        }

        private O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfu.this.O00000Oo.O000000o(i, str);
            cfu.this.getSession().getMemoryStorage().remove(cfu.this.f13733O000000o, "responseData");
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfu.O00000Oo(cfu.this);
        }
    }

    class O000000o extends RxBaseErrorHandleTaskListener<g.a> {
        /* synthetic */ O000000o(cfu cfu, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            final g.a aVar = (g.a) obj;
            super.handleSuccess(aVar);
            if (!TextUtils.isEmpty(aVar.f5137a)) {
                cfu.this.O00000Oo.O000000o(new cfn.O000000o<Activity>() {
                    /* class _m_j.cfu.O000000o.AnonymousClass1 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        Activity activity = (Activity) obj;
                        if (MarketUtils.isAppInstalled(activity, "com.mipay.wallet")) {
                            activity.startActivityForResult(O000000o.O000000o(aVar), 100);
                            Log.d("MipayDeductModel", "start Mipay deduct success");
                            return;
                        }
                        cfu.this.O00000Oo.O000000o(9818, activity.getResources().getString(R.string.mibi_msg_mipay_no_installed));
                        Log.d("MipayDeductModel", "start Mipay deduct failed");
                    }
                });
            } else {
                cfu.O00000Oo(cfu.this);
            }
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            super.handleError(i, str, th);
            cfu.this.O00000Oo.O000000o(i, str);
        }

        static /* synthetic */ Intent O000000o(g.a aVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.mipay.wallet");
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https");
            builder.authority("app.mipay.com");
            builder.appendQueryParameter("id", "mipay.partnerAutoPay");
            builder.appendQueryParameter("requestData", aVar.f5137a);
            builder.appendQueryParameter("merchantName", aVar.c);
            builder.appendQueryParameter("cancelMerchantName", aVar.d);
            builder.appendQueryParameter("goodsName", aVar.b);
            intent.setData(builder.build());
            return intent;
        }
    }

    public final void O000000o(int i, int i2, Bundle bundle) {
        super.O000000o(i, i2, bundle);
        if (i != 100) {
            return;
        }
        if (-1 == i2 && bundle != null) {
            getSession().getMemoryStorage().put(this.f13733O000000o, "responseData", bundle.getBundle("result").getString("responseData"));
            O00000o0();
        } else if (i2 != 0) {
            this.O00000Oo.O000000o(9818, "mipay deduct failed");
        } else if (bundle != null) {
            String string = bundle.getString("message");
            if (TextUtils.isEmpty(string)) {
                string = "mipay deduct canceled by user";
            }
            this.O00000Oo.O000000o(9811, string);
        } else {
            this.O00000Oo.O000000o(9811, "user cancel mipay deduct");
        }
    }

    static /* synthetic */ void O00000Oo(cfu cfu) {
        Bundle bundle = new Bundle();
        bundle.putString("processId", cfu.f13733O000000o);
        bundle.putString("deductChannel", e.a.MIPAY.b());
        cfu.O00000Oo.O000000o();
        cfu.getSession().getMemoryStorage().remove(cfu.f13733O000000o, "responseData");
    }
}
