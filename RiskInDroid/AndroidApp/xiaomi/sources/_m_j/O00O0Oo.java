package _m_j;

import O000000o.O000000o.O000000o.O00000oO.h;
import _m_j.O00oOooO;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hannto.circledialog.CircleDialog$Builder$2;
import com.hannto.circledialog.CircleDialog$Builder$3;
import com.hannto.circledialog.params.ButtonParams;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.DialogParams;
import com.hannto.circledialog.params.ItemsParams;
import com.hannto.circledialog.params.TextParams;
import com.xiaomi.smarthome.R;

public final class O00O0Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000OOo f6628O000000o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public FragmentActivity f6629O000000o;
        public O00O0Oo O00000Oo;
        public CircleParams O00000o0 = new CircleParams();

        public O000000o(FragmentActivity fragmentActivity) {
            this.f6629O000000o = fragmentActivity;
            this.O00000o0.O00000Oo = new DialogParams();
        }

        public static /* synthetic */ void O000000o(O000000o o000000o) {
            dz dzVar = o000000o.O00000o0.f4340O000000o;
            if (dzVar != null) {
                dzVar.dismiss();
                o000000o.f6629O000000o = null;
                o000000o.O00000o0.f4340O000000o = null;
            }
            CircleParams circleParams = o000000o.O00000o0;
            if (circleParams != null) {
                ButtonParams buttonParams = circleParams.O00000oo;
                if (buttonParams != null) {
                    buttonParams.O00000o0 = null;
                }
                ButtonParams buttonParams2 = o000000o.O00000o0.O00000oO;
                if (buttonParams2 != null) {
                    buttonParams2.O00000o0 = null;
                }
                ItemsParams itemsParams = o000000o.O00000o0.O0000O0o;
                if (itemsParams != null) {
                    itemsParams.O00000o0 = null;
                }
                o000000o.O00000o0 = null;
            }
            O00O0Oo o00O0Oo = o000000o.O00000Oo;
            if (o00O0Oo != null) {
                o00O0Oo.f6628O000000o = null;
                o000000o.O00000Oo = null;
            }
        }

        public final O000000o O000000o() {
            this.O00000o0.O00000Oo.O00000Oo = false;
            return this;
        }

        public final O000000o O000000o(O0000Oo o0000Oo) {
            CircleParams circleParams = this.O00000o0;
            circleParams.O0000Oo = R.layout.ht_bottom_loading_dialog;
            circleParams.O0000OoO = o0000Oo;
            return this;
        }

        public final O000000o O000000o(String str, View.OnClickListener onClickListener) {
            CircleParams circleParams = this.O00000o0;
            if (circleParams.O00000oo == null) {
                circleParams.O00000oo = new CircleDialog$Builder$2(this);
            }
            ButtonParams buttonParams = this.O00000o0.O00000oo;
            buttonParams.O0000Oo = str;
            buttonParams.O00000o0 = onClickListener;
            return this;
        }

        public final O000000o O00000Oo() {
            this.O00000o0.O00000Oo.O00000o0 = false;
            return this;
        }

        public final void O00000o() {
            DialogParams dialogParams = this.O00000o0.O00000Oo;
            if (dialogParams.f4341O000000o == 0) {
                dialogParams.f4341O000000o = 17;
            }
            CircleParams circleParams = this.O00000o0;
            if (circleParams.O00000o == null) {
                circleParams.O00000o = new TextParams();
            }
        }

        public final dz O00000o0() {
            if (this.O00000Oo == null) {
                this.O00000Oo = new O00O0Oo();
            }
            O00O0Oo o00O0Oo = this.O00000Oo;
            CircleParams circleParams = this.O00000o0;
            O000OOo o000OOo = o00O0Oo.f6628O000000o;
            if (o000OOo == null) {
                O000OOo o000OOo2 = new O000OOo();
                o000OOo2.f6617O000000o = circleParams;
                Bundle bundle = new Bundle();
                bundle.putParcelable("circle:params", circleParams);
                o000OOo2.setArguments(bundle);
                o00O0Oo.f6628O000000o = o000OOo2;
            } else if (o000OOo.getDialog() != null && o00O0Oo.f6628O000000o.getDialog().isShowing()) {
                O000o00 o000o00 = o00O0Oo.f6628O000000o.O00000Oo;
                h hVar = o000o00.O00000o0.O00000oO;
                if (!(hVar == null || hVar.f376a.O00000o == null)) {
                    hVar.post(new O000O0o0(hVar));
                }
                O00oOooO o00oOooO = o000o00.O00000o0.O00000oo;
                if (o00oOooO != null) {
                    o00oOooO.post(new O00oOooO.O000000o());
                }
                O000O0OO o000o0oo = o000o00.O00000o0.O0000O0o;
                if (o000o0oo != null) {
                    o000o0oo.O00000Oo.setMax(o000o0oo.f5255O000000o.O0000OOo);
                    o000o0oo.O00000Oo.setProgress(o000o0oo.f5255O000000o.O0000Oo0);
                    o000o0oo.O00000Oo.setSecondaryProgress(o000o0oo.f5255O000000o.O0000Oo0 + 10);
                    Handler handler = o000o0oo.O00000o0;
                    if (handler != null && !handler.hasMessages(0)) {
                        o000o0oo.O00000o0.sendEmptyMessage(0);
                    }
                }
                if (!(o000o00.O00000Oo.O00000Oo.O0000OOo == 0 || o000o00.O00000o0.O00000o0 == null)) {
                    o000o00.O00000o0.O00000o0.post(new O000o000(o000o00));
                }
            }
            O000OOo o000OOo3 = o00O0Oo.f6628O000000o;
            O00O0Oo o00O0Oo2 = this.O00000Oo;
            FragmentActivity fragmentActivity = this.f6629O000000o;
            O000OOo o000OOo4 = o00O0Oo2.f6628O000000o;
            ee supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            if (!o000OOo4.isAdded()) {
                ei O000000o2 = supportFragmentManager.O000000o();
                O000000o2.O0000Oo0 = 4097;
                O000000o2.O000000o(o000OOo4, "circleDialog");
                O000000o2.O00000o0();
            }
            return o000OOo3;
        }

        public final O000000o O00000Oo(String str, View.OnClickListener onClickListener) {
            CircleParams circleParams = this.O00000o0;
            if (circleParams.O00000oO == null) {
                circleParams.O00000oO = new CircleDialog$Builder$3(this);
            }
            ButtonParams buttonParams = this.O00000o0.O00000oO;
            buttonParams.O0000Oo = str;
            buttonParams.O00000oo = -11776948;
            buttonParams.O00000o0 = onClickListener;
            buttonParams.O0000OoO = true;
            return this;
        }
    }
}
