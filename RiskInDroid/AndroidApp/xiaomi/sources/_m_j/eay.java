package _m_j;

import android.content.Context;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.e;
import java.util.HashMap;
import java.util.Map;

public class eay implements dzl {
    private static volatile eay O00000o;
    /* access modifiers changed from: package-private */

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f15135O000000o;
    eaa O00000Oo;
    /* access modifiers changed from: package-private */
    public boolean O00000o0 = false;
    private Map<e, dzl> O00000oO = new HashMap();

    private eay(Context context) {
        this.f15135O000000o = context.getApplicationContext();
    }

    public static eay O000000o(Context context) {
        if (O00000o == null) {
            synchronized (eay.class) {
                if (O00000o == null) {
                    O00000o = new eay(context);
                }
            }
        }
        return O00000o;
    }

    private void O000000o(e eVar, dzl dzl) {
        if (dzl != null) {
            if (this.O00000oO.containsKey(eVar)) {
                this.O00000oO.remove(eVar);
            }
            this.O00000oO.put(eVar, dzl);
        }
    }

    private boolean O00000o(e eVar) {
        return this.O00000oO.containsKey(eVar);
    }

    private void O00000o0(e eVar) {
        this.O00000oO.remove(eVar);
    }

    public final dzl O000000o(e eVar) {
        return this.O00000oO.get(eVar);
    }

    public final void O00000Oo() {
        duv.O000000o("ASSEMBLE_PUSH : assemble push unregister");
        for (dzl next : this.O00000oO.values()) {
            if (next != null) {
                next.O00000Oo();
            }
        }
        this.O00000oO.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01cf  */
    public final void O000000o() {
        eaa eaa;
        dzl O000000o2;
        dzl O000000o3;
        dzl O000000o4;
        dzl O000000o5;
        duv.O000000o("ASSEMBLE_PUSH : assemble push register");
        if (this.O00000oO.size() <= 0 && (eaa = this.O00000Oo) != null) {
            if (eaa.f15114O000000o) {
                StringBuilder sb = new StringBuilder();
                sb.append(" HW user switch : ");
                sb.append(this.O00000Oo.f15114O000000o);
                sb.append(" HW online switch : ");
                Context context = this.f15135O000000o;
                e eVar = e.f6055a;
                sb.append(ebb.O00000Oo(context));
                sb.append(" HW isSupport : ");
                sb.append(ag.f6051a.equals(ebg.O000000o(this.f15135O000000o)));
                duv.O000000o("ASSEMBLE_PUSH : " + sb.toString());
            }
            if (this.O00000Oo.f15114O000000o) {
                Context context2 = this.f15135O000000o;
                e eVar2 = e.f6055a;
                if (ebb.O00000Oo(context2) && ag.f6051a.equals(ebg.O000000o(this.f15135O000000o))) {
                    if (!O00000o(e.f6055a)) {
                        O000000o(e.f6055a, eak.O000000o(this.f15135O000000o, e.f6055a));
                    }
                    duv.O00000o0("hw manager add to list");
                    if (this.O00000Oo.O00000Oo) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" FCM user switch : ");
                        sb2.append(this.O00000Oo.O00000Oo);
                        sb2.append(" FCM online switch : ");
                        Context context3 = this.f15135O000000o;
                        e eVar3 = e.b;
                        sb2.append(ebb.O00000Oo(context3));
                        sb2.append(" FCM isSupport : ");
                        sb2.append(ebg.O00000Oo(this.f15135O000000o));
                        duv.O000000o("ASSEMBLE_PUSH : " + sb2.toString());
                    }
                    if (this.O00000Oo.O00000Oo) {
                        Context context4 = this.f15135O000000o;
                        e eVar4 = e.b;
                        if (ebb.O00000Oo(context4) && ebg.O00000Oo(this.f15135O000000o)) {
                            if (!O00000o(e.b)) {
                                O000000o(e.b, eak.O000000o(this.f15135O000000o, e.b));
                            }
                            duv.O00000o0("fcm manager add to list");
                            if (this.O00000Oo.O00000o0) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(" COS user switch : ");
                                sb3.append(this.O00000Oo.O00000o0);
                                sb3.append(" COS online switch : ");
                                Context context5 = this.f15135O000000o;
                                e eVar5 = e.c;
                                sb3.append(ebb.O00000Oo(context5));
                                sb3.append(" COS isSupport : ");
                                sb3.append(ebg.O00000o0(this.f15135O000000o));
                                duv.O000000o("ASSEMBLE_PUSH : " + sb3.toString());
                            }
                            if (this.O00000Oo.O00000o0) {
                                Context context6 = this.f15135O000000o;
                                e eVar6 = e.c;
                                if (ebb.O00000Oo(context6) && ebg.O00000o0(this.f15135O000000o)) {
                                    O000000o(e.c, eak.O000000o(this.f15135O000000o, e.c));
                                    if (this.O00000Oo.O00000o) {
                                        Context context7 = this.f15135O000000o;
                                        e eVar7 = e.d;
                                        if (ebb.O00000Oo(context7) && ebg.O00000o(this.f15135O000000o)) {
                                            O000000o(e.d, eak.O000000o(this.f15135O000000o, e.d));
                                        }
                                    }
                                    if (O00000o(e.d) && (O000000o2 = O000000o(e.d)) != null) {
                                        O00000o0(e.d);
                                        O000000o2.O00000Oo();
                                    }
                                }
                            }
                            if (O00000o(e.c) && (O000000o3 = O000000o(e.c)) != null) {
                                O00000o0(e.c);
                                O000000o3.O00000Oo();
                            }
                            if (this.O00000Oo.O00000o) {
                            }
                            O00000o0(e.d);
                            O000000o2.O00000Oo();
                        }
                    }
                    if (O00000o(e.b) && (O000000o4 = O000000o(e.b)) != null) {
                        O00000o0(e.b);
                        O000000o4.O00000Oo();
                    }
                    if (this.O00000Oo.O00000o0) {
                    }
                    if (this.O00000Oo.O00000o0) {
                    }
                    O00000o0(e.c);
                    O000000o3.O00000Oo();
                    if (this.O00000Oo.O00000o) {
                    }
                    O00000o0(e.d);
                    O000000o2.O00000Oo();
                }
            }
            if (O00000o(e.f6055a) && (O000000o5 = O000000o(e.f6055a)) != null) {
                O00000o0(e.f6055a);
                O000000o5.O00000Oo();
            }
            if (this.O00000Oo.O00000Oo) {
            }
            if (this.O00000Oo.O00000Oo) {
            }
            O00000o0(e.b);
            O000000o4.O00000Oo();
            if (this.O00000Oo.O00000o0) {
            }
            if (this.O00000Oo.O00000o0) {
            }
            O00000o0(e.c);
            O000000o3.O00000Oo();
            if (this.O00000Oo.O00000o) {
            }
            O00000o0(e.d);
            O000000o2.O00000Oo();
        }
        if (this.O00000oO.size() > 0) {
            for (dzl next : this.O00000oO.values()) {
                if (next != null) {
                    next.O000000o();
                }
            }
            ebb.O000000o(this.f15135O000000o);
        }
    }

    public final boolean O00000Oo(e eVar) {
        int i = eba.f15138O000000o[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            eaa eaa = this.O00000Oo;
            if (eaa != null) {
                return eaa.f15114O000000o;
            }
            return false;
        } else if (i != 2) {
            if (i == 3) {
                eaa eaa2 = this.O00000Oo;
                if (eaa2 != null) {
                    z = eaa2.O00000o0;
                }
            } else if (i != 4) {
                return false;
            }
            eaa eaa3 = this.O00000Oo;
            if (eaa3 != null) {
                return eaa3.O00000o;
            }
            return z;
        } else {
            eaa eaa4 = this.O00000Oo;
            if (eaa4 != null) {
                return eaa4.O00000Oo;
            }
            return false;
        }
    }
}
