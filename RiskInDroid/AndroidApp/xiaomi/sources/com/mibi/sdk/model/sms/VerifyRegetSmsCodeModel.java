package com.mibi.sdk.model.sms;

import _m_j.chh;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;

public class VerifyRegetSmsCodeModel extends Model<Void> {
    public VerifyRegetSmsCodeModel(Session session) {
        super(session);
    }

    public void request(Bundle bundle, IBaseModel.IResultCallback<Void> iResultCallback) {
        Log.d("VerifyRegetSmsCodeModel", "resend sms");
        super.request(bundle, iResultCallback);
        String string = bundle.getString("processId");
        RxVerifyRegetSmsCodeTask rxVerifyRegetSmsCodeTask = new RxVerifyRegetSmsCodeTask(getContext(), getSession());
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", string);
        rxVerifyRegetSmsCodeTask.setParams(sortedParameter);
        chh.O000000o(rxVerifyRegetSmsCodeTask).O000000o();
    }
}
