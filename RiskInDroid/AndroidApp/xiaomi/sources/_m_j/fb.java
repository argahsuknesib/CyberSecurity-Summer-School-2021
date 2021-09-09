package _m_j;

import _m_j.o0OoO00O;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public final class fb extends Lifecycle {
    private o0O000o0<ez, O000000o> O00000Oo = new o0O000o0<>();
    private final WeakReference<fa> O00000o;
    private Lifecycle.State O00000o0;
    private int O00000oO = 0;
    private boolean O00000oo = false;
    private boolean O0000O0o = false;
    private ArrayList<Lifecycle.State> O0000OOo = new ArrayList<>();

    public fb(fa faVar) {
        this.O00000o = new WeakReference<>(faVar);
        this.O00000o0 = Lifecycle.State.INITIALIZED;
    }

    public final void O000000o(Lifecycle.Event event) {
        O000000o(O00000Oo(event));
    }

    public final void O000000o(Lifecycle.State state) {
        if (this.O00000o0 != state) {
            this.O00000o0 = state;
            if (this.O00000oo || this.O00000oO != 0) {
                this.O0000O0o = true;
                return;
            }
            this.O00000oo = true;
            O00000o();
            this.O00000oo = false;
        }
    }

    private boolean O00000Oo() {
        if (this.O00000Oo.O00000oO == 0) {
            return true;
        }
        Lifecycle.State state = ((O000000o) this.O00000Oo.O00000Oo.getValue()).f16041O000000o;
        Lifecycle.State state2 = ((O000000o) this.O00000Oo.O00000o0.getValue()).f16041O000000o;
        if (state == state2 && this.O00000o0 == state2) {
            return true;
        }
        return false;
    }

    private Lifecycle.State O00000o0(ez ezVar) {
        o0O000o0<ez, O000000o> o0o000o0 = this.O00000Oo;
        Lifecycle.State state = null;
        o0OoO00O.O00000o0<K, V> o00000o0 = o0o000o0.O00000o0(ezVar) ? o0o000o0.f2230O000000o.get(ezVar).O00000o : null;
        Lifecycle.State state2 = o00000o0 != null ? ((O000000o) o00000o0.getValue()).f16041O000000o : null;
        if (!this.O0000OOo.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.O0000OOo;
            state = arrayList.get(arrayList.size() - 1);
        }
        return O000000o(O000000o(this.O00000o0, state2), state);
    }

    public final void O000000o(ez ezVar) {
        fa faVar;
        O000000o o000000o = new O000000o(ezVar, this.O00000o0 == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.O00000Oo.O000000o(ezVar, o000000o) == null && (faVar = this.O00000o.get()) != null) {
            boolean z = this.O00000oO != 0 || this.O00000oo;
            Lifecycle.State O00000o02 = O00000o0(ezVar);
            this.O00000oO++;
            while (o000000o.f16041O000000o.compareTo((Enum) O00000o02) < 0 && this.O00000Oo.O00000o0(ezVar)) {
                O00000Oo(o000000o.f16041O000000o);
                o000000o.O000000o(faVar, O00000o0(o000000o.f16041O000000o));
                O00000o0();
                O00000o02 = O00000o0(ezVar);
            }
            if (!z) {
                O00000o();
            }
            this.O00000oO--;
        }
    }

    private void O00000o0() {
        ArrayList<Lifecycle.State> arrayList = this.O0000OOo;
        arrayList.remove(arrayList.size() - 1);
    }

    private void O00000Oo(Lifecycle.State state) {
        this.O0000OOo.add(state);
    }

    public final void O00000Oo(ez ezVar) {
        this.O00000Oo.O00000Oo(ezVar);
    }

    public final Lifecycle.State O000000o() {
        return this.O00000o0;
    }

    static Lifecycle.State O00000Oo(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(event)));
        }
    }

    /* renamed from: _m_j.fb$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] O00000Oo = new int[Lifecycle.State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0086 */
        static {
            try {
                O00000Oo[Lifecycle.State.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[Lifecycle.State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[Lifecycle.State.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[Lifecycle.State.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                O00000Oo[Lifecycle.State.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f16040O000000o = new int[Lifecycle.Event.values().length];
            f16040O000000o[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            f16040O000000o[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            f16040O000000o[Lifecycle.Event.ON_START.ordinal()] = 3;
            f16040O000000o[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            f16040O000000o[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            f16040O000000o[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            f16040O000000o[Lifecycle.Event.ON_ANY.ordinal()] = 7;
        }
    }

    private static Lifecycle.Event O00000o0(Lifecycle.State state) {
        int i = AnonymousClass1.O00000Oo[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Lifecycle.Event.ON_START;
            }
            if (i == 3) {
                return Lifecycle.Event.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(state)));
            }
        }
        return Lifecycle.Event.ON_CREATE;
    }

    private void O000000o(fa faVar) {
        o0OoO00O<K, V>.O00000o O000000o2 = this.O00000Oo.O000000o();
        while (O000000o2.hasNext() && !this.O0000O0o) {
            Map.Entry entry = (Map.Entry) O000000o2.next();
            O000000o o000000o = (O000000o) entry.getValue();
            while (o000000o.f16041O000000o.compareTo((Enum) this.O00000o0) < 0 && !this.O0000O0o && this.O00000Oo.O00000o0(entry.getKey())) {
                O00000Oo(o000000o.f16041O000000o);
                o000000o.O000000o(faVar, O00000o0(o000000o.f16041O000000o));
                O00000o0();
            }
        }
    }

    private void O00000Oo(fa faVar) {
        Lifecycle.Event event;
        o0O000o0<ez, O000000o> o0o000o0 = this.O00000Oo;
        o0OoO00O.O00000Oo o00000Oo = new o0OoO00O.O00000Oo(o0o000o0.O00000o0, o0o000o0.O00000Oo);
        o0o000o0.O00000o.put(o00000Oo, Boolean.FALSE);
        while (o00000Oo.hasNext() && !this.O0000O0o) {
            Map.Entry entry = (Map.Entry) o00000Oo.next();
            O000000o o000000o = (O000000o) entry.getValue();
            while (o000000o.f16041O000000o.compareTo((Enum) this.O00000o0) > 0 && !this.O0000O0o && this.O00000Oo.O00000o0(entry.getKey())) {
                Lifecycle.State state = o000000o.f16041O000000o;
                int i = AnonymousClass1.O00000Oo[state.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        event = Lifecycle.Event.ON_DESTROY;
                    } else if (i == 3) {
                        event = Lifecycle.Event.ON_STOP;
                    } else if (i == 4) {
                        event = Lifecycle.Event.ON_PAUSE;
                    } else if (i != 5) {
                        throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(state)));
                    } else {
                        throw new IllegalArgumentException();
                    }
                    O00000Oo(O00000Oo(event));
                    o000000o.O000000o(faVar, event);
                    O00000o0();
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void O00000o() {
        fa faVar = this.O00000o.get();
        if (faVar != null) {
            while (!O00000Oo()) {
                this.O0000O0o = false;
                if (this.O00000o0.compareTo((Enum) ((O000000o) this.O00000Oo.O00000Oo.getValue()).f16041O000000o) < 0) {
                    O00000Oo(faVar);
                }
                o0OoO00O.O00000o0<K, V> o00000o0 = this.O00000Oo.O00000o0;
                if (!this.O0000O0o && o00000o0 != null && this.O00000o0.compareTo((Enum) ((O000000o) o00000o0.getValue()).f16041O000000o) > 0) {
                    O000000o(faVar);
                }
            }
            this.O0000O0o = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    static Lifecycle.State O000000o(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Lifecycle.State f16041O000000o;
        ey O00000Oo;

        O000000o(ez ezVar, Lifecycle.State state) {
            this.O00000Oo = fd.O000000o(ezVar);
            this.f16041O000000o = state;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(fa faVar, Lifecycle.Event event) {
            Lifecycle.State O00000Oo2 = fb.O00000Oo(event);
            this.f16041O000000o = fb.O000000o(this.f16041O000000o, O00000Oo2);
            this.O00000Oo.O000000o(faVar, event);
            this.f16041O000000o = O00000Oo2;
        }
    }
}
