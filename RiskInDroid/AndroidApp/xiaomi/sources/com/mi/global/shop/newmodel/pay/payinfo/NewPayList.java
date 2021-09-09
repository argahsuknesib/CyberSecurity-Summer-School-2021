package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewPayList {
    @SerializedName("cards")
    public ArrayList<String> cards = new ArrayList<>();
    @SerializedName("emi")
    public ArrayList<NewEmi> emi = new ArrayList<>();
    @SerializedName("netbank")
    public NewNetBank netbank;
    @SerializedName("wallet")
    public NewWallet wallet;

    public static NewPayList decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayList decode(ProtoReader protoReader) throws IOException {
        NewPayList newPayList = new NewPayList();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPayList;
            } else if (nextTag == 1) {
                newPayList.emi.add(NewEmi.decode(protoReader));
            } else if (nextTag == 2) {
                newPayList.cards.add(ProtoAdapter.STRING.decode(protoReader));
            } else if (nextTag == 3) {
                newPayList.netbank = NewNetBank.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPayList.wallet = NewWallet.decode(protoReader);
            }
        }
    }
}
