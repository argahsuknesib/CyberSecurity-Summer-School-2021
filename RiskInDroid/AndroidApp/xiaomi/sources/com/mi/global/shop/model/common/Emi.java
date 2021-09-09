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
import java.util.List;
import okio.ByteString;

public final class Emi extends Message<Emi, Builder> {
    public static final ProtoAdapter<Emi> ADAPTER = new ProtoAdapter_Emi();
    public static final Boolean DEFAULT_ENABLE = Boolean.FALSE;
    public static final Integer DEFAULT_MIN = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean enable;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String img;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String key;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer min;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String name;
    @WireField(adapter = "com.mi.global.shop.model.common.Emi$EmiRate#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<EmiRate> rate;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String tips;

    public Emi(Integer num, String str, String str2, Boolean bool, String str3, List<EmiRate> list, String str4) {
        this(num, str, str2, bool, str3, list, str4, ByteString.O00000Oo);
    }

    public Emi(Integer num, String str, String str2, Boolean bool, String str3, List<EmiRate> list, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.min = num;
        this.key = str;
        this.name = str2;
        this.enable = bool;
        this.img = str3;
        this.rate = Internal.immutableCopyOf("rate", list);
        this.tips = str4;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.min = this.min;
        builder.key = this.key;
        builder.name = this.name;
        builder.enable = this.enable;
        builder.img = this.img;
        builder.rate = Internal.copyOf("rate", this.rate);
        builder.tips = this.tips;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Emi)) {
            return false;
        }
        Emi emi = (Emi) obj;
        return Internal.equals(unknownFields(), emi.unknownFields()) && Internal.equals(this.min, emi.min) && Internal.equals(this.key, emi.key) && Internal.equals(this.name, emi.name) && Internal.equals(this.enable, emi.enable) && Internal.equals(this.img, emi.img) && Internal.equals(this.rate, emi.rate) && Internal.equals(this.tips, emi.tips);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.min;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.key;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.enable;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.img;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<EmiRate> list = this.rate;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        String str4 = this.tips;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.min != null) {
            sb.append(", min=");
            sb.append(this.min);
        }
        if (this.key != null) {
            sb.append(", key=");
            sb.append(this.key);
        }
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.enable != null) {
            sb.append(", enable=");
            sb.append(this.enable);
        }
        if (this.img != null) {
            sb.append(", img=");
            sb.append(this.img);
        }
        if (this.rate != null) {
            sb.append(", rate=");
            sb.append(this.rate);
        }
        if (this.tips != null) {
            sb.append(", tips=");
            sb.append(this.tips);
        }
        StringBuilder replace = sb.replace(0, 2, "Emi{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Emi, Builder> {
        public Boolean enable;
        public String img;
        public String key;
        public Integer min;
        public String name;
        public List<EmiRate> rate = Internal.newMutableList();
        public String tips;

        public final Builder min(Integer num) {
            this.min = num;
            return this;
        }

        public final Builder key(String str) {
            this.key = str;
            return this;
        }

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final Builder enable(Boolean bool) {
            this.enable = bool;
            return this;
        }

        public final Builder img(String str) {
            this.img = str;
            return this;
        }

        public final Builder rate(List<EmiRate> list) {
            Internal.checkElementsNotNull(list);
            this.rate = list;
            return this;
        }

        public final Builder tips(String str) {
            this.tips = str;
            return this;
        }

        public final Emi build() {
            return new Emi(this.min, this.key, this.name, this.enable, this.img, this.rate, this.tips, buildUnknownFields());
        }
    }

    public static final class EmiRate extends Message<EmiRate, Builder> {
        public static final ProtoAdapter<EmiRate> ADAPTER = new ProtoAdapter_EmiRate();
        public static final Float DEFAULT_INTEREST = Float.valueOf(0.0f);
        public static final Integer DEFAULT_MONTHS = 0;
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
        public final String code;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        public final String desc;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float interest;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
        public final String interest_desc;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
        public final String monthPay;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
        public final Integer months;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
        public final String tips;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
        public final String totalInterest;

        public EmiRate(String str, Float f, String str2, Integer num, String str3, String str4, String str5, String str6) {
            this(str, f, str2, num, str3, str4, str5, str6, ByteString.O00000Oo);
        }

        public EmiRate(String str, Float f, String str2, Integer num, String str3, String str4, String str5, String str6, ByteString byteString) {
            super(ADAPTER, byteString);
            this.desc = str;
            this.interest = f;
            this.code = str2;
            this.months = num;
            this.totalInterest = str3;
            this.monthPay = str4;
            this.tips = str5;
            this.interest_desc = str6;
        }

        public final Builder newBuilder() {
            Builder builder = new Builder();
            builder.desc = this.desc;
            builder.interest = this.interest;
            builder.code = this.code;
            builder.months = this.months;
            builder.totalInterest = this.totalInterest;
            builder.monthPay = this.monthPay;
            builder.tips = this.tips;
            builder.interest_desc = this.interest_desc;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EmiRate)) {
                return false;
            }
            EmiRate emiRate = (EmiRate) obj;
            return Internal.equals(unknownFields(), emiRate.unknownFields()) && Internal.equals(this.desc, emiRate.desc) && Internal.equals(this.interest, emiRate.interest) && Internal.equals(this.code, emiRate.code) && Internal.equals(this.months, emiRate.months) && Internal.equals(this.totalInterest, emiRate.totalInterest) && Internal.equals(this.monthPay, emiRate.monthPay) && Internal.equals(this.tips, emiRate.tips) && Internal.equals(this.interest_desc, emiRate.interest_desc);
        }

        public final int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.desc;
            int i2 = 0;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            Float f = this.interest;
            int hashCode3 = (hashCode2 + (f != null ? f.hashCode() : 0)) * 37;
            String str2 = this.code;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
            Integer num = this.months;
            int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
            String str3 = this.totalInterest;
            int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.monthPay;
            int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.tips;
            int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.interest_desc;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            int i3 = hashCode8 + i2;
            this.hashCode = i3;
            return i3;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.desc != null) {
                sb.append(", desc=");
                sb.append(this.desc);
            }
            if (this.interest != null) {
                sb.append(", interest=");
                sb.append(this.interest);
            }
            if (this.code != null) {
                sb.append(", code=");
                sb.append(this.code);
            }
            if (this.months != null) {
                sb.append(", months=");
                sb.append(this.months);
            }
            if (this.totalInterest != null) {
                sb.append(", totalInterest=");
                sb.append(this.totalInterest);
            }
            if (this.monthPay != null) {
                sb.append(", monthPay=");
                sb.append(this.monthPay);
            }
            if (this.tips != null) {
                sb.append(", tips=");
                sb.append(this.tips);
            }
            if (this.interest_desc != null) {
                sb.append(", interest_desc=");
                sb.append(this.interest_desc);
            }
            StringBuilder replace = sb.replace(0, 2, "EmiRate{");
            replace.append('}');
            return replace.toString();
        }

        public static final class Builder extends Message.Builder<EmiRate, Builder> {
            public String code;
            public String desc;
            public Float interest;
            public String interest_desc;
            public String monthPay;
            public Integer months;
            public String tips;
            public String totalInterest;

            public final Builder desc(String str) {
                this.desc = str;
                return this;
            }

            public final Builder interest(Float f) {
                this.interest = f;
                return this;
            }

            public final Builder code(String str) {
                this.code = str;
                return this;
            }

            public final Builder months(Integer num) {
                this.months = num;
                return this;
            }

            public final Builder totalInterest(String str) {
                this.totalInterest = str;
                return this;
            }

            public final Builder monthPay(String str) {
                this.monthPay = str;
                return this;
            }

            public final Builder tips(String str) {
                this.tips = str;
                return this;
            }

            public final Builder interest_desc(String str) {
                this.interest_desc = str;
                return this;
            }

            public final EmiRate build() {
                return new EmiRate(this.desc, this.interest, this.code, this.months, this.totalInterest, this.monthPay, this.tips, this.interest_desc, buildUnknownFields());
            }
        }

        static final class ProtoAdapter_EmiRate extends ProtoAdapter<EmiRate> {
            ProtoAdapter_EmiRate() {
                super(FieldEncoding.LENGTH_DELIMITED, EmiRate.class);
            }

            public final int encodedSize(EmiRate emiRate) {
                int i = 0;
                int encodedSizeWithTag = (emiRate.desc != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, emiRate.desc) : 0) + (emiRate.interest != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, emiRate.interest) : 0) + (emiRate.code != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, emiRate.code) : 0) + (emiRate.months != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, emiRate.months) : 0) + (emiRate.totalInterest != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, emiRate.totalInterest) : 0) + (emiRate.monthPay != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, emiRate.monthPay) : 0) + (emiRate.tips != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, emiRate.tips) : 0);
                if (emiRate.interest_desc != null) {
                    i = ProtoAdapter.STRING.encodedSizeWithTag(8, emiRate.interest_desc);
                }
                return encodedSizeWithTag + i + emiRate.unknownFields().O0000OOo();
            }

            public final void encode(ProtoWriter protoWriter, EmiRate emiRate) throws IOException {
                if (emiRate.desc != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, emiRate.desc);
                }
                if (emiRate.interest != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, emiRate.interest);
                }
                if (emiRate.code != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, emiRate.code);
                }
                if (emiRate.months != null) {
                    ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, emiRate.months);
                }
                if (emiRate.totalInterest != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, emiRate.totalInterest);
                }
                if (emiRate.monthPay != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, emiRate.monthPay);
                }
                if (emiRate.tips != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, emiRate.tips);
                }
                if (emiRate.interest_desc != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, emiRate.interest_desc);
                }
                protoWriter.writeBytes(emiRate.unknownFields());
            }

            public final EmiRate decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                builder.desc(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 2:
                                builder.interest(ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 3:
                                builder.code(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 4:
                                builder.months(ProtoAdapter.INT32.decode(protoReader));
                                break;
                            case 5:
                                builder.totalInterest(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 6:
                                builder.monthPay(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 7:
                                builder.tips(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                builder.interest_desc(ProtoAdapter.STRING.decode(protoReader));
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

            public final EmiRate redact(EmiRate emiRate) {
                Builder newBuilder = emiRate.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }
    }

    static final class ProtoAdapter_Emi extends ProtoAdapter<Emi> {
        ProtoAdapter_Emi() {
            super(FieldEncoding.LENGTH_DELIMITED, Emi.class);
        }

        public final int encodedSize(Emi emi) {
            int i = 0;
            int encodedSizeWithTag = (emi.min != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, emi.min) : 0) + (emi.key != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, emi.key) : 0) + (emi.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, emi.name) : 0) + (emi.enable != null ? ProtoAdapter.BOOL.encodedSizeWithTag(4, emi.enable) : 0) + (emi.img != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, emi.img) : 0) + EmiRate.ADAPTER.asRepeated().encodedSizeWithTag(6, emi.rate);
            if (emi.tips != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(7, emi.tips);
            }
            return encodedSizeWithTag + i + emi.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Emi emi) throws IOException {
            if (emi.min != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, emi.min);
            }
            if (emi.key != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, emi.key);
            }
            if (emi.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, emi.name);
            }
            if (emi.enable != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, emi.enable);
            }
            if (emi.img != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, emi.img);
            }
            if (emi.rate != null) {
                EmiRate.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, emi.rate);
            }
            if (emi.tips != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, emi.tips);
            }
            protoWriter.writeBytes(emi.unknownFields());
        }

        public final Emi decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.min(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 2:
                            builder.key(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.enable(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 5:
                            builder.img(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.rate.add(EmiRate.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            builder.tips(ProtoAdapter.STRING.decode(protoReader));
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

        public final Emi redact(Emi emi) {
            Builder newBuilder = emi.newBuilder();
            Internal.redactElements(newBuilder.rate, EmiRate.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
