package com.mobikwik.sdk.lib;

import java.io.Serializable;

public class MKTransactionResponse implements Serializable {
    public String amount;
    public String orderId;
    public String statusCode;
    public String statusMessage;
}
