package com.mobikwik.sdk.lib;

import _m_j.ayt;

public enum SDKErrorCodes {
    SUCCESS("0", "Success"),
    FAILURE("1", "Transaction Failed"),
    USER_BLOCKED("20", "User blocked"),
    MERCHANT_BLOCKED("21", "Merchant Blocked"),
    MERCHANT_DOES_REGISTERED("22", "Merchant Not Registered"),
    MERCHANT_INACTIVE(ayt.f12712O000000o, "Merchant Inactive"),
    WALLET_TOPUP_FAILED("30", "Wallet Topup Failed"),
    WALLET_INSUFFICIENT_BALANCE("33", "Insufficent Balance"),
    DUPLICATE_ORDERID("50", "Duplicate order id"),
    UNEXPECTED_ERROR("99", "Unexcepted error"),
    INTERNET_NOT_WORKING("98", "Unable to connect Server"),
    INVALID_EMAIL("53", "Email id Invalid"),
    INVALID_AMOUNT("54", "Amount Invalid"),
    CHECKSUM_MISMATCH("80", "Checksum mismatch"),
    USER_DETAILS_REQUIRED("181", "Either Email or Mobile is required"),
    USER_NOT_REGISTERED_ON_CELL("159", "No Wallet Account is associated with specified cell"),
    USER_NOT_REGISTERED("120", "User does not exist"),
    INVALID_CELL("156", "Cell Invalid"),
    KYC_REACHED("111", "Your KYC limit has been reached"),
    KYC_NOT_ALLOWED("74", "KYC Transactions is not allowed"),
    INVALID_OTP("155", "Invalid OTP"),
    AUTHENTICATION_FAILURE("60", "Authentication Failed"),
    INVALID_TOKEN("198", "Invalid Token"),
    USER_CANCELLED_TRANSACTION("43", "User cancelled Transaction");
    
    private String errorCode;
    private String errorDescription;

    private SDKErrorCodes(String str, String str2) {
        this.errorCode = str;
        this.errorDescription = str2;
    }

    public static SDKErrorCodes getErrorCode(String str) {
        SDKErrorCodes[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(str)) {
                return values[i];
            }
        }
        return null;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final void updateErrorDescription(String str) {
        this.errorDescription = str;
    }
}
