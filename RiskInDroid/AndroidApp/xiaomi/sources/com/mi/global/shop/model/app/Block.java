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

public final class Block extends Message<Block, Builder> {
    public static final ProtoAdapter<Block> ADAPTER = new ProtoAdapter_Block();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.app.BlockData#ADAPTER", tag = 3)
    public final BlockData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public Block(Integer num, String str, BlockData blockData) {
        this(num, str, blockData, ByteString.O00000Oo);
    }

    public Block(Integer num, String str, BlockData blockData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = blockData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errno = this.errno;
        builder.errmsg = this.errmsg;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Block)) {
            return false;
        }
        Block block = (Block) obj;
        return Internal.equals(unknownFields(), block.unknownFields()) && Internal.equals(this.errno, block.errno) && Internal.equals(this.errmsg, block.errmsg) && Internal.equals(this.data, block.data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.errmsg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        BlockData blockData = this.data;
        if (blockData != null) {
            i2 = blockData.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.errno != null) {
            sb.append(", errno=");
            sb.append(this.errno);
        }
        if (this.errmsg != null) {
            sb.append(", errmsg=");
            sb.append(this.errmsg);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "Block{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Block, Builder> {
        public BlockData data;
        public String errmsg;
        public Integer errno;

        public final Builder errno(Integer num) {
            this.errno = num;
            return this;
        }

        public final Builder errmsg(String str) {
            this.errmsg = str;
            return this;
        }

        public final Builder data(BlockData blockData) {
            this.data = blockData;
            return this;
        }

        public final Block build() {
            return new Block(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Block extends ProtoAdapter<Block> {
        ProtoAdapter_Block() {
            super(FieldEncoding.LENGTH_DELIMITED, Block.class);
        }

        public final int encodedSize(Block block) {
            int i = 0;
            int encodedSizeWithTag = (block.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, block.errno) : 0) + (block.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, block.errmsg) : 0);
            if (block.data != null) {
                i = BlockData.ADAPTER.encodedSizeWithTag(3, block.data);
            }
            return encodedSizeWithTag + i + block.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Block block) throws IOException {
            if (block.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, block.errno);
            }
            if (block.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, block.errmsg);
            }
            if (block.data != null) {
                BlockData.ADAPTER.encodeWithTag(protoWriter, 3, block.data);
            }
            protoWriter.writeBytes(block.unknownFields());
        }

        public final Block decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(BlockData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final Block redact(Block block) {
            Builder newBuilder = block.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = BlockData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
