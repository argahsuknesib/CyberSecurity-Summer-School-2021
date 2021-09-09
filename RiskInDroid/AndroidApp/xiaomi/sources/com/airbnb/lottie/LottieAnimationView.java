package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.xiaomi.smarthome.R;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    private int animationResId;
    private boolean autoPlay = false;
    private LottieComposition composition;
    private LottieTask<LottieComposition> compositionTask;
    private final LottieListener<Throwable> failureListener = new LottieListener<Throwable>() {
        /* class com.airbnb.lottie.LottieAnimationView.AnonymousClass2 */

        public void onResult(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    private final LottieListener<LottieComposition> loadedListener = new LottieListener<LottieComposition>() {
        /* class com.airbnb.lottie.LottieAnimationView.AnonymousClass1 */

        public void onResult(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    };
    private final LottieDrawable lottieDrawable = new LottieDrawable();
    private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
    private boolean useHardwareLayer = false;
    private boolean wasAnimatingWhenDetached = false;

    public LottieAnimationView(Context context) {
        super(context);
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.lottie_autoPlay, R.attr.lottie_colorFilter, R.attr.lottie_enableMergePathsForKitKatAndAbove, R.attr.lottie_fileName, R.attr.lottie_imageAssetsFolder, R.attr.lottie_loop, R.attr.lottie_progress, R.attr.lottie_rawRes, R.attr.lottie_repeatCount, R.attr.lottie_repeatMode, R.attr.lottie_scale, R.attr.lottie_url});
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(7);
            boolean hasValue2 = obtainStyledAttributes.hasValue(3);
            boolean hasValue3 = obtainStyledAttributes.hasValue(11);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            } else if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(7, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(11)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(0, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(5, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(9)) {
            setRepeatMode(obtainStyledAttributes.getInt(9, 1));
        }
        if (obtainStyledAttributes.hasValue(8)) {
            setRepeatCount(obtainStyledAttributes.getInt(8, -1));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(4));
        setProgress(obtainStyledAttributes.getFloat(6, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(2, false));
        if (obtainStyledAttributes.hasValue(1)) {
            addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback(new SimpleColorFilter(obtainStyledAttributes.getColor(1, 0))));
        }
        if (obtainStyledAttributes.hasValue(10)) {
            this.lottieDrawable.setScale(obtainStyledAttributes.getFloat(10, 1.0f));
        }
        obtainStyledAttributes.recycle();
        enableOrDisableHardwareLayer();
    }

    public void setImageResource(int i) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, true);
    }

    private void setImageDrawable(Drawable drawable, boolean z) {
        if (z && drawable != this.lottieDrawable) {
            recycleBitmaps();
        }
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        if (drawable2 == lottieDrawable2) {
            super.invalidateDrawable(lottieDrawable2);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        savedState.isAnimating = this.lottieDrawable.isAnimating();
        savedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        savedState.repeatMode = this.lottieDrawable.getRepeatMode();
        savedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.animationName;
        if (!TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.animationResId;
        int i = this.animationResId;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.setImagesAssetsFolder(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        recycleBitmaps();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public void recycleBitmaps() {
        this.lottieDrawable.recycleBitmaps();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration(boolean z) {
        useHardwareAcceleration(z);
    }

    public void useHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    public void useHardwareAcceleration(boolean z) {
        if (this.useHardwareLayer != z) {
            this.useHardwareLayer = z;
            enableOrDisableHardwareLayer();
        }
    }

    public boolean getUseHardwareAcceleration() {
        return this.useHardwareLayer;
    }

    public void setAnimation(int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(LottieCompositionFactory.fromRawRes(getContext(), i));
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(LottieCompositionFactory.fromAsset(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new JsonReader(new StringReader(str)), str2);
    }

    public void setAnimation(JsonReader jsonReader, String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonReader(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str));
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.failureListener);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.failureListener);
        }
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (L.DBG) {
            Log.v(TAG, "Set Composition \n".concat(String.valueOf(lottieComposition)));
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        boolean composition2 = this.lottieDrawable.setComposition(lottieComposition);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || composition2) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            requestLayout();
            for (LottieOnCompositionLoadedListener onCompositionLoaded : this.lottieOnCompositionLoadedListeners) {
                onCompositionLoaded.onCompositionLoaded(lottieComposition);
            }
        }
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void playAnimation() {
        this.lottieDrawable.playAnimation();
        enableOrDisableHardwareLayer();
    }

    public void resumeAnimation() {
        this.lottieDrawable.resumeAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public void setMaxProgress(float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.lottieDrawable.setMinAndMaxProgress(f, f2);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.lottieDrawable.setSpeed(f);
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.setImagesAssetsFolder(str);
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, t, lottieValueCallback);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, t, new LottieValueCallback<T>() {
            /* class com.airbnb.lottie.LottieAnimationView.AnonymousClass3 */

            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setScale(float f) {
        this.lottieDrawable.setScale(f);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null, false);
            setImageDrawable(this.lottieDrawable, false);
        }
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public void cancelAnimation() {
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void pauseAnimation() {
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int i) {
        this.lottieDrawable.setFrame(i);
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public void setProgress(float f) {
        this.lottieDrawable.setProgress(f);
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return (long) lottieComposition.getDuration();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    private void enableOrDisableHardwareLayer() {
        int i = 1;
        if (this.useHardwareLayer && this.lottieDrawable.isAnimating()) {
            i = 2;
        }
        setLayerType(i, null);
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.airbnb.lottie.LottieAnimationView.SavedState.AnonymousClass1 */

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() != 1 ? false : true;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }
}
