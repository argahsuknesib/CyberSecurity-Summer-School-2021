package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai;

import _m_j.ftn;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Map;

public enum XiaoaiServer {
    NORMAL {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://api2.mina.mi.com");
            this.mUrlMap.put("tw", "https://tw.api2.mina.mi.com/");
            this.mSidMap.put("cn", "micoapi");
            this.mSidMap.put("tw", "micoapi_sgp");
        }
    },
    HD {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://hd.mina.mi.com");
            this.mUrlMap.put("tw", "https://tw.hd.mina.mi.com");
            this.mSidMap.put("cn", "");
            this.mSidMap.put("tw", "");
        }
    },
    PROFILE {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://userprofile.mina.mi.com");
            this.mUrlMap.put("tw", "https://tw.userprofile.mina.mi.com/");
            this.mSidMap.put("cn", "");
            this.mSidMap.put("tw", "");
        }
    },
    LBS {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://lbs.mina.mi.com");
            this.mUrlMap.put("tw", "https://tw.lbs.mina.mi.com");
            this.mSidMap.put("cn", "");
            this.mSidMap.put("tw", "");
        }
    },
    SKILLSTORE {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://skillstore.mina.mi.com");
            this.mUrlMap.put("tw", "https://tw.skillstore.mina.mi.com");
            this.mSidMap.put("cn", "");
            this.mSidMap.put("tw", "");
        }
    },
    AIFILE {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://file.ai.xiaomi.com");
            this.mUrlMap.put("tw", "https://file.ai.xiaomi.com");
            this.mSidMap.put("cn", "ai-service");
            this.mSidMap.put("tw", "ai-service");
        }
    },
    AI {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://api.ai.xiaomi.com");
            this.mUrlMap.put("tw", "https://api.ai.xiaomi.com");
            this.mSidMap.put("cn", "ai-service");
            this.mSidMap.put("tw", "ai-service");
        }
    },
    AITRAIN {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://i.ai.mi.com/mico");
            this.mUrlMap.put("tw", "https://i.ai.mi.com/mico");
            this.mSidMap.put("cn", "i.ai.mi.com");
            this.mSidMap.put("tw", "i.ai.mi.com");
        }
    },
    AITRAIN_ALIAS {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://i.ai.mi.com");
            this.mUrlMap.put("tw", "https://i.ai.mi.com");
            this.mSidMap.put("cn", "i.ai.mi.com");
            this.mSidMap.put("tw", "i.ai.mi.com");
        }
    },
    AITRAINV2 {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://i.ai.mi.com/v2/mico");
            this.mUrlMap.put("tw", "https://i.ai.mi.com/v2/mico");
            this.mSidMap.put("cn", "i.ai.mi.com");
            this.mSidMap.put("tw", "i.ai.mi.com");
        }
    },
    GRAYUPGRADE {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://api.miwifi.com/rs/grayupgrade/v2/micoiOS");
            this.mUrlMap.put("tw", "https://tw.api.miwifi.com/rs/grayupgrade/v2/micoiOS");
            this.mSidMap.put("cn", "");
            this.mSidMap.put("tw", "");
        }
    },
    HOMEALBUM {
        /* access modifiers changed from: protected */
        public final void init() {
            this.mUrlMap.put("cn", "https://display.api.mina.mi.com");
            this.mUrlMap.put("tw", "https://display.api.mina.mi.com");
            this.mSidMap.put("cn", "");
            this.mSidMap.put("tw", "");
        }
    },
    NONE {
        /* access modifiers changed from: protected */
        public final void init() {
        }
    };
    
    private String mCurAreaCode;
    protected Map<String, String> mSidMap;
    protected Map<String, String> mUrlMap;

    /* access modifiers changed from: protected */
    public abstract void init();

    public String getUrl() {
        return this.mUrlMap.get(getCurAreaCode());
    }

    public String getSid() {
        return this.mSidMap.get(getCurAreaCode());
    }

    public String getCurAreaCode() {
        if (TextUtils.isEmpty(this.mCurAreaCode)) {
            this.mCurAreaCode = ftn.O0000Oo0(CommonApplication.getAppContext()) ? "tw" : "cn";
        }
        return this.mCurAreaCode;
    }

    public static XiaoaiServer fromHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return NONE;
        }
        return valueOf(str.toUpperCase());
    }

    public static XiaoaiServer fromUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (XiaoaiServer xiaoaiServer : values()) {
                if (str.equalsIgnoreCase(xiaoaiServer.getUrl())) {
                    return xiaoaiServer;
                }
            }
        }
        return NONE;
    }
}
