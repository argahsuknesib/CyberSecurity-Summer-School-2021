package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class FeatureExtractor {
    private static Map<String, String> eventInfo = null;
    private static boolean initialized = false;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    FeatureExtractor() {
    }

    static void initialize(File file) {
        try {
            rules = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            rules = new JSONObject(new String(bArr, "UTF-8"));
            HashMap hashMap = new HashMap();
            languageInfo = hashMap;
            hashMap.put("ENGLISH", "1");
            languageInfo.put("GERMAN", "2");
            languageInfo.put("SPANISH", "3");
            languageInfo.put("JAPANESE", "4");
            HashMap hashMap2 = new HashMap();
            eventInfo = hashMap2;
            hashMap2.put("VIEW_CONTENT", "0");
            eventInfo.put("SEARCH", "1");
            eventInfo.put("ADD_TO_CART", "2");
            eventInfo.put("ADD_TO_WISHLIST", "3");
            eventInfo.put("INITIATE_CHECKOUT", "4");
            eventInfo.put("ADD_PAYMENT_INFO", "5");
            eventInfo.put("PURCHASE", "6");
            eventInfo.put("LEAD", "7");
            eventInfo.put("COMPLETE_REGISTRATION", "8");
            HashMap hashMap3 = new HashMap();
            textTypeInfo = hashMap3;
            hashMap3.put("BUTTON_TEXT", "1");
            textTypeInfo.put("PAGE_TITLE", "2");
            textTypeInfo.put("RESOLVED_DOCUMENT_LINK", "3");
            textTypeInfo.put("BUTTON_ID", "4");
            initialized = true;
        } catch (Exception unused) {
        }
    }

    static boolean isInitialized() {
        return initialized;
    }

    static String getTextFeature(String str, String str2, String str3) {
        return (str3 + " | " + str2 + ", " + str).toLowerCase();
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
    static float[] getDenseFeatures(JSONObject jSONObject, String str) {
        if (!initialized) {
            return null;
        }
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        try {
            String lowerCase = str.toLowerCase();
            JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
            String optString = jSONObject.optString("screenname");
            JSONArray jSONArray = new JSONArray();
            pruneTree(jSONObject2, jSONArray);
            sum(fArr, parseFeatures(jSONObject2));
            JSONObject interactedNode = getInteractedNode(jSONObject2);
            if (interactedNode == null) {
                return null;
            }
            sum(fArr, nonparseFeatures(interactedNode, jSONArray, optString, jSONObject2.toString(), lowerCase));
            return fArr;
        } catch (JSONException unused) {
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
    private static float[] parseFeatures(JSONObject jSONObject) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String lowerCase = jSONObject.optString("text").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint").toLowerCase();
        String lowerCase3 = jSONObject.optString("classname").toLowerCase();
        int optInt = jSONObject.optInt("inputtype", -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (matchIndicators(new String[]{"$", "amount", "price", "total"}, strArr)) {
            double d = (double) fArr[0];
            Double.isNaN(d);
            fArr[0] = (float) (d + 1.0d);
        }
        if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
            double d2 = (double) fArr[1];
            Double.isNaN(d2);
            fArr[1] = (float) (d2 + 1.0d);
        }
        if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
            double d3 = (double) fArr[2];
            Double.isNaN(d3);
            fArr[2] = (float) (d3 + 1.0d);
        }
        if (matchIndicators(new String[]{"search"}, strArr)) {
            double d4 = (double) fArr[4];
            Double.isNaN(d4);
            fArr[4] = (float) (d4 + 1.0d);
        }
        if (optInt >= 0) {
            double d5 = (double) fArr[5];
            Double.isNaN(d5);
            fArr[5] = (float) (d5 + 1.0d);
        }
        if (optInt == 3 || optInt == 2) {
            double d6 = (double) fArr[6];
            Double.isNaN(d6);
            fArr[6] = (float) (d6 + 1.0d);
        }
        if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            double d7 = (double) fArr[7];
            Double.isNaN(d7);
            fArr[7] = (float) (d7 + 1.0d);
        }
        if (lowerCase3.contains("checkbox")) {
            double d8 = (double) fArr[8];
            Double.isNaN(d8);
            fArr[8] = (float) (d8 + 1.0d);
        }
        if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
            double d9 = (double) fArr[10];
            Double.isNaN(d9);
            fArr[10] = (float) (d9 + 1.0d);
        }
        if (lowerCase3.contains("radio") && lowerCase3.contains("button")) {
            double d10 = (double) fArr[12];
            Double.isNaN(d10);
            fArr[12] = (float) (d10 + 1.0d);
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                sum(fArr, parseFeatures(optJSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
        return fArr;
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
    private static float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float[] fArr = new float[30];
        float f = 0.0f;
        Arrays.fill(fArr, 0.0f);
        int length = jSONArray.length();
        int i = 0;
        fArr[3] = (float) (length > 1 ? length - 1 : 0);
        while (i < jSONArray.length()) {
            try {
                if (isButton(jSONArray.getJSONObject(i))) {
                    fArr[9] = fArr[9] + 1.0f;
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        String str4 = str + '|' + str3;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        updateHintAndTextRecursively(jSONObject, sb, sb2);
        String sb3 = sb.toString();
        String sb4 = sb2.toString();
        fArr[15] = regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
        fArr[16] = regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        fArr[17] = regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_ID", sb3) ? 1.0f : 0.0f;
        fArr[18] = str2.contains("password") ? 1.0f : 0.0f;
        fArr[19] = regexMatched("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str2) ? 1.0f : 0.0f;
        fArr[20] = regexMatched("(?i)(sign in)|login|signIn", str2) ? 1.0f : 0.0f;
        fArr[21] = regexMatched("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str2) ? 1.0f : 0.0f;
        fArr[22] = regexMatched("ENGLISH", "PURCHASE", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
        fArr[24] = regexMatched("ENGLISH", "PURCHASE", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        fArr[25] = regexMatched("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", sb4) ? 1.0f : 0.0f;
        fArr[27] = regexMatched("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", str4) ? 1.0f : 0.0f;
        fArr[28] = regexMatched("ENGLISH", "LEAD", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
        if (regexMatched("ENGLISH", "LEAD", "PAGE_TITLE", str4)) {
            f = 1.0f;
        }
        fArr[29] = f;
        return fArr;
    }

    private static boolean regexMatched(String str, String str2, String str3, String str4) {
        return regexMatched(rules.optJSONObject("rulesForLanguage").optJSONObject(languageInfo.get(str)).optJSONObject("rulesForEvent").optJSONObject(eventInfo.get(str2)).optJSONObject("positiveRules").optString(textTypeInfo.get(str3)), str4);
    }

    private static boolean regexMatched(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }

    private static boolean matchIndicators(String[] strArr, String[] strArr2) {
        for (String str : strArr) {
            for (String contains : strArr2) {
                if (contains.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    z = false;
                    z2 = false;
                    break;
                } else if (optJSONArray.getJSONObject(i).optBoolean("is_interacted")) {
                    z = true;
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    jSONArray.put(optJSONArray.getJSONObject(i2));
                }
            } else {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (pruneTree(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z2 = true;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static void sum(float[] fArr, float[] fArr2) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] + fArr2[i];
        }
    }

    private static boolean isButton(JSONObject jSONObject) {
        return (jSONObject.optInt("classtypebitmask") & 32) > 0;
    }

    private static void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        String lowerCase = jSONObject.optString("text", "").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint", "").toLowerCase();
        if (!lowerCase.isEmpty()) {
            sb.append(lowerCase);
            sb.append(" ");
        }
        if (!lowerCase2.isEmpty()) {
            sb2.append(lowerCase2);
            sb2.append(" ");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                updateHintAndTextRecursively(jSONObject, sb, sb2);
            }
        }
    }

    private static JSONObject getInteractedNode(JSONObject jSONObject) {
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            if (optJSONArray == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject interactedNode = getInteractedNode(optJSONArray.getJSONObject(i));
                if (interactedNode != null) {
                    return interactedNode;
                }
            }
            return null;
        } catch (JSONException unused) {
        }
    }
}
