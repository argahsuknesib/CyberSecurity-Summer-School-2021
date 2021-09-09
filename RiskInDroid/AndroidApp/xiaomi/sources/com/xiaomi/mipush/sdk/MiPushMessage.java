package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.HashMap;
import java.util.Map;

public class MiPushMessage implements PushMessageHandler.a {
    private static final long serialVersionUID = 1;
    public String alias;
    public boolean arrived = false;
    public String category;
    public String content;
    public String description;
    public HashMap<String, String> extra = new HashMap<>();
    public boolean isNotified;
    public String messageId;
    public int messageType;
    public int notifyId;
    public int notifyType;
    public int passThrough;
    public String title;
    public String topic;
    public String userAccount;

    public final void O000000o(Map<String, String> map) {
        this.extra.clear();
        if (map != null) {
            this.extra.putAll(map);
        }
    }

    public String toString() {
        return "messageId={" + this.messageId + "},passThrough={" + this.passThrough + "},alias={" + this.alias + "},topic={" + this.topic + "},userAccount={" + this.userAccount + "},content={" + this.content + "},description={" + this.description + "},title={" + this.title + "},isNotified={" + this.isNotified + "},notifyId={" + this.notifyId + "},notifyType={" + this.notifyType + "}, category={" + this.category + "}, extra={" + this.extra + "}";
    }
}
