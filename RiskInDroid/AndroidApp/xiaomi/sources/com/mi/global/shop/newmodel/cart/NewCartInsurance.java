package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewCartInsurance implements Parcelable {
    public static final Parcelable.Creator<NewCartInsurance> CREATOR = new Parcelable.Creator<NewCartInsurance>() {
        /* class com.mi.global.shop.newmodel.cart.NewCartInsurance.AnonymousClass1 */

        public final NewCartInsurance createFromParcel(Parcel parcel) {
            return new NewCartInsurance(parcel);
        }

        public final NewCartInsurance[] newArray(int i) {
            return new NewCartInsurance[i];
        }
    };
    @SerializedName("goods_dealer")
    public String goods_dealer;
    @SerializedName("goods_id")
    public String goods_id;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("img_insurance")
    public String img_insurance;
    @SerializedName("insurance_desc")
    public String insurance_desc;
    @SerializedName("itemId")
    public String itemId;
    @SerializedName("market_price")
    public String market_price;
    @SerializedName("num")
    public int num;
    @SerializedName("price")
    public String price;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("validperiod")
    public String validperiod;

    public int describeContents() {
        return 0;
    }

    public static NewCartInsurance decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartInsurance decode(ProtoReader protoReader) throws IOException {
        NewCartInsurance newCartInsurance = new NewCartInsurance();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 3:
                        newCartInsurance.price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newCartInsurance.market_price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                    case 6:
                        newCartInsurance.goods_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newCartInsurance.image_url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newCartInsurance.itemId = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newCartInsurance.validperiod = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newCartInsurance.img_insurance = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newCartInsurance.goods_dealer = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 13:
                        newCartInsurance.num = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 14:
                        newCartInsurance.product_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newCartInsurance.insurance_desc = ProtoAdapter.STRING.decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newCartInsurance;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.price);
        parcel.writeString(this.market_price);
        parcel.writeString(this.goods_id);
        parcel.writeString(this.image_url);
        parcel.writeString(this.itemId);
        parcel.writeString(this.validperiod);
        parcel.writeString(this.img_insurance);
        parcel.writeString(this.goods_dealer);
        parcel.writeInt(this.num);
        parcel.writeString(this.product_name);
        parcel.writeString(this.insurance_desc);
    }

    public NewCartInsurance() {
    }

    protected NewCartInsurance(Parcel parcel) {
        this.price = parcel.readString();
        this.market_price = parcel.readString();
        this.goods_id = parcel.readString();
        this.image_url = parcel.readString();
        this.itemId = parcel.readString();
        this.validperiod = parcel.readString();
        this.img_insurance = parcel.readString();
        this.goods_dealer = parcel.readString();
        this.num = parcel.readInt();
        this.product_name = parcel.readString();
        this.insurance_desc = parcel.readString();
    }
}
