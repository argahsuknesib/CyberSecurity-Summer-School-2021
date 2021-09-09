package _m_j;

import _m_j.d;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import java.util.List;
import java.util.Map;

public final class oOOO00o0 extends ContextCompat {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O00000Oo f2311O000000o;

    public interface O000000o {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface O00000Oo {
        boolean O000000o();

        boolean O00000Oo();
    }

    public interface O00000o0 {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static O00000Oo O000000o() {
        return f2311O000000o;
    }

    public static void O000000o(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void O000000o(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void O000000o(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void O00000Oo(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void O000000o(Activity activity, d dVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(dVar != null ? new O00000o(dVar) : null);
        }
    }

    public static void O00000Oo(Activity activity, d dVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(dVar != null ? new O00000o(dVar) : null);
        }
    }

    public static void O00000o0(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void O00000o(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void O000000o(final Activity activity, final String[] strArr, final int i) {
        O00000Oo o00000Oo = f2311O000000o;
        if (o00000Oo != null && o00000Oo.O000000o()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof O00000o0) {
                ((O00000o0) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof O000000o) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class _m_j.oOOO00o0.AnonymousClass1 */

                public final void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((O000000o) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean O000000o(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void O00000oO(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else if (!oOOO0O0o.O000000o(activity)) {
            activity.recreate();
        }
    }

    static class O00000o extends SharedElementCallback {

        /* renamed from: O000000o  reason: collision with root package name */
        private final d f2313O000000o;

        public final void onMapSharedElements(List<String> list, Map<String, View> map) {
        }

        public final void onRejectSharedElements(List<View> list) {
        }

        public final void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        }

        public final void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        }

        O00000o(d dVar) {
            this.f2313O000000o = dVar;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            Bitmap bitmap;
            View view2 = view;
            RectF rectF2 = rectF;
            d dVar = this.f2313O000000o;
            if (view2 instanceof ImageView) {
                ImageView imageView = (ImageView) view2;
                Drawable drawable = imageView.getDrawable();
                Drawable background = imageView.getBackground();
                if (drawable != null && background == null) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                        bitmap = null;
                    } else {
                        float min = Math.min(1.0f, 1048576.0f / ((float) (intrinsicWidth * intrinsicHeight)));
                        if (!(drawable instanceof BitmapDrawable) || min != 1.0f) {
                            int i = (int) (((float) intrinsicWidth) * min);
                            int i2 = (int) (((float) intrinsicHeight) * min);
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            Rect bounds = drawable.getBounds();
                            int i3 = bounds.left;
                            int i4 = bounds.top;
                            int i5 = bounds.right;
                            int i6 = bounds.bottom;
                            drawable.setBounds(0, 0, i, i2);
                            drawable.draw(canvas);
                            drawable.setBounds(i3, i4, i5, i6);
                            bitmap = createBitmap;
                        } else {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        }
                    }
                    if (bitmap != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("sharedElement:snapshot:bitmap", bitmap);
                        bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float[] fArr = new float[9];
                            imageView.getImageMatrix().getValues(fArr);
                            bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                        }
                        return bundle;
                    }
                }
            }
            int round = Math.round(rectF.width());
            int round2 = Math.round(rectF.height());
            if (round <= 0 || round2 <= 0) {
                return null;
            }
            float min2 = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int i7 = (int) (((float) round) * min2);
            int i8 = (int) (((float) round2) * min2);
            if (dVar.f14413O000000o == null) {
                dVar.f14413O000000o = new Matrix();
            }
            dVar.f14413O000000o.set(matrix);
            dVar.f14413O000000o.postTranslate(-rectF2.left, -rectF2.top);
            dVar.f14413O000000o.postScale(min2, min2);
            Bitmap createBitmap2 = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.concat(dVar.f14413O000000o);
            view2.draw(canvas2);
            return createBitmap2;
        }

        public final void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            new d.O000000o() {
                /* class _m_j.oOOO00o0.O00000o.AnonymousClass1 */

                public final void O000000o() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            }.O000000o();
        }

        public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
                if (bitmap == null) {
                    return null;
                }
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
                if (imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                    return imageView;
                }
                float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
                Matrix matrix = new Matrix();
                matrix.setValues(floatArray);
                imageView.setImageMatrix(matrix);
                return imageView;
            } else if (!(parcelable instanceof Bitmap)) {
                return null;
            } else {
                ImageView imageView2 = new ImageView(context);
                imageView2.setImageBitmap((Bitmap) parcelable);
                return imageView2;
            }
        }
    }
}
