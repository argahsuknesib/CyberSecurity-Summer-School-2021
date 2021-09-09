package _m_j;

import _m_j.cbm;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public abstract class can extends Fragment implements SwipeRefreshLayout.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f13525O000000o;
    protected boolean O0000o00;

    public void onRefresh() {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f13525O000000o == null) {
            this.f13525O000000o = new O000000o(this, (byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getActivity().registerReceiver(this.f13525O000000o, intentFilter);
        this.O0000o00 = cbm.O00000Oo.O000000o(getActivity());
    }

    public void onDetach() {
        super.onDetach();
        getActivity().unregisterReceiver(this.f13525O000000o);
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(can can, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            boolean O000000o2 = cbm.O00000Oo.O000000o(can.this.getActivity());
            if (!can.this.O0000o00 && O000000o2 && (connectivityManager = (ConnectivityManager) can.this.getActivity().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                activeNetworkInfo.getType();
            }
            can.this.O0000o00 = O000000o2;
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: package-private */
    public int O00000oo() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean O0000O0o() {
        FragmentActivity activity = getActivity();
        if (activity != null && isAdded()) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return false;
                }
                return true;
            } else if (!activity.isFinishing()) {
                return true;
            }
        }
        return false;
    }
}
