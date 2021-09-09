package com.xiaomi.aiot.mibeacon.logging;

abstract class AbstractAndroidLogger implements Logger {
    AbstractAndroidLogger() {
    }

    /* access modifiers changed from: protected */
    public String formatString(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }
}
