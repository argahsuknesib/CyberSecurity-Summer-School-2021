package com.mi.global.shop.model.app;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class RefreshUserInfo extends Message<RefreshUserInfo, Builder> {
    public static final ProtoAdapter<RefreshUserInfo> ADAPTER = new ProtoAdapter_RefreshUserInfo();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.app.RefreshUserInfoData#ADAPTER", tag = 3)
    public final RefreshUserInfoData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public RefreshUserInfo(Integer num, String str, RefreshUserInfoData refreshUserInfoData) {
        this(num, str, refreshUserInfoData, ByteString.O00000Oo);
    }

    public RefreshUserInfo(Integer num, String str, RefreshUserInfoData refreshUserInfoData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = refreshUserInfoData;
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
        if (!(obj instanceof RefreshUserInfo)) {
            return false;
        }
        RefreshUserInfo refreshUserInfo = (RefreshUserInfo) obj;
        return Internal.equals(unknownFields(), refreshUserInfo.unknownFields()) && Internal.equals(this.errno, refreshUserInfo.errno) && Internal.equals(this.errmsg, refreshUserInfo.errmsg) && Internal.equals(this.data, refreshUserInfo.data);
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
        RefreshUserInfoData refreshUserInfoData = this.data;
        if (refreshUserInfoData != null) {
            i2 = refreshUserInfoData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "RefreshUserInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<RefreshUserInfo, Builder> {
        public RefreshUserInfoData data;
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

        public final Builder data(RefreshUserInfoData refreshUserInfoData) {
            this.data = refreshUserInfoData;
            return this;
        }

        public final RefreshUserInfo build() {
            return new RefreshUserInfo(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_RefreshUserInfo extends ProtoAdapter<RefreshUserInfo> {
        ProtoAdapter_RefreshUserInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshUserInfo.class);
        }

        public final int encodedSize(RefreshUserInfo refreshUserInfo) {
            int i = 0;
            int encodedSizeWithTag = (refreshUserInfo.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, refreshUserInfo.errno) : 0) + (refreshUserInfo.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, refreshUserInfo.errmsg) : 0);
            if (refreshUserInfo.data != null) {
                i = RefreshUserInfoData.ADAPTER.encodedSizeWithTag(3, refreshUserInfo.data);
            }
            return encodedSizeWithTag + i + refreshUserInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, RefreshUserInfo refreshUserInfo) throws IOException {
            if (refreshUserInfo.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, refreshUserInfo.errno);
            }
            if (refreshUserInfo.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, refreshUserInfo.errmsg);
            }
            if (refreshUserInfo.data != null) {
                RefreshUserInfoData.ADAPTER.encodeWithTag(protoWriter, 3, refreshUserInfo.data);
            }
            protoWriter.writeBytes(refreshUserInfo.unknownFields());
        }

        public final RefreshUserInfo decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(RefreshUserInfoData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final RefreshUserInfo redact(RefreshUserInfo refreshUserInfo) {
            Builder newBuilder = refreshUserInfo.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = RefreshUserInfoData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
