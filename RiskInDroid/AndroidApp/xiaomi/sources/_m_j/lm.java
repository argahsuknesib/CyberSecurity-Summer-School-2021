package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public final class lm {
    public static int O000000o(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int O000000o(Context context) {
        return (int) TypedValue.applyDimension(2, 10.0f, context.getResources().getDisplayMetrics());
    }

    public static ImageView O000000o(Context context, int i, ln lnVar, ImageView.ScaleType scaleType) {
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(O000000o(context, i, lnVar.f2169O000000o, lnVar.O00000Oo, lnVar.O00000o0, lnVar.O00000o));
        imageView.setClickable(true);
        imageView.setScaleType(scaleType);
        return imageView;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, int):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O000000o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O000000o(int, int):int
      _m_j.cb.O000000o(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O000000o(int, android.view.View):void
      _m_j.cb.O000000o(android.view.View, _m_j.bh):void
      _m_j.cb.O000000o(android.view.View, _m_j.bw):void
      _m_j.cb.O000000o(android.view.View, _m_j.by):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl$O000000o):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl):void
      _m_j.cb.O000000o(android.view.View, android.content.res.ColorStateList):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Paint):void
      _m_j.cb.O000000o(android.view.View, android.graphics.PorterDuff$Mode):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Rect):void
      _m_j.cb.O000000o(android.view.View, android.graphics.drawable.Drawable):void
      _m_j.cb.O000000o(android.view.View, java.lang.Runnable):void
      _m_j.cb.O000000o(android.view.View, java.lang.String):void
      _m_j.cb.O000000o(android.view.View, boolean):void
      _m_j.cb.O000000o(android.view.View, int):boolean
      _m_j.cb.O000000o(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O000000o(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000Oo(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000Oo(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O00000Oo(android.view.View, boolean):void
      _m_j.cb.O00000Oo(android.view.View, int):boolean
      _m_j.cb.O00000Oo(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O00000Oo(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oo(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000oo(android.view.View, int):void
      _m_j.cb.O00000oo(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000O0o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O0000O0o(android.view.View, int):void
      _m_j.cb.O0000O0o(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, int):void
      _m_j.cb.O00000oO(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o(android.view.View, int):void
      _m_j.cb.O00000o(android.view.View, float):void */
    public static void O000000o(List<? extends View> list) {
        if (list != null) {
            for (View view : list) {
                view.setVisibility(0);
                cb.O00000o0(view, 1.0f);
                cb.O0000OOo(view, ((float) view.getMeasuredWidth()) * 0.5f);
                cb.O0000Oo0(view, ((float) view.getMeasuredHeight()) * 0.5f);
                cb.O000000o(view, 0.0f);
                cb.O00000Oo(view, 0.0f);
                cb.O00000oo(view, 1.0f);
                cb.O0000O0o(view, 1.0f);
                cb.O0000oO0(view);
                cb.O00000oO(view, 0.0f);
                cb.O00000o(view, 0.0f);
            }
        }
    }

    public static boolean O000000o(int i, Collection collection) {
        return O00000Oo(collection, new Collection[0]) && i < collection.size();
    }

    public static boolean O000000o(Collection collection, Collection... collectionArr) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        for (Collection collection2 : collectionArr) {
            if (collection2 == null || collection2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000Oo(Collection collection, Collection... collectionArr) {
        return !O000000o(collection, collectionArr);
    }

    private static Bitmap O000000o(Context context, int i, int i2, int i3, float f, float f2) {
        O000000o<Throwable> O000000o2;
        do {
            O000000o2 = O000000o(context, i, i2, i3);
            if (O000000o2.f12896O000000o != null) {
                break;
            }
            i2 /= 2;
            i3 /= 2;
            if (!(O000000o2.O00000Oo instanceof OutOfMemoryError) || ((float) i2) <= f) {
                break;
            }
        } while (((float) i3) > f2);
        return (Bitmap) O000000o2.f12896O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ab A[SYNTHETIC, Splitter:B:43:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c0 A[SYNTHETIC, Splitter:B:52:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c7 A[SYNTHETIC, Splitter:B:56:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x00a1=Splitter:B:40:0x00a1, B:49:0x00b6=Splitter:B:49:0x00b6} */
    private static O000000o<Throwable> O000000o(Context context, int i, int i2, int i3) {
        InputStream inputStream;
        O000000o<Throwable> o000000o;
        O000000o<Throwable> o000000o2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap.Config config = Bitmap.Config.RGB_565;
        if (i2 == 0 && i3 == 0) {
            try {
                options.inPreferredConfig = config;
                inputStream = context.getResources().openRawResource(i);
            } catch (OutOfMemoryError e) {
                e = e;
                inputStream = null;
                e.printStackTrace();
                o000000o = new O000000o<>(null, e);
                if (inputStream != null) {
                    return o000000o;
                }
                inputStream.close();
                return o000000o;
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
                e.printStackTrace();
                o000000o = new O000000o<>(null, e);
                if (inputStream == null) {
                    return o000000o;
                }
                try {
                    inputStream.close();
                    return o000000o;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return o000000o;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = null;
                if (inputStream != null) {
                }
                throw th;
            }
            try {
                o000000o2 = new O000000o<>(BitmapFactory.decodeStream(inputStream, null, options), null);
                inputStream.close();
            } catch (OutOfMemoryError e4) {
                e = e4;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                o000000o = new O000000o<>(null, e);
                if (inputStream == null) {
                }
            }
        } else {
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = config;
            InputStream openRawResource = context.getResources().openRawResource(i);
            try {
                BitmapFactory.decodeStream(openRawResource, null, options);
                openRawResource.reset();
                openRawResource.close();
                int i4 = options.outWidth;
                int i5 = options.outHeight;
                int O000000o2 = O000000o(i2, i3, i4, i5);
                int O000000o3 = O000000o(i3, i2, i5, i4);
                options.inJustDecodeBounds = false;
                options.inSampleSize = O000000o(options, O000000o2, O000000o3);
                options.inPreferredConfig = config;
                inputStream = context.getResources().openRawResource(i);
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.close();
                if (decodeStream == null || (decodeStream.getWidth() <= O000000o2 && decodeStream.getHeight() <= O000000o3)) {
                    o000000o2 = new O000000o<>(decodeStream, null);
                } else {
                    O000000o<Throwable> o000000o3 = new O000000o<>(Bitmap.createScaledBitmap(decodeStream, O000000o2, O000000o3, true), null);
                    decodeStream.recycle();
                    o000000o2 = o000000o3;
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                inputStream = openRawResource;
                e.printStackTrace();
                o000000o = new O000000o<>(null, e);
                if (inputStream != null) {
                }
            } catch (Exception e7) {
                e = e7;
                inputStream = openRawResource;
                try {
                    e.printStackTrace();
                    o000000o = new O000000o<>(null, e);
                    if (inputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = openRawResource;
                if (inputStream != null) {
                }
                throw th;
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        }
        return o000000o2;
    }

    static class O000000o<S extends Throwable> extends be<Bitmap, S> {
        O000000o(Bitmap bitmap, S s) {
            super(bitmap, s);
        }
    }

    private static int O000000o(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            double d = (double) i2;
            double d2 = (double) i4;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = (double) i3;
            Double.isNaN(d3);
            return (int) (d3 * (d / d2));
        } else if (i2 == 0) {
            return i;
        } else {
            double d4 = (double) i4;
            double d5 = (double) i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            double d7 = (double) i;
            Double.isNaN(d7);
            double d8 = (double) i2;
            if (d7 * d6 <= d8) {
                return i;
            }
            Double.isNaN(d8);
            return (int) (d8 / d6);
        }
    }

    private static int O000000o(BitmapFactory.Options options, int i, int i2) {
        int i3 = 1;
        if (!(i == 0 || i2 == 0)) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 > i2 || i5 > i) {
                int i6 = i4 / 2;
                int i7 = i5 / 2;
                while (i6 / i3 >= i2 && i7 / i3 >= i) {
                    i3 *= 2;
                }
            }
        }
        return i3;
    }
}
