package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewWallet {
    @SerializedName("bank")
    public String bank;
    @SerializedName("desc")
    public String desc;
    @SerializedName("mbkValide")
    public boolean mbkValide;
    @SerializedName("mobikwik_desc")
    public String mobikwik_desc;
    @SerializedName("mobikwik_img")
    public String mobikwik_img;
    @SerializedName("payu_img")
    public String payu_img;

    public static NewWallet decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewWallet decode(ProtoReader protoReader) throws IOException {
        NewWallet newWallet = new NewWallet();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newWallet.desc = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newWallet.bank = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newWallet.payu_img = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newWallet.mobikwik_img = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newWallet.mobikwik_desc = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newWallet.mbkValide = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newWallet;
            }
        }
    }
}
