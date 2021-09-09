package com.xiaomi.mico.common.adapter;

import _m_j.ee;
import _m_j.eh;
import androidx.fragment.app.Fragment;

public class SimplePagerAdapter extends eh {
    private Fragment fragment;

    public int getCount() {
        return 1;
    }

    public SimplePagerAdapter(ee eeVar, Fragment fragment2) {
        super(eeVar);
        this.fragment = fragment2;
    }

    public Fragment getItem(int i) {
        return this.fragment;
    }
}
