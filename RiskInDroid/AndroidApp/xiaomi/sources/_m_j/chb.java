package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrpay.b.d;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.mibi.sdk.task.handler.ServerErrorCodeExceptionHandler;

public final class chb extends Model<Bundle> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13806O000000o;

    public chb(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Bundle> iResultCallback) {
        super.request(bundle, iResultCallback);
        SortedParameter sortedParameter = (SortedParameter) bundle.getSerializable("sortedParams");
        if (sortedParameter == null || iResultCallback == null) {
            throw new IllegalStateException();
        }
        this.f13806O000000o = sortedParameter.getString("processId");
        d dVar = new d(getContext(), getSession());
        dVar.setParams(sortedParameter);
        O000000o o000000o = new O000000o(this, getContext(), (byte) 0);
        o000000o.getDispatcher().register(new ServerErrorCodeExceptionHandler(getContext()) {
            /* class _m_j.chb.AnonymousClass1 */

            public final boolean handleServerErrorCodeError(int i, String str, Object obj) {
                int i2;
                if (i == 1986) {
                    i2 = 7;
                } else if (i != 1991) {
                    return false;
                } else {
                    i2 = 13;
                }
                chb.this.getCallback().onFailed(i2, str, null);
                return true;
            }
        });
        chh.O000000o(dVar).O000000o(o000000o);
    }

    class O000000o extends RxBaseErrorHandleTaskListener<d.a> {
        /* synthetic */ O000000o(chb chb, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            d.a aVar = (d.a) obj;
            if (aVar.f5173a != null) {
                Log.d("NoAccountCheckModel", "error,result is not null");
                chb.this.getCallback().onFailed(aVar.b, aVar.c, null);
                return;
            }
            chb.O000000o(chb.this, aVar);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            chb.this.getCallback().onFailed(i, str, th);
        }
    }

    static /* synthetic */ void O000000o(chb chb, d.a aVar) {
        chb.getSession().getMemoryStorage().put(chb.f13806O000000o, "rechargeValue", Long.valueOf(aVar.e));
        chb.getCallback().onSuccess(null);
    }
}
