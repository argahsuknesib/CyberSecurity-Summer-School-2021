package com.miui.tsmclientsdk;

public interface MiTsmCallback {
    void onFail(int i, String str, Object... objArr);

    void onSuccess(int i, Object... objArr);
}
