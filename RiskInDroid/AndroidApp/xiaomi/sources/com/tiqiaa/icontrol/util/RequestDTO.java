package com.tiqiaa.icontrol.util;

import _m_j.bdf;
import _m_j.bdi;
import _m_j.bdk;
import _m_j.bdl;
import android.content.Context;
import com.imi.fastjson.parser.Feature;
import com.tiqiaa.common.IJsonable;
import java.util.Locale;

@bdl(O000000o = {"sdkNumber", "partnerNumber", "data"})
public class RequestDTO extends DTO implements IJsonable {
    private static String PHONE_IMEI = null;
    private static String TIQIAA_KEY = "00000000000000000000000000000000TIQIAA";
    private static final long serialVersionUID = -4877933754225633794L;
    @bdk(O000000o = "app_version")
    private int app_version;
    @bdk(O000000o = "client_type")
    private int client_type;
    @bdk(O000000o = "data")
    private Object data;
    @bdk(O000000o = "imei")
    private String imei;
    @bdk(O000000o = "langue")
    private int langue;
    @bdk(O000000o = "locale")
    private String locale;
    @bdk(O000000o = "location_json")
    private String location_json;
    @bdk(O000000o = "package_name")
    private String package_name;
    @bdk(O000000o = "partnerNumber")
    private String partnerNumber;
    @bdk(O000000o = "sdkNumber")
    private String sdkNumber;
    @bdk(O000000o = "sdkVersion")
    private int sdkVersion;

    public RequestDTO(Context context) {
        this.sdkVersion = 9;
        this.sdkVersion = 10;
        this.sdkNumber = "0000000000000001";
        this.partnerNumber = TIQIAA_KEY;
        this.client_type = 0;
        this.imei = PHONE_IMEI;
        this.app_version = PhoneHelper.getAppVersion(context);
        this.package_name = PhoneHelper.getPackageName(context);
        this.locale = Locale.getDefault().toString();
    }

    public static void setTiqiaaKey(String str) {
        TIQIAA_KEY = str;
    }

    public static String getTiqiaaKey() {
        return TIQIAA_KEY;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(int i) {
        this.sdkVersion = i;
    }

    public int getLangue() {
        return this.langue;
    }

    public void setLangue(int i) {
        this.langue = i;
    }

    public String getSdkNumber() {
        return this.sdkNumber;
    }

    public void setSdkNumber(String str) {
        this.sdkNumber = str;
    }

    public String getPartnerNumber() {
        return this.partnerNumber;
    }

    public void setPartnerNumber(String str) {
        this.partnerNumber = str;
    }

    public String getLocation_json() {
        return this.location_json;
    }

    public void setLocation_json(String str) {
        this.location_json = str;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public int getClient_type() {
        return this.client_type;
    }

    public void setClient_type(int i) {
        this.client_type = i;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public int getApp_version() {
        return this.app_version;
    }

    public void setApp_version(int i) {
        this.app_version = i;
    }

    public <T> T getData(Class<T> cls) {
        Object obj = this.data;
        if (obj == null || obj.equals("")) {
            return null;
        }
        return bdf.O000000o(this.data.toString(), cls);
    }

    public <T> T getData(bdi<T> bdi) {
        Object obj = this.data;
        if (obj == null || obj.equals("")) {
            return null;
        }
        return bdf.O000000o(this.data.toString(), bdi, new Feature[0]);
    }

    public static RequestDTO getDTO(String str) {
        return (RequestDTO) bdf.O000000o(str, RequestDTO.class);
    }
}
