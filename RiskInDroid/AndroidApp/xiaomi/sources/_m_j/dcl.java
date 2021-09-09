package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class dcl extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f14469O000000o;
    public String O00000Oo = "";
    private final String O00000o = getClass().getSimpleName();
    protected volatile boolean O00000o0 = false;

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.O00000Oo = bundle.getString("iid");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14469O000000o = getActivity();
    }

    public final boolean O000000o() {
        if (!isAdded() || isDetached()) {
            return false;
        }
        FragmentActivity activity = super.getActivity();
        FragmentActivity fragmentActivity = null;
        if (activity != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            fragmentActivity = activity;
        }
        return fragmentActivity != null;
    }
}
