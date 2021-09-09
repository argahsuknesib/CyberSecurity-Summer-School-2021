package com.xiaomi.smarthome.lifecycle;

import _m_j.cza;
import _m_j.ez;
import _m_j.gsy;
import _m_j.gte;
import _m_j.ixe;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/xiaomi/smarthome/lifecycle/BootPageLifeCycleDispatcher;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "TAG", "", "dispatchOnAppTerminate", "", "app", "Landroid/app/Application;", "dispatchOnCreate", "activity", "Landroidx/fragment/app/FragmentActivity;", "dispatchOnDestroy", "lifecycle_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BootPageLifeCycleDispatcher implements ez {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final BootPageLifeCycleDispatcher f9341O000000o = new BootPageLifeCycleDispatcher();

    private BootPageLifeCycleDispatcher() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static void O000000o(Application application) {
        ixe.O00000o(application, "app");
        List<gte> O000000o2 = cza.O000000o(gte.class).O000000o();
        ixe.O00000Oo(O000000o2, "observers");
        for (gte gte : O000000o2) {
            gsy.O00000o0(LogType.STARTUP, "BootPageLifeCycleDispatcher", ixe.O000000o("dispatchOnAppTerminate ", (Object) gte.getClass().getSimpleName()));
            gte.onAppDestroy(application);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static void O000000o(FragmentActivity fragmentActivity) {
        ixe.O00000o(fragmentActivity, "activity");
        List<gte> O000000o2 = cza.O000000o(gte.class).O000000o();
        ixe.O00000Oo(O000000o2, "observers");
        for (gte gte : O000000o2) {
            gsy.O00000o0(LogType.STARTUP, "BootPageLifeCycleDispatcher", ixe.O000000o("dispatchOnCreate ", (Object) gte.getClass().getSimpleName()));
            gte.onCreate(fragmentActivity);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static void O00000Oo(FragmentActivity fragmentActivity) {
        ixe.O00000o(fragmentActivity, "activity");
        List<gte> O000000o2 = cza.O000000o(gte.class).O000000o();
        ixe.O00000Oo(O000000o2, "observers");
        for (gte gte : O000000o2) {
            gsy.O00000o0(LogType.STARTUP, "BootPageLifeCycleDispatcher", ixe.O000000o("dispatchOnDestroy ", (Object) gte.getClass().getSimpleName()));
            gte.onDestroy(fragmentActivity);
        }
    }
}
