package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewLoanPayResult extends BaseResult {
    @SerializedName("data")
    public LoanAgreementData data;

    public static class Params {
        @SerializedName("url")
        public String url;
    }

    public static NewLoanPayResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewLoanPayResult decode(ProtoReader protoReader) throws IOException {
        NewLoanPayResult newLoanPayResult = new NewLoanPayResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newLoanPayResult;
            } else if (nextTag == 1) {
                newLoanPayResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newLoanPayResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newLoanPayResult.data = LoanAgreementData.decode(protoReader);
            }
        }
    }

    public static class LoanAgreementData {
        @SerializedName("html")
        public String html;
        @SerializedName("params")
        public String params;

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
                } else if (nextTag == 1) {
                    loanAgreementData.html = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 2) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    loanAgreementData.params = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
