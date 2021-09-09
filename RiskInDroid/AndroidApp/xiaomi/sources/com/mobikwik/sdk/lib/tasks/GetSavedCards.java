package com.mobikwik.sdk.lib.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.Utils;

public class GetSavedCards extends AsyncTask {
    private Activity ctx;
    private GetSavedCardsListener listener;
    private String url;

    public interface GetSavedCardsListener {
        void onSavedCaredLoded(SavedCardResponse.CardDetails[] cardDetailsArr);
    }

    public GetSavedCards(Activity activity, String str, GetSavedCardsListener getSavedCardsListener) {
        this.ctx = activity;
        this.listener = getSavedCardsListener;
        this.url = str;
    }

    private void callback(SavedCardResponse.CardDetails[] cardDetailsArr) {
        GetSavedCardsListener getSavedCardsListener = this.listener;
        if (getSavedCardsListener != null) {
            getSavedCardsListener.onSavedCaredLoded(cardDetailsArr);
        }
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        Utils.print("GetSavedCards URL " + this.url);
        return Network.getResponseFromQuery(this.ctx.getApplicationContext(), this.url);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (!Network.validateNetworkResponse(this.ctx, str, false)) {
            callback(null);
            return;
        }
        try {
            SavedCardResponse savedCardResponse = (SavedCardResponse) new Gson().fromJson(str, SavedCardResponse.class);
            if ("100".equals(savedCardResponse.responseCode)) {
                callback(savedCardResponse.cards);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        callback(null);
    }
}
