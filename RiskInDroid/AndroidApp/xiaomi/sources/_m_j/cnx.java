package _m_j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import java.io.File;
import java.util.concurrent.ExecutorService;

public class cnx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f14158O000000o = "cnx";
    private static volatile cnx O00000oO;
    public ImageLoaderConfiguration O00000Oo;
    private cny O00000o;
    public coo O00000o0 = new coq();

    public static cnx O000000o() {
        if (O00000oO == null) {
            synchronized (cnx.class) {
                if (O00000oO == null) {
                    O00000oO = new cnx();
                }
            }
        }
        return O00000oO;
    }

    protected cnx() {
    }

    public final synchronized void O000000o(ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoaderConfiguration == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        } else if (this.O00000Oo == null) {
            cou.O000000o("Initialize ImageLoader with configuration", new Object[0]);
            this.O00000o = new cny(imageLoaderConfiguration);
            this.O00000Oo = imageLoaderConfiguration;
        } else {
            cou.O00000o0("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    public final boolean O00000Oo() {
        return this.O00000Oo != null;
    }

    public final void O000000o(String str, ImageView imageView) {
        O000000o(str, new col(imageView), null, null, null);
    }

    public final void O000000o(String str, ImageView imageView, cnw cnw) {
        O000000o(str, new col(imageView), cnw, null, null);
    }

    public final void O00000o0() {
        if (this.O00000Oo == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public final void O000000o(ImageView imageView) {
        this.O00000o.O00000Oo(new col(imageView));
    }

    public final void O00000o() {
        if (this.O00000Oo != null) {
            cou.O000000o("Destroy ImageLoader", new Object[0]);
        }
        cny cny = this.O00000o;
        if (!cny.f14159O000000o.O0000Oo0) {
            ((ExecutorService) cny.O00000Oo).shutdownNow();
        }
        if (!cny.f14159O000000o.O0000Oo) {
            ((ExecutorService) cny.O00000o0).shutdownNow();
        }
        cny.O00000oO.clear();
        cny.O00000oo.clear();
        this.O00000Oo.O0000o0O.O000000o();
        this.O00000o = null;
        this.O00000Oo = null;
    }

    public final void O000000o(String str, cok cok, cnw cnw, coo coo, cop cop) {
        O00000o0();
        if (coo == null) {
            coo = this.O00000o0;
        }
        coo coo2 = coo;
        if (cnw == null) {
            cnw = this.O00000Oo.O0000oO0;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            this.O00000o.O00000Oo(cok);
            coo2.onLoadingStarted(str, cok.O00000o());
            if (!(cnw.O00000oO == null && cnw.O00000Oo == 0)) {
                z = true;
            }
            if (z) {
                cok.O000000o(cnw.O00000Oo != 0 ? this.O00000Oo.f5352O000000o.getDrawable(cnw.O00000Oo) : cnw.O00000oO);
            } else {
                cok.O000000o((Drawable) null);
            }
            coo2.onLoadingComplete(str, cok.O00000o(), null);
            return;
        }
        cod O000000o2 = cos.O000000o(cok, this.O00000Oo.O000000o());
        String str2 = str + "_" + O000000o2.f14165O000000o + "x" + O000000o2.O00000Oo;
        this.O00000o.O00000oO.put(Integer.valueOf(cok.O00000oo()), str2);
        coo2.onLoadingStarted(str, cok.O00000o());
        Bitmap O000000o3 = this.O00000Oo.O0000o0.O000000o(str2);
        if (O000000o3 == null || O000000o3.isRecycled()) {
            if (!(cnw.O00000o == null && cnw.f14156O000000o == 0)) {
                z = true;
            }
            if (z) {
                cok.O000000o(cnw.f14156O000000o != 0 ? this.O00000Oo.f5352O000000o.getDrawable(cnw.f14156O000000o) : cnw.O00000o);
            } else if (cnw.O0000O0o) {
                cok.O000000o((Drawable) null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.O00000o, new cnz(str, cok, O000000o2, str2, cnw, coo2, null, this.O00000o.O000000o(str)), O000000o(cnw));
            if (cnw.O0000oO) {
                loadAndDisplayImageTask.run();
                return;
            }
            cny cny = this.O00000o;
            cny.O00000o.execute(new Runnable(loadAndDisplayImageTask) {
                /* class _m_j.cny.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ LoadAndDisplayImageTask f14160O000000o;

                {
                    this.f14160O000000o = r2;
                }

                public final void run() {
                    File O000000o2 = cny.this.f14159O000000o.O0000o0O.O000000o(this.f14160O000000o.O00000Oo);
                    boolean z = O000000o2 != null && O000000o2.exists();
                    cny.this.O000000o();
                    if (z) {
                        cny.this.O00000o0.execute(this.f14160O000000o);
                    } else {
                        cny.this.O00000Oo.execute(this.f14160O000000o);
                    }
                }
            });
            return;
        }
        cou.O000000o("Load image from memory cache [%s]", str2);
        if (cnw.O000000o()) {
            coa coa = new coa(this.O00000o, O000000o3, new cnz(str, cok, O000000o2, str2, cnw, coo2, null, this.O00000o.O000000o(str)), O000000o(cnw));
            if (cnw.O0000oO) {
                coa.run();
                return;
            }
            cny cny2 = this.O00000o;
            cny2.O000000o();
            cny2.O00000o0.execute(coa);
            return;
        }
        coi coi = cnw.O0000o;
        LoadedFrom loadedFrom = LoadedFrom.MEMORY_CACHE;
        coi.O000000o(O000000o3, cok);
        coo2.onLoadingComplete(str, cok.O00000o(), O000000o3);
    }

    public final void O000000o(String str, ImageView imageView, cnw cnw, coo coo) {
        O000000o(str, new col(imageView), cnw, coo, null);
    }

    private static Handler O000000o(cnw cnw) {
        Handler handler = cnw.O0000oO0;
        if (cnw.O0000oO) {
            return null;
        }
        return (handler == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : handler;
    }
}
