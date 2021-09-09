package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewLoanApplicationResult extends BaseResult {
    @SerializedName("data")
    public LoanAgreementData data;

    public static NewLoanApplicationResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewLoanApplicationResult decode(ProtoReader protoReader) throws IOException {
        NewLoanApplicationResult newLoanApplicationResult = new NewLoanApplicationResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newLoanApplicationResult;
            } else if (nextTag == 1) {
                newLoanApplicationResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newLoanApplicationResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newLoanApplicationResult.data = LoanAgreementData.decode(protoReader);
            }
        }
    }

    public static class LoanAgreementData {
        @SerializedName("content")
        public String content;

        public static LoanAgreementData decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static LoanAgreementData decode(ProtoReader protoReader) throws IOException {
            LoanAgreementData loanAgreementData = new LoanAgreementData();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return loanAgreementData;
                } else if (nextTag != 1) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    loanAgreementData.content = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
