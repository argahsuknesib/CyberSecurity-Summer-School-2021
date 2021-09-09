package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.hzy.tvmao.KKNonACManager;
import com.kookong.app.data.IrData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class fyl implements fyi {

    /* renamed from: O000000o  reason: collision with root package name */
    private KKNonACManager f17410O000000o;

    public final boolean O000000o() {
        return false;
    }

    public final boolean O000000o(int i) {
        return false;
    }

    public final boolean O00000Oo() {
        return false;
    }

    public final boolean O00000Oo(int i) {
        return false;
    }

    public final int O00000o() {
        return 0;
    }

    public final boolean O00000o(int i) {
        return false;
    }

    public final boolean O00000o0() {
        return false;
    }

    public final boolean O00000o0(int i) {
        return false;
    }

    public final int O00000oO() {
        return 0;
    }

    public final boolean O00000oO(int i) {
        return false;
    }

    public final int O00000oo() {
        return 0;
    }

    public final boolean O00000oo(int i) {
        return false;
    }

    public final int O0000O0o() {
        return 0;
    }

    public final int O0000OOo() {
        return 0;
    }

    public final WritableArray O0000Oo() {
        return null;
    }

    public final int O0000Oo0() {
        return 0;
    }

    public final WritableArray O0000OoO() {
        return null;
    }

    public final WritableArray O0000Ooo() {
        return null;
    }

    public final WritableArray O0000o0() {
        return null;
    }

    public final WritableArray O0000o00() {
        return null;
    }

    public final WritableArray O0000o0O() {
        return null;
    }

    public fyl(KKNonACManager kKNonACManager) {
        this.f17410O000000o = kKNonACManager;
    }

    public final Object O0000o() {
        return this.f17410O000000o;
    }

    public final WritableArray O0000o0o() {
        ArrayList<IrData.IrKey> allKeys = this.f17410O000000o.getAllKeys();
        WritableArray createArray = Arguments.createArray();
        if (allKeys != null && allKeys.size() > 0) {
            for (IrData.IrKey next : allKeys) {
                WritableMap createMap = Arguments.createMap();
                if (next != null) {
                    createMap.putInt("fid", next.fid);
                    createMap.putString("fkey", next.fkey);
                    createMap.putString("fname", next.fname);
                    createMap.putInt("format", next.format);
                    createMap.putString("scode", next.scode);
                    createMap.putString("dcode", next.dcode);
                    createMap.putString("pulse", next.pulse);
                    HashMap<Integer, String> hashMap = next.exts;
                    WritableMap createMap2 = Arguments.createMap();
                    if (hashMap != null) {
                        Set<Integer> keySet = hashMap.keySet();
                        if (keySet.size() > 0) {
                            for (Integer next2 : keySet) {
                                createMap2.putString(String.valueOf(next2), hashMap.get(next2));
                            }
                        }
                    }
                    createMap.putMap("exts", createMap2);
                }
                createArray.pushMap(createMap);
            }
        }
        return createArray;
    }
}
