package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FacebookRequestErrorClassification {
    private static FacebookRequestErrorClassification defaultInstance;
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    private final String loginRecoverableRecoveryMessage;
    private final Map<Integer, Set<Integer>> otherErrors;
    private final String otherRecoveryMessage;
    private final Map<Integer, Set<Integer>> transientErrors;
    private final String transientRecoveryMessage;

    FacebookRequestErrorClassification(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }

    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    /* renamed from: com.facebook.internal.FacebookRequestErrorClassification$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$FacebookRequestError$Category = new int[FacebookRequestError.Category.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$facebook$FacebookRequestError$Category[FacebookRequestError.Category.OTHER.ordinal()] = 1;
            $SwitchMap$com$facebook$FacebookRequestError$Category[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
            try {
                $SwitchMap$com$facebook$FacebookRequestError$Category[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final String getRecoveryMessage(FacebookRequestError.Category category) {
        int i = AnonymousClass3.$SwitchMap$com$facebook$FacebookRequestError$Category[category.ordinal()];
        if (i == 1) {
            return this.otherRecoveryMessage;
        }
        if (i == 2) {
            return this.loginRecoverableRecoveryMessage;
        }
        if (i != 3) {
            return null;
        }
        return this.transientRecoveryMessage;
    }

    public final FacebookRequestError.Category classify(int i, int i2, boolean z) {
        Set set;
        Set set2;
        Set set3;
        if (z) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.otherErrors;
        if (map != null && map.containsKey(Integer.valueOf(i)) && ((set3 = this.otherErrors.get(Integer.valueOf(i))) == null || set3.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.loginRecoverableErrors;
        if (map2 != null && map2.containsKey(Integer.valueOf(i)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(i))) == null || set2.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.transientErrors;
        if (map3 == null || !map3.containsKey(Integer.valueOf(i)) || ((set = this.transientErrors.get(Integer.valueOf(i))) != null && !set.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.OTHER;
        }
        return FacebookRequestError.Category.TRANSIENT;
    }

    public static synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            if (defaultInstance == null) {
                defaultInstance = getDefaultErrorClassificationImpl();
            }
            facebookRequestErrorClassification = defaultInstance;
        }
        return facebookRequestErrorClassification;
    }

    private static FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
        return new FacebookRequestErrorClassification(null, new HashMap<Integer, Set<Integer>>() {
            /* class com.facebook.internal.FacebookRequestErrorClassification.AnonymousClass1 */

            {
                put(2, null);
                put(4, null);
                put(9, null);
                put(17, null);
                put(341, null);
            }
        }, new HashMap<Integer, Set<Integer>>() {
            /* class com.facebook.internal.FacebookRequestErrorClassification.AnonymousClass2 */

            {
                put(102, null);
                put(190, null);
                put(412, null);
            }
        }, null, null, null);
    }

    private static Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject jSONObject) {
        int optInt;
        HashSet hashSet;
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optInt = optJSONObject.optInt("code")) == 0)) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    hashSet = null;
                } else {
                    hashSet = new HashSet();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        int optInt2 = optJSONArray2.optInt(i2);
                        if (optInt2 != 0) {
                            hashSet.add(Integer.valueOf(optInt2));
                        }
                    }
                }
                hashMap.put(Integer.valueOf(optInt), hashSet);
            }
        }
        return hashMap;
    }

    public static FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
        String optString;
        if (jSONArray == null) {
            return null;
        }
        Map<Integer, Set<Integer>> map = null;
        Map<Integer, Set<Integer>> map2 = null;
        Map<Integer, Set<Integer>> map3 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                if (optString.equalsIgnoreCase("other")) {
                    str = optJSONObject.optString("recovery_message", null);
                    map = parseJSONDefinition(optJSONObject);
                } else if (optString.equalsIgnoreCase("transient")) {
                    str2 = optJSONObject.optString("recovery_message", null);
                    map2 = parseJSONDefinition(optJSONObject);
                } else if (optString.equalsIgnoreCase("login_recoverable")) {
                    str3 = optJSONObject.optString("recovery_message", null);
                    map3 = parseJSONDefinition(optJSONObject);
                }
            }
        }
        return new FacebookRequestErrorClassification(map, map2, map3, str, str2, str3);
    }
}
