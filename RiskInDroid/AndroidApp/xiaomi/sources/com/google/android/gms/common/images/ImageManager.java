package com.google.android.gms.common.images;

import _m_j.o0oOo0O0;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.ImageRequest;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object zzov = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> zzow = new HashSet<>();
    private static ImageManager zzox;
    private static ImageManager zzoy;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ExecutorService zzoz = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */
    public final zza zzpa;
    /* access modifiers changed from: private */
    public final PostProcessedResourceCache zzpb;
    /* access modifiers changed from: private */
    public final Map<ImageRequest, ImageReceiver> zzpc;
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zzpd;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zzpe;

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        /* access modifiers changed from: private */
        public final ArrayList<ImageRequest> zzpf = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zzoz.execute(new zzb(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zza(ImageRequest imageRequest) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzpf.add(imageRequest);
        }

        public final void zzb(ImageRequest imageRequest) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzpf.remove(imageRequest);
        }

        public final void zzco() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    static final class zza extends o0oOo0O0<ImageRequest.zza, Bitmap> {
        /* JADX WARNING: Illegal instructions before constructor call */
        public zza(Context context) {
            super((int) (((float) (((context.getApplicationInfo().flags & ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) != 0 ? r0.getLargeMemoryClass() : r0.getMemoryClass()) * ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES)) * 0.33f));
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        }

        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            super.entryRemoved(z, (ImageRequest.zza) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    final class zzb implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzph;

        public zzb(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzph = parcelFileDescriptor;
        }

        public final void run() {
            boolean z;
            Bitmap bitmap;
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.zzph;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.mUri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                }
                try {
                    this.zzph.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zze(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.mUri);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    final class zzc implements Runnable {
        private final ImageRequest zzpi;

        public zzc(ImageRequest imageRequest) {
            this.zzpi = imageRequest;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, boolean):void
         arg types: [android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, int]
         candidates:
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, int):android.graphics.drawable.Drawable
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, android.graphics.Bitmap, boolean):void
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, boolean):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, android.graphics.Bitmap, boolean):void
         arg types: [android.content.Context, android.graphics.Bitmap, int]
         candidates:
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, int):android.graphics.drawable.Drawable
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, boolean):void
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, android.graphics.Bitmap, boolean):void */
        public final void run() {
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzpc.get(this.zzpi);
            if (imageReceiver != null) {
                ImageManager.this.zzpc.remove(this.zzpi);
                imageReceiver.zzb(this.zzpi);
            }
            ImageRequest.zza zza = this.zzpi.zzpk;
            if (zza.uri == null) {
                this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb, true);
                return;
            }
            Bitmap zza2 = ImageManager.this.zza(zza);
            if (zza2 != null) {
                this.zzpi.zza(ImageManager.this.mContext, zza2, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzpe.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb, true);
                    return;
                }
                ImageManager.this.zzpe.remove(zza.uri);
            }
            this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzpd.get(zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zza.uri);
                ImageManager.this.zzpd.put(zza.uri, imageReceiver2);
            }
            imageReceiver2.zza(this.zzpi);
            if (!(this.zzpi instanceof ImageRequest.ListenerImageRequest)) {
                ImageManager.this.zzpc.put(this.zzpi, imageReceiver2);
            }
            synchronized (ImageManager.zzov) {
                if (!ImageManager.zzow.contains(zza.uri)) {
                    ImageManager.zzow.add(zza.uri);
                    imageReceiver2.zzco();
                }
            }
        }
    }

    static final class zzd implements ComponentCallbacks2 {
        private final zza zzpa;

        public zzd(zza zza) {
            this.zzpa = zza;
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
            this.zzpa.evictAll();
        }

        public final void onTrimMemory(int i) {
            if (i >= 60) {
                this.zzpa.evictAll();
            } else if (i >= 20) {
                zza zza = this.zzpa;
                zza.trimToSize(zza.size() / 2);
            }
        }
    }

    final class zze implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzfd;
        private boolean zzpj;

        public zze(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzpj = z;
            this.zzfd = countDownLatch;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, android.graphics.Bitmap, boolean):void
         arg types: [android.content.Context, android.graphics.Bitmap, int]
         candidates:
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, int):android.graphics.drawable.Drawable
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, boolean):void
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, android.graphics.Bitmap, boolean):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, boolean):void
         arg types: [android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, int]
         candidates:
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, int):android.graphics.drawable.Drawable
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, android.graphics.Bitmap, boolean):void
          com.google.android.gms.common.images.ImageRequest.zza(android.content.Context, com.google.android.gms.common.images.internal.PostProcessedResourceCache, boolean):void */
        public final void run() {
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzpa != null) {
                if (this.zzpj) {
                    ImageManager.this.zzpa.evictAll();
                    System.gc();
                    this.zzpj = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.zzpa.put(new ImageRequest.zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzpd.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList zza = imageReceiver.zzpf;
                int size = zza.size();
                for (int i = 0; i < size; i++) {
                    ImageRequest imageRequest = (ImageRequest) zza.get(i);
                    if (z) {
                        imageRequest.zza(ImageManager.this.mContext, this.mBitmap, false);
                    } else {
                        ImageManager.this.zzpe.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        imageRequest.zza(ImageManager.this.mContext, ImageManager.this.zzpb, false);
                    }
                    if (!(imageRequest instanceof ImageRequest.ListenerImageRequest)) {
                        ImageManager.this.zzpc.remove(imageRequest);
                    }
                }
            }
            this.zzfd.countDown();
            synchronized (ImageManager.zzov) {
                ImageManager.zzow.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzpa = new zza(this.mContext);
            this.mContext.registerComponentCallbacks(new zzd(this.zzpa));
        } else {
            this.zzpa = null;
        }
        this.zzpb = new PostProcessedResourceCache();
        this.zzpc = new HashMap();
        this.zzpd = new HashMap();
        this.zzpe = new HashMap();
    }

    public static ImageManager create(Context context) {
        return create(context, false);
    }

    public static ImageManager create(Context context, boolean z) {
        if (z) {
            if (zzoy == null) {
                zzoy = new ImageManager(context, true);
            }
            return zzoy;
        }
        if (zzox == null) {
            zzox = new ImageManager(context, false);
        }
        return zzox;
    }

    /* access modifiers changed from: private */
    public final Bitmap zza(ImageRequest.zza zza2) {
        zza zza3 = this.zzpa;
        if (zza3 == null) {
            return null;
        }
        return (Bitmap) zza3.get(zza2);
    }

    public final void loadImage(ImageView imageView, int i) {
        loadImage(new ImageRequest.ImageViewImageRequest(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        loadImage(new ImageRequest.ImageViewImageRequest(imageView, uri));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        ImageRequest.ImageViewImageRequest imageViewImageRequest = new ImageRequest.ImageViewImageRequest(imageView, uri);
        imageViewImageRequest.setNoDataPlaceholder(i);
        loadImage(imageViewImageRequest);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        loadImage(new ImageRequest.ListenerImageRequest(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        ImageRequest.ListenerImageRequest listenerImageRequest = new ImageRequest.ListenerImageRequest(onImageLoadedListener, uri);
        listenerImageRequest.setNoDataPlaceholder(i);
        loadImage(listenerImageRequest);
    }

    public final void loadImage(ImageRequest imageRequest) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zzc(imageRequest).run();
    }
}
