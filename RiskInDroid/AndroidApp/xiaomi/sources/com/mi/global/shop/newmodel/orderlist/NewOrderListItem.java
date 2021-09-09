package com.mi.global.shop.newmodel.orderlist;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.order.NewDeliversData;
import com.mi.global.shop.newmodel.order.NewListProduct;
import com.mi.global.shop.newmodel.order.NewOrderStatusInfo;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewOrderListItem {
    @SerializedName("add_time")
    public String add_time;
    @SerializedName("add_time_fm")
    public String add_time_fm;
    @SerializedName("consignee")
    public String consignee;
    @SerializedName("delivers")
    public ArrayList<NewDeliversData> delivers = new ArrayList<>();
    @SerializedName("difference_amount")
    public String difference_amount;
    @SerializedName("goods_amount")
    public String goods_amount;
    public boolean hasCancel;
    public boolean hasPay;
    public boolean hasRefund;
    public boolean hasSuborder;
    public boolean hasTrace;
    @SerializedName("order_flow")
    public String order_flow;
    @SerializedName("order_id")
    public String order_id;
    @SerializedName("order_status")
    public String order_status;
    @SerializedName("order_status_info")
    public NewOrderStatusInfo order_status_info;
    @SerializedName("product")
    public ArrayList<NewListProduct> product = new ArrayList<>();
    @SerializedName("show_tag")
    public String show_tag;
    @SerializedName("show_tips")
    public String show_tips;

    public static NewOrderListItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOrderListItem decode(ProtoReader protoReader) throws IOException {
        NewOrderListItem newOrderListItem = new NewOrderListItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newOrderListItem.order_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newOrderListItem.order_status = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newOrderListItem.goods_amount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newOrderListItem.add_time = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newOrderListItem.order_status_info = NewOrderStatusInfo.decode(protoReader);
                        break;
                    case 6:
                        newOrderListItem.product.add(NewListProduct.decode(protoReader));
                        break;
                    case 7:
                        newOrderListItem.order_flow = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newOrderListItem.delivers.add(NewDeliversData.decode(protoReader));
                        break;
                    case 9:
                        newOrderListItem.difference_amount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newOrderListItem.consignee = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newOrderListItem.add_time_fm = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newOrderListItem.show_tag = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 13:
                        newOrderListItem.show_tips = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newOrderListItem;
            }
        }
    }
}
