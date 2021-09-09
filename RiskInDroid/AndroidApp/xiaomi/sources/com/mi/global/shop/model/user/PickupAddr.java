package com.mi.global.shop.model.user;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class PickupAddr extends Message<PickupAddr, Builder> {
    public static final ProtoAdapter<PickupAddr> ADAPTER = new ProtoAdapter_PickupAddr();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String Sat;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String SundayToHoliday;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String code;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String workday;

    public PickupAddr(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, ByteString.O00000Oo);
    }

    public PickupAddr(String str, String str2, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.code = str;
        this.workday = str2;
        this.Sat = str3;
        this.SundayToHoliday = str4;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.code = this.code;
        builder.workday = this.workday;
        builder.Sat = this.Sat;
        builder.SundayToHoliday = this.SundayToHoliday;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PickupAddr)) {
            return false;
        }
        PickupAddr pickupAddr = (PickupAddr) obj;
        return Internal.equals(unknownFields(), pickupAddr.unknownFields()) && Internal.equals(this.code, pickupAddr.code) && Internal.equals(this.workday, pickupAddr.workday) && Internal.equals(this.Sat, pickupAddr.Sat) && Internal.equals(this.SundayToHoliday, pickupAddr.SundayToHoliday);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.code;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.workday;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.Sat;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.SundayToHoliday;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.code != null) {
            sb.append(", code=");
            sb.append(this.code);
        }
        if (this.workday != null) {
            sb.append(", workday=");
            sb.append(this.workday);
        }
        if (this.Sat != null) {
            sb.append(", Sat=");
            sb.append(this.Sat);
        }
        if (this.SundayToHoliday != null) {
            sb.append(", SundayToHoliday=");
            sb.append(this.SundayToHoliday);
        }
        StringBuilder replace = sb.replace(0, 2, "PickupAddr{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PickupAddr, Builder> {
        public String Sat;
        public String SundayToHoliday;
        public String code;
        public String workday;

        public final Builder code(String str) {
            this.code = str;
            return this;
        }

        public final Builder workday(String str) {
            this.workday = str;
            return this;
        }

        public final Builder Sat(String str) {
            this.Sat = str;
            return this;
        }

        public final Builder SundayToHoliday(String str) {
            this.SundayToHoliday = str;
            return this;
        }

        public final PickupAddr build() {
            return new PickupAddr(this.code, this.workday, this.Sat, this.SundayToHoliday, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PickupAddr extends ProtoAdapter<PickupAddr> {
        ProtoAdapter_PickupAddr() {
            super(FieldEncoding.LENGTH_DELIMITED, PickupAddr.class);
        }

        public final int encodedSize(PickupAddr pickupAddr) {
            int i = 0;
            int encodedSizeWithTag = (pickupAddr.code != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, pickupAddr.code) : 0) + (pickupAddr.workday != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, pickupAddr.workday) : 0) + (pickupAddr.Sat != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, pickupAddr.Sat) : 0);
            if (pickupAddr.SundayToHoliday != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, pickupAddr.SundayToHoliday);
            }
            return encodedSizeWithTag + i + pickupAddr.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PickupAddr pickupAddr) throws IOException {
            if (pickupAddr.code != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, pickupAddr.code);
            }
            if (pickupAddr.workday != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, pickupAddr.workday);
            }
            if (pickupAddr.Sat != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, pickupAddr.Sat);
            }
            if (pickupAddr.SundayToHoliday != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, pickupAddr.SundayToHoliday);
            }
            protoWriter.writeBytes(pickupAddr.unknownFields());
        }

        public final PickupAddr decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.code(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.workday(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.Sat(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.SundayToHoliday(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final PickupAddr redact(PickupAddr pickupAddr) {
            Builder newBuilder = pickupAddr.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
