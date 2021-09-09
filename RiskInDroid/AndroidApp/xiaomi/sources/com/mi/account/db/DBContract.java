package com.mi.account.db;

import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Pair;

public final class DBContract {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f4561O000000o;
    public static final Uri O00000Oo = Uri.parse("content://" + f4561O000000o);

    public static final class DataStats implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(DBContract.O00000Oo, "data_stats");
    }

    public static final class Cache implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(DBContract.O00000Oo, "cache");

        private Cache() {
        }
    }

    public static final class DataMimeType implements BaseColumns {
        public static String formatServiceToken(String str, String str2) {
            return str + ":" + str2;
        }

        public static Pair<String, String> parseServiceToken(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length != 2) {
                return null;
            }
            return new Pair<>(split[0], split[1]);
        }
    }
}
