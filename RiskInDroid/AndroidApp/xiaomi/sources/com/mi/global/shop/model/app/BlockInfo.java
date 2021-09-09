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

public final class BlockInfo extends Message<BlockInfo, Builder> {
    public static final ProtoAdapter<BlockInfo> ADAPTER = new ProtoAdapter_BlockInfo();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.app.Desc#ADAPTER", tag = 2)
    public final Desc desc;
    @WireField(adapter = "com.mi.global.shop.model.app.Items#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Items> items;

    public BlockInfo(List<Items> list, Desc desc2) {
        this(list, desc2, ByteString.O00000Oo);
    }

    public BlockInfo(List<Items> list, Desc desc2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.items = Internal.immutableCopyOf("items", list);
        this.desc = desc2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.items = Internal.copyOf("items", this.items);
        builder.desc = this.desc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlockInfo)) {
            return false;
        }
        BlockInfo blockInfo = (BlockInfo) obj;
        return Internal.equals(unknownFields(), blockInfo.unknownFields()) && Internal.equals(this.items, blockInfo.items) && Internal.equals(this.desc, blockInfo.desc);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        List<Items> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Desc desc2 = this.desc;
        int hashCode3 = hashCode2 + (desc2 != null ? desc2.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.items != null) {
            sb.append(", items=");
            sb.append(this.items);
        }
        if (this.desc != null) {
            sb.append(", desc=");
            sb.append(this.desc);
        }
        StringBuilder replace = sb.replace(0, 2, "BlockInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BlockInfo, Builder> {
        public Desc desc;
        public List<Items> items = Internal.newMutableList();

        public final Builder items(List<Items> list) {
            Internal.checkElementsNotNull(list);
            this.items = list;
            return this;
        }

        public final Builder desc(Desc desc2) {
            this.desc = desc2;
            return this;
        }

        public final BlockInfo build() {
            return new BlockInfo(this.items, this.desc, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_BlockInfo extends ProtoAdapter<BlockInfo> {
        ProtoAdapter_BlockInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, BlockInfo.class);
        }

        public final int encodedSize(BlockInfo blockInfo) {
            return Items.ADAPTER.asRepeated().encodedSizeWithTag(1, blockInfo.items) + (blockInfo.desc != null ? Desc.ADAPTER.encodedSizeWithTag(2, blockInfo.desc) : 0) + blockInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, BlockInfo blockInfo) throws IOException {
            if (blockInfo.items != null) {
                Items.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, blockInfo.items);
            }
            if (blockInfo.desc != null) {
                Desc.ADAPTER.encodeWithTag(protoWriter, 2, blockInfo.desc);
            }
            protoWriter.writeBytes(blockInfo.unknownFields());
        }

        public final BlockInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.items.add(Items.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.desc(Desc.ADAPTER.decode(protoReader));
                }
            }
        }

        public final BlockInfo redact(BlockInfo blockInfo) {
            Builder newBuilder = blockInfo.newBuilder();
            Internal.redactElements(newBuilder.items, Items.ADAPTER);
            if (newBuilder.desc != null) {
                newBuilder.desc = Desc.ADAPTER.redact(newBuilder.desc);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
