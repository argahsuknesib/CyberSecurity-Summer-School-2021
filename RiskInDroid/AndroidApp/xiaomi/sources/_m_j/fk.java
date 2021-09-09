package _m_j;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

public final class fk extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f16509O000000o;

    interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public static void O000000o(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new fk(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    static fk O00000Oo(Activity activity) {
        return (fk) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O000000o(Lifecycle.Event.ON_CREATE);
    }

    public final void onStart() {
        super.onStart();
        O000000o o000000o = this.f16509O000000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        O000000o(Lifecycle.Event.ON_START);
    }

    public final void onResume() {
        super.onResume();
        O000000o o000000o = this.f16509O000000o;
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
        O000000o(Lifecycle.Event.ON_RESUME);
    }

    public final void onPause() {
        super.onPause();
        O000000o(Lifecycle.Event.ON_PAUSE);
    }

    public final void onStop() {
        super.onStop();
        O000000o(Lifecycle.Event.ON_STOP);
    }

    public final void onDestroy() {
        super.onDestroy();
        O000000o(Lifecycle.Event.ON_DESTROY);
        this.f16509O000000o = null;
    }

    private void O000000o(Lifecycle.Event event) {
        Activity activity = getActivity();
        if (activity instanceof fc) {
            ((fc) activity).O000000o().O000000o(event);
        } else if (activity instanceof fa) {
            Lifecycle lifecycle = ((fa) activity).getLifecycle();
            if (lifecycle instanceof fb) {
                ((fb) lifecycle).O000000o(event);
            }
        }
    }
}
