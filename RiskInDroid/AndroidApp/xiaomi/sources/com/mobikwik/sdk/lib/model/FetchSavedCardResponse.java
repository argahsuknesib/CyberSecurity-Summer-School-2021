package com.mobikwik.sdk.lib.model;

import java.util.List;

public class FetchSavedCardResponse extends ApiResponse {
    List storedCards;
    String token;

    public FetchSavedCardResponse() {
    }

    public FetchSavedCardResponse(String str, String str2, String str3, Double d, String str4, List list) {
        super(str, str2, str3);
        this.storedCards = list;
        this.token = str4;
    }

    public List getStoredCards() {
        return this.storedCards;
    }

    public String getToken() {
        return this.token;
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        this.statuscode = genricApiResp.getStatuscode();
        this.status = genricApiResp.getStatus();
        this.statusdescription = genricApiResp.getStatusdescription();
        this.token = genricApiResp.getToken();
        this.storedCards = genricApiResp.getStoredCards();
    }
}
