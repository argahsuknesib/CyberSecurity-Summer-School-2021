package _m_j;

import _m_j.cfo;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.WXUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.deduct.d.i;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class cfz extends cfx {

    /* renamed from: O000000o  reason: collision with root package name */
    private IWXAPI f13743O000000o = WXAPIFactory.createWXAPI(getContext().getApplicationContext(), null);
    private ExecutorService O00000Oo;

    public cfz(Session session, String str) {
        super(session, str);
    }

    public final void O000000o() {
        if (!this.f13743O000000o.isWXAppInstalled()) {
            O00000Oo();
            return;
        }
        MibiLog.d("WxpaySignDeductModel", "request wx sign deduct");
        if (getSession().getMemoryStorage().getBoolean(this.O00000o0, "signDeductStart", false)) {
            O00000o0();
            return;
        }
        MibiLog.d("WxpaySignDeductModel", "request wx sign deduct url");
        i iVar = new i(getContext(), getSession());
        O00000Oo o00000Oo = new O00000Oo(this, getContext(), (byte) 0);
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", this.O00000o0);
        iVar.setParams(sortedParameter);
        chh.O000000o(iVar).O000000o(o00000Oo);
    }

    private void O00000Oo() {
        MibiLog.d("WxpaySignDeductModel", "prompt wx apk install");
        this.O00000o.O000000o(new cfo.O000000o<Activity>() {
            /* class _m_j.cfz.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                Activity activity = (Activity) obj;
                MarketUtils.showInstallPromt(activity, activity.getString(R.string.mibi_paytool_app_not_installed, new Object[]{activity.getResources().getString(R.string.mibi_paytool_weixin)}), "com.tencent.mm", new MarketUtils.InstallPromtListener() {
                    /* class _m_j.cfz.AnonymousClass1.AnonymousClass1 */

                    public final void onConfirm() {
                        MibiLog.d("WxpaySignDeductModel", "go market for wxpay install");
                        cfz.this.O00000o.O000000o(9812, "go market for wxpay install");
                    }

                    public final void onCancel() {
                        MibiLog.d("WxpaySignDeductModel", "Wxpay install is canceled");
                        cfz.this.O00000o.O000000o(9822, "Wxpay install is canceled");
                    }
                });
            }
        });
    }

    private void O00000o0() {
        MibiLog.d("WxpaySignDeductModel", "query result");
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.O00000o0);
        bundle.putString("deductSignAndPayChannel", e.a.WXPAY.b());
        this.O00000o.O000000o();
        getSession().getMemoryStorage().remove(this.O00000o0, "signDeductStart");
    }

    public void O000000o(int i) {
        if (i == -2) {
            this.O00000o.O000000o(9822, getContext().getResources().getString(R.string.mibi_paytool_wechat_return_cancel));
        } else if (i == -1) {
            String string = getContext().getResources().getString(R.string.mibi_paytool_weixin);
            String string2 = getContext().getResources().getString(R.string.mibi_paytool_error_msp, string);
            this.O00000o.O000000o(9823, string2 + " ; code : " + i);
        } else if (i != 0) {
            this.O00000o.O000000o(9823, "WXPay failed errorCode : ".concat(String.valueOf(i)));
        } else {
            O00000o0();
        }
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<i.a> {
        /* synthetic */ O00000Oo(cfz cfz, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfz.O000000o(cfz.this, (i.a) obj);
        }

        private O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfz.this.O00000o.O000000o(i, str);
        }
    }

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private IWXAPI f13746O000000o;
        private i.a O00000Oo;
        private WeakReference<cfz> O00000o0;

        public O000000o(cfz cfz, i.a aVar) {
            this.O00000o0 = new WeakReference<>(cfz);
            this.O00000Oo = aVar;
        }

        public final void run() {
            cfz cfz = this.O00000o0.get();
            if (cfz != null) {
                this.f13746O000000o = WXAPIFactory.createWXAPI(cfz.getContext().getApplicationContext(), null);
                i.a aVar = this.O00000Oo;
                PayReq payReq = new PayReq();
                payReq.appId = aVar.b;
                payReq.partnerId = aVar.c;
                payReq.prepayId = aVar.d;
                payReq.packageValue = aVar.e;
                payReq.nonceStr = aVar.f;
                payReq.timeStamp = aVar.g;
                payReq.sign = aVar.h;
                this.f13746O000000o.registerApp(aVar.b);
                boolean sendReq = this.f13746O000000o.sendReq(payReq);
                cfz.getSession().getMemoryStorage().put(cfz.O00000o0, "signDeductStart", Boolean.TRUE);
                MibiLog.d("WxpaySignDeductModel", "WeiXin sendSuccess = ".concat(String.valueOf(sendReq)));
                if (sendReq) {
                    WXUtils.putString(cfz.getContext(), "prepayid", aVar.d);
                    WXUtils.putString(cfz.getContext(), "appid", aVar.b);
                    return;
                }
                cfz.O00000o.O000000o(9823, "start wx failed");
            }
        }
    }

    static /* synthetic */ void O000000o(cfz cfz, i.a aVar) {
        MibiLog.d("WxpaySignDeductModel", "start wx sign deduct");
        if (cfz.f13743O000000o.isWXAppInstalled()) {
            cfz.O00000Oo = Executors.newSingleThreadExecutor();
            cfz.O00000Oo.execute(new O000000o(cfz, aVar));
            return;
        }
        cfz.O00000Oo();
    }
}
