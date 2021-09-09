package com.mobikwik.sdk.lib;

import com.mobikwik.sdk.lib.payinstrument.PaymentInstrument;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1;
    private String amount;
    private String checksum;
    private String orderId;
    private PaymentInstrument payInstrument;
    private PaymentInstrumentType paymentType;
    private User user;

    public static class Factory {
        private Factory() {
        }

        public static Transaction newTransaction(User user, String str, String str2) {
            return new Transaction(user, str, str2);
        }

        public static Transaction newTransaction(User user, String str, String str2, PaymentInstrument paymentInstrument) {
            return new Transaction(user, str, str2, paymentInstrument);
        }

        public static Transaction newTransaction(User user, String str, String str2, PaymentInstrumentType paymentInstrumentType) {
            return new Transaction(user, str, str2, paymentInstrumentType);
        }

        public static Transaction newTransaction(String str, String str2) {
            return new Transaction((User) null, str, str2);
        }
    }

    private Transaction(User user2, String str, String str2) {
        this.orderId = str;
        this.amount = str2;
        this.user = user2;
    }

    private Transaction(User user2, String str, String str2, PaymentInstrument paymentInstrument) {
        this(user2, str, str2);
        this.payInstrument = paymentInstrument;
    }

    private Transaction(User user2, String str, String str2, PaymentInstrumentType paymentInstrumentType) {
        this(user2, str, str2);
        this.paymentType = paymentInstrumentType;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public PaymentInstrument getPayInstrument() {
        return this.payInstrument;
    }

    public PaymentInstrumentType getPaymentType() {
        return this.paymentType;
    }

    public User getUser() {
        return this.user;
    }

    public void setChecksum(String str) {
        this.checksum = str;
    }

    public void updateUser(User user2) {
        if (user2 != null) {
            User user3 = this.user;
            if (user3 == null) {
                this.user = new User(user2.getEmail(), user2.getCell());
                return;
            }
            user3.setEmail(user2.getEmail());
            this.user.setCell(user2.getCell());
        }
    }
}
