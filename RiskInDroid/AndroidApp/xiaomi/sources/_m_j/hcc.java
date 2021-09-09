package _m_j;

import _m_j.hcc.O000000o;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class hcc<E extends O000000o<T>, T> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<E> f18768O000000o = new ArrayList();
    public int O00000Oo = -1;

    public boolean O00000o0() {
        return false;
    }

    public List<E> O000000o() {
        return this.f18768O000000o;
    }

    public final List<E> O00000Oo() {
        return this.f18768O000000o;
    }

    public static abstract class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final double f18769O000000o;
        public final int O00000Oo;
        public final List<hdb> O00000o;
        public final String O00000o0;
        public final String O00000oO;
        public final hee O00000oo;
        public final boolean O0000O0o;

        public abstract int O000000o(T t);

        public abstract hdj O000000o(T t, Object obj, Device device);

        public abstract Object O000000o(T t, int i);

        public abstract String O000000o(Device device, T t);

        public abstract String O000000o(Device device, T t, Object obj);

        public abstract String O000000o(Device device, T t, Object obj, State state);

        public abstract void O000000o(hdb hdb, Device device, T t, Object obj, fsm<JSONObject, fso> fsm);

        public abstract boolean O000000o(Device device, hdb hdb);

        public abstract Object O00000Oo(Device device, T t);

        public abstract String O00000Oo(Device device, T t, Object obj);

        public abstract Pair<Object, Long> O00000o(Device device, T t);

        public abstract Object O00000o0(Device device, T t);

        public abstract long O00000oO(Device device, T t);

        public O000000o(int i, String str, List<hdb> list, double d, String str2, hee hee) {
            this.O00000Oo = i;
            this.O00000o0 = str;
            this.O00000o = list;
            this.f18769O000000o = d;
            this.O00000oO = str2;
            this.O00000oo = hee;
            this.O0000O0o = false;
        }

        public O000000o(JSONObject jSONObject, hee hee) {
            if (jSONObject == null) {
                this.O00000o0 = null;
                this.O00000o = Collections.emptyList();
                this.O00000Oo = 0;
                this.f18769O000000o = 0.0d;
                this.O00000oO = null;
                this.O00000oo = null;
                this.O0000O0o = false;
                return;
            }
            this.O00000oo = hee;
            this.O00000Oo = jSONObject.optInt("cardType");
            this.O00000o0 = jSONObject.optString("prop_key");
            this.f18769O000000o = jSONObject.optDouble("param_delta", 0.0d);
            this.O00000oO = jSONObject.optString("small_image");
            this.O0000O0o = jSONObject.optBoolean("prop_name_ignore", false);
            JSONArray optJSONArray = jSONObject.optJSONArray("param_type");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("operation");
            if (optJSONArray2 != null) {
                this.O00000o = new ArrayList();
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    this.O00000o.add(new hdb(optJSONArray2.optJSONObject(i), optJSONArray));
                }
                return;
            }
            this.O00000o = Collections.emptyList();
        }

        public hee O000000o() {
            return this.O00000oo;
        }

        public String toString() {
            return "CardType{cardItemType=" + this.O00000Oo + ", propKey='" + this.O00000o0 + '\'' + '}';
        }

        public final boolean O00000Oo() {
            int i = this.O00000Oo;
            return i == 8 || i == 7 || i == 18 || i == 9;
        }

        public final boolean O00000o0() {
            int i = this.O00000Oo;
            return i == 1 || i == 2 || i == 101;
        }

        public final boolean O00000o() {
            int i = this.O00000Oo;
            return i == 3 || i == 11 || i == 5 || i == 4 || i == 12;
        }

        public final boolean O00000oO() {
            int i = this.O00000Oo;
            return i == 7 || i == 17;
        }

        public final boolean O00000oo() {
            int i = this.O00000Oo;
            return i == 1 || i == 2 || i == 3 || i == 101;
        }

        public final boolean O0000O0o() {
            return this.O00000Oo == 14;
        }
    }
}
