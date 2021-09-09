package com.google.android.material.transition.platform;

import _m_j.p;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    public static WeakReference<View> capturedSharedElement;
    private boolean entering = true;
    private Rect returnEndBounds;
    private ShapeProvider shapeProvider = new ShapeableViewShapeProvider();
    private boolean sharedElementReenterTransitionEnabled = false;
    private boolean transparentWindowBackgroundEnabled = true;

    public interface ShapeProvider {
        ShapeAppearanceModel provideShape(View view);
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
        public ShapeAppearanceModel provideShape(View view) {
            if (view instanceof Shapeable) {
                return ((Shapeable) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        capturedSharedElement = new WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view;
        ShapeAppearanceModel provideShape;
        View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (!(onCreateSnapshotView == null || (weakReference = capturedSharedElement) == null || this.shapeProvider == null || (view = weakReference.get()) == null || (provideShape = this.shapeProvider.provideShape(view)) == null)) {
            onCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, provideShape);
        }
        return onCreateSnapshotView;
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
        View view;
        Activity activity;
        if (!list.isEmpty() && !map.isEmpty() && (view = map.get(list.get(0))) != null && (activity = ContextUtils.getActivity(view.getContext())) != null) {
            Window window = activity.getWindow();
            if (this.entering) {
                setUpEnterTransform(window);
            } else {
                setUpReturnTransform(activity, window);
            }
        }
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (!this.entering && !list2.isEmpty() && this.returnEndBounds != null) {
            View view = list2.get(0);
            view.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
            view.layout(this.returnEndBounds.left, this.returnEndBounds.top, this.returnEndBounds.right, this.returnEndBounds.bottom);
        }
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        if (!list2.isEmpty() && (list2.get(0).getTag(R.id.mtrl_motion_snapshot_view) instanceof View)) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, null);
        }
        if (!this.entering && !list2.isEmpty()) {
            this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(list2.get(0));
        }
        this.entering = false;
    }

    public ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    public void setShapeProvider(ShapeProvider shapeProvider2) {
        this.shapeProvider = shapeProvider2;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    public void setTransparentWindowBackgroundEnabled(boolean z) {
        this.transparentWindowBackgroundEnabled = z;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public void setSharedElementReenterTransitionEnabled(boolean z) {
        this.sharedElementReenterTransitionEnabled = z;
    }

    private void setUpEnterTransform(final Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
            if (!this.sharedElementReenterTransitionEnabled) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() {
                    /* class com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.AnonymousClass1 */

                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.removeWindowBackground(window);
                    }

                    public void onTransitionEnd(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.restoreWindowBackground(window);
                    }
                });
            }
        }
    }

    private void setUpReturnTransform(final Activity activity, final Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementReturnTransition;
            materialContainerTransform.setHoldAtEndEnabled(true);
            materialContainerTransform.addListener(new TransitionListenerAdapter() {
                /* class com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.AnonymousClass2 */

                public void onTransitionEnd(Transition transition) {
                    View view;
                    if (!(MaterialContainerTransformSharedElementCallback.capturedSharedElement == null || (view = MaterialContainerTransformSharedElementCallback.capturedSharedElement.get()) == null)) {
                        view.setAlpha(1.0f);
                        MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
                    }
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
            });
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() {
                    /* class com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.AnonymousClass3 */

                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.removeWindowBackground(window);
                    }
                });
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cc  */
    public static void removeWindowBackground(Window window) {
        PorterDuff.Mode mode;
        BlendMode blendMode;
        Drawable mutate = window.getDecorView().getBackground().mutate();
        BlendModeCompat blendModeCompat = BlendModeCompat.CLEAR;
        ColorFilter colorFilter = null;
        if (Build.VERSION.SDK_INT >= 29) {
            switch (p.AnonymousClass1.f2379O000000o[blendModeCompat.ordinal()]) {
                case 1:
                    blendMode = BlendMode.CLEAR;
                    break;
                case 2:
                    blendMode = BlendMode.SRC;
                    break;
                case 3:
                    blendMode = BlendMode.DST;
                    break;
                case 4:
                    blendMode = BlendMode.SRC_OVER;
                    break;
                case 5:
                    blendMode = BlendMode.DST_OVER;
                    break;
                case 6:
                    blendMode = BlendMode.SRC_IN;
                    break;
                case 7:
                    blendMode = BlendMode.DST_IN;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    blendMode = BlendMode.SRC_OUT;
                    break;
                case 9:
                    blendMode = BlendMode.DST_OUT;
                    break;
                case 10:
                    blendMode = BlendMode.SRC_ATOP;
                    break;
                case 11:
                    blendMode = BlendMode.DST_ATOP;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    blendMode = BlendMode.XOR;
                    break;
                case 13:
                    blendMode = BlendMode.PLUS;
                    break;
                case 14:
                    blendMode = BlendMode.MODULATE;
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    blendMode = BlendMode.SCREEN;
                    break;
                case 16:
                    blendMode = BlendMode.OVERLAY;
                    break;
                case 17:
                    blendMode = BlendMode.DARKEN;
                    break;
                case 18:
                    blendMode = BlendMode.LIGHTEN;
                    break;
                case 19:
                    blendMode = BlendMode.COLOR_DODGE;
                    break;
                case 20:
                    blendMode = BlendMode.COLOR_BURN;
                    break;
                case 21:
                    blendMode = BlendMode.HARD_LIGHT;
                    break;
                case 22:
                    blendMode = BlendMode.SOFT_LIGHT;
                    break;
                case 23:
                    blendMode = BlendMode.DIFFERENCE;
                    break;
                case 24:
                    blendMode = BlendMode.EXCLUSION;
                    break;
                case 25:
                    blendMode = BlendMode.MULTIPLY;
                    break;
                case 26:
                    blendMode = BlendMode.HUE;
                    break;
                case 27:
                    blendMode = BlendMode.SATURATION;
                    break;
                case 28:
                    blendMode = BlendMode.COLOR;
                    break;
                case 29:
                    blendMode = BlendMode.LUMINOSITY;
                    break;
                default:
                    blendMode = null;
                    break;
            }
            if (blendMode != null) {
                colorFilter = new BlendModeColorFilter(0, blendMode);
            }
        } else {
            if (blendModeCompat != null) {
                switch (p.AnonymousClass1.f2379O000000o[blendModeCompat.ordinal()]) {
                    case 1:
                        mode = PorterDuff.Mode.CLEAR;
                        break;
                    case 2:
                        mode = PorterDuff.Mode.SRC;
                        break;
                    case 3:
                        mode = PorterDuff.Mode.DST;
                        break;
                    case 4:
                        mode = PorterDuff.Mode.SRC_OVER;
                        break;
                    case 5:
                        mode = PorterDuff.Mode.DST_OVER;
                        break;
                    case 6:
                        mode = PorterDuff.Mode.SRC_IN;
                        break;
                    case 7:
                        mode = PorterDuff.Mode.DST_IN;
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        mode = PorterDuff.Mode.SRC_OUT;
                        break;
                    case 9:
                        mode = PorterDuff.Mode.DST_OUT;
                        break;
                    case 10:
                        mode = PorterDuff.Mode.SRC_ATOP;
                        break;
                    case 11:
                        mode = PorterDuff.Mode.DST_ATOP;
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        mode = PorterDuff.Mode.XOR;
                        break;
                    case 13:
                        mode = PorterDuff.Mode.ADD;
                        break;
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.OVERLAY;
                        break;
                    case 17:
                        mode = PorterDuff.Mode.DARKEN;
                        break;
                    case 18:
                        mode = PorterDuff.Mode.LIGHTEN;
                        break;
                }
                if (mode != null) {
                    colorFilter = new PorterDuffColorFilter(0, mode);
                }
            }
            mode = null;
            if (mode != null) {
            }
        }
        mutate.setColorFilter(colorFilter);
    }

    public static void restoreWindowBackground(Window window) {
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private static void updateBackgroundFadeDuration(Window window, MaterialContainerTransform materialContainerTransform) {
        window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
    }
}
