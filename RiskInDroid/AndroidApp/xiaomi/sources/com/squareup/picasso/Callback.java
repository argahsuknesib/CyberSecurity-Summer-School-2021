package com.squareup.picasso;

public interface Callback {

    public static class EmptyCallback implements Callback {
        public void onError(Exception exc) {
        }

        public void onSuccess() {
        }
    }

    void onError(Exception exc);

    void onSuccess();
}
