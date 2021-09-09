package _m_j;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.sankuai.waimai.router.annotation.RouterService;

@RouterService
public class eyn implements eyd {
    private static final eyn INSTANCE = new eyn();

    @cug
    public static eyn provideInstance() {
        return INSTANCE;
    }

    public void setAutoInitEnabled(boolean z) {
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
    }

    public String getToken() {
        try {
            return FirebaseInstanceId.getInstance().getToken();
        } catch (Exception unused) {
            return "FirebaseApp is not initialized.";
        }
    }

    public void setAnalyticsCollectionEnabled(final Context context, boolean z) {
        goq.O000000o(new Runnable() {
            /* class _m_j.eyn.AnonymousClass1 */

            public final void run() {
                try {
                    FirebaseAnalytics.getInstance(context).setAnalyticsCollectionEnabled(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
