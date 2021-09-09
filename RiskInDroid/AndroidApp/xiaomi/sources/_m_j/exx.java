package _m_j;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.ExtendPipelineControllerFactory;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatCheckerUtils;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.fresco.SystraceRequestListener;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.svg.SVG;
import java.lang.reflect.Field;
import java.util.HashSet;
import okhttp3.OkHttpClient;

public final class exx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f15936O000000o = false;
    public static exy O00000Oo = new exy();

    public static synchronized void O000000o(boolean z) {
        synchronized (exx.class) {
            if (!z) {
                if (f15936O000000o) {
                    return;
                }
            }
            f15936O000000o = true;
            FLog.setLoggingDelegate(new eyq());
            Context appContext = CommonApplication.getAppContext();
            OkHttpClient okHttpClient = OkHttpClientProvider.getOkHttpClient();
            HashSet hashSet = new HashSet();
            hashSet.add(new SystraceRequestListener());
            ImagePipelineConfig.Builder requestListeners = OkHttpImagePipelineConfigFactory.newBuilder(appContext.getApplicationContext(), okHttpClient).setDownsampleEnabled(true).setResizeAndRotateEnabledForNetwork(true).setBitmapsConfig(Bitmap.Config.RGB_565).setMemoryTrimmableRegistry(O00000Oo).setRequestListeners(hashSet);
            int min = Math.min(((ActivityManager) appContext.getSystemService("activity")).getMemoryClass() * ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, Integer.MAX_VALUE);
            final int i = min < 33554432 ? 4194304 : min < 67108864 ? 6291456 : Build.VERSION.SDK_INT < 11 ? 8388608 : min / 6;
            requestListeners.setBitmapMemoryCacheParamsSupplier(new Supplier<MemoryCacheParams>() {
                /* class _m_j.exx.AnonymousClass2 */

                public final /* synthetic */ Object get() {
                    return new MemoryCacheParams(i, 56, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
                }
            });
            final ImageFormat imageFormat = new ImageFormat("SVG", "svg");
            requestListeners.setImageDecoderConfig(new ImageDecoderConfig.Builder().addDecodingCapability(imageFormat, new ImageFormat.FormatChecker() {
                /* class _m_j.exx.AnonymousClass3 */
                private final byte[] O00000Oo = "<svg".getBytes();
                private final byte[] O00000o0 = "<?xml".getBytes();

                public final int getHeaderSize() {
                    return Ints.max(this.O00000Oo.length, this.O00000o0.length);
                }

                public final ImageFormat determineFormat(byte[] bArr, int i) {
                    return (ImageFormatCheckerUtils.startsWithPattern(bArr, this.O00000Oo) || ImageFormatCheckerUtils.startsWithPattern(bArr, this.O00000o0)) ? imageFormat : ImageFormat.UNKNOWN;
                }
            }, new ImageDecoder() {
                /* class _m_j.$$Lambda$exx$3T7PRHN9HRHzt1Zc6WZx8CU */

                public final CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                    return exx.O000000o(ImageFormat.this, encodedImage, i, qualityInfo, imageDecodeOptions);
                }
            }).build());
            ImagePipelineConfig build = requestListeners.build();
            try {
                gsy.O00000Oo("FrescoInitial", "FrescoInitial->Fresco.initialize...");
                Fresco.initialize(CommonApplication.getAppContext(), build, DraweeConfig.newBuilder().addCustomDrawableFactory(new O00000Oo()).setPipelineDraweeControllerFactory(new ExtendPipelineControllerFactory()).build());
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000Oo(logType, "fresco", "FrescoInitial crash:" + th.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
            if (gfr.O0000o0o) {
                FLog.setMinimumLoggingLevel(2);
            }
            Class<FrescoModule> cls = FrescoModule.class;
            try {
                Field declaredField = cls.getDeclaredField("sHasBeenInitialized");
                declaredField.setAccessible(true);
                declaredField.setBoolean(cls, true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("app_quit_broadcast");
            ft.O000000o(CommonApplication.getAppContext()).O000000o(new BroadcastReceiver() {
                /* class _m_j.exx.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    if (intent != null && intent.getAction() != null && "app_quit_broadcast".equals(intent.getAction())) {
                        gsy.O00000Oo("FrescoInitial", "Fresco clearMemoryCaches");
                        if (Fresco.hasBeenInitialized()) {
                            Fresco.getImagePipeline().clearMemoryCaches();
                        }
                    }
                }
            }, intentFilter);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ CloseableImage O000000o(ImageFormat imageFormat, EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        PooledByteBuffer pooledByteBuffer;
        if (!encodedImage.getImageFormat().equals(imageFormat)) {
            return null;
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        if (!byteBufferRef.isValid() || (pooledByteBuffer = byteBufferRef.get()) == null) {
            LogType logType = LogType.MAIN_PAGE;
            gsy.O00000o0(logType, "FrescoInitial", "pooledByteBuffer:" + byteBufferRef.isValid());
            return null;
        }
        int size = pooledByteBuffer.size();
        byte[] bArr = new byte[size];
        pooledByteBuffer.read(0, bArr, 0, size);
        String str = new String(bArr);
        try {
            return new O000000o(SVG.O000000o(str), size);
        } catch (Exception e) {
            LogType logType2 = LogType.MAIN_PAGE;
            gsy.O00000o0(logType2, "FrescoInitial", "fatal decode", Log.getStackTraceString(e) + " " + str);
            return null;
        }
    }

    public static synchronized void O000000o() {
        synchronized (exx.class) {
        }
    }

    public static class O000000o extends CloseableImage {

        /* renamed from: O000000o  reason: collision with root package name */
        public SVG f15939O000000o;
        private int O00000Oo;

        public final void close() {
        }

        public final boolean isClosed() {
            return false;
        }

        public O000000o(SVG svg, int i) {
            this.f15939O000000o = svg;
            this.O00000Oo = i;
        }

        public final int getSizeInBytes() {
            return this.O00000Oo;
        }

        public final int getWidth() {
            return (int) this.f15939O000000o.O000000o();
        }

        public final int getHeight() {
            return (int) this.f15939O000000o.O00000Oo();
        }
    }

    public static class O00000Oo implements DrawableFactory {
        public boolean supportsImageType(CloseableImage closeableImage) {
            return closeableImage instanceof O000000o;
        }

        public Drawable createDrawable(CloseableImage closeableImage) {
            return new hyn(((O000000o) closeableImage).f15939O000000o);
        }
    }
}
