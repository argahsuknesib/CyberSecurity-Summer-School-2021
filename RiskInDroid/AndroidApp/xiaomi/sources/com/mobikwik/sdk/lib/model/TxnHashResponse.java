package com.mobikwik.sdk.lib.model;

public class TxnHashResponse extends ApiResponse {
    private String txnHash;

    public TxnHashResponse(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.txnHash = str4;
    }

    public String getTxnHash() {
        return this.txnHash;
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        throw new RuntimeException("Can not be initiated from GenricApiResp");
    }

    public void setTxnHash(String str) {
        this.txnHash = str;
    }
}
