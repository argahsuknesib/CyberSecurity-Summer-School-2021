package com.xiaomi.account.diagnosis.encrypt;

import android.util.Base64;
import android.util.Log;
import com.xiaomi.account.diagnosis.log.LogFileAppender;
import com.xiaomi.account.diagnosis.log.LogHeader;
import com.xiaomi.account.diagnosis.log.LogLevel;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.utils.PassportEnvEncryptUtils;

class EncryptLogSender {
    public static EncryptLogSender getInstance() {
        return new EncryptLogSender();
    }

    private EncryptLogSender() {
    }

    /* access modifiers changed from: package-private */
    public int printLog(int i, String str, String str2, Throwable th) {
        int println = println(i, str, generateEncryptMessageLine(str2)) + 0;
        return th != null ? println + println(i, str, generateEncryptMessageLine(Log.getStackTraceString(th))) : println;
    }

    private String generateEncryptMessageLine(String str) {
        try {
            PassportEnvEncryptUtils.O00000Oo O000000o2 = PassportEnvEncryptUtils.O000000o(str);
            return String.format("#&^%s!!%s!!%s^&#", O000000o2.O00000Oo, Base64.encodeToString(O000000o2.O00000o0, 10), O000000o2.f6348O000000o);
        } catch (PassportEnvEncryptUtils.EncryptException e) {
            AccountLog.e("EncryptLogSender", "encrypt failed: ", e);
            return str;
        }
    }

    private static int println(int i, String str, String str2) {
        String format = LogHeader.format(LogLevel.fromInt(i), str);
        LogFileAppender.appendLine(format + str2);
        return Log.println(i, str, str2);
    }
}
