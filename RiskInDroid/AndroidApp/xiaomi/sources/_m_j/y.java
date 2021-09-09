package _m_j;

import _m_j.j;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

public final class y extends z {
    /* access modifiers changed from: protected */
    public final FontsContractCompat.O00000Oo O000000o(FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* access modifiers changed from: protected */
    public final Typeface O000000o(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public final Typeface O000000o(Context context, CancellationSignal cancellationSignal, FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        int length = o00000OoArr.length;
        int i2 = 0;
        FontFamily.Builder builder = null;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 < length) {
                FontsContractCompat.O00000Oo o00000Oo = o00000OoArr[i3];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(o00000Oo.f2835O000000o, "r", null);
                    if (openFileDescriptor != null) {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(o00000Oo.O00000o0);
                        if (!o00000Oo.O00000o) {
                            i4 = 0;
                        }
                        Font build = weight.setSlant(i4).setTtcIndex(o00000Oo.O00000Oo).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                        if (openFileDescriptor == null) {
                            i3++;
                        }
                    } else if (openFileDescriptor == null) {
                        i3++;
                    }
                    openFileDescriptor.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th.addSuppressed(th);
                    break;
                }
                i3++;
            } else if (builder == null) {
                return null;
            } else {
                int i5 = (i & 1) != 0 ? 700 : 400;
                if ((i & 2) != 0) {
                    i2 = 1;
                }
                return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
            }
        }
        throw th;
    }

    public final Typeface O000000o(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (IOException unused) {
            return null;
        }
    }

    public final Typeface O000000o(Context context, j.O00000Oo o00000Oo, Resources resources, int i) {
        j.O00000o0[] o00000o0Arr = o00000Oo.f1687O000000o;
        int length = o00000o0Arr.length;
        int i2 = 0;
        FontFamily.Builder builder = null;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 >= length) {
                break;
            }
            j.O00000o0 o00000o0 = o00000o0Arr[i3];
            try {
                Font.Builder weight = new Font.Builder(resources, o00000o0.O00000oo).setWeight(o00000o0.O00000Oo);
                if (!o00000o0.O00000o0) {
                    i4 = 0;
                }
                Font build = weight.setSlant(i4).setTtcIndex(o00000o0.O00000oO).setFontVariationSettings(o00000o0.O00000o).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i3++;
        }
        if (builder == null) {
            return null;
        }
        int i5 = (i & 1) != 0 ? 700 : 400;
        if ((i & 2) != 0) {
            i2 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
    }
}
