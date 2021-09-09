package com.mibi.sdk.network;

import android.text.TextUtils;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.exception.ServiceTokenExpiredException;
import com.mibi.sdk.common.session.Session;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceManager {
    private static String KEY_DEVICE_ID = "deviceId";

    public static void uploadDevice(Session session) throws PaymentException {
        String str;
        if (session != null) {
            synchronized (session.getLock(KEY_DEVICE_ID)) {
                if (TextUtils.isEmpty(innerGetDeviceId(session))) {
                    if (!session.isFakeAccountLoader()) {
                        str = CommonConstants.getUrl("device");
                    } else if (session.getMemoryStorage().getBoolean("isPartnerAccount")) {
                        str = CommonConstants.getUrl("/partner/device");
                    } else {
                        str = CommonConstants.getUrl("/na/device");
                    }
                    Connection createConnection = ConnectionFactory.createConnection(session.getAppContext(), session, str);
                    SortedParameter parameter = createConnection.getParameter();
                    parameter.add("la", Client.getLanguage());
                    parameter.add("co", Client.getCountry());
                    parameter.add("model", Client.getBuildModel());
                    parameter.add("device", Client.getBuildDevice());
                    parameter.add("product", Client.getBuildProduct());
                    parameter.add("manufacturer", Client.getBuildManufacturer());
                    parameter.add("brand", Client.getBuildBrand());
                    parameter.add("buildType", Client.getBuildType());
                    parameter.add("sdk", Integer.valueOf(Client.getBuildSdkVersion()));
                    parameter.add("systemVersion", Integer.valueOf(Client.getBuildSdkVersion()));
                    parameter.add("systemRelease", Client.getBuildSystemRelease());
                    parameter.add("os", Client.getOS());
                    parameter.add("miuiVersion", Client.getMiuiVersion());
                    parameter.add("miuiUiVersion", Client.getMiuiUiVersion());
                    parameter.add("miuiUiVersionCode", Integer.valueOf(Client.getMiuiUiVersionCode()));
                    parameter.add("platform", Client.getPlatform());
                    Client.DisplayInfo displayInfo = Client.getDisplayInfo();
                    parameter.add("displayResolution", displayInfo.getDisplayResolution());
                    parameter.add("displayDensity", Integer.valueOf(displayInfo.getDisplayDensity()));
                    parameter.add("screenSize", Integer.valueOf(displayInfo.getScreenSize()));
                    Client.AppInfo appInfo = Client.getAppInfo();
                    parameter.add("version", appInfo.getVersion());
                    parameter.add("package", appInfo.getPackage());
                    parameter.add("apkSign", appInfo.getSignature());
                    parameter.add("apkChannel", Client.getApkChannel());
                    parameter.add("romChannel", Client.getRomChannel());
                    parameter.add("carrier", Client.getTelephonyInfo().getSimOperator());
                    parameter.add("mac", Client.getWifiNetworkInfo().getWifiMac());
                    parameter.add("androidId", Client.getAndroidId());
                    parameter.add("xiaomiDeviceToken", Client.getXiaomiDeviceToken());
                    parameter.add("oaid", Client.getOaid());
                    JSONObject requestJSON = createConnection.requestJSON();
                    try {
                        if (requestJSON.getInt("errcode") != 1984) {
                            String string = requestJSON.getString("deviceId");
                            if (!TextUtils.isEmpty(string)) {
                                session.getMemoryStorage().put("groupGlobalSettings", KEY_DEVICE_ID, string);
                                return;
                            }
                            throw new ResultException("result has error");
                        }
                        throw new ServiceTokenExpiredException();
                    } catch (JSONException e) {
                        throw new ResultException("error code not exists", e);
                    } catch (JSONException e2) {
                        throw new ResultException(e2);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("session should not be null when upload device info.");
        }
    }

    private static String innerGetDeviceId(Session session) {
        return (String) session.getMemoryStorage().get("groupGlobalSettings", KEY_DEVICE_ID);
    }

    public static String getDeviceId(Session session) {
        String innerGetDeviceId;
        synchronized (session.getLock(KEY_DEVICE_ID)) {
            innerGetDeviceId = innerGetDeviceId(session);
        }
        return innerGetDeviceId;
    }
}
