package com.mi.global.shop.newmodel.home;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewHomeBlockInfo {
    @SerializedName("desc")
    public NewHomeBlockInfoDesc mDesc;
    @SerializedName("items")
    public ArrayList<NewHomeBlockInfoItem> mItems = new ArrayList<>();

    public static NewHomeBlockInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewHomeBlockInfo decode(ProtoReader protoReader) throws IOException {
        NewHomeBlockInfo newHomeBlockInfo = new NewHomeBlockInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newHomeBlockInfo;
            } else if (nextTag == 1) {
                newHomeBlockInfo.mItems.add(NewHomeBlockInfoItem.decode(protoReader));
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newHomeBlockInfo.mDesc = NewHomeBlockInfoDesc.decode(protoReader);
            }
        }
    }
}
