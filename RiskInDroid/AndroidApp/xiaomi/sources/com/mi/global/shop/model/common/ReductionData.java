package com.mi.global.shop.model.common;

import com.google.android.exoplayer2.C;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class ReductionData extends Message<ReductionData, Builder> {
    public static final ProtoAdapter<ReductionData> ADAPTER = new ProtoAdapter_ReductionData();
    public static final Integer DEFAULT_TIMES = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String actName;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String activity_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String reduceMoney;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String reduceMoneySingle;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String reduceMoneySingle_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String reduceMoney_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer times;

    public ReductionData(String str, String str2, Integer num, String str3, String str4, String str5, String str6) {
        this(str, str2, num, str3, str4, str5, str6, ByteString.O00000Oo);
    }

    public ReductionData(String str, String str2, Integer num, String str3, String str4, String str5, String str6, ByteString byteString) {
        super(ADAPTER, byteString);
        this.actName = str;
        this.reduceMoneySingle = str2;
        this.times = num;
        this.reduceMoney = str3;
        this.activity_name = str4;
        this.reduceMoneySingle_txt = str5;
        this.reduceMoney_txt = str6;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.actName = this.actName;
        builder.reduceMoneySingle = this.reduceMoneySingle;
        builder.times = this.times;
        builder.reduceMoney = this.reduceMoney;
        builder.activity_name = this.activity_name;
        builder.reduceMoneySingle_txt = this.reduceMoneySingle_txt;
        builder.reduceMoney_txt = this.reduceMoney_txt;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReductionData)) {
            return false;
        }
        ReductionData reductionData = (ReductionData) obj;
        return Internal.equals(unknownFields(), reductionData.unknownFields()) && Internal.equals(this.actName, reductionData.actName) && Internal.equals(this.reduceMoneySingle, reductionData.reduceMoneySingle) && Internal.equals(this.times, reductionData.times) && Internal.equals(this.reduceMoney, reductionData.reduceMoney) && Internal.equals(this.activity_name, reductionData.activity_name) && Internal.equals(this.reduceMoneySingle_txt, reductionData.reduceMoneySingle_txt) && Internal.equals(this.reduceMoney_txt, reductionData.reduceMoney_txt);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.actName;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.reduceMoneySingle;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.times;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.reduceMoney;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.activity_name;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.reduceMoneySingle_txt;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.reduceMoney_txt;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.actName != null) {
            sb.append(", actName=");
            sb.append(this.actName);
        }
        if (this.reduceMoneySingle != null) {
            sb.append(", reduceMoneySingle=");
            sb.append(this.reduceMoneySingle);
        }
        if (this.times != null) {
            sb.append(", times=");
            sb.append(this.times);
        }
        if (this.reduceMoney != null) {
            sb.append(", reduceMoney=");
            sb.append(this.reduceMoney);
        }
        if (this.activity_name != null) {
            sb.append(", activity_name=");
            sb.append(this.activity_name);
        }
        if (this.reduceMoneySingle_txt != null) {
            sb.append(", reduceMoneySingle_txt=");
            sb.append(this.reduceMoneySingle_txt);
        }
        if (this.reduceMoney_txt != null) {
            sb.append(", reduceMoney_txt=");
            sb.append(this.reduceMoney_txt);
        }
        StringBuilder replace = sb.replace(0, 2, "ReductionData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ReductionData, Builder> {
        public String actName;
        public String activity_name;
        public String reduceMoney;
        public String reduceMoneySingle;
        public String reduceMoneySingle_txt;
        public String reduceMoney_txt;
        public Integer times;

        public final Builder actName(String str) {
            this.actName = str;
            return this;
        }

        public final Builder reduceMoneySingle(String str) {
            this.reduceMoneySingle = str;
            return this;
        }

        public final Builder times(Integer num) {
            this.times = num;
            return this;
        }

        public final Builder reduceMoney(String str) {
            this.reduceMoney = str;
            return this;
        }

        public final Builder activity_name(String str) {
            this.activity_name = str;
            return this;
        }

        public final Builder reduceMoneySingle_txt(String str) {
            this.reduceMoneySingle_txt = str;
            return this;
        }

        public final Builder reduceMoney_txt(String str) {
            this.reduceMoney_txt = str;
            return this;
        }

        public final ReductionData build() {
            return new ReductionData(this.actName, this.reduceMoneySingle, this.times, this.reduceMoney, this.activity_name, this.reduceMoneySingle_txt, this.reduceMoney_txt, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ReductionData extends ProtoAdapter<ReductionData> {
        ProtoAdapter_ReductionData() {
            super(FieldEncoding.LENGTH_DELIMITED, ReductionData.class);
        }

        public final int encodedSize(ReductionData reductionData) {
            int i = 0;
            int encodedSizeWithTag = (reductionData.actName != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, reductionData.actName) : 0) + (reductionData.reduceMoneySingle != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, reductionData.reduceMoneySingle) : 0) + (reductionData.times != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, reductionData.times) : 0) + (reductionData.reduceMoney != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, reductionData.reduceMoney) : 0) + (reductionData.activity_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, reductionData.activity_name) : 0) + (reductionData.reduceMoneySingle_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, reductionData.reduceMoneySingle_txt) : 0);
            if (reductionData.reduceMoney_txt != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(9, reductionData.reduceMoney_txt);
            }
            return encodedSizeWithTag + i + reductionData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ReductionData reductionData) throws IOException {
            if (reductionData.actName != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, reductionData.actName);
            }
            if (reductionData.reduceMoneySingle != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, reductionData.reduceMoneySingle);
            }
            if (reductionData.times != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, reductionData.times);
            }
            if (reductionData.reduceMoney != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, reductionData.reduceMoney);
            }
            if (reductionData.activity_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, reductionData.activity_name);
            }
            if (reductionData.reduceMoneySingle_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, reductionData.reduceMoneySingle_txt);
            }
            if (reductionData.reduceMoney_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, reductionData.reduceMoney_txt);
            }
            protoWriter.writeBytes(reductionData.unknownFields());
        }

        public final ReductionData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.actName(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.reduceMoneySingle(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.times(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.reduceMoney(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 7) {
                    builder.activity_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 8) {
                    builder.reduceMoneySingle_txt(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 9) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.reduceMoney_txt(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final ReductionData redact(ReductionData reductionData) {
            Builder newBuilder = reductionData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
