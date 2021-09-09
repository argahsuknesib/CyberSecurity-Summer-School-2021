package com.mobikwik.sdk.lib.tasks;

import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.mobikwik.sdk.lib.Constants;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.ui.data.b;
import com.xiaomi.smarthome.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class LoadPaymentsMapping extends AsyncTask {
    private static HashMap cache = new HashMap();
    Context context;
    PaymentMappingLoadListener listener;
    String mid;
    int mode;

    public interface PaymentMappingLoadListener {
        void onMappingLoaded(PaymentsMappingAPIResponse paymentsMappingAPIResponse);
    }

    public LoadPaymentsMapping(Context context2, String str, int i, PaymentMappingLoadListener paymentMappingLoadListener) {
        this.context = context2;
        this.mid = str;
        this.mode = i;
        this.listener = paymentMappingLoadListener;
    }

    private void callback(PaymentsMappingAPIResponse paymentsMappingAPIResponse) {
        PaymentMappingLoadListener paymentMappingLoadListener = this.listener;
        if (paymentMappingLoadListener != null) {
            paymentMappingLoadListener.onMappingLoaded(paymentsMappingAPIResponse);
        }
    }

    private static String getBundledMapping(Context context2) {
        try {
            InputStream openRawResource = context2.getResources().openRawResource(R.raw.bank_mapping);
            byte[] bArr = new byte[512];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = openRawResource.read(bArr);
                if (read <= 0) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String loadMappingSync(String str, int i, Context context2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb.append(Constants.getServerUrl(sb2.toString()));
        sb.append("bankMapping.do?ver=5&clientId=3");
        return "0".equals(b.b(context2).f().getMode()) ? getBundledMapping(context2) : Network.getResponseFromQuery(context2, (sb.toString() + "&sellerId=" + str) + "&action=sdkMapping");
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        HashMap hashMap = cache;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mid);
        sb.append(this.mode);
        return hashMap.containsKey(sb.toString()) ? "CACHED" : loadMappingSync(this.mid, this.mode, this.context);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if ("CACHED".equals(str)) {
            HashMap hashMap = cache;
            callback((PaymentsMappingAPIResponse) hashMap.get(this.mid + this.mode));
        } else if (!Network.validateNetworkResponse(this.context, str, false)) {
            callback(null);
        } else {
            try {
                PaymentsMappingAPIResponse paymentsMappingAPIResponse = (PaymentsMappingAPIResponse) new Gson().fromJson(str, PaymentsMappingAPIResponse.class);
                if (paymentsMappingAPIResponse.failure) {
                    callback(null);
                    return;
                }
                HashMap hashMap2 = cache;
                hashMap2.put(this.mid + this.mode, paymentsMappingAPIResponse);
                callback(paymentsMappingAPIResponse);
            } catch (Exception e) {
                e.printStackTrace();
                callback(null);
            }
        }
    }
}
