package com.xiaomi.smarthome.scene;

import java.util.HashSet;
import java.util.Set;

public final class ConstantType {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Set<String> f10552O000000o;

    static {
        HashSet hashSet = new HashSet();
        f10552O000000o = hashSet;
        hashSet.add("viomi.lock.link1");
        f10552O000000o.add("loock.lock.v5");
        f10552O000000o.add("chuangmi.lock.hmi503a01");
        f10552O000000o.add("chuangmi.lock.hmi505a01");
        f10552O000000o.add("loock.lock.v4");
        f10552O000000o.add("shjszn.lock.kx");
        f10552O000000o.add("chuangmi.lock.hmi501");
        f10552O000000o.add("lumi.lock.acn02");
        f10552O000000o.add("lumi.lock.mcn01");
        f10552O000000o.add("loock.lock.v3");
        f10552O000000o.add("loock.lock.v1");
    }

    public enum TriggerConditionType {
        CLICK("user.click"),
        DEVICE("device"),
        LOCATION_ENTER("location.enter_fence"),
        LOCATION_LEAVE("location.leave_fence"),
        CLOUD_SUNSET("cloud.sunset"),
        CLOUD_SUNRISE("cloud.sunrise"),
        CLOUD_TEMPERATURE("cloud.temperature"),
        CLOUD_HUMIDITY("cloud.humidity"),
        CLOUD_AQI("cloud.aqi"),
        TIMER("timer"),
        ANY_TIME("any.time");
        
        public final String key;

        private TriggerConditionType(String str) {
            this.key = str;
        }
    }

    public enum PayloadType {
        RPC(0),
        PUSH(1);
        
        public final int type;

        private PayloadType(int i) {
            this.type = i;
        }
    }

    public enum ValueType {
        TYPE_UNKWON(0),
        TYPE_INT(1),
        TYPE_DOUBLE(2),
        TYPE_INTERVAL(3),
        TYPE_BOOLEAN(4),
        TYPE_JSON(5),
        TYPE_STRING(6);
        
        public int type;

        private ValueType(int i) {
            this.type = i;
        }
    }

    public enum StyleType {
        DEVICE(0),
        PICKER(1),
        FENCE(2),
        SPEAKER(3),
        HIDE(4);
        
        public final int styleId;

        private StyleType(int i) {
            this.styleId = i;
        }
    }

    public enum RpcMethod {
        ACION("action"),
        PROPERTY("set_properties");
        
        public final String method;

        private RpcMethod(String str) {
            this.method = str;
        }
    }
}
