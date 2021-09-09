package com.mi.global.shop.model.address;

import com.mi.global.shop.model.common.RegionData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class RegionBody extends Message<RegionBody, Builder> {
    public static final ProtoAdapter<RegionBody> ADAPTER = new ProtoAdapter_RegionBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.RegionData#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<RegionData> data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public RegionBody(Integer num, String str, List<RegionData> list) {
        this(num, str, list, ByteString.O00000Oo);
    }

    public RegionBody(Integer num, String str, List<RegionData> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = Internal.immutableCopyOf("data", list);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errno = this.errno;
        builder.errmsg = this.errmsg;
        builder.data = Internal.copyOf("data", this.data);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegionBody)) {
            return false;
        }
        RegionBody regionBody = (RegionBody) obj;
        return Internal.equals(unknownFields(), regionBody.unknownFields()) && Internal.equals(this.errno, regionBody.errno) && Internal.equals(this.errmsg, regionBody.errmsg) && Internal.equals(this.data, regionBody.data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.errmsg;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<RegionData> list = this.data;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.errno != null) {
            sb.append(", errno=");
            sb.append(this.errno);
        }
        if (this.errmsg != null) {
            sb.append(", errmsg=");
            sb.append(this.errmsg);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "RegionBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<RegionBody, Builder> {
        public List<RegionData> data = Internal.newMutableList();
        public String errmsg;
        public Integer errno;

        public final Builder errno(Integer num) {
            this.errno = num;
            return this;
        }

        public final Builder errmsg(String str) {
            this.errmsg = str;
            return this;
        }

        public final Builder data(List<RegionData> list) {
            Internal.checkElementsNotNull(list);
            this.data = list;
            return this;
        }

        public final RegionBody build() {
            return new RegionBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_RegionBody extends ProtoAdapter<RegionBody> {
        ProtoAdapter_RegionBody() {
            super(FieldEncoding.LENGTH_DELIMITED, RegionBody.class);
        }

        public final int encodedSize(RegionBody regionBody) {
            int i = 0;
            int encodedSizeWithTag = regionBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, regionBody.errno) : 0;
            if (regionBody.errmsg != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, regionBody.errmsg);
            }
            return encodedSizeWithTag + i + RegionData.ADAPTER.asRepeated().encodedSizeWithTag(3, regionBody.data) + regionBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, RegionBody regionBody) throws IOException {
            if (regionBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, regionBody.errno);
            }
            if (regionBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, regionBody.errmsg);
            }
            if (regionBody.data != null) {
                RegionData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, regionBody.data);
            }
            protoWriter.writeBytes(regionBody.unknownFields());
        }

        public final RegionBody decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data.add(RegionData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final RegionBody redact(RegionBody regionBody) {
            Builder newBuilder = regionBody.newBuilder();
            Internal.redactElements(newBuilder.data, RegionData.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
