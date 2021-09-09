package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPayGoBFLResult extends BaseResult {
    @SerializedName("data")
    public NewPayGoResultData data;

    public static class Params {
        @SerializedName("code")
        public String code;
        @SerializedName("msg")
        public String msg;
        @SerializedName("url")
        public String url;
    }

    public static NewPayGoBFLResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayGoBFLResult decode(ProtoReader protoReader) throws IOException {
        NewPayGoBFLResult newPayGoBFLResult = new NewPayGoBFLResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPayGoBFLResult;
            } else if (nextTag == 1) {
                newPayGoBFLResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newPayGoBFLResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPayGoBFLResult.data = NewPayGoResultData.decode(protoReader);
            }
        }
    }

    public static class NewPayGoResultData {
        @SerializedName("ext")
        public String ext;
        @SerializedName("html")
        public String html;
        @SerializedName("params")
        public String params;

        public static NewPayGoResultData decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static NewPayGoResultData decode(ProtoReader protoReader) throws IOException {
            NewPayGoResultData newPayGoResultData = new NewPayGoResultData();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return newPayGoResultData;
                } else if (nextTag == 1) {
                    newPayGoResultData.html = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    newPayGoResultData.params = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 3) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    newPayGoResultData.ext = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
