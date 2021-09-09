package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.xiaomi.smarthome.R;

public class ProfilePictureView extends FrameLayout {
    public static final String TAG = "ProfilePictureView";
    private Bitmap customizedDefaultProfilePicture = null;
    private ImageView image;
    private Bitmap imageContents;
    private boolean isCropped = true;
    private ImageRequest lastRequest;
    private OnErrorListener onErrorListener;
    private int presetSizeType = -1;
    private String profileId;
    private int queryHeight = 0;
    private int queryWidth = 0;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public ProfilePictureView(Context context) {
        super(context);
        initialize(context);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
        parseAttributes(attributeSet);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
        parseAttributes(attributeSet);
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final void setPresetSize(int i) {
        if (i == -4 || i == -3 || i == -2 || i == -1) {
            this.presetSizeType = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public final void setCropped(boolean z) {
        this.isCropped = z;
        refreshImage(false);
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final void setProfileId(String str) {
        boolean z;
        if (Utility.isNullOrEmpty(this.profileId) || !this.profileId.equalsIgnoreCase(str)) {
            setBlankProfilePicture();
            z = true;
        } else {
            z = false;
        }
        this.profileId = str;
        refreshImage(z);
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i2) == 1073741824 || layoutParams.height != -2) {
            z = false;
        } else {
            size = getPresetSizeInPixels(true);
            i2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z = true;
        }
        if (View.MeasureSpec.getMode(i) != 1073741824 && layoutParams.width == -2) {
            size2 = getPresetSizeInPixels(true);
            i = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            z = true;
        }
        if (z) {
            setMeasuredDimension(size2, size);
            measureChildren(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        refreshImage(false);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ProfilePictureView_superState", onSaveInstanceState);
        bundle.putString("ProfilePictureView_profileId", this.profileId);
        bundle.putInt("ProfilePictureView_presetSize", this.presetSizeType);
        bundle.putBoolean("ProfilePictureView_isCropped", this.isCropped);
        bundle.putInt("ProfilePictureView_width", this.queryWidth);
        bundle.putInt("ProfilePictureView_height", this.queryHeight);
        bundle.putBoolean("ProfilePictureView_refresh", this.lastRequest != null);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("ProfilePictureView_superState"));
        this.profileId = bundle.getString("ProfilePictureView_profileId");
        this.presetSizeType = bundle.getInt("ProfilePictureView_presetSize");
        this.isCropped = bundle.getBoolean("ProfilePictureView_isCropped");
        this.queryWidth = bundle.getInt("ProfilePictureView_width");
        this.queryHeight = bundle.getInt("ProfilePictureView_height");
        refreshImage(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    private void initialize(Context context) {
        removeAllViews();
        this.image = new ImageView(context);
        this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.image);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.com_facebook_is_cropped, R.attr.com_facebook_preset_size});
        setPresetSize(obtainStyledAttributes.getInt(1, -1));
        this.isCropped = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    private void refreshImage(boolean z) {
        boolean updateImageQueryParameters = updateImageQueryParameters();
        String str = this.profileId;
        if (str == null || str.length() == 0 || (this.queryWidth == 0 && this.queryHeight == 0)) {
            setBlankProfilePicture();
        } else if (updateImageQueryParameters || z) {
            sendImageRequest(true);
        }
    }

    private void setBlankProfilePicture() {
        ImageRequest imageRequest = this.lastRequest;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        if (this.customizedDefaultProfilePicture == null) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), isCropped() ? R.drawable.com_facebook_profile_picture_blank_square : R.drawable.com_facebook_profile_picture_blank_portrait));
            return;
        }
        updateImageQueryParameters();
        setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
    }

    private void setImageBitmap(Bitmap bitmap) {
        ImageView imageView = this.image;
        if (imageView != null && bitmap != null) {
            this.imageContents = bitmap;
            imageView.setImageBitmap(bitmap);
        }
    }

    private void sendImageRequest(boolean z) {
        ImageRequest build = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight, AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : "")).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new ImageRequest.Callback() {
            /* class com.facebook.login.widget.ProfilePictureView.AnonymousClass1 */

            public void onCompleted(ImageResponse imageResponse) {
                ProfilePictureView.this.processResponse(imageResponse);
            }
        }).build();
        ImageRequest imageRequest = this.lastRequest;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        this.lastRequest = build;
        ImageDownloader.downloadAsync(build);
    }

    public void processResponse(ImageResponse imageResponse) {
        if (imageResponse.getRequest() == this.lastRequest) {
            this.lastRequest = null;
            Bitmap bitmap = imageResponse.getBitmap();
            Exception error = imageResponse.getError();
            if (error != null) {
                OnErrorListener onErrorListener2 = this.onErrorListener;
                if (onErrorListener2 != null) {
                    onErrorListener2.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), error));
                    return;
                }
                Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
            } else if (bitmap != null) {
                setImageBitmap(bitmap);
                if (imageResponse.isCachedRedirect()) {
                    sendImageRequest(false);
                }
            }
        }
    }

    private boolean updateImageQueryParameters() {
        int height = getHeight();
        int width = getWidth();
        boolean z = false;
        if (width > 0 && height > 0) {
            int presetSizeInPixels = getPresetSizeInPixels(false);
            if (presetSizeInPixels != 0) {
                height = presetSizeInPixels;
                width = height;
            }
            if (width <= height) {
                height = isCropped() ? width : 0;
            } else {
                width = isCropped() ? height : 0;
            }
            if (!(width == this.queryWidth && height == this.queryHeight)) {
                z = true;
            }
            this.queryWidth = width;
            this.queryHeight = height;
        }
        return z;
    }

    private int getPresetSizeInPixels(boolean z) {
        int i = this.presetSizeType;
        int i2 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        if (i == -4) {
            i2 = R.dimen.com_facebook_profilepictureview_preset_size_large;
        } else if (i != -3) {
            if (i == -2) {
                i2 = R.dimen.com_facebook_profilepictureview_preset_size_small;
            } else if (i != -1 || !z) {
                return 0;
            }
        }
        return getResources().getDimensionPixelSize(i2);
    }
}
