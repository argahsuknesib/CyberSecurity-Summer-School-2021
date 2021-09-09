package com.xiaomi.smarthome.frame.plugin.pluginhook.config;

import _m_j.fcx;
import _m_j.gfr;
import _m_j.gpv;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.gsy;
import _m_j.hte;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.frame.plugin.pluginhook.IEnvCallback;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Response;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class DNSHookConfigManager {
    private static volatile DNSHookConfigManager sInstance;
    private volatile boolean enabled = false;
    private IEnvCallback envCallback;
    private volatile boolean inited = false;
    public AtomicBoolean mSynchronizing = new AtomicBoolean(false);
    private volatile int minAppVer = 0;
    StringBuffer tmpBuf = new StringBuffer();
    private final Set<String> whiteListSet = new HashSet();

    private DNSHookConfigManager() {
        init();
    }

    public static DNSHookConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (DNSHookConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new DNSHookConfigManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isInWhiteList(String str) {
        gsy.O00000Oo(LogType.PLUGIN, "DNSHookConfigManager", "enabled=" + this.enabled + ",minAppVer=" + this.minAppVer);
        if (gfr.O0000OOo || gfr.O0000Ooo || gfr.O0000Oo || gfr.O0000o00) {
            gsy.O00000o0(LogType.PLUGIN, "DNSHookConfigManager", "isInWhiteList:" + str + ",whiteListSet:" + this.whiteListSet.size() + ",enabled=" + this.enabled + ",minAppVer=" + this.minAppVer);
            gsy.O000000o(6, "DNSHookConfigManager", "isInWhiteList:" + str + ",whiteListSet:" + this.whiteListSet.size() + ",enabled=" + this.enabled + ",minAppVer=" + this.minAppVer);
        }
        if (!this.enabled || gfr.O00000oO < this.minAppVer) {
            return true;
        }
        if (this.whiteListSet.isEmpty()) {
            init();
        }
        if (this.whiteListSet.isEmpty()) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.whiteListSet.contains(str) || this.whiteListSet.contains("*.".concat(String.valueOf(str)))) {
            return true;
        }
        String[] split = str.split("\\.");
        for (int length = split.length - 2; length > 0; length--) {
            this.tmpBuf.setLength(0);
            for (int i = length; i <= split.length - 1; i++) {
                this.tmpBuf.append("." + split[i]);
            }
            if (this.whiteListSet.contains("*" + this.tmpBuf.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumericHost(String str) {
        return InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str) || "localhost".equals(str);
    }

    private synchronized void init() {
        if (!this.inited) {
            this.inited = true;
            try {
                String O000000o2 = gpv.O000000o(CommonApplication.getAppContext().getSharedPreferences("plugin_dns_conf", 0), "plugin_dns_conf", "{}");
                LogType logType = LogType.PLUGIN;
                gsy.O00000o0(logType, "DNSHookConfigManager", "init " + O000000o2 + ",pid=" + Process.myPid());
                populateFromJSON(new JSONObject(O000000o2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getRemoteConfig() {
        gsy.O00000Oo("DNSHookConfigManager", "getRemoteConfig");
        if (!this.mSynchronizing.getAndSet(true)) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lang", "zh_CN");
                StringBuilder sb = new StringBuilder("plugin_dns_config");
                boolean z = gfr.O0000oo0;
                sb.append("_preview");
                jSONObject.put("name", sb.toString());
                jSONObject.put("version", "1");
            } catch (Exception unused) {
                this.mSynchronizing.set(false);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            gsj gsj = null;
            try {
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsj = o000000o.O00000Oo(buildUrl(jSONObject)).O000000o();
            } catch (UnsupportedEncodingException e) {
                this.mSynchronizing.set(false);
                e.printStackTrace();
            }
            if (gsj == null) {
                this.mSynchronizing.set(false);
            } else {
                gsg.O00000Oo(gsj, new gsl() {
                    /* class com.xiaomi.smarthome.frame.plugin.pluginhook.config.DNSHookConfigManager.AnonymousClass1 */

                    public void onFailure(gsf gsf, Exception exc, Response response) {
                    }

                    public void onSuccess(Object obj, Response response) {
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: org.json.JSONObject} */
                    /* JADX WARNING: Multi-variable type inference failed */
                    public void processResponse(Response response) {
                        try {
                            String string = response.body().string();
                            if (gfr.O0000OOo) {
                                gsy.O000000o(6, "DNSHookConfigManager", "getRemoteConfig  result:".concat(String.valueOf(string)));
                            }
                            gsy.O00000Oo(LogType.PLUGIN, "DNSHookConfigManager", "getRemoteConfig  result".concat(String.valueOf(string)));
                            JSONObject jSONObject = new JSONObject(string);
                            if (jSONObject.isNull("result")) {
                                DNSHookConfigManager.this.mSynchronizing.set(false);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (optJSONObject.isNull("content")) {
                                DNSHookConfigManager.this.mSynchronizing.set(false);
                                return;
                            }
                            JSONObject jSONObject2 = null;
                            Object obj = optJSONObject.get("content");
                            if (obj instanceof JSONObject) {
                                jSONObject2 = obj;
                            } else if (obj instanceof String) {
                                jSONObject2 = new JSONObject((String) obj);
                            }
                            DNSHookConfigManager.this.savePluginDnsConfig(jSONObject2);
                            DNSHookConfigManager.this.populateFromJSON(jSONObject2);
                            DNSHookConfigManager.this.mSynchronizing.set(false);
                        } catch (Exception e) {
                            LogType logType = LogType.PLUGIN;
                            gsy.O00000o0(logType, "DNSHookConfigManager", "getRemoteConfig  exception " + e.getMessage());
                            DNSHookConfigManager.this.mSynchronizing.set(false);
                            e.printStackTrace();
                        }
                    }

                    public void processFailure(Call call, IOException iOException) {
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "DNSHookConfigManager", "getRemoteConfig  processFailure " + iOException.getMessage());
                        DNSHookConfigManager.this.mSynchronizing.set(false);
                    }
                });
            }
        }
    }

    private String buildUrl(JSONObject jSONObject) throws UnsupportedEncodingException {
        return fcx.f16092O000000o.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
    }

    public void savePluginDnsConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            gpv.O00000Oo(CommonApplication.getAppContext().getSharedPreferences("plugin_dns_conf", 0), "plugin_dns_conf", jSONObject.toString());
        }
    }

    public void populateFromJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("plugin_dns")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("plugin_dns");
                    if (optJSONObject == null) {
                        return;
                    }
                    if (optJSONObject.has("white_list")) {
                        this.enabled = optJSONObject.optBoolean("enabled", false);
                        this.minAppVer = optJSONObject.optInt("min_app_ver_android", 0);
                        this.whiteListSet.addAll(parse(optJSONObject.optJSONArray("white_list")));
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "DNSHookConfigManager", "populateFromJSON result: enabled:" + this.enabled + ",whiteListSet size:" + this.whiteListSet.size());
                        if (!this.enabled) {
                            return;
                        }
                        if ((gfr.O0000OOo || gfr.O0000Oo) && this.whiteListSet.size() > 0) {
                            hte.O000000o(CommonApplication.getAppContext(), "Plugin Dns hook enabled", CommonApplication.getGlobalHandler());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Set<String> parse(JSONArray jSONArray) {
        String[] split;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (checkValidity(optString) && (split = optString.split("\\.")) != null && split.length > 1) {
                if (!optString.startsWith("*")) {
                    hashSet.add(optString);
                } else if (split.length > 2 && optString.indexOf(".") != -1) {
                    hashSet.add(optString);
                }
            }
        }
        return hashSet;
    }

    private static boolean checkValidity(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(".")) {
            return true;
        }
        return false;
    }

    public static void test() {
        printResult("api.io.mi.com", getInstance().isInWhiteList("api.io.mi.com"));
        printResult("account.xiaomi.com", getInstance().isInWhiteList("account.xiaomi.com"));
        printResult("xiaomi.com", getInstance().isInWhiteList("xiaomi.com"));
        printResult("baidu.com", !getInstance().isInWhiteList("baidu.com"));
        printResult("sfsaf.sdfd.mi-img.com", getInstance().isInWhiteList("sfsaf.sdfd.mi-img.com"));
        printResult("i1.miwifi.com", getInstance().isInWhiteList("i1.miwifi.com"));
        printResult("aapp.mi.com", getInstance().isInWhiteList("aapp.mi.com"));
        printResult("fds.amap.com", getInstance().isInWhiteList("fds.amap.com"));
        printResult("imilab.com", getInstance().isInWhiteList("imilab.com"));
        printResult("t.imilab.com", !getInstance().isInWhiteList("t.imilab.com"));
        printResult("amap.com", getInstance().isInWhiteList("amap.com"));
        printResult("qq.gorouter.info", getInstance().isInWhiteList("qq.gorouter.info"));
        printResult("hh.k.kkk.ximalaya.com", getInstance().isInWhiteList("hh.k.kkk.ximalaya.com"));
        printResult("xiaomiyoupin.com", getInstance().isInWhiteList("xiaomiyoupin.com"));
        printResult("2.xiaomiyoupin.com", getInstance().isInWhiteList("2.xiaomiyoupin.com"));
        printResult("i.weixin.qq.com", getInstance().isInWhiteList("i.weixin.qq.com"));
        printResult("apicn.hualaikeji.com", getInstance().isInWhiteList("apicn.hualaikeji.com"));
        printResult("t.apicn.hualaikeji.com", !getInstance().isInWhiteList("t.apicn.hualaikeji.com"));
        printResult("hualaikeji.com", !getInstance().isInWhiteList("hualaikeji.com"));
        printResult("ntp1.aliyun.com", getInstance().isInWhiteList("ntp1.aliyun.com"));
        printResult("32.aliyun.com", !getInstance().isInWhiteList("32.aliyun.com"));
        printResult("s1b.time.edu.cn", getInstance().isInWhiteList("s1b.time.edu.cn"));
        printResult("ntp1.vniiftri.ru", getInstance().isInWhiteList("ntp1.vniiftri.ru"));
        printResult("time.windows.com", getInstance().isInWhiteList("time.windows.com"));
        printResult("clock.fmt.he.net", getInstance().isInWhiteList("clock.fmt.he.net"));
        printResult("t2.timegps.net", getInstance().isInWhiteList("t2.timegps.net"));
        printResult("api.dunmitech.com", getInstance().isInWhiteList("api.dunmitech.com"));
        printResult("app-api.aqara.cn", getInstance().isInWhiteList("app-api.aqara.cn"));
        printResult("xiaomi1.com", !getInstance().isInWhiteList("xiaomi1.com"));
        printResult("xiaom.com", !getInstance().isInWhiteList("xiaom.com"));
        printResult("xiami.com", !getInstance().isInWhiteList("xiami.com"));
        printResult("41.547.87.55", !getInstance().isInWhiteList("41.547.87.55"));
        printResult("fds.account.xiaomi.com", getInstance().isInWhiteList("fds.account.xiaomi.com"));
    }

    private static void printResult(String str, boolean z) {
        if (z) {
            gsy.O000000o(3, "DNSHookConfigManager", "pass:".concat(String.valueOf(str)));
        } else {
            gsy.O000000o(6, "DNSHookConfigManager", "fail!!".concat(String.valueOf(str)));
        }
    }

    public Set<String> getWhiteListSet() {
        return this.whiteListSet;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isInited() {
        return this.inited;
    }

    public int getMinAppVer() {
        return this.minAppVer;
    }

    public boolean isInWhiteListForNonRN(String str) {
        if (fcx.f16092O000000o.O0000O0o()) {
            return true;
        }
        return isInWhiteList(str);
    }
}
