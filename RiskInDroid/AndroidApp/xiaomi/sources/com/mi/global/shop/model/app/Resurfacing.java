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

public final class Resurfacing extends Message<Resurfacing, Builder> {
    public static final ProtoAdapter<Resurfacing> ADAPTER = new ProtoAdapter_Resurfacing();
    public static final Integer DEFAULT_ENDTIME = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Boolean DEFAULT_SWITCH_ = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer endtime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String md5;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer starttime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean switch_;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String theme;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String url;

    public Resurfacing(Boolean bool, Integer num, Integer num2, String str, String str2, String str3) {
        this(bool, num, num2, str, str2, str3, ByteString.O00000Oo);
    }

    public Resurfacing(Boolean bool, Integer num, Integer num2, String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.switch_ = bool;
        this.starttime = num;
        this.endtime = num2;
        this.url = str;
        this.md5 = str2;
        this.theme = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.switch_ = this.switch_;
        builder.starttime = this.starttime;
        builder.endtime = this.endtime;
        builder.url = this.url;
        builder.md5 = this.md5;
        builder.theme = this.theme;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Resurfacing)) {
            return false;
        }
        Resurfacing resurfacing = (Resurfacing) obj;
        return Internal.equals(unknownFields(), resurfacing.unknownFields()) && Internal.equals(this.switch_, resurfacing.switch_) && Internal.equals(this.starttime, resurfacing.starttime) && Internal.equals(this.endtime, resurfacing.endtime) && Internal.equals(this.url, resurfacing.url) && Internal.equals(this.md5, resurfacing.md5) && Internal.equals(this.theme, resurfacing.theme);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.switch_;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.starttime;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.endtime;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.url;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.md5;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.theme;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.switch_ != null) {
            sb.append(", switch=");
            sb.append(this.switch_);
        }
        if (this.starttime != null) {
            sb.append(", starttime=");
            sb.append(this.starttime);
        }
        if (this.endtime != null) {
            sb.append(", endtime=");
            sb.append(this.endtime);
        }
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        if (this.md5 != null) {
            sb.append(", md5=");
            sb.append(this.md5);
        }
        if (this.theme != null) {
            sb.append(", theme=");
            sb.append(this.theme);
        }
        StringBuilder replace = sb.replace(0, 2, "Resurfacing{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Resurfacing, Builder> {
        public Integer endtime;
        public String md5;
        public Integer starttime;
        public Boolean switch_;
        public String theme;
        public String url;

        public final Builder switch_(Boolean bool) {
            this.switch_ = bool;
            return this;
        }

        public final Builder starttime(Integer num) {
            this.starttime = num;
            return this;
        }

        public final Builder endtime(Integer num) {
            this.endtime = num;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder md5(String str) {
            this.md5 = str;
            return this;
        }

        public final Builder theme(String str) {
            this.theme = str;
            return this;
        }

        public final Resurfacing build() {
            return new Resurfacing(this.switch_, this.starttime, this.endtime, this.url, this.md5, this.theme, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Resurfacing extends ProtoAdapter<Resurfacing> {
        ProtoAdapter_Resurfacing() {
            super(FieldEncoding.LENGTH_DELIMITED, Resurfacing.class);
        }

        public final int encodedSize(Resurfacing resurfacing) {
            int i = 0;
            int encodedSizeWithTag = (resurfacing.switch_ != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, resurfacing.switch_) : 0) + (resurfacing.starttime != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, resurfacing.starttime) : 0) + (resurfacing.endtime != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, resurfacing.endtime) : 0) + (resurfacing.url != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, resurfacing.url) : 0) + (resurfacing.md5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, resurfacing.md5) : 0);
            if (resurfacing.theme != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(6, resurfacing.theme);
            }
            return encodedSizeWithTag + i + resurfacing.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Resurfacing resurfacing) throws IOException {
            if (resurfacing.switch_ != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, resurfacing.switch_);
            }
            if (resurfacing.starttime != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, resurfacing.starttime);
            }
            if (resurfacing.endtime != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, resurfacing.endtime);
            }
            if (resurfacing.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, resurfacing.url);
            }
            if (resurfacing.md5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, resurfacing.md5);
            }
            if (resurfacing.theme != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, resurfacing.theme);
            }
            protoWriter.writeBytes(resurfacing.unknownFields());
        }

        public final Resurfacing decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.switch_(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 2:
                            builder.starttime(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 3:
                            builder.endtime(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 4:
                            builder.url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.theme(ProtoAdapter.STRING.decode(protoReader));
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

        public final Resurfacing redact(Resurfacing resurfacing) {
            Builder newBuilder = resurfacing.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
