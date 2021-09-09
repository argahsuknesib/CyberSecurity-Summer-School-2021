package com.trello.rxlifecycle;

public class OutsideLifecycleException extends IllegalStateException {
    public OutsideLifecycleException(String str) {
        super(str);
    }
}
