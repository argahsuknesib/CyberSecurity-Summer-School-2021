package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewEmiRate {
    @SerializedName("code")
    public String code;
    @SerializedName("desc")
    public String desc;
    @SerializedName("interest")
    public float interest;
    @SerializedName("interest_desc")
    public String interest_desc;
    @SerializedName("monthPay")
    public String monthPay;
    @SerializedName("months")
    public int months;
    @SerializedName("tips")
    public String tips;
    @SerializedName("totalInterest")
    public String totalInterest;

    public static NewEmiRate decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewEmiRate decode(ProtoReader protoReader) throws IOException {
        NewEmiRate newEmiRate = new NewEmiRate();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newEmiRate.desc = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newEmiRate.interest = ProtoAdapter.FLOAT.decode(protoReader).floatValue();
                        break;
                    case 3:
                        newEmiRate.code = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newEmiRate.months = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 5:
                        newEmiRate.totalInterest = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newEmiRate.monthPay = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newEmiRate.tips = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newEmiRate.interest_desc = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newEmiRate;
            }
        }
    }
}
