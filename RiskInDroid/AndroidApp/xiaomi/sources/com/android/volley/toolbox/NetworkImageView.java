package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

public class NetworkImageView extends ImageView {
    public int mDefaultImageId;
    public int mErrorImageId;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        this.mUrl = str;
        this.mImageLoader = imageLoader;
        loadImageIfNecessary(false);
    }

    public void setDefaultImageResId(int i) {
        this.mDefaultImageId = i;
    }

    public void setErrorImageResId(int i) {
        this.mErrorImageId = i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    public void loadImageIfNecessary(final boolean z) {
        boolean z2;
        boolean z3;
        int width = getWidth();
        int height = getHeight();
        boolean z4 = true;
        if (getLayoutParams() != null) {
            z3 = getLayoutParams().width == -2;
            if (getLayoutParams().height == -2) {
                z2 = true;
                if (!z3 || !z2) {
                    z4 = false;
                }
                if (width != 0 && height == 0 && !z4) {
                    return;
                }
                if (!TextUtils.isEmpty(this.mUrl)) {
                    ImageLoader.ImageContainer imageContainer = this.mImageContainer;
                    if (imageContainer != null) {
                        imageContainer.cancelRequest();
                        this.mImageContainer = null;
                    }
                    setDefaultImageOrNull();
                    return;
                }
                ImageLoader.ImageContainer imageContainer2 = this.mImageContainer;
                if (!(imageContainer2 == null || imageContainer2.getRequestUrl() == null)) {
                    if (!this.mImageContainer.getRequestUrl().equals(this.mUrl)) {
                        this.mImageContainer.cancelRequest();
                        setDefaultImageOrNull();
                    } else {
                        return;
                    }
                }
                if (z3) {
                    width = 0;
                }
                if (z2) {
                    height = 0;
                }
                this.mImageContainer = this.mImageLoader.get(this.mUrl, new ImageLoader.ImageListener() {
                    /* class com.android.volley.toolbox.NetworkImageView.AnonymousClass1 */

                    public void onErrorResponse(VolleyError volleyError) {
                        if (NetworkImageView.this.mErrorImageId != 0) {
                            NetworkImageView networkImageView = NetworkImageView.this;
                            networkImageView.setImageResource(networkImageView.mErrorImageId);
                        }
                    }

                    public void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
                        if (z && z) {
                            NetworkImageView.this.post(new Runnable() {
                                /* class com.android.volley.toolbox.NetworkImageView.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    AnonymousClass1.this.onResponse(imageContainer, false);
                                }
                            });
                        } else if (imageContainer.getBitmap() != null) {
                            NetworkImageView.this.setImageBitmap(imageContainer.getBitmap());
                        } else if (NetworkImageView.this.mDefaultImageId != 0) {
                            NetworkImageView networkImageView = NetworkImageView.this;
                            networkImageView.setImageResource(networkImageView.mDefaultImageId);
                        }
                    }
                }, width, height);
                return;
            }
        } else {
            z3 = false;
        }
        z2 = false;
        z4 = false;
        if (width != 0) {
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
        }
    }

    private void setDefaultImageOrNull() {
        int i = this.mDefaultImageId;
        if (i != 0) {
            setImageResource(i);
        } else {
            setImageBitmap(null);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        loadImageIfNecessary(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.mImageContainer;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap(null);
            this.mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
