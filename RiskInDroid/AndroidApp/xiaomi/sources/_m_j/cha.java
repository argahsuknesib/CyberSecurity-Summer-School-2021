package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrpay.b.b;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cha extends Model<b.a> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13804O000000o;

    public cha(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<b.a> iResultCallback) {
        super.request(bundle, iResultCallback);
        Log.d("MibiQrPayModel", "request mibi pay  qr_code");
        this.f13804O000000o = bundle.getString("processId");
        if (!TextUtils.isEmpty(this.f13804O000000o)) {
            String str = this.f13804O000000o;
            Log.d("MibiQrPayModel", "requestServer");
            long j = getSession().getMemoryStorage().getLong(str, "rechargeValue");
            b bVar = new b(getContext(), getSession());
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", str);
            sortedParameter.add("chargeFee", Long.valueOf(j * 1));
            bVar.setParams(sortedParameter);
            chh.O000000o(bVar).O000000o(new O000000o(this, getContext(), (byte) 0));
            return;
        }
        throw new IllegalStateException();
    }

    class O000000o extends RxBaseErrorHandleTaskListener<b.a> {
        /* synthetic */ O000000o(cha cha, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cha.this.getCallback().onSuccess((b.a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("MibiQrPayModel", "request mibi pay qr_code error:" + i + " ,errorDesc:" + str);
            cha.this.getCallback().onFailed(i, str, th);
        }
    }
}
