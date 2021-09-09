package com.xiaomi.mico.utils;

public interface LogCallback {
    void d(String str, Throwable th);

    void d(String str, Object... objArr);

    void e(String str, Throwable th);

    void e(String str, Object... objArr);

    void i(String str, Throwable th);

    void i(String str, Object... objArr);

    void v(String str, Throwable th);

    void v(String str, Object... objArr);

    void w(String str, Throwable th);

    void w(String str, Object... objArr);
}
