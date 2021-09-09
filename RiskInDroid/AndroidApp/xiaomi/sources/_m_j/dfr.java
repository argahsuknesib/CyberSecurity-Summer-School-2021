package _m_j;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.List;

public final class dfr extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<O00000o0> f14585O000000o;

    static abstract class O00000o0 {
        public String O00000Oo;

        public abstract Object O000000o(dev dev);

        private O00000o0() {
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }
    }

    static class O000000o extends O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14586O000000o;

        private O000000o() {
            super((byte) 0);
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final Object O000000o(dev dev) {
            return dev.O000000o(this.f14586O000000o);
        }
    }

    static class O00000Oo extends O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Object f14587O000000o;

        private O00000Oo() {
            super((byte) 0);
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final Object O000000o(dev dev) {
            return this.f14587O000000o;
        }
    }

    public dfr(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        Object obj;
        ReadableArray array = readableMap.getArray("transform");
        ArrayList arrayList = new ArrayList(array.size());
        for (int i2 = 0; i2 < array.size(); i2++) {
            ReadableMap map = array.getMap(i2);
            String string = map.getString("property");
            if (map.hasKey("nodeID")) {
                O000000o o000000o = new O000000o((byte) 0);
                o000000o.O00000Oo = string;
                o000000o.f14586O000000o = map.getInt("nodeID");
                arrayList.add(o000000o);
            } else {
                O00000Oo o00000Oo = new O00000Oo((byte) 0);
                o00000Oo.O00000Oo = string;
                if (map.getType("value") == ReadableType.String) {
                    obj = map.getString("value");
                } else {
                    obj = Double.valueOf(map.getDouble("value"));
                }
                o00000Oo.f14587O000000o = obj;
                arrayList.add(o00000Oo);
            }
        }
        this.f14585O000000o = arrayList;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object evaluate() {
        ArrayList arrayList = new ArrayList(this.f14585O000000o.size());
        for (O00000o0 next : this.f14585O000000o) {
            arrayList.add(JavaOnlyMap.of(next.O00000Oo, next.O000000o(this.mNodesManager)));
        }
        return JavaOnlyArray.from(arrayList);
    }
}
