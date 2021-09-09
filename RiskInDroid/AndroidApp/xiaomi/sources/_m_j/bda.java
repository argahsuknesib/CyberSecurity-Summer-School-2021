package _m_j;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.LinkedList;
import java.util.List;

public final class bda {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O000000o f12878O000000o;
    public final O000000o O00000Oo;
    public final List<O000000o> O00000o;
    public final O000000o O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f12879O000000o;
        public final String O00000Oo;

        public O000000o(String str, String str2) {
            this.f12879O000000o = str;
            this.O00000Oo = str2;
        }
    }

    public bda(O000000o o000000o, O000000o o000000o2, O000000o o000000o3, LinkedList<O000000o> linkedList) {
        this.f12878O000000o = o000000o;
        this.O00000Oo = o000000o2;
        this.O00000o0 = o000000o3;
        this.O00000o = linkedList;
    }

    public final List<String> O000000o() {
        LinkedList linkedList = new LinkedList();
        O000000o o000000o = this.f12878O000000o;
        if (o000000o != null) {
            linkedList.add(o000000o.f12879O000000o);
        }
        O000000o o000000o2 = this.O00000Oo;
        if (o000000o2 != null) {
            linkedList.add(o000000o2.f12879O000000o);
        }
        for (int i = 0; i < this.O00000o.size(); i++) {
            linkedList.add(this.O00000o.get(i).f12879O000000o);
        }
        return linkedList;
    }

    public final List<String> O00000Oo() {
        LinkedList linkedList = new LinkedList();
        O000000o o000000o = this.f12878O000000o;
        if (o000000o != null) {
            linkedList.add(o000000o.O00000Oo);
        }
        O000000o o000000o2 = this.O00000Oo;
        if (o000000o2 != null) {
            linkedList.add(o000000o2.O00000Oo);
        }
        for (int i = 0; i < this.O00000o.size(); i++) {
            linkedList.add(this.O00000o.get(i).O00000Oo);
        }
        return linkedList;
    }

    public static LinkedList<O000000o> O000000o(ReadableMap readableMap) {
        LinkedList<O000000o> linkedList = new LinkedList<>();
        if (!readableMap.hasKey("customButtons")) {
            return linkedList;
        }
        ReadableArray array = readableMap.getArray("customButtons");
        for (int i = 0; i < array.size(); i++) {
            ReadableMap map = array.getMap(i);
            linkedList.add(new O000000o(map.getString("title"), map.getString("name")));
        }
        return linkedList;
    }

    public static O000000o O000000o(ReadableMap readableMap, String str, String str2) {
        if (!bdc.O000000o(String.class, readableMap, str)) {
            return null;
        }
        return new O000000o(readableMap.getString(str), str2);
    }
}
