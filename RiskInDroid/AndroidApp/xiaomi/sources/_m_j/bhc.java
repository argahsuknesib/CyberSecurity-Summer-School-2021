package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class bhc {

    /* renamed from: O000000o  reason: collision with root package name */
    public final bhu f12968O000000o;
    List<bhp> O00000Oo;
    List<bhj> O00000o;
    List<bia> O00000o0;
    List<bhq> O00000oO;
    bhs O00000oo;
    private final bht O0000O0o;
    private int O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private DateFormat O0000OoO;
    private IdentityHashMap<Object, bhs> O0000Ooo;

    public bhc() {
        this(new bhu(), bht.O000000o());
    }

    public bhc(bhu bhu) {
        this(bhu, bht.O000000o());
    }

    private bhc(bhu bhu, bht bht) {
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oO = null;
        this.O0000OOo = 0;
        this.O0000Oo0 = "\t";
        this.O0000Ooo = null;
        this.f12968O000000o = bhu;
        this.O0000O0o = bht;
    }

    public final DateFormat O000000o() {
        String str;
        if (this.O0000OoO == null && (str = this.O0000Oo) != null) {
            this.O0000OoO = new SimpleDateFormat(str);
        }
        return this.O0000OoO;
    }

    public final void O000000o(bhs bhs, Object obj, Object obj2) {
        if (!O000000o(SerializerFeature.DisableCircularReferenceDetect)) {
            this.O00000oo = new bhs(bhs, obj, obj2);
            if (this.O0000Ooo == null) {
                this.O0000Ooo = new IdentityHashMap<>();
            }
            this.O0000Ooo.put(obj, this.O00000oo);
        }
    }

    public final boolean O000000o(Object obj) {
        IdentityHashMap<Object, bhs> identityHashMap = this.O0000Ooo;
        if (identityHashMap == null) {
            return false;
        }
        return identityHashMap.containsKey(obj);
    }

    public final void O00000Oo() {
        this.O0000OOo++;
    }

    public final void O00000o0() {
        this.O0000OOo--;
    }

    public final void O00000o() {
        this.f12968O000000o.O000000o(10);
        for (int i = 0; i < this.O0000OOo; i++) {
            this.f12968O000000o.write(this.O0000Oo0);
        }
    }

    public final String toString() {
        return this.f12968O000000o.toString();
    }

    public final boolean O000000o(SerializerFeature serializerFeature) {
        return this.f12968O000000o.O000000o(serializerFeature);
    }

    public final void O00000oO() {
        this.f12968O000000o.write("null");
    }

    public final void O00000o0(Object obj) {
        if (obj == null) {
            this.f12968O000000o.write("null");
            return;
        }
        try {
            O000000o(obj.getClass()).O000000o(this, obj, null, null);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void O000000o(String str) {
        bhx bhx = bhx.f12983O000000o;
        bhx.O000000o(this, str);
    }

    public final bhn O000000o(Class<?> cls) {
        boolean z;
        bhn bhn = (bhn) this.O0000O0o.O000000o((Object) cls);
        if (bhn != null) {
            return bhn;
        }
        if (Map.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bhi.f12974O000000o);
        } else if (List.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bhf.f12971O000000o);
        } else if (Collection.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bgk.f12951O000000o);
        } else if (Date.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bgm.f12953O000000o);
        } else if (bdg.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bhb.f12967O000000o);
        } else if (bdh.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bhd.f12969O000000o);
        } else if (cls.isEnum() || (cls.getSuperclass() != null && cls.getSuperclass().isEnum())) {
            this.O0000O0o.O000000o(cls, bgp.f12956O000000o);
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            this.O0000O0o.O000000o(cls, new bfu(componentType, O000000o(componentType)));
        } else if (Throwable.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, new bgr(cls));
        } else if (TimeZone.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bhy.f12984O000000o);
        } else if (Charset.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bhz.f12985O000000o);
        } else if (Enumeration.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bgq.f12957O000000o);
        } else if (Calendar.class.isAssignableFrom(cls)) {
            this.O0000O0o.O000000o(cls, bgg.f12947O000000o);
        } else {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            boolean z2 = false;
            int i = 0;
            while (true) {
                z = true;
                if (i >= length) {
                    break;
                }
                Class<?> cls2 = interfaces[i];
                if (cls2.getName().equals("net.sf.cglib.proxy.Factory")) {
                    z2 = true;
                    break;
                } else if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                    break;
                } else {
                    i++;
                }
            }
            z = false;
            if (z2 || z) {
                bhn O000000o2 = O000000o((Class<?>) cls.getSuperclass());
                this.O0000O0o.O000000o(cls, O000000o2);
                return O000000o2;
            } else if (Proxy.isProxyClass(cls)) {
                this.O0000O0o.O000000o(cls, bht.O000000o(cls));
            } else {
                this.O0000O0o.O000000o(cls, bht.O000000o(cls));
            }
        }
        return (bhn) this.O0000O0o.O000000o((Object) cls);
    }

    public final void O00000Oo(Object obj) {
        bhs bhs;
        bhs bhs2 = this.O00000oo;
        if (obj == bhs2.O00000Oo) {
            this.f12968O000000o.write("{\"$ref\":\"@\"}");
            return;
        }
        bhs bhs3 = bhs2.f12978O000000o;
        if (bhs3 == null || obj != bhs3.O00000Oo) {
            while (bhs2.f12978O000000o != null) {
                bhs2 = bhs2.f12978O000000o;
            }
            if (obj == bhs2.O00000Oo) {
                this.f12968O000000o.write("{\"$ref\":\"$\"}");
                return;
            }
            IdentityHashMap<Object, bhs> identityHashMap = this.O0000Ooo;
            if (identityHashMap == null) {
                bhs = null;
            } else {
                bhs = identityHashMap.get(obj);
            }
            String O000000o2 = bhs.O000000o();
            this.f12968O000000o.write("{\"$ref\":\"");
            this.f12968O000000o.write(O000000o2);
            this.f12968O000000o.write("\"}");
            return;
        }
        this.f12968O000000o.write("{\"$ref\":\"..\"}");
    }
}
