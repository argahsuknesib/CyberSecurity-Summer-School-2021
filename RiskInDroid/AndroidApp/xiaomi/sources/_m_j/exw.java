package _m_j;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sankuai.waimai.router.annotation.RouterService;

@RouterService
public class exw implements hxx {
    private FirebaseAnalytics mFirebaseAnalytics;

    public void init(Context context) {
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public void report(String str, Bundle bundle) {
        FirebaseAnalytics firebaseAnalytics = this.mFirebaseAnalytics;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.logEvent(str, bundle);
        }
    }
}
