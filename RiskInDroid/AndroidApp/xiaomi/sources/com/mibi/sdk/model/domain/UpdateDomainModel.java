package com.mibi.sdk.model.domain;

import _m_j.chh;
import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.model.domain.RxUpdateDomainTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public class UpdateDomainModel extends Model<Void> {
    public UpdateDomainModel(Session session) {
        super(session);
    }

    public void request(Bundle bundle, IBaseModel.IResultCallback<Void> iResultCallback) {
        super.request(bundle, iResultCallback);
        RxUpdateDomainTask rxUpdateDomainTask = new RxUpdateDomainTask(getContext(), getSession());
        rxUpdateDomainTask.setParams((SortedParameter) bundle.getSerializable("sortedParams"));
        chh.O000000o(rxUpdateDomainTask).O000000o(new UpdateDomainTaskListener(getContext()));
    }

    class UpdateDomainTaskListener extends RxBaseErrorHandleTaskListener<RxUpdateDomainTask.Result> {
        public UpdateDomainTaskListener(Context context) {
            super(context);
        }

        public void handleError(int i, String str, Throwable th) {
            UpdateDomainModel.this.getCallback().onFailed(i, str, th);
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(RxUpdateDomainTask.Result result) {
            UpdateDomainModel.this.getCallback().onSuccess(null);
        }
    }
}
