package _m_j;

import _m_j.cfn;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.deduct.d.h;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xiaomi.smarthome.R;
import java.util.HashMap;

public final class cfy extends cft {
    private IWXAPI O00000o0 = WXAPIFactory.createWXAPI(getContext().getApplicationContext(), null);

    public cfy(Session session, String str) {
        super(session, str);
    }

    public final void O000000o() {
        if (!this.O00000o0.isWXAppInstalled()) {
            this.O00000Oo.O000000o(new cfn.O000000o<Activity>() {
                /* class _m_j.cfy.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    Activity activity = (Activity) obj;
                    MarketUtils.showInstallPromt(activity, activity.getString(R.string.mibi_paytool_app_not_installed, new Object[]{activity.getResources().getString(R.string.mibi_paytool_weixin)}), "com.tencent.mm", new MarketUtils.InstallPromtListener() {
                        /* class _m_j.cfy.AnonymousClass1.AnonymousClass1 */

                        public final void onConfirm() {
                            cfy.this.O00000Oo.O000000o(9812, "go market for wxpay install");
                        }

                        public final void onCancel() {
                            cfy.this.O00000Oo.O000000o(9811, "Wxpay install is canceled");
                        }
                    });
                }
            });
        } else if (getSession().getMemoryStorage().getBoolean(this.f13733O000000o, "deductStart", false)) {
            O00000Oo();
        } else {
            h hVar = new h(getContext(), getSession());
            O000000o o000000o = new O000000o(this, getContext(), (byte) 0);
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", this.f13733O000000o);
            hVar.setParams(sortedParameter);
            chh.O000000o(hVar).O000000o(o000000o);
        }
    }

    public final void O00000Oo() {
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.f13733O000000o);
        bundle.putString("deductChannel", e.a.WXPAY.b());
        this.O00000Oo.O000000o();
        getSession().getMemoryStorage().remove(this.f13733O000000o, "deductStart");
    }

    class O000000o extends RxBaseErrorHandleTaskListener<h.a> {
        /* synthetic */ O000000o(cfy cfy, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfy.O000000o(cfy.this, (h.a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfy.this.O00000Oo.O000000o(i, str);
        }
    }

    static /* synthetic */ void O000000o(cfy cfy, h.a aVar) {
        if (!TextUtils.isEmpty(aVar.f5138a)) {
            WXOpenBusinessWebview.Req req = new WXOpenBusinessWebview.Req();
            req.businessType = aVar.m;
            HashMap hashMap = new HashMap();
            hashMap.put("appid", aVar.b);
            hashMap.put("contract_code", aVar.c);
            hashMap.put("contract_display_account", aVar.d);
            hashMap.put("mch_id", aVar.e);
            hashMap.put("notify_url", aVar.f);
            hashMap.put("plan_id", aVar.g);
            hashMap.put("request_serial", aVar.h);
            hashMap.put("timestamp", aVar.j);
            hashMap.put("version", aVar.k);
            hashMap.put("sign", aVar.l);
            hashMap.put("return_app", aVar.i);
            req.queryInfo = hashMap;
            cfy.O00000o0 = WXAPIFactory.createWXAPI(cfy.getContext().getApplicationContext(), null);
            cfy.O00000o0.registerApp(aVar.b);
            cfy.O00000o0.sendReq(req);
            cfy.getSession().getMemoryStorage().put(cfy.f13733O000000o, "deductStart", Boolean.TRUE);
            return;
        }
        cfy.O00000Oo();
    }
}
