package com.mi.global.shop.model.cart;

import com.mi.global.shop.model.common.EditCartData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class EditCartList extends Message<EditCartList, Builder> {
    public static final ProtoAdapter<EditCartList> ADAPTER = new ProtoAdapter_EditCartList();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.EditCartData#ADAPTER", tag = 3)
    public final EditCartData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public EditCartList(Integer num, String str, EditCartData editCartData) {
        this(num, str, editCartData, ByteString.O00000Oo);
    }

    public EditCartList(Integer num, String str, EditCartData editCartData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = editCartData;
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
        if (!(obj instanceof EditCartList)) {
            return false;
        }
        EditCartList editCartList = (EditCartList) obj;
        return Internal.equals(unknownFields(), editCartList.unknownFields()) && Internal.equals(this.errno, editCartList.errno) && Internal.equals(this.errmsg, editCartList.errmsg) && Internal.equals(this.data, editCartList.data);
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
        EditCartData editCartData = this.data;
        if (editCartData != null) {
            i2 = editCartData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "EditCartList{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<EditCartList, Builder> {
        public EditCartData data;
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

        public final Builder data(EditCartData editCartData) {
            this.data = editCartData;
            return this;
        }

        public final EditCartList build() {
            return new EditCartList(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_EditCartList extends ProtoAdapter<EditCartList> {
        ProtoAdapter_EditCartList() {
            super(FieldEncoding.LENGTH_DELIMITED, EditCartList.class);
        }

        public final int encodedSize(EditCartList editCartList) {
            int i = 0;
            int encodedSizeWithTag = (editCartList.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, editCartList.errno) : 0) + (editCartList.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, editCartList.errmsg) : 0);
            if (editCartList.data != null) {
                i = EditCartData.ADAPTER.encodedSizeWithTag(3, editCartList.data);
            }
            return encodedSizeWithTag + i + editCartList.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, EditCartList editCartList) throws IOException {
            if (editCartList.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, editCartList.errno);
            }
            if (editCartList.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, editCartList.errmsg);
            }
            if (editCartList.data != null) {
                EditCartData.ADAPTER.encodeWithTag(protoWriter, 3, editCartList.data);
            }
            protoWriter.writeBytes(editCartList.unknownFields());
        }

        public final EditCartList decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(EditCartData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final EditCartList redact(EditCartList editCartList) {
            Builder newBuilder = editCartList.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = EditCartData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
