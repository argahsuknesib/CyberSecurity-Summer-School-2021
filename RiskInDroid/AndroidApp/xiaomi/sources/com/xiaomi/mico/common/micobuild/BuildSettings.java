package com.xiaomi.mico.common.micobuild;

import android.content.Context;
import com.xiaomi.mico.common.util.PreferenceUtils;

public class BuildSettings {
    public static final boolean IsDailyBuild = false;
    public static final boolean IsDebugBuild = false;
    public static final boolean IsDefaultChannel = true;
    public static final boolean IsDevBuild = false;
    public static final boolean IsDevDevBuild = false;
    public static final boolean IsLogableBuild = (IsDevBuild || IsDebugBuild || IsDailyBuild);
    public static final boolean IsPlayBuild = false;
    public static final boolean IsPreviewBuild = false;
    public static final boolean IsRNDebugBuild = (IsDebugBuild || IsDailyBuild);
    public static final boolean IsTestBuild = false;
    public static final boolean IsTunnelBuild = (IsDebugBuild);
    public static final boolean IsWeixinBuild;

    static {
        boolean z = true;
        if (!IsDailyBuild && !IsDebugBuild) {
            z = false;
        }
        IsWeixinBuild = z;
    }

    private static String getReleaseChannel(Context context) {
        if (IsDefaultChannel) {
            return PreferenceUtils.getSettingString(context, "build_channel", "@SHIP.TO.2A2FE0D7@");
        }
        PreferenceUtils.setSettingString(context, "build_channel", "@SHIP.TO.2A2FE0D7@");
        return "@SHIP.TO.2A2FE0D7@";
    }

    public static String getReleaseChannelNew(Context context) {
        return getReleaseChannel(context);
    }
}
