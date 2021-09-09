package com.facebook.appevents.suggestedevents;

import android.content.SharedPreferences;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class PredictionHistoryManager {
    private static final Map<String, String> clickedViewPaths = new HashMap();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static SharedPreferences shardPreferences;

    PredictionHistoryManager() {
    }

    private static void initAndWait() {
        if (!initialized.get()) {
            shardPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
            clickedViewPaths.putAll(Utility.JsonStrToMap(shardPreferences.getString("SUGGESTED_EVENTS_HISTORY", "")));
            initialized.set(true);
        }
    }

    static void addPrediction(String str, String str2) {
        if (!initialized.get()) {
            initAndWait();
        }
        clickedViewPaths.put(str, str2);
        shardPreferences.edit().putString("SUGGESTED_EVENTS_HISTORY", Utility.mapToJsonStr(clickedViewPaths)).apply();
    }

    static String getPathID(View view) {
        JSONObject jSONObject = new JSONObject();
        while (view != null) {
            SuggestedEventViewHierarchy.updateBasicInfo(view, jSONObject);
            view = ViewHierarchy.getParentOfView(view);
        }
        return Utility.sha256hash(jSONObject.toString());
    }

    static String queryEvent(String str) {
        if (clickedViewPaths.containsKey(str)) {
            return clickedViewPaths.get(str);
        }
        return null;
    }
}
