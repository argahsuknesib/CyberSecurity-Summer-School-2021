package _m_j;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.util.Pair;
import com.xiaomi.smarthome.download.Downloads;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class frj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f16970O000000o = {"_id", "title", "description", "uri", "media_type", "total_size", "local_uri", "status", "reason", "bytes_so_far", "last_modified_timestamp"};
    public static final Set<String> O00000Oo = new HashSet(Arrays.asList("_id", "total_size", "status", "reason", "bytes_so_far", "last_modified_timestamp"));
    private static final String[] O00000o0 = {"_id", "title", "description", "uri", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "destination", "hint", "_data"};
    private ContentResolver O00000o;
    private String O00000oO;
    private Uri O00000oo = Downloads.CONTENT_URI;

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ boolean f16973O000000o = (!frj.class.desiredAssertionStatus());
        private Uri O00000Oo;
        private List<Pair<String, String>> O00000o = new ArrayList();
        private Uri O00000o0;
        private CharSequence O00000oO;
        private CharSequence O00000oo;
        private boolean O0000O0o = true;
        private String O0000OOo;
        private int O0000Oo = -1;
        private boolean O0000Oo0 = true;
        private boolean O0000OoO = true;
        private String O0000Ooo;

        public O00000o0(Uri uri) {
            if (uri != null) {
                String scheme = uri.getScheme();
                if (scheme == null || !scheme.equals("http")) {
                    throw new IllegalArgumentException("Can only download HTTP URIs: ".concat(String.valueOf(uri)));
                }
                this.O00000Oo = uri;
                this.O0000Ooo = null;
                return;
            }
            throw new NullPointerException();
        }

        public O00000o0(Uri uri, String str) {
            if (uri != null) {
                String scheme = uri.getScheme();
                if (scheme == null || !scheme.equals("http")) {
                    throw new IllegalArgumentException("Can only download HTTP URIs: ".concat(String.valueOf(uri)));
                }
                this.O00000Oo = uri;
                this.O0000Ooo = str;
                return;
            }
            throw new NullPointerException();
        }

        public final O00000o0 O000000o(Context context, String str, String str2) {
            File externalFilesDir = context.getExternalFilesDir("external");
            if (externalFilesDir != null) {
                File file = new File(externalFilesDir.getPath() + "/" + str + "/");
                if (!file.exists()) {
                    file.mkdir();
                }
                O000000o(file, str2);
            }
            return this;
        }

        private void O000000o(File file, String str) {
            if (str != null) {
                this.O00000o0 = Uri.withAppendedPath(Uri.fromFile(file), str);
                LogType logType = LogType.NETWORK;
                gsy.O000000o(logType, "DownloadManager", "mDestinationUri=" + this.O00000o0.toString());
                return;
            }
            throw new NullPointerException("subPath cannot be null");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
         arg types: [java.lang.String, int]
         candidates:
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
        /* access modifiers changed from: package-private */
        public final ContentValues O000000o(String str) {
            ContentValues contentValues = new ContentValues();
            if (f16973O000000o || this.O00000Oo != null) {
                contentValues.put("uri", this.O00000Oo.toString());
                contentValues.put("is_public_api", Boolean.TRUE);
                contentValues.put("notificationpackage", str);
                int i = 0;
                if (this.O00000o0 != null) {
                    contentValues.put("destination", (Integer) 4);
                    contentValues.put("hint", this.O00000o0.toString());
                } else {
                    contentValues.put("destination", (Integer) 0);
                }
                if (!this.O00000o.isEmpty()) {
                    O000000o(contentValues);
                }
                O000000o(contentValues, "title", this.O00000oO);
                O000000o(contentValues, "description", this.O00000oo);
                O000000o(contentValues, "mimetype", this.O0000OOo);
                if (!this.O0000O0o) {
                    i = 2;
                }
                contentValues.put("visibility", Integer.valueOf(i));
                contentValues.put("allowed_network_types", Integer.valueOf(this.O0000Oo));
                contentValues.put("allow_roaming", Boolean.valueOf(this.O0000Oo0));
                contentValues.put("is_visible_in_downloads_ui", Boolean.valueOf(this.O0000OoO));
                contentValues.put("no_integrity", Boolean.TRUE);
                String str2 = this.O0000Ooo;
                if (str2 != null) {
                    contentValues.put("udn", str2);
                }
                return contentValues;
            }
            throw new AssertionError();
        }

        private void O000000o(ContentValues contentValues) {
            int i = 0;
            for (Pair next : this.O00000o) {
                contentValues.put("http_header_".concat(String.valueOf(i)), ((String) next.first) + ": " + ((String) next.second));
                i++;
            }
        }

        private static void O000000o(ContentValues contentValues, String str, Object obj) {
            if (obj != null) {
                contentValues.put(str, obj.toString());
            }
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public long[] f16972O000000o = null;
        public boolean O00000Oo = false;
        private String O00000o = "lastmod";
        private Integer O00000o0 = null;
        private int O00000oO = 2;

        /* access modifiers changed from: package-private */
        public final Cursor O000000o(ContentResolver contentResolver, String[] strArr, Uri uri) {
            String[] strArr2;
            ArrayList arrayList = new ArrayList();
            long[] jArr = this.f16972O000000o;
            if (jArr != null) {
                arrayList.add(frj.O00000oO(jArr));
                strArr2 = frj.O00000oo(this.f16972O000000o);
            } else {
                strArr2 = null;
            }
            String[] strArr3 = strArr2;
            if (this.O00000o0 != null) {
                ArrayList arrayList2 = new ArrayList();
                if ((this.O00000o0.intValue() & 1) != 0) {
                    arrayList2.add(O000000o("=", 190));
                }
                if ((this.O00000o0.intValue() & 2) != 0) {
                    arrayList2.add(O000000o("=", 192));
                }
                if ((this.O00000o0.intValue() & 4) != 0) {
                    arrayList2.add(O000000o("=", 193));
                    arrayList2.add(O000000o("=", 194));
                    arrayList2.add(O000000o("=", 195));
                    arrayList2.add(O000000o("=", 196));
                }
                if ((this.O00000o0.intValue() & 8) != 0) {
                    arrayList2.add(O000000o("=", 200));
                }
                if ((this.O00000o0.intValue() & 16) != 0) {
                    arrayList2.add("(" + O000000o(">=", 400) + " AND " + O000000o("<", 600) + ")");
                }
                arrayList.add(O000000o(" OR ", arrayList2));
            }
            if (this.O00000Oo) {
                arrayList.add("is_visible_in_downloads_ui != '0'");
            }
            arrayList.add("deleted != '1'");
            String O000000o2 = O000000o(" AND ", arrayList);
            String str = this.O00000oO == 1 ? "ASC" : "DESC";
            return contentResolver.query(uri, strArr, O000000o2, strArr3, this.O00000o + " " + str);
        }

        private static String O000000o(String str, Iterable<String> iterable) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String next : iterable) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(next);
                z = false;
            }
            return sb.toString();
        }

        private static String O000000o(String str, int i) {
            return "status" + str + "'" + i + "'";
        }
    }

    public frj(ContentResolver contentResolver, String str) {
        this.O00000o = contentResolver;
        this.O00000oO = str;
    }

    public final long O000000o(O00000o0 o00000o0) {
        return Long.parseLong(this.O00000o.insert(Downloads.CONTENT_URI, o00000o0.O000000o(this.O00000oO)).getLastPathSegment());
    }

    public final int O000000o(long... jArr) {
        if (jArr != null && jArr.length != 0) {
            return this.O00000o.delete(this.O00000oo, O00000oO(jArr), O00000oo(jArr));
        }
        throw new IllegalArgumentException("input param 'ids' can't be null");
    }

    public final Cursor O000000o(O00000Oo o00000Oo) {
        Cursor O000000o2 = o00000Oo.O000000o(this.O00000o, O00000o0, this.O00000oo);
        if (O000000o2 == null) {
            return null;
        }
        return new O000000o(O000000o2);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public final void O00000Oo(long... jArr) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.f16972O000000o = jArr;
        Cursor O000000o2 = O000000o(o00000Oo);
        try {
            O000000o2.moveToFirst();
            while (!O000000o2.isAfterLast()) {
                int i = O000000o2.getInt(O000000o2.getColumnIndex("status"));
                if (i != 2) {
                    if (i != 1) {
                        throw new IllegalArgumentException("Can only pause a running download: " + O000000o2.getLong(O000000o2.getColumnIndex("_id")));
                    }
                }
                O000000o2.moveToNext();
            }
            O000000o2.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("control", (Integer) 1);
            contentValues.put("no_integrity", (Integer) 1);
            this.O00000o.update(this.O00000oo, contentValues, O00000oO(jArr), O00000oo(jArr));
        } catch (Throwable th) {
            O000000o2.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public final void O00000o0(long... jArr) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.f16972O000000o = jArr;
        Cursor O000000o2 = O000000o(o00000Oo);
        try {
            O000000o2.moveToFirst();
            while (!O000000o2.isAfterLast()) {
                if (O000000o2.getInt(O000000o2.getColumnIndex("status")) == 4) {
                    O000000o2.moveToNext();
                } else {
                    throw new IllegalArgumentException("Cann only resume a paused download: " + O000000o2.getLong(O000000o2.getColumnIndex("_id")));
                }
            }
            O000000o2.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 190);
            contentValues.put("control", (Integer) 0);
            this.O00000o.update(this.O00000oo, contentValues, O00000oO(jArr), O00000oo(jArr));
        } catch (Throwable th) {
            O000000o2.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public final void O00000o(long... jArr) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.f16972O000000o = jArr;
        Cursor O000000o2 = O000000o(o00000Oo);
        try {
            O000000o2.moveToFirst();
            while (!O000000o2.isAfterLast()) {
                int i = O000000o2.getInt(O000000o2.getColumnIndex("status"));
                if (i != 8) {
                    if (i != 16) {
                        throw new IllegalArgumentException("Cannot restart incomplete download: " + O000000o2.getLong(O000000o2.getColumnIndex("_id")));
                    }
                }
                O000000o2.moveToNext();
            }
            O000000o2.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_bytes", (Integer) 0);
            contentValues.put("total_bytes", (Integer) -1);
            contentValues.putNull("_data");
            contentValues.put("status", (Integer) 190);
            this.O00000o.update(this.O00000oo, contentValues, O00000oO(jArr), O00000oo(jArr));
        } catch (Throwable th) {
            O000000o2.close();
            throw th;
        }
    }

    static String O00000oO(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                sb.append("OR ");
            }
            sb.append("_id");
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    static String[] O00000oo(long[] jArr) {
        String[] strArr = new String[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            strArr[i] = Long.toString(jArr[i]);
        }
        return strArr;
    }

    static class O000000o extends CursorWrapper {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ boolean f16971O000000o = (!frj.class.desiredAssertionStatus());

        private static long O00000Oo(int i) {
            switch (i) {
                case 194:
                    return 1;
                case 195:
                    return 2;
                case 196:
                    return 3;
                default:
                    return 4;
            }
        }

        private static long O00000o0(int i) {
            if ((400 <= i && i < 488) || (500 <= i && i < 600)) {
                return (long) i;
            }
            switch (i) {
                case 488:
                    return 1009;
                case 489:
                    return 1008;
                case 490:
                case 491:
                case 496:
                default:
                    return 1000;
                case 492:
                    return 1001;
                case 493:
                case 494:
                    return 1002;
                case 495:
                    return 1004;
                case 497:
                    return 1005;
                case 498:
                    return 1006;
                case 499:
                    return 1007;
            }
        }

        public O000000o(Cursor cursor) {
            super(cursor);
        }

        public final int getColumnIndex(String str) {
            return Arrays.asList(frj.f16970O000000o).indexOf(str);
        }

        public final int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            int columnIndex = getColumnIndex(str);
            if (columnIndex != -1) {
                return columnIndex;
            }
            throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
        }

        public final String getColumnName(int i) {
            int length = frj.f16970O000000o.length;
            if (i >= 0 && i < length) {
                return frj.f16970O000000o[i];
            }
            throw new IllegalArgumentException("Invalid column index " + i + ", " + length + " columns exist");
        }

        public final String[] getColumnNames() {
            String[] strArr = new String[frj.f16970O000000o.length];
            System.arraycopy(frj.f16970O000000o, 0, strArr, 0, frj.f16970O000000o.length);
            return strArr;
        }

        public final int getColumnCount() {
            return frj.f16970O000000o.length;
        }

        public final byte[] getBlob(int i) {
            throw new UnsupportedOperationException();
        }

        public final double getDouble(int i) {
            return (double) getLong(i);
        }

        private static boolean O000000o(String str) {
            return frj.O00000Oo.contains(str);
        }

        public final float getFloat(int i) {
            return (float) getDouble(i);
        }

        public final int getInt(int i) {
            return (int) getLong(i);
        }

        public final long getLong(int i) {
            return O00000o0(getColumnName(i));
        }

        public final short getShort(int i) {
            return (short) ((int) getLong(i));
        }

        public final String getString(int i) {
            return O00000Oo(getColumnName(i));
        }

        private String O00000Oo(String str) {
            if (O000000o(str)) {
                return Long.toString(O00000o0(str));
            }
            if (str.equals("title")) {
                return O00000oO("title");
            }
            if (str.equals("description")) {
                return O00000oO("description");
            }
            if (str.equals("uri")) {
                return O00000oO("uri");
            }
            if (str.equals("media_type")) {
                return O00000oO("mimetype");
            }
            if (f16971O000000o || str.equals("local_uri")) {
                return O000000o();
            }
            throw new AssertionError();
        }

        private String O000000o() {
            String O00000oO = O00000oO("_data");
            if (O00000oO == null) {
                return null;
            }
            return Uri.fromFile(new File(O00000oO)).toString();
        }

        private long O00000o0(String str) {
            if (!O000000o(str)) {
                return Long.valueOf(O00000Oo(str)).longValue();
            }
            if (str.equals("_id")) {
                return O00000o("_id");
            }
            if (str.equals("total_size")) {
                return O00000o("total_bytes");
            }
            if (str.equals("status")) {
                return (long) O00000o((int) O00000o("status"));
            }
            if (str.equals("reason")) {
                return O000000o((int) O00000o("status"));
            }
            if (str.equals("bytes_so_far")) {
                return O00000o("current_bytes");
            }
            if (f16971O000000o || str.equals("last_modified_timestamp")) {
                return O00000o("lastmod");
            }
            throw new AssertionError();
        }

        private static long O000000o(int i) {
            int O00000o = O00000o(i);
            if (O00000o == 4) {
                return O00000Oo(i);
            }
            if (O00000o != 16) {
                return 0;
            }
            return O00000o0(i);
        }

        private long O00000o(String str) {
            return super.getLong(super.getColumnIndex(str));
        }

        private String O00000oO(String str) {
            return super.getString(super.getColumnIndex(str));
        }

        private static int O00000o(int i) {
            if (i == 190) {
                return 1;
            }
            if (i == 200) {
                return 8;
            }
            switch (i) {
                case 192:
                    return 2;
                case 193:
                case 194:
                case 195:
                case 196:
                    return 4;
                default:
                    if (f16971O000000o || Downloads.isStatusError(i)) {
                        return 16;
                    }
                    throw new AssertionError();
            }
        }
    }
}
