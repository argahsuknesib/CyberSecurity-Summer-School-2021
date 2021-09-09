package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewUserCardsType {
    @SerializedName("card_brand")
    public String card_brand;
    @SerializedName("card_mode")
    public String card_mode;
    @SerializedName("card_name")
    public String card_name;
    @SerializedName("card_no")
    public String card_no;
    @SerializedName("card_token")
    public String card_token;
    @SerializedName("card_type")
    public String card_type;
    public boolean expand = false;
    @SerializedName("expiry_month")
    public String expiry_month;
    @SerializedName("expiry_year")
    public String expiry_year;
    @SerializedName("name_on_card")
    public String name_on_card;

    public static NewUserCardsType decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewUserCardsType decode(ProtoReader protoReader) throws IOException {
        NewUserCardsType newUserCardsType = new NewUserCardsType();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newUserCardsType.card_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newUserCardsType.card_type = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newUserCardsType.card_token = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newUserCardsType.expiry_year = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newUserCardsType.expiry_month = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newUserCardsType.name_on_card = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newUserCardsType.card_no = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newUserCardsType.card_mode = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newUserCardsType.card_brand = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newUserCardsType;
            }
        }
    }
}
