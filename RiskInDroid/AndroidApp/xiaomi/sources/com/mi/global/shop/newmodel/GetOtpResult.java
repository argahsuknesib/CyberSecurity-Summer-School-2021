package com.mi.global.shop.newmodel;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class GetOtpResult extends BaseResult {
    @SerializedName("data")
    public GetOtpData data;

    public static GetOtpResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static GetOtpResult decode(ProtoReader protoReader) throws IOException {
        GetOtpResult getOtpResult = new GetOtpResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return getOtpResult;
            } else if (nextTag == 1) {
                getOtpResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                getOtpResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                getOtpResult.data = GetOtpData.decode(protoReader);
            }
        }
    }

    public static class GetOtpData {
        @SerializedName("mobileNumber")
        public String mobileNumber;
        @SerializedName("transactionCode")
        public String transactionCode;

        public static GetOtpData decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static GetOtpData decode(ProtoReader protoReader) throws IOException {
            GetOtpData getOtpData = new GetOtpData();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return getOtpData;
                } else if (nextTag == 1) {
                    getOtpData.transactionCode = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 2) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    getOtpData.mobileNumber = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
