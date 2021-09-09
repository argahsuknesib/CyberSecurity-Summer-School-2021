package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;

final class bhk extends bgs {
    public bhk(bid bid) {
        super(bid);
    }

    public final void O000000o(bhc bhc, Object obj) throws Exception {
        bhu bhu = bhc.f12968O000000o;
        O000000o(bhc);
        if (obj != null) {
            bhu.append((CharSequence) obj.toString());
        } else if (bhu.O000000o(SerializerFeature.WriteNullNumberAsZero)) {
            bhu.O000000o('0');
        } else {
            bhu.write("null");
        }
    }
}
