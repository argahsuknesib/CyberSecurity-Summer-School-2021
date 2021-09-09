package com.mi.global.shop.model.user;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class AddressBody extends Message<AddressBody, Builder> {
    public static final ProtoAdapter<AddressBody> ADAPTER = new ProtoAdapter_AddressBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.user.AddressData#ADAPTER", tag = 3)
    public final AddressData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public AddressBody(Integer num, String str, AddressData addressData) {
        this(num, str, addressData, ByteString.O00000Oo);
    }

    public AddressBody(Integer num, String str, AddressData addressData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = addressData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errno = this.errno;
        builder.errmsg = this.errmsg;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddressBody)) {
            return false;
        }
        AddressBody addressBody = (AddressBody) obj;
        return Internal.equals(unknownFields(), addressBody.unknownFields()) && Internal.equals(this.errno, addressBody.errno) && Internal.equals(this.errmsg, addressBody.errmsg) && Internal.equals(this.data, addressBody.data);
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
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        AddressData addressData = this.data;
        if (addressData != null) {
            i2 = addressData.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
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
        StringBuilder replace = sb.replace(0, 2, "AddressBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AddressBody, Builder> {
        public AddressData data;
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

        public final Builder data(AddressData addressData) {
            this.data = addressData;
            return this;
        }

        public final AddressBody build() {
            return new AddressBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_AddressBody extends ProtoAdapter<AddressBody> {
        ProtoAdapter_AddressBody() {
            super(FieldEncoding.LENGTH_DELIMITED, AddressBody.class);
        }

        public final int encodedSize(AddressBody addressBody) {
            int i = 0;
            int encodedSizeWithTag = (addressBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, addressBody.errno) : 0) + (addressBody.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, addressBody.errmsg) : 0);
            if (addressBody.data != null) {
                i = AddressData.ADAPTER.encodedSizeWithTag(3, addressBody.data);
            }
            return encodedSizeWithTag + i + addressBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, AddressBody addressBody) throws IOException {
            if (addressBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, addressBody.errno);
            }
            if (addressBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, addressBody.errmsg);
            }
            if (addressBody.data != null) {
                AddressData.ADAPTER.encodeWithTag(protoWriter, 3, addressBody.data);
            }
            protoWriter.writeBytes(addressBody.unknownFields());
        }

        public final AddressBody decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(AddressData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final AddressBody redact(AddressBody addressBody) {
            Builder newBuilder = addressBody.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = AddressData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
