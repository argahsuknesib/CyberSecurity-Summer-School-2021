package com.mobikwik.sdk.lib.model;

import java.util.HashMap;

public class MbkInitPaymentResponse {
    PaymentResponseData data;
    PaymentResponseMessage message;
    Boolean success;

    public class PaymentResponseData {
        HashMap headers;
        String orderId;
        HashMap parameters;
        String postingUrl;
        Boolean redirect;

        public PaymentResponseData() {
        }

        public HashMap getHeaders() {
            return this.headers;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public HashMap getParameters() {
            return this.parameters;
        }

        public String getPostingUrl() {
            return this.postingUrl;
        }

        public Boolean getRedirect() {
            return this.redirect;
        }
    }

    public class PaymentResponseMessage {
        String statusCode;
        String text;

        public PaymentResponseMessage() {
        }

        public String getStatusCode() {
            return this.statusCode;
        }

        public String getText() {
            return this.text;
        }
    }

    public class PaymentResponseParams {
        String MD;
        String PaReq;
        String TermUrl;

        public PaymentResponseParams() {
        }

        public String getMD() {
            return this.MD;
        }

        public String getPaReq() {
            return this.PaReq;
        }

        public String getTermUrl() {
            return this.TermUrl;
        }
    }

    public PaymentResponseData getData() {
        return this.data;
    }

    public PaymentResponseMessage getMessage() {
        return this.message;
    }

    public Boolean getSuccess() {
        return this.success;
    }
}
