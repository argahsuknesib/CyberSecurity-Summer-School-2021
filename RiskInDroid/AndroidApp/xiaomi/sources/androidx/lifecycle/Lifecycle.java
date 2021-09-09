package androidx.lifecycle;

import _m_j.ez;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle {

    /* renamed from: O000000o  reason: collision with root package name */
    AtomicReference<Object> f2878O000000o = new AtomicReference<>();

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public abstract State O000000o();

    public abstract void O000000o(ez ezVar);

    public abstract void O00000Oo(ez ezVar);

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }
}
