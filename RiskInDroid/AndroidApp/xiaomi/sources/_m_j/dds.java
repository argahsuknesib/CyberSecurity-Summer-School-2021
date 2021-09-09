package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.smarthome.uwb.ui.Store$SimpleStore$store$2;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u0010"}, d2 = {"Lcom/smarthome/uwb/ui/Store;", "", "()V", "newIntStore", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", "", "context", "Landroid/content/Context;", "name", "", "distinguish", "", "newLongStore", "", "newStringStore", "SimpleStore", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class dds {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final dds f14516O000000o = new dds();

    private dds() {
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\b"}, d2 = {"com/smarthome/uwb/ui/Store$newStringStore$1", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", "", "get", "key", "set", "", "value", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends O000000o<String> {
        final /* synthetic */ String O00000o;
        final /* synthetic */ Context O00000o0;
        final /* synthetic */ boolean O00000oO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000o(Context context, String str, boolean z) {
            super(context, str, z);
            this.O00000o0 = context;
            this.O00000o = str;
            this.O00000oO = z;
        }

        public final /* synthetic */ Object O000000o(String str) {
            ixe.O00000o(str, "key");
            String O00000Oo = O00000Oo(str);
            if (O00000Oo.length() <= 2) {
                return null;
            }
            return O000000o().getString(O00000Oo, null);
        }

        public final /* synthetic */ void O000000o(String str, Object obj) {
            String str2 = (String) obj;
            ixe.O00000o(str, "key");
            ixe.O00000o(str2, "value");
            O000000o().edit().putString(O00000Oo(str), str2).apply();
        }
    }

    public static O000000o<String> O000000o(Context context, String str, boolean z) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "name");
        return new O00000o(context, str, z);
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"com/smarthome/uwb/ui/Store$newIntStore$1", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", "", "get", "key", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "set", "", "value", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends O000000o<Integer> {
        final /* synthetic */ String O00000o;
        final /* synthetic */ Context O00000o0;
        final /* synthetic */ boolean O00000oO = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000Oo(Context context, String str, boolean z) {
            super(context, str, true);
            this.O00000o0 = context;
            this.O00000o = str;
        }

        public final /* synthetic */ Object O000000o(String str) {
            ixe.O00000o(str, "key");
            String O00000Oo = O00000Oo(str);
            if (O00000Oo.length() <= 2) {
                return -1;
            }
            return Integer.valueOf(O000000o().getInt(O00000Oo, -1));
        }

        public final /* synthetic */ void O000000o(String str, Object obj) {
            int intValue = ((Number) obj).intValue();
            ixe.O00000o(str, "key");
            O000000o().edit().putInt(O00000Oo(str), intValue).apply();
        }
    }

    public static O000000o<Integer> O000000o(Context context, String str) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "name");
        return new O00000Oo(context, str, true);
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"com/smarthome/uwb/ui/Store$newLongStore$1", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", "", "get", "key", "", "(Ljava/lang/String;)Ljava/lang/Long;", "set", "", "value", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 extends O000000o<Long> {
        final /* synthetic */ String O00000o;
        final /* synthetic */ Context O00000o0;
        final /* synthetic */ boolean O00000oO = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000o0(Context context, String str, boolean z) {
            super(context, str, true);
            this.O00000o0 = context;
            this.O00000o = str;
        }

        public final /* synthetic */ Object O000000o(String str) {
            ixe.O00000o(str, "key");
            String O00000Oo = O00000Oo(str);
            if (O00000Oo.length() <= 2) {
                return -1L;
            }
            return Long.valueOf(O000000o().getLong(O00000Oo, -1));
        }

        public final /* synthetic */ void O000000o(String str, Object obj) {
            long longValue = ((Number) obj).longValue();
            ixe.O00000o(str, "key");
            O000000o().edit().putLong(O00000Oo(str), longValue).apply();
        }
    }

    public static O000000o<Long> O00000Oo(Context context, String str) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "name");
        return new O00000o0(context, str, true);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0013\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u0014J2\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00180\u00170\u0016\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00180\u001aJ\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/smarthome/uwb/ui/Store$SimpleStore;", "T", "", "context", "Landroid/content/Context;", "name", "", "distinguish", "", "(Landroid/content/Context;Ljava/lang/String;Z)V", "store", "Landroid/content/SharedPreferences;", "getStore", "()Landroid/content/SharedPreferences;", "store$delegate", "Lkotlin/Lazy;", "clear", "", "get", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "keyValues", "", "Lkotlin/Pair;", "E", "mapper", "Lkotlin/Function1;", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "standardizedKey", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Context f14517O000000o;
        public final String O00000Oo;
        private final itz O00000o = iua.O000000o(new Store$SimpleStore$store$2(this));
        private final boolean O00000o0;

        public abstract T O000000o(String str);

        public abstract void O000000o(String str, T t);

        public O000000o(Context context, String str, boolean z) {
            ixe.O00000o(context, "context");
            ixe.O00000o(str, "name");
            this.f14517O000000o = context;
            this.O00000Oo = str;
            this.O00000o0 = z;
        }

        /* access modifiers changed from: protected */
        public final SharedPreferences O000000o() {
            Object O000000o2 = this.O00000o.O000000o();
            ixe.O00000Oo(O000000o2, "<get-store>(...)");
            return (SharedPreferences) O000000o2;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: protected */
        public final String O00000Oo(String str) {
            ixe.O00000o(str, "key");
            return this.O00000o0 ? ixe.O000000o(gpp.O00000Oo(CoreApi.O000000o().O0000o0()), (Object) str) : str;
        }

        public final <E> List<Pair<String, E>> O000000o(iwc iwc) {
            Object obj;
            ixe.O00000o(iwc, "mapper");
            List<Pair<String, E>> arrayList = new ArrayList<>();
            Map<String, ?> all = O000000o().getAll();
            ixe.O00000Oo(all, "store.all");
            for (Map.Entry next : all.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                try {
                    Result.O000000o o000000o = Result.f15374O000000o;
                    if (value != null) {
                        obj = Result.O00000o0(iwc.invoke((String) value));
                        if (Result.O000000o(obj)) {
                            obj = null;
                        }
                        if (obj != null) {
                            arrayList.add(iuf.O000000o(str, obj));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } catch (Throwable th) {
                    Result.O000000o o000000o2 = Result.f15374O000000o;
                    obj = Result.O00000o0(iue.O000000o(th));
                }
            }
            return arrayList;
        }

        public final void O00000Oo() {
            O000000o().edit().clear().apply();
        }
    }
}
