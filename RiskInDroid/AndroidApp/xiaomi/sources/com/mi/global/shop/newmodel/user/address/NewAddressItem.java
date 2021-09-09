package com.mi.global.shop.newmodel.user.address;

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

public class NewAddressItem implements Parcelable, Cloneable {
    public static final Parcelable.Creator<NewAddressItem> CREATOR = new Parcelable.Creator<NewAddressItem>() {
        /* class com.mi.global.shop.newmodel.user.address.NewAddressItem.AnonymousClass1 */

        public final NewAddressItem createFromParcel(Parcel parcel) {
            return new NewAddressItem(parcel);
        }

        public final NewAddressItem[] newArray(int i) {
            return new NewAddressItem[i];
        }
    };
    public static int DEFAULT_ADDRESS = 1;
    public static int OTHER_ADDRESS;
    @SerializedName("addr_india")
    public NewIndiaAddress addr_india;
    @SerializedName("address")
    public String address;
    @SerializedName("address1")
    public String address1;
    @SerializedName("address2")
    public String address2;
    @SerializedName("address_id")
    public String address_id;
    @SerializedName("can_cod")
    public int can_cod;
    @SerializedName("city")
    public NewSimpleRegionItem city;
    @SerializedName("citys")
    public String citys;
    @SerializedName("consignee")
    public String consignee;
    @SerializedName("district")
    public NewSimpleRegionItem district;
    @SerializedName("email")
    public String email;
    @SerializedName("first_name")
    public String first_name;
    @SerializedName("is_default")
    public int is_default;
    @SerializedName("is_invalid")
    public int is_invalid;
    @SerializedName("last_name")
    public String last_name;
    @SerializedName("limit")
    public String limit;
    @SerializedName("limit_cod")
    public String limit_cod;
    @SerializedName("limit_cod_txt")
    public String limit_cod_txt;
    @SerializedName("limit_txt")
    public String limit_txt;
    @SerializedName("province")
    public NewSimpleRegionItem province;
    public boolean selected;
    @SerializedName("tel")
    public String tel;
    @SerializedName("zipcode")
    public String zipcode;

    public int describeContents() {
        return 0;
    }

    public static NewAddressItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewAddressItem decode(ProtoReader protoReader) throws IOException {
        NewAddressItem newAddressItem = new NewAddressItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newAddressItem.address = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newAddressItem.address_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newAddressItem.city = NewSimpleRegionItem.decode(protoReader);
                        break;
                    case 4:
                        newAddressItem.consignee = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newAddressItem.district = NewSimpleRegionItem.decode(protoReader);
                        break;
                    case 6:
                        newAddressItem.email = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newAddressItem.province = NewSimpleRegionItem.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newAddressItem.tel = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newAddressItem.zipcode = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newAddressItem.limit = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newAddressItem.limit_cod = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newAddressItem.citys = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 13:
                        newAddressItem.is_default = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 14:
                        newAddressItem.can_cod = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newAddressItem.is_invalid = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 16:
                        newAddressItem.limit_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 17:
                        newAddressItem.limit_cod_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 18:
                        newAddressItem.first_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 19:
                        newAddressItem.last_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 20:
                        newAddressItem.address1 = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 21:
                        newAddressItem.address2 = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 22:
                        newAddressItem.addr_india = NewIndiaAddress.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newAddressItem;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.selected ? (byte) 1 : 0);
        parcel.writeString(this.address);
        parcel.writeString(this.address_id);
        parcel.writeParcelable(this.city, i);
        parcel.writeString(this.consignee);
        parcel.writeParcelable(this.district, i);
        parcel.writeString(this.email);
        parcel.writeParcelable(this.province, i);
        parcel.writeString(this.tel);
        parcel.writeString(this.zipcode);
        parcel.writeString(this.limit);
        parcel.writeString(this.limit_cod);
        parcel.writeString(this.citys);
        parcel.writeInt(this.is_default);
        parcel.writeInt(this.can_cod);
        parcel.writeInt(this.is_invalid);
        parcel.writeString(this.limit_txt);
        parcel.writeString(this.limit_cod_txt);
        parcel.writeString(this.first_name);
        parcel.writeString(this.last_name);
        parcel.writeString(this.address1);
        parcel.writeString(this.address2);
        parcel.writeParcelable(this.addr_india, i);
    }

    public NewAddressItem() {
    }

    protected NewAddressItem(Parcel parcel) {
        this.selected = parcel.readByte() != 0;
        this.address = parcel.readString();
        this.address_id = parcel.readString();
        this.city = (NewSimpleRegionItem) parcel.readParcelable(NewSimpleRegionItem.class.getClassLoader());
        this.consignee = parcel.readString();
        this.district = (NewSimpleRegionItem) parcel.readParcelable(NewSimpleRegionItem.class.getClassLoader());
        this.email = parcel.readString();
        this.province = (NewSimpleRegionItem) parcel.readParcelable(NewSimpleRegionItem.class.getClassLoader());
        this.tel = parcel.readString();
        this.zipcode = parcel.readString();
        this.limit = parcel.readString();
        this.limit_cod = parcel.readString();
        this.citys = parcel.readString();
        this.is_default = parcel.readInt();
        this.can_cod = parcel.readInt();
        this.is_invalid = parcel.readInt();
        this.limit_txt = parcel.readString();
        this.limit_cod_txt = parcel.readString();
        this.first_name = parcel.readString();
        this.last_name = parcel.readString();
        this.address1 = parcel.readString();
        this.address2 = parcel.readString();
        this.addr_india = (NewIndiaAddress) parcel.readParcelable(NewIndiaAddress.class.getClassLoader());
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
