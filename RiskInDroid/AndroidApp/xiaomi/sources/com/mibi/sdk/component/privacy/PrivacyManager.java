package com.mibi.sdk.component.privacy;

import android.content.SharedPreferences;
import android.util.Log;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.MemoryStorage;
import com.mibi.sdk.common.session.Session;

public class PrivacyManager {
    public static void makePrivacyParam(Session session, String str, String str2) {
        MemoryStorage memoryStorage = session.getMemoryStorage();
        String userId = session.getUserId();
        memoryStorage.put(userId, "market", str);
        memoryStorage.put(userId, "entry", str2);
    }

    public static void uploadPrivacy(Session session) throws PaymentException {
        if (session == null) {
            throw new IllegalArgumentException("session should not be null when uploadPrivacy privacy info.");
        } else if (!hasUploadAgreePrivacy(session)) {
            MemoryStorage memoryStorage = session.getMemoryStorage();
            String userId = session.getUserId();
            Log.d("PrivacyManager", "upload privacy marketType = ".concat(String.valueOf(memoryStorage.getString(userId, "market", "105"))));
            memoryStorage.getString(userId, "entry", "HOMEPAGE");
            memoryStorage.getBoolean(userId, "agree", true);
            if (!(session.getAccountLoader() instanceof FakeAccountLoader)) {
                CommonConstants.getUrl("privacy/authorize");
            }
        }
    }

    public static void commitAgreePrivacy(Session session, boolean z) {
        SharedPreferences.Editor edit = session.getUserPreferences("agreePrivacy").edit();
        edit.putBoolean("agreePrivacy", z);
        edit.apply();
    }

    public static boolean hasUploadAgreePrivacy(Session session) {
        return session.getUserPreferences("agreePrivacy").getBoolean("agreePrivacy", false);
    }
}
