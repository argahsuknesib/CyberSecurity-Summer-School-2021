package com.tutk;

public class RDTMessage {
    public byte[] data;
    public int reqId;
    public Response resp;

    public interface Response {
        void onError(int i);

        void onResponse(int i, byte[] bArr);
    }

    public RDTMessage(int i, byte[] bArr, Response response) {
        this.resp = response;
        this.reqId = i;
        this.data = bArr;
    }
}
