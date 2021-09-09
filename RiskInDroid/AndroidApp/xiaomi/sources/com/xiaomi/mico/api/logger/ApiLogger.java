package com.xiaomi.mico.api.logger;

public interface ApiLogger {
    void d(String str);

    void d(String str, Object... objArr);

    void e(String str);

    void e(String str, Object... objArr);

    void i(String str);

    void i(String str, Object... objArr);

    void v(String str);

    void v(String str, Object... objArr);

    void w(String str);

    void w(String str, Object... objArr);
}
