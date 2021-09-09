package _m_j;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mi.global.shop.widget.CustomTextView;
import java.util.Timer;
import java.util.TimerTask;

public final class cax {

    /* renamed from: O000000o  reason: collision with root package name */
    public Activity f13574O000000o;
    public Timer O00000Oo = null;
    public long O00000o;
    public Handler O00000o0 = null;
    public String O00000oO;
    public long O00000oo;
    public long O0000O0o;
    public long O0000OOo;

    public cax(Activity activity, long j) {
        this.f13574O000000o = activity;
        this.O00000o = j;
    }

    public final void O000000o(final CustomTextView customTextView, final String str) {
        this.O00000Oo = new Timer();
        this.O00000o0 = new Handler() {
            /* class _m_j.cax.AnonymousClass1 */

            public final void handleMessage(Message message) {
                Object obj;
                Object obj2;
                Object obj3;
                if (message.what <= 0) {
                    if (cax.this.O00000Oo != null) {
                        cax.this.O00000Oo.cancel();
                    }
                    if (cax.this.f13574O000000o != null) {
                        if (!TextUtils.isEmpty(str)) {
                            cec.O000000o(cax.this.f13574O000000o, str, 3000);
                        }
                        cax.this.f13574O000000o.finish();
                    }
                }
                try {
                    cax.this.O00000oo = cax.this.O00000o / 3600;
                    cax cax = cax.this;
                    long j = cax.this.O00000o;
                    long j2 = cax.this.O00000oo;
                    Long.signum(j2);
                    cax.O0000O0o = (j - (j2 * 3600)) / 60;
                    cax.this.O0000OOo = (cax.this.O00000o - (cax.this.O00000oo * 3600)) - (cax.this.O0000O0o * 60);
                    cax cax2 = cax.this;
                    StringBuilder sb = new StringBuilder();
                    if (cax.this.O00000oo < 10) {
                        obj = "0" + cax.this.O00000oo;
                    } else {
                        obj = Long.valueOf(cax.this.O00000oo);
                    }
                    sb.append(obj);
                    sb.append(" : ");
                    if (cax.this.O0000O0o < 10) {
                        obj2 = "0" + cax.this.O0000O0o;
                    } else {
                        obj2 = Long.valueOf(cax.this.O0000O0o);
                    }
                    sb.append(obj2);
                    sb.append(" : ");
                    if (cax.this.O0000OOo < 10) {
                        obj3 = "0" + cax.this.O0000OOo;
                    } else {
                        obj3 = Long.valueOf(cax.this.O0000OOo);
                    }
                    sb.append(obj3);
                    cax2.O00000oO = sb.toString();
                    customTextView.setText(cax.this.O00000oO);
                } catch (Exception e) {
                    e.printStackTrace();
                    customTextView.setVisibility(8);
                }
            }
        };
        this.O00000Oo.schedule(new TimerTask() {
            /* class _m_j.cax.AnonymousClass2 */

            public final void run() {
                Message message = new Message();
                cax.this.O00000o--;
                if (cax.this.O00000o > 0) {
                    message.what = 1;
                } else {
                    message.what = -1;
                }
                cax.this.O00000o0.sendMessage(message);
            }
        }, 0, 1000);
    }

    public final void O000000o() {
        this.O00000Oo.cancel();
        this.O00000Oo = null;
        this.f13574O000000o = null;
    }
}
