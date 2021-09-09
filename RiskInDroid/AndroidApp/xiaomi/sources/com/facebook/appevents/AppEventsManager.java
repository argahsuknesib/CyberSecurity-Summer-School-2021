package com.facebook.appevents;

import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;

public class AppEventsManager {
    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() {
                /* class com.facebook.appevents.AppEventsManager.AnonymousClass1 */

                public final void onCompleted(boolean z) {
                    if (z) {
                        MetadataIndexer.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() {
                /* class com.facebook.appevents.AppEventsManager.AnonymousClass2 */

                public final void onCompleted(boolean z) {
                    if (z) {
                        RestrictiveDataManager.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() {
                /* class com.facebook.appevents.AppEventsManager.AnonymousClass3 */

                public final void onCompleted(boolean z) {
                    if (z) {
                        ModelManager.enable();
                    }
                }
            });
        }
    }
}
