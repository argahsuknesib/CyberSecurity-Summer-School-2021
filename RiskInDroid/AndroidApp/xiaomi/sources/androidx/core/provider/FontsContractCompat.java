package androidx.core.provider;

import _m_j.aa;
import _m_j.at;
import _m_j.au;
import _m_j.bf;
import _m_j.j;
import _m_j.m;
import _m_j.o0OO00OO;
import _m_j.o0oOo0O0;
import _m_j.t;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class FontsContractCompat {

    /* renamed from: O000000o  reason: collision with root package name */
    static final o0oOo0O0<String, Typeface> f2831O000000o = new o0oOo0O0<>(16);
    static final Object O00000Oo = new Object();
    private static final au O00000o = new au("fonts");
    static final o0OO00OO<String, ArrayList<au.O000000o<O00000o0>>> O00000o0 = new o0OO00OO<>();
    private static final Comparator<byte[]> O00000oO = new Comparator<byte[]>() {
        /* class androidx.core.provider.FontsContractCompat.AnonymousClass4 */

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            int i;
            int i2;
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = (byte[]) obj2;
            if (bArr.length != bArr2.length) {
                i2 = bArr.length;
                i = bArr2.length;
            } else {
                int i3 = 0;
                while (i3 < bArr.length) {
                    if (bArr[i3] != bArr2[i3]) {
                        i2 = bArr[i3];
                        i = bArr2[i3];
                    } else {
                        i3++;
                    }
                }
                return 0;
            }
            return i2 - i;
        }
    };

    public static final class Columns implements BaseColumns {
    }

    static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final Typeface f2836O000000o;
        final int O00000Oo;

        O00000o0(Typeface typeface, int i) {
            this.f2836O000000o = typeface;
            this.O00000Oo = i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        r3 = androidx.core.provider.FontsContractCompat.O00000o;
        r3.O000000o(new _m_j.au.AnonymousClass2(r3, r1, new android.os.Handler(), new androidx.core.provider.FontsContractCompat.AnonymousClass3()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        return null;
     */
    public static Typeface O000000o(final Context context, final at atVar, final m.O000000o o000000o, final Handler handler, boolean z, int i, final int i2) {
        AnonymousClass2 r3;
        final String str = atVar.O00000oo + "-" + i2;
        Typeface typeface = f2831O000000o.get(str);
        if (typeface != null) {
            if (o000000o != null) {
                o000000o.onFontRetrieved(typeface);
            }
            return typeface;
        } else if (!z || i != -1) {
            AnonymousClass1 r1 = new Callable<O00000o0>() {
                /* class androidx.core.provider.FontsContractCompat.AnonymousClass1 */

                public O00000o0 call() throws Exception {
                    O00000o0 O000000o2 = FontsContractCompat.O000000o(context, atVar, i2);
                    if (O000000o2.f2836O000000o != null) {
                        FontsContractCompat.f2831O000000o.put(str, O000000o2.f2836O000000o);
                    }
                    return O000000o2;
                }
            };
            if (z) {
                try {
                    return ((O00000o0) O00000o.O000000o(r1, i)).f2836O000000o;
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                if (o000000o == null) {
                    r3 = null;
                } else {
                    r3 = new au.O000000o<O00000o0>() {
                        /* class androidx.core.provider.FontsContractCompat.AnonymousClass2 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            O00000o0 o00000o0 = (O00000o0) obj;
                            if (o00000o0 == null) {
                                m.O000000o.this.callbackFailAsync(1, handler);
                            } else if (o00000o0.O00000Oo == 0) {
                                m.O000000o.this.callbackSuccessAsync(o00000o0.f2836O000000o, handler);
                            } else {
                                m.O000000o.this.callbackFailAsync(o00000o0.O00000Oo, handler);
                            }
                        }
                    };
                }
                synchronized (O00000Oo) {
                    ArrayList arrayList = O00000o0.get(str);
                    if (arrayList != null) {
                        if (r3 != null) {
                            arrayList.add(r3);
                        }
                    } else if (r3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(r3);
                        O00000o0.put(str, arrayList2);
                    }
                }
            }
        } else {
            O00000o0 O000000o2 = O000000o(context, atVar, i2);
            if (o000000o != null) {
                if (O000000o2.O00000Oo == 0) {
                    o000000o.callbackSuccessAsync(O000000o2.f2836O000000o, handler);
                } else {
                    o000000o.callbackFailAsync(O000000o2.O00000Oo, handler);
                }
            }
            return O000000o2.f2836O000000o;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Uri f2835O000000o;
        public final int O00000Oo;
        public final boolean O00000o;
        public final int O00000o0;
        final int O00000oO;

        public O00000Oo(Uri uri, int i, int i2, boolean z, int i3) {
            this.f2835O000000o = (Uri) bf.O000000o(uri);
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = z;
            this.O00000oO = i3;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f2834O000000o;
        final O00000Oo[] O00000Oo;

        public O000000o(int i, O00000Oo[] o00000OoArr) {
            this.f2834O000000o = i;
            this.O00000Oo = o00000OoArr;
        }
    }

    public static Map<Uri, ByteBuffer> O000000o(Context context, O00000Oo[] o00000OoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (O00000Oo o00000Oo : o00000OoArr) {
            if (o00000Oo.O00000oO == 0) {
                Uri uri = o00000Oo.f2835O000000o;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, aa.O000000o(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean O000000o(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> O000000o(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static O00000Oo[] O000000o(Context context, at atVar, String str, CancellationSignal cancellationSignal) {
        Cursor cursor;
        Uri uri;
        at atVar2 = atVar;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor2 = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{atVar2.O00000o0}, null, null);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{atVar2.O00000o0}, null);
            }
            cursor2 = cursor;
            if (cursor2 != null && cursor2.getCount() > 0) {
                int columnIndex = cursor2.getColumnIndex("result_code");
                arrayList = new ArrayList();
                int columnIndex2 = cursor2.getColumnIndex("_id");
                int columnIndex3 = cursor2.getColumnIndex("file_id");
                int columnIndex4 = cursor2.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor2.getColumnIndex("font_weight");
                int columnIndex6 = cursor2.getColumnIndex("font_italic");
                while (cursor2.moveToNext()) {
                    int i = columnIndex != -1 ? cursor2.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor2.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor2.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor2.getLong(columnIndex3));
                    }
                    arrayList.add(new O00000Oo(uri, i2, columnIndex5 != -1 ? cursor2.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor2.getInt(columnIndex6) == 1, i));
                }
            }
            return (O00000Oo[]) arrayList.toArray(new O00000Oo[0]);
        } finally {
            if (cursor2 != null) {
                cursor2.close();
            }
        }
    }

    static O00000o0 O000000o(Context context, at atVar, int i) {
        List<List<byte[]>> list;
        O000000o o000000o;
        try {
            PackageManager packageManager = context.getPackageManager();
            Resources resources = context.getResources();
            String str = atVar.f12581O000000o;
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: ".concat(String.valueOf(str)));
            } else if (resolveContentProvider.packageName.equals(atVar.O00000Oo)) {
                List<byte[]> O000000o2 = O000000o(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(O000000o2, O00000oO);
                if (atVar.O00000o != null) {
                    list = atVar.O00000o;
                } else {
                    list = j.O000000o(resources, atVar.O00000oO);
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        resolveContentProvider = null;
                        break;
                    }
                    ArrayList arrayList = new ArrayList((Collection) list.get(i2));
                    Collections.sort(arrayList, O00000oO);
                    if (O000000o(O000000o2, arrayList)) {
                        break;
                    }
                    i2++;
                }
                if (resolveContentProvider == null) {
                    o000000o = new O000000o(1, null);
                } else {
                    o000000o = new O000000o(0, O000000o(context, atVar, resolveContentProvider.authority, null));
                }
                int i3 = -3;
                if (o000000o.f2834O000000o == 0) {
                    Typeface O000000o3 = t.O000000o(context, o000000o.O00000Oo, i);
                    if (O000000o3 != null) {
                        i3 = 0;
                    }
                    return new O00000o0(O000000o3, i3);
                }
                if (o000000o.f2834O000000o == 1) {
                    i3 = -2;
                }
                return new O00000o0(null, i3);
            } else {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + atVar.O00000Oo);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return new O00000o0(null, -1);
        }
    }
}
