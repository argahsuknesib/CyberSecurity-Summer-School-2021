package com.payu.custombrowser;

import android.os.AsyncTask;
import org.json.JSONObject;

class StoreMerchantHashTask extends AsyncTask<String, Void, Void> {
    StoreMerchantHashTask() {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        ClassLoader classLoader = Bank.class.getClassLoader();
        try {
            if (!isCancelled()) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("card_token") && jSONObject.has("merchant_hash")) {
                    Object invoke = classLoader.loadClass("com.payu.india.CallBackHandler.OnetapCallback").getDeclaredMethod("getOneTapCallback", new Class[0]).invoke(null, new Object[0]);
                    invoke.getClass().getDeclaredMethod("saveOneClickHash", String.class, String.class).invoke(invoke, jSONObject.getString("card_token"), jSONObject.getString("merchant_hash"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void voidR) {
        super.onPostExecute((Object) voidR);
    }
}
