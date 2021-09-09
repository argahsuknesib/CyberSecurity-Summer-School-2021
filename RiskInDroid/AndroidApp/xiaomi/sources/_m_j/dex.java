package _m_j;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

public final class dex {
    public static Map<String, Integer> O000000o(ReadableMap readableMap) {
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, Integer.valueOf(readableMap.getInt(nextKey)));
        }
        return hashMap;
    }

    public static int[] O000000o(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = readableArray.getInt(i);
        }
        return iArr;
    }
}
