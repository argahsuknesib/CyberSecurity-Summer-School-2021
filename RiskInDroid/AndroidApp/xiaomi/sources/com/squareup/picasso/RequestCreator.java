package com.squareup.picasso;

import _m_j.dvt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.squareup.picasso.Target;
import com.xiaomi.image.ImageLoaderOptions;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class RequestCreator {
    private boolean asBitmap;
    private final Context context;
    private final Request.Builder data;
    private boolean deferred;
    private Drawable errorDrawable;
    private int errorResId;
    private int memoryPolicy;
    private int networkPolicy;
    private boolean noFade;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private float rotationDegrees;
    private boolean setPlaceholder = true;
    final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator = new WeakHashMap();
    private String url;

    public RequestCreator(String str, Context context2) {
        this.url = str;
        this.context = context2;
        this.data = new Request.Builder(null, 0, null);
    }

    public void into(ImageView imageView) {
        into(imageView, null);
    }

    public void into(ImageView imageView, Callback callback) {
        ImageLoaderOptions createImageLoaderOptions = createImageLoaderOptions(imageView);
        if (createImageLoaderOptions != null) {
            dvt.O000000o().O000000o(createImageLoaderOptions, 2);
        }
    }

    public void into(Target target) {
        createImageLoaderOptions(null);
        dvt O000000o2 = dvt.O000000o();
        String str = this.url;
        Context context2 = this.context;
        if (!TextUtils.isEmpty(str)) {
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), context2).subscribe(new BaseBitmapDataSubscriber(target) {
                /* class _m_j.dvt.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Target f14982O000000o;

                {
                    this.f14982O000000o = r2;
                }

                public final void onNewResultImpl(final Bitmap bitmap) {
                    if (bitmap != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class _m_j.dvt.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                Bitmap bitmap = bitmap;
                                Bitmap copy = bitmap.copy(bitmap.getConfig(), bitmap.isMutable());
                                if (copy == null || copy.isRecycled()) {
                                    AnonymousClass2.this.f14982O000000o.onBitmapLoaded(null, null);
                                } else {
                                    AnonymousClass2.this.f14982O000000o.onBitmapLoaded(copy, null);
                                }
                            }
                        });
                    }
                }

                public final void onFailureImpl(final DataSource dataSource) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class _m_j.dvt.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            AnonymousClass2.this.f14982O000000o.onBitmapFailed(new Exception(dataSource.getFailureCause().getMessage()), null);
                        }
                    });
                }
            }, CallerThreadExecutor.getInstance());
        }
    }

    public RequestCreator noPlaceholder() {
        if (this.placeholderResId != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        } else if (this.placeholderDrawable == null) {
            this.setPlaceholder = false;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator placeholder(int i) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.placeholderDrawable == null) {
            this.placeholderResId = i;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator placeholder(Drawable drawable) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.placeholderResId == 0) {
            this.placeholderDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator error(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.errorDrawable == null) {
            this.errorResId = i;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public RequestCreator error(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        } else if (this.errorResId == 0) {
            this.errorDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public RequestCreator centerCrop() {
        this.data.centerCrop();
        return this;
    }

    public RequestCreator centerCrop(int i) {
        this.data.centerCrop();
        return this;
    }

    public RequestCreator centerInside() {
        this.data.centerInside();
        return this;
    }

    public RequestCreator onlyScaleDown() {
        this.data.onlyScaleDown();
        return this;
    }

    public RequestCreator transform(Transformation transformation) {
        this.data.transform(transformation);
        return this;
    }

    public RequestCreator transform(List<? extends Transformation> list) {
        this.data.transform(list);
        return this;
    }

    public RequestCreator priority(Picasso.Priority priority) {
        this.data.priority(priority);
        return this;
    }

    public RequestCreator asBitmap() {
        this.asBitmap = true;
        return this;
    }

    public RequestCreator memoryPolicy(MemoryPolicy memoryPolicy2, MemoryPolicy... memoryPolicyArr) {
        if (memoryPolicy2 != null) {
            this.memoryPolicy = memoryPolicy2.index | this.memoryPolicy;
            if (memoryPolicyArr != null) {
                if (memoryPolicyArr.length > 0) {
                    int length = memoryPolicyArr.length;
                    int i = 0;
                    while (i < length) {
                        MemoryPolicy memoryPolicy3 = memoryPolicyArr[i];
                        if (memoryPolicy3 != null) {
                            this.memoryPolicy = memoryPolicy3.index | this.memoryPolicy;
                            i++;
                        } else {
                            throw new IllegalArgumentException("Memory policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        throw new IllegalArgumentException("Memory policy cannot be null.");
    }

    public RequestCreator networkPolicy(NetworkPolicy networkPolicy2, NetworkPolicy... networkPolicyArr) {
        if (networkPolicy2 != null) {
            this.networkPolicy = networkPolicy2.index | this.networkPolicy;
            if (networkPolicyArr != null) {
                if (networkPolicyArr.length > 0) {
                    int length = networkPolicyArr.length;
                    int i = 0;
                    while (i < length) {
                        NetworkPolicy networkPolicy3 = networkPolicyArr[i];
                        if (networkPolicy3 != null) {
                            this.networkPolicy = networkPolicy3.index | this.networkPolicy;
                            i++;
                        } else {
                            throw new IllegalArgumentException("Network policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Network policy cannot be null.");
        }
        throw new IllegalArgumentException("Network policy cannot be null.");
    }

    public RequestCreator resizeDimen(int i, int i2) {
        Resources resources = this.context.getResources();
        return resize(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i2));
    }

    public RequestCreator resize(int i, int i2) {
        this.data.resize(i, i2);
        return this;
    }

    public RequestCreator noFade() {
        this.noFade = true;
        return this;
    }

    public RequestCreator fit() {
        this.deferred = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RequestCreator unfit() {
        this.deferred = false;
        return this;
    }

    public RequestCreator rotate(float f) {
        this.rotationDegrees = f;
        return this;
    }

    private ImageLoaderOptions createImageLoaderOptions(ImageView imageView) {
        ImageLoaderOptions imageLoaderOptions = new ImageLoaderOptions(imageView, this.url);
        Request build = this.data.build();
        int i = this.placeholderResId;
        if (i <= 0 || !this.setPlaceholder) {
            Drawable drawable = this.placeholderDrawable;
            if (drawable != null && this.setPlaceholder) {
                imageLoaderOptions.O00000oo = drawable;
            }
        } else {
            imageLoaderOptions.O00000oO = i;
        }
        int i2 = this.errorResId;
        if (i2 > 0) {
            imageLoaderOptions.O0000OOo = i2;
        } else {
            Drawable drawable2 = this.errorDrawable;
            if (drawable2 != null) {
                imageLoaderOptions.O0000Oo0 = drawable2;
            }
        }
        if (build.targetWidth > 0 && build.targetHeight > 0) {
            imageLoaderOptions.O000000o(build.targetWidth, build.targetHeight);
        }
        if (build.centerCrop) {
            imageLoaderOptions.O0000o0 = 2;
        } else if (build.centerInside) {
            imageLoaderOptions.O0000o0 = 4;
        }
        if (build.transformations != null && build.transformations.size() > 0) {
            imageLoaderOptions.O0000oO = build.transformations;
        }
        if (this.memoryPolicy == MemoryPolicy.NO_CACHE.index || this.memoryPolicy == MemoryPolicy.NO_STORE.index) {
            imageLoaderOptions.O0000o00 = ImageLoaderOptions.ImageLoaderDiskCacheStrategy.DISK;
        }
        if (this.networkPolicy == NetworkPolicy.NO_CACHE.index || this.networkPolicy == NetworkPolicy.NO_STORE.index) {
            imageLoaderOptions.O0000o00 = ImageLoaderOptions.ImageLoaderDiskCacheStrategy.MEMORY;
        }
        if ((this.memoryPolicy == MemoryPolicy.NO_CACHE.index || this.memoryPolicy == MemoryPolicy.NO_STORE.index) && (this.networkPolicy == NetworkPolicy.NO_CACHE.index || this.networkPolicy == NetworkPolicy.NO_STORE.index)) {
            imageLoaderOptions.O0000o00 = ImageLoaderOptions.ImageLoaderDiskCacheStrategy.NONE;
        }
        if (this.noFade) {
            imageLoaderOptions.O0000Ooo = false;
        }
        if (this.asBitmap) {
            imageLoaderOptions.O0000OoO = true;
        }
        if (this.deferred) {
            if (!this.data.hasSize()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width == 0 || height == 0) {
                    if (this.setPlaceholder) {
                        imageView.setImageDrawable(getPlaceholderDrawable());
                    }
                    defer(imageView, new DeferredRequestCreator(this, imageView, null));
                    return imageLoaderOptions;
                }
                imageLoaderOptions.O000000o(width, height);
            } else {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
        }
        return imageLoaderOptions;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [int, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    private Drawable getPlaceholderDrawable() {
        if (this.placeholderResId == 0) {
            return this.placeholderDrawable;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return this.context.getDrawable(this.placeholderResId);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return this.context.getResources().getDrawable(this.placeholderResId);
        }
        TypedValue typedValue = new TypedValue();
        this.context.getResources().getValue(this.placeholderResId, typedValue, true);
        return this.context.getResources().getDrawable(typedValue.resourceId);
    }

    /* access modifiers changed from: package-private */
    public void defer(ImageView imageView, DeferredRequestCreator deferredRequestCreator) {
        if (this.targetToDeferredRequestCreator.containsKey(imageView)) {
            cancelExistingRequest(imageView);
        }
        this.targetToDeferredRequestCreator.put(imageView, deferredRequestCreator);
    }

    /* access modifiers changed from: package-private */
    public void cancelExistingRequest(Object obj) {
        DeferredRequestCreator remove;
        if ((obj instanceof ImageView) && (remove = this.targetToDeferredRequestCreator.remove((ImageView) obj)) != null) {
            remove.cancel();
        }
    }
}
