package _m_j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.channel.mipay.b.a;
import com.mibi.sdk.channel.mipay.b.b;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.MemoryStorage;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.mvp.lifecycle.ILifeCycleListener;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.mibi.sdk.task.handler.ServerErrorCodeExceptionHandler;
import com.mipay.sdk.MipayFactory;
import com.xiaomi.smarthome.R;

public final class cfc extends Model<Bundle> implements ILifeCycleListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public Activity f13708O000000o;
    private ServerErrorCodeExceptionHandler O00000Oo = new ServerErrorCodeExceptionHandler(getContext()) {
        /* class _m_j.cfc.AnonymousClass1 */

        public final boolean handleProcessExpiredError() {
            cfc.this.getCallback().onFailed(8000, "process error", null);
            return true;
        }
    };

    public final void onPause() {
    }

    public final void onResume() {
    }

    public cfc(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Bundle> iResultCallback) {
        super.request(bundle, iResultCallback);
        String string = bundle.getString("processId");
        if (TextUtils.isEmpty(string)) {
            throw new IllegalStateException();
        } else if (!bundle.getBoolean("isRestored")) {
            MemoryStorage memoryStorage = getSession().getMemoryStorage();
            long j = memoryStorage.getLong(string, "rechargeValue");
            boolean z = memoryStorage.getBoolean(string, "isPartnerAccount");
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", string);
            sortedParameter.add("payment_denomination_mibi", Long.valueOf(j));
            sortedParameter.add("chargeFee", Long.valueOf(j * 1));
            sortedParameter.add("channel", "MIPAY");
            if (z) {
                boolean z2 = memoryStorage.getBoolean(string, "useGiftcard");
                boolean z3 = memoryStorage.getBoolean(string, "usePartnerGiftcard");
                sortedParameter.add("useGiftcard", Boolean.valueOf(z2));
                sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(z3));
                b bVar = new b(getContext(), getSession(), string);
                bVar.setParams(sortedParameter);
                O00000Oo o00000Oo = new O00000Oo(getContext());
                o00000Oo.getDispatcher().register(this.O00000Oo);
                chh.O000000o(bVar).O000000o(o00000Oo);
                return;
            }
            a aVar = new a(getContext(), getSession());
            aVar.setParams(sortedParameter);
            O000000o o000000o = new O000000o(getContext());
            o000000o.getDispatcher().register(this.O00000Oo);
            chh.O000000o(aVar).O000000o(o000000o);
        }
    }

    public final void onDestroy() {
        this.f13708O000000o = null;
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        Log.d("MipayPayModel", "requestCode:" + i + ",resultCode:" + i2);
        if (i == 424) {
            if (bundle != null) {
                int i3 = bundle.getInt("code", 2);
                if (i3 == 0) {
                    Log.d("MipayPayModel", "onSuccess");
                    getCallback().onSuccess(bundle);
                } else if (i3 == 2) {
                    Log.d("MipayPayModel", "onCancel");
                    getCallback().onFailed(9804, getContext().getResources().getString(R.string.mibi_msg_mipay_cancel), null);
                } else {
                    Log.d("MipayPayModel", "onError");
                    getCallback().onFailed(11, getContext().getResources().getString(R.string.mibi_mipay_error), null);
                }
            } else {
                Log.d("MipayPayModel", "onError");
                getCallback().onFailed(11, getContext().getResources().getString(R.string.mibi_mipay_error), null);
            }
            MipayFactory.release();
        }
    }

    class O000000o extends RxBaseErrorHandleTaskListener<a.C0039a> {
        public final /* synthetic */ void handleSuccess(Object obj) {
            Log.d("MipayPayModel", "start mipay");
            cfc.O000000o(cfc.this, ((a.C0039a) obj).c);
        }

        public O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("MipayPayModel", "request mipay error:" + i + " ,errorDesc:" + str);
            cfc.this.getCallback().onFailed(i, str, th);
        }
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<b.a> {
        public final /* synthetic */ void handleSuccess(Object obj) {
            Log.d("MipayPayModel", "start mipay");
            cfc.O000000o(cfc.this, ((b.a) obj).c);
        }

        public O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("MipayPayModel", "request mipay error:" + i + " ,errorDesc:" + str);
            cfc.this.getCallback().onFailed(i, str, th);
        }
    }

    static /* synthetic */ void O000000o(cfc cfc, String str) {
        if (cfc.f13708O000000o == null) {
            cfc.getCallback().onFailed(0, "activity is null", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("skipSuccess", true);
        MipayFactory.get(cfc.getContext(), cfb.O000000o(cfc.getContext())).pay(cfc.f13708O000000o, str, bundle);
    }
}
