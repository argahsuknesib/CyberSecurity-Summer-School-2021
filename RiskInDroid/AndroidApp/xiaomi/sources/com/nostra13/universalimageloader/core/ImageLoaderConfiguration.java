package com.nostra13.universalimageloader.core;

import _m_j.cni;
import _m_j.cnp;
import _m_j.cnq;
import _m_j.cns;
import _m_j.cnt;
import _m_j.cnu;
import _m_j.cnw;
import _m_j.coc;
import _m_j.cod;
import _m_j.cof;
import _m_j.cog;
import _m_j.cor;
import _m_j.cou;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.concurrent.Executor;

public final class ImageLoaderConfiguration {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Resources f5352O000000o;
    final int O00000Oo;
    final int O00000o;
    final int O00000o0;
    final int O00000oO;
    final cor O00000oo;
    public final Executor O0000O0o;
    public final Executor O0000OOo;
    public final boolean O0000Oo;
    public final boolean O0000Oo0;
    public final int O0000OoO;
    public final int O0000Ooo;
    final cog O0000o;
    public final cns O0000o0;
    public final QueueProcessingType O0000o00;
    public final cni O0000o0O;
    final ImageDownloader O0000o0o;
    final ImageDownloader O0000oO;
    public final cnw O0000oO0;
    final ImageDownloader O0000oOO;

    /* synthetic */ ImageLoaderConfiguration(Builder builder, byte b) {
        this(builder);
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.f5352O000000o = builder.O00000Oo.getResources();
        this.O00000Oo = builder.O00000o0;
        this.O00000o0 = builder.O00000o;
        this.O00000o = builder.O00000oO;
        this.O00000oO = builder.O00000oo;
        this.O00000oo = builder.O0000O0o;
        this.O0000O0o = builder.O0000OOo;
        this.O0000OOo = builder.O0000Oo0;
        this.O0000OoO = builder.O0000Ooo;
        this.O0000Ooo = builder.O0000o00;
        this.O0000o00 = builder.O0000o0O;
        this.O0000o0O = builder.O0000o;
        this.O0000o0 = builder.O0000o0o;
        this.O0000oO0 = builder.O0000oOO;
        this.O0000o0o = builder.O0000oO0;
        this.O0000o = builder.O0000oO;
        this.O0000Oo0 = builder.O0000Oo;
        this.O0000Oo = builder.O0000OoO;
        this.O0000oO = new O000000o(this.O0000o0o);
        this.O0000oOO = new O00000Oo(this.O0000o0o);
        cou.O000000o(builder.O0000oOo);
    }

    public final cod O000000o() {
        DisplayMetrics displayMetrics = this.f5352O000000o.getDisplayMetrics();
        int i = this.O00000Oo;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.O00000o0;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new cod(i, i2);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final QueueProcessingType f5354O000000o = QueueProcessingType.FIFO;
        public Context O00000Oo;
        public int O00000o = 0;
        public int O00000o0 = 0;
        public int O00000oO = 0;
        public int O00000oo = 0;
        public cor O0000O0o = null;
        public Executor O0000OOo = null;
        public boolean O0000Oo = false;
        public Executor O0000Oo0 = null;
        public boolean O0000OoO = false;
        public int O0000Ooo = 3;
        public cni O0000o = null;
        public boolean O0000o0 = false;
        public int O0000o00 = 3;
        public QueueProcessingType O0000o0O = f5354O000000o;
        public cns O0000o0o = null;
        public cog O0000oO;
        public ImageDownloader O0000oO0 = null;
        public cnw O0000oOO = null;
        public boolean O0000oOo = false;
        private long O0000oo = 0;
        private int O0000oo0 = 0;
        private int O0000ooO = 0;
        private cnp O0000ooo = null;

        public Builder(Context context) {
            this.O00000Oo = context.getApplicationContext();
        }

        public final Builder O000000o() {
            if (!(this.O0000OOo == null && this.O0000Oo0 == null)) {
                cou.O00000o0("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.O0000o00 = 3;
            return this;
        }

        public final Builder O000000o(QueueProcessingType queueProcessingType) {
            if (!(this.O0000OOo == null && this.O0000Oo0 == null)) {
                cou.O00000o0("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.O0000o0O = queueProcessingType;
            return this;
        }

        public final Builder O00000Oo() {
            if (this.O0000o != null) {
                cou.O00000o0("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            this.O0000oo = 52428800;
            return this;
        }

        public final Builder O000000o(cnp cnp) {
            if (this.O0000o != null) {
                cou.O00000o0("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.O0000ooo = cnp;
            return this;
        }

        public final ImageLoaderConfiguration O00000o0() {
            boolean z = true;
            if (this.O0000OOo == null) {
                this.O0000OOo = DefaultConfigurationFactory.O000000o(this.O0000Ooo, this.O0000o00, this.O0000o0O);
            } else {
                this.O0000Oo = true;
            }
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = DefaultConfigurationFactory.O000000o(this.O0000Ooo, this.O0000o00, this.O0000o0O);
            } else {
                this.O0000OoO = true;
            }
            if (this.O0000o == null) {
                if (this.O0000ooo == null) {
                    this.O0000ooo = new cnq();
                }
                this.O0000o = DefaultConfigurationFactory.O000000o(this.O00000Oo, this.O0000ooo, this.O0000oo, this.O0000ooO);
            }
            if (this.O0000o0o == null) {
                Context context = this.O00000Oo;
                int i = this.O0000oo0;
                if (i == 0) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    int memoryClass = activityManager.getMemoryClass();
                    if (Build.VERSION.SDK_INT >= 11) {
                        if ((context.getApplicationInfo().flags & ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) == 0) {
                            z = false;
                        }
                        if (z) {
                            memoryClass = activityManager.getLargeMemoryClass();
                        }
                    }
                    i = (memoryClass * ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) / 8;
                }
                this.O0000o0o = new cnu(i);
            }
            if (this.O0000o0) {
                this.O0000o0o = new cnt(this.O0000o0o, new Comparator<String>() {
                    /* class _m_j.cov.AnonymousClass1 */

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        String str = (String) obj;
                        String str2 = (String) obj2;
                        return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
                    }
                });
            }
            if (this.O0000oO0 == null) {
                this.O0000oO0 = new BaseImageDownloader(this.O00000Oo);
            }
            if (this.O0000oO == null) {
                this.O0000oO = new cof(this.O0000oOo);
            }
            if (this.O0000oOO == null) {
                this.O0000oOO = new cnw.O000000o().O000000o();
            }
            return new ImageLoaderConfiguration(this, (byte) 0);
        }
    }

    static class O000000o implements ImageDownloader {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ImageDownloader f5355O000000o;

        public O000000o(ImageDownloader imageDownloader) {
            this.f5355O000000o = imageDownloader;
        }

        public final InputStream getStream(String str, Object obj) throws IOException {
            int i = AnonymousClass1.f5353O000000o[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i != 1 && i != 2) {
                return this.f5355O000000o.getStream(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.ImageLoaderConfiguration$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5353O000000o = new int[ImageDownloader.Scheme.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f5353O000000o[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            f5353O000000o[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
        }
    }

    static class O00000Oo implements ImageDownloader {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ImageDownloader f5356O000000o;

        public O00000Oo(ImageDownloader imageDownloader) {
            this.f5356O000000o = imageDownloader;
        }

        public final InputStream getStream(String str, Object obj) throws IOException {
            InputStream stream = this.f5356O000000o.getStream(str, obj);
            int i = AnonymousClass1.f5353O000000o[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i == 1 || i == 2) {
                return new coc(stream);
            }
            return stream;
        }
    }
}
