package com.mi.global.shop.model.cart;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class AddCartList extends Message<AddCartList, Builder> {
    public static final ProtoAdapter<AddCartList> ADAPTER = new ProtoAdapter_AddCartList();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.cart.AddCartData#ADAPTER", tag = 3)
    public final AddCartData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public AddCartList(Integer num, String str, AddCartData addCartData) {
        this(num, str, addCartData, ByteString.O00000Oo);
    }

    public AddCartList(Integer num, String str, AddCartData addCartData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = addCartData;
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
        if (!(obj instanceof AddCartList)) {
            return false;
        }
        AddCartList addCartList = (AddCartList) obj;
        return Internal.equals(unknownFields(), addCartList.unknownFields()) && Internal.equals(this.errno, addCartList.errno) && Internal.equals(this.errmsg, addCartList.errmsg) && Internal.equals(this.data, addCartList.data);
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
        AddCartData addCartData = this.data;
        if (addCartData != null) {
            i2 = addCartData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "AddCartList{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AddCartList, Builder> {
        public AddCartData data;
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

        public final Builder data(AddCartData addCartData) {
            this.data = addCartData;
            return this;
        }

        public final AddCartList build() {
            return new AddCartList(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_AddCartList extends ProtoAdapter<AddCartList> {
        ProtoAdapter_AddCartList() {
            super(FieldEncoding.LENGTH_DELIMITED, AddCartList.class);
        }

        public final int encodedSize(AddCartList addCartList) {
            int i = 0;
            int encodedSizeWithTag = (addCartList.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, addCartList.errno) : 0) + (addCartList.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, addCartList.errmsg) : 0);
            if (addCartList.data != null) {
                i = AddCartData.ADAPTER.encodedSizeWithTag(3, addCartList.data);
            }
            return encodedSizeWithTag + i + addCartList.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, AddCartList addCartList) throws IOException {
            if (addCartList.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, addCartList.errno);
            }
            if (addCartList.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, addCartList.errmsg);
            }
            if (addCartList.data != null) {
                AddCartData.ADAPTER.encodeWithTag(protoWriter, 3, addCartList.data);
            }
            protoWriter.writeBytes(addCartList.unknownFields());
        }

        public final AddCartList decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(AddCartData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final AddCartList redact(AddCartList addCartList) {
            Builder newBuilder = addCartList.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = AddCartData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
