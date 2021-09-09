package com.xiaomi.account.diagnosis;

import _m_j.ekv;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import java.io.IOException;

public class DiagnosisController {
    private String mDomainCache;

    static class Holder {
        static DiagnosisController instance = new DiagnosisController();

        private Holder() {
        }
    }

    private DiagnosisController() {
    }

    public static DiagnosisController get() {
        return Holder.instance;
    }

    class CheckDiagnosisEnabledTask extends AsyncTask<Void, Void, Boolean> {
        private final DiagnosisLaunchCallback mCallback;

        private CheckDiagnosisEnabledTask(DiagnosisLaunchCallback diagnosisLaunchCallback) {
            this.mCallback = diagnosisLaunchCallback;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(!TextUtils.isEmpty(DiagnosisController.this.queryDomainOnlineConfig()));
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            if (this.mCallback != null) {
                if (bool != null && bool.booleanValue()) {
                    this.mCallback.onLaunch();
                } else {
                    this.mCallback.onError();
                }
            }
        }
    }

    public void checkStart(DiagnosisLaunchCallback diagnosisLaunchCallback) {
        new CheckDiagnosisEnabledTask(diagnosisLaunchCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public String getDiagnosisDomain() {
        if (!TextUtils.isEmpty(this.mDomainCache)) {
            return this.mDomainCache;
        }
        return queryDomainOnlineConfig();
    }

    public String queryDomainOnlineConfig() {
        try {
            this.mDomainCache = ekv.O000000o().O00000Oo;
            return this.mDomainCache;
        } catch (AccessDeniedException | AuthenticationFailureException | InvalidResponseException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
