package com.mibi.sdk.model.auth;

import _m_j.chh;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.ServerErrorCodeException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.model.auth.RxCheckAuthTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public class CheckAuthModel extends Model<Void> {
    public ICheckAuthCallback mCallback;
    public String mProcessId;

    public interface ICheckAuthCallback {
        void onAccountFrozen();

        void onAuthCheckError(int i, String str, Throwable th);

        void onBindPhoneCheck(Bundle bundle);

        void onPasswordCheck();

        void onProcessExpired();

        void onSMSCodeCheck(Bundle bundle);

        void onSuccess();
    }

    public CheckAuthModel(Session session) {
        super(session);
    }

    public void request(Bundle bundle, IBaseModel.IResultCallback<Void> iResultCallback) {
        throw new IllegalStateException("should not use this method");
    }

    public void checkAuth(Bundle bundle, ICheckAuthCallback iCheckAuthCallback) {
        super.request(bundle, null);
        this.mCallback = iCheckAuthCallback;
        this.mProcessId = bundle.getString("processId");
        String string = bundle.getString("fullAuth");
        String string2 = bundle.getString("smsCode");
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", this.mProcessId);
        if (!TextUtils.isEmpty(string)) {
            sortedParameter.add("fullAuth", string);
        }
        if (!TextUtils.isEmpty(string2)) {
            sortedParameter.add("smsCode", string2);
        }
        RxCheckAuthTask rxCheckAuthTask = new RxCheckAuthTask(getContext(), getSession());
        rxCheckAuthTask.setParams(sortedParameter);
        chh.O000000o(rxCheckAuthTask).O000000o(new CheckAuthTaskListener(getContext()));
    }

    class CheckAuthTaskListener extends RxBaseErrorHandleTaskListener<RxCheckAuthTask.Result> {
        private CheckAuthTaskListener(Context context) {
            super(context);
        }

        public void handleError(int i, String str, Throwable th) {
            if (i == 1985) {
                Log.d("CheckAuthModel", "need check password");
                CheckAuthModel.this.mCallback.onPasswordCheck();
            } else if (i == 1993) {
                Log.d("CheckAuthModel", "account frozen");
                CheckAuthModel.this.mCallback.onAccountFrozen();
            } else if (i == 8000) {
                Log.d("CheckAuthModel", "process expired");
                CheckAuthModel.this.mCallback.onProcessExpired();
            } else if (i == 7001) {
                Log.d("CheckAuthModel", "need verify sms");
                String str2 = ((RxCheckAuthTask.Result) ((ServerErrorCodeException) th).getResult()).mPhoneNum;
                Bundle bundle = new Bundle();
                bundle.putString("processId", CheckAuthModel.this.mProcessId);
                bundle.putString("payment_phone_num", str2);
                bundle.putInt("payment_error", 7001);
                CheckAuthModel.this.mCallback.onSMSCodeCheck(bundle);
            } else if (i != 7002) {
                Log.d("CheckAuthModel", "check auth server error", th);
                CheckAuthModel.this.mCallback.onAuthCheckError(i, str, th);
            } else {
                Log.d("CheckAuthModel", "need bind phone");
                String str3 = ((RxCheckAuthTask.Result) ((ServerErrorCodeException) th).getResult()).mBindPhoneUrl;
                Bundle bundle2 = new Bundle();
                bundle2.putString("processId", CheckAuthModel.this.mProcessId);
                bundle2.putString("bindPhoneUrl", str3);
                bundle2.putInt("payment_error", 7002);
                CheckAuthModel.this.mCallback.onBindPhoneCheck(bundle2);
            }
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(RxCheckAuthTask.Result result) {
            Log.d("CheckAuthModel", "handleSuccess");
            CheckAuthModel.this.mCallback.onSuccess();
        }
    }
}
