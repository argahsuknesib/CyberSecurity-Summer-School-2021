package com.mi.global.shop.model.app;

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

public final class VerInfo extends Message<VerInfo, Builder> {
    public static final ProtoAdapter<VerInfo> ADAPTER = new ProtoAdapter_VerInfo();
    public static final Boolean DEFAULT_FORCEUPDATE = Boolean.FALSE;
    public static final Integer DEFAULT_VERSIONCODE = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean forceUpdate;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String md5;
    @WireField(adapter = "com.mi.global.shop.model.app.Note#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<Note> notes;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String patchUrl;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer versionCode;

    public VerInfo(String str, List<Note> list, String str2, Boolean bool, Integer num, String str3, String str4) {
        this(str, list, str2, bool, num, str3, str4, ByteString.O00000Oo);
    }

    public VerInfo(String str, List<Note> list, String str2, Boolean bool, Integer num, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = str;
        this.notes = Internal.immutableCopyOf("notes", list);
        this.url = str2;
        this.forceUpdate = bool;
        this.versionCode = num;
        this.md5 = str3;
        this.patchUrl = str4;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.version = this.version;
        builder.notes = Internal.copyOf("notes", this.notes);
        builder.url = this.url;
        builder.forceUpdate = this.forceUpdate;
        builder.versionCode = this.versionCode;
        builder.md5 = this.md5;
        builder.patchUrl = this.patchUrl;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VerInfo)) {
            return false;
        }
        VerInfo verInfo = (VerInfo) obj;
        return Internal.equals(unknownFields(), verInfo.unknownFields()) && Internal.equals(this.version, verInfo.version) && Internal.equals(this.notes, verInfo.notes) && Internal.equals(this.url, verInfo.url) && Internal.equals(this.forceUpdate, verInfo.forceUpdate) && Internal.equals(this.versionCode, verInfo.versionCode) && Internal.equals(this.md5, verInfo.md5) && Internal.equals(this.patchUrl, verInfo.patchUrl);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.version;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        List<Note> list = this.notes;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.url;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.forceUpdate;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.versionCode;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.md5;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.patchUrl;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.notes != null) {
            sb.append(", notes=");
            sb.append(this.notes);
        }
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        if (this.forceUpdate != null) {
            sb.append(", forceUpdate=");
            sb.append(this.forceUpdate);
        }
        if (this.versionCode != null) {
            sb.append(", versionCode=");
            sb.append(this.versionCode);
        }
        if (this.md5 != null) {
            sb.append(", md5=");
            sb.append(this.md5);
        }
        if (this.patchUrl != null) {
            sb.append(", patchUrl=");
            sb.append(this.patchUrl);
        }
        StringBuilder replace = sb.replace(0, 2, "VerInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<VerInfo, Builder> {
        public Boolean forceUpdate;
        public String md5;
        public List<Note> notes = Internal.newMutableList();
        public String patchUrl;
        public String url;
        public String version;
        public Integer versionCode;

        public final Builder version(String str) {
            this.version = str;
            return this;
        }

        public final Builder notes(List<Note> list) {
            Internal.checkElementsNotNull(list);
            this.notes = list;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder forceUpdate(Boolean bool) {
            this.forceUpdate = bool;
            return this;
        }

        public final Builder versionCode(Integer num) {
            this.versionCode = num;
            return this;
        }

        public final Builder md5(String str) {
            this.md5 = str;
            return this;
        }

        public final Builder patchUrl(String str) {
            this.patchUrl = str;
            return this;
        }

        public final VerInfo build() {
            return new VerInfo(this.version, this.notes, this.url, this.forceUpdate, this.versionCode, this.md5, this.patchUrl, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_VerInfo extends ProtoAdapter<VerInfo> {
        ProtoAdapter_VerInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, VerInfo.class);
        }

        public final int encodedSize(VerInfo verInfo) {
            int i = 0;
            int encodedSizeWithTag = (verInfo.version != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, verInfo.version) : 0) + Note.ADAPTER.asRepeated().encodedSizeWithTag(2, verInfo.notes) + (verInfo.url != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, verInfo.url) : 0) + (verInfo.forceUpdate != null ? ProtoAdapter.BOOL.encodedSizeWithTag(4, verInfo.forceUpdate) : 0) + (verInfo.versionCode != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, verInfo.versionCode) : 0) + (verInfo.md5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, verInfo.md5) : 0);
            if (verInfo.patchUrl != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(7, verInfo.patchUrl);
            }
            return encodedSizeWithTag + i + verInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, VerInfo verInfo) throws IOException {
            if (verInfo.version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, verInfo.version);
            }
            if (verInfo.notes != null) {
                Note.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, verInfo.notes);
            }
            if (verInfo.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, verInfo.url);
            }
            if (verInfo.forceUpdate != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, verInfo.forceUpdate);
            }
            if (verInfo.versionCode != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, verInfo.versionCode);
            }
            if (verInfo.md5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, verInfo.md5);
            }
            if (verInfo.patchUrl != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, verInfo.patchUrl);
            }
            protoWriter.writeBytes(verInfo.unknownFields());
        }

        public final VerInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.version(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.notes.add(Note.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.forceUpdate(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 5:
                            builder.versionCode(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 6:
                            builder.md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.patchUrl(ProtoAdapter.STRING.decode(protoReader));
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

        public final VerInfo redact(VerInfo verInfo) {
            Builder newBuilder = verInfo.newBuilder();
            Internal.redactElements(newBuilder.notes, Note.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
