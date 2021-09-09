package com.mi.global.shop.model.address;

import com.mi.global.shop.model.common.AddressData;
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

public final class ListBody extends Message<ListBody, Builder> {
    public static final ProtoAdapter<ListBody> ADAPTER = new ProtoAdapter_ListBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.AddressData#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<AddressData> data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public ListBody(Integer num, String str, List<AddressData> list) {
        this(num, str, list, ByteString.O00000Oo);
    }

    public ListBody(Integer num, String str, List<AddressData> list, ByteString byteString) {
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
        if (!(obj instanceof ListBody)) {
            return false;
        }
        ListBody listBody = (ListBody) obj;
        return Internal.equals(unknownFields(), listBody.unknownFields()) && Internal.equals(this.errno, listBody.errno) && Internal.equals(this.errmsg, listBody.errmsg) && Internal.equals(this.data, listBody.data);
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
        List<AddressData> list = this.data;
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
        StringBuilder replace = sb.replace(0, 2, "ListBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ListBody, Builder> {
        public List<AddressData> data = Internal.newMutableList();
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

        public final Builder data(List<AddressData> list) {
            Internal.checkElementsNotNull(list);
            this.data = list;
            return this;
        }

        public final ListBody build() {
            return new ListBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ListBody extends ProtoAdapter<ListBody> {
        ProtoAdapter_ListBody() {
            super(FieldEncoding.LENGTH_DELIMITED, ListBody.class);
        }

        public final int encodedSize(ListBody listBody) {
            int i = 0;
            int encodedSizeWithTag = listBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, listBody.errno) : 0;
            if (listBody.errmsg != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, listBody.errmsg);
            }
            return encodedSizeWithTag + i + AddressData.ADAPTER.asRepeated().encodedSizeWithTag(3, listBody.data) + listBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ListBody listBody) throws IOException {
            if (listBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, listBody.errno);
            }
            if (listBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, listBody.errmsg);
            }
            if (listBody.data != null) {
                AddressData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, listBody.data);
            }
            protoWriter.writeBytes(listBody.unknownFields());
        }

        public final ListBody decode(ProtoReader protoReader) throws IOException {
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
                    builder.data.add(AddressData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final ListBody redact(ListBody listBody) {
            Builder newBuilder = listBody.newBuilder();
            Internal.redactElements(newBuilder.data, AddressData.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
