package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrpay.b.e;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class chc extends Model<e.a> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13809O000000o;

    public chc(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<e.a> iResultCallback) {
        super.request(bundle, iResultCallback);
        Log.d("UnitedQrPayModel", "request united pay  qr_code");
        this.f13809O000000o = bundle.getString("processId");
        if (!TextUtils.isEmpty(this.f13809O000000o)) {
            String str = this.f13809O000000o;
            Log.d("UnitedQrPayModel", "requestServer");
            long j = getSession().getMemoryStorage().getLong(str, "rechargeValue");
            e eVar = new e(getContext(), getSession());
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", str);
            sortedParameter.add("chargeFee", Long.valueOf(j * 1));
            eVar.setParams(sortedParameter);
            chh.O000000o(eVar).O000000o(new O000000o(this, getContext(), (byte) 0));
            return;
        }
        throw new IllegalStateException();
    }

    class O000000o extends RxBaseErrorHandleTaskListener<e.a> {
        /* synthetic */ O000000o(chc chc, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            chc.this.getCallback().onSuccess((e.a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("UnitedQrPayModel", "request united pay qr_code error:" + i + " ,errorDesc:" + str);
            chc.this.getCallback().onFailed(i, str, th);
        }
    }
}
