package _m_j;

import _m_j.cfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.LocalBroadcastManager;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.deduct.d.f;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.mvp.lifecycle.ILifeCycleListener;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class cfq extends cfx implements ILifeCycleListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile Activity f13723O000000o;
    public boolean O00000Oo = false;
    /* access modifiers changed from: private */
    public O00000o0 O00000oO = new O00000o0(this, (byte) 0);

    public final void onPause() {
    }

    public final void onResume() {
    }

    public cfq(Session session, String str) {
        super(session, str);
    }

    public final void O000000o() {
        MibiLog.d("AlipaySignDeductModel", "start sign deduct called");
        if (!MarketUtils.isAppInstalled(getContext(), "com.eg.android.AlipayGphone")) {
            this.O00000o.O000000o(new cfo.O000000o<Activity>() {
                /* class _m_j.cfq.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    Activity activity = (Activity) obj;
                    MarketUtils.showInstallPromt(activity, activity.getString(R.string.mibi_paytool_app_not_installed, new Object[]{activity.getResources().getString(R.string.mibi_paytool_alipay)}), "com.eg.android.AlipayGphone", new MarketUtils.InstallPromtListener() {
                        /* class _m_j.cfq.AnonymousClass1.AnonymousClass1 */

                        public final void onConfirm() {
                            cfq.this.O00000o.O000000o(9812, "go market for alipay install");
                        }

                        public final void onCancel() {
                            cfq.this.O00000o.O000000o(9822, "Alipay install is canceled");
                        }
                    });
                }
            });
            return;
        }
        f fVar = new f(getContext(), getSession());
        O00000Oo o00000Oo = new O00000Oo(this, getContext(), (byte) 0);
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", this.O00000o0);
        fVar.setParams(sortedParameter);
        chh.O000000o(fVar).O000000o(o00000Oo);
    }

    public void O00000Oo() {
        MibiLog.d("AlipaySignDeductModel", "start query result");
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.O00000o0);
        bundle.putString("deductSignAndPayChannel", e.a.ALIPAY.b());
        this.O00000o.O000000o();
    }

    public final void onDestroy() {
        this.f13723O000000o = null;
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<f.a> {
        /* synthetic */ O00000Oo(cfq cfq, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfq.O000000o(cfq.this, (f.a) obj);
        }

        private O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfq.this.O00000o.O000000o(i, str);
        }
    }

    class O000000o implements Runnable {
        private String O00000Oo;

        /* synthetic */ O000000o(cfq cfq, String str, byte b) {
            this(str);
        }

        private O000000o(String str) {
            this.O00000Oo = str;
        }

        public final void run() {
            if (!cfq.O000000o(cfq.this)) {
                MibiLog.d("AlipaySignDeductModel", "activity is null,maybe activity has been destroyed");
                return;
            }
            MibiLog.i("AlipaySignDeductModel", "start ali sign deduct");
            Map<String, String> payV2 = new PayTask(cfq.this.f13723O000000o).payV2(this.O00000Oo, true);
            MibiLog.i("AlipaySignDeductModel", "finish ali sign deduct");
            String str = new cfv(payV2).f13737O000000o;
            if (!cfq.O000000o(cfq.this)) {
                Intent intent = new Intent("com.mibi.sdk.alipay.result.action");
                intent.setPackage(Client.getAppInfo().getPackage());
                intent.putExtra("mibi_alipay_status", str);
                LocalBroadcastManager.getInstance(cfq.this.getContext()).sendBroadcast(intent);
                MibiLog.d("AlipaySignDeductModel", "send broadcast");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = str;
            cfq.this.O00000oO.sendMessage(obtain);
        }
    }

    static class O00000o0 extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<cfq> f13728O000000o;

        /* synthetic */ O00000o0(cfq cfq, byte b) {
            this(cfq);
        }

        private O00000o0(cfq cfq) {
            this.f13728O000000o = new WeakReference<>(cfq);
        }

        public final void handleMessage(Message message) {
            cfq cfq = this.f13728O000000o.get();
            if (cfq == null) {
                MibiLog.d("AlipaySignDeductModel", "model is null");
                return;
            }
            String str = (String) message.obj;
            if (message.what == 100) {
                if (TextUtils.equals("9000", str)) {
                    cfq.O00000Oo();
                    MibiLog.d("AlipaySignDeductModel", "ali sign deduct success");
                } else if (TextUtils.equals("6001", str)) {
                    MibiLog.d("AlipaySignDeductModel", "ali sign deduct cancelled by user");
                    cfq.O00000o.O000000o(9822, cfq.getContext().getResources().getString(R.string.mibi_sign_deduct_alipay_cancel));
                } else {
                    MibiLog.d("AlipaySignDeductModel", "ali sign deduct failed : ".concat(String.valueOf(str)));
                    cfq.O00000o.O000000o(9823, "alipay sign deduct exception");
                }
            }
        }
    }

    static /* synthetic */ void O000000o(cfq cfq, f.a aVar) {
        if (TextUtils.isEmpty(aVar.f5136a)) {
            cfq.O00000Oo();
        } else if (aVar.f5136a.startsWith("alipays://platformapi/startapp")) {
            MibiLog.d("AlipaySignDeductModel", "open by scheme");
            cfq.O00000Oo = false;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.f5136a));
            intent.addFlags(268435456);
            cfq.getContext().startActivity(intent);
            cfq.getSession().getMemoryStorage().put(cfq.O00000o0, "signDeductStart", Boolean.TRUE);
        } else {
            MibiLog.d("AlipaySignDeductModel", "open by pay task");
            cfq.O00000Oo = true;
            new Thread(new O000000o(cfq, aVar.f5136a, (byte) 0)).start();
        }
    }

    static /* synthetic */ boolean O000000o(cfq cfq) {
        return cfq.f13723O000000o != null && !cfq.f13723O000000o.isDestroyed() && !cfq.f13723O000000o.isFinishing();
    }
}
