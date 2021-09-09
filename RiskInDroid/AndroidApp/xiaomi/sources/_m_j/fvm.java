package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class fvm extends Fragment implements fvn {
    private final String TAG = getClass().getSimpleName();
    public Context mContext;
    public String mPageId = "";
    protected volatile boolean mPageSelected = false;

    public boolean onBackPressed() {
        return false;
    }

    public void refreshTitleBar() {
    }

    /* access modifiers changed from: protected */
    public boolean titleBarSettled() {
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!titleBarSettled()) {
            gwg.O000000o(getActivity(), view);
        }
        if (bundle != null) {
            this.mPageId = bundle.getString("iid");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!getClass().getName().equals("com.xiaomi.smarthome.shop.fragment") && Build.VERSION.SDK_INT >= 29 && onCreateView != null) {
            onCreateView.setForceDarkAllowed(false);
        }
        return onCreateView;
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
        this.mContext = getActivity();
    }

    public void onPageSelected() {
        this.mPageSelected = true;
    }

    public void onPageDeselected() {
        this.mPageSelected = false;
    }

    public FragmentActivity getValidActivity() {
        FragmentActivity activity = super.getActivity();
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return activity;
        }
        return null;
    }

    public boolean isValid() {
        return isAdded() && !isDetached() && getValidActivity() != null;
    }
}
