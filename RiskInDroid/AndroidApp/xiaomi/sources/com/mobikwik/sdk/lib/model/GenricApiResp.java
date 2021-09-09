package com.mobikwik.sdk.lib.model;

import com.mobikwik.sdk.lib.model.SavedCardResponse;
import java.util.ArrayList;
import java.util.List;

public class GenricApiResp {
    private Double balanceamount;
    private String cell;
    private Double debitedamount;
    private String email;
    private String name;
    private String orderid;
    private String refId;
    private String status;
    private String statuscode;
    private String statusdescription;
    private SavedCardResponse.CardDetails[] storedCards;
    private String token;

    public Double getBalanceamount() {
        return this.balanceamount;
    }

    public String getCell() {
        return this.cell;
    }

    public Double getDebitedamount() {
        return this.debitedamount;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public String getRefId() {
        return this.refId;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatuscode() {
        return this.statuscode;
    }

    public String getStatusdescription() {
        return this.statusdescription;
    }

    public List getStoredCards() {
        SavedCardResponse.CardDetails[] cardDetailsArr = this.storedCards;
        if (cardDetailsArr == null || cardDetailsArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SavedCardResponse.CardDetails add : this.storedCards) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public String getToken() {
        return this.token;
    }
}
