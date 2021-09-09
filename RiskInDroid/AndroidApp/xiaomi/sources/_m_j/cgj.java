package _m_j;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.pay.task.RxAccountGetRechargeTypeTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cgj extends Model<RxAccountGetRechargeTypeTask.Result> {
    cgj(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<RxAccountGetRechargeTypeTask.Result> iResultCallback) {
        super.request(bundle, iResultCallback);
        RxAccountGetRechargeTypeTask rxAccountGetRechargeTypeTask = new RxAccountGetRechargeTypeTask(getContext(), getSession());
        rxAccountGetRechargeTypeTask.setParams((SortedParameter) bundle.getSerializable("sortedParams"));
        chh.O000000o(rxAccountGetRechargeTypeTask).O000000o(new O000000o(this, getContext(), (byte) 0));
    }

    class O000000o extends RxBaseErrorHandleTaskListener<RxAccountGetRechargeTypeTask.Result> {
        /* synthetic */ O000000o(cgj cgj, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            RxAccountGetRechargeTypeTask.Result result = (RxAccountGetRechargeTypeTask.Result) obj;
            super.handleSuccess(result);
            cgj.this.getCallback().onSuccess(result);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            super.handleError(i, str, th);
            cgj.this.getCallback().onFailed(i, str, th);
        }
    }
}
