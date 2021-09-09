package com.mi.global.shop.model;

import androidx.fragment.app.Fragment;

public class FragmentDesc {
    public Fragment fragment;
    public String title;

    public FragmentDesc(Fragment fragment2, String str) {
        this.fragment = fragment2;
        this.title = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        FragmentDesc fragmentDesc = (FragmentDesc) obj;
        String str = this.title;
        if (str == null) {
            if (fragmentDesc.title != null) {
                return false;
            }
        } else if (!str.equals(fragmentDesc.title)) {
            return false;
        }
        return true;
    }
}
