package com.xiaomi.mico.common.adapter;

import _m_j.ee;
import _m_j.eh;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.List;

public class TabPagerAdapter extends eh {
    private List<TabPage> mTabPages;

    public static class TabPage {
        public Class clazz;
        public Fragment fragment;
        private long itemId;
        public CharSequence title;
        public String type;

        public static TabPage newPage(Fragment fragment2) {
            return newPage(fragment2, (CharSequence) null);
        }

        public static TabPage newPage(Fragment fragment2, CharSequence charSequence) {
            return new TabPage(fragment2, charSequence);
        }

        public static TabPage newPage(Fragment fragment2, CharSequence charSequence, String str) {
            return new TabPage(fragment2, charSequence, str);
        }

        public static TabPage newPage(Class cls, CharSequence charSequence) {
            return new TabPage(cls, charSequence);
        }

        private TabPage(Fragment fragment2, CharSequence charSequence, String str) {
            this.fragment = fragment2;
            this.title = charSequence;
            this.type = str;
        }

        private TabPage(Fragment fragment2, CharSequence charSequence) {
            this.fragment = fragment2;
            this.title = charSequence;
        }

        public TabPage(Class cls, CharSequence charSequence) {
            this.clazz = cls;
            this.title = charSequence;
        }
    }

    public TabPagerAdapter(ee eeVar, List<TabPage> list) {
        super(eeVar);
        this.mTabPages = list;
    }

    public Fragment getItem(int i) {
        if (this.mTabPages.get(i).fragment != null) {
            return this.mTabPages.get(i).fragment;
        }
        try {
            return (Fragment) this.mTabPages.get(i).clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            throw new IllegalStateException("New fragment failed.");
        }
    }

    public long getItemId(int i) {
        List<TabPage> list = this.mTabPages;
        if (list == null || i >= list.size()) {
            return super.getItemId(i);
        }
        return (long) this.mTabPages.get(i).fragment.hashCode();
    }

    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public int getCount() {
        return this.mTabPages.size();
    }

    public CharSequence getPageTitle(int i) {
        CharSequence charSequence = this.mTabPages.get(i).title;
        return charSequence != null ? charSequence : "";
    }
}
