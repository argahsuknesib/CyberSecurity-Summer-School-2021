package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrpay.b.a;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cgz extends Model<a.C0043a> {
    public cgz(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<a.C0043a> iResultCallback) {
        super.request(bundle, iResultCallback);
        String string = bundle.getString("processId");
        if (!TextUtils.isEmpty(string)) {
            long j = getSession().getMemoryStorage().getLong(string, "rechargeValue");
            a aVar = new a(getContext(), getSession());
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", string);
            sortedParameter.add("chargeFee", Long.valueOf(j * 1));
            aVar.setParams(sortedParameter);
            chh.O000000o(aVar).O000000o(new O000000o(this, getContext(), (byte) 0));
            return;
        }
        throw new IllegalStateException();
    }

    class O000000o extends RxBaseErrorHandleTaskListener<a.C0043a> {
        /* synthetic */ O000000o(cgz cgz, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            Log.d("AliQrPayModel", "start alipay");
            cgz.this.getCallback().onSuccess((a.C0043a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("AliQrPayModel", "request alipay qr_code error:" + i + " ,errorDesc:" + str);
            cgz.this.getCallback().onFailed(i, str, th);
        }
    }
}
