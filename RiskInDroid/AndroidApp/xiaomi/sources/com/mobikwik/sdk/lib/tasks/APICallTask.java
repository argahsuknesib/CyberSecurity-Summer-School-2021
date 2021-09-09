package com.mobikwik.sdk.lib.tasks;

import android.os.AsyncTask;
import com.mobikwik.sdk.lib.utils.Network;
import java.util.HashMap;

public class APICallTask extends AsyncTask {
    HashMap data;
    String jsondata;
    OnCompleteListener l;
    String url;

    public interface OnCompleteListener {
        void onCompleted(String str);
    }

    public APICallTask(String str, String str2, OnCompleteListener onCompleteListener) {
        this.url = str;
        this.jsondata = str2;
        this.l = onCompleteListener;
    }

    public APICallTask(String str, HashMap hashMap, OnCompleteListener onCompleteListener) {
        this.url = str;
        this.data = hashMap;
        this.l = onCompleteListener;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        HashMap hashMap = this.data;
        return hashMap == null ? Network.getResponseOfPostRequest(this.url, this.jsondata, "application/json", null) : Network.getResponseOfPostRequest(this.url, hashMap);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.l.onCompleted(str);
    }
}
