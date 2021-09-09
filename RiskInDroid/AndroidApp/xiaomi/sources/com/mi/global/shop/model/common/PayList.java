package com.mi.global.shop.model.common;

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

public final class PayList extends Message<PayList, Builder> {
    public static final ProtoAdapter<PayList> ADAPTER = new ProtoAdapter_PayList();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> cards;
    @WireField(adapter = "com.mi.global.shop.model.common.Emi#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Emi> emi;
    @WireField(adapter = "com.mi.global.shop.model.common.Netbank#ADAPTER", tag = 3)
    public final Netbank netbank;
    @WireField(adapter = "com.mi.global.shop.model.common.Wallet#ADAPTER", tag = 4)
    public final Wallet wallet;

    public PayList(List<Emi> list, List<String> list2, Netbank netbank2, Wallet wallet2) {
        this(list, list2, netbank2, wallet2, ByteString.O00000Oo);
    }

    public PayList(List<Emi> list, List<String> list2, Netbank netbank2, Wallet wallet2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.emi = Internal.immutableCopyOf("emi", list);
        this.cards = Internal.immutableCopyOf("cards", list2);
        this.netbank = netbank2;
        this.wallet = wallet2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.emi = Internal.copyOf("emi", this.emi);
        builder.cards = Internal.copyOf("cards", this.cards);
        builder.netbank = this.netbank;
        builder.wallet = this.wallet;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayList)) {
            return false;
        }
        PayList payList = (PayList) obj;
        return Internal.equals(unknownFields(), payList.unknownFields()) && Internal.equals(this.emi, payList.emi) && Internal.equals(this.cards, payList.cards) && Internal.equals(this.netbank, payList.netbank) && Internal.equals(this.wallet, payList.wallet);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        List<Emi> list = this.emi;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<String> list2 = this.cards;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        Netbank netbank2 = this.netbank;
        int i4 = 0;
        int hashCode3 = (i3 + (netbank2 != null ? netbank2.hashCode() : 0)) * 37;
        Wallet wallet2 = this.wallet;
        if (wallet2 != null) {
            i4 = wallet2.hashCode();
        }
        int i5 = hashCode3 + i4;
        this.hashCode = i5;
        return i5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.emi != null) {
            sb.append(", emi=");
            sb.append(this.emi);
        }
        if (this.cards != null) {
            sb.append(", cards=");
            sb.append(this.cards);
        }
        if (this.netbank != null) {
            sb.append(", netbank=");
            sb.append(this.netbank);
        }
        if (this.wallet != null) {
            sb.append(", wallet=");
            sb.append(this.wallet);
        }
        StringBuilder replace = sb.replace(0, 2, "PayList{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PayList, Builder> {
        public List<String> cards = Internal.newMutableList();
        public List<Emi> emi = Internal.newMutableList();
        public Netbank netbank;
        public Wallet wallet;

        public final Builder emi(List<Emi> list) {
            Internal.checkElementsNotNull(list);
            this.emi = list;
            return this;
        }

        public final Builder cards(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.cards = list;
            return this;
        }

        public final Builder netbank(Netbank netbank2) {
            this.netbank = netbank2;
            return this;
        }

        public final Builder wallet(Wallet wallet2) {
            this.wallet = wallet2;
            return this;
        }

        public final PayList build() {
            return new PayList(this.emi, this.cards, this.netbank, this.wallet, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PayList extends ProtoAdapter<PayList> {
        ProtoAdapter_PayList() {
            super(FieldEncoding.LENGTH_DELIMITED, PayList.class);
        }

        public final int encodedSize(PayList payList) {
            int i = 0;
            int encodedSizeWithTag = Emi.ADAPTER.asRepeated().encodedSizeWithTag(1, payList.emi) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, payList.cards) + (payList.netbank != null ? Netbank.ADAPTER.encodedSizeWithTag(3, payList.netbank) : 0);
            if (payList.wallet != null) {
                i = Wallet.ADAPTER.encodedSizeWithTag(4, payList.wallet);
            }
            return encodedSizeWithTag + i + payList.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PayList payList) throws IOException {
            if (payList.emi != null) {
                Emi.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, payList.emi);
            }
            if (payList.cards != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, payList.cards);
            }
            if (payList.netbank != null) {
                Netbank.ADAPTER.encodeWithTag(protoWriter, 3, payList.netbank);
            }
            if (payList.wallet != null) {
                Wallet.ADAPTER.encodeWithTag(protoWriter, 4, payList.wallet);
            }
            protoWriter.writeBytes(payList.unknownFields());
        }

        public final PayList decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.emi.add(Emi.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.cards.add(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.netbank(Netbank.ADAPTER.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.wallet(Wallet.ADAPTER.decode(protoReader));
                }
            }
        }

        public final PayList redact(PayList payList) {
            Builder newBuilder = payList.newBuilder();
            Internal.redactElements(newBuilder.emi, Emi.ADAPTER);
            if (newBuilder.netbank != null) {
                newBuilder.netbank = Netbank.ADAPTER.redact(newBuilder.netbank);
            }
            if (newBuilder.wallet != null) {
                newBuilder.wallet = Wallet.ADAPTER.redact(newBuilder.wallet);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
