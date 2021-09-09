package com.mi.global.shop.newmodel.pay.savecard;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.pay.payinfo.NewUserCardsType;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewCardsListData {
    @SerializedName("user_cards")
    public ArrayList<NewUserCardsType> user_cards = new ArrayList<>();

    public static NewCardsListData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCardsListData decode(ProtoReader protoReader) throws IOException {
        NewCardsListData newCardsListData = new NewCardsListData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCardsListData;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCardsListData.user_cards.add(NewUserCardsType.decode(protoReader));
            }
        }
    }
}
