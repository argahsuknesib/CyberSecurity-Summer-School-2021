package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;

public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode O0000OOo = PorterDuff.Mode.SRC_IN;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2830O000000o;
    public Object O00000Oo;
    public Parcelable O00000o;
    public byte[] O00000o0;
    public int O00000oO;
    public int O00000oo;
    public ColorStateList O0000O0o;
    public String O0000Oo;
    PorterDuff.Mode O0000Oo0;

    public static IconCompat O000000o(Resources resources, String str, int i) {
        if (i != 0) {
            IconCompat iconCompat = new IconCompat((byte) 0);
            iconCompat.O00000oO = i;
            iconCompat.O00000Oo = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public IconCompat() {
        this.f2830O000000o = -1;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O0000O0o = null;
        this.O0000Oo0 = O0000OOo;
        this.O0000Oo = null;
    }

    private IconCompat(byte b) {
        this.f2830O000000o = -1;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O0000O0o = null;
        this.O0000Oo0 = O0000OOo;
        this.O0000Oo = null;
        this.f2830O000000o = 2;
    }

    private String O00000Oo() {
        if (this.f2830O000000o == -1 && Build.VERSION.SDK_INT >= 23) {
            return O00000Oo((Icon) this.O00000Oo);
        }
        if (this.f2830O000000o == 2) {
            return ((String) this.O00000Oo).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on ".concat(String.valueOf(this)));
    }

    public final int O000000o() {
        if (this.f2830O000000o == -1 && Build.VERSION.SDK_INT >= 23) {
            return O00000o0((Icon) this.O00000Oo);
        }
        if (this.f2830O000000o == 2) {
            return this.O00000oO;
        }
        throw new IllegalStateException("called getResId() on ".concat(String.valueOf(this)));
    }

    private Uri O00000o0() {
        if (this.f2830O000000o == -1 && Build.VERSION.SDK_INT >= 23) {
            return O00000o((Icon) this.O00000Oo);
        }
        int i = this.f2830O000000o;
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.O00000Oo);
        }
        throw new IllegalStateException("called getUri() on ".concat(String.valueOf(this)));
    }

    public final Icon O000000o(Context context) {
        Icon icon;
        switch (this.f2830O000000o) {
            case -1:
                return (Icon) this.O00000Oo;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                icon = Icon.createWithBitmap((Bitmap) this.O00000Oo);
                break;
            case 2:
                icon = Icon.createWithResource(O00000Oo(), this.O00000oO);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.O00000Oo, this.O00000oO, this.O00000oo);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.O00000Oo);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    icon = Icon.createWithBitmap(O000000o((Bitmap) this.O00000Oo));
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.O00000Oo);
                    break;
                }
            case 6:
                throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + O00000o0());
        }
        ColorStateList colorStateList = this.O0000O0o;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.O0000Oo0;
        if (mode != O0000OOo) {
            icon.setTintMode(mode);
        }
        return icon;
    }

    public String toString() {
        String str;
        if (this.f2830O000000o == -1) {
            return String.valueOf(this.O00000Oo);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f2830O000000o) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f2830O000000o) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.O00000Oo).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.O00000Oo).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(O00000Oo());
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(O000000o())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.O00000oO);
                if (this.O00000oo != 0) {
                    sb.append(" off=");
                    sb.append(this.O00000oo);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.O00000Oo);
                break;
        }
        if (this.O0000O0o != null) {
            sb.append(" tint=");
            sb.append(this.O0000O0o);
        }
        if (this.O0000Oo0 != O0000OOo) {
            sb.append(" mode=");
            sb.append(this.O0000Oo0);
        }
        sb.append(")");
        return sb.toString();
    }

    public static int O000000o(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon type ".concat(String.valueOf(icon)), e);
            return -1;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon type ".concat(String.valueOf(icon)), e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type ".concat(String.valueOf(icon)), e3);
            return -1;
        }
    }

    private static String O00000Oo(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    private static int O00000o0(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    private static Uri O00000o(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    private static Bitmap O000000o(Bitmap bitmap) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = ((float) min) * 0.5f;
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f, f, 0.9166667f * f, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
