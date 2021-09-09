package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCreateLoanApplicationResult extends BaseResult {
    @SerializedName("data")
    public LoanApplicationData data;

    public static NewCreateLoanApplicationResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCreateLoanApplicationResult decode(ProtoReader protoReader) throws IOException {
        NewCreateLoanApplicationResult newCreateLoanApplicationResult = new NewCreateLoanApplicationResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCreateLoanApplicationResult;
            } else if (nextTag == 1) {
                newCreateLoanApplicationResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newCreateLoanApplicationResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCreateLoanApplicationResult.data = LoanApplicationData.decode(protoReader);
            }
        }
    }

    public static class LoanApplicationData {
        @SerializedName("content")
        public String content;
        @SerializedName("result")
        public boolean result;

        public static LoanApplicationData decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static LoanApplicationData decode(ProtoReader protoReader) throws IOException {
            LoanApplicationData loanApplicationData = new LoanApplicationData();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return loanApplicationData;
                } else if (nextTag == 1) {
                    loanApplicationData.result = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                } else if (nextTag != 2) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    loanApplicationData.content = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
