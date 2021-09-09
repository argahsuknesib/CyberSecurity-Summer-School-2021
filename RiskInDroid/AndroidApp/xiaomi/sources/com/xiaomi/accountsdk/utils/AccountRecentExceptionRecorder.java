package com.xiaomi.accountsdk.utils;

import java.util.LinkedList;

public class AccountRecentExceptionRecorder {
    private static volatile AccountRecentExceptionRecorder instance;
    private LinkedList<Exception> exceptionQueue = new LinkedList<>();

    private AccountRecentExceptionRecorder() {
    }

    public static AccountRecentExceptionRecorder getInstance() {
        if (instance == null) {
            synchronized (AccountRecentExceptionRecorder.class) {
                if (instance == null) {
                    instance = new AccountRecentExceptionRecorder();
                }
            }
        }
        return instance;
    }

    public synchronized void recordAccountRequestException(Exception exc) {
        if (this.exceptionQueue.size() == 10) {
            this.exceptionQueue.remove();
        }
        this.exceptionQueue.add(exc);
    }

    public synchronized LinkedList getAccountRequestExceptions() {
        return new LinkedList(this.exceptionQueue);
    }
}
