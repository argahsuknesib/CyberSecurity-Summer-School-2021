package com.wx.wheelview.common;

public class WheelViewException extends RuntimeException {
    public WheelViewException() {
    }

    public WheelViewException(String str) {
        super(str);
    }

    public WheelViewException(String str, Throwable th) {
        super(str, th);
    }

    public WheelViewException(Throwable th) {
        super(th);
    }
}
