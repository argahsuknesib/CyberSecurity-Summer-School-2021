package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.image.ImageLoaderOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class up extends vf<up> {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f2542O000000o;
    private Drawable O0000Oo;
    private boolean O0000OoO;
    private boolean O0000Ooo;
    private uq<?, ?> O0000o;
    private Class O0000o0 = Bitmap.class;
    private boolean O0000o00;
    private RequestManager O0000o0O;
    private Context O0000o0o;
    private List<vg> O0000oO;
    private boolean O0000oO0 = true;

    public up(RequestManager requestManager, Class cls, Context context) {
        this.O0000o0o = context;
        this.O0000o0O = requestManager;
        this.O0000o0 = cls;
        if (cls == ve.class) {
            this.O0000OoO = true;
        } else if (cls == File.class) {
            this.O0000Ooo = true;
        } else if (cls == Bitmap.class) {
            this.O0000o00 = true;
        }
        for (vg<Object> O00000Oo : requestManager.f3571O000000o) {
            O00000Oo(O00000Oo);
        }
    }

    public final up O000000o(String str) {
        this.f2542O000000o = str;
        return this;
    }

    public final up O000000o(vg vgVar) {
        this.O0000oO = null;
        return O00000Oo(vgVar);
    }

    private up O00000Oo(vg vgVar) {
        if (vgVar != null) {
            if (this.O0000oO == null) {
                this.O0000oO = new ArrayList();
            }
            this.O0000oO.add(vgVar);
        }
        return this;
    }

    public final vm O000000o(ImageView imageView) {
        ImageLoaderOptions O00000Oo = O00000Oo(imageView);
        vi viVar = new vi(imageView);
        O00000Oo.O00000Oo = viVar;
        dvt.O000000o().O000000o(O00000Oo, 1);
        return viVar;
    }

    public final <Y extends vl> Y O000000o(vl vlVar) {
        ImageLoaderOptions O00000Oo = O00000Oo((ImageView) null);
        O00000Oo.O00000Oo = vlVar;
        dvt O000000o2 = dvt.O000000o();
        Context context = this.O0000o0o;
        Uri O000000o3 = dvt.O000000o(O00000Oo);
        if (O000000o3 != null) {
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(O000000o3).build(), context).subscribe(new BaseBitmapDataSubscriber(O00000Oo.O00000Oo, O00000Oo, O00000Oo.O0000o) {
                /* class _m_j.dvt.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ vl f14979O000000o;
                final /* synthetic */ ImageLoaderOptions O00000Oo;
                final /* synthetic */ List O00000o0;

                {
                    this.f14979O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                }

                public final void onNewResultImpl(final Bitmap bitmap) {
                    if (bitmap != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class _m_j.dvt.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                Bitmap bitmap;
                                if (!bitmap.isRecycled()) {
                                    Bitmap bitmap2 = bitmap;
                                    bitmap = bitmap2.copy(bitmap2.getConfig(), bitmap.isMutable());
                                } else {
                                    bitmap = bitmap;
                                }
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                                if (AnonymousClass1.this.f14979O000000o != null) {
                                    if (AnonymousClass1.this.O00000Oo.O0000OoO) {
                                        AnonymousClass1.this.f14979O000000o.O000000o(bitmap);
                                    } else {
                                        AnonymousClass1.this.f14979O000000o.O000000o(bitmapDrawable);
                                    }
                                }
                                if (AnonymousClass1.this.O00000o0 != null && AnonymousClass1.this.O00000o0.size() > 0) {
                                    Iterator it = AnonymousClass1.this.O00000o0.iterator();
                                    while (it.hasNext()) {
                                        it.next();
                                        DataSource dataSource = DataSource.DATA_DISK_CACHE;
                                    }
                                }
                            }
                        });
                    }
                }

                public final void onFailureImpl(final com.facebook.datasource.DataSource dataSource) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class _m_j.dvt.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            new GlideException(dataSource.getFailureCause().getMessage());
                            if (AnonymousClass1.this.O00000o0 != null && AnonymousClass1.this.O00000o0.size() > 0) {
                                for (vg O000000o2 : AnonymousClass1.this.O00000o0) {
                                    O000000o2.O000000o();
                                }
                            }
                        }
                    });
                }
            }, CallerThreadExecutor.getInstance());
        }
        return vlVar;
    }

    private ImageLoaderOptions O00000Oo(ImageView imageView) {
        ImageLoaderOptions imageLoaderOptions = new ImageLoaderOptions(imageView, this.f2542O000000o);
        imageLoaderOptions.O0000Oo = this.O0000OoO;
        imageLoaderOptions.O0000OoO = this.O0000o00;
        if (!(this.O0000OOo == -1 || this.O0000O0o == -1)) {
            imageLoaderOptions.O000000o(this.O0000OOo, this.O0000O0o);
        }
        if (this.O00000oo != -1) {
            imageLoaderOptions.O00000oO = this.O00000oo;
        } else if (this.O00000oO != null) {
            imageLoaderOptions.O00000oo = this.O00000oO;
        }
        Class cls = this.O0000o0;
        if (cls != null) {
            imageLoaderOptions.O0000o0o = cls;
        }
        if (this.O00000o != -1) {
            imageLoaderOptions.O0000OOo = this.O00000o;
        } else if (this.O00000o0 != null) {
            imageLoaderOptions.O0000Oo0 = this.O00000o0;
        }
        if (O00000Oo()) {
            imageLoaderOptions.O0000o0 = 1;
        } else if (O00000o0()) {
            imageLoaderOptions.O0000o0 = 2;
        } else if (O00000o()) {
            imageLoaderOptions.O0000o0 = 3;
        } else if (O00000oO()) {
            imageLoaderOptions.O0000o0 = 4;
        }
        Drawable drawable = this.O0000Oo;
        if (drawable != null) {
            imageLoaderOptions.O00000o = drawable;
        }
        if (this.O0000Oo0.size() > 0) {
            imageLoaderOptions.O0000o0O = this.O0000Oo0;
        }
        if (O00000oo() == uv.O00000Oo) {
            imageLoaderOptions.O0000o00 = ImageLoaderOptions.ImageLoaderDiskCacheStrategy.NONE;
        } else {
            imageLoaderOptions.O0000o00 = ImageLoaderOptions.ImageLoaderDiskCacheStrategy.All;
        }
        List<vg> list = this.O0000oO;
        if (list != null && list.size() > 0) {
            imageLoaderOptions.O0000o = this.O0000oO;
        }
        uq<?, ?> uqVar = this.O0000o;
        if (uqVar != null && uqVar.O000000o() > 0) {
            imageLoaderOptions.O0000Ooo = true;
            imageLoaderOptions.O0000oO0 = this.O0000o.O000000o();
        }
        return imageLoaderOptions;
    }

    /* renamed from: O000000o */
    public final up O00000Oo(vf<?> vfVar) {
        return (up) super.O00000Oo(vfVar);
    }
}
