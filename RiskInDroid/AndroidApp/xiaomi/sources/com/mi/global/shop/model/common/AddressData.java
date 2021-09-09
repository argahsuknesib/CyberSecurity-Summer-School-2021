package com.mi.global.shop.model.common;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class AddressData extends Message<AddressData, Builder> {
    public static final ProtoAdapter<AddressData> ADAPTER = new ProtoAdapter_AddressData();
    public static final Integer DEFAULT_CAN_COD = 0;
    public static final Integer DEFAULT_IS_DEFAULT = 0;
    public static final Integer DEFAULT_IS_INVALID = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.AddrIndiaData#ADAPTER", tag = 22)
    public final AddrIndiaData addr_india;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String address;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 20)
    public final String address1;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 21)
    public final String address2;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String address_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 14)
    public final Integer can_cod;
    @WireField(adapter = "com.mi.global.shop.model.common.RegionSimpleData#ADAPTER", tag = 3)
    public final RegionSimpleData city;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String citys;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String consignee;
    @WireField(adapter = "com.mi.global.shop.model.common.RegionSimpleData#ADAPTER", tag = 5)
    public final RegionSimpleData district;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String email;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    public final String first_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer is_default;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final Integer is_invalid;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    public final String last_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String limit;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String limit_cod;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    public final String limit_cod_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String limit_txt;
    @WireField(adapter = "com.mi.global.shop.model.common.RegionSimpleData#ADAPTER", tag = 7)
    public final RegionSimpleData province;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String tel;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String zipcode;

    public AddressData(String str, String str2, RegionSimpleData regionSimpleData, String str3, RegionSimpleData regionSimpleData2, String str4, RegionSimpleData regionSimpleData3, String str5, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, String str10, String str11, String str12, String str13, String str14, String str15, AddrIndiaData addrIndiaData) {
        this(str, str2, regionSimpleData, str3, regionSimpleData2, str4, regionSimpleData3, str5, str6, str7, str8, str9, num, num2, num3, str10, str11, str12, str13, str14, str15, addrIndiaData, ByteString.O00000Oo);
    }

    public AddressData(String str, String str2, RegionSimpleData regionSimpleData, String str3, RegionSimpleData regionSimpleData2, String str4, RegionSimpleData regionSimpleData3, String str5, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, String str10, String str11, String str12, String str13, String str14, String str15, AddrIndiaData addrIndiaData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.address = str;
        this.address_id = str2;
        this.city = regionSimpleData;
        this.consignee = str3;
        this.district = regionSimpleData2;
        this.email = str4;
        this.province = regionSimpleData3;
        this.tel = str5;
        this.zipcode = str6;
        this.limit = str7;
        this.limit_cod = str8;
        this.citys = str9;
        this.is_default = num;
        this.can_cod = num2;
        this.is_invalid = num3;
        this.limit_txt = str10;
        this.limit_cod_txt = str11;
        this.first_name = str12;
        this.last_name = str13;
        this.address1 = str14;
        this.address2 = str15;
        this.addr_india = addrIndiaData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.address = this.address;
        builder.address_id = this.address_id;
        builder.city = this.city;
        builder.consignee = this.consignee;
        builder.district = this.district;
        builder.email = this.email;
        builder.province = this.province;
        builder.tel = this.tel;
        builder.zipcode = this.zipcode;
        builder.limit = this.limit;
        builder.limit_cod = this.limit_cod;
        builder.citys = this.citys;
        builder.is_default = this.is_default;
        builder.can_cod = this.can_cod;
        builder.is_invalid = this.is_invalid;
        builder.limit_txt = this.limit_txt;
        builder.limit_cod_txt = this.limit_cod_txt;
        builder.first_name = this.first_name;
        builder.last_name = this.last_name;
        builder.address1 = this.address1;
        builder.address2 = this.address2;
        builder.addr_india = this.addr_india;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddressData)) {
            return false;
        }
        AddressData addressData = (AddressData) obj;
        return Internal.equals(unknownFields(), addressData.unknownFields()) && Internal.equals(this.address, addressData.address) && Internal.equals(this.address_id, addressData.address_id) && Internal.equals(this.city, addressData.city) && Internal.equals(this.consignee, addressData.consignee) && Internal.equals(this.district, addressData.district) && Internal.equals(this.email, addressData.email) && Internal.equals(this.province, addressData.province) && Internal.equals(this.tel, addressData.tel) && Internal.equals(this.zipcode, addressData.zipcode) && Internal.equals(this.limit, addressData.limit) && Internal.equals(this.limit_cod, addressData.limit_cod) && Internal.equals(this.citys, addressData.citys) && Internal.equals(this.is_default, addressData.is_default) && Internal.equals(this.can_cod, addressData.can_cod) && Internal.equals(this.is_invalid, addressData.is_invalid) && Internal.equals(this.limit_txt, addressData.limit_txt) && Internal.equals(this.limit_cod_txt, addressData.limit_cod_txt) && Internal.equals(this.first_name, addressData.first_name) && Internal.equals(this.last_name, addressData.last_name) && Internal.equals(this.address1, addressData.address1) && Internal.equals(this.address2, addressData.address2) && Internal.equals(this.addr_india, addressData.addr_india);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.address;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.address_id;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        RegionSimpleData regionSimpleData = this.city;
        int hashCode4 = (hashCode3 + (regionSimpleData != null ? regionSimpleData.hashCode() : 0)) * 37;
        String str3 = this.consignee;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        RegionSimpleData regionSimpleData2 = this.district;
        int hashCode6 = (hashCode5 + (regionSimpleData2 != null ? regionSimpleData2.hashCode() : 0)) * 37;
        String str4 = this.email;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        RegionSimpleData regionSimpleData3 = this.province;
        int hashCode8 = (hashCode7 + (regionSimpleData3 != null ? regionSimpleData3.hashCode() : 0)) * 37;
        String str5 = this.tel;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.zipcode;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.limit;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.limit_cod;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.citys;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num = this.is_default;
        int hashCode14 = (hashCode13 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.can_cod;
        int hashCode15 = (hashCode14 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.is_invalid;
        int hashCode16 = (hashCode15 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str10 = this.limit_txt;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.limit_cod_txt;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.first_name;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.last_name;
        int hashCode20 = (hashCode19 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.address1;
        int hashCode21 = (hashCode20 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.address2;
        int hashCode22 = (hashCode21 + (str15 != null ? str15.hashCode() : 0)) * 37;
        AddrIndiaData addrIndiaData = this.addr_india;
        if (addrIndiaData != null) {
            i2 = addrIndiaData.hashCode();
        }
        int i3 = hashCode22 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.address != null) {
            sb.append(", address=");
            sb.append(this.address);
        }
        if (this.address_id != null) {
            sb.append(", address_id=");
            sb.append(this.address_id);
        }
        if (this.city != null) {
            sb.append(", city=");
            sb.append(this.city);
        }
        if (this.consignee != null) {
            sb.append(", consignee=");
            sb.append(this.consignee);
        }
        if (this.district != null) {
            sb.append(", district=");
            sb.append(this.district);
        }
        if (this.email != null) {
            sb.append(", email=");
            sb.append(this.email);
        }
        if (this.province != null) {
            sb.append(", province=");
            sb.append(this.province);
        }
        if (this.tel != null) {
            sb.append(", tel=");
            sb.append(this.tel);
        }
        if (this.zipcode != null) {
            sb.append(", zipcode=");
            sb.append(this.zipcode);
        }
        if (this.limit != null) {
            sb.append(", limit=");
            sb.append(this.limit);
        }
        if (this.limit_cod != null) {
            sb.append(", limit_cod=");
            sb.append(this.limit_cod);
        }
        if (this.citys != null) {
            sb.append(", citys=");
            sb.append(this.citys);
        }
        if (this.is_default != null) {
            sb.append(", is_default=");
            sb.append(this.is_default);
        }
        if (this.can_cod != null) {
            sb.append(", can_cod=");
            sb.append(this.can_cod);
        }
        if (this.is_invalid != null) {
            sb.append(", is_invalid=");
            sb.append(this.is_invalid);
        }
        if (this.limit_txt != null) {
            sb.append(", limit_txt=");
            sb.append(this.limit_txt);
        }
        if (this.limit_cod_txt != null) {
            sb.append(", limit_cod_txt=");
            sb.append(this.limit_cod_txt);
        }
        if (this.first_name != null) {
            sb.append(", first_name=");
            sb.append(this.first_name);
        }
        if (this.last_name != null) {
            sb.append(", last_name=");
            sb.append(this.last_name);
        }
        if (this.address1 != null) {
            sb.append(", address1=");
            sb.append(this.address1);
        }
        if (this.address2 != null) {
            sb.append(", address2=");
            sb.append(this.address2);
        }
        if (this.addr_india != null) {
            sb.append(", addr_india=");
            sb.append(this.addr_india);
        }
        StringBuilder replace = sb.replace(0, 2, "AddressData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AddressData, Builder> {
        public AddrIndiaData addr_india;
        public String address;
        public String address1;
        public String address2;
        public String address_id;
        public Integer can_cod;
        public RegionSimpleData city;
        public String citys;
        public String consignee;
        public RegionSimpleData district;
        public String email;
        public String first_name;
        public Integer is_default;
        public Integer is_invalid;
        public String last_name;
        public String limit;
        public String limit_cod;
        public String limit_cod_txt;
        public String limit_txt;
        public RegionSimpleData province;
        public String tel;
        public String zipcode;

        public final Builder address(String str) {
            this.address = str;
            return this;
        }

        public final Builder address_id(String str) {
            this.address_id = str;
            return this;
        }

        public final Builder city(RegionSimpleData regionSimpleData) {
            this.city = regionSimpleData;
            return this;
        }

        public final Builder consignee(String str) {
            this.consignee = str;
            return this;
        }

        public final Builder district(RegionSimpleData regionSimpleData) {
            this.district = regionSimpleData;
            return this;
        }

        public final Builder email(String str) {
            this.email = str;
            return this;
        }

        public final Builder province(RegionSimpleData regionSimpleData) {
            this.province = regionSimpleData;
            return this;
        }

        public final Builder tel(String str) {
            this.tel = str;
            return this;
        }

        public final Builder zipcode(String str) {
            this.zipcode = str;
            return this;
        }

        public final Builder limit(String str) {
            this.limit = str;
            return this;
        }

        public final Builder limit_cod(String str) {
            this.limit_cod = str;
            return this;
        }

        public final Builder citys(String str) {
            this.citys = str;
            return this;
        }

        public final Builder is_default(Integer num) {
            this.is_default = num;
            return this;
        }

        public final Builder can_cod(Integer num) {
            this.can_cod = num;
            return this;
        }

        public final Builder is_invalid(Integer num) {
            this.is_invalid = num;
            return this;
        }

        public final Builder limit_txt(String str) {
            this.limit_txt = str;
            return this;
        }

        public final Builder limit_cod_txt(String str) {
            this.limit_cod_txt = str;
            return this;
        }

        public final Builder first_name(String str) {
            this.first_name = str;
            return this;
        }

        public final Builder last_name(String str) {
            this.last_name = str;
            return this;
        }

        public final Builder address1(String str) {
            this.address1 = str;
            return this;
        }

        public final Builder address2(String str) {
            this.address2 = str;
            return this;
        }

        public final Builder addr_india(AddrIndiaData addrIndiaData) {
            this.addr_india = addrIndiaData;
            return this;
        }

        public final AddressData build() {
            return new AddressData(this.address, this.address_id, this.city, this.consignee, this.district, this.email, this.province, this.tel, this.zipcode, this.limit, this.limit_cod, this.citys, this.is_default, this.can_cod, this.is_invalid, this.limit_txt, this.limit_cod_txt, this.first_name, this.last_name, this.address1, this.address2, this.addr_india, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_AddressData extends ProtoAdapter<AddressData> {
        ProtoAdapter_AddressData() {
            super(FieldEncoding.LENGTH_DELIMITED, AddressData.class);
        }

        public final int encodedSize(AddressData addressData) {
            int i = 0;
            int encodedSizeWithTag = (addressData.address != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, addressData.address) : 0) + (addressData.address_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, addressData.address_id) : 0) + (addressData.city != null ? RegionSimpleData.ADAPTER.encodedSizeWithTag(3, addressData.city) : 0) + (addressData.consignee != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, addressData.consignee) : 0) + (addressData.district != null ? RegionSimpleData.ADAPTER.encodedSizeWithTag(5, addressData.district) : 0) + (addressData.email != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, addressData.email) : 0) + (addressData.province != null ? RegionSimpleData.ADAPTER.encodedSizeWithTag(7, addressData.province) : 0) + (addressData.tel != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, addressData.tel) : 0) + (addressData.zipcode != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, addressData.zipcode) : 0) + (addressData.limit != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, addressData.limit) : 0) + (addressData.limit_cod != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, addressData.limit_cod) : 0) + (addressData.citys != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, addressData.citys) : 0) + (addressData.is_default != null ? ProtoAdapter.INT32.encodedSizeWithTag(13, addressData.is_default) : 0) + (addressData.can_cod != null ? ProtoAdapter.INT32.encodedSizeWithTag(14, addressData.can_cod) : 0) + (addressData.is_invalid != null ? ProtoAdapter.INT32.encodedSizeWithTag(15, addressData.is_invalid) : 0) + (addressData.limit_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(16, addressData.limit_txt) : 0) + (addressData.limit_cod_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(17, addressData.limit_cod_txt) : 0) + (addressData.first_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(18, addressData.first_name) : 0) + (addressData.last_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(19, addressData.last_name) : 0) + (addressData.address1 != null ? ProtoAdapter.STRING.encodedSizeWithTag(20, addressData.address1) : 0) + (addressData.address2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(21, addressData.address2) : 0);
            if (addressData.addr_india != null) {
                i = AddrIndiaData.ADAPTER.encodedSizeWithTag(22, addressData.addr_india);
            }
            return encodedSizeWithTag + i + addressData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, AddressData addressData) throws IOException {
            if (addressData.address != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, addressData.address);
            }
            if (addressData.address_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, addressData.address_id);
            }
            if (addressData.city != null) {
                RegionSimpleData.ADAPTER.encodeWithTag(protoWriter, 3, addressData.city);
            }
            if (addressData.consignee != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, addressData.consignee);
            }
            if (addressData.district != null) {
                RegionSimpleData.ADAPTER.encodeWithTag(protoWriter, 5, addressData.district);
            }
            if (addressData.email != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, addressData.email);
            }
            if (addressData.province != null) {
                RegionSimpleData.ADAPTER.encodeWithTag(protoWriter, 7, addressData.province);
            }
            if (addressData.tel != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, addressData.tel);
            }
            if (addressData.zipcode != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, addressData.zipcode);
            }
            if (addressData.limit != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, addressData.limit);
            }
            if (addressData.limit_cod != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, addressData.limit_cod);
            }
            if (addressData.citys != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, addressData.citys);
            }
            if (addressData.is_default != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 13, addressData.is_default);
            }
            if (addressData.can_cod != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 14, addressData.can_cod);
            }
            if (addressData.is_invalid != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 15, addressData.is_invalid);
            }
            if (addressData.limit_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, addressData.limit_txt);
            }
            if (addressData.limit_cod_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, addressData.limit_cod_txt);
            }
            if (addressData.first_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, addressData.first_name);
            }
            if (addressData.last_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 19, addressData.last_name);
            }
            if (addressData.address1 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 20, addressData.address1);
            }
            if (addressData.address2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 21, addressData.address2);
            }
            if (addressData.addr_india != null) {
                AddrIndiaData.ADAPTER.encodeWithTag(protoWriter, 22, addressData.addr_india);
            }
            protoWriter.writeBytes(addressData.unknownFields());
        }

        public final AddressData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.address(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.address_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.city(RegionSimpleData.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.consignee(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.district(RegionSimpleData.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            builder.email(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.province(RegionSimpleData.ADAPTER.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.tel(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.zipcode(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.limit(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.limit_cod(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.citys(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.is_default(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 14:
                            builder.can_cod(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.is_invalid(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 16:
                            builder.limit_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            builder.limit_cod_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 18:
                            builder.first_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            builder.last_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 20:
                            builder.address1(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 21:
                            builder.address2(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 22:
                            builder.addr_india(AddrIndiaData.ADAPTER.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final AddressData redact(AddressData addressData) {
            Builder newBuilder = addressData.newBuilder();
            if (newBuilder.city != null) {
                newBuilder.city = RegionSimpleData.ADAPTER.redact(newBuilder.city);
            }
            if (newBuilder.district != null) {
                newBuilder.district = RegionSimpleData.ADAPTER.redact(newBuilder.district);
            }
            if (newBuilder.province != null) {
                newBuilder.province = RegionSimpleData.ADAPTER.redact(newBuilder.province);
            }
            if (newBuilder.addr_india != null) {
                newBuilder.addr_india = AddrIndiaData.ADAPTER.redact(newBuilder.addr_india);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
