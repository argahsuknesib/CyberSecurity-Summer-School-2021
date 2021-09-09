package com.xiaomi.accountsdk.account.data;

import android.app.Application;
import com.xiaomi.accountsdk.account.XMPassportSettings;

public class EmailRegisterParams {
    public final String captCode;
    public final String captIck;
    public final String emailAddress;
    public final String password;
    public final String region;
    public final String serviceId;

    public EmailRegisterParams(Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
        this.captCode = builder.captCode;
        this.captIck = builder.captIck;
        this.region = builder.region;
        this.serviceId = builder.serviceId;
    }

    public static final class Builder {
        public String captCode;
        public String captIck;
        public String emailAddress;
        public String password;
        public String region;
        public String serviceId;

        public final Builder email(String str) {
            this.emailAddress = str;
            return this;
        }

        public final Builder password(String str) {
            this.password = str;
            return this;
        }

        public final Builder captchaCode(String str, String str2) {
            this.captCode = str;
            this.captIck = str2;
            return this;
        }

        public final Builder region(String str) {
            this.region = str;
            return this;
        }

        public final Builder application(Application application) {
            XMPassportSettings.setApplicationContext(application);
            return this;
        }

        public final Builder serviceId(String str) {
            this.serviceId = str;
            return this;
        }

        public final EmailRegisterParams build() {
            return new EmailRegisterParams(this);
        }
    }
}
