package _m_j;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public final class eiq {
    public static void O000000o(FragmentManager fragmentManager, Fragment fragment) {
        O000000o(fragmentManager, 16908290, fragment);
    }

    private static Fragment O000000o(FragmentManager fragmentManager, int i, Fragment fragment) {
        String name = fragment.getClass().getName();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(name);
        if (findFragmentByTag != null) {
            return findFragmentByTag;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(16908290, fragment, name);
        beginTransaction.commitAllowingStateLoss();
        return fragment;
    }
}
