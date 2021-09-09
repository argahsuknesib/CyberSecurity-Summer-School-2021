package com.facebook.appevents.restrictivedatafilter;

import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public final class AddressFilterManager {
    private static boolean enabled = false;
    private static boolean isSampleEnabled = false;

    public static void enable() {
        enabled = true;
        isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureAddressDetectionSample", FacebookSdk.getApplicationId(), false);
    }

    public static void processParameters(Map<String, String> map) {
        if (enabled && map.size() != 0) {
            try {
                ArrayList<String> arrayList = new ArrayList<>(map.keySet());
                JSONObject jSONObject = new JSONObject();
                for (String str : arrayList) {
                    String str2 = map.get(str);
                    if (shouldFilterKey(str2)) {
                        map.remove(str);
                        if (!isSampleEnabled) {
                            str2 = "";
                        }
                        jSONObject.put(str, str2);
                    }
                }
                if (jSONObject.length() != 0) {
                    map.put("_onDeviceParams", jSONObject.toString());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(float[], float):void}
     arg types: [float[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void} */
    private static boolean shouldFilterKey(String str) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String predict = ModelManager.predict("DATA_DETECTION_ADDRESS", fArr, str);
        return predict != null && predict.equals("SHOULD_FILTER");
    }
}
