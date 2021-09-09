package com.horcrux.svg;

import _m_j.baq;
import _m_j.bar;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
class ImageView extends RenderableView {
    private String mAlign;
    private baq mH;
    private int mImageHeight;
    private int mImageWidth;
    public final AtomicBoolean mLoading = new AtomicBoolean(false);
    private int mMeetOrSlice;
    private baq mW;
    private baq mX;
    private baq mY;
    private String uriString;

    public ImageView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.mX = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.mY = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.mW = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.mH = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "src")
    public void setSrc(ReadableMap readableMap) {
        if (readableMap != null) {
            this.uriString = readableMap.getString("uri");
            String str = this.uriString;
            if (str != null && !str.isEmpty()) {
                if (!readableMap.hasKey("width") || !readableMap.hasKey("height")) {
                    this.mImageWidth = 0;
                    this.mImageHeight = 0;
                } else {
                    this.mImageWidth = readableMap.getInt("width");
                    this.mImageHeight = readableMap.getInt("height");
                }
                if (Uri.parse(this.uriString).getScheme() == null) {
                    ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(this.mContext, this.uriString);
                }
            }
        }
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        if (!this.mLoading.get()) {
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            ImageRequest fromUri = ImageRequest.fromUri(new ImageSource(this.mContext, this.uriString).getUri());
            if (imagePipeline.isInBitmapMemoryCache(fromUri)) {
                tryRenderFromBitmapCache(imagePipeline, fromUri, canvas, paint, f * this.mOpacity);
                return;
            }
            loadBitmap(imagePipeline, fromUri);
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        path.addRect(getRect(), Path.Direction.CW);
        return path;
    }

    private void loadBitmap(ImagePipeline imagePipeline, ImageRequest imageRequest) {
        this.mLoading.set(true);
        imagePipeline.fetchDecodedImage(imageRequest, this.mContext).subscribe(new BaseBitmapDataSubscriber() {
            /* class com.horcrux.svg.ImageView.AnonymousClass1 */

            public final void onNewResultImpl(Bitmap bitmap) {
                ImageView.this.mLoading.set(false);
                SvgView svgView = ImageView.this.getSvgView();
                if (svgView != null) {
                    svgView.invalidate();
                }
            }

            public final void onFailureImpl(DataSource dataSource) {
                ImageView.this.mLoading.set(false);
                FLog.w("ReactNative", dataSource.getFailureCause(), "RNSVG: fetchDecodedImage failed!", new Object[0]);
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }

    private RectF getRect() {
        double relativeOnWidth = relativeOnWidth(this.mX);
        double relativeOnHeight = relativeOnHeight(this.mY);
        double relativeOnWidth2 = relativeOnWidth(this.mW);
        double relativeOnHeight2 = relativeOnHeight(this.mH);
        if (relativeOnWidth2 == 0.0d) {
            relativeOnWidth2 = (double) (((float) this.mImageWidth) * this.mScale);
        }
        if (relativeOnHeight2 == 0.0d) {
            relativeOnHeight2 = (double) (((float) this.mImageHeight) * this.mScale);
        }
        return new RectF((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2));
    }

    private void doRender(Canvas canvas, Paint paint, Bitmap bitmap, float f) {
        if (this.mImageWidth == 0 || this.mImageHeight == 0) {
            this.mImageWidth = bitmap.getWidth();
            this.mImageHeight = bitmap.getHeight();
        }
        RectF rect = getRect();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.mImageWidth, (float) this.mImageHeight);
        bar.O000000o(rectF, rect, this.mAlign, this.mMeetOrSlice).mapRect(rectF);
        canvas.clipPath(getPath(canvas, paint));
        Path clipPath = getClipPath(canvas, paint);
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
        Paint paint2 = new Paint();
        paint2.setAlpha((int) (f * 255.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
        canvas.getMatrix().mapRect(rectF);
        setClientRect(rectF);
    }

    private void tryRenderFromBitmapCache(ImagePipeline imagePipeline, ImageRequest imageRequest, Canvas canvas, Paint paint, float f) {
        CloseableReference result;
        DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache = imagePipeline.fetchImageFromBitmapCache(imageRequest, this.mContext);
        try {
            result = fetchImageFromBitmapCache.getResult();
            if (result == null) {
                fetchImageFromBitmapCache.close();
                return;
            }
            CloseableImage closeableImage = (CloseableImage) result.get();
            if (!(closeableImage instanceof CloseableBitmap)) {
                CloseableReference.closeSafely(result);
                fetchImageFromBitmapCache.close();
                return;
            }
            Bitmap underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
            if (underlyingBitmap == null) {
                CloseableReference.closeSafely(result);
                fetchImageFromBitmapCache.close();
                return;
            }
            doRender(canvas, paint, underlyingBitmap, f);
            CloseableReference.closeSafely(result);
            fetchImageFromBitmapCache.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } catch (Exception e2) {
            try {
                throw new IllegalStateException(e2);
            } catch (Throwable th) {
                fetchImageFromBitmapCache.close();
                throw th;
            }
        } catch (Throwable th2) {
            CloseableReference.closeSafely(result);
            throw th2;
        }
    }
}
