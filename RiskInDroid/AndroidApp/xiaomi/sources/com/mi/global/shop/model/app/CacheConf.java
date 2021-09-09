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

public final class CacheConf extends Message<CacheConf, Builder> {
    public static final ProtoAdapter<CacheConf> ADAPTER = new ProtoAdapter_CacheConf();
    public static final Boolean DEFAULT_CSS = Boolean.FALSE;
    public static final Boolean DEFAULT_ENABLE = Boolean.FALSE;
    public static final Boolean DEFAULT_HTML = Boolean.FALSE;
    public static final Boolean DEFAULT_JS = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean css;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean enable;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean html;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean js;

    public CacheConf(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this(bool, bool2, bool3, bool4, ByteString.O00000Oo);
    }

    public CacheConf(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.enable = bool;
        this.js = bool2;
        this.css = bool3;
        this.html = bool4;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.enable = this.enable;
        builder.js = this.js;
        builder.css = this.css;
        builder.html = this.html;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CacheConf)) {
            return false;
        }
        CacheConf cacheConf = (CacheConf) obj;
        return Internal.equals(unknownFields(), cacheConf.unknownFields()) && Internal.equals(this.enable, cacheConf.enable) && Internal.equals(this.js, cacheConf.js) && Internal.equals(this.css, cacheConf.css) && Internal.equals(this.html, cacheConf.html);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.enable;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.js;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.css;
        int hashCode4 = (hashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.html;
        if (bool4 != null) {
            i2 = bool4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.enable != null) {
            sb.append(", enable=");
            sb.append(this.enable);
        }
        if (this.js != null) {
            sb.append(", js=");
            sb.append(this.js);
        }
        if (this.css != null) {
            sb.append(", css=");
            sb.append(this.css);
        }
        if (this.html != null) {
            sb.append(", html=");
            sb.append(this.html);
        }
        StringBuilder replace = sb.replace(0, 2, "CacheConf{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CacheConf, Builder> {
        public Boolean css;
        public Boolean enable;
        public Boolean html;
        public Boolean js;

        public final Builder enable(Boolean bool) {
            this.enable = bool;
            return this;
        }

        public final Builder js(Boolean bool) {
            this.js = bool;
            return this;
        }

        public final Builder css(Boolean bool) {
            this.css = bool;
            return this;
        }

        public final Builder html(Boolean bool) {
            this.html = bool;
            return this;
        }

        public final CacheConf build() {
            return new CacheConf(this.enable, this.js, this.css, this.html, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CacheConf extends ProtoAdapter<CacheConf> {
        ProtoAdapter_CacheConf() {
            super(FieldEncoding.LENGTH_DELIMITED, CacheConf.class);
        }

        public final int encodedSize(CacheConf cacheConf) {
            int i = 0;
            int encodedSizeWithTag = (cacheConf.enable != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, cacheConf.enable) : 0) + (cacheConf.js != null ? ProtoAdapter.BOOL.encodedSizeWithTag(2, cacheConf.js) : 0) + (cacheConf.css != null ? ProtoAdapter.BOOL.encodedSizeWithTag(3, cacheConf.css) : 0);
            if (cacheConf.html != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(4, cacheConf.html);
            }
            return encodedSizeWithTag + i + cacheConf.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CacheConf cacheConf) throws IOException {
            if (cacheConf.enable != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, cacheConf.enable);
            }
            if (cacheConf.js != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, cacheConf.js);
            }
            if (cacheConf.css != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, cacheConf.css);
            }
            if (cacheConf.html != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, cacheConf.html);
            }
            protoWriter.writeBytes(cacheConf.unknownFields());
        }

        public final CacheConf decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.enable(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.js(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.css(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.html(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public final CacheConf redact(CacheConf cacheConf) {
            Builder newBuilder = cacheConf.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
