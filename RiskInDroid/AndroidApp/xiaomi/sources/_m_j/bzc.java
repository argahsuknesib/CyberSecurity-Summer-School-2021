package _m_j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;

public final class bzc extends bzf {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f13455O000000o;
    private bzb O00000Oo;

    public final void onCreate(Bundle bundle) {
        ccr.O00000Oo("EMIfragment", "onCreate");
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ccr.O00000Oo("EMIfragment", "onCreateView");
        View view = this.f13455O000000o;
        if (view == null) {
            this.f13455O000000o = layoutInflater.inflate((int) R.layout.shop_buy_confirm_payment_emi, viewGroup, false);
            this.O00000Oo = new bzb(getActivity(), this.f13455O000000o);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f13455O000000o);
                ccr.O00000Oo("EMIfragment", "onCreateView remove from parent");
            }
        }
        return this.f13455O000000o;
    }

    public final void O000000o() {
        bzb bzb = this.O00000Oo;
        if (bzb != null) {
            bzb.O000000o();
        }
    }
}
