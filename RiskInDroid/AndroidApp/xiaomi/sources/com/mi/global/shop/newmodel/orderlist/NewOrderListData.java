package com.mi.global.shop.newmodel.orderlist;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewOrderListData {
    @SerializedName("current_page")
    public int current_page;
    @SerializedName("ext")
    public NewExtData ext;
    @SerializedName("order_list")
    public ArrayList<NewOrderListItem> order_list = new ArrayList<>();
    @SerializedName("pagemsg")
    public NewPageMessage pagemsg;
    @SerializedName("total_count")
    public int total_count;
    @SerializedName("total_pages")
    public int total_pages;

    public static NewOrderListData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOrderListData decode(ProtoReader protoReader) throws IOException {
        NewOrderListData newOrderListData = new NewOrderListData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newOrderListData.total_pages = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 2:
                        newOrderListData.current_page = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 3:
                        newOrderListData.total_count = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 4:
                        newOrderListData.ext = NewExtData.decode(protoReader);
                        break;
                    case 5:
                        newOrderListData.order_list.add(NewOrderListItem.decode(protoReader));
                        break;
                    case 6:
                        newOrderListData.pagemsg = NewPageMessage.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newOrderListData;
            }
        }
    }
}
