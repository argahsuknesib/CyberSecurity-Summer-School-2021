package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.impl.util.StrictModeUtil;
import org.json.JSONObject;

public abstract class DataUtils<T> {

    public static class BooleanUtils extends DataUtils<Boolean> {
        private final Flag.BooleanFlag zzack;

        BooleanUtils(Flag.BooleanFlag booleanFlag) {
            this.zzack = booleanFlag;
        }

        public static Boolean getFromSharedPreferencesNoStrict(SharedPreferences sharedPreferences, String str, Boolean bool) {
            try {
                return (Boolean) StrictModeUtil.runWithLaxStrictMode(new zza(sharedPreferences, str, bool));
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return bool;
            }
        }

        public Boolean getFromJSONObject(JSONObject jSONObject) {
            return Boolean.valueOf(jSONObject.optBoolean(this.zzack.getKey(), ((Boolean) this.zzack.getDefault()).booleanValue()));
        }

        public Boolean getFromSharedPreferences(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.zzack.getKey(), ((Boolean) this.zzack.getDefault()).booleanValue()));
        }

        public GservicesValue<Boolean> getGservicesValue() {
            return GservicesValue.value(this.zzack.getKey(), ((Boolean) this.zzack.getDefault()).booleanValue());
        }

        public void putInSharedPreferences(SharedPreferences.Editor editor, Boolean bool) {
            editor.putBoolean(this.zzack.getKey(), bool.booleanValue());
        }

        public void putStringOverrideInSharedPreferences(SharedPreferences.Editor editor, String str) {
            editor.putBoolean(this.zzack.getKey(), Boolean.parseBoolean(str));
        }
    }

    public static class IntegerUtils extends DataUtils<Integer> {
        private final Flag.IntegerFlag zzaco;

        IntegerUtils(Flag.IntegerFlag integerFlag) {
            this.zzaco = integerFlag;
        }

        public static Integer getFromSharedPreferencesNoStrict(SharedPreferences sharedPreferences, String str, Integer num) {
            try {
                return (Integer) StrictModeUtil.runWithLaxStrictMode(new zzb(sharedPreferences, str, num));
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return num;
            }
        }

        public Integer getFromJSONObject(JSONObject jSONObject) {
            return Integer.valueOf(jSONObject.optInt(this.zzaco.getKey(), ((Integer) this.zzaco.getDefault()).intValue()));
        }

        public Integer getFromSharedPreferences(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(this.zzaco.getKey(), ((Integer) this.zzaco.getDefault()).intValue()));
        }

        public GservicesValue<Integer> getGservicesValue() {
            return GservicesValue.value(this.zzaco.getKey(), (Integer) this.zzaco.getDefault());
        }

        public void putInSharedPreferences(SharedPreferences.Editor editor, Integer num) {
            editor.putInt(this.zzaco.getKey(), num.intValue());
        }

        public void putStringOverrideInSharedPreferences(SharedPreferences.Editor editor, String str) {
            editor.putInt(this.zzaco.getKey(), Integer.parseInt(str));
        }
    }

    public static class LongUtils extends DataUtils<Long> {
        private final Flag.LongFlag zzacq;

        LongUtils(Flag.LongFlag longFlag) {
            this.zzacq = longFlag;
        }

        public static Long getFromSharedPreferencesNoStrict(SharedPreferences sharedPreferences, String str, Long l) {
            try {
                return (Long) StrictModeUtil.runWithLaxStrictMode(new zzc(sharedPreferences, str, l));
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return l;
            }
        }

        public Long getFromJSONObject(JSONObject jSONObject) {
            return Long.valueOf(jSONObject.optLong(this.zzacq.getKey(), ((Long) this.zzacq.getDefault()).longValue()));
        }

        public Long getFromSharedPreferences(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(this.zzacq.getKey(), ((Long) this.zzacq.getDefault()).longValue()));
        }

        public GservicesValue<Long> getGservicesValue() {
            return GservicesValue.value(this.zzacq.getKey(), (Long) this.zzacq.getDefault());
        }

        public void putInSharedPreferences(SharedPreferences.Editor editor, Long l) {
            editor.putLong(this.zzacq.getKey(), l.longValue());
        }

        public void putStringOverrideInSharedPreferences(SharedPreferences.Editor editor, String str) {
            editor.putLong(this.zzacq.getKey(), Long.parseLong(str));
        }
    }

    public static class StringUtils extends DataUtils<String> {
        private final Flag.StringFlag zzacs;

        StringUtils(Flag.StringFlag stringFlag) {
            this.zzacs = stringFlag;
        }

        public static String getFromSharedPreferencesNoStrict(SharedPreferences sharedPreferences, String str, String str2) {
            try {
                return (String) StrictModeUtil.runWithLaxStrictMode(new zzd(sharedPreferences, str, str2));
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return str2;
            }
        }

        public String getFromJSONObject(JSONObject jSONObject) {
            return jSONObject.optString(this.zzacs.getKey(), (String) this.zzacs.getDefault());
        }

        public String getFromSharedPreferences(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(this.zzacs.getKey(), (String) this.zzacs.getDefault());
        }

        public GservicesValue<String> getGservicesValue() {
            return GservicesValue.value(this.zzacs.getKey(), (String) this.zzacs.getDefault());
        }

        public void putInSharedPreferences(SharedPreferences.Editor editor, String str) {
            editor.putString(this.zzacs.getKey(), str);
        }

        public void putStringOverrideInSharedPreferences(SharedPreferences.Editor editor, String str) {
            editor.putString(this.zzacs.getKey(), String.valueOf(str));
        }
    }

    public static DataUtils forFlag(Flag flag) {
        if (flag instanceof Flag.BooleanFlag) {
            return new BooleanUtils((Flag.BooleanFlag) flag);
        }
        if (flag instanceof Flag.IntegerFlag) {
            return new IntegerUtils((Flag.IntegerFlag) flag);
        }
        if (flag instanceof Flag.LongFlag) {
            return new LongUtils((Flag.LongFlag) flag);
        }
        if (flag instanceof Flag.StringFlag) {
            return new StringUtils((Flag.StringFlag) flag);
        }
        String valueOf = String.valueOf(flag.getClass().getName());
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unexpected flag type: ".concat(valueOf) : new String("Unexpected flag type: "));
    }

    public abstract T getFromJSONObject(JSONObject jSONObject);

    public abstract T getFromSharedPreferences(SharedPreferences sharedPreferences);

    public abstract GservicesValue<T> getGservicesValue();

    public abstract void putInSharedPreferences(SharedPreferences.Editor editor, T t);

    public abstract void putStringOverrideInSharedPreferences(SharedPreferences.Editor editor, String str);
}
