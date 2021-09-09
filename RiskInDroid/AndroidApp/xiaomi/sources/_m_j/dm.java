package _m_j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBinderMapperImpl;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public final class dm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dl f14778O000000o = new DataBinderMapperImpl();
    private static DataBindingComponent O00000Oo = null;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static <T extends ViewDataBinding> T O000000o(LayoutInflater layoutInflater, int i, ViewGroup viewGroup) {
        layoutInflater.inflate(i, viewGroup, false);
        return f14778O000000o.O000000o();
    }
}
