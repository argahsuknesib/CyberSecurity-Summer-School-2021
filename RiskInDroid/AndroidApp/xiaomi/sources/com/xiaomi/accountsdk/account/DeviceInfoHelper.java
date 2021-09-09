package com.xiaomi.accountsdk.account;

import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.DeviceModelInfo;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.data.PhoneInfo;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.ObjectUtils;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfoHelper {
    private static final Integer INT_0 = 0;

    public static HashMap<String, Object> getDeviceInfo(PassportInfo passportInfo, String str, List<String> list) throws IOException, AccessDeniedException, CipherException, InvalidResponseException, AuthenticationFailureException {
        if (passportInfo == null) {
            throw new IllegalArgumentException("null passportInfo");
        } else if (list == null || list.size() == 0) {
            return null;
        } else {
            String str2 = URLs.URL_DEV_SETTING;
            JSONArray jSONArray = new JSONArray();
            for (String str3 : list) {
                jSONArray.put(str3.toString());
            }
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("devId", str).easyPut("meta", jSONArray.toString());
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str2, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyPut).log();
            SimpleRequest.MapContent asMap = SecureRequestForAccount.getAsMap(str2, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str2).mapResponseOrNull(asMap).log();
            if (asMap != null) {
                Object fromBody = asMap.getFromBody("code");
                AccountLog.w("DeviceInfoHelper", "getDeviceInfo code : ".concat(String.valueOf(fromBody)));
                if (INT_0.equals(fromBody)) {
                    Object fromBody2 = asMap.getFromBody("data");
                    if (fromBody2 instanceof Map) {
                        Object obj = ((Map) fromBody2).get("settings");
                        if (obj instanceof ArrayList) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            Iterator it = ((ArrayList) obj).iterator();
                            while (it.hasNext()) {
                                HashMap hashMap2 = (HashMap) it.next();
                                hashMap.put((String) hashMap2.get("name"), hashMap2.get("value"));
                            }
                            processDevicesSettingResult(hashMap);
                            return hashMap;
                        }
                    }
                }
                throw new InvalidResponseException("failed to get device info : " + asMap.toString());
            }
            throw new IOException("failed to get device info");
        }
    }

    public static ArrayList<HashMap<String, Object>> getAllDevicesInfo(PassportInfo passportInfo, ArrayList<String> arrayList) throws IOException, AccessDeniedException, AuthenticationFailureException, CipherException, InvalidResponseException {
        if (passportInfo == null) {
            throw new IllegalArgumentException("null passportInfo");
        } else if (arrayList == null) {
            return null;
        } else {
            String str = URLs.URL_DEVICES_SETTING;
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toString());
            }
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("meta", jSONArray.toString());
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyPut).log();
            SimpleRequest.MapContent asMap = SecureRequestForAccount.getAsMap(str, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str).mapResponseOrNull(asMap).log();
            if (asMap != null) {
                Object fromBody = asMap.getFromBody("code");
                AccountLog.w("DeviceInfoHelper", "getDeviceList code : ".concat(String.valueOf(fromBody)));
                if (INT_0.equals(fromBody)) {
                    Object fromBody2 = asMap.getFromBody("data");
                    if (fromBody2 instanceof Map) {
                        Object obj = ((Map) fromBody2).get("all_device_settings");
                        if (obj instanceof ArrayList) {
                            ArrayList<HashMap<String, Object>> arrayList2 = (ArrayList) obj;
                            Iterator<HashMap<String, Object>> it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                processDevicesSettingResult(it2.next());
                            }
                            return arrayList2;
                        }
                    }
                }
                return null;
            }
            throw new IOException("failed to get devices list");
        }
    }

    private static void processDevicesSettingResult(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (hashMap.get("_phoneInfo") != null) {
                hashMap.put("_phoneInfo", processDevicePhoneInfoContent(hashMap.get("_phoneInfo").toString()));
            }
            if (!(hashMap.get("model") == null || hashMap.get("model_info") == null)) {
                hashMap.put("model_info", processDeviceModelInfoContent(hashMap.get("model").toString(), hashMap.get("model_info").toString()));
            }
            if (hashMap.get("micloudFind") != null) {
                hashMap.put("micloudFind", hashMap.get("micloudFind"));
            }
            if (hashMap.get("urlParam") != null) {
                hashMap.put("urlParam", hashMap.get("urlParam"));
            }
        }
    }

    private static ArrayList<PhoneInfo> processDevicePhoneInfoContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<PhoneInfo> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new PhoneInfo(optJSONObject.optString("simId"), optJSONObject.optString("phone")));
            }
        } catch (JSONException e) {
            AccountLog.e("DeviceInfoHelper", "setPhoneInfo", e);
        }
        return arrayList;
    }

    private static DeviceModelInfo processDeviceModelInfoContent(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        DeviceModelInfo deviceModelInfo = new DeviceModelInfo(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            deviceModelInfo.setImageUrl(jSONObject.optString("fullImageUrl"));
            JSONObject optJSONObject = jSONObject.optJSONObject(XMPassportUtil.getISOLocaleString(Locale.getDefault()));
            if (optJSONObject == null) {
                optJSONObject = jSONObject.optJSONObject("default");
            }
            if (optJSONObject != null) {
                deviceModelInfo.setModelName(optJSONObject.optString("modelName"));
                deviceModelInfo.setDefaultDeviceName(optJSONObject.optString("deviceName"));
            }
        } catch (JSONException e) {
            AccountLog.w("DeviceInfoHelper", e);
        }
        return deviceModelInfo;
    }

    @Deprecated
    public static boolean uploadDeviceInfo(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return uploadDeviceInfo(new PassportInfo(str, str2, null, str3, str4), str5, map);
    }

    public static boolean uploadDeviceInfo(PassportInfo passportInfo, String str, Map<String, Object> map) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        if (passportInfo == null || map == null) {
            throw new IllegalArgumentException("invalid parameter");
        }
        String str2 = URLs.URL_DEV_SETTING;
        JSONArray convertDevSettingValues = convertDevSettingValues(map);
        HashMap hashMap = new HashMap();
        hashMap.put("userId", passportInfo.getUserId());
        hashMap.put("devId", str);
        hashMap.put("content", convertDevSettingValues.toString());
        EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
        ProtocolLogHelper.newRequestLog(str2, HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(hashMap).log();
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str2, hashMap, passportCookie, true, passportInfo.getSecurity());
        ProtocolLogHelper.newResponseLog(str2).mapResponseOrNull(postAsMap).log();
        if (postAsMap != null) {
            Object fromBody = postAsMap.getFromBody("code");
            postAsMap.getFromBody("description");
            if (INT_0.equals(fromBody)) {
                return true;
            }
            AccountLog.d("DeviceInfoHelper", "failed upload dev name, code: ".concat(String.valueOf(fromBody)));
            return false;
        }
        throw new IOException("failed to upload device settings info");
    }

    private static JSONArray convertDevSettingValues(Map<String, Object> map) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object convertObjectToJson = ObjectUtils.convertObjectToJson(next.getValue());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("value", convertObjectToJson);
            } catch (JSONException e) {
                AccountLog.e("DeviceInfoHelper", "convertDevSettingValues", e);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static HashMap<String, DeviceModelInfo> getDeviceModelInfos(ArrayList<String> arrayList) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException {
        if (arrayList != null) {
            String str = URLs.URL_GET_DEVICE_MODEL_INFOS;
            HashMap<String, DeviceModelInfo> hashMap = new HashMap<>();
            if (arrayList.size() == 0) {
                return hashMap;
            }
            EasyMap easyPut = new EasyMap().easyPut("models", new JSONArray((Collection<?>) arrayList).toString());
            ProtocolLogHelper.newRequestLog(str, HttpMethod.GET).paramOrNull(easyPut).log();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str, easyPut, null, true);
            ProtocolLogHelper.newResponseLog(str).stringResponseOrNull(asString).log();
            if (asString != null) {
                try {
                    JSONObject jSONObject = new JSONObject(asString.getBody());
                    if (jSONObject.getInt("code") == 0) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        String iSOLocaleString = XMPassportUtil.getISOLocaleString(Locale.getDefault());
                        for (int i = 0; i < arrayList.size(); i++) {
                            String str2 = arrayList.get(i);
                            JSONObject optJSONObject = jSONObject2.optJSONObject(str2);
                            DeviceModelInfo deviceModelInfo = new DeviceModelInfo(str2);
                            deviceModelInfo.setModelName(str2);
                            if (optJSONObject != null) {
                                deviceModelInfo.setImageUrl(optJSONObject.optString("fullImageUrl"));
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject(iSOLocaleString);
                                if (optJSONObject2 == null) {
                                    optJSONObject2 = optJSONObject.optJSONObject("default");
                                }
                                if (optJSONObject2 != null) {
                                    deviceModelInfo.setDefaultDeviceName(optJSONObject2.optString("deviceName"));
                                    deviceModelInfo.setModelName(optJSONObject2.optString("modelName"));
                                }
                            }
                            hashMap.put(str2, deviceModelInfo);
                        }
                    }
                    return hashMap;
                } catch (JSONException e) {
                    AccountLog.w("DeviceInfoHelper", "fail to parse JSONObject", e);
                    throw new InvalidResponseException(asString.toString());
                }
            } else {
                throw new InvalidResponseException("failed to getModelInfos");
            }
        } else {
            throw new IllegalArgumentException("invalid parameter");
        }
    }

    private static EasyMap<String, String> getPassportCookie(PassportInfo passportInfo) {
        if (passportInfo != null) {
            EasyMap<String, String> easyPut = new EasyMap().easyPut("serviceToken", passportInfo.getServiceToken());
            if (TextUtils.isEmpty(passportInfo.getEncryptedUserId())) {
                easyPut.easyPut("userId", passportInfo.getUserId());
            } else {
                easyPut.easyPut("cUserId", passportInfo.getEncryptedUserId());
            }
            return easyPut;
        }
        throw new IllegalArgumentException("passportInfo is null");
    }
}
