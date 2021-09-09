package _m_j;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.hzy.tvmao.BaseACManager;
import com.hzy.tvmao.ir.ac.ACStateV2;
import com.kookong.app.data.IrData;
import java.util.ArrayList;
import java.util.HashMap;

public final class fyj {

    static class O000000o extends BaseACManager {
        /* synthetic */ O000000o(BaseACManager baseACManager, byte b) {
            this(baseACManager);
        }

        private O000000o(BaseACManager baseACManager) {
            setACStateV2FromString(baseACManager.getACStateV2InString());
        }

        /* access modifiers changed from: package-private */
        public final ACStateV2 O000000o() {
            return this.mAcStateV2;
        }
    }

    public static WritableArray O000000o(byte[] bArr) {
        WritableArray createArray = Arguments.createArray();
        if (bArr != null) {
            for (byte b : bArr) {
                createArray.pushInt(b & 255);
            }
        }
        return createArray;
    }

    private static HashMap<Integer, String> O00000Oo(ReadableMap readableMap) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            try {
                String nextKey = keySetIterator.nextKey();
                hashMap.put(Integer.valueOf(Integer.parseInt(nextKey)), readableMap.getString(nextKey));
            } catch (NumberFormatException e) {
                gbu.O00000o("readableMapToIntStringHashMap error:" + Log.getStackTraceString(e));
            }
        }
        return hashMap;
    }

    public static IrData O000000o(ReadableMap readableMap) {
        IrData irData = new IrData();
        if (readableMap != null) {
            irData.rid = gbv.O00000Oo(readableMap, "rid");
            irData.fre = gbv.O00000Oo(readableMap, "fre");
            irData.type = (short) gbv.O00000Oo(readableMap, "type");
            irData.exts = O00000Oo(gbv.O00000o(readableMap, "exts"));
            ReadableArray O00000oO = gbv.O00000oO(readableMap, "keys");
            ArrayList<IrData.IrKey> arrayList = new ArrayList<>();
            if (O00000oO != null) {
                int size = O00000oO.size();
                for (int i = 0; i < size; i++) {
                    ReadableMap map = O00000oO.getMap(i);
                    IrData.IrKey irKey = new IrData.IrKey();
                    if (map != null) {
                        irKey.fid = gbv.O00000Oo(map, "fid");
                        irKey.fkey = gbv.O000000o(map, "fkey");
                        irKey.fname = gbv.O000000o(map, "fname");
                        irKey.format = gbv.O00000Oo(map, "format");
                        irKey.scode = gbv.O000000o(map, "scode");
                        irKey.dcode = gbv.O000000o(map, "dcode");
                        irKey.pulse = gbv.O000000o(map, "pulse");
                        irKey.exts = O00000Oo(gbv.O00000o(map, "exts"));
                    }
                    arrayList.add(irKey);
                }
            }
            irData.keys = arrayList;
            irData.extJSON = gbv.O000000o(readableMap, "extJSON");
        }
        return irData;
    }
}
