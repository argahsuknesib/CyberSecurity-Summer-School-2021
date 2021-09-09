package _m_j;

import _m_j.hja;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;

@RouterService
public class hjb implements gte {
    public void onAppDestroy(Application application) {
    }

    public void onDestroy(FragmentActivity fragmentActivity) {
    }

    static /* synthetic */ void lambda$onCreate$0(FragmentActivity fragmentActivity) {
        hja.O000000o o000000o = hja.f18973O000000o;
        ixe.O00000o(fragmentActivity, "activity");
        if (hja.O000000o.O000000o()) {
            hja.O000000o.O00000o0(fragmentActivity);
        }
    }

    public void onCreate(FragmentActivity fragmentActivity) {
        CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class _m_j.$$Lambda$hjb$PJ6VeWHpGMYopgncOHFAh1D5XQ */

            public final void run() {
                hjb.lambda$onCreate$0(FragmentActivity.this);
            }
        }, 1500);
    }
}
