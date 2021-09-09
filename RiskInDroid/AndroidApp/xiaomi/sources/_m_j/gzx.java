package _m_j;

import _m_j.gzx;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.StagingArea;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.xiaomi.smarthome.module.blur.JavaBlurProcess;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0015H\u0002¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/newui/FrescoBitmapCache;", "", "()V", "cache", "", "key", "", "bitmap", "Landroid/graphics/Bitmap;", "createCacheKey", "Lcom/facebook/cache/common/SimpleCacheKey;", "into", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "callback", "Lcom/xiaomi/smarthome/newui/FrescoBitmapCache$Callback;", "blur", "", "readFromCacheSync", "readFromDiskCache", "Ljava/io/InputStream;", "Lcom/facebook/cache/common/CacheKey;", "Callback", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class gzx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final gzx f18674O000000o = new gzx();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/newui/FrescoBitmapCache$Callback;", "", "onFail", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void O000000o();
    }

    private gzx() {
    }

    public static void O000000o(String str, Bitmap bitmap) {
        ixe.O00000o(str, "key");
        ixe.O00000o(bitmap, "bitmap");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        Fresco.getImagePipelineFactory().getMainFileCache().insert(O00000Oo(str), new WriterCallback(byteArrayOutputStream.toByteArray()) {
            /* class _m_j.$$Lambda$gzx$Eu7UA6v3BnQIM0h1W1qJK6rcrAk */
            private final /* synthetic */ byte[] f$0;

            {
                this.f$0 = r1;
            }

            public final void write(OutputStream outputStream) {
                gzx.O000000o(this.f$0, outputStream);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(byte[] bArr, OutputStream outputStream) {
        outputStream.write(bArr);
    }

    public static void O000000o(String str, SimpleDraweeView simpleDraweeView, O000000o o000000o, boolean z) {
        ixe.O00000o(str, "key");
        ixe.O00000o(simpleDraweeView, "imageView");
        simpleDraweeView.setTag(str);
        goq.O000000o(new Runnable(str, z, simpleDraweeView, o000000o) {
            /* class _m_j.$$Lambda$gzx$X7IATb3Hml8PpnvPAj_PrcyFPQs */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ SimpleDraweeView f$2;
            private final /* synthetic */ gzx.O000000o f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                gzx.O000000o(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(String str, boolean z, SimpleDraweeView simpleDraweeView, O000000o o000000o) {
        ixe.O00000o(str, "$key");
        ixe.O00000o(simpleDraweeView, "$imageView");
        Bitmap O000000o2 = O000000o(str);
        if (z) {
            if (O000000o2 != null) {
                O000000o2 = new JavaBlurProcess().O000000o(O000000o2, O000000o2.getHeight() == 360 ? 10.0f : 30.0f);
            } else {
                O000000o2 = null;
            }
        }
        simpleDraweeView.post(new Runnable(str, O000000o2, o000000o) {
            /* class _m_j.$$Lambda$gzx$jcMYr5MJJsQCJn6SxOSvRt620do */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Bitmap f$2;
            private final /* synthetic */ gzx.O000000o f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                gzx.O000000o(SimpleDraweeView.this, this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* access modifiers changed from: private */
    public static final void O000000o(SimpleDraweeView simpleDraweeView, String str, Bitmap bitmap, O000000o o000000o) {
        ixe.O00000o(simpleDraweeView, "$imageView");
        ixe.O00000o(str, "$key");
        if (ixe.O000000o(simpleDraweeView.getTag(), (Object) str)) {
            if (bitmap != null) {
                simpleDraweeView.setImageBitmap(bitmap);
            } else {
                simpleDraweeView.setImageBitmap(null);
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        }
        simpleDraweeView.setTag(null);
    }

    public static Bitmap O000000o(String str) {
        ixe.O00000o(str, "key");
        SimpleCacheKey O00000Oo = O00000Oo(str);
        EncodedImage encodedImage = StagingArea.getInstance().get(O00000Oo);
        if (encodedImage != null) {
            return BitmapFactory.decodeStream(encodedImage.getInputStream());
        }
        try {
            InputStream O000000o2 = O000000o(O00000Oo);
            Bitmap decodeStream = BitmapFactory.decodeStream(O000000o2);
            if (O000000o2 == null) {
                return decodeStream;
            }
            O000000o2.close();
            return decodeStream;
        } catch (Exception unused) {
            return null;
        }
    }

    private static InputStream O000000o(CacheKey cacheKey) {
        try {
            BinaryResource resource = ImagePipelineFactory.getInstance().getMainFileCache().getResource(cacheKey);
            if (resource == null) {
                return null;
            }
            return resource.openStream();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    private static SimpleCacheKey O00000Oo(String str) {
        return new SimpleCacheKey(ixe.O000000o("file:///card_cover/", (Object) Integer.valueOf(str.hashCode())));
    }
}
