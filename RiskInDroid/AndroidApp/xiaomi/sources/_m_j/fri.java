package _m_j;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Pair;
import com.xiaomi.smarthome.download.DownloadThread;
import com.xiaomi.smarthome.download.Downloads;
import com.xiaomi.smarthome.download.Helpers;
import java.util.ArrayList;
import java.util.List;

public final class fri {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f16968O000000o;
    public String O00000Oo;
    public String O00000o;
    public boolean O00000o0;
    public String O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public String O0000o;
    public String O0000o0;
    public long O0000o00;
    public String O0000o0O;
    public String O0000o0o;
    public String O0000oO;
    public String O0000oO0;
    public long O0000oOO;
    public long O0000oOo;
    public boolean O0000oo;
    public String O0000oo0;
    public boolean O0000ooO;
    public int O0000ooo;
    public String O000O00o;
    public int O000O0OO;
    public int O000O0Oo;
    private frm O000O0o;
    public List<Pair<String, String>> O000O0o0;
    private Context O000O0oO;
    public volatile boolean O00oOoOo;
    public boolean O00oOooO;
    public String O00oOooo;

    public static String O000000o(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "unknown error with network connectivity" : "download was requested to not use the current network type" : "download cannot use the current network connection because it is roaming" : "download size exceeds recommended limit for mobile network" : "download size exceeds limit for mobile network" : "no network connection available";
    }

    /* synthetic */ fri(Context context, frm frm, byte b) {
        this(context, frm);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private ContentResolver f16969O000000o;
        private Cursor O00000Oo;
        private CharArrayBuffer O00000o;
        private CharArrayBuffer O00000o0;

        public O000000o(ContentResolver contentResolver, Cursor cursor) {
            this.f16969O000000o = contentResolver;
            this.O00000Oo = cursor;
        }

        /* JADX INFO: finally extract failed */
        public final fri O000000o(Context context, frm frm) {
            fri fri = new fri(context, frm, (byte) 0);
            O000000o(fri);
            fri.O000O0o0.clear();
            Cursor query = this.f16969O000000o.query(Uri.withAppendedPath(fri.O00000o0(), "headers"), null, null, null, null);
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("header");
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow("value");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    O000000o(fri, query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2));
                    query.moveToNext();
                }
                query.close();
                if (fri.O0000o != null) {
                    O000000o(fri, "Cookie", fri.O0000o);
                }
                if (fri.O0000oO != null) {
                    O000000o(fri, "Referer", fri.O0000oO);
                }
                return fri;
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }

        public final void O000000o(fri fri) {
            fri.f16968O000000o = O00000Oo("_id").longValue();
            fri.O00000Oo = O000000o(fri.O00000Oo, "uri");
            boolean z = false;
            fri.O00000o0 = O000000o("no_integrity").intValue() == 1;
            fri.O00000o = O000000o(fri.O00000o, "hint");
            fri.O00000oO = O000000o(fri.O00000oO, "_data");
            fri.O00000oo = O000000o(fri.O00000oo, "mimetype");
            fri.O0000O0o = O000000o("destination").intValue();
            fri.O0000OOo = O000000o("visibility").intValue();
            fri.O0000Oo = O000000o("status").intValue();
            fri.O0000OoO = O000000o("numfailed").intValue();
            fri.O0000Ooo = O000000o("method").intValue() & 268435455;
            fri.O0000o00 = O00000Oo("lastmod").longValue();
            fri.O0000o0 = O000000o(fri.O0000o0, "notificationpackage");
            fri.O0000o0O = O000000o(fri.O0000o0O, "notificationclass");
            fri.O0000o0o = O000000o(fri.O0000o0o, "notificationextras");
            fri.O0000o = O000000o(fri.O0000o, "cookiedata");
            fri.O0000oO0 = O000000o(fri.O0000oO0, "useragent");
            fri.O0000oO = O000000o(fri.O0000oO, "referer");
            fri.O0000oOO = O00000Oo("total_bytes").longValue();
            fri.O0000oOo = O00000Oo("current_bytes").longValue();
            fri.O0000oo0 = O000000o(fri.O0000oo0, "etag");
            fri.O0000oo = O000000o("deleted").intValue() == 1;
            fri.O0000ooO = O000000o("is_public_api").intValue() != 0;
            fri.O0000ooo = O000000o("allowed_network_types").intValue();
            if (O000000o("allow_roaming").intValue() != 0) {
                z = true;
            }
            fri.O00oOooO = z;
            fri.O00oOooo = O000000o(fri.O00oOooo, "title");
            fri.O000O00o = O000000o(fri.O000O00o, "description");
            fri.O000O0OO = O000000o("bypass_recommended_size_limit").intValue();
            synchronized (this) {
                fri.O0000Oo0 = O000000o("control").intValue();
            }
        }

        private static void O000000o(fri fri, String str, String str2) {
            fri.O000O0o0.add(Pair.create(str, str2));
        }

        private String O000000o(String str, String str2) {
            int columnIndexOrThrow = this.O00000Oo.getColumnIndexOrThrow(str2);
            if (str == null) {
                return this.O00000Oo.getString(columnIndexOrThrow);
            }
            if (this.O00000o == null) {
                this.O00000o = new CharArrayBuffer((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            }
            this.O00000Oo.copyStringToBuffer(columnIndexOrThrow, this.O00000o);
            int i = this.O00000o.sizeCopied;
            if (i != str.length()) {
                return new String(this.O00000o.data, 0, i);
            }
            CharArrayBuffer charArrayBuffer = this.O00000o0;
            if (charArrayBuffer == null || charArrayBuffer.sizeCopied < i) {
                this.O00000o0 = new CharArrayBuffer(i);
            }
            char[] cArr = this.O00000o0.data;
            char[] cArr2 = this.O00000o.data;
            str.getChars(0, i, cArr, 0);
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (cArr[i2] != cArr2[i2]) {
                    return new String(cArr2, 0, i);
                }
            }
            return str;
        }

        private Integer O000000o(String str) {
            Cursor cursor = this.O00000Oo;
            return Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(str)));
        }

        private Long O00000Oo(String str) {
            Cursor cursor = this.O00000Oo;
            return Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(str)));
        }
    }

    private fri(Context context, frm frm) {
        this.O000O0o0 = new ArrayList();
        this.O000O0oO = context;
        this.O000O0o = frm;
        this.O000O0Oo = Helpers.f7316O000000o.nextInt(1001);
    }

    public final void O000000o() {
        Intent intent;
        if (this.O0000o0 != null) {
            if (this.O0000ooO) {
                intent = new Intent("android.intent.action.DOWNLOAD_COMPLETE");
                intent.setPackage(this.O0000o0);
                intent.putExtra("extra_download_id", this.f16968O000000o);
            } else if (this.O0000o0O != null) {
                intent = new Intent("android.intent.action.DOWNLOAD_COMPLETED");
                intent.setClassName(this.O0000o0, this.O0000o0O);
                String str = this.O0000o0o;
                if (str != null) {
                    intent.putExtra("notificationextras", str);
                }
                intent.setData(ContentUris.withAppendedId(Downloads.CONTENT_URI, this.f16968O000000o));
            } else {
                return;
            }
            this.O000O0o.O000000o(intent);
        }
    }

    public final long O000000o(long j) {
        int i = this.O0000OoO;
        if (i == 0) {
            return j;
        }
        int i2 = this.O0000Ooo;
        if (i2 > 0) {
            return this.O0000o00 + ((long) i2);
        }
        return this.O0000o00 + ((long) ((this.O000O0Oo + 1000) * 30 * (1 << (i - 1))));
    }

    public final int O00000Oo() {
        boolean z;
        Long O00000oO2;
        Integer O00000Oo2 = this.O000O0o.O00000Oo();
        int i = 2;
        if (O00000Oo2 == null) {
            return 2;
        }
        if (this.O0000ooO) {
            z = this.O00oOooO;
        } else {
            z = true;
        }
        if (!z && this.O000O0o.O00000o0()) {
            return 5;
        }
        int intValue = O00000Oo2.intValue();
        if (this.O0000ooO) {
            if (intValue == 0) {
                i = 1;
            } else if (intValue != 1) {
                i = 0;
            }
            if ((i & this.O0000ooo) == 0) {
                return 6;
            }
        }
        if (this.O0000oOO > 0 && intValue != 1) {
            Long O00000o2 = this.O000O0o.O00000o();
            if (O00000o2 != null && this.O0000oOO > O00000o2.longValue()) {
                return 3;
            }
            if (this.O000O0OO != 0 || (O00000oO2 = this.O000O0o.O00000oO()) == null || this.O0000oOO <= O00000oO2.longValue()) {
                return 1;
            }
            return 4;
        }
        return 1;
    }

    public final Uri O00000o0() {
        return ContentUris.withAppendedId(Downloads.ALL_DOWNLOADS_CONTENT_URI, this.f16968O000000o);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (O00000Oo() == 1) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (O000000o(r7) <= r7) goto L_0x0029;
     */
    public final void O00000Oo(long j) {
        boolean z = false;
        if (!this.O00oOoOo && this.O0000Oo0 != 1) {
            int i = this.O0000Oo;
            if (!(i == 0 || i == 190 || i == 192)) {
                switch (i) {
                }
            }
            z = true;
        }
        if (z) {
            if (this.O00oOoOo) {
                throw new IllegalStateException("Multiple threads on same download");
            } else if (this.O0000Oo != 192) {
                this.O0000Oo = 192;
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(this.O0000Oo));
                this.O000O0oO.getContentResolver().update(O00000o0(), contentValues, null, null);
            } else {
                DownloadThread downloadThread = new DownloadThread(this.O000O0oO, this.O000O0o, this);
                this.O00oOoOo = true;
                this.O000O0o.O000000o(downloadThread);
            }
        }
    }
}
