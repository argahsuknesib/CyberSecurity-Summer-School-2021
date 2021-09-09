package com.mibi.sdk.pay.model;

import _m_j.chh;
import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.pay.task.RxUploadOrderGiftcardSettingTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public class UploadOrderGiftcardModel extends Model<Void> {
    public UploadOrderGiftcardModel(Session session) {
        super(session);
    }

    public void request(Bundle bundle, IBaseModel.IResultCallback<Void> iResultCallback) {
        super.request(bundle, iResultCallback);
        RxUploadOrderGiftcardSettingTask rxUploadOrderGiftcardSettingTask = new RxUploadOrderGiftcardSettingTask(getContext(), getSession());
        rxUploadOrderGiftcardSettingTask.setParams((SortedParameter) bundle.getSerializable("sortedParams"));
        chh.O000000o(rxUploadOrderGiftcardSettingTask).O000000o(new O000000o(this, getContext(), (byte) 0));
    }

    class O000000o extends RxBaseErrorHandleTaskListener<RxUploadOrderGiftcardSettingTask.Result> {
        /* synthetic */ O000000o(UploadOrderGiftcardModel uploadOrderGiftcardModel, Context context, byte b) {
            this(context);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            UploadOrderGiftcardModel.this.getCallback().onFailed(i, str, th);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            UploadOrderGiftcardModel.this.getCallback().onSuccess(null);
        }
    }
}
