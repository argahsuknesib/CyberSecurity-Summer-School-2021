package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.request.SimpleRequest;
import java.io.IOException;

public abstract class PassportFallbackableRequest extends PassportRequest {
    private final PassportRequest request1;
    private final PassportRequest request2;
    private boolean request2Used = false;

    /* access modifiers changed from: protected */
    public abstract void onRequest1Failed();

    /* access modifiers changed from: protected */
    public abstract void onRequest1Success();

    /* access modifiers changed from: protected */
    public abstract boolean shouldTryRequest2(SimpleRequest.StringContent stringContent);

    /* access modifiers changed from: protected */
    public abstract boolean shouldTryRequest2(Exception exc);

    public PassportFallbackableRequest(PassportRequest passportRequest, PassportRequest passportRequest2) {
        if (passportRequest == null || passportRequest2 == null) {
            throw new IllegalStateException("both arguments should not be null.");
        }
        this.request1 = passportRequest;
        this.request2 = passportRequest2;
    }

    public SimpleRequest.StringContent execute() throws IOException, PassportRequestException {
        try {
            SimpleRequest.StringContent execute = this.request1.execute();
            if (!shouldTryRequest2(execute)) {
                onRequest1Success();
                return execute;
            }
        } catch (IOException e) {
            if (!shouldTryRequest2(e)) {
                throw e;
            }
        } catch (PassportRequestException e2) {
            if (!shouldTryRequest2(e2)) {
                throw e2;
            }
        }
        onRequest1Failed();
        this.request2Used = true;
        return this.request2.execute();
    }

    public final boolean isRequest2Used() {
        return this.request2Used;
    }
}
