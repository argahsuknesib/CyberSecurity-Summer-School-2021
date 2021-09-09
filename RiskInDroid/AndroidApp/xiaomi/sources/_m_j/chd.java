package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrpay.b.g;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class chd extends Model<g.a> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13811O000000o;

    public chd(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<g.a> iResultCallback) {
        super.request(bundle, iResultCallback);
        Log.d("WXQrPayModel", "request wx qr_code");
        this.f13811O000000o = bundle.getString("processId");
        if (!TextUtils.isEmpty(this.f13811O000000o)) {
            String str = this.f13811O000000o;
            Log.d("WXQrPayModel", "requestServer");
            long j = getSession().getMemoryStorage().getLong(str, "rechargeValue");
            g gVar = new g(getContext(), getSession());
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", str);
            sortedParameter.add("chargeFee", Long.valueOf(j * 1));
            gVar.setParams(sortedParameter);
            chh.O000000o(gVar).O000000o(new O000000o(this, getContext(), (byte) 0));
            return;
        }
        throw new IllegalStateException();
    }

    class O000000o extends RxBaseErrorHandleTaskListener<g.a> {
        /* synthetic */ O000000o(chd chd, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            chd.this.getCallback().onSuccess((g.a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("WXQrPayModel", "request wxpay qr_code error:" + i + " ,errorDesc:" + str);
            chd.this.getCallback().onFailed(i, str, th);
        }
    }
}
