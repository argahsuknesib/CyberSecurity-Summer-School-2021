package com.google.android.material.transition.platform;

import _m_j.bf;
import _m_j.cb;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.transition.platform.TransitionUtils;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialContainerTransform extends Transition {
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    private static final String TAG = "MaterialContainerTransform";
    private static final String[] TRANSITION_PROPS = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    private int containerColor = 0;
    private boolean drawDebugEnabled = false;
    private int drawingViewId = 16908290;
    private boolean elevationShadowEnabled;
    private int endContainerColor = 0;
    private float endElevation;
    private ShapeAppearanceModel endShapeAppearanceModel;
    private View endView;
    private int endViewId = -1;
    private int fadeMode = 0;
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode = 0;
    public boolean holdAtEndEnabled = false;
    private ProgressThresholds scaleMaskProgressThresholds;
    private ProgressThresholds scaleProgressThresholds;
    private int scrimColor = 1375731712;
    private ProgressThresholds shapeMaskProgressThresholds;
    private int startContainerColor = 0;
    private float startElevation;
    private ShapeAppearanceModel startShapeAppearanceModel;
    private View startView;
    private int startViewId = -1;
    private int transitionDirection = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    public MaterialContainerTransform() {
        boolean z = false;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28 ? true : z;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public final int getStartViewId() {
        return this.startViewId;
    }

    public final void setStartViewId(int i) {
        this.startViewId = i;
    }

    public final int getEndViewId() {
        return this.endViewId;
    }

    public final void setEndViewId(int i) {
        this.endViewId = i;
    }

    public final View getStartView() {
        return this.startView;
    }

    public final void setStartView(View view) {
        this.startView = view;
    }

    public final View getEndView() {
        return this.endView;
    }

    public final void setEndView(View view) {
        this.endView = view;
    }

    public final ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    public final void setStartShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.startShapeAppearanceModel = shapeAppearanceModel;
    }

    public final ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    public final void setEndShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.endShapeAppearanceModel = shapeAppearanceModel;
    }

    public final boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public final void setElevationShadowEnabled(boolean z) {
        this.elevationShadowEnabled = z;
    }

    public final float getStartElevation() {
        return this.startElevation;
    }

    public final void setStartElevation(float f) {
        this.startElevation = f;
    }

    public final float getEndElevation() {
        return this.endElevation;
    }

    public final void setEndElevation(float f) {
        this.endElevation = f;
    }

    public final int getDrawingViewId() {
        return this.drawingViewId;
    }

    public final void setDrawingViewId(int i) {
        this.drawingViewId = i;
    }

    public final int getContainerColor() {
        return this.containerColor;
    }

    public final void setContainerColor(int i) {
        this.containerColor = i;
    }

    public final int getStartContainerColor() {
        return this.startContainerColor;
    }

    public final void setStartContainerColor(int i) {
        this.startContainerColor = i;
    }

    public final int getEndContainerColor() {
        return this.endContainerColor;
    }

    public final void setEndContainerColor(int i) {
        this.endContainerColor = i;
    }

    public final void setAllContainerColors(int i) {
        this.containerColor = i;
        this.startContainerColor = i;
        this.endContainerColor = i;
    }

    public final int getScrimColor() {
        return this.scrimColor;
    }

    public final void setScrimColor(int i) {
        this.scrimColor = i;
    }

    public final int getTransitionDirection() {
        return this.transitionDirection;
    }

    public final void setTransitionDirection(int i) {
        this.transitionDirection = i;
    }

    public final int getFadeMode() {
        return this.fadeMode;
    }

    public final void setFadeMode(int i) {
        this.fadeMode = i;
    }

    public final int getFitMode() {
        return this.fitMode;
    }

    public final void setFitMode(int i) {
        this.fitMode = i;
    }

    public final ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public final void setFadeProgressThresholds(ProgressThresholds progressThresholds) {
        this.fadeProgressThresholds = progressThresholds;
    }

    public final ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    public final void setScaleProgressThresholds(ProgressThresholds progressThresholds) {
        this.scaleProgressThresholds = progressThresholds;
    }

    public final ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    public final void setScaleMaskProgressThresholds(ProgressThresholds progressThresholds) {
        this.scaleMaskProgressThresholds = progressThresholds;
    }

    public final ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    public final void setShapeMaskProgressThresholds(ProgressThresholds progressThresholds) {
        this.shapeMaskProgressThresholds = progressThresholds;
    }

    public final boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public final void setHoldAtEndEnabled(boolean z) {
        this.holdAtEndEnabled = z;
    }

    public final boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public final void setDrawDebugEnabled(boolean z) {
        this.drawDebugEnabled = z;
    }

    public final String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    private static void captureValues(TransitionValues transitionValues, View view, int i, ShapeAppearanceModel shapeAppearanceModel) {
        if (i != -1) {
            transitionValues.view = TransitionUtils.findDescendantOrAncestorById(transitionValues.view, i);
        } else if (view != null) {
            transitionValues.view = view;
        } else if (transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view) instanceof View) {
            transitionValues.view.setTag(R.id.mtrl_motion_snapshot_view, null);
            transitionValues.view = (View) transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view);
        }
        View view2 = transitionValues.view;
        if (cb.O000O0oO(view2) || view2.getWidth() != 0 || view2.getHeight() != 0) {
            RectF relativeBounds = view2.getParent() == null ? TransitionUtils.getRelativeBounds(view2) : TransitionUtils.getLocationOnScreen(view2);
            transitionValues.values.put("materialContainerTransition:bounds", relativeBounds);
            transitionValues.values.put("materialContainerTransition:shapeAppearance", captureShapeAppearance(view2, relativeBounds, shapeAppearanceModel));
        }
    }

    private static ShapeAppearanceModel captureShapeAppearance(View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel) {
        return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(view, shapeAppearanceModel), rectF);
    }

    private static ShapeAppearanceModel getShapeAppearance(View view, ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        if (view.getTag(R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(R.id.mtrl_motion_snapshot_view);
        }
        Context context = view.getContext();
        int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
        if (transitionShapeAppearanceResId != -1) {
            return ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build();
        }
        if (view instanceof Shapeable) {
            return ((Shapeable) view).getShapeAppearanceModel();
        }
        return ShapeAppearanceModel.builder().build();
    }

    private static int getTransitionShapeAppearanceResId(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        final View view;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (!(transitionValues3 == null || transitionValues4 == null)) {
            RectF rectF = (RectF) transitionValues3.values.get("materialContainerTransition:bounds");
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues3.values.get("materialContainerTransition:shapeAppearance");
            if (rectF == null || shapeAppearanceModel == null) {
                Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
            } else {
                RectF rectF2 = (RectF) transitionValues4.values.get("materialContainerTransition:bounds");
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues4.values.get("materialContainerTransition:shapeAppearance");
                if (rectF2 == null || shapeAppearanceModel2 == null) {
                    Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                final View view2 = transitionValues3.view;
                final View view3 = transitionValues4.view;
                View view4 = view3.getParent() != null ? view3 : view2;
                if (this.drawingViewId == view4.getId()) {
                    view = (View) view4.getParent();
                } else {
                    view = TransitionUtils.findAncestorById(view4, this.drawingViewId);
                    view4 = null;
                }
                RectF locationOnScreen = TransitionUtils.getLocationOnScreen(view);
                float f = -locationOnScreen.left;
                float f2 = -locationOnScreen.top;
                RectF calculateDrawableBounds = calculateDrawableBounds(view, view4, f, f2);
                rectF.offset(f, f2);
                rectF2.offset(f, f2);
                boolean isEntering = isEntering(rectF, rectF2);
                final TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view2, rectF, shapeAppearanceModel, getElevationOrDefault(this.startElevation, view2), view3, rectF2, shapeAppearanceModel2, getElevationOrDefault(this.endElevation, view3), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, isEntering, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, isEntering), FitModeEvaluators.get(this.fitMode, isEntering, rectF, rectF2), buildThresholdsGroup(isEntering), this.drawDebugEnabled);
                transitionDrawable.setBounds(Math.round(calculateDrawableBounds.left), Math.round(calculateDrawableBounds.top), Math.round(calculateDrawableBounds.right), Math.round(calculateDrawableBounds.bottom));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.google.android.material.transition.platform.MaterialContainerTransform.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        transitionDrawable.setProgress(valueAnimator.getAnimatedFraction());
                    }
                });
                addListener(new TransitionListenerAdapter() {
                    /* class com.google.android.material.transition.platform.MaterialContainerTransform.AnonymousClass2 */

                    public void onTransitionStart(Transition transition) {
                        ViewUtils.getOverlay(view).add(transitionDrawable);
                        view2.setAlpha(0.0f);
                        view3.setAlpha(0.0f);
                    }

                    public void onTransitionEnd(Transition transition) {
                        MaterialContainerTransform.this.removeListener(this);
                        if (!MaterialContainerTransform.this.holdAtEndEnabled) {
                            view2.setAlpha(1.0f);
                            view3.setAlpha(1.0f);
                            ViewUtils.getOverlay(view).remove(transitionDrawable);
                        }
                    }
                });
                return ofFloat;
            }
        }
        return null;
    }

    private static float getElevationOrDefault(float f, View view) {
        return f != -1.0f ? f : cb.O0000oOO(view);
    }

    private static RectF calculateDrawableBounds(View view, View view2, float f, float f2) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        }
        RectF locationOnScreen = TransitionUtils.getLocationOnScreen(view2);
        locationOnScreen.offset(f, f2);
        return locationOnScreen;
    }

    private boolean isEntering(RectF rectF, RectF rectF2) {
        int i = this.transitionDirection;
        if (i == 0) {
            return TransitionUtils.calculateArea(rectF2) > TransitionUtils.calculateArea(rectF);
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean z) {
        PathMotion pathMotion = getPathMotion();
        if ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) {
            return getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
        }
        return getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean z, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, progressThresholdsGroup.fade), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, progressThresholdsGroup.scale), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, progressThresholdsGroup.scaleMask), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, progressThresholdsGroup.shapeMask));
    }

    static final class TransitionDrawable extends Drawable {
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final RectF endBounds;
        private final Paint endContainerPaint;
        private final float endElevation;
        private final ShapeAppearanceModel endShapeAppearanceModel;
        public final View endView;
        private final boolean entering;
        private final FadeModeEvaluator fadeModeEvaluator;
        private FadeModeResult fadeModeResult;
        private final FitModeEvaluator fitModeEvaluator;
        private FitModeResult fitModeResult;
        private final MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final ProgressThresholdsGroup progressThresholds;
        private final Paint scrimPaint;
        private final Paint shadowPaint;
        private final RectF startBounds;
        private final Paint startContainerPaint;
        private final float startElevation;
        private final ShapeAppearanceModel startShapeAppearanceModel;
        public final View startView;

        public final int getOpacity() {
            return -3;
        }

        private TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z, boolean z2, FadeModeEvaluator fadeModeEvaluator2, FitModeEvaluator fitModeEvaluator2, ProgressThresholdsGroup progressThresholdsGroup, boolean z3) {
            RectF rectF3 = rectF;
            this.containerPaint = new Paint();
            this.startContainerPaint = new Paint();
            this.endContainerPaint = new Paint();
            this.shadowPaint = new Paint();
            this.scrimPaint = new Paint();
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[2];
            this.compatShadowDrawable = new MaterialShapeDrawable();
            this.debugPaint = new Paint();
            this.debugPath = new Path();
            this.startView = view;
            this.startBounds = rectF3;
            this.startShapeAppearanceModel = shapeAppearanceModel;
            this.startElevation = f;
            this.endView = view2;
            this.endBounds = rectF2;
            this.endShapeAppearanceModel = shapeAppearanceModel2;
            this.endElevation = f2;
            this.entering = z;
            this.elevationShadowEnabled = z2;
            this.fadeModeEvaluator = fadeModeEvaluator2;
            this.fitModeEvaluator = fitModeEvaluator2;
            this.progressThresholds = progressThresholdsGroup;
            this.drawDebugEnabled = z3;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.displayWidth = (float) displayMetrics.widthPixels;
            this.displayHeight = (float) displayMetrics.heightPixels;
            this.containerPaint.setColor(i);
            this.startContainerPaint.setColor(i2);
            this.endContainerPaint.setColor(i3);
            this.compatShadowDrawable.setFillColor(ColorStateList.valueOf(0));
            this.compatShadowDrawable.setShadowCompatibilityMode(2);
            this.compatShadowDrawable.setShadowBitmapDrawingEnable(false);
            this.compatShadowDrawable.setShadowColor(-7829368);
            this.currentStartBounds = new RectF(rectF);
            this.currentStartBoundsMasked = new RectF(this.currentStartBounds);
            this.currentEndBounds = new RectF(this.currentStartBounds);
            this.currentEndBoundsMasked = new RectF(this.currentEndBounds);
            PointF motionPathPoint = getMotionPathPoint(rectF);
            PointF motionPathPoint2 = getMotionPathPoint(rectF2);
            this.motionPathMeasure = new PathMeasure(pathMotion.getPath(motionPathPoint.x, motionPathPoint.y, motionPathPoint2.x, motionPathPoint2.y), false);
            this.motionPathLength = this.motionPathMeasure.getLength();
            this.motionPathPosition[0] = rectF.centerX();
            this.motionPathPosition[1] = rectF3.top;
            this.scrimPaint.setStyle(Paint.Style.FILL);
            this.scrimPaint.setShader(TransitionUtils.createColorShader(i4));
            this.debugPaint.setStyle(Paint.Style.STROKE);
            this.debugPaint.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        public final void draw(Canvas canvas) {
            if (this.scrimPaint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.scrimPaint);
            }
            int save = this.drawDebugEnabled ? canvas.save() : -1;
            if (this.elevationShadowEnabled && this.currentElevation > 0.0f) {
                drawElevationShadow(canvas);
            }
            this.maskEvaluator.clip(canvas);
            maybeDrawContainerColor(canvas, this.containerPaint);
            if (this.fadeModeResult.endOnTop) {
                drawStartView(canvas);
                drawEndView(canvas);
            } else {
                drawEndView(canvas);
                drawStartView(canvas);
            }
            if (this.drawDebugEnabled) {
                canvas.restoreToCount(save);
                drawDebugCumulativePath(canvas, this.currentStartBounds, this.debugPath, -65281);
                drawDebugRect(canvas, this.currentStartBoundsMasked, -256);
                drawDebugRect(canvas, this.currentStartBounds, -16711936);
                drawDebugRect(canvas, this.currentEndBoundsMasked, -16711681);
                drawDebugRect(canvas, this.currentEndBounds, -16776961);
            }
        }

        private void drawElevationShadow(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                drawElevationShadowWithPaintShadowLayer(canvas);
            } else {
                drawElevationShadowWithMaterialShapeDrawable(canvas);
            }
            canvas.restore();
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas canvas) {
            ShapeAppearanceModel currentShapeAppearanceModel = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if (currentShapeAppearanceModel.isRoundRect(this.currentMaskBounds)) {
                float cornerSize = currentShapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
                canvas.drawRoundRect(this.currentMaskBounds, cornerSize, cornerSize, this.shadowPaint);
                return;
            }
            canvas.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas canvas) {
            this.compatShadowDrawable.setBounds((int) this.currentMaskBounds.left, (int) this.currentMaskBounds.top, (int) this.currentMaskBounds.right, (int) this.currentMaskBounds.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(canvas);
        }

        private void drawStartView(Canvas canvas) {
            maybeDrawContainerColor(canvas, this.startContainerPaint);
            TransitionUtils.transform(canvas, getBounds(), this.currentStartBounds.left, this.currentStartBounds.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new TransitionUtils.CanvasOperation() {
                /* class com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.AnonymousClass1 */

                public void run(Canvas canvas) {
                    TransitionDrawable.this.startView.draw(canvas);
                }
            });
        }

        private void drawEndView(Canvas canvas) {
            maybeDrawContainerColor(canvas, this.endContainerPaint);
            TransitionUtils.transform(canvas, getBounds(), this.currentEndBounds.left, this.currentEndBounds.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new TransitionUtils.CanvasOperation() {
                /* class com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.AnonymousClass2 */

                public void run(Canvas canvas) {
                    TransitionDrawable.this.endView.draw(canvas);
                }
            });
        }

        private void maybeDrawContainerColor(Canvas canvas, Paint paint) {
            if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
        }

        public final void setAlpha(int i) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        public final void setProgress(float f) {
            if (this.progress != f) {
                updateProgress(f);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.material.transition.platform.TransitionUtils.lerp(float, float, float, float, float):float
         arg types: [int, int, float, float, float]
         candidates:
          com.google.android.material.transition.platform.TransitionUtils.lerp(int, int, float, float, float):int
          com.google.android.material.transition.platform.TransitionUtils.lerp(float, float, float, float, float):float */
        private void updateProgress(float f) {
            float f2;
            this.progress = f;
            this.scrimPaint.setAlpha((int) (this.entering ? TransitionUtils.lerp(0.0f, 255.0f, f) : TransitionUtils.lerp(255.0f, 0.0f, f)));
            this.motionPathMeasure.getPosTan(this.motionPathLength * f, this.motionPathPosition, null);
            float[] fArr = this.motionPathPosition;
            float f3 = fArr[0];
            float f4 = fArr[1];
            if (f > 1.0f || f < 0.0f) {
                float f5 = 0.01f;
                if (f > 1.0f) {
                    f5 = 0.99f;
                    f2 = (f - 1.0f) / 0.00999999f;
                } else {
                    f2 = (f / 0.01f) * -1.0f;
                }
                this.motionPathMeasure.getPosTan(this.motionPathLength * f5, this.motionPathPosition, null);
                float[] fArr2 = this.motionPathPosition;
                f3 += (f3 - fArr2[0]) * f2;
                f4 += (f4 - fArr2[1]) * f2;
            }
            float f6 = f4;
            float f7 = f3;
            this.fitModeResult = this.fitModeEvaluator.evaluate(f, ((Float) bf.O000000o(Float.valueOf(this.progressThresholds.scale.start))).floatValue(), ((Float) bf.O000000o(Float.valueOf(this.progressThresholds.scale.end))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.currentStartBounds.set(f7 - (this.fitModeResult.currentStartWidth / 2.0f), f6, (this.fitModeResult.currentStartWidth / 2.0f) + f7, this.fitModeResult.currentStartHeight + f6);
            this.currentEndBounds.set(f7 - (this.fitModeResult.currentEndWidth / 2.0f), f6, f7 + (this.fitModeResult.currentEndWidth / 2.0f), this.fitModeResult.currentEndHeight + f6);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float floatValue = ((Float) bf.O000000o(Float.valueOf(this.progressThresholds.scaleMask.start))).floatValue();
            float floatValue2 = ((Float) bf.O000000o(Float.valueOf(this.progressThresholds.scaleMask.end))).floatValue();
            boolean shouldMaskStartBounds = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            RectF rectF = shouldMaskStartBounds ? this.currentStartBoundsMasked : this.currentEndBoundsMasked;
            float lerp = TransitionUtils.lerp(0.0f, 1.0f, floatValue, floatValue2, f);
            if (!shouldMaskStartBounds) {
                lerp = 1.0f - lerp;
            }
            this.fitModeEvaluator.applyMask(rectF, lerp, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(f, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, this.progressThresholds.shapeMask);
            this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, f);
            float calculateElevationDxMultiplier = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            float calculateElevationDyMultiplier = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            float f8 = this.currentElevation;
            this.currentElevationDy = (float) ((int) (calculateElevationDyMultiplier * f8));
            this.shadowPaint.setShadowLayer(f8, (float) ((int) (calculateElevationDxMultiplier * f8)), this.currentElevationDy, 754974720);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(f, ((Float) bf.O000000o(Float.valueOf(this.progressThresholds.fade.start))).floatValue(), ((Float) bf.O000000o(Float.valueOf(this.progressThresholds.fade.end))).floatValue());
            if (this.startContainerPaint.getColor() != 0) {
                this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
            }
            if (this.endContainerPaint.getColor() != 0) {
                this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
            }
            invalidateSelf();
        }

        private static PointF getMotionPathPoint(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private static float calculateElevationDxMultiplier(RectF rectF, float f) {
            return ((rectF.centerX() / (f / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float calculateElevationDyMultiplier(RectF rectF, float f) {
            return (rectF.centerY() / f) * 1.5f;
        }

        private void drawDebugCumulativePath(Canvas canvas, RectF rectF, Path path, int i) {
            PointF motionPathPoint = getMotionPathPoint(rectF);
            if (this.progress == 0.0f) {
                path.reset();
                path.moveTo(motionPathPoint.x, motionPathPoint.y);
                return;
            }
            path.lineTo(motionPathPoint.x, motionPathPoint.y);
            this.debugPaint.setColor(i);
            canvas.drawPath(path, this.debugPaint);
        }

        private void drawDebugRect(Canvas canvas, RectF rectF, int i) {
            this.debugPaint.setColor(i);
            canvas.drawRect(rectF, this.debugPaint);
        }
    }

    public static class ProgressThresholds {
        public final float end;
        public final float start;

        public ProgressThresholds(float f, float f2) {
            this.start = f;
            this.end = f2;
        }

        public float getStart() {
            return this.start;
        }

        public float getEnd() {
            return this.end;
        }
    }

    static class ProgressThresholdsGroup {
        public final ProgressThresholds fade;
        public final ProgressThresholds scale;
        public final ProgressThresholds scaleMask;
        public final ProgressThresholds shapeMask;

        private ProgressThresholdsGroup(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.fade = progressThresholds;
            this.scale = progressThresholds2;
            this.scaleMask = progressThresholds3;
            this.shapeMask = progressThresholds4;
        }
    }
}
