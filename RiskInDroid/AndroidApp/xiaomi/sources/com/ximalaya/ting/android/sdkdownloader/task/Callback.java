package com.ximalaya.ting.android.sdkdownloader.task;

public interface Callback {

    public static class CancelledException extends RuntimeException {
        public CancelledException(String str) {
            super(str);
        }
    }

    public static class RemovedException extends RuntimeException {
        public RemovedException(String str) {
            super(str);
        }
    }
}
