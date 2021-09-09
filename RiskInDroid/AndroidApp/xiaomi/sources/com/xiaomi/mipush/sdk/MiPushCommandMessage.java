package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.List;

public class MiPushCommandMessage implements PushMessageHandler.a {
    private static final long serialVersionUID = 1;
    public String category;
    public String command;
    public List<String> commandArguments;
    public String reason;
    public long resultCode;

    public String toString() {
        return "command={" + this.command + "}, resultCode={" + this.resultCode + "}, reason={" + this.reason + "}, category={" + this.category + "}, commandArguments={" + this.commandArguments + "}";
    }
}
