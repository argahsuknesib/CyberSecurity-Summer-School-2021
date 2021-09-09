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

public final class ActivityConf extends Message<ActivityConf, Builder> {
    public static final ProtoAdapter<ActivityConf> ADAPTER = new ProtoAdapter_ActivityConf();
    public static final Integer DEFAULT_DURATION = 0;
    public static final Integer DEFAULT_ENDTIME = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer duration;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer endTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer startTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    public ActivityConf(String str, Integer num, Integer num2, Integer num3) {
        this(str, num, num2, num3, ByteString.O00000Oo);
    }

    public ActivityConf(String str, Integer num, Integer num2, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.url = str;
        this.startTime = num;
        this.endTime = num2;
        this.duration = num3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.startTime = this.startTime;
        builder.endTime = this.endTime;
        builder.duration = this.duration;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityConf)) {
            return false;
        }
        ActivityConf activityConf = (ActivityConf) obj;
        return Internal.equals(unknownFields(), activityConf.unknownFields()) && Internal.equals(this.url, activityConf.url) && Internal.equals(this.startTime, activityConf.startTime) && Internal.equals(this.endTime, activityConf.endTime) && Internal.equals(this.duration, activityConf.duration);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.url;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.startTime;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.endTime;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.duration;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        if (this.startTime != null) {
            sb.append(", startTime=");
            sb.append(this.startTime);
        }
        if (this.endTime != null) {
            sb.append(", endTime=");
            sb.append(this.endTime);
        }
        if (this.duration != null) {
            sb.append(", duration=");
            sb.append(this.duration);
        }
        StringBuilder replace = sb.replace(0, 2, "ActivityConf{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ActivityConf, Builder> {
        public Integer duration;
        public Integer endTime;
        public Integer startTime;
        public String url;

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder startTime(Integer num) {
            this.startTime = num;
            return this;
        }

        public final Builder endTime(Integer num) {
            this.endTime = num;
            return this;
        }

        public final Builder duration(Integer num) {
            this.duration = num;
            return this;
        }

        public final ActivityConf build() {
            return new ActivityConf(this.url, this.startTime, this.endTime, this.duration, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ActivityConf extends ProtoAdapter<ActivityConf> {
        ProtoAdapter_ActivityConf() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivityConf.class);
        }

        public final int encodedSize(ActivityConf activityConf) {
            int i = 0;
            int encodedSizeWithTag = (activityConf.url != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, activityConf.url) : 0) + (activityConf.startTime != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, activityConf.startTime) : 0) + (activityConf.endTime != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, activityConf.endTime) : 0);
            if (activityConf.duration != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(4, activityConf.duration);
            }
            return encodedSizeWithTag + i + activityConf.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ActivityConf activityConf) throws IOException {
            if (activityConf.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, activityConf.url);
            }
            if (activityConf.startTime != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, activityConf.startTime);
            }
            if (activityConf.endTime != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, activityConf.endTime);
            }
            if (activityConf.duration != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, activityConf.duration);
            }
            protoWriter.writeBytes(activityConf.unknownFields());
        }

        public final ActivityConf decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.startTime(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.endTime(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.duration(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public final ActivityConf redact(ActivityConf activityConf) {
            Builder newBuilder = activityConf.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
