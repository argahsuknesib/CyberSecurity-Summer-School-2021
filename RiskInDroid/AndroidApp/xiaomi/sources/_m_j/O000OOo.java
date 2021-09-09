package _m_j;

import android.content.DialogInterface;
import android.os.Bundle;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.DialogParams;

public final class O000OOo extends O000Oo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public CircleParams f6617O000000o;
    public O000o00 O00000Oo;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f6617O000000o = (CircleParams) bundle.getParcelable("circle:params");
        }
        DialogParams dialogParams = this.f6617O000000o.O00000Oo;
        this.O00000o0 = dialogParams.f4341O000000o;
        this.O00000o = dialogParams.O00000Oo;
        this.O00000oO = dialogParams.O00000o0;
        this.O00000oo = dialogParams.O00000oO;
        int[] iArr = dialogParams.O00000oo;
        if (iArr != null) {
            this.O0000O0o = new int[]{iArr[0], iArr[1], iArr[2], iArr[3]};
        }
        this.O0000OOo = dialogParams.O0000O0o;
        this.O0000Oo0 = dialogParams.O0000Oo0;
        this.O0000Oo = dialogParams.O0000Oo;
        this.O0000OoO = dialogParams.O0000OoO;
        this.O0000Ooo = dialogParams.O00000o;
        this.O0000o00 = dialogParams.O0000Ooo;
        this.O0000o0 = dialogParams.O0000o00;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f6617O000000o = null;
        this.O00000Oo = null;
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("circle:params", this.f6617O000000o);
    }
}
