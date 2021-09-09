package androidx.savedstate;

import _m_j.ew;
import _m_j.fa;
import _m_j.ht;
import _m_j.hv;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RestrictedApi"})
public final class Recreator implements ew {

    /* renamed from: O000000o  reason: collision with root package name */
    private final hv f2972O000000o;

    public Recreator(hv hvVar) {
        this.f2972O000000o = hvVar;
    }

    public final void O000000o(fa faVar, Lifecycle.Event event) {
        Bundle bundle;
        if (event == Lifecycle.Event.ON_CREATE) {
            faVar.getLifecycle().O00000Oo(this);
            ht savedStateRegistry = this.f2972O000000o.getSavedStateRegistry();
            if (savedStateRegistry.O00000Oo) {
                if (savedStateRegistry.f612O000000o != null) {
                    bundle = savedStateRegistry.f612O000000o.getBundle("androidx.savedstate.Restarter");
                    savedStateRegistry.f612O000000o.remove("androidx.savedstate.Restarter");
                    if (savedStateRegistry.f612O000000o.isEmpty()) {
                        savedStateRegistry.f612O000000o = null;
                    }
                } else {
                    bundle = null;
                }
                if (bundle != null) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("classes_to_restore");
                    if (stringArrayList != null) {
                        Iterator<String> it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            try {
                                Class<? extends U> asSubclass = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(ht.O000000o.class);
                                try {
                                    Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                                    declaredConstructor.setAccessible(true);
                                    try {
                                        declaredConstructor.newInstance(new Object[0]);
                                    } catch (Exception e) {
                                        throw new RuntimeException("Failed to instantiate ".concat(String.valueOf(next)), e);
                                    }
                                } catch (NoSuchMethodException e2) {
                                    throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                                }
                            } catch (ClassNotFoundException e3) {
                                throw new RuntimeException("Class " + next + " wasn't found", e3);
                            }
                        }
                        return;
                    }
                    throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                return;
            }
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
