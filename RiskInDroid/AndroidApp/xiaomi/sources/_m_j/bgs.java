package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bgs {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final bid f12958O000000o;
    boolean O00000Oo = false;
    private final String O00000o;
    private final String O00000o0;
    private final String O00000oO;

    public abstract void O000000o(bhc bhc, Object obj) throws Exception;

    public bgs(bid bid) {
        this.f12958O000000o = bid;
        if (bid.O00000Oo != null) {
            bid.O00000Oo.setAccessible(true);
        } else {
            bid.O00000o0.setAccessible(true);
        }
        this.O00000o0 = jdn.f1779O000000o + bid.f12989O000000o + "\":";
        this.O00000o = "'" + bid.f12989O000000o + "':";
        this.O00000oO = bid.f12989O000000o + ":";
        bdk bdk = (bdk) bid.O000000o(bdk.class);
        if (bdk != null) {
            for (SerializerFeature serializerFeature : bdk.O00000oO()) {
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    this.O00000Oo = true;
                }
            }
        }
    }

    public final Field O000000o() {
        return this.f12958O000000o.O00000o0;
    }

    public final String O00000Oo() {
        return this.f12958O000000o.f12989O000000o;
    }

    public final Object O000000o(Object obj) throws Exception {
        return this.f12958O000000o.O000000o(obj);
    }

    public final void O000000o(bhc bhc) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (!bhc.O000000o(SerializerFeature.QuoteFieldNames)) {
            bhu.write(this.O00000oO);
        } else if (bhc.O000000o(SerializerFeature.UseSingleQuotes)) {
            bhu.write(this.O00000o);
        } else {
            bhu.write(this.O00000o0);
        }
    }
}
