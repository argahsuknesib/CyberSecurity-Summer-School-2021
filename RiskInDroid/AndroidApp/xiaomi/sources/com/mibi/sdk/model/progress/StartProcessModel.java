package com.mibi.sdk.model.progress;

import _m_j.chh;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.model.progress.RxStartProcessTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.mibi.sdk.task.handler.NoPrivacyRightExceptionHandler;

public class StartProcessModel extends Model<String> {
    public StartProcessModel(Session session) {
        super(session);
    }

    public void request(Bundle bundle, IBaseModel.IResultCallback<String> iResultCallback) {
        super.request(bundle, iResultCallback);
        ProcessTaskListener processTaskListener = new ProcessTaskListener(getContext());
        processTaskListener.getDispatcher().register(new NoPrivacyRightExceptionHandler(getContext()) {
            /* class com.mibi.sdk.model.progress.StartProcessModel.AnonymousClass1 */

            public boolean handleNoPrivacyRightException(int i, String str) {
                StartProcessModel.this.getCallback().onFailed(0, str, null);
                return true;
            }
        });
        chh.O000000o(new RxStartProcessTask(getContext(), getSession())).O000000o(processTaskListener);
    }

    class ProcessTaskListener extends RxBaseErrorHandleTaskListener<RxStartProcessTask.Result> {
        private ProcessTaskListener(Context context) {
            super(context);
        }

        public void handleError(int i, String str, Throwable th) {
            StartProcessModel.this.getCallback().onFailed(i, str, th);
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(RxStartProcessTask.Result result) {
            String str = result.mProcessId;
            if (TextUtils.isEmpty(str)) {
                StartProcessModel.this.getCallback().onFailed(0, "process is is null", null);
            } else {
                StartProcessModel.this.getCallback().onSuccess(str);
            }
        }
    }
}
