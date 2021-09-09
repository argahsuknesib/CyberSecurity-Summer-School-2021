package com.mi.global.shop.model.common;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class ActivityContent extends Message<ActivityContent, Builder> {
    public static final ProtoAdapter<ActivityContent> ADAPTER = new ProtoAdapter_ActivityContent();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.BombBox#ADAPTER", tag = 3)
    public final BombBox bombbox;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String endtime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String icon;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String prompt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String starttime;

    public ActivityContent(String str, String str2, BombBox bombBox, String str3, String str4) {
        this(str, str2, bombBox, str3, str4, ByteString.O00000Oo);
    }

    public ActivityContent(String str, String str2, BombBox bombBox, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.prompt = str;
        this.icon = str2;
        this.bombbox = bombBox;
        this.starttime = str3;
        this.endtime = str4;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.prompt = this.prompt;
        builder.icon = this.icon;
        builder.bombbox = this.bombbox;
        builder.starttime = this.starttime;
        builder.endtime = this.endtime;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityContent)) {
            return false;
        }
        ActivityContent activityContent = (ActivityContent) obj;
        return Internal.equals(unknownFields(), activityContent.unknownFields()) && Internal.equals(this.prompt, activityContent.prompt) && Internal.equals(this.icon, activityContent.icon) && Internal.equals(this.bombbox, activityContent.bombbox) && Internal.equals(this.starttime, activityContent.starttime) && Internal.equals(this.endtime, activityContent.endtime);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.prompt;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.icon;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BombBox bombBox = this.bombbox;
        int hashCode4 = (hashCode3 + (bombBox != null ? bombBox.hashCode() : 0)) * 37;
        String str3 = this.starttime;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.endtime;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.prompt != null) {
            sb.append(", prompt=");
            sb.append(this.prompt);
        }
        if (this.icon != null) {
            sb.append(", icon=");
            sb.append(this.icon);
        }
        if (this.bombbox != null) {
            sb.append(", bombbox=");
            sb.append(this.bombbox);
        }
        if (this.starttime != null) {
            sb.append(", starttime=");
            sb.append(this.starttime);
        }
        if (this.endtime != null) {
            sb.append(", endtime=");
            sb.append(this.endtime);
        }
        StringBuilder replace = sb.replace(0, 2, "ActivityContent{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ActivityContent, Builder> {
        public BombBox bombbox;
        public String endtime;
        public String icon;
        public String prompt;
        public String starttime;

        public final Builder prompt(String str) {
            this.prompt = str;
            return this;
        }

        public final Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public final Builder bombbox(BombBox bombBox) {
            this.bombbox = bombBox;
            return this;
        }

        public final Builder starttime(String str) {
            this.starttime = str;
            return this;
        }

        public final Builder endtime(String str) {
            this.endtime = str;
            return this;
        }

        public final ActivityContent build() {
            return new ActivityContent(this.prompt, this.icon, this.bombbox, this.starttime, this.endtime, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ActivityContent extends ProtoAdapter<ActivityContent> {
        ProtoAdapter_ActivityContent() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivityContent.class);
        }

        public final int encodedSize(ActivityContent activityContent) {
            int i = 0;
            int encodedSizeWithTag = (activityContent.prompt != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, activityContent.prompt) : 0) + (activityContent.icon != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, activityContent.icon) : 0) + (activityContent.bombbox != null ? BombBox.ADAPTER.encodedSizeWithTag(3, activityContent.bombbox) : 0) + (activityContent.starttime != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, activityContent.starttime) : 0);
            if (activityContent.endtime != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(5, activityContent.endtime);
            }
            return encodedSizeWithTag + i + activityContent.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ActivityContent activityContent) throws IOException {
            if (activityContent.prompt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, activityContent.prompt);
            }
            if (activityContent.icon != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, activityContent.icon);
            }
            if (activityContent.bombbox != null) {
                BombBox.ADAPTER.encodeWithTag(protoWriter, 3, activityContent.bombbox);
            }
            if (activityContent.starttime != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, activityContent.starttime);
            }
            if (activityContent.endtime != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, activityContent.endtime);
            }
            protoWriter.writeBytes(activityContent.unknownFields());
        }

        public final ActivityContent decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.prompt(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.icon(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.bombbox(BombBox.ADAPTER.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.starttime(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.endtime(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final ActivityContent redact(ActivityContent activityContent) {
            Builder newBuilder = activityContent.newBuilder();
            if (newBuilder.bombbox != null) {
                newBuilder.bombbox = BombBox.ADAPTER.redact(newBuilder.bombbox);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
