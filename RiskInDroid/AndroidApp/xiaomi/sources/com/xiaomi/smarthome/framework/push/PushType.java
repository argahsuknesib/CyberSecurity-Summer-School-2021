package com.xiaomi.smarthome.framework.push;

public enum PushType {
    SHARE("share"),
    SCENE("scene"),
    ADS("adv"),
    SHOP("shop"),
    DEVICE("device"),
    DEVICE_CONNECTED("device_connect"),
    ADD_RELATION("addRelation"),
    ADD_RELATION_MSG("addRelation_message"),
    ACCEPT_RELATION("acceptRelation"),
    ACCEPT_RELATION_MSG("acceptRelation_message"),
    DENY_RELATION("denyRelation"),
    DENY_RELATION_MSG("denyRelation_message"),
    REVOKE_RELATION("revokeRelation"),
    REVOKE_RELATION_MSG("revokeRelation_Message"),
    COMMON("common"),
    THIRDPARTYAPI("third_api"),
    DEVICE_BATCH("device_batch"),
    HOME_MEMBER("home_member"),
    VOICE_CTRL_MSG("voicectrl_msg"),
    USER_BANNER_PROP("user_banner_prop"),
    SCENE_STATUS("user_scene_switch_changed"),
    DEVICE_NEW("device_new"),
    AIOT_BIND("aiot-bind"),
    INNER_JUMP("inner_jump");
    
    private String mValue;

    private PushType(String str) {
        this.mValue = str;
    }

    public final String getValue() {
        return this.mValue;
    }
}
