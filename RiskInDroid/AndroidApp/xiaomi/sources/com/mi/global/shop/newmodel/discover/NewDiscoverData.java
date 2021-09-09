package com.mi.global.shop.newmodel.discover;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewDiscoverData {
    @SerializedName("currentpage")
    public int currentpage = 0;
    @SerializedName("items")
    public ArrayList<NewDiscoverListItem> items = new ArrayList<>();
    @SerializedName("totalpages")
    public long totalpages = 0;

    public static NewDiscoverData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewDiscoverData decode(ProtoReader protoReader) throws IOException {
        NewDiscoverData newDiscoverData = new NewDiscoverData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newDiscoverData;
            } else if (nextTag == 1) {
                newDiscoverData.totalpages = ProtoAdapter.INT64.decode(protoReader).longValue();
            } else if (nextTag == 2) {
                newDiscoverData.currentpage = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newDiscoverData.items.add(NewDiscoverListItem.decode(protoReader));
            }
        }
    }
}
