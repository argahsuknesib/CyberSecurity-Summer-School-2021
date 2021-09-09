package com.xiaomi.accountsdk.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegionConfig {
    private Context mAppContext;
    private SharedPreferences mSP;

    public RegionConfig(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.mSP = this.mAppContext.getSharedPreferences(XMPassport.USE_PREVIEW ? "region_config_staging" : "region_config", 0);
    }

    public Long blockingGetCheckSyncTimeout() {
        checkDownloadAndSave();
        return Long.valueOf(this.mSP.getLong("check_timeout", 10000));
    }

    public String blockingGetRegHostName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        checkDownloadAndSave();
        String string = this.mSP.getString("region_json", null);
        if (string == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(keys.next());
                if (contains(jSONObject2.optJSONArray("region.codes"), str.toString())) {
                    return jSONObject2.getString("register.domain");
                }
            }
        } catch (JSONException e) {
            AccountLog.e("RegionConfig", "JSON ERROR", e);
        }
        return null;
    }

    private boolean contains(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(jSONArray.optString(i), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkDownloadAndSave() {
        long j = this.mSP.getLong("last_download_time", 0);
        if (Math.abs(System.currentTimeMillis() - j) < this.mSP.getLong("download_interval_time", 86400000)) {
            AccountLog.d("RegionConfig", "not download twice within interval time");
            return;
        }
        try {
            saveRegionConfigJson(downloadRegionConfig());
        } catch (Exception e) {
            AccountLog.w("RegionConfig", "download region config failed", e);
        }
    }

    private String downloadRegionConfig() throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException {
        String str = URLs.URL_ACCOUNT_BASE + "/regionConfig";
        EasyMap easyPut = new EasyMap().easyPut("deviceId", new HashedDeviceIdUtil(this.mAppContext).getHashedDeviceIdNoThrow()).easyPut("_locale", XMPassportUtil.getISOLocaleString(Locale.getDefault()));
        ProtocolLogHelper.newRequestLog(str, HttpMethod.GET).cookieOrNull(easyPut).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str, null, easyPut, true);
        ProtocolLogHelper.newResponseLog(str).stringResponseOrNull(asString).log();
        if (asString != null) {
            String removeSafePrefixAndGetRealBody = XMPassport.removeSafePrefixAndGetRealBody(asString);
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody);
                if (jSONObject.getInt("code") == 0) {
                    return jSONObject.getString("data");
                }
                throw new InvalidResponseException(removeSafePrefixAndGetRealBody.toString());
            } catch (JSONException e) {
                AccountLog.e("RegionConfig", "JSON ERROR", e);
                throw new InvalidResponseException(e.getMessage());
            }
        } else {
            throw new InvalidResponseException("result content is null");
        }
    }

    private void saveRegionConfigJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("Config");
            this.mSP.edit().putLong("last_download_time", System.currentTimeMillis()).putLong("download_interval_time", jSONObject.getLong("client.update.interval") * 1000).putLong("check_timeout", jSONObject.getLong("register.check.timeout") * 1000).putString("region_json", str).commit();
        } catch (JSONException e) {
            AccountLog.e("RegionConfig", "JSON ERROR", e);
        }
    }
}
