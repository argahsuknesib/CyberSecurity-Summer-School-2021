package com.xiaomi.mico.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class PreferenceUtils {
    private static final ArrayList<PrefObserver> sPrefObs = new ArrayList<>();

    public interface PrefObserver {
        void notifyPrefChange(String str, Object obj);
    }

    public static void addPrefObserver(PrefObserver prefObserver) {
        sPrefObs.add(prefObserver);
    }

    public static void removePrefObserver(PrefObserver prefObserver) {
        Iterator<PrefObserver> it = sPrefObs.iterator();
        while (it.hasNext()) {
            PrefObserver next = it.next();
            if (next == prefObserver) {
                sPrefObs.remove(next);
                return;
            }
        }
    }

    public static void notifyPrefChange(String str, Object obj) {
        Iterator<PrefObserver> it = sPrefObs.iterator();
        while (it.hasNext()) {
            it.next().notifyPrefChange(str, obj);
        }
    }

    public static String getSettingString(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static Set<String> getSettingStringSet(Context context, String str, Set<String> set) {
        return PreferenceManager.getDefaultSharedPreferences(context).getStringSet(str, set);
    }

    public static void setSettingString(Context context, String str, String str2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).commit();
    }

    public static void setSettingStringSet(Context context, String str, Set<String> set) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet(str, set).apply();
    }

    public static void appendSettingString(SharedPreferences sharedPreferences, String str, String str2) {
        String string = sharedPreferences.getString(str, "");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, string + str2).apply();
    }

    public static boolean getSettingBoolean(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static boolean hasKey(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
    }

    public static void setSettingBoolean(Context context, String str, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).apply();
    }

    public static void setSettingInt(Context context, String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(str, i).apply();
    }

    public static void setSettingInt(SharedPreferences sharedPreferences, String str, int i) {
        sharedPreferences.edit().putInt(str, i).apply();
    }

    public static void increaseSettingInt(Context context, String str) {
        increaseSettingInt(PreferenceManager.getDefaultSharedPreferences(context), str);
    }

    public static void increaseSettingInt(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().putInt(str, sharedPreferences.getInt(str, 0) + 1).apply();
    }

    public static void increaseSettingInt(SharedPreferences sharedPreferences, String str, int i) {
        sharedPreferences.edit().putInt(str, sharedPreferences.getInt(str, 0) + i).apply();
    }

    public static int getSettingInt(Context context, String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i);
    }

    public static void setSettingFloat(Context context, String str, float f) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putFloat(str, f).apply();
    }

    public static float getSettingFloat(Context context, String str, float f) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(str, f);
    }

    public static void setSettingLong(Context context, String str, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(str, j).apply();
    }

    public static long getSettingLong(Context context, String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j);
    }

    public static void increaseSettingLong(SharedPreferences sharedPreferences, String str, long j) {
        sharedPreferences.edit().putLong(str, sharedPreferences.getLong(str, 0) + j).apply();
    }

    public static void removePreference(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
    }

    public static void clearPreference(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    public static void dumpDefaultPreference(Context context) {
        dumpPreference(PreferenceManager.getDefaultSharedPreferences(context), "default preference:");
    }

    public static void dumpDefaultPreference(Context context, String str) {
        dumpPreference(context.getSharedPreferences(str, 0), str);
    }

    private static void dumpPreference(SharedPreferences sharedPreferences, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("\n");
        Map<String, ?> all = sharedPreferences.getAll();
        for (String next : all.keySet()) {
            stringBuffer.append(next);
            stringBuffer.append(":");
            stringBuffer.append(all.get(next));
            stringBuffer.append("\n");
        }
        new Object[1][0] = stringBuffer.toString();
    }
}
