package _m_j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public final class byx extends bzf {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f13436O000000o;
    private bzk O00000Oo;

    public final void onCreate(Bundle bundle) {
        ccr.O00000Oo("CODfragment", "onCreate");
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ccr.O00000Oo("CODfragment", "onCreateView");
        View view = this.f13436O000000o;
        if (view == null) {
            this.f13436O000000o = layoutInflater.inflate((int) R.layout.shop_buy_confirm_payment_cod, viewGroup, false);
            this.O00000Oo = new bzk((ConfirmActivity) getActivity(), this.f13436O000000o, ((ConfirmActivity) getActivity()).getOrderPaymentInfo());
            bzk bzk = this.O00000Oo;
            bzk.O0000OOo = (LinearLayout) bzk.O00000o.findViewById(R.id.buy_confirm_payment_cod_phone);
            bzk.O0000Oo0 = (LinearLayout) bzk.O00000o.findViewById(R.id.buy_confirm_payment_cod_pic);
            bzk.O0000Oo = (LinearLayout) bzk.O00000o.findViewById(R.id.buy_confirm_payment_cod_verify);
            bzk.O0000OoO = (CommonButton) bzk.O0000Oo.findViewById(R.id.buy_confirm_cod_confirm_your_order);
            bzk.O0000OoO.setOnClickListener(bzk);
            bzk.O0000OoO.setEnabled(false);
            bzk.O0000o00 = (CustomTextView) bzk.O00000o.findViewById(R.id.buy_confirm_cod_phone_number_text);
            bzk.O0000o0o = (CustomTextView) bzk.O00000o.findViewById(R.id.buy_confirm_payment_cod_tel_edit_button);
            bzk.O0000o0o.setOnClickListener(bzk);
            bzk.O0000o0O = (CustomTextView) bzk.O00000o.findViewById(R.id.buy_confirm_cod_switch_to_img);
            bzk.O0000o0O.setOnClickListener(bzk);
            bzk.O0000o0 = (CommonButton) bzk.O00000o.findViewById(R.id.buy_confirm_cod_phone_get_verification_code_button);
            bzk.O0000o0.setOnClickListener(bzk);
            bzk.O0000o = (CustomEditTextView) bzk.O00000o.findViewById(R.id.buy_confirm_cod_verification_code_text);
            bzk.O0000o.addTextChangedListener(bzk);
            bzk.O0000oO0 = (SimpleDraweeView) bzk.O00000o.findViewById(R.id.buy_confirm_payment_cod_pic_img_view);
            bzk.O0000oO = (CustomTextView) bzk.O00000o.findViewById(R.id.buy_confirm_payment_cod_pic_refresh_button);
            bzk.O0000oO.setOnClickListener(bzk);
            bzk.O0000oOO = (CustomTextView) bzk.O00000o.findViewById(R.id.buy_confirm_cod_switch_to_sms);
            bzk.O0000oOO.setOnClickListener(bzk);
            bzk.O0000oOo = (CustomEditTextView) bzk.O00000o.findViewById(R.id.buy_confirm_cod_vcode_text);
            bzk.O0000oOo.addTextChangedListener(bzk);
            bzk.O0000Ooo = (CustomTextView) bzk.O00000o.findViewById(R.id.buy_confirm_cod_not_support);
            this.O00000Oo.O000000o();
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f13436O000000o);
                ccr.O00000Oo("CODfragment", "onCreateView remove from parent");
            }
        }
        return this.f13436O000000o;
    }

    public final void onResume() {
        ccr.O00000Oo("CODfragment", "onResume");
        bzk bzk = this.O00000Oo;
        if (bzk != null) {
            bzk.O00000o0();
        }
        super.onResume();
    }

    public final void O000000o() {
        bzk bzk = this.O00000Oo;
        if (bzk != null) {
            bzk.O00000oo = ((ConfirmActivity) getActivity()).getOrderPaymentInfo();
            bzk.O0000O0o = cav.O00000oO(bzk.O00000oo.f4866O000000o);
            bzk.O000000o();
        }
    }
}
