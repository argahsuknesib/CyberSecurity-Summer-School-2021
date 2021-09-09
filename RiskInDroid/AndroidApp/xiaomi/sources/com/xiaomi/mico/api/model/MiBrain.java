package com.xiaomi.mico.api.model;

import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class MiBrain {

    public static class OAuthInfo {
        public String accessToken;
        public String context;
        public long expireAt;
        public String providerId;
        public String providerName;
        public String refreshToken;
        public String state;
        public long userId;

        public boolean binded() {
            return "binded".equals(this.state);
        }
    }

    public class ExpressInfo {
        public String name;
        public String phone;

        public ExpressInfo() {
        }
    }

    public static class CPBindStatus implements Serializable {
        private static final long serialVersionUID = -3357915290839339889L;
        public String detailedState;
        public long expireAt;
        public String expireStatus;
        public int expiresIn;
        public String providerName;

        public String providerId() {
            if ("com.tencent.qq".equals(this.providerName)) {
                return "259021302864545792";
            }
            if ("com.tencent.weixin".equals(this.providerName)) {
                return "259021749641805824";
            }
            if ("com.kkbox".equals(this.providerName)) {
                return "347442676548767744";
            }
            return "com.tencent.openid".equals(this.providerName) ? "435808820829097984" : "";
        }

        public int willExpireDay() {
            return this.expiresIn / 86400;
        }

        public boolean isBinded() {
            return "binded".equals(this.expireStatus);
        }

        public boolean isQQMusicCP() {
            return "com.tencent.qq".equals(this.providerName) || "com.tencent.weixin".equals(this.providerName) || "com.tencent.openid".equals(this.providerName);
        }

        public boolean isKKBoxMusicCP() {
            return "com.kkbox".equals(this.providerName);
        }
    }

    public class CPAccountInfo {
        public String headImgUrl;
        public String memberLevel;
        public String nickName;

        public CPAccountInfo() {
        }
    }

    public enum KKBoxLevel {
        PLATINUM("platinum", R.string.mico_kkbox_level_platinum),
        NORMAL("normal", R.string.mico_kkbox_level_normal),
        UNKNOWN("unknown", R.string.mico_kkbox_level_unknown);
        
        String level;
        int resid;

        private KKBoxLevel(String str, int i) {
            this.level = str;
            this.resid = i;
        }

        public final int getResid() {
            return this.resid;
        }

        public static KKBoxLevel value(String str) {
            for (KKBoxLevel kKBoxLevel : values()) {
                if (str.equals(kKBoxLevel.level)) {
                    return kKBoxLevel;
                }
            }
            return UNKNOWN;
        }
    }
}
