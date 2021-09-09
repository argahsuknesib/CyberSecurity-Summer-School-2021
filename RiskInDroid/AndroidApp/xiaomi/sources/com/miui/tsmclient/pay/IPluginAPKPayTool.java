package com.miui.tsmclient.pay;

public interface IPluginAPKPayTool extends IPayTool {
    void downloadPlugin();

    String getPluginName();

    String getPluginPackageName();
}
