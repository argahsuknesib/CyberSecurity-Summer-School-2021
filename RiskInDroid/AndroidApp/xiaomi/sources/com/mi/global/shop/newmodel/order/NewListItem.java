package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewListItem implements Parcelable {
    public static final Parcelable.Creator<NewListItem> CREATOR = new Parcelable.Creator<NewListItem>() {
        /* class com.mi.global.shop.newmodel.order.NewListItem.AnonymousClass1 */

        public final NewListItem createFromParcel(Parcel parcel) {
            return new NewListItem(parcel);
        }

        public final NewListItem[] newArray(int i) {
            return new NewListItem[i];
        }
    };
    @SerializedName("cart_price")
    public String cart_price;
    @SerializedName("commodity_id")
    public String commodity_id;
    @SerializedName("goods_id")
    public String goods_id;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("jump_url")
    public String jump_url;
    @SerializedName("price")
    public String price;
    @SerializedName("product_count")
    public String product_count;
    @SerializedName("product_id")
    public String product_id;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("subtotal")
    public String subtotal;

    public int describeContents() {
        return 0;
    }

    public static NewListItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewListItem decode(ProtoReader protoReader) throws IOException {
        NewListItem newListItem = new NewListItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newListItem.product_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newListItem.commodity_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newListItem.goods_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newListItem.product_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newListItem.image_url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newListItem.product_count = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newListItem.price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newListItem.subtotal = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newListItem.cart_price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newListItem.jump_url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newListItem;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.product_id);
        parcel.writeString(this.commodity_id);
        parcel.writeString(this.goods_id);
        parcel.writeString(this.product_name);
        parcel.writeString(this.image_url);
        parcel.writeString(this.product_count);
        parcel.writeString(this.price);
        parcel.writeString(this.subtotal);
        parcel.writeString(this.cart_price);
    }

    public NewListItem() {
    }

    protected NewListItem(Parcel parcel) {
        this.product_id = parcel.readString();
        this.commodity_id = parcel.readString();
        this.goods_id = parcel.readString();
        this.product_name = parcel.readString();
        this.image_url = parcel.readString();
        this.product_count = parcel.readString();
        this.price = parcel.readString();
        this.subtotal = parcel.readString();
        this.cart_price = parcel.readString();
    }
}
