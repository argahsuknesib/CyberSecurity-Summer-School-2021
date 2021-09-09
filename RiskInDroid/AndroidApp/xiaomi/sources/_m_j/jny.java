package _m_j;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.IOException;
import pl.droidsonroids.gif.GifInfoHandle;

public abstract class jny {
    public abstract GifInfoHandle O000000o() throws IOException;

    /* synthetic */ jny(byte b) {
        this();
    }

    private jny() {
    }

    public static final class O000000o extends jny {

        /* renamed from: O000000o  reason: collision with root package name */
        private final AssetManager f1988O000000o;
        private final String O00000Oo;

        public O000000o(AssetManager assetManager, String str) {
            super((byte) 0);
            this.f1988O000000o = assetManager;
            this.O00000Oo = str;
        }

        /* access modifiers changed from: package-private */
        public final GifInfoHandle O000000o() throws IOException {
            return new GifInfoHandle(this.f1988O000000o.openFd(this.O00000Oo));
        }
    }

    public static class O00000Oo extends jny {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Resources f1989O000000o;
        private final int O00000Oo;

        public O00000Oo(Resources resources, int i) {
            super((byte) 0);
            this.f1989O000000o = resources;
            this.O00000Oo = i;
        }

        /* access modifiers changed from: package-private */
        public final GifInfoHandle O000000o() throws IOException {
            return new GifInfoHandle(this.f1989O000000o.openRawResourceFd(this.O00000Oo));
        }
    }
}
