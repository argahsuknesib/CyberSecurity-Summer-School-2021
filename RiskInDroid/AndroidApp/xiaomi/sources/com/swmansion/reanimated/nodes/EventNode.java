package com.swmansion.reanimated.nodes;

import _m_j.dev;
import _m_j.dfk;
import _m_j.dfs;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.ArrayList;
import java.util.List;

public class EventNode extends dfk implements RCTEventEmitter {
    private final List<O000000o> mMapping;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f5781O000000o;
        private final String[] O00000Oo;

        public O000000o(ReadableArray readableArray) {
            int size = readableArray.size() - 1;
            this.O00000Oo = new String[size];
            for (int i = 0; i < size; i++) {
                this.O00000Oo[i] = readableArray.getString(i);
            }
            this.f5781O000000o = readableArray.getInt(size);
        }

        public final Double O000000o(ReadableMap readableMap) {
            int i = 0;
            while (readableMap != null) {
                String[] strArr = this.O00000Oo;
                if (i >= strArr.length - 1) {
                    break;
                }
                String str = strArr[i];
                readableMap = readableMap.hasKey(str) ? readableMap.getMap(str) : null;
                i++;
            }
            if (readableMap != null) {
                String[] strArr2 = this.O00000Oo;
                String str2 = strArr2[strArr2.length - 1];
                if (readableMap.hasKey(str2)) {
                    return Double.valueOf(readableMap.getDouble(str2));
                }
            }
            return null;
        }
    }

    private static List<O000000o> processMapping(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new O000000o(readableArray.getArray(i)));
        }
        return arrayList;
    }

    public EventNode(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.mMapping = processMapping(readableMap.getArray("argMapping"));
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        if (writableMap != null) {
            for (int i2 = 0; i2 < this.mMapping.size(); i2++) {
                O000000o o000000o = this.mMapping.get(i2);
                Double O000000o2 = o000000o.O000000o(writableMap);
                if (O000000o2 != null) {
                    ((dfs) this.mNodesManager.O000000o(o000000o.f5781O000000o, dfs.class)).O000000o(O000000o2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Animated events must have event data.");
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by animated events");
    }

    /* access modifiers changed from: protected */
    public Double evaluate() {
        return ZERO;
    }
}
