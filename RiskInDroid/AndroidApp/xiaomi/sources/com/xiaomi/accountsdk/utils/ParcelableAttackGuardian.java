package com.xiaomi.accountsdk.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.BadParcelableException;

public class ParcelableAttackGuardian {
    public boolean safeCheck(Activity activity) {
        if (!(activity == null || activity.getIntent() == null)) {
            try {
                unparcelIntent(new Intent(activity.getIntent()));
                return true;
            } catch (RuntimeException e) {
                if (e instanceof BadParcelableException) {
                    AccountLog.w("ParcelableAttackGuardia", "fail checking ParcelableAttack for Activity " + activity.getClass().getName());
                    return false;
                } else if (e.getCause() instanceof ClassNotFoundException) {
                    AccountLog.w("ParcelableAttackGuardia", "fail checking SerializableAttack for Activity " + activity.getClass().getName());
                    return false;
                } else {
                    AccountLog.w("ParcelableAttackGuardia", "error", e);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void unparcelIntent(Intent intent) throws BadParcelableException {
        intent.getStringExtra("");
    }
}
