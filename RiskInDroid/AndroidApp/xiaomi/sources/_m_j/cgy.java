package _m_j;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.privacy.PrivacyManager;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrpay.b.c;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.mibi.sdk.task.RxPrivacyUploadTask;

public final class cgy extends Model<Bundle> {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13801O000000o;

    public cgy(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Bundle> iResultCallback) {
        super.request(bundle, iResultCallback);
        SortedParameter sortedParameter = (SortedParameter) bundle.getSerializable("sortedParams");
        boolean z = false;
        if (sortedParameter == null || iResultCallback == null) {
            StringBuilder sb = new StringBuilder("params == null ? ");
            if (sortedParameter == null) {
                z = true;
            }
            sb.append(z);
            MibiLog.d("AccountOrderCheckModel", sb.toString());
            throw new IllegalStateException();
        }
        this.f13801O000000o = sortedParameter.getString("processId");
        c cVar = new c(getContext(), getSession());
        cVar.setParams(sortedParameter);
        chh.O000000o(cVar).O000000o(new O000000o(this, getContext(), (byte) 0));
    }

    class O000000o extends RxBaseErrorHandleTaskListener<c.a> {
        /* synthetic */ O000000o(cgy cgy, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            c.a aVar = (c.a) obj;
            if (aVar.f5171a != null) {
                cgy.this.getCallback().onFailed(aVar.b, aVar.c, null);
                return;
            }
            cgy.O000000o(cgy.this, aVar.e);
            cgy.this.getSession().getMemoryStorage().put(cgy.this.f13801O000000o, "rechargeValue", Long.valueOf(aVar.d));
            cgy.this.getCallback().onSuccess(null);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cgy.this.getCallback().onFailed(i, str, th);
        }
    }

    static /* synthetic */ void O000000o(cgy cgy, String str) {
        PrivacyManager.makePrivacyParam(cgy.getSession(), str, "PAYMENTPAGE");
        chh.O000000o(new RxPrivacyUploadTask(cgy.getSession())).O000000o();
    }
}
