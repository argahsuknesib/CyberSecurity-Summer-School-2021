package _m_j;

import com.imi.fastjson.JSONArray;
import com.imi.fastjson.JSONObject;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class bdu {
    private static bdu O00000o0 = new bdu();

    /* renamed from: O000000o  reason: collision with root package name */
    public final Set<Class<?>> f12891O000000o = new HashSet();
    protected final bdv O00000Oo = new bdv();
    private final bif<Type, bff> O00000o = new bif<>();

    public static bdu O000000o() {
        return O00000o0;
    }

    public bdu() {
        this.f12891O000000o.add(Boolean.TYPE);
        this.f12891O000000o.add(Boolean.class);
        this.f12891O000000o.add(Character.TYPE);
        this.f12891O000000o.add(Character.class);
        this.f12891O000000o.add(Byte.TYPE);
        this.f12891O000000o.add(Byte.class);
        this.f12891O000000o.add(Short.TYPE);
        this.f12891O000000o.add(Short.class);
        this.f12891O000000o.add(Integer.TYPE);
        this.f12891O000000o.add(Integer.class);
        this.f12891O000000o.add(Long.TYPE);
        this.f12891O000000o.add(Long.class);
        this.f12891O000000o.add(Float.TYPE);
        this.f12891O000000o.add(Float.class);
        this.f12891O000000o.add(Double.TYPE);
        this.f12891O000000o.add(Double.class);
        this.f12891O000000o.add(BigInteger.class);
        this.f12891O000000o.add(BigDecimal.class);
        this.f12891O000000o.add(String.class);
        this.f12891O000000o.add(Date.class);
        this.f12891O000000o.add(java.sql.Date.class);
        this.f12891O000000o.add(Time.class);
        this.f12891O000000o.add(Timestamp.class);
        this.O00000o.O000000o(SimpleDateFormat.class, bek.f12906O000000o);
        this.O00000o.O000000o(Timestamp.class, bfp.f12929O000000o);
        this.O00000o.O000000o(java.sql.Date.class, bfi.f12924O000000o);
        this.O00000o.O000000o(Time.class, bfn.f12927O000000o);
        this.O00000o.O000000o(Date.class, bej.f12905O000000o);
        this.O00000o.O000000o(Calendar.class, bed.f12899O000000o);
        this.O00000o.O000000o(JSONObject.class, bev.f12915O000000o);
        this.O00000o.O000000o(JSONArray.class, beu.f12914O000000o);
        this.O00000o.O000000o(Map.class, bfc.f12920O000000o);
        this.O00000o.O000000o(HashMap.class, bfc.f12920O000000o);
        this.O00000o.O000000o(LinkedHashMap.class, bfc.f12920O000000o);
        this.O00000o.O000000o(TreeMap.class, bfc.f12920O000000o);
        this.O00000o.O000000o(ConcurrentMap.class, bfc.f12920O000000o);
        this.O00000o.O000000o(ConcurrentHashMap.class, bfc.f12920O000000o);
        this.O00000o.O000000o(Collection.class, bei.f12904O000000o);
        this.O00000o.O000000o(List.class, bei.f12904O000000o);
        this.O00000o.O000000o(ArrayList.class, bei.f12904O000000o);
        this.O00000o.O000000o(Object.class, bex.f12917O000000o);
        this.O00000o.O000000o(String.class, bfk.f12926O000000o);
        this.O00000o.O000000o(Character.TYPE, bef.f12901O000000o);
        this.O00000o.O000000o(Character.class, bef.f12901O000000o);
        this.O00000o.O000000o(Byte.TYPE, bfe.f12921O000000o);
        this.O00000o.O000000o(Byte.class, bfe.f12921O000000o);
        this.O00000o.O000000o(Short.TYPE, bfe.f12921O000000o);
        this.O00000o.O000000o(Short.class, bfe.f12921O000000o);
        this.O00000o.O000000o(Integer.TYPE, bes.f12913O000000o);
        this.O00000o.O000000o(Integer.class, bes.f12913O000000o);
        this.O00000o.O000000o(Long.TYPE, bfa.f12919O000000o);
        this.O00000o.O000000o(Long.class, bfa.f12919O000000o);
        this.O00000o.O000000o(BigInteger.class, bea.f12897O000000o);
        this.O00000o.O000000o(BigDecimal.class, bdz.f12895O000000o);
        this.O00000o.O000000o(Float.TYPE, bep.f12910O000000o);
        this.O00000o.O000000o(Float.class, bep.f12910O000000o);
        this.O00000o.O000000o(Double.TYPE, bfe.f12921O000000o);
        this.O00000o.O000000o(Double.class, bfe.f12921O000000o);
        this.O00000o.O000000o(Boolean.TYPE, beb.f12898O000000o);
        this.O00000o.O000000o(Boolean.class, beb.f12898O000000o);
        this.O00000o.O000000o(Class.class, beh.f12903O000000o);
        this.O00000o.O000000o(char[].class, bee.f12900O000000o);
        this.O00000o.O000000o(AtomicBoolean.class, beb.f12898O000000o);
        this.O00000o.O000000o(AtomicInteger.class, bes.f12913O000000o);
        this.O00000o.O000000o(AtomicLong.class, bfa.f12919O000000o);
        this.O00000o.O000000o(AtomicReference.class, bfh.f12923O000000o);
        this.O00000o.O000000o(WeakReference.class, bfh.f12923O000000o);
        this.O00000o.O000000o(SoftReference.class, bfh.f12923O000000o);
        this.O00000o.O000000o(UUID.class, bfs.f12932O000000o);
        this.O00000o.O000000o(TimeZone.class, bfo.f12928O000000o);
        this.O00000o.O000000o(Locale.class, bez.f12918O000000o);
        this.O00000o.O000000o(InetAddress.class, beq.f12911O000000o);
        this.O00000o.O000000o(Inet4Address.class, beq.f12911O000000o);
        this.O00000o.O000000o(Inet6Address.class, beq.f12911O000000o);
        this.O00000o.O000000o(InetSocketAddress.class, ber.f12912O000000o);
        this.O00000o.O000000o(File.class, beo.f12909O000000o);
        this.O00000o.O000000o(URI.class, bfq.f12930O000000o);
        this.O00000o.O000000o(URL.class, bfr.f12931O000000o);
        this.O00000o.O000000o(Pattern.class, bfg.f12922O000000o);
        this.O00000o.O000000o(Charset.class, beg.f12902O000000o);
        this.O00000o.O000000o(Number.class, bfe.f12921O000000o);
        this.O00000o.O000000o(AtomicIntegerArray.class, bdx.f12894O000000o);
        this.O00000o.O000000o(AtomicLongArray.class, bdx.f12894O000000o);
        this.O00000o.O000000o(StackTraceElement.class, bfj.f12925O000000o);
        this.O00000o.O000000o(Serializable.class, bex.f12917O000000o);
        this.O00000o.O000000o(Cloneable.class, bex.f12917O000000o);
        this.O00000o.O000000o(Comparable.class, bex.f12917O000000o);
        this.O00000o.O000000o(Closeable.class, bex.f12917O000000o);
    }

    public final bdv O00000Oo() {
        return this.O00000Oo;
    }

    public final bff O000000o(Type type) {
        while (true) {
            bff O000000o2 = this.O00000o.O000000o(type);
            if (O000000o2 != null) {
                return O000000o2;
            }
            if (type instanceof Class) {
                return O000000o((Class) type, type);
            }
            if (!(type instanceof ParameterizedType)) {
                return bex.f12917O000000o;
            }
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return O000000o((Class) rawType, type);
            }
            type = rawType;
        }
    }

    private bff O000000o(Class<?> cls, Type type) {
        bff O000000o2;
        bff bff;
        Class<?> O00000o02;
        while (true) {
            bff O000000o3 = this.O00000o.O000000o(type);
            if (O000000o3 != null) {
                return O000000o3;
            }
            if (type == null) {
                type = cls;
            }
            O000000o2 = this.O00000o.O000000o(type);
            if (O000000o2 != null) {
                return O000000o2;
            }
            bdl bdl = (bdl) cls.getAnnotation(bdl.class);
            if (bdl != null && (O00000o02 = bdl.O00000o0()) != Void.class) {
                cls = O00000o02;
                type = cls;
            }
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            O000000o2 = this.O00000o.O000000o(cls);
        }
        if (O000000o2 != null) {
            return O000000o2;
        }
        bff O000000o4 = this.O00000o.O000000o(type);
        if (O000000o4 != null) {
            return O000000o4;
        }
        if (cls.isEnum()) {
            bff = new bem(cls);
        } else if (cls.isArray()) {
            return bdx.f12894O000000o;
        } else {
            if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class) {
                bff = bei.f12904O000000o;
            } else if (Collection.class.isAssignableFrom(cls)) {
                bff = bei.f12904O000000o;
            } else if (Map.class.isAssignableFrom(cls)) {
                bff = bfc.f12920O000000o;
            } else if (Throwable.class.isAssignableFrom(cls)) {
                bff = new bfm(this, cls);
            } else {
                bff = O00000Oo(cls, type);
            }
        }
        O000000o(type, bff);
        return bff;
    }

    private bff O00000Oo(Class<?> cls, Type type) {
        return new bew(this, cls, type);
    }

    private void O000000o(Type type, bff bff) {
        this.O00000o.O000000o(type, bff);
    }

    public static Field O000000o(Class<?> cls, String str) {
        Field O00000Oo2 = O00000Oo(cls, str);
        if (O00000Oo2 == null) {
            O00000Oo2 = O00000Oo(cls, "_".concat(String.valueOf(str)));
        }
        return O00000Oo2 == null ? O00000Oo(cls, "m_".concat(String.valueOf(str))) : O00000Oo2;
    }

    private static Field O00000Oo(Class<?> cls, String str) {
        for (Field field : cls.getDeclaredFields()) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return null;
        }
        return O000000o(cls.getSuperclass(), str);
    }

    public final Map<String, ben> O000000o(Class<?> cls) {
        bff O000000o2 = O000000o((Type) cls);
        if (O000000o2 instanceof bew) {
            return ((bew) O000000o2).f12916O000000o;
        }
        return Collections.emptyMap();
    }

    public static ben O000000o(bdu bdu, Class<?> cls, bid bid) {
        Class<?> cls2 = bid.O00000o;
        if (cls2 == Boolean.TYPE || cls2 == Boolean.class) {
            return new bec(cls, bid);
        }
        if (cls2 == Integer.TYPE || cls2 == Integer.class) {
            return new bet(cls, bid);
        }
        if (cls2 == Long.TYPE || cls2 == Long.class) {
            return new bfb(bdu, cls, bid);
        }
        if (cls2 == String.class) {
            return new bfl(bdu, cls, bid);
        }
        if (cls2 == List.class || cls2 == ArrayList.class) {
            return new bdy(cls, bid);
        }
        return new bel(cls, bid);
    }

    public final bff O000000o(bid bid) {
        return O000000o(bid.O00000o, bid.O00000oO);
    }
}
