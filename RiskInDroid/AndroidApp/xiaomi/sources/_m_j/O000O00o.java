package _m_j;

import O000000o.O000000o.O000000o.O00000oO.q;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

public final class O000O00o extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ q f5254O000000o;
    public final /* synthetic */ O000O0OO O00000Oo;

    public O000O00o(O000O0OO o000o0oo, q qVar) {
        this.O00000Oo = o000o0oo;
        this.f5254O000000o = qVar;
    }

    public final void handleMessage(Message message) {
        q qVar;
        String str;
        super.handleMessage(message);
        int progress = this.O00000Oo.O00000Oo.getProgress();
        String str2 = ((int) ((((float) progress) / ((float) this.O00000Oo.O00000Oo.getMax())) * 100.0f)) + "%";
        if (TextUtils.isEmpty(this.O00000Oo.f5255O000000o.O0000Oo) || !this.O00000Oo.f5255O000000o.O0000Oo.contains("%s")) {
            qVar = this.f5254O000000o;
            str = this.O00000Oo.f5255O000000o.O0000Oo + str2;
        } else {
            qVar = this.f5254O000000o;
            str = String.format(this.O00000Oo.f5255O000000o.O0000Oo, str2);
        }
        qVar.setText(str);
    }
}
