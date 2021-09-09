package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import in.cashify.otex.PermissionActivity;
import java.util.ArrayList;

public class ooooooo extends Fragment implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f2368O000000o;

    public interface O000000o {
        void O000000o(String str, ArrayList<b> arrayList);
    }

    public final void O000000o() {
        if (getActivity() != null) {
            startActivity(new Intent(getActivity(), PermissionActivity.class));
        }
    }

    public final void O000000o(b bVar) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            O000000o(arrayList);
        } catch (Throwable th) {
            O00o.O000000o("OTEx Diagnose", "postResult: Error" + th.getMessage());
        }
    }

    public g O00000o() {
        throw new UnsupportedOperationException("getDiagnoseContext must override in child class " + getClass().getName());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof O000000o) {
            this.f2368O000000o = (O000000o) getParentFragment();
            return;
        }
        throw new RuntimeException(context.toString() + " must implement ExchangeManager.OnExchangeCallback");
    }

    public void onClick(View view) {
        throw new UnsupportedOperationException("onClick must override in child class " + getClass().getName());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return new TextView(getActivity());
    }

    public void onDetach() {
        super.onDetach();
        this.f2368O000000o = null;
    }

    public final void O000000o(ArrayList<b> arrayList) {
        if (this.f2368O000000o != null) {
            g O00000o = O00000o();
            O000000o o000000o = this.f2368O000000o;
            if (o000000o != null) {
                o000000o.O000000o(O00000o.O0000Oo0, arrayList);
            }
        }
    }

    public final boolean O000000o(String str) {
        FragmentActivity activity = getActivity();
        return activity != null && ContextCompat.O000000o(activity.getApplicationContext(), str) == 0;
    }

    public static boolean O000000o(Context context, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 23) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(Process.myUid()), context.getPackageName()};
            Class cls = Integer.TYPE;
            return ((Integer) appOpsManager.getClass().getMethod("checkOp", new Class[]{cls, cls, String.class}).invoke(appOpsManager, objArr)).intValue() == 0;
        } catch (Exception e) {
            O00o.O000000o("OTEx Diagnose", e.getMessage());
            return false;
        }
    }

    public final long O00000Oo() {
        if (O00000o() == null) {
            return 2000;
        }
        return (long) (O00000o().O00000o * 1000);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final long O00000o0() {
        if (O00000o() == null) {
            return 300;
        }
        return Math.max(300L, (long) (O00000o().O00000oO * 1000));
    }
}
