package com.mi.global.shop.buy;

import _m_j.byw;
import _m_j.cbe;
import _m_j.cbs;
import _m_j.iuh;
import _m_j.iwb;
import _m_j.ixe;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 15})
public final class BFLVerifyOTPFragment$showVerifyFailedDialog$1$convertView$1 extends Lambda implements iwb<iuh> {
    final /* synthetic */ cbs $dialogFragment;
    final /* synthetic */ byw.O0000Oo0 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BFLVerifyOTPFragment$showVerifyFailedDialog$1$convertView$1(byw.O0000Oo0 o0000Oo0, cbs cbs) {
        super(0);
        this.this$0 = o0000Oo0;
        this.$dialogFragment = cbs;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final /* synthetic */ Object invoke() {
        this.$dialogFragment.dismiss();
        cbe.O000000o("go_back_click", "OTP_verifcation", "key", this.this$0.O00000Oo);
        if (ixe.O000000o((Object) this.this$0.O00000Oo, (Object) "4") || ixe.O000000o((Object) this.this$0.O00000Oo, (Object) "2")) {
            this.this$0.f13435O000000o.O000000o();
            byw.O00000Oo(this.this$0.f13435O000000o).setVisibility(8);
            FragmentActivity activity = this.this$0.f13435O000000o.getActivity();
            if (activity != null) {
                ((ConfirmActivity) activity).onBackPressed();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.buy.ConfirmActivity");
            }
        } else if (ixe.O000000o((Object) this.this$0.O00000Oo, (Object) "1")) {
            CustomTextView O00000o0 = byw.O00000o0(this.this$0.f13435O000000o);
            FragmentActivity activity2 = this.this$0.f13435O000000o.getActivity();
            if (activity2 != null) {
                O00000o0.setTextColor(ContextCompat.O00000o0(activity2, R.color.bfl_resend_otp));
                byw.O00000o0(this.this$0.f13435O000000o).setEnabled(true);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
            }
        } else if (ixe.O000000o((Object) this.this$0.O00000Oo, (Object) "3")) {
            byw.O00000o(this.this$0.f13435O000000o).setText("");
            CustomTextView O00000o02 = byw.O00000o0(this.this$0.f13435O000000o);
            FragmentActivity activity3 = this.this$0.f13435O000000o.getActivity();
            if (activity3 != null) {
                O00000o02.setTextColor(ContextCompat.O00000o0(activity3, R.color.title_text_color));
                byw.O00000o0(this.this$0.f13435O000000o).setEnabled(false);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
            }
        }
        return iuh.f1631O000000o;
    }
}
