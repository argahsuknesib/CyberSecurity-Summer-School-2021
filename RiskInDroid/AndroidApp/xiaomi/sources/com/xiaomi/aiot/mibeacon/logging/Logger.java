package com.xiaomi.aiot.mibeacon.logging;

public interface Logger {
    void d(String str, String str2, Object... objArr);

    void d(Throwable th, String str, String str2, Object... objArr);

    void e(String str, String str2, Object... objArr);

    void e(Throwable th, String str, String str2, Object... objArr);

    void i(String str, String str2, Object... objArr);

    void i(Throwable th, String str, String str2, Object... objArr);

    void v(String str, String str2, Object... objArr);

    void v(Throwable th, String str, String str2, Object... objArr);

    void w(String str, String str2, Object... objArr);

    void w(Throwable th, String str, String str2, Object... objArr);
}
