package com.xiaomi.onetrack;

import android.content.Context;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneTrack {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6081a;
    private static boolean b;
    private f c;

    public static class Event {
    }

    public interface ICommonPropertyProvider {
        Map<String, Object> getDynamicProperty(String str);
    }

    public interface IEventHook {
        boolean fillGAID(String str);
    }

    public static class Param {
    }

    public static String sdkVersion() {
        return "1.1.5";
    }

    public enum Mode {
        APP("app"),
        PLUGIN("plugin"),
        SDK("sdk");
        

        /* renamed from: a  reason: collision with root package name */
        private String f6083a;

        private Mode(String str) {
            this.f6083a = str;
        }

        public final String getType() {
            return this.f6083a;
        }
    }

    public enum UserIdType {
        XIAOMI("xiaomi"),
        PHONE_NUMBER("phone_number"),
        WEIXIN("weixin"),
        WEIBO("weibo"),
        QQ("qq"),
        OTHER("other");
        

        /* renamed from: a  reason: collision with root package name */
        private String f6085a;

        private UserIdType(String str) {
            this.f6085a = str;
        }

        public final String getUserIdType() {
            return this.f6085a;
        }
    }

    public enum NetType {
        NOT_CONNECTED("NONE"),
        MOBILE_2G("2G"),
        MOBILE_3G("3G"),
        MOBILE_4G("4G"),
        MOBILE_5G("5G"),
        WIFI("WIFI"),
        ETHERNET("ETHERNET"),
        UNKNOWN("UNKNOWN");
        

        /* renamed from: a  reason: collision with root package name */
        private String f6084a;

        private NetType(String str) {
            this.f6084a = str;
        }

        public final String toString() {
            return this.f6084a;
        }
    }

    private OneTrack(Context context, Configuration configuration) {
        a.a(context.getApplicationContext());
        this.c = new f(context, configuration);
        setEventHook(new DefaultEventHook());
    }

    public static OneTrack createInstance(Context context, Configuration configuration) {
        return new OneTrack(context, configuration);
    }

    public static void setDebugMode(boolean z) {
        q.f6178a = z;
    }

    public static void setDisable(boolean z) {
        f6081a = z;
    }

    public static boolean isDisable() {
        return f6081a;
    }

    public static void setUseSystemNetTrafficOnly() {
        b = true;
    }

    public static boolean isUseSystemNetTrafficOnly() {
        return b;
    }

    public static void setTestMode(boolean z) {
        q.c = z;
    }

    public static void registerCrashHook(Context context) {
        CrashAnalysis.a(context);
    }

    public static void setAccessNetworkEnable(Context context, final boolean z) {
        a(context);
        j.a(new Runnable() {
            /* class com.xiaomi.onetrack.OneTrack.AnonymousClass1 */

            public final void run() {
                g.a(z);
                g.b(z);
            }
        });
    }

    private static void a(Context context) {
        if (context != null) {
            a.a(context.getApplicationContext());
            return;
        }
        throw new IllegalStateException("context is null!");
    }

    public void track(String str, Map<String, Object> map) {
        this.c.a(str, map);
    }

    public void track(String str, List<String> list, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("exp_id", String.join(",", list));
        this.c.a(str, (Map<String, Object>) hashMap);
    }

    public void trackPluginEvent(String str, String str2, Map<String, Object> map) {
        this.c.a(str, str2, map);
    }

    public void login(String str, UserIdType userIdType, Map<String, Object> map, boolean z) {
        this.c.a(str, userIdType, map, z);
    }

    public void login(String str, UserIdType userIdType, Map<String, Object> map) {
        login(str, userIdType, map, false);
    }

    public void logout() {
        logout(null, false);
    }

    public void logout(Map<String, Object> map, boolean z) {
        this.c.a(map, z);
    }

    public void setCommonProperty(Map<String, Object> map) {
        this.c.c(map);
    }

    public void clearCommonProperty() {
        this.c.a();
    }

    public void removeCommonProperty(String str) {
        this.c.a(str);
    }

    public void setDynamicCommonProperty(ICommonPropertyProvider iCommonPropertyProvider) {
        this.c.a(iCommonPropertyProvider);
    }

    public void setUserProfile(Map<String, Object> map) {
        this.c.a(map);
    }

    public void setUserProfile(String str, Object obj) {
        this.c.a(str, obj);
    }

    public void userProfileIncrement(Map<String, ? extends Number> map) {
        this.c.b(map);
    }

    public void userProfileIncrement(String str, Number number) {
        this.c.a(str, number);
    }

    public void setInstanceId(String str) {
        this.c.b(str);
    }

    public String getInstanceId() throws OnMainThreadException {
        return this.c.b();
    }

    public String getOAID(Context context) throws OnMainThreadException {
        return this.c.a(context);
    }

    public void trackServiceQualityEvent(ServiceQualityEvent serviceQualityEvent) {
        this.c.a(serviceQualityEvent);
    }

    public void setEventHook(IEventHook iEventHook) {
        this.c.a(iEventHook);
    }
}
