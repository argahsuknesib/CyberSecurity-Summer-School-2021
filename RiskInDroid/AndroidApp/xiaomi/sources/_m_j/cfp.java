package _m_j;

import _m_j.cfn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.deduct.d.e;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.xiaomi.smarthome.R;

public final class cfp extends cft {
    public cfp(Session session, String str) {
        super(session, str);
    }

    public final void O000000o() {
        if (!MarketUtils.isAppInstalled(getContext(), "com.eg.android.AlipayGphone")) {
            this.O00000Oo.O000000o(new cfn.O000000o<Activity>() {
                /* class _m_j.cfp.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    Activity activity = (Activity) obj;
                    MarketUtils.showInstallPromt(activity, activity.getString(R.string.mibi_paytool_app_not_installed, new Object[]{activity.getResources().getString(R.string.mibi_paytool_alipay)}), "com.eg.android.AlipayGphone", new MarketUtils.InstallPromtListener() {
                        /* class _m_j.cfp.AnonymousClass1.AnonymousClass1 */

                        public final void onConfirm() {
                            cfp.this.O00000Oo.O000000o(9812, "go market for alipay install");
                        }

                        public final void onCancel() {
                            cfp.this.O00000Oo.O000000o(9811, "Alipay install is canceled");
                        }
                    });
                }
            });
        } else if (getSession().getMemoryStorage().getBoolean(this.f13733O000000o, "deductStart", false)) {
            O00000Oo();
        } else {
            e eVar = new e(getContext(), getSession());
            O000000o o000000o = new O000000o(this, getContext(), (byte) 0);
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", this.f13733O000000o);
            eVar.setParams(sortedParameter);
            chh.O000000o(eVar).O000000o(o000000o);
        }
    }

    public final void O00000Oo() {
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.f13733O000000o);
        bundle.putString("deductChannel", e.a.ALIPAY.b());
        this.O00000Oo.O000000o();
        getSession().getMemoryStorage().remove(this.f13733O000000o, "deductStart");
    }

    class O000000o extends RxBaseErrorHandleTaskListener<e.a> {
        /* synthetic */ O000000o(cfp cfp, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfp.O000000o(cfp.this, ((e.a) obj).f5135a);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfp.this.O00000Oo.O000000o(i, str);
        }
    }

    static /* synthetic */ void O000000o(cfp cfp, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            cfp.getContext().startActivity(intent);
            cfp.getSession().getMemoryStorage().put(cfp.f13733O000000o, "deductStart", Boolean.TRUE);
            return;
        }
        cfp.O00000Oo();
    }
}
