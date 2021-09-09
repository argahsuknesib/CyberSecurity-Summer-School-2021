package com.mobikwik.sdk.lib.model;

import java.io.Serializable;

public class SavedCardResponse implements Serializable {
    public String buyerEmail;
    public CardDetails[] cards;
    public String responseCode;
    public String responseDescription;

    public static class CardDetails implements Serializable {
        public String cardAlias;
        public String cardId;
        public String cardType;
        public String first4;
        public String formattedCardNum;
        public String last4;

        public String toString() {
            return this.formattedCardNum;
        }
    }
}
