package _m_j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import java.io.IOException;
import java.io.InputStream;

public class iil {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f1317O000000o = "_m_j.iil";
    private static final String[] O00000Oo = {"drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable"};

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iil.O000000o(android.content.Context, java.lang.String, boolean):android.graphics.drawable.Drawable
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.iil.O000000o(android.content.Context, java.lang.String, java.lang.String):android.graphics.drawable.StateListDrawable
      _m_j.iil.O000000o(android.content.Context, java.lang.String, boolean):android.graphics.drawable.Drawable */
    public static Drawable O000000o(Context context, String str) {
        return O000000o(context, O00000o0(context, str), false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iil.O000000o(android.content.Context, java.lang.String, boolean):android.graphics.drawable.Drawable
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.iil.O000000o(android.content.Context, java.lang.String, java.lang.String):android.graphics.drawable.StateListDrawable
      _m_j.iil.O000000o(android.content.Context, java.lang.String, boolean):android.graphics.drawable.Drawable */
    private static Drawable O00000Oo(Context context, String str) {
        return O000000o(context, O00000o0(context, str), true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0090, code lost:
        if (java.lang.Math.abs(r4 - r2) <= java.lang.Math.abs(r4 - r5)) goto L_0x009d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ac  */
    private static String O00000o0(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            iii.O00000o0(f1317O000000o, "id is NOT correct!");
            return null;
        }
        int i = context.getResources().getDisplayMetrics().densityDpi;
        String str2 = i <= 120 ? "drawable-ldpi" : (i <= 120 || i > 160) ? (i <= 160 || i > 240) ? (i <= 240 || i > 320) ? "drawable-xxhdpi" : "drawable-xhdpi" : "drawable-hdpi" : "drawable-mdpi";
        iii.O000000o(f1317O000000o, "find Appropriate path...");
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            String[] strArr = O00000Oo;
            if (i2 >= strArr.length) {
                i2 = -1;
                break;
            }
            if (strArr[i2].equals(str2)) {
                i4 = i2;
            }
            String str3 = O00000Oo[i2] + "/" + str;
            if (O00000o(context, str3)) {
                if (i4 == i2) {
                    return str3;
                }
                if (i4 >= 0) {
                    break;
                }
                i5 = i2;
            }
            i2++;
        }
        if (i5 <= 0 || i2 <= 0) {
            if (i5 <= 0 || i2 >= 0) {
                if (i5 >= 0 || i2 <= 0) {
                    iii.O00000o0(f1317O000000o, "Not find the appropriate path for drawable");
                    if (i3 < 0) {
                        iii.O00000o0(f1317O000000o, "Not find the appropriate path for drawable");
                        return null;
                    }
                    return O00000Oo[i3] + "/" + str;
                }
                i3 = i2;
                if (i3 < 0) {
                }
            }
        }
        i3 = i5;
        if (i3 < 0) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[SYNTHETIC, Splitter:B:23:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC, Splitter:B:29:0x006d] */
    private static Drawable O000000o(Context context, String str, boolean z) {
        InputStream inputStream;
        NinePatchDrawable ninePatchDrawable = null;
        try {
            inputStream = context.getAssets().open(str);
            if (inputStream != null) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (z) {
                        ninePatchDrawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                    } else {
                        decodeStream.setDensity(displayMetrics.densityDpi);
                        ninePatchDrawable = new BitmapDrawable(context.getResources(), decodeStream);
                    }
                } catch (IOException e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return ninePatchDrawable;
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            e = e4;
            inputStream = null;
            e.printStackTrace();
            if (inputStream != null) {
            }
            return ninePatchDrawable;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
        return ninePatchDrawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r5 = _m_j.iil.f1317O000000o;
        _m_j.iii.O000000o(r5, "file [" + r6 + "] NOT existed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r2 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
    private static boolean O00000o(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        inputStream = context.getAssets().open(str);
        String str2 = f1317O000000o;
        iii.O000000o(str2, "file [" + str + "] existed");
        if (inputStream == null) {
            return true;
        }
        try {
            inputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static int O000000o(Context context, int i) {
        double d = (double) (((float) i) * context.getResources().getDisplayMetrics().density);
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    public static ColorStateList O000000o() {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, StateSet.WILD_CARD}, new int[]{-6710887, -6710887, -6710887, -498622});
    }

    public static StateListDrawable O000000o(Context context, String str, String str2) {
        Drawable drawable;
        Drawable drawable2;
        if (str.indexOf(".9") >= 0) {
            drawable = O00000Oo(context, str);
        } else {
            drawable = O000000o(context, str);
        }
        if (str2.indexOf(".9") >= 0) {
            drawable2 = O00000Oo(context, str2);
        } else {
            drawable2 = O000000o(context, str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[]{16842908}, drawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }
}
