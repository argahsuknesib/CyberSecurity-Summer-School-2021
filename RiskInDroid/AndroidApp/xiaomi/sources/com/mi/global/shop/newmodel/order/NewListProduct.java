package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewListProduct implements Parcelable {
    public static final Parcelable.Creator<NewListProduct> CREATOR = new Parcelable.Creator<NewListProduct>() {
        /* class com.mi.global.shop.newmodel.order.NewListProduct.AnonymousClass1 */

        public final NewListProduct createFromParcel(Parcel parcel) {
            return new NewListProduct(parcel);
        }

        public final NewListProduct[] newArray(int i) {
            return new NewListProduct[i];
        }
    };
    @SerializedName("cart_price")
    public String cart_price;
    @SerializedName("commodity_id")
    public String commodity_id;
    @SerializedName("extentions")
    public NewExtentions extentions;
    @SerializedName("goods_id")
    public String goods_id;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("jump_url")
    public String jump_url;
    @SerializedName("list")
    public ArrayList<NewListItem> list = new ArrayList<>();
    @SerializedName("price_txt")
    public String price_txt;
    @SerializedName("product_count")
    public String product_count;
    @SerializedName("product_id")
    public String product_id;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("subtotal_txt")
    public String subtotal_txt;

    public int describeContents() {
        return 0;
    }

    public static NewListProduct decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewListProduct decode(ProtoReader protoReader) throws IOException {
        NewListProduct newListProduct = new NewListProduct();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newListProduct.goods_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newListProduct.product_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newListProduct.image_url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newListProduct.product_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newListProduct.cart_price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newListProduct.product_count = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newListProduct.price_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newListProduct.subtotal_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newListProduct.extentions = NewExtentions.decode(protoReader);
                        break;
                    case 10:
                        newListProduct.list.add(NewListItem.decode(protoReader));
                        break;
                    case 11:
                        newListProduct.commodity_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newListProduct.jump_url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newListProduct;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.goods_id);
        parcel.writeString(this.product_id);
        parcel.writeString(this.image_url);
        parcel.writeString(this.product_name);
        parcel.writeString(this.cart_price);
        parcel.writeString(this.product_count);
        parcel.writeString(this.price_txt);
        parcel.writeString(this.subtotal_txt);
        parcel.writeParcelable(this.extentions, i);
        parcel.writeTypedList(this.list);
        parcel.writeString(this.commodity_id);
    }

    public NewListProduct() {
    }

    protected NewListProduct(Parcel parcel) {
        this.goods_id = parcel.readString();
        this.product_id = parcel.readString();
        this.image_url = parcel.readString();
        this.product_name = parcel.readString();
        this.cart_price = parcel.readString();
        this.product_count = parcel.readString();
        this.price_txt = parcel.readString();
        this.subtotal_txt = parcel.readString();
        this.extentions = (NewExtentions) parcel.readParcelable(NewExtentions.class.getClassLoader());
        this.list = parcel.createTypedArrayList(NewListItem.CREATOR);
        this.commodity_id = parcel.readString();
    }
}
