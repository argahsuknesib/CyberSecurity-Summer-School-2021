package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public final class GifRenderingExecutor extends ScheduledThreadPoolExecutor {

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final GifRenderingExecutor f15483O000000o = new GifRenderingExecutor();
    }

    public static GifRenderingExecutor getInstance() {
        return O000000o.f15483O000000o;
    }

    private GifRenderingExecutor() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
