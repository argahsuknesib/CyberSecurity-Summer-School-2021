package _m_j;

import com.xiaomi.push.gg;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class epv {

    /* renamed from: O000000o  reason: collision with root package name */
    private XmlPullParser f15714O000000o;

    epv() {
        try {
            this.f15714O000000o = XmlPullParserFactory.newInstance().newPullParser();
            this.f15714O000000o.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final eqr O000000o(byte[] bArr, eqb eqb) {
        this.f15714O000000o.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f15714O000000o.next();
        int eventType = this.f15714O000000o.getEventType();
        String name = this.f15714O000000o.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return eqy.O000000o(this.f15714O000000o);
        }
        if (name.equals("iq")) {
            return eqy.O000000o(this.f15714O000000o, eqb);
        }
        if (name.equals("presence")) {
            return eqy.O00000Oo(this.f15714O000000o);
        }
        if (this.f15714O000000o.getName().equals("stream")) {
            return null;
        }
        if (this.f15714O000000o.getName().equals("error")) {
            throw new gg(eqy.O00000o0(this.f15714O000000o));
        } else if (this.f15714O000000o.getName().equals("warning")) {
            this.f15714O000000o.next();
            boolean equals = this.f15714O000000o.getName().equals("multi-login");
            return null;
        } else {
            this.f15714O000000o.getName().equals("bind");
            return null;
        }
    }
}
