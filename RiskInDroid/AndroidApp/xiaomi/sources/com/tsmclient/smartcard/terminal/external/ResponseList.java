package com.tsmclient.smartcard.terminal.external;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ResponseList {
    @SerializedName("isSuccess")
    private boolean mIsSuccess = true;
    @SerializedName("responses")
    private List<Response> mResponses = new ArrayList();

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setFailed() {
        this.mIsSuccess = false;
    }

    public List<Response> getList() {
        return this.mResponses;
    }

    public void addResponse(Response response) {
        this.mResponses.add(response);
    }

    public static class Response {
        @SerializedName("data")
        private byte[] mData;
        @SerializedName("status")
        private byte[] mStatus;

        public Response(byte[] bArr, byte[] bArr2) {
            this.mData = bArr;
            this.mStatus = bArr2;
        }

        public byte[] getData() {
            return this.mData;
        }

        public byte[] getStatus() {
            return this.mStatus;
        }
    }
}
