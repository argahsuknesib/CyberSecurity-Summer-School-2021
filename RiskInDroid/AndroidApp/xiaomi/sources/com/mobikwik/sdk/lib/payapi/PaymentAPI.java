package com.mobikwik.sdk.lib.payapi;

import android.app.Activity;
import java.io.Serializable;
import java.util.HashMap;

public interface PaymentAPI extends Serializable {

    public interface Callback {
        void onError(String str, String str2);

        void onPaymentCompleted(String str);

        void onSuccess(String str, String str2, HashMap hashMap);
    }

    void startAPI(Callback callback, Activity activity);
}
