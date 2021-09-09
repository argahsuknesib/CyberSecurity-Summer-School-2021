package com.mibi.sdk.task;

import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.privacy.PrivacyManager;

public class RxPrivacyUploadTask extends RxTask<Result> {
    private Session mSession;

    public static class Result {
    }

    public RxPrivacyUploadTask(Session session) {
        super(Result.class);
        this.mSession = session;
    }

    /* access modifiers changed from: protected */
    public void doLoad(Result result) throws PaymentException {
        if (!(this.mSession.getAccountLoader() instanceof FakeAccountLoader)) {
            PrivacyManager.uploadPrivacy(this.mSession);
        }
    }
}
