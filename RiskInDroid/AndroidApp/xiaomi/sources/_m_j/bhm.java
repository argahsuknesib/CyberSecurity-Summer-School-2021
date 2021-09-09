package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public final class bhm extends bgs {
    boolean O00000o = false;
    boolean O00000o0 = false;
    boolean O00000oO = false;
    boolean O00000oo = false;
    private bhn O0000O0o;
    private Class<?> O0000OOo;
    private boolean O0000Oo = false;
    private String O0000Oo0;

    public bhm(bid bid) {
        super(bid);
        bdk bdk = (bdk) bid.O000000o(bdk.class);
        if (bdk != null) {
            this.O0000Oo0 = bdk.O00000Oo();
            if (this.O0000Oo0.trim().length() == 0) {
                this.O0000Oo0 = null;
            }
            for (SerializerFeature serializerFeature : bdk.O00000oO()) {
                if (serializerFeature == SerializerFeature.WriteNullNumberAsZero) {
                    this.O0000Oo = true;
                } else if (serializerFeature == SerializerFeature.WriteNullStringAsEmpty) {
                    this.O00000o0 = true;
                } else if (serializerFeature == SerializerFeature.WriteNullBooleanAsFalse) {
                    this.O00000o = true;
                } else if (serializerFeature == SerializerFeature.WriteNullListAsEmpty) {
                    this.O00000oO = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.O00000oo = true;
                }
            }
        }
    }

    public final void O000000o(bhc bhc, Object obj) throws Exception {
        O000000o(bhc);
        String str = this.O0000Oo0;
        if (str == null) {
            if (this.O0000O0o == null) {
                if (obj == null) {
                    this.O0000OOo = this.f12958O000000o.O00000o;
                } else {
                    this.O0000OOo = obj.getClass();
                }
                this.O0000O0o = bhc.O000000o(this.O0000OOo);
            }
            if (obj == null) {
                if (this.O0000Oo && Number.class.isAssignableFrom(this.O0000OOo)) {
                    bhc.f12968O000000o.O000000o('0');
                } else if (this.O00000o0 && String.class == this.O0000OOo) {
                    bhc.f12968O000000o.write("\"\"");
                } else if (this.O00000o && Boolean.class == this.O0000OOo) {
                    bhc.f12968O000000o.write("false");
                } else if (!this.O00000oO || !Collection.class.isAssignableFrom(this.O0000OOo)) {
                    this.O0000O0o.O000000o(bhc, null, this.f12958O000000o.f12989O000000o, null);
                } else {
                    bhc.f12968O000000o.write("[]");
                }
            } else if (!this.O00000oo || !this.O0000OOo.isEnum()) {
                Class<?> cls = obj.getClass();
                if (cls == this.O0000OOo) {
                    this.O0000O0o.O000000o(bhc, obj, this.f12958O000000o.f12989O000000o, this.f12958O000000o.O00000oO);
                } else {
                    bhc.O000000o(cls).O000000o(bhc, obj, this.f12958O000000o.f12989O000000o, this.f12958O000000o.O00000oO);
                }
            } else {
                bhc.f12968O000000o.O000000o(((Enum) obj).name());
            }
        } else if (obj instanceof Date) {
            DateFormat O000000o2 = bhc.O000000o();
            if (O000000o2 == null) {
                O000000o2 = new SimpleDateFormat(str);
            }
            bhc.f12968O000000o.O000000o(O000000o2.format((Date) obj));
        } else {
            bhc.O00000o0(obj);
        }
    }
}
