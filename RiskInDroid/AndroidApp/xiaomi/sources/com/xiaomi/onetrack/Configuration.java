package com.xiaomi.onetrack;

import android.text.TextUtils;
import com.xiaomi.onetrack.OneTrack;

public class Configuration {

    /* renamed from: a  reason: collision with root package name */
    private String f6076a;
    private String b;
    private String c;
    private boolean d;
    private String e;
    private OneTrack.Mode f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private String m;
    private OneTrack.IEventHook n;

    private Configuration(Builder builder) {
        this.f = OneTrack.Mode.APP;
        this.g = true;
        this.h = true;
        this.i = true;
        this.k = true;
        this.l = false;
        this.f6076a = builder.f6077a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.i = builder.i;
        this.h = builder.h;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
    }

    public String getAppId() {
        return this.f6076a;
    }

    public String getPluginId() {
        return this.b;
    }

    public String getChannel() {
        return this.c;
    }

    public boolean isInternational() {
        return this.d;
    }

    public String getRegion() {
        return this.e;
    }

    public OneTrack.Mode getMode() {
        return this.f;
    }

    @Deprecated
    public boolean isGAIDEnable() {
        return this.g;
    }

    public boolean isExceptionCatcherEnable() {
        return this.j;
    }

    public boolean isIMSIEnable() {
        return this.h;
    }

    public boolean isIMEIEnable() {
        return this.i;
    }

    public boolean isAutoTrackActivityAction() {
        return this.k;
    }

    public boolean isOverrideMiuiRegionSetting() {
        return this.l;
    }

    public String getInstanceId() {
        return this.m;
    }

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f6077a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public OneTrack.Mode f = OneTrack.Mode.APP;
        /* access modifiers changed from: private */
        public boolean g = true;
        /* access modifiers changed from: private */
        public boolean h = true;
        /* access modifiers changed from: private */
        public boolean i = true;
        /* access modifiers changed from: private */
        public boolean j = false;
        /* access modifiers changed from: private */
        public boolean k = true;
        /* access modifiers changed from: private */
        public boolean l = false;
        /* access modifiers changed from: private */
        public String m;

        public Builder setAppId(String str) {
            this.f6077a = str;
            return this;
        }

        public Builder setPluginId(String str) {
            this.b = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.c = str;
            return this;
        }

        public Builder setInternational(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setRegion(String str) {
            this.e = str;
            return this;
        }

        public Builder setMode(OneTrack.Mode mode) {
            this.f = mode;
            return this;
        }

        @Deprecated
        public Builder setGAIDEnable(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setImeiEnable(boolean z) {
            this.i = z;
            return this;
        }

        public Builder setImsiEnable(boolean z) {
            this.h = z;
            return this;
        }

        public Builder setExceptionCatcherEnable(boolean z) {
            this.j = z;
            return this;
        }

        public Builder setAutoTrackActivityAction(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setOverrideMiuiRegionSetting(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setInstanceId(String str) {
            this.m = str;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }

    public String toString() {
        try {
            return "Configuration{appId='" + a(this.f6076a) + '\'' + ", pluginId='" + a(this.b) + '\'' + ", channel='" + this.c + '\'' + ", international=" + this.d + ", region='" + this.e + '\'' + ", overrideMiuiRegionSetting=" + this.l + ", mode=" + this.f + ", GAIDEnable=" + this.g + ", IMSIEnable=" + this.h + ", IMEIEnable=" + this.i + ", ExceptionCatcherEnable=" + this.j + ", instanceId=" + a(this.m) + '}';
        } catch (Exception unused) {
            return "";
        }
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            sb.append(str);
        } else {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (i2 == 0 || i2 == 1 || i2 == str.length() - 2 || i2 == str.length() - 1) {
                    sb.append(str.charAt(i2));
                } else {
                    sb.append("*");
                }
            }
        }
        return sb.toString();
    }
}
