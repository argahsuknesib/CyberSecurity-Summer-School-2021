package _m_j;

import _m_j.dev;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import java.util.Map;

public class dfo extends dfk implements dfh {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14581O000000o = -1;
    private final Map<String, Integer> O00000Oo;
    private final JavaOnlyMap O00000o;
    private final UIImplementation O00000o0;
    private final ReactStylesDiffMap O00000oO;

    private static void O000000o(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof WritableArray) {
            writableMap.putArray(str, (WritableArray) obj);
        } else if (obj instanceof WritableMap) {
            writableMap.putMap(str, (WritableMap) obj);
        } else {
            throw new IllegalStateException("Unknown type of animated value");
        }
    }

    public dfo(int i, ReadableMap readableMap, dev dev, UIImplementation uIImplementation) {
        super(i, readableMap, dev);
        this.O00000Oo = dex.O000000o(readableMap.getMap("props"));
        this.O00000o0 = uIImplementation;
        this.O00000o = new JavaOnlyMap();
        this.O00000oO = new ReactStylesDiffMap(this.O00000o);
    }

    public final void O000000o(int i) {
        this.f14581O000000o = i;
        dangerouslyRescheduleEvaluate();
    }

    /* renamed from: _m_j.dfo$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14582O000000o = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f14582O000000o[ReadableType.Number.ordinal()] = 1;
            f14582O000000o[ReadableType.String.ordinal()] = 2;
            try {
                f14582O000000o[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O000000o() {
        if (this.f14581O000000o != -1) {
            value();
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Object evaluate() {
        boolean z;
        boolean z2;
        boolean z3;
        WritableMap writableMap;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (Map.Entry next : this.O00000Oo.entrySet()) {
            dfk O000000o2 = this.mNodesManager.O000000o(((Integer) next.getValue()).intValue(), dfk.class);
            if (O000000o2 instanceof dfq) {
                WritableMap writableMap2 = (WritableMap) O000000o2.value();
                ReadableMapKeySetIterator keySetIterator = writableMap2.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    if (this.mNodesManager.O0000o0.contains(nextKey)) {
                        writableMap = this.O00000o;
                        z = z6;
                        z2 = z5;
                        z3 = true;
                    } else if (this.mNodesManager.O0000o0O.contains(nextKey)) {
                        z3 = z4;
                        z = z6;
                        z2 = true;
                        writableMap = createMap2;
                    } else {
                        z2 = z5;
                        z = true;
                        z3 = z4;
                        writableMap = createMap;
                    }
                    ReadableType type = writableMap2.getType(nextKey);
                    int i = AnonymousClass1.f14582O000000o[type.ordinal()];
                    if (i == 1) {
                        writableMap.putDouble(nextKey, writableMap2.getDouble(nextKey));
                    } else if (i == 2) {
                        writableMap.putString(nextKey, writableMap2.getString(nextKey));
                    } else if (i == 3) {
                        writableMap.putArray(nextKey, (WritableArray) writableMap2.getArray(nextKey));
                    } else {
                        throw new IllegalArgumentException("Unexpected type ".concat(String.valueOf(type)));
                    }
                    z4 = z3;
                    z5 = z2;
                    z6 = z;
                }
                continue;
            } else {
                String str = (String) next.getKey();
                Object value = O000000o2.value();
                if (this.mNodesManager.O0000o0.contains(str)) {
                    O000000o(this.O00000o, str, value);
                    z4 = true;
                } else {
                    O000000o(createMap2, str, value);
                    z5 = true;
                }
            }
        }
        int i2 = this.f14581O000000o;
        if (i2 != -1) {
            if (z4) {
                this.O00000o0.synchronouslyUpdateViewOnUIThread(i2, this.O00000oO);
            }
            if (z5) {
                dev dev = this.mNodesManager;
                dev.O0000o0o.add(new dev.O000000o(this.f14581O000000o, createMap2));
            }
            if (z6) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putInt("viewTag", this.f14581O000000o);
                createMap3.putMap("props", createMap);
                this.mNodesManager.O000000o("onReanimatedPropsChange", createMap3);
            }
        }
        return ZERO;
    }
}
