package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.google.android.exoplayer2.C;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class FeatureManager {

    public interface Callback {
        void onCompleted(boolean z);
    }

    public static void checkFeature(final Feature feature, final Callback callback) {
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FetchedAppGateKeepersManager.Callback() {
            /* class com.facebook.internal.FeatureManager.AnonymousClass1 */

            public final void onCompleted() {
                callback.onCompleted(FeatureManager.isEnabled(feature));
            }
        });
    }

    public static boolean isEnabled(Feature feature) {
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return getGKStatus(feature);
        }
        if (!isEnabled(parent) || !getGKStatus(feature)) {
            return false;
        }
        return true;
    }

    private static boolean getGKStatus(Feature feature) {
        return FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeature" + feature.toString(), FacebookSdk.getApplicationId(), defaultStatus(feature));
    }

    /* renamed from: com.facebook.internal.FeatureManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$internal$FeatureManager$Feature = new int[Feature.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Instrument.ordinal()] = 2;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.CrashReport.ordinal()] = 3;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.ErrorReport.ordinal()] = 4;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.AAM.ordinal()] = 5;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.PrivacyProtection.ordinal()] = 6;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.SuggestedEvents.ordinal()] = 7;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.PIIFiltering.ordinal()] = 8;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Core.ordinal()] = 9;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.AppEvents.ordinal()] = 10;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.CodelessEvents.ordinal()] = 11;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Login.ordinal()] = 12;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Share.ordinal()] = 13;
            $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Places.ordinal()] = 14;
        }
    }

    private static boolean defaultStatus(Feature feature) {
        switch (AnonymousClass2.$SwitchMap$com$facebook$internal$FeatureManager$Feature[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return false;
            default:
                return true;
        }
    }

    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        PIIFiltering(66562),
        Instrument(131072),
        CrashReport(131328),
        ErrorReport(131584),
        Login(16777216),
        Share(33554432),
        Places(50331648);
        
        private final int code;

        private Feature(int i) {
            this.code = i;
        }

        public final String toString() {
            switch (AnonymousClass2.$SwitchMap$com$facebook$internal$FeatureManager$Feature[ordinal()]) {
                case 1:
                    return "RestrictiveDataFiltering";
                case 2:
                    return "Instrument";
                case 3:
                    return "CrashReport";
                case 4:
                    return "ErrorReport";
                case 5:
                    return "AAM";
                case 6:
                    return "PrivacyProtection";
                case 7:
                    return "SuggestedEvents";
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    return "PIIFiltering";
                case 9:
                    return "CoreKit";
                case 10:
                    return "AppEvents";
                case 11:
                    return "CodelessEvents";
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return "LoginKit";
                case 13:
                    return "ShareKit";
                case 14:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }

        static Feature fromInt(int i) {
            for (Feature feature : values()) {
                if (feature.code == i) {
                    return feature;
                }
            }
            return Unknown;
        }

        public final Feature getParent() {
            int i = this.code;
            if ((i & 255) > 0) {
                return fromInt(i & -256);
            }
            if ((65280 & i) > 0) {
                return fromInt(i & -65536);
            }
            if ((16711680 & i) > 0) {
                return fromInt(i & -16777216);
            }
            return fromInt(0);
        }
    }
}
