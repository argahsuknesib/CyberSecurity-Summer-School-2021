package _m_j;

import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

public final class csm {

    /* renamed from: O000000o  reason: collision with root package name */
    public Uri f14308O000000o;
    public csq O00000Oo;
    Executor O00000o;
    public Runnable O00000o0;
    public Executor O00000oO;
    public DataSource<CloseableReference<CloseableImage>> O00000oo;

    public csm(Executor executor, Executor executor2, Runnable runnable) {
        this.O00000o0 = runnable;
        this.O00000o = executor;
        this.O00000oO = executor2;
        this.O00000Oo = new csq(executor);
    }
}
