package _m_j;

import com.github.scribejava.core.httpclient.jdk.JDKHttpClient;
import com.github.scribejava.core.model.Token;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutionException;

public abstract class avj<T extends Token> implements AutoCloseable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final auy f12643O000000o;
    public final avc O00000Oo;

    public avj(avc avc) {
        this.O00000Oo = avc;
        auz auz = avc.O0000OOo;
        auy auy = avc.O0000Oo0;
        if (auz == null && auy == null) {
            auy = new JDKHttpClient(new avb());
        } else if (auy == null) {
            auy = O000000o();
        }
        this.f12643O000000o = auy;
    }

    private static auy O000000o() {
        Iterator it = ServiceLoader.load(ava.class).iterator();
        while (it.hasNext()) {
            auy O000000o2 = ((ava) it.next()).O000000o();
            if (O000000o2 != null) {
                return O000000o2;
            }
        }
        return null;
    }

    public void close() throws IOException {
        this.f12643O000000o.O000000o();
    }

    public final avg O000000o(avd avd) throws InterruptedException, ExecutionException, IOException {
        File file = avd.O00000oo;
        if (file != null) {
            return this.f12643O000000o.O000000o(this.O00000Oo.O0000O0o, avd.O00000o, avd.O00000Oo, avd.O000000o(), file);
        }
        if (avd.O00000oO != null) {
            return this.f12643O000000o.O000000o(this.O00000Oo.O0000O0o, avd.O00000o, avd.O00000Oo, avd.O000000o(), avd.O00000oO);
        }
        return this.f12643O000000o.O000000o(this.O00000Oo.O0000O0o, avd.O00000o, avd.O00000Oo, avd.O000000o(), avd.O00000o0());
    }
}
