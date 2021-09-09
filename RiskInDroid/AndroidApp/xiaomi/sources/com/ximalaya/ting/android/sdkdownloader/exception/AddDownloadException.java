package com.ximalaya.ting.android.sdkdownloader.exception;

public class AddDownloadException extends BaseRuntimeException {
    private static int BASE_CODE = 1;
    public static final int CODE_DISK_OVER;
    public static final int CODE_MAX_DOWNLOADING_COUNT;
    public static final int CODE_MAX_OVER;
    public static final int CODE_MAX_SPACE_OVER;
    public static final int CODE_NOT_FIND_TRACK;
    public static final int CODE_NO_PAY_SOUND;
    public static final int CODE_NULL = 1;
    private int code;

    static {
        int i = BASE_CODE + 1;
        BASE_CODE = i;
        CODE_MAX_OVER = i;
        int i2 = BASE_CODE + 1;
        BASE_CODE = i2;
        CODE_NOT_FIND_TRACK = i2;
        int i3 = BASE_CODE + 1;
        BASE_CODE = i3;
        CODE_MAX_DOWNLOADING_COUNT = i3;
        int i4 = BASE_CODE + 1;
        BASE_CODE = i4;
        CODE_DISK_OVER = i4;
        int i5 = BASE_CODE + 1;
        BASE_CODE = i5;
        CODE_MAX_SPACE_OVER = i5;
        int i6 = BASE_CODE + 1;
        BASE_CODE = i6;
        CODE_NO_PAY_SOUND = i6;
    }

    public AddDownloadException(int i, String str) {
        super(str);
        this.code = i;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public String toString() {
        return "AddDownloadException{code=" + this.code + " ;message = " + getMessage() + "}";
    }
}
