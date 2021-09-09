package com.xiaomi.accountsdk.account.exception;

public class InvalidPhoneOrTicketException extends Exception {
    public InvalidPhoneOrTicketException() {
        super("wrong ticket or unactivated phone");
    }

    public InvalidPhoneOrTicketException(String str) {
        super(str);
    }
}
