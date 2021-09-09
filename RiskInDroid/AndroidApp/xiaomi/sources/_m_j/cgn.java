package _m_j;

import android.content.Intent;
import android.os.Bundle;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.model.auth.OnCheckAuthErrorListener;
import com.mibi.sdk.mvp.IView;
import com.mibi.sdk.pay.task.RxAccountGetRechargeTypeTask;
import com.mibi.sdk.pay.task.RxStartAccountPaymentTask;
import java.util.ArrayList;

public interface cgn {

    public interface O000000o {
        String O000000o();
    }

    public interface O00000Oo extends OnCheckAuthErrorListener, IView {
        void a();

        void a(int i, Bundle bundle);

        void a(int i, String str, Throwable th);

        void a(Intent intent);

        void a(Bundle bundle);

        void a(RxStartAccountPaymentTask.Result result, RxAccountGetRechargeTypeTask.Result result2);

        void a(ArrayList<RechargeType> arrayList);
    }
}
