package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.Singletons;
import com.google.android.gms.flags.impl.DataUtils;
import java.util.ArrayList;
import java.util.List;

public class ServiceApi {
    public static void persistGserviceValues(Context context) {
        try {
            SharedPreferences.Editor edit = SharedPreferencesFactory.getSharedPreferences(context).edit();
            for (Flag next : Singletons.flagRegistry().registeredFlags()) {
                if (next.getSource() == 0) {
                    DataUtils forFlag = DataUtils.forFlag(next);
                    forFlag.putInSharedPreferences(edit, forFlag.getGservicesValue().get());
                }
            }
            SharedPreferencesUtils.publishWorldReadableSharedPreferences(context, edit, "google_sdk_flags");
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FlagsServiceApi", valueOf.length() != 0 ? "Failed to write shared flags: ".concat(valueOf) : new String("Failed to write shared flags: "));
        }
    }

    public List<String> getExperimentIdsFromService() {
        ArrayList arrayList = new ArrayList();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            for (Flag.StringFlag stringUtils : Singletons.flagRegistry().registeredServiceExperimentIdFlags()) {
                String str = (String) new DataUtils.StringUtils(stringUtils).getGservicesValue().get();
                if (str != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
