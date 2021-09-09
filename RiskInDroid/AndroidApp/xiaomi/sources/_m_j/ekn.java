package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class ekn {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Activity f15574O000000o;
    public final ekk O00000Oo;
    private final String O00000o;
    public final BroadcastReceiver O00000o0 = new BroadcastReceiver() {
        /* class _m_j.ekn.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (!"ok".equals(intent.getStringExtra("sns_result"))) {
                ekn.this.O00000Oo.onSnsLoginFailed();
            }
        }
    };

    public ekn(Activity activity, ekk ekk, String str) {
        this.f15574O000000o = activity;
        this.O00000Oo = ekk;
        this.O00000o = str;
    }

    public final void O000000o() {
        egt egt = egt.f15254O000000o;
        ((ehr) egt.O000000o("FACEBOOK_AUTH_PROVIDER")).O000000o(this.f15574O000000o, this.O00000o);
    }

    public final void O00000Oo() {
        egt egt = egt.f15254O000000o;
        ((ehr) egt.O000000o("GOOGLE_AUTH_PROVIDER")).O000000o(this.f15574O000000o, this.O00000o);
    }

    public final void O00000o0() {
        egt egt = egt.f15254O000000o;
        ((ehr) egt.O000000o("WEIBO_AUTH_PROVIDER")).O000000o(this.f15574O000000o, this.O00000o);
    }

    public final void O00000o() {
        egt egt = egt.f15254O000000o;
        ((ehr) egt.O000000o("QQ_AUTH_PROVIDER")).O000000o(this.f15574O000000o, this.O00000o);
    }

    public final void O00000oO() {
        egt egt = egt.f15254O000000o;
        ((ehr) egt.O000000o("WECHAT_AUTH_PROVIDER")).O000000o(this.f15574O000000o, this.O00000o);
    }

    public final void O000000o(ehr ehr, ehq ehq) {
        this.O00000Oo.onRequestSnsLogin(ehr, ehq);
    }
}
