package _m_j;

import com.iheartradio.m3u8.Encoding;
import java.io.EOFException;
import java.io.InputStream;

abstract class bbc implements bbk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final bbn f12760O000000o;
    protected final Encoding O00000Oo;

    bbc(InputStream inputStream, Encoding encoding) {
        this.f12760O000000o = new bbn(inputStream, encoding);
        this.O00000Oo = encoding;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() throws EOFException {
        if (!this.f12760O000000o.f12765O000000o.hasNext()) {
            throw new EOFException();
        }
    }
}
