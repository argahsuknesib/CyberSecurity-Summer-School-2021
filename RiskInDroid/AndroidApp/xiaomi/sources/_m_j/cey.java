package _m_j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.mibi.sdk.channel.alipay.PayResult;
import com.mibi.sdk.channel.alipay.b.a;
import com.mibi.sdk.channel.alipay.b.b;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.MemoryStorage;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.mvp.lifecycle.ILifeCycleListener;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class cey extends Model<Void> implements ILifeCycleListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile Activity f13702O000000o;
    /* access modifiers changed from: private */
    public O000000o O00000Oo = new O000000o(this, (byte) 0);

    public final void handleResult(int i, int i2, Bundle bundle) {
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public cey(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Void> iResultCallback) {
        super.request(bundle, iResultCallback);
        String string = bundle.getString("processId");
        if (!TextUtils.isEmpty(string)) {
            MemoryStorage memoryStorage = getSession().getMemoryStorage();
            long j = memoryStorage.getLong(string, "rechargeValue");
            boolean z = memoryStorage.getBoolean(string, "isPartnerAccount");
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", string);
            sortedParameter.add("chargeFee", Long.valueOf(j * 1));
            sortedParameter.add("channel", "ALIPAY");
            if (z) {
                boolean z2 = memoryStorage.getBoolean(string, "useGiftcard");
                boolean z3 = memoryStorage.getBoolean(string, "usePartnerGiftcard");
                sortedParameter.add("useGiftcard", Boolean.valueOf(z2));
                sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(z3));
                b bVar = new b(getContext(), getSession(), string);
                bVar.setParams(sortedParameter);
                chh.O000000o(bVar).O000000o(new O00000o(this, getContext(), (byte) 0));
                return;
            }
            a aVar = new a(getContext(), getSession());
            aVar.setParams(sortedParameter);
            chh.O000000o(aVar).O000000o(new O00000o0(this, getContext(), (byte) 0));
            return;
        }
        throw new IllegalStateException();
    }

    public final void onDestroy() {
        this.f13702O000000o = null;
    }

    class O00000o extends RxBaseErrorHandleTaskListener<b.a> {
        /* synthetic */ O00000o(cey cey, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            MibiLog.d("AlipayModel", "start alipay");
            cey.O000000o(cey.this, ((b.a) obj).f5116a);
        }

        private O00000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            MibiLog.d("AlipayModel", "request alipay error:" + i + " ,errorDesc:" + str);
            cey.this.getCallback().onFailed(i, str, th);
        }
    }

    class O00000o0 extends RxBaseErrorHandleTaskListener<a.C0038a> {
        /* synthetic */ O00000o0(cey cey, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            MibiLog.d("AlipayModel", "start alipay");
            cey.O000000o(cey.this, ((a.C0038a) obj).f5114a);
        }

        private O00000o0(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            MibiLog.d("AlipayModel", "request alipay error:" + i + " ,errorDesc:" + str);
            cey.this.getCallback().onFailed(i, str, th);
        }
    }

    class O00000Oo implements Runnable {
        private String O00000Oo;

        /* synthetic */ O00000Oo(cey cey, String str, byte b) {
            this(str);
        }

        private O00000Oo(String str) {
            this.O00000Oo = str;
        }

        public final void run() {
            if (!cey.O00000o0(cey.this)) {
                MibiLog.d("AlipayModel", "activity is null,maybe activity has been destroyed");
                return;
            }
            MibiLog.i("AlipayModel", "start alipay sdk");
            Map<String, String> payV2 = new PayTask(cey.this.f13702O000000o).payV2(this.O00000Oo, true);
            MibiLog.i("AlipayModel", "finish alipay sdk");
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = payV2;
            cey.this.O00000Oo.sendMessage(obtain);
        }
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<cey> f13703O000000o;

        /* synthetic */ O000000o(cey cey, byte b) {
            this(cey);
        }

        private O000000o(cey cey) {
            this.f13703O000000o = new WeakReference<>(cey);
        }

        public final void handleMessage(Message message) {
            cey cey = this.f13703O000000o.get();
            if (cey == null) {
                MibiLog.d("AlipayModel", "model is null");
            } else if (message.what == 100) {
                cey.O000000o(cey, new PayResult((Map) message.obj));
            } else if (message.what == 101) {
                MibiLog.d("AlipayModel", "alipay exception:101");
                cey.getCallback().onFailed(0, "alipay exception", null);
            } else {
                throw new IllegalStateException("should not happen:" + message.what);
            }
        }
    }

    static /* synthetic */ void O000000o(cey cey, String str) {
        if (TextUtils.isEmpty(str)) {
            MibiLog.e("AlipayModel", "result is null");
            return;
        }
        MibiLog.d("AlipayModel", "start alipay thread");
        new Thread(new O00000Oo(cey, str, (byte) 0)).start();
    }

    static /* synthetic */ boolean O00000o0(cey cey) {
        return cey.f13702O000000o != null && !cey.f13702O000000o.isDestroyed() && !cey.f13702O000000o.isFinishing();
    }

    static /* synthetic */ void O000000o(cey cey, PayResult payResult) {
        MibiLog.d("AlipayModel", "handlePayResult");
        try {
            String resultStatus = payResult.getResultStatus();
            if (TextUtils.equals(resultStatus, "9000")) {
                MibiLog.d("AlipayModel", "resultStatus success");
                cey.getCallback().onSuccess(null);
            } else if (TextUtils.equals(resultStatus, "6001")) {
                String concat = "alipay user cancel:".concat(String.valueOf(resultStatus));
                MibiLog.d("AlipayModel", concat);
                cey.getCallback().onFailed(9808, concat, null);
            } else {
                String concat2 = "alipay error:".concat(String.valueOf(resultStatus));
                MibiLog.d("AlipayModel", concat2);
                cey.getCallback().onFailed(0, concat2, null);
            }
        } catch (Exception e) {
            MibiLog.d("AlipayModel", "alipay exception", e);
            cey.getCallback().onFailed(0, "alipay exception", null);
        }
    }
}
